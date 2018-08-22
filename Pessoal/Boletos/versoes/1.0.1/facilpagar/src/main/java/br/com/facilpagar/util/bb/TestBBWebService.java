package br.com.facilpagar.util.bb;
import java.util.Base64;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

public class TestBBWebService {

    public static final String CLIENT_SECRET = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";
    public static final String CLIENT_ID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
    
    public static void main( String[] args ) throws Exception {
        
       
        OAuthClientRequest request = OAuthClientRequest.tokenLocation("https://oauth.hm.bb.com.br/oauth/token")
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
        
//        OAuthAuthzResponse oar = OAuthAuthzResponse.oauthCodeAuthzResponse(request);
//        String code = oar.getCode();
    }
    
}