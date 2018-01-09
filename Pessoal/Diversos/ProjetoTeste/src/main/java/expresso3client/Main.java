/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresso3client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import json.JsonLoginResponse;
import json.JsonRpc;
import json.JsonSMD;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author "Mário César Kolling" <mario.kolling@serpro.gov.br>
 */
public class Main {

    static String ldapURL = "ldap://ldap.pi.gov.br:389";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String username = "juniel.alves@ati.pi.gov.br";

        String password = "SistemaRemanso84";

        String base = "ou=ati,ou=Usuarios,dc=pi,dc=gov,dc=br";

        String dn = "uid=" + username + "," + base;

// Setup environment for authenticating
        Hashtable<String, String> environment = new Hashtable<String, String>();

        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        environment.put(Context.PROVIDER_URL, ldapURL);

        environment.put(Context.SECURITY_AUTHENTICATION, "simple");

        environment.put(Context.SECURITY_PRINCIPAL, dn); //dn

        environment.put(Context.SECURITY_CREDENTIALS, password);
        

        try {

            DirContext authContext = new InitialDirContext(environment);
            System.out.println("Autenticado");
// user is authenticated
        } catch (AuthenticationException ex) {
            System.out.println("Não Autenticado");
            ex.printStackTrace();
// Authentication failed
        } catch (NamingException ex) {
            System.out.println("Erro");
            ex.printStackTrace();

        }

    }

    public static boolean authenticateJndi(String username, String password) throws Exception {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, ldapURL);
//        props.put(Context.SECURITY_PRINCIPAL, "ou=ati,ou=Usuarios,dc=pi,dc=gov,dc=br");//adminuser - User with special priviledge, dn user
//        props.put(Context.SECURITY_CREDENTIALS, "adminpassword");//dn user password

        InitialDirContext context = new InitialDirContext(props);

        SearchControls ctrls = new SearchControls();
        ctrls.setReturningAttributes(new String[]{"givenName", "sn", "memberOf"});
        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<javax.naming.directory.SearchResult> answers = context.search("pi.gov.br", "(uid=" + username + ")", ctrls);
        javax.naming.directory.SearchResult result = answers.nextElement();

        String user = result.getNameInNamespace();

        try {
            props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            props.put(Context.PROVIDER_URL, ldapURL);
            props.put(Context.SECURITY_PRINCIPAL, user);
            props.put(Context.SECURITY_CREDENTIALS, password);

            context = new InitialDirContext(props);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
