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
import java.util.Base64;

/**
 *
 * @author KillerBeeTwo
 */
public class HttpBasicAuth {

    public static void main(String[] args) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://oauth.hm.bb.com.br:4300/oauth/token");
        post.getParams().setParameter("client_id", "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ");
        post.getParams().setParameter("client_secret", "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0");
        post.getParams().setParameter("Content-Type", "application/x-www-form-urlencoded");
        post.getParams().setParameter("grant_type", "client_credentials");
        post.getParams().setParameter("scope", "cobranca.registro-boletos");
//        post.getParams().setParameter("redirect_uri", "https://login.salesforce.com/services/oauth2/success");
        HttpResponse response = httpclient.execute(post);
        JSONObject json = (JSONObject) JSONValue.parse(new InputStreamReader(response.getEntity().getContent()));
        System.out.println(json);
    }
}
