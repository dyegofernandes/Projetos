/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresso3client;

import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author KillerBeeTwo
 */
public class Teste {

    public static void main(String[] args) {
        String base64AsString = new String(Base64.encode("Juniel".getBytes()));

        System.out.println(base64AsString);
        
         String conteudo = new String(Base64.decode(base64AsString));
         
         System.out.println(conteudo);
    }

}
