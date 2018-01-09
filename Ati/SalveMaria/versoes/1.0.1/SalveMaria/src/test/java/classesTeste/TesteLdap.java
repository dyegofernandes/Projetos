/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesTeste;

import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author ayslan.sousa
 */
public class TesteLdap {

    /**
     * Used to authenticate a user given a username/password and domain name.
     * Provides an option to identify a specific a Active Directory server.
     *
     * @param username
     * @param password
     * @param domainName
     * @param serverName
     * @return
     * @throws javax.naming.CommunicationException
     * @throws javax.naming.AuthenticationException
     */
    public static LdapContext getConnection(String username, String password, String domainName, String serverName) throws CommunicationException, AuthenticationException {

        if (domainName == null) {
            try {
                String fqdn = java.net.InetAddress.getLocalHost().getCanonicalHostName();
                if (fqdn.split("\\.").length > 1) {
                    domainName = fqdn.substring(fqdn.indexOf(".") + 1);
                }
            } catch (java.net.UnknownHostException e) {
            }
        }

        //System.out.println("Authenticating " + username + "@" + domainName + " through " + serverName);
        if (password != null) {
            password = password.trim();
            if (password.length() == 0) {
                password = null;
            }
        }

        //bind by using the specified username/password
        Hashtable props = new Hashtable();
        //if user is not null
        if (username != null) {
            String principalName;
            //if contains @ then dont concatenate
            if (username.indexOf("@") > 0 || username.contains("uid=")) {
                principalName = username;
            } else {
                principalName = username + "@" + domainName;
            }
            props.put(Context.SECURITY_PRINCIPAL, principalName);
            if (password != null) {
                props.put(Context.SECURITY_CREDENTIALS, password);
            }
        }

        String ldapURL = "ldap://" + ((serverName == null) ? domainName : serverName + "." + domainName) + '/';
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, ldapURL);
        try {
            return new InitialLdapContext(props, null);
        } catch (CommunicationException e) {
            throw new CommunicationException("Failed to connect to " + domainName + ((serverName == null) ? "" : " through " + serverName));
        } catch (AuthenticationException e) {
            throw new AuthenticationException("Failed to authenticate " + username + "@" + domainName + ((serverName == null) ? "" : " through " + serverName));
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
