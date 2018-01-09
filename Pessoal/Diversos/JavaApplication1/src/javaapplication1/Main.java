/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileWriter; 
import java.io.IOException; 
import java.io.UnsupportedEncodingException; 
import java.util.ArrayList; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import json.JsonLoginResponse; 
import json.JsonRpc; 
import json.JsonSMD; 
import org.apache.http.client.ClientProtocolException; 
import org.apache.http.client.methods.HttpPost; 
import org.apache.http.impl.client.DefaultHttpClient; 
import org.codehaus.jackson.JsonFactory; 

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        String username = "";
        String password = "";
        String url = "";
        if (args.length < 3) {
            System.out.println("Usage: java -jar Expresso3Client.jar username password url");
            System.exit(1);
        } else {
            username = args[0];
            password = args[1];
            url = args[2];
        }
        try {
            // Instancia o HttpClient 
            DefaultHttpClient client = new DefaultHttpClient();
            // Instancia a classe que monta request serializado em Json 
            JsonRpc jsonrpc = new JsonRpc();
            // Configura um Post request 
            System.out.print("SMDRequest: ");
            // Expresso3 always use the index.php as controller 
            HttpPost post = new HttpPost(url);
            // Instancia o conteúdo do post como uma StringEntity 
            StringEntity entity = new StringEntity(jsonrpc.generateSmdRequest(), "UTF-8");
            entity.writeTo(System.out);
            System.out.println();
            // Adiciona o conteúdo ao Post 
            post.setEntity(entity);
            // Define o header ContentType como "application/json; charset=UTF-8" 
            post.setHeader("Content-Type", "application/json; charset=UTF-8");
 //
            //
            // Executa o Post e obtém a resposta 
            // Cuidado!!! O contentType desta resposta é text/html ao invés de application/json 
            // embora o conteúdo seja serializado em Json. 
            // Alguns frameworks testam este valor para carregar o parser apropriado 
            // para tratar o conteúdo e podem lançar uma exceção. 
            HttpResponse response = client.execute(post);
            ObjectMapper mapper = new ObjectMapper(new JsonFactory());
            // Mapeia o conteúdo da resposta como um objeto da classe JsonSMD 
            JsonSMD smdResponse = mapper.readValue(response.getEntity().getContent(), JsonSMD.class);
            smdResponse.writeContent(new FileWriter("/tmp/smdNotLogged.txt"));
            // Logando no Expresso3 
            System.out.println("Login request: ");
            // Adiciona os parâmetros da chamada ao método Tinebase.login 
            jsonrpc.addParam("username", username);
            jsonrpc.addParam("password", password);
            // Instancia o conteúdo do Post como uma StringEntity 
            entity = new StringEntity(jsonrpc.generateRequest("Tinebase.login"), "UTF-8");
            System.out.print("LoginRequest: ");
            entity.writeTo(System.out);
            System.out.println();
// define a entidade no Post 
            post.setEntity(entity);
// Executa o Post e pega a resposta 
            response = client.execute(post);
// Mapeia o conteúdo da resposta para um objeto da classe JsonLoginResponse 
            JsonLoginResponse loginResponse
                    = mapper.readValue(response.getEntity().getContent(),
                            JsonLoginResponse.class);
// Testa se login obteve sucesso 
            if (loginResponse.getResult().getSuccess()) {
                System.out.println("Expressomail.getRegistryData após login: ");
// Recupera a jsonKey, chave que controla a sessão no servidor 
                String jsonKey = loginResponse.getResult().getJsonKey();
                jsonrpc.clearParams();
                entity = new StringEntity(jsonrpc.generateRequest("Expressomail.getRegistryData"), "UTF-8");
                System.out.print("Expressomail.getRegistryData Request: ");
                entity.writeTo(System.out);
                System.out.println();
                post.setEntity(entity);
// Define o header HTTP X-Tine20-jsonKey cujo valor deve ser o da chave 
// jsonKey, para que o Expresso3 saiba que já estamos em uma sessão logada. 
                post.addHeader("X-Tine20-jsonKey", jsonKey);
                response = client.execute(post);
//
//
// Mapeando resultado para um Map<String, Object> 
// E recuperando o valor filter 
                Map<String, Object> ExpressomailGetRegistryDataResponse
                        = mapper.readValue(response.getEntity().getContent(), Map.class);
                LinkedHashMap<String, Object> result = (LinkedHashMap<String, Object>) ExpressomailGetRegistryDataResponse.get("result");
                LinkedHashMap<String, Object> accounts = (LinkedHashMap<String, Object>) result.get("accounts");
                ArrayList filter = (ArrayList) accounts.get("filter");
// Adiciona regra ao filtro para buscar folders que possuam o campo 
// globalname = "", isto retornará o folder / e o folder INBOX 
                LinkedHashMap<String, Object> otherFilter = new LinkedHashMap();
                otherFilter.put("field", "globalname");
                otherFilter.put("operator", "equals");
                otherFilter.put("value", "");
                ArrayList searchFilter = (ArrayList) filter.clone();
                searchFilter.add(otherFilter);
// Executa o a chamada à Expressomail.searchFolders passando o parâmetro 
// filter (ArrayList) 
                jsonrpc.addParam("filter", searchFilter);
                entity = new StringEntity(jsonrpc.generateRequest("Expressomail.searchFolders"), "UTF-8");
                System.out.println("Expressomail.searchFolders Request:"
                        + jsonrpc.generateRequest("Expressomail.searchFolders"));
                post.setEntity(entity);
                response = client.execute(post);
// Recupera Id do folder INDEX e caminho passando 
                Map<String, Object> ExpressomailSearchFoldersResponse
                        = mapper.readValue(response.getEntity().getContent(), Map.class);
                result = (LinkedHashMap<String, Object>) ExpressomailSearchFoldersResponse.get("result");
                ArrayList results = (ArrayList) result.get("results");
                for (Object folder : results) {
                    String globalname = (String) ((LinkedHashMap<String, Object>) folder).get("globalname");
                    if (globalname != null && globalname.equalsIgnoreCase("INBOX")) {
                        System.out.println("Folder " + globalname + " path: ");
                    }
                }
                String path = "/";
                path += (String) ((LinkedHashMap<String, Object>) results.get(1)).get("id");
                path += "/";
                path += (String) ((LinkedHashMap<String, Object>) results.get(0)).get("id");
                System.out.println(path);
            } else {
                Logger.getLogger(Main.class.getName()).log(Level.INFO,
                        loginResponse.getResult().getErrorMessage());
            }
        } catch (ClientProtocolException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
