/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomaventeste;

import com.xpert.security.ActiveDirectory;
import java.util.Properties;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author KillerBeeTwo
 */
public class Main {

    public static void main(String args[]) throws CommunicationException, AuthenticationException, NamingException {
//        System.out.println("Iniciando Teste...");
//        String usuarioZimbra = "uid=juniel.silva,ou=people,dc=ati,dc=pi,dc=gov,dc=br";
//        String urlZimbra = "zldap.pi.gov.br:389";
//
//        String usuarioMail = "uid=juniel.silva,ou=ati,ou=usuarios,dc=pi,dc=gov,dc=br";
//        String urlMail = "ldap.pi.gov.br";
//        try {
//            Properties authEnv = new Properties();
//            authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
//            LdapContext context = ActiveDirectory.getConnection(usuarioZimbra, "SistemaRemanso84", urlZimbra);
//
//            context.close();
//            System.out.println("Autenticado com Sucesso!!");
//
//        } catch (AuthenticationException ex) {
//            System.out.println("Erro de Autenticação!! Usuário não autenticado!!");
//            System.out.println(ex);
//            //erro de autenticacao retornar nulo, pois o usuario nao foi autenticado
//        } catch (CommunicationException ex) {
//            System.out.println("Erro na autenticacao Active Directory");
//            System.out.println("Erro ao se comunicar com o Servidor Active Directory. Entre em contato com o Administrador");
//            System.out.println(ex);
//        } catch (NamingException ex) {
//            System.out.println("Erro na autenticacao Active Directory");
//            System.out.println("Erro ao se comunicar com o Servidor Active Directory. Entre em contato com o Administrador");
//            System.out.println(ex);
//        }

        String num = "201713434";
        System.out.println(num.length());
        System.out.println(num.substring(0, 4));
        System.out.println(num.substring(4, num.length()));
    }

    public static void getConnection(String username, String password, String domainName) throws CommunicationException, AuthenticationException {

        String ldapURL = "ldap://" + domainName;

        Properties props = new Properties();

        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, ldapURL);
        props.put(Context.SECURITY_AUTHENTICATION, "simple");
        props.put(Context.SECURITY_PRINCIPAL, username);
        props.put(Context.SECURITY_CREDENTIALS, password);
        props.put("java.naming.ldap.version", "3");

        try {
            DirContext authContext = new InitialDirContext(props);
            System.out.println("Deu Certo");
        } catch (CommunicationException e) {
            throw new CommunicationException("Failed to connect to " + domainName + " through ");
        } catch (AuthenticationException e) {
            throw new AuthenticationException("Failed to authenticate " + username + "@" + domainName + " through ");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static LdapContext teste(String dominio, String passwordTemp, String ldapURLTemp) throws NamingException {
        Properties authEnv = new Properties();
        authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        authEnv.put(Context.PROVIDER_URL, ldapURLTemp);
        authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        authEnv.put(Context.SECURITY_PRINCIPAL, dominio);
        authEnv.put(Context.SECURITY_CREDENTIALS, passwordTemp);
//        authEnv.put("java.naming.ldap.version", "3");

        try {
            return new InitialLdapContext(authEnv, null);

        } catch (CommunicationException e) {
            throw new CommunicationException("Failed to connect to " + dominio);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("Failed to authenticate " + dominio);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void teste() {
        String userName = "juniel.silva";
        String password = "SistemaRemanso84";
        String base = "ou=people,dc=ati,dc=pi,dc=gov,dc=br";
        String dn = "uid=" + userName + "," + base;

        String ldapURL = "ldap://zldap.pi.gov.br:389";
        Properties authEnv = new Properties();
        authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        authEnv.put(Context.PROVIDER_URL, ldapURL);
        authEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        authEnv.put(Context.SECURITY_PRINCIPAL, dn);
        authEnv.put(Context.SECURITY_CREDENTIALS, password);
//        authEnv.put("java.naming.ldap.version", "3");

        try {
            DirContext authContext = new InitialDirContext(authEnv);
            //return true;
            System.out.println("Deu Certo");

        } catch (NamingException namEx) {
            //return false;
            System.out.println("Deu Merda");
        }
    }
}
