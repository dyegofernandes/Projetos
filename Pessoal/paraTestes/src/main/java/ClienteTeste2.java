
import com.zimbra.wsdl.zimbraservice.ZcsAdminPortType;
import com.zimbra.wsdl.zimbraservice.ZcsAdminService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import zimbra.AccountBy;
import zimbra.AccountSelector;
import zimbraadmin.AuthRequest;
import zimbraadmin.CreateAccountRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KillerBeeTwo
 */
public class ClienteTeste2 {
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        ZcsAdminService service = new ZcsAdminService();
        ZcsAdminPortType cliente = service.getZcsAdminServicePort();

        AuthRequest auth = new AuthRequest();

        AccountSelector conta = new AccountSelector();
        conta.setBy(AccountBy.ADMIN_NAME);
//        conta.setValue("sisforms@ati.pi.gov.br");
         conta.setValue("teste11@ati.pi.gov.br");
        auth.setAccount(conta);
//        auth.setPassword("Sysf0rms@");
         auth.setPassword("Teste@2017");
        
        String SOAPUrl = "https://webmail.pi.gov.br/";
        // Create the connection where we're going to send the file.
        URL url = new URL(SOAPUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;

        String  postContent = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"+
        "<soap:Header>" +
        "<context xmlns=\"urn:zimbra\">" +
        "<format type=\"js\"/>" +
        "<authToken>" + cliente.authRequest(auth).getAuthToken() + "</authToken>" +
        "</context>" +
        "</soap:Header>" +
        "<soap:Body>" + 
        "<GetFolderRequest xmlns=\"urn:zimbraMail\" />" +
        "</soap:Body>" +
        "</soap:Envelope>";

        // insert your SOAP XML!!!
        byte[] b = postContent.getBytes();

        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty( "Content-Length", String.valueOf( b.length ) );
        httpConn.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
        httpConn.setRequestMethod( "POST" );
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write( b );
        out.close();

        // Read the response and write it to standard out.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        // read & do something with input stream...
        String s = null;
        String response = "";
        while((s=in.readLine()) != null){
            response += s;
        }
        
        System.out.println(response);
        
         CreateAccountRequest emailRequest = new CreateAccountRequest();

        emailRequest.setName("usuario.pela.api@ati.pi.gov.br");
        emailRequest.setPassword("teste11");                

        cliente.createAccountRequest(emailRequest);
        
        in.close();
    }
    
}
