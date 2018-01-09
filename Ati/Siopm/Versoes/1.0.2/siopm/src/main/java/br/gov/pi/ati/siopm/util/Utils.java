package br.gov.pi.ati.siopm.util;

import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import br.gov.pi.ati.siopm.modelo.enums.Conversao;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.text.MaskFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {

    public static Date converterStringParaDate(String dataString, String pattern) throws ParseException {
        if (dataString == null) {
            if (dataString.equals("")) {
                return null;
            }
            return null;
        }
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        return formato.parse(dataString);
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

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals(""));
    }

    public static Integer getAnoAtual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        Integer ano = new Integer(formato.format(new Date()));
        return ano;
    }

    /* Calculate distance between two points in latitude 
     and longitude taking into account height difference. 
     If you are not interested in height difference pass 0.0.
     Uses Haversine method as its base. lat1, lon1 Start point 
     lat2, lon2 End point el1 Start altitude in meters el2 End altitude 
     in meters */
    public static double distance(double lat1, double lat2, double lon1, double lon2,
            double el1, double el2) {

        final int R = 6371; // Radius of the earth

        Double latDistance = deg2rad(lat2 - lat1);
        Double lonDistance = deg2rad(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        return Math.sqrt(distance);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
//se aumentar mudar splint também

    public static String getAtributosMarcacaoDenuncia(Ocorrencia ocorrencia, List<NaturezaOcorrencia> naturezas, List<Patrulha> patrulhas) {
        String retorno = "";

        if (ocorrencia.getId() != null) {
            retorno = retorno.concat("Id: ").concat(ocorrencia.getId().toString());
            retorno = retorno.concat("\n");
        } else {
            retorno = retorno.concat("Id: -");
            retorno = retorno.concat("\n");
        }

        if (ocorrencia.getCodigo() != null) {
            if (ocorrencia.getAno() != null) {
                retorno = retorno.concat("Código: ").concat(ocorrencia.getAno().toString().concat(ocorrencia.getCodigo().toString()));
                retorno = retorno.concat("\n");
            }
        }
        if (ocorrencia.getId() != null) {
            if (ocorrencia.getSituacao() != null) {
                retorno = retorno.concat("Situação: ").concat(ocorrencia.getSituacao().getDescricao());
                retorno = retorno.concat("\n");
            }

        } else {
            retorno = retorno.concat("Situação: ").concat("Ocorrência não confirmada");
            retorno = retorno.concat("\n");
        }

        if (ocorrencia.getClassificacaoChamada() != null) {
            retorno = retorno.concat("Classificação: ").concat(ocorrencia.getClassificacaoOcorrencia().getDescricao());
            retorno = retorno.concat("\n");
        }

        if (ocorrencia.getDataOcorrencia() != null) {
            if (ocorrencia.getDataOcorrencia() != null) {
                retorno = retorno.concat("Data: ".concat(Utils.convertDateToString(ocorrencia.getDataOcorrencia(), "dd/MM/yyyy")));
                retorno = retorno.concat("\n");

                if (ocorrencia.getId() != null) {
                    retorno = retorno.concat("Horário: ".concat(Utils.convertDateToString(ocorrencia.getSolicitantes().get(0).getHorarioSolicitacao(), "HH:mm")));
                } else {
                    retorno = retorno.concat("Horário: ".concat(Utils.convertDateToString(new Date(), "HH:mm")));

                }

                retorno = retorno.concat("\n");

            }
        }

        if (ocorrencia.getEndereco() != null) {
            if (ocorrencia.getEndereco().getEnderecoFormatado() != null) {
                retorno = retorno.concat("Endereço: ").concat(ocorrencia.getEndereco().getEnderecoFormatado());
                retorno = retorno.concat("\n");
            }
        }

        if (naturezas != null) {
            if (naturezas.size() > 0) {
                String naturezasString = "";
                for (NaturezaOcorrencia natureza : naturezas) {
                    naturezasString = naturezasString.concat(natureza.getCodigo().concat(" - ").concat(natureza.getNome())).concat("; ");
                }
                retorno = retorno.concat("Naturezas: ").concat(naturezasString);
                retorno = retorno.concat("\n");
            }
        }

        if (patrulhas != null) {
            if (patrulhas.size() > 0) {
                String viaturasString = "";
                for (Patrulha patrulha : patrulhas) {
                    viaturasString = viaturasString.concat(patrulha.getNome()).concat("; ");
                }

                retorno = retorno.concat("Guarnições: ").concat(viaturasString);
                retorno = retorno.concat("\n");
            }
        }

        if (!isNullOrEmpty(ocorrencia.getHistorioInicial())) {
            retorno = retorno.concat("Descrição: ").concat(ocorrencia.getHistorioInicial());
            retorno = retorno.concat("\n");
        }

        return retorno;
    }

    public static String moeda(BigDecimal num) {
        NumberFormat formatter = new DecimalFormat("##,###,###,###,###,###,###,##0.00");

        return formatter.format(num.doubleValue());
    }

    public static BigDecimal calcularPorcentagem(BigDecimal porcentagem, BigDecimal valor) {
        BigDecimal retorno = BigDecimal.ZERO;

        if (valor == null || porcentagem == null) {
            return BigDecimal.ZERO;
        }

        retorno = valor.multiply(porcentagem).divide(new BigDecimal(100), 2, RoundingMode.DOWN);

        return retorno;
    }

    public static BigDecimal diferencaEntreDadas(Date dataInicial, Date dataFinal, Conversao conversao) {

        BigDecimal tempo = BigDecimal.ZERO;

        Calendar dataInicialTemp = Calendar.getInstance();
        dataInicialTemp.setTime(dataInicial);

        Calendar dataFinalTemp = Calendar.getInstance();

        if (dataFinal != null) {
            dataFinalTemp.setTime(dataFinal);
        } else {
            dataFinalTemp.setTime(new Date());
        }

        Long milisegundos = (dataFinalTemp.getTimeInMillis() - dataInicialTemp.getTimeInMillis());

        if (conversao == Conversao.MINUTO) {
            tempo = (new BigDecimal(milisegundos)).divide(new BigDecimal(60000), RoundingMode.HALF_UP);
        }

        if (conversao == Conversao.HORA) {
            tempo = (new BigDecimal(milisegundos)).divide(new BigDecimal(3600000), RoundingMode.HALF_UP);
        }

        if (conversao == Conversao.DIA) {
            tempo = (new BigDecimal(milisegundos)).divide(new BigDecimal(86400000), RoundingMode.HALF_UP);
        }

        return tempo;
    }

    /**
     * Retorna a data passada como parametro por extenso
     *
     * @param data
     * @return
     */
    public static String getDataPorExtenso(Date data) {
        DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
        return dfmt.format(data);
    }

    /**
     * Retorna a data passada como parametro por extenso
     *
     * @param dataInicial
     * @param dataFinal
     * @return
     */
    public static String getPeriodoPorExtenso(Date dataInicial, Date dataFinal) {

        DateFormat dfmt = new SimpleDateFormat("HH:mm 'do dia'  dd/MM/yyyy");

        String periodo = "Período: ";

        if (dataInicial != null) {
            periodo = periodo.concat(dfmt.format(dataInicial));
        } else {
            periodo = periodo.concat(" --");
        }

        periodo = periodo.concat(" as ");

        if (dataFinal != null) {
            periodo = periodo.concat(dfmt.format(dataFinal));
        } else {
            periodo = periodo.concat(" -- ");
        }

        return periodo;
    }

    public static boolean verificarSeDataEhMaiorQueDataAtual(Date dataVerificada, Date horaVerificada) {
        Calendar dataTemp = Calendar.getInstance();
        dataTemp.setTime(dataVerificada);

        Calendar horaTemp = Calendar.getInstance();
        horaTemp.setTime(horaVerificada);

        dataTemp.set(Calendar.HOUR_OF_DAY, horaTemp.get(Calendar.HOUR_OF_DAY));
        dataTemp.set(Calendar.MINUTE, horaTemp.get(Calendar.MINUTE));

        return (dataTemp.getTime().compareTo(new Date()) > 0);

    }

    public static Date juntarDataEHora(Date data, Date hora) {
        Calendar dataTemp = Calendar.getInstance();
        dataTemp.setTime(data);

        Calendar horaTemp = Calendar.getInstance();
        horaTemp.setTime(hora);

        dataTemp.set(Calendar.HOUR_OF_DAY, horaTemp.get(Calendar.HOUR_OF_DAY));
        dataTemp.set(Calendar.MINUTE, horaTemp.get(Calendar.MINUTE));

        return dataTemp.getTime();
    }
}
