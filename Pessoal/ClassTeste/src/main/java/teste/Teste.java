/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author KillerBeeTwo
 */
public class Teste {
    
    public static void main(String[] args) {
       
        System.out.println("20180101000001".substring(0, 8));
    }
    public static String moeda(BigDecimal num) {

        if (num == null) {
            return null;
        }
        Locale ptBr = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(ptBr);
        String formatado = nf.format(num);

        return formatado;
    }
}
