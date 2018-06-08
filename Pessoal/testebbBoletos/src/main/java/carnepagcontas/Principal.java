/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnepagcontas;

import java.util.Base64;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

/**
 *
 * @author Juniel
 */
public class Principal {

    public static final String TOKEN_REQUEST_URL = "https://oauth.hm.bb.com.br/oauth/token";
    public static final String CLIENT_SECRET = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";
    public static final String CLIENT_ID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";

    public static void main(String[] args) throws Exception {

        OAuthClientRequest request = OAuthClientRequest.tokenLocation(TOKEN_REQUEST_URL)
                .setGrantType(GrantType.CLIENT_CREDENTIALS)
                .setClientId(CLIENT_ID)
                .setClientSecret(CLIENT_SECRET)
                .setScope("cobranca.registro-boletos")
                .buildBodyMessage();

        String auth = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader("Authorization", authHeader);

        //create OAuth client that uses custom http client under the hood
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

        OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request);

        String accessToken = oAuthResponse.getAccessToken();
        Long expiresIn = oAuthResponse.getExpiresIn();

        System.out.println(accessToken);
        System.out.println(expiresIn);
        System.out.println(oAuthResponse.getResponseCode());

        if (oAuthResponse.getResponseCode() == 200) {
            System.out.println("Deu certo");
        } else {
            System.out.println("Deu merda");
        }
    }

}
