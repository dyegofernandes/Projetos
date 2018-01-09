/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesTeste;

import com.xpert.security.ActiveDirectory;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author KillerBeeTwo
 */
public class Main {

    public static void main(String[] args) throws CommunicationException, NamingException {
        String login = "juniel.silva@ati.pi.gov.br";
        try {
//            LdapContext context = ActiveDirectory.getConnection("juniel.silva", "SistemaRemanso84","ou=ati,ou=Usuarios,dc=pi,dc=gov,dc=br","ldap.pi.gov.br");
//            LdapContext context = ActiveDirectory.getConnection(null, null,"ldap.pi.gov.br");
            LdapContext context = ActiveDirectory.getConnection(gerarDomain(login), "SistemaRemanso84", "ldap.pi.gov.br", null);
//            LdapContext context = ActiveDirectory.getConnection("juniel.silva", "SistemaRemanso84", "ati.pi.gov.br");
//            LdapContext context = TesteLdap.getConnection("uid=juniel.silva,ou=ati,ou=usuarios,dc=pi,dc=gov,dc=br", "SistemaRemanso84", "ldap.pi.gov.br", null);
            context.close();
            System.out.println("Autenticação realizada com sucesso");
        } catch (AuthenticationException ex) {
            System.out.println("Autenticação não realizada");
            ex.printStackTrace();
        } catch (CommunicationException ex) {
            System.out.println("Falha ao se comunicar o com o servidor LDAP");
            ex.printStackTrace();
        } catch (NamingException ex) {
            System.out.println("Falha ao se comunicar o com o servidor LDAP");
            ex.printStackTrace();
        }

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
