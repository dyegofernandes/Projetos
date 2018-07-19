/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author KillerBeeTwo
 */
public class Teste {
    
    public static void main(String[] args) {
        List<ProgramacaoFinanceira> programacoes = new ArrayList<ProgramacaoFinanceira>();
        ProgramacaoFinanceira programacao1 = new ProgramacaoFinanceira();
        programacao1.setAno(2019);
        programacao1.setMes(Meses.FEVEREIRO);
        ProgramacaoFinanceira programacao2 = new ProgramacaoFinanceira();
        programacao2.setAno(2019);
        programacao2.setMes(Meses.MARCO);
        ProgramacaoFinanceira programacao3 = new ProgramacaoFinanceira();
        programacao3.setAno(2019);
        programacao3.setMes(Meses.DEZEMBRO);
        ProgramacaoFinanceira programacao4 = new ProgramacaoFinanceira();
        programacao4.setAno(2018);
        programacao4.setMes(Meses.JANEIRO);
        ProgramacaoFinanceira programacao5 = new ProgramacaoFinanceira();
        programacao5.setAno(2018);
        programacao5.setMes(Meses.MARCO);
        ProgramacaoFinanceira programacao6 = new ProgramacaoFinanceira();
        programacao6.setAno(2018);
        programacao6.setMes(Meses.MAIO);
        ProgramacaoFinanceira programacao7 = new ProgramacaoFinanceira();
        programacao7.setAno(2019);
        programacao7.setMes(Meses.JANEIRO);
        
        programacoes.add(programacao1);
        programacoes.add(programacao2);
        programacoes.add(programacao3);
        programacoes.add(programacao4);
        programacoes.add(programacao5);
        programacoes.add(programacao6);
        programacoes.add(programacao7);
        
        List<ProgramacaoFinanceira> programacoesVingente = new ArrayList<ProgramacaoFinanceira>();
        List<ProgramacaoFinanceira> programacoesProxima = new ArrayList<ProgramacaoFinanceira>();
        
        Collections.sort(programacoes);
        Integer ano = programacoes.get(0).getAno();
        
        for (ProgramacaoFinanceira programacao : programacoes) {
            if (ano.compareTo(programacao.getAno()) == 0) {
                programacoesVingente.add(programacao);
            } else {
                programacoesProxima.add(programacao);
            }
        }
        
        for (ProgramacaoFinanceira programacao : programacoesVingente) {
            System.out.println(programacao);
        }

    }
    
}
