/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author KillerBeeTwo
 */
public class ConnectServiceLDAP {
    private static final String USER   = "ou=ati,ou=usuarios,dc=pi,dc=gov,dc=br";
    private static final String PASSWD = "*******";
    private static final String LDAP_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    private static final String LDAP_SERVIDOR = "ldap://10.0.10.49:389";
    private static final String TYPE_CONNECTION = "simple";
    @SuppressWarnings("UseOfObsoleteCollectionType")
    public static DirContext connect()
    {
        Hashtable authEnv = new Hashtable(11);
        authEnv.put(Context.INITIAL_CONTEXT_FACTORY, LDAP_FACTORY);  
        authEnv.put(Context.PROVIDER_URL, LDAP_SERVIDOR);  
        authEnv.put(Context.SECURITY_AUTHENTICATION, TYPE_CONNECTION);  
        authEnv.put(Context.SECURITY_PRINCIPAL, USER);  
//        authEnv.put(Context.SECURITY_CREDENTIALS, PASSWD);
        try {
            DirContext context = new InitialDirContext(authEnv);
            System.out.println("Autenticado com sucesso no servidor LDAP");
            return context;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
