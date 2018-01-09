package br.gov.pi.ati.agendacultural.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.primefaces.json.JSONObject;

public class Utils {

    String domainLDap = "uid=USUARIO_LDAP,ou=people,dc=ORGAO,dc=pi,dc=gov,dc=br";

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals(""));
    }

    public static String gerarDomain(String login) {
        //String usuarioZimbra = "uid=juniel.silva,ou=people,dc=ati,dc=pi,dc=gov,dc=br";
        //"uid=juniel.silva,ou=ati,ou=usuarios,dc=pi,dc=gov,dc=br"
        String domainLDap = "uid=USUARIO_LDAP,ou=people,dc=ORGAO,dc=pi,dc=gov,dc=br";
        String[] loginPartes = new String[2];
        loginPartes = login.toLowerCase().split("@");
        String usuario = loginPartes[0];

        String domain = loginPartes[1].toString();

        String[] domainPedacos = new String[4];
        domainPedacos = domain.split("\\.");
        String orgao = domainPedacos[0];

        domainLDap = domainLDap.replace("USUARIO_LDAP", usuario).replace("ORGAO", orgao);

        return domainLDap;
    }

    public static String getValorJson(JSONObject json, String chave) {

        String valor;

        try {
            valor = json.get(chave).toString();
        } catch (Exception e) {
            return null;
        }

        return valor;
    }

    public static Date convertStringToDate(String dataString, String formato) throws ParseException {
        if (isNullOrEmpty(dataString)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.parse(dataString);
    }

}
