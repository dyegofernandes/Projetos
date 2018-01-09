package br.gov.pi.salvemaria.util;

import br.gov.pi.salvemaria.modelo.enums.Demandante;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {

    public FormasDeViolencia formaViolenciaPeloNome(String nome) {
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

    public Demandante demandantePeloNome(String nome) {
        if (Demandante.ANONIMO.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.ANONIMO;
        }
        if (Demandante.FAMILIAR.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.FAMILIAR;
        }
        if (Demandante.VITIMA.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.VITIMA;
        }
        if (Demandante.VIZINHO.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return Demandante.VIZINHO;
        }
        return null;
    }

    public TipoDenuncia tipoDenunciaPeloNome(String nome) {
        if (TipoDenuncia.DENUNCIA.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return TipoDenuncia.DENUNCIA;
        }
        if (TipoDenuncia.PANICO.getDescricao().toUpperCase().equals(nome.toUpperCase())) {
            return TipoDenuncia.PANICO;
        }
        return null;
    }

    public Date converterStringParaDate(String dataString, String pattern) throws ParseException {
        if (dataString == null) {
            return null;
        }
        SimpleDateFormat formato = new SimpleDateFormat(pattern);
        return formato.parse(dataString);
    }

    public String convertDateToString(Date date, String pattern) {
        SimpleDateFormat formataData = null;

        if (date == null) {
            return "";
        }

        formataData = new SimpleDateFormat(pattern);

        String data = formataData.format(date);

        return data;
    }

    public String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String enderecoPorNomeAtributoJson(JSONArray jsonArray, String componente) {
        Integer index = null;

        if (componente.equals("Numero")) {
            index = 0;
        }
        if (componente.equals("Endereco")) {
            index = 1;
        }
        if (componente.equals("Bairro")) {
            index = 2;
        }
        if (componente.equals("Cidade")) {
            index = 3;
        }
        if (componente.equals("Estado")) {
            index = 5;
        }
        if (componente.equals("Cep")) {
            index = 7;
        }

        JSONObject json = (JSONObject) jsonArray.get(index);

        return json.getString("long_name");
    }

    public String pegarRetornoUrlGoogle(URL url) throws IOException {
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

    public String pegarLatitude(String jsonString) {

        String location = jsonString.substring(jsonString.indexOf("\"location\" :"), jsonString.indexOf("\"location_type\"") - 13);
        String lat = location.substring((location.indexOf("\"lat\"") + 8), location.indexOf(","));
        return lat;
    }

    public String pegarLongitude(String jsonString) {

        String location = jsonString.substring(jsonString.indexOf("\"location\" :"), jsonString.indexOf("\"location_type\""));
        String lng = location.substring((location.indexOf("\"lng\" :") + 8), (location.indexOf("}")));
        return lng;
    }

}
