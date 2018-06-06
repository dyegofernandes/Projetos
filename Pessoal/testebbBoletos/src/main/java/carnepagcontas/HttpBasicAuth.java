/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnepagcontas;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.gson.Gson;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author KillerBeeTwo
 */
public class HttpBasicAuth {

    public static void main(String[] args) throws IOException {
        String requestUrl = "https://oauth.hm.bb.com.br";
        URLConnection connection = new URL(requestUrl).openConnection();
        System.out.println("orignal url: " + connection.getURL());
        connection.connect();
        System.out.println("connected url: " + connection.getURL());
        HttpPost httpPost = new HttpPost(requestUrl);
        String username = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
        String password = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";
        String encoded = DatatypeConverter.printBase64Binary((username + ":" + password).getBytes("UTF-8"));
        
        httpPost.addHeader("AUTHORIZATION", "Basic " + encoded);
        httpPost.addHeader("Content-Type", "application/xml");
        httpPost.addHeader("Cache-Control", "no-cache");
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(httpPost);
        
        System.out.println("Response --> " + response.getStatusLine().toString());
        
        HttpEntity entity = response.getEntity();
        
        String responseString = EntityUtils.toString(entity, "UTF-8");
        
        System.out.println("ResponseString" + responseString);
        
        EntityUtils.consume(entity);
    }
}
