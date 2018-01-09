/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

/**
 * Classe que constrói requests no formato Json-RPC 2.0
 * 
* @author "Mário César Kolling" <mario.kolling@serpro.gov.br>
 */
public class JsonRpc {

    public static String VERSION = "2.0";
    private final Random rdm = new Random(Calendar.getInstance().getTimeInMillis());
    private Map<String, Object> params = new HashMap<String, Object>();

    /**
     * Método que contrói um request cuja resposta é um Json-SMD. Um Json-SMD
     * request para o Expresso3 é um request Json onde o método é nulo e params
     * é vazio.
     *     
* @return Request serializado em Json
     */
    public String generateSmdRequest() {
        this.clearParams();
        return generateRequest(null);
    }

    /**
     * Método que monta um request Json-RPC. TODO: Criar método recursivo que
     * gera parâmetros {@code} array, já que podemos ter vários níveis de
     * recursão dentro deste tipo de parâmetros
     *     
* @param method Método a ser executado pelo servidor Expresso3. Ex:
     * Tinebase.login
     * @return Request serializado em Json
     */
    public String generateRequest(String method) {
        int id = Math.abs(rdm.nextInt());
        StringWriter writer = new StringWriter();
        JsonFactory factory = new JsonFactory();
        try {
            JsonGenerator gen = factory.createJsonGenerator(writer);
// Initialize Json 
            gen.writeStartObject();
            gen.writeStringField("jsonrpc", JsonRpc.VERSION);
// Add method param 
            gen.writeStringField("method", method);
// Add params Object 
            gen.writeObjectFieldStart("params");
            for (Iterator<String> i = this.params.keySet().iterator(); i.hasNext();) {
                String param = i.next();
                Object value = this.params.get(param);
                if (value instanceof String) {
                    gen.writeStringField(param, (String) value);
                } else if (value instanceof Boolean) {
                    gen.writeBooleanField(param, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    gen.writeNumberField(param, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    gen.writeNumberField(param, ((Long) value).longValue());
                } else if (value instanceof BigInteger) {
                    gen.writeNumberField(param, ((BigInteger) value).longValue());
                } else if (value instanceof Double) {
                    gen.writeNumberField(param, ((Double) value).doubleValue());
                } else if (value instanceof BigDecimal) {
                    gen.writeNumberField(param, (BigDecimal) value);
                } else if (value instanceof ArrayList) {
                    ArrayList<LinkedHashMap<String, String>> values
                            = (ArrayList<LinkedHashMap<String, String>>) value;
//
// Start array 
                    gen.writeArrayFieldStart(param);
                    for (LinkedHashMap<String, String> arrayValue : values) {
// Start Object 
                        gen.writeStartObject();
                        for (Iterator<String> arrayI = arrayValue.keySet().iterator();
                                arrayI.hasNext();) {
                            String arrayKey = arrayI.next();
                            gen.writeStringField(arrayKey, arrayValue.get(arrayKey));
                        }
// End Object 
                        gen.writeEndObject();
                    }
// End array 
                    gen.writeEndArray();
                }
            }
// Close params Object 
            gen.writeEndObject();
// Add id field 
            gen.writeNumberField("id", id);
// End Json 
            gen.writeEndObject();
            gen.close();
        } catch (IOException ex) {
            Logger.getLogger(JsonRpc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return writer.toString();
    }

    /**
     * Método que limpa os parâmetros que serão usados para montar o request
     *     
*/
    public void clearParams() {
        this.params = new HashMap<String, Object>();
    }

    /**
     * Adiciona um parâmetro ao método que está sendo criado
     *     
* @param param Nome do parâmetro do método
     * @param value Valor do parâmetro
     */
    public void addParam(String param, Object value) {
        this.params.put(param, value);
    }

    /**
     * Adiciona um conjunto ({@code} Map<String, String>) com os parâmetros do
     * método a ser chamado
     *     
* @param params Um mapa com todos os parâmetros
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
