/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum EstiloArquitetonico {

    MANEIRISMO("Maneirismo"),
    BARROCO_E_ROCOCO("Barroco e Rococó"),
    NEOCLASSICISMO("Neoclassicismo"),
    ECLETISMO("Ecletismo"),
    NEOGOTICO("Neogótico"),
    NEOCOLONIAL("Neocolonial"),
    MODERNISTA("Modernista"),
    CONTEPORANEO("Contemporâneo");

    private EstiloArquitetonico(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
