/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author KillerBeeTwo
 */
public class NewClass {

    public static void main(String args[]) {
        List<Denuncia> denuncias = new ArrayList<Denuncia>();
        
        Long maiorId = 0L;

        Denuncia denuncia1 = new Denuncia(2L, "Dois");
        Denuncia denuncia2 = new Denuncia(6L, "Seis");
        Denuncia denuncia3 = new Denuncia(23L, "Vinte e Tres");
        Denuncia denuncia4 = new Denuncia(244L, "Duzentos e Quarenta e Quatro");
        Denuncia denuncia5 = new Denuncia(2343L, "Dois mil");
        Denuncia denuncia6 = new Denuncia(25L, "Vinte e Cinto");

        denuncias.add(denuncia1);
        denuncias.add(denuncia2);
        denuncias.add(denuncia3);
        denuncias.add(denuncia4);
        denuncias.add(denuncia5);
        denuncias.add(denuncia6);

        for (Denuncia denuncia : denuncias) {
            System.out.println(denuncia.getNome());
        }
        
    }

    private static final Comparator<Denuncia> MAIOR_ID = new Comparator<Denuncia>() {
        @Override
        public int compare(Denuncia o1, Denuncia o2) {
            return o1.getId().intValue() - o2.getId().intValue();
        }
    };

}
