/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchResult;

/**
 *
 * @author KillerBeeTwo
 */
public class AcessLDAP {

    public static final String SEARCHBASE = "ou=People, dc=consisanet, dc=com";

    public static void main(String[] args) {
        DirContext dircontext = ConnectServiceLDAP.connect();
        //tentando buscar dados no servidor LDAP
        String login = "juniel.alves@ati.pi.gov.br";
        String senha = "SistemaRemanso84";
        Attributes attributes = new BasicAttributes(Boolean.FALSE);
        attributes.put(new BasicAttribute("uid", login));
        attributes.put(new BasicAttribute("userPassword", senha));
        String atributosRetorno[] = new String[]{"uid", "userPassword", "givenName", "mail"};
        System.out.println("Buscando.......");
        try {
            NamingEnumeration resultado = dircontext.search(SEARCHBASE, attributes, atributosRetorno);
            while (resultado.hasMore()) {
                SearchResult sr = (SearchResult) resultado.next();
                Attributes atributos = sr.getAttributes();
                NamingEnumeration todosAtributos = atributos.getAll();
                while (todosAtributos.hasMore()) {
                    Attribute attrib = (Attribute) todosAtributos.next();
                    String nomeAtributo = attrib.getID();
                    System.out.println("Atributo:" + nomeAtributo);
                    for (NamingEnumeration e = attrib.getAll(); e.hasMore();) {
                        if (nomeAtributo.equals("userPassword")) {
                            System.out.println("\tvalor:" + new String((byte[]) e.next()));
                        } else {
                            System.out.println("\tvalor:" + e.next());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
