/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.monitoramento;

import br.gov.pi.ati.sisforms.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.Conversao;
import br.gov.pi.ati.sisforms.util.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class InterrupcaoPontoAcesso implements Serializable {

    @Id
    @SequenceGenerator(name = "InterrupcaoPontoAcesso", sequenceName = "seq_interrupcaoPontoAcesso")
    @GeneratedValue(generator = "InterrupcaoPontoAcesso")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PontoAcesso indentificacao;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataInicial;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;

    @Size(max = 255)
    private String numeroOrdemServico;

    @Column(columnDefinition = "Text")
    private String observacoes;

    @Column(columnDefinition = "Text")
    private String comentarios;

    @Size(max = 255)
    private String numeroSysaid;

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PontoAcesso getIndentificacao() {
        return indentificacao;
    }

    public void setIndentificacao(PontoAcesso indentificacao) {
        this.indentificacao = indentificacao;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNumeroOrdemServico() {
        return numeroOrdemServico;
    }

    public void setNumeroOrdemServico(String numeroOrdemServico) {
        this.numeroOrdemServico = numeroOrdemServico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getNumeroSysaid() {
        return numeroSysaid;
    }

    public void setNumeroSysaid(String numeroSysaid) {
        this.numeroSysaid = numeroSysaid;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public BigDecimal getTempoInterrupcao() {
        BigDecimal tempo = BigDecimal.ZERO;
        if (dataInicial != null) {
            tempo = Utils.diferencaEntreDadas(dataInicial, dataFinal, Conversao.HORA);
        }

        return tempo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InterrupcaoPontoAcesso other = (InterrupcaoPontoAcesso) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
