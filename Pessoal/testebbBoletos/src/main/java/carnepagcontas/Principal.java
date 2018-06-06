/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnepagcontas;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import java.util.Base64;

import org.apache.oltu.oauth2.common.OAuth;

/**
 *
 * @author Juniel
 */
public class Principal {

    /**
     * URL for requesting OAuth access tokens.
     * https://oauth.hm.bb.com.br:43000/oauth/token
     * https://oauth.hm.bb.com.br/oauth/token
     */
    public static final String TOKEN_REQUEST_URL = "https://oauth.hm.bb.com.br/oauth/token";

    /**
     * Client ID of your client credential. Change this to match whatever
     * credential you have created.
     */
    public static final String CLIENT_ID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
//            = Base64.getEncoder().withoutPadding().encodeToString("eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ".getBytes());

    /**
     * Client secret of your client credential. Change this to match whatever
     * credential you have created.
     */
    public static final String CLIENT_SECRET = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";
//            = Base64.getEncoder().withoutPadding().encodeToString("eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0".getBytes());

    /**
     * Account on which you want to request a resource. Change this to match the
     * account you want to retrieve resources on.
     */
    public static final String ACCOUNT_ID = "2625444";

    /**
     * URL from which you are going to request a resource. The example below is
     * for the Analytics resource server. :account-id will be replaced with
     * {@link ACCOUNT_ID} below.
     */
    public static final String RESOURCE_URL_TPL
            = "https://cobranca.homologa.bb.com.br/registrarBoleto";

    public static void main(String[] args) throws OAuthSystemException, OAuthProblemException {
//        HttpServletRequest request = new HttpServletRequestt();
//        OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);

        try {
            OAuthClient client = new OAuthClient(new URLConnectionClient());

            OAuthClientRequest request
                    = OAuthClientRequest.tokenLocation(TOKEN_REQUEST_URL)
                    .setGrantType(GrantType.CLIENT_CREDENTIALS)
                    .setUsername(CLIENT_ID)
                    .setPassword(CLIENT_SECRET)
                    .setScope("cobranca.registro-boletos")
                    .buildQueryMessage();

//            request.addHeader("Accept", "application/x-www-form-urlencoded");
//            request.addHeader("Content-Type", "application/x-www-form-urlencoded");
            request.addHeader("Accept", "application/json");
            request.addHeader("Content-Type", "application/json");

            request.addHeader("Cache-Control", "no-cache");
            request.addHeader("Authorization", "Basic");

            String token
                    = client.accessToken(request, OAuth.HttpMethod.POST, OAuthJSONAccessTokenResponse.class)
                    .getAccessToken();

//            String resourceUrl = RESOURCE_URL_TPL.replace(":account-id", ACCOUNT_ID);
//            HttpURLConnection resource_cxn =
//                    (HttpURLConnection)(new URL(resourceUrl).openConnection());
//            resource_cxn.addRequestProperty("Authorization", "Bearer " + token);
//
//            InputStream resource = resource_cxn.getInputStream();
//
//            // Do whatever you want to do with the contents of resource at this point.
//
//            BufferedReader r = new BufferedReader(new InputStreamReader(resource, "UTF-8"));
//            String line = null;
//            while ((line = r.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch (Exception exn) {
            exn.printStackTrace();
        }
    }

    private static String base64EncodedBasicAuthentication() {
        return Base64.getEncoder().withoutPadding().encodeToString(CLIENT_ID.getBytes()).concat(":").concat(Base64.getEncoder().withoutPadding().encodeToString(CLIENT_SECRET.getBytes()));
        //return Base64.getEncoder().withoutPadding().encodeToString(CLIENT_ID.concat(":").concat(CLIENT_SECRET).getBytes());
    }

}
