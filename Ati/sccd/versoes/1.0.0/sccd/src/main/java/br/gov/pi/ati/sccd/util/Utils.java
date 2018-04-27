package br.gov.pi.ati.sccd.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

public class Utils {

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

    public static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String moeda(BigDecimal num) {
        NumberFormat formatter = new DecimalFormat("##,###,###,###,###,###,###,##0.00");

        return formatter.format(num.doubleValue());
    }

    public static String inserirZeroAEsquerda(String input, int width) {
        char ch = '0';
        String strPad = "";

        if (input == null) {
            input = "";
        }
        StringBuilder sb = new StringBuilder(input.trim());

        while (sb.length() < width) {
            sb.insert(0, ch);
        }
        strPad = sb.toString();

        if (strPad.length() > width) {

            strPad = strPad.substring(0, width);
        }
        return strPad;
    }

    public static String getDateString(Date data, String pattern) {
        SimpleDateFormat formataData = null;

        if (data == null) {
            return "";
        }

        formataData = new SimpleDateFormat(pattern);

        return formataData.format(data);
    }

}
