/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import javax.swing.text.AbstractDocument.Content;

/**
 *
 * @author Juniel
 */
public class Teste2 {

    public static void main(String[] args) throws MalformedURLException, IOException {
//        Integer codigo = 20171;
//
//        if (2017 == pegaPrimirosDigitos(codigo, 4)) {
//            System.out.println("Igual");
//        }
//        System.out.println(pegaPrimirosDigitos(codigo, 4));

//        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=Altos,Piauí&sensor=false");
//
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        connection.setRequestMethod("GET");
//
//        InputStream is = connection.getInputStream();
//        try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
//            String line;
//            while ((line = rd.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
        String nome = null;
        if (isNullOrEmpty(nome)) {
            System.out.println("Ok");
        }
    }

    private static Integer getUtimoCodigoOcorrencia(Integer codigoAtual) {
        Calendar hoje = Calendar.getInstance();
        Integer anoAtual = hoje.get(Calendar.YEAR);
        Integer novoCodigo = 0;

        if (anoAtual.equals(pegaPrimirosDigitos(codigoAtual, 4))) {
            novoCodigo = codigoAtual + 1;
        } else {
            novoCodigo = anoAtual;
        }

        return null;
    }

    public static Integer pegaPrimirosDigitos(int valor, int digitos) {
        digitos = Math.max(1, digitos);
        int positivo = Math.abs(valor);
        String texto = String.valueOf(positivo);
        if (digitos > texto.length()) {
            return valor;
        }
        return Integer.parseInt(texto.substring(0, digitos)) * Integer.signum(valor);
    }

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals(""));
    }

}
