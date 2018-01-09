/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class RelatorioInterrupcoesVO implements Serializable {

    private Long idLocal;
    
    private String local;

    private Integer qtd_interrupcoes;

    private String numDaOS;

    private BigDecimal tempoTotal = BigDecimal.ZERO;

    private String observacoes;

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getQtd_interrupcoes() {
        return qtd_interrupcoes;
    }

    public void setQtd_interrupcoes(Integer qtd_interrupcoes) {
        this.qtd_interrupcoes = qtd_interrupcoes;
    }

    public String getNumDaOS() {
        return numDaOS;
    }

    public void setNumDaOS(String numDaOS) {
        this.numDaOS = numDaOS;
    }

    public BigDecimal getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(BigDecimal tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
