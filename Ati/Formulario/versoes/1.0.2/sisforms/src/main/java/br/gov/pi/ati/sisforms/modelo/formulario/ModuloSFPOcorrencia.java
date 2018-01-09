/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Juniel
 */
@Entity
public class ModuloSFPOcorrencia implements Serializable {

    @Id
    @SequenceGenerator(name = "ModuloSFPOcorrencia", allocationSize = 1, sequenceName = "seq_moduloSFPOcorrencia")
    @GeneratedValue(generator = "ModuloSFPOcorrencia")
    private Long id;

    private boolean afastamentoLicenca = false;

    private boolean exoneracao = false;

    private boolean aposentadoria = false;

    private boolean disposicao = false;
    
    private boolean enquadramento = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAfastamentoLicenca() {
        return afastamentoLicenca;
    }

    public void setAfastamentoLicenca(boolean afastamentoLicenca) {
        this.afastamentoLicenca = afastamentoLicenca;
    }

    public boolean isExoneracao() {
        return exoneracao;
    }

    public void setExoneracao(boolean exoneracao) {
        this.exoneracao = exoneracao;
    }

    public boolean isAposentadoria() {
        return aposentadoria;
    }

    public void setAposentadoria(boolean aposentadoria) {
        this.aposentadoria = aposentadoria;
    }

    public boolean isDisposicao() {
        return disposicao;
    }

    public void setDisposicao(boolean disposicao) {
        this.disposicao = disposicao;
    }

    public boolean isEnquadramento() {
        return enquadramento;
    }

    public void setEnquadramento(boolean enquadramento) {
        this.enquadramento = enquadramento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ModuloSFPOcorrencia other = (ModuloSFPOcorrencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
