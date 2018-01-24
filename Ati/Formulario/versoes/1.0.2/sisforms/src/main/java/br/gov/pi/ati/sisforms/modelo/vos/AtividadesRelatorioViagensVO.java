/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.formulario.AtividadeRelatorioViagem;
import br.gov.pi.ati.sisforms.util.Utils;

/**
 *
 * @author Juniel
 */
public class AtividadesRelatorioViagensVO {

    private String descricao;

    private String dataAtividade;

    public AtividadesRelatorioViagensVO(AtividadeRelatorioViagem atividade) {
        this.descricao = atividade.getDescricao();
        this.dataAtividade = Utils.convertDateToString(atividade.getDataAtividade(), "dd/MM/yyyy");
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(String dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

}
