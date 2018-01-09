/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author Juniel
 */
public class TesteJason {

    public static void main(String[] args) throws MalformedURLException, IOException {
        List<String> logradouros = new ArrayList<String>();
        String chave = "AIzaSyDqNlqKwp8anYtmSrccmb5FTDwO1cINm-w";
        URL url = null;
        String urlString = "http://maps.googleapis.com/maps/api/geocode/json?address=:BUSCA";
        String stringDeBusca = "Limpel - General Services - Rua Rio Grande do Sul - Ilhotas, Teresina - Piaui, Brazil";

        url = new URL(urlString.replace(":BUSCA", stringDeBusca.replace(" ", "%20")).replace(":KEY", chave));

        String retorno = pegarRetornoUrlGoogle(url);
        EnderecoVO enderecoVO = new EnderecoVO();
        //retorno é um json = { "results" : [], "status" : "ZERO_RESULTS"}
        //retorno invalido é "status": "INVALID_REQUEST"
        //sem resultado  "status" : "ZERO_RESULTS"
        //com resultado "status" : "OK"

        org.json.JSONObject jsonObjTest = new org.json.JSONObject(retorno);

        if (jsonObjTest.getString("status").equals("OK")) {
            JSONArray jsonArray = jsonObjTest.getJSONArray("results");
            for (Object jsonArray1 : jsonArray) {
                JSONArray endereco = (JSONArray) ((org.json.JSONObject) jsonArray1).get("address_components");
                enderecoVO.setLogradouro(enderecoPorNomeAtributoJson(endereco, "Endereco"));
                enderecoVO.setNumero(enderecoPorNomeAtributoJson(endereco, "Numero"));
                enderecoVO.setBairro(enderecoPorNomeAtributoJson(endereco, "Bairro"));
                enderecoVO.setCidade(enderecoPorNomeAtributoJson(endereco, "Cidade"));
                enderecoVO.setEstado(enderecoPorNomeAtributoJson(endereco, "Estado"));
                enderecoVO.setPais(enderecoPorNomeAtributoJson(endereco, "Pais"));
                enderecoVO.setCep(enderecoPorNomeAtributoJson(endereco, "Cep"));

                String formatoEnderecoGoogle = ((org.json.JSONObject) jsonArray1).get("formatted_address").toString();
                enderecoVO.setEnderecoNoGoogle(formatoEnderecoGoogle);
                org.json.JSONObject geometrico = (org.json.JSONObject) ((org.json.JSONObject) jsonArray1).get("geometry");
                org.json.JSONObject localizacao = (org.json.JSONObject) geometrico.get("location");
                enderecoVO.setLatitude(localizacao.getDouble("lat"));
                enderecoVO.setLongitude(localizacao.getDouble("lng"));

            }

        } else {
            System.out.println("Lista vazia!");
        }

        System.out.println(enderecoVO.getEnderecoNoGoogle());
        System.out.println(enderecoVO.getLogradouro());
        System.out.println(enderecoVO.getNumero());
        System.out.println(enderecoVO.getBairro());
        System.out.println(enderecoVO.getCep());
        System.out.println(enderecoVO.getCidade());
        System.out.println(enderecoVO.getEstado());
        System.out.println(enderecoVO.getPais());
        System.out.println(enderecoVO.getLatitude());
        System.out.println(enderecoVO.getLongitude());
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
            JSONArray tipos = ((org.json.JSONObject) obj).getJSONArray("types");
            if (tipos.toString().contains(chave)) {
                return ((org.json.JSONObject) obj).getString("long_name");
            }
        }
        return null;
    }

}
