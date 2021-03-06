/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.central;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ConvenioSite;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Loja;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema="financeira")
public class FatosBoletoSite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer qtd;
    
    @NotNull
    private Integer periodo;
  
    private BigDecimal arrecadado;

    private BigDecimal unitarioconvenio;

    private BigDecimal unitarioloja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConvenioSite conveniosite;

//   @Transient
    public BigDecimal getUnitarioLiquido() {
        if (unitarioconvenio != null && unitarioloja != null) {
            return this.unitarioconvenio.subtract(this.unitarioloja);

        }
        return BigDecimal.ZERO;
    }
    
//    @Transient
    public BigDecimal getComissaoConvenio() {
        if (unitarioconvenio != null && qtd != null) {
            return this.unitarioconvenio.multiply(new BigDecimal(this.qtd));

        }
        return BigDecimal.ZERO;
    }
    
    //@Transient
    public BigDecimal getComissaoLoja() {
        if (unitarioloja != null && qtd != null) {
            return this.unitarioloja.multiply(new BigDecimal(this.qtd));

        }
        return BigDecimal.ZERO;
    }
    
    //@Transient
    public BigDecimal getComissaoLiquida() {
        return getComissaoConvenio().subtract(getComissaoLoja());
    }

    public BigDecimal getArrecadado() {
        return arrecadado;
    }

    public void setArrecadado(BigDecimal arrecadado) {
        this.arrecadado = arrecadado;
    }

    public BigDecimal getUnitarioconvenio() {
        return unitarioconvenio;
    }

    public void setUnitarioconvenio(BigDecimal unitarioconvenio) {
        this.unitarioconvenio = unitarioconvenio;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public ConvenioSite getConveniosite() {
        return conveniosite;
    }

    public void setConveniosite(ConvenioSite conveniosite) {
        this.conveniosite = conveniosite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getUnitarioloja() {
        return unitarioloja;
    }

    public void setUnitarioloja(BigDecimal unitarioloja) {
        this.unitarioloja = unitarioloja;
    }
    
      public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FatosBoletoSite)) {
            return false;
        }
        FatosBoletoSite other = (FatosBoletoSite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }    

}
