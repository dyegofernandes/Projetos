/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.arquivoBanco;

import com.opfacil.modelo.enums.Formato;

/**
 *
 * @author Juniel
 */
public class ConstruirTxt {

    public String setHeaderArquivo(HeaderArquivo hA) {
        String linha = "";
        linha = linha + inserirCaractere(hA.getCampo1_0(), 3, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo2_0(), 4, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo3_0(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo4_0(), 9, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo5_0(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo6_0(), 14, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo7_0(), 20, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo8_0(), 5, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo9_0(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo10_0(), 12, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo11_0(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo12_0(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo13_0(), 30, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo14_0(), 30, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo15_0(), 10, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo16_0(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo17_0(), 8, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo18_0(), 6, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo19_0(), 6, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo20_0(), 3, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo21_0(), 5, Formato.NUM);
        linha = linha + inserirCaractere(hA.getCampo22_0(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo23_0(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(hA.getCampo24_0(), 29, Formato.ALFA);

        return (linha + System.getProperty("line.separator"));
    }

    public String setHeaderLote(HeaderLote hL) {
        String linha = "";
        linha = linha + inserirCaractere(hL.getCampo1_1(), 3, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo2_1(), 4, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo3_1(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo4_1(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo5_1(), 2, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo6_1(), 2, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo7_1(), 3, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo8_1(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo9_1(), 1, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo10_1(), 14, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo11_1(), 20, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo12_1(), 5, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo13_1(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo14_1(), 12, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo15_1(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo16_1(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo17_1(), 30, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo18_1(), 40, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo19_1(), 30, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo20_1(), 5, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo21_1(), 15, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo22_1(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo23_1(), 8, Formato.NUM);
        linha = linha + inserirCaractere(hL.getCampo24_1(), 2, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo25_1(), 8, Formato.ALFA);
        linha = linha + inserirCaractere(hL.getCampo26_1(), 10, Formato.ALFA);

        return (linha + System.getProperty("line.separator"));
    }

    public String setDetalhe(Detalhe dE) {
        String linha = "";
        linha = linha + inserirCaractere(dE.getCampo1_3(), 3, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo2_3(), 4, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo3_3(), 1, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo4_3(), 5, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo5_3(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo6_3(), 1, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo7_3(), 2, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo8_3(), 3, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo9_3(), 3, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo10_3(), 5, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo11_3(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo12_3(), 12, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo13_3(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo14_3(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo15_3(), 30, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo16_3(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo17_3(), 8, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo18_3(), 3, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo19_3(), 15, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo20_3(), 15, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo21_3(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo22_3(), 8, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo23_3(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo24_3(), 20, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo25_3(), 1, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo26_3(), 14, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo27_3(), 3, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo28_3(), 9, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo29_3(), 1, Formato.NUM);
        linha = linha + inserirCaractere(dE.getCampo30_3(), 10, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo31_3(), 1, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo32_3(), 30, Formato.ALFA);
        linha = linha + inserirCaractere(dE.getCampo33_3(), 30, Formato.ALFA);

        return linha;
    }

    public String setDetalheItem(DetalheItem dEIt) {
        String linha = "";
        linha = linha + inserirCaractere(dEIt.getCampoTexto(), 29, Formato.ALFA);
        linha = linha + inserirCaractere(dEIt.getCampoValor(), 7, Formato.NUM);
        linha = linha + inserirCaractere(dEIt.getCampoSinal(), 1, Formato.ALFA);

        return linha;
    }

    public String setTrailerLote(TrailerLote tL) {
        String linha = "";
        linha = linha + inserirCaractere(tL.getCampo1_5(), 3, Formato.NUM);
        linha = linha + inserirCaractere(tL.getCampo2_5(), 4, Formato.NUM);
        linha = linha + inserirCaractere(tL.getCampo3_5(), 1, Formato.NUM);
        linha = linha + inserirCaractere(tL.getCampo4_5(), 9, Formato.ALFA);
        linha = linha + inserirCaractere(tL.getCampo5_5(), 6, Formato.NUM);
        linha = linha + inserirCaractere(tL.getCampo6_5(), 18, Formato.NUM); //16 + 2 decimais
        linha = linha + inserirCaractere(tL.getCampo7_5(), 18, Formato.NUM); //13 + 5 decimais
        linha = linha + inserirCaractere(tL.getCampo9_5(), 171, Formato.ALFA);
        linha = linha + inserirCaractere(tL.getCampo10_5(), 10, Formato.ALFA);

        return (linha + System.getProperty("line.separator"));
    }

    public String setTrailerArquivo(TrailerArquivo tA) {
        String linha = "";
        linha = linha + inserirCaractere(tA.getCampo1_9(), 3, Formato.NUM);
        linha = linha + inserirCaractere(tA.getCampo2_9(), 4, Formato.NUM);
        linha = linha + inserirCaractere(tA.getCampo3_9(), 1, Formato.NUM);
        linha = linha + inserirCaractere(tA.getCampo4_9(), 9, Formato.ALFA);
        linha = linha + inserirCaractere(tA.getCampo5_9(), 6, Formato.NUM);
        linha = linha + inserirCaractere(tA.getCampo6_9(), 6, Formato.NUM);
        linha = linha + inserirCaractere(tA.getCampo7_9(), 6, Formato.NUM);
        linha = linha + inserirCaractere(tA.getCampo8_9(), 205, Formato.ALFA);

        return (linha + System.getProperty("line.separator"));
    }

    /**
     * metodo usado para inserir caracteres na esquerda ou direita para uma
     * string
     *
     * @author Juniel
     * @param input
     * @param width
     * @param formato pode pode ser do tipo num ou alfa
     * @return uma estring preenchendo a direita se for o formato for alfa e a
     * esquerda se for num
     */
    private String inserirCaractere(String input, int width, Formato formato) {

        char ch = ' ';

        if (formato == Formato.NUM) {
            ch = '0';
        }

        String strPad = "";
        
        if(input==null){
            input = "";
        }

        StringBuilder sb = new StringBuilder(input.trim());

        if (formato == Formato.NUM) {
            while (sb.length() < width) {
                sb.insert(0, ch);
            }
            strPad = sb.toString();

            if (strPad.length() > width) {

                strPad = strPad.substring(0, width);
            }
        } else {
            int total = sb.length() - 1;
            while (sb.length() < width) {
                sb.append(ch);
            }
            strPad = sb.toString();

            if (strPad.length() > width) {

                strPad = strPad.substring(0, width);
            }
        }

        return strPad;
    }
}
