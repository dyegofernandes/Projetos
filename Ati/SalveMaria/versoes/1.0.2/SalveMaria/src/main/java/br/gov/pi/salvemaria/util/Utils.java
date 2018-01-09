package br.gov.pi.salvemaria.util;

import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.Demandante;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.MaskFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {

    public static Demandante demandantePeloNome(String nome) {
        if (Demandante.FAMILIAR.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.FAMILIAR;
        }
        if (Demandante.ANONIMO.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.ANONIMO;
        }
        if (Demandante.VITIMA.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.VITIMA;
        }
        if (Demandante.VIZINHO.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.VIZINHO;
        }

        return null;
    }

    public static FormasDeViolencia formaViolenciaPeloNome(String nome) {
        if (FormasDeViolencia.FISICA.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return FormasDeViolencia.FISICA;
        }
        if (FormasDeViolencia.MORAL.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return FormasDeViolencia.MORAL;
        }
        if (FormasDeViolencia.PATRIMONIAL.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return FormasDeViolencia.PATRIMONIAL;
        }
        if (FormasDeViolencia.PSICOLOGICA.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return FormasDeViolencia.PSICOLOGICA;
        }
        if (FormasDeViolencia.SEXUAL.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return FormasDeViolencia.SEXUAL;
        }

        return null;
    }

    public static TipoDenuncia tipoDenunciaPeloNome(String nome) {
        if (TipoDenuncia.DENUNCIA.toString().equals(nome)) {
            return TipoDenuncia.DENUNCIA;
        }
        if (TipoDenuncia.PANICO.toString().equals(nome)) {
            return TipoDenuncia.PANICO;
        }
        return null;
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

    public static String enderecoPorNomeAtributoJson(JSONArray jsonArray, String componente) {
        String chave = "";
        if (componente.equals("Numero")) {
            chave = "street_number";
        }
        if (componente.equals("Endereco")) {
            chave = "route";
        }
        if (componente.equals("Bairro")) {
            chave = "sublocality_level_1"; //["political","sublocality","sublocality_level_1"]
        }
        if (componente.equals("Cidade")) {
            chave = "administrative_area_level_2";
        }
        if (componente.equals("Estado")) {
            chave = "administrative_area_level_1";
        }
        if (componente.equals("Cep")) {
            chave = "postal_code";
        }
        if (componente.equals("Pais")) {
            chave = "country";
        }

        for (Object obj : jsonArray) {
            JSONArray tipos = ((JSONObject) obj).getJSONArray("types");
            if (tipos.toString().contains(chave)) {
                return ((JSONObject) obj).getString("long_name");
            }
        }

        return null;

    }

    public static String pegarRetornoUrlGoogle(URL url) throws IOException {
        if (url == null) {
            return null;
        }
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
        } catch (IOException e) {
            return null;
        }
        String str;

        String json = "";
        while ((str = in.readLine()) != null) {
            json = json + str;
        }
        in.close();
//        return json;
        return json.replace("   ", "");
    }

    public static String pegarLatitude(String jsonString) {

        String location = jsonString.substring(jsonString.indexOf("\"location\" :"), jsonString.indexOf("\"location_type\"") - 13);
        String lat = location.substring((location.indexOf("\"lat\"") + 8), location.indexOf(","));
        return lat;
    }

    public static String pegarLongitude(String jsonString) {

        String location = jsonString.substring(jsonString.indexOf("\"location\" :"), jsonString.indexOf("\"location_type\""));
        String lng = location.substring((location.indexOf("\"lng\" :") + 8), (location.indexOf("}")));
        return lng;
    }

    public static Date primeiroDiaDoMes() {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_MONTH, 1);

        return dataAtual.getTime();
    }

    public static Date ultimoDiaDoMes() {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_MONTH, dataAtual.getActualMaximum(Calendar.DAY_OF_MONTH));

        return dataAtual.getTime();
    }

    public static Date primeiroDiaDaSemana() {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return dataAtual.getTime();
    }

    public static Date ultimoDiaDaSemana() {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return dataAtual.getTime();
    }

    public static Date primeiroDiaSemestre() {
        Calendar dataAtual = Calendar.getInstance();

        if (dataAtual.get(Calendar.MONTH) < 6) {
            dataAtual.set(Calendar.MONTH, 0);
        } else {
            dataAtual.set(Calendar.MONTH, 6);
        }

        dataAtual.set(Calendar.DAY_OF_MONTH, 1);

        return dataAtual.getTime();
    }

    public static Date ultimoDiaSemestre() {
        Calendar dataAtual = Calendar.getInstance();

        if (dataAtual.get(Calendar.MONTH) < 6) {
            dataAtual.set(Calendar.MONTH, 5);
        } else {
            dataAtual.set(Calendar.MONTH, 11);
        }

        dataAtual.set(Calendar.DAY_OF_MONTH, dataAtual.getActualMaximum(Calendar.DAY_OF_MONTH));

        return dataAtual.getTime();
    }

    public static Date primeiroDiaDoAno() {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_MONTH, 1);
        dataAtual.set(Calendar.MONTH, 0);

        return dataAtual.getTime();
    }

    public static Date ultiomoDiaDoAno() {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_MONTH, 31);
        dataAtual.set(Calendar.MONTH, 11);

        return dataAtual.getTime();
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

    public static String getAtributosMarcacaoDenuncia(Denuncia denuncia) {
        String retorno = "";

        if (denuncia.getId() != null) {
            retorno = retorno.concat("Código: ").concat(denuncia.getId().toString());
            retorno = retorno.concat("\n");
        }

        if (denuncia.getTipo() != null) {
            retorno = retorno.concat("Tipo: ").concat(denuncia.getTipo().getDescricao());
            retorno = retorno.concat("\n");
        }

        if (denuncia.getEndereco() != null) {
            if (denuncia.getEndereco().getEndereco() != null) {
                retorno = retorno.concat("Endereço: ").concat(denuncia.getEndereco().getEndereco());
            }
            if (denuncia.getEndereco().getNumero() != null) {
                retorno = retorno.concat(", ").concat(denuncia.getEndereco().getNumero());
            }

            if (denuncia.getEndereco().getBairro() != null) {
                retorno = retorno.concat(", ").concat(denuncia.getEndereco().getBairro().getNome());

                if (denuncia.getEndereco().getBairro().getCidade() != null) {
                    retorno = retorno.concat(", ").concat(denuncia.getEndereco().getBairro().getCidade().getNome());
                }
            }

            retorno = retorno.concat("\n");
        }

        if (denuncia.getVitima() != null) {
            retorno = retorno.concat("Vítima: ").concat(denuncia.getVitima());
        }

        return retorno;
    }

    public static boolean ltdELgdNaoEhNullo(Denuncia denuncia) {
        if (denuncia.getEndereco().getLatitude() != null && denuncia.getEndereco().getLongitude() != null) {
            if (!denuncia.getEndereco().getLatitude().equals("") && !denuncia.getEndereco().getLongitude().equals("")) {
                return true;
            }
        }

        return false;
    }

    public static Date setarData(Integer dia, Integer mes, Integer ano) {
        Calendar dataAtual = Calendar.getInstance();

        if (dia != null) {
            dataAtual.set(Calendar.DAY_OF_MONTH, dia);
        }

        if (mes != null) {
            dataAtual.set(Calendar.MONTH, mes);
        }

        if (ano != null) {
            dataAtual.set(Calendar.YEAR, ano);
        }

        return dataAtual.getTime();
    }

    public static BigDecimal calcularPorcPeloValor(Integer total, Integer valor) {

        BigDecimal retorno = BigDecimal.ZERO;

        if (valor == null || total == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalTemp = new BigDecimal(total);
        BigDecimal valorTemp = new BigDecimal(valor);

        if (totalTemp.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        retorno = valorTemp.multiply(new BigDecimal(100)).divide(totalTemp, 2, RoundingMode.UP);

        return retorno;
    }

    public static FormasDeViolencia getFormaDeViolencia(int num) {
        FormasDeViolencia forma = null;

        switch (num) {
            case 0:
                forma = FormasDeViolencia.FISICA;
                break;
            case 1:
                forma = FormasDeViolencia.PSICOLOGICA;
                break;
            case 2:
                forma = FormasDeViolencia.SEXUAL;
                break;
            case 3:
                forma = FormasDeViolencia.PATRIMONIAL;
                break;
            case 4:
                forma = FormasDeViolencia.MORAL;
                break;
            default:
                forma = null;
        }

        return forma;
    }

    public static Date convertStringToDate(String dataString, String formato) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.parse(dataString);
    }

    public static Date getDataComHora(Date dataInicial, Date horaInicial) {

        if (dataInicial == null || horaInicial == null) {
            return null;
        }

        SimpleDateFormat hours = new SimpleDateFormat("hh");
        SimpleDateFormat minutes = new SimpleDateFormat("mm");
        SimpleDateFormat secounds = new SimpleDateFormat("ss");

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        dataInicialTemp.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours.format(horaInicial)));
        dataInicialTemp.set(Calendar.MINUTE, Integer.parseInt(minutes.format(horaInicial)));
        dataInicialTemp.set(Calendar.SECOND, Integer.parseInt(secounds.format(horaInicial)));

        return dataInicialTemp.getTime();
    }

    public static Long getTempoAtendimentoEmMinutos(Date dataInicial, Date dataFinal) {

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

        return (milisegundos / 60000);
    }

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals(""));
    }
}
