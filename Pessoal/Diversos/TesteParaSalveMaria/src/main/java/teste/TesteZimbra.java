/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import zimbra.AccountBy;
import zimbra.AccountSelector;
import zimbra.com.zimbra.wsdl.zimbraservice.ZcsAdminPortType;
import zimbra.com.zimbra.wsdl.zimbraservice.ZcsAdminService;
import zimbra.zimbraadmin.AuthRequest;
import zimbra.zimbraadmin.CreateAccountRequest;
import zimbra.zimbraadmin.GetAccountInfoRequest;
import zimbra.zimbraadmin.GetAccountRequest;

/**
 *
 * @author KillerBeeTwo
 */
public class TesteZimbra {

    public static void main(String[] args) {
        
        ZcsAdminService service = new ZcsAdminService();
        ZcsAdminPortType email = service.getZcsAdminServicePort();

        AuthRequest autentica = new AuthRequest();
        autentica.setAccount(null);
        
        System.out.println(email.authRequest(autentica));

    }

}
