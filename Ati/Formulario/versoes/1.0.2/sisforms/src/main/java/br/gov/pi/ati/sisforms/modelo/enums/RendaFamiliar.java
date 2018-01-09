/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum RendaFamiliar {
    MENOR_QUE_SALARIO_MINIMO("Menor que 1 Salário Mínimo"),
    DE_UM_A_TRE_SALARIO_MINIMO("De 1 a 3 Salário Mínimo"),
    DE_TRES_A_CINCO_SALARIO_MINIMO("De 3 a 5 Salário Mínimo"),
    DE_CINCO_A_SETE_SALARIO_MINIMO("De 5 a 7 Salário Mínimo"),
    ACIMA_DE_SETE_SALARIO_MINIMO("Maior que 7 Salário Mínimo");
    

    private RendaFamiliar(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
