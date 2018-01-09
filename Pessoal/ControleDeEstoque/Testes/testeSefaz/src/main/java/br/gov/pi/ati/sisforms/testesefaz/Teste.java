/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.testesefaz;

import javax.naming.CommunicationException;
import javax.naming.NamingException;

/**
 *
 * @author KillerBeeTwo
 */
public class Teste {

    public static void main(String[] args) throws CommunicationException, NamingException {

        String login = "juniel.alves@ati.pi.gov.br";

        System.out.println(gerarDomain(login));
    }

    public static String gerarDomain(String login) {
        //"uid=juniel.silva,ou=ati,ou=usuarios,dc=pi,dc=gov,dc=br"
        String domainLDap = "uid=USUARIO_LDAP,ou=ORGAO,ou=usuarios,dc=pi,dc=gov,dc=br";
        String[] loginPartes = new String[2];
        loginPartes = login.split("@");
        String usuario = loginPartes[0];

        String domain = loginPartes[1].toString();
        
        String[] domainPedacos = new String[4];
        domainPedacos = domain.split("\\.");
        String orgao = domainPedacos[0];

        domainLDap = domainLDap.replace("USUARIO_LDAP", usuario).replace("ORGAO", orgao);

        return domainLDap;
    }

}
