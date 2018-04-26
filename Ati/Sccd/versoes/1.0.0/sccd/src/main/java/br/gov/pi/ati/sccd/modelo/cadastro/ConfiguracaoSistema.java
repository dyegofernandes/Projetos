/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class ConfiguracaoSistema implements Serializable {

    @Id
    @SequenceGenerator(name = "ConfiguracaoSistema", sequenceName = "configuracaoSistema_id_seq")
    @GeneratedValue(generator = "ConfiguracaoSistema")
    private Long id;
    
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date inicioTurno;
    
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date fimTurno;
    
    @NotNull
    private Integer numeroAtendentes;
    
    @NotNull
    private Integer tempoAtendimento;
    
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroAtendentes() {
        return numeroAtendentes;
    }

    public void setNumeroAtendentes(Integer numeroAtendentes) {
        this.numeroAtendentes = numeroAtendentes;
    }

    public Integer getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoAtendimento(Integer tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(Date inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public Date getFimTurno() {
        return fimTurno;
    }

    public void setFimTurno(Date fimTurno) {
        this.fimTurno = fimTurno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ConfiguracaoSistema other = (ConfiguracaoSistema) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
