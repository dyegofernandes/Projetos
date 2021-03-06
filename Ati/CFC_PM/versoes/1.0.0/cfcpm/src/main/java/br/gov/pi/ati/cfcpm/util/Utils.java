package br.gov.pi.ati.cfcpm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.MaskFormatter;

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

    public static Long getTempoAtendimentoEmAnos(Date dataInicial, Date dataFinal) {

        if (dataInicial == null) {
            return 0L;
        }

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        Calendar dataFinalTemp = Calendar.getInstance();

        if (dataFinal != null) {
            dataFinalTemp.setTime(dataFinal);
        } else {
            dataFinalTemp.setTime(new Date());
        }

        Long milisegundos = (dataFinalTemp.getTimeInMillis() - dataInicialTemp.getTimeInMillis());

        return (((milisegundos / (1000 * 60 * 60 * 24)) / 30) / 12);
    }

    public static Date convertStringToDate(String dataString, String formato) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.parse(dataString);
    }

    public static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat formataData = null;

        if (date == null) {
            return "";
        }

        formataData = new SimpleDateFormat(pattern);

        String data = formataData.format(date);

        return data;
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

    public static long getIdade(Date dataNascimento) {
        Calendar hoje = Calendar.getInstance();
        hoje.setTime(new Date());
        Calendar dtNascimentoTemp = Calendar.getInstance();
        dtNascimentoTemp.setTime(dataNascimento);

        long idade = (hoje.getTimeInMillis() - dtNascimentoTemp.getTimeInMillis()) / 31536000000L;

        return idade;
    }

    public static long diferencaEmAnos(Date dataUm, Date dataDois) {
        Calendar fim = Calendar.getInstance();
        fim.setTime(dataDois);
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(dataUm);

        long idade = (fim.getTimeInMillis() - inicio.getTimeInMillis()) / 31536000000L;

        return idade;
    }
}
