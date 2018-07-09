/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author KillerBeeTwo
 */
public class Teste {
    public static void main(String[] args){
       String teste = "aa.002.1.008295/17";
       
       System.out.println(teste.matches("^[a-zA-Z]{2}\\.\\d{3}\\.\\d\\.\\d{6}\\/\\d{2}$"));
    }
    
}
