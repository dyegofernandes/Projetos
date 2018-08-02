/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import br.gov.pi.ati.sisdh.modelo.cadastro.enums.AreaAtuacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.SimOuNao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoDeServicoLgbt;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class AgendamentoTriagem implements Serializable {

    @Id
    @SequenceGenerator(name = "AgendamentoTriagem", sequenceName = "seq_agendamentoTriagem")
    @GeneratedValue(generator = "AgendamentoTriagem")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataAgend = new Date();

    @Temporal(TemporalType.TIME)
    private Date hora = new Date();

    @NotNull
    private TipoDeServicoLgbt tipoDeServico;

    @NotBlank
    @Column(columnDefinition = "Text")
    private String descricao;

    @NotNull
    private AreaAtuacao area;

    @NotNull
    private SimOuNao efetivado;

    @Size(max = 120)
    @NotBlank
    private String nomeEfetivado;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AgendamentoTriagem other = (AgendamentoTriagem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAgend() {
        return dataAgend;
    }

    public void setDataAgend(Date dataAgend) {
        this.dataAgend = dataAgend;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public TipoDeServicoLgbt getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(TipoDeServicoLgbt tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AreaAtuacao getArea() {
        return area;
    }

    public void setArea(AreaAtuacao area) {
        this.area = area;
    }

    public SimOuNao getEfetivado() {
        return efetivado;
    }

    public void setEfetivado(SimOuNao efetivado) {
        this.efetivado = efetivado;
    }

    public String getNomeEfetivado() {
        return nomeEfetivado;
    }

    public void setNomeEfetivado(String nomeEfetivado) {
        this.nomeEfetivado = nomeEfetivado;
    }
    
    
}
