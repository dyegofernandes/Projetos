/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnepagcontas;

import javax.servlet.http.HttpServletRequest;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

/**
 *
 * @author Juniel
 */
public class Principal {
    public static void main(String[] args) throws OAuthSystemException, OAuthProblemException{
        HttpServletRequest request = new HttpServletRequestt();
        OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
    }
    
}
