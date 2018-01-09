/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class SituacaoTributaria implements Serializable {
    
    @Id
    @SequenceGenerator(name = "SituacaoTributaria", allocationSize = 1, sequenceName = "seq_situacaoTributaria")
    @GeneratedValue(generator = "SituacaoTributaria")
    private Long id;
    
    @NotNull
    @Size(max = 50)
    private String codigo;
    
    @NotBlank
    @Size(max = 200)
    private String descricao;
    
    private String cSosn;
    
    private String cfopEstadoJur;
    
    private String cfopForaEstadoJur;
    
    private BigDecimal aliquotaIcmsEstadoJur;
    
    private String situacaoTribEstadoJur;
    
    private BigDecimal redBaseCalcIcmsEstadoJur;
    
    private BigDecimal addIcmsSubTribEstadoJur;
    
    private String eCFEstadoJur;
    
    @NotAudited
    @OneToMany(mappedBy = "situacaoTributaria")
    private List<Loja_Filial> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SituacaoTributaria() {
    }

    public String getcSosn() {
        return cSosn;
    }

    public void setcSosn(String cSosn) {
        this.cSosn = cSosn;
    }

    public List<Loja_Filial> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Loja_Filial> produtos) {
        this.produtos = produtos;
    }

    public String getCfopEstadoJur() {
        return cfopEstadoJur;
    }

    public void setCfopEstadoJur(String cfopEstadoJur) {
        this.cfopEstadoJur = cfopEstadoJur;
    }

    public String getCfopForaEstadoJur() {
        return cfopForaEstadoJur;
    }

    public void setCfopForaEstadoJur(String cfopForaEstadoJur) {
        this.cfopForaEstadoJur = cfopForaEstadoJur;
    }

    public BigDecimal getAliquotaIcmsEstadoJur() {
        return aliquotaIcmsEstadoJur;
    }

    public void setAliquotaIcmsEstadoJur(BigDecimal aliquotaIcmsEstadoJur) {
        this.aliquotaIcmsEstadoJur = aliquotaIcmsEstadoJur;
    }

    public String getSituacaoTribEstadoJur() {
        return situacaoTribEstadoJur;
    }

    public void setSituacaoTribEstadoJur(String situacaoTribEstadoJur) {
        this.situacaoTribEstadoJur = situacaoTribEstadoJur;
    }

    public BigDecimal getRedBaseCalcIcmsEstadoJur() {
        return redBaseCalcIcmsEstadoJur;
    }

    public void setRedBaseCalcIcmsEstadoJur(BigDecimal redBaseCalcIcmsEstadoJur) {
        this.redBaseCalcIcmsEstadoJur = redBaseCalcIcmsEstadoJur;
    }

    public BigDecimal getAddIcmsSubTribEstadoJur() {
        return addIcmsSubTribEstadoJur;
    }

    public void setAddIcmsSubTribEstadoJur(BigDecimal addIcmsSubTribEstadoJur) {
        this.addIcmsSubTribEstadoJur = addIcmsSubTribEstadoJur;
    }

    public String geteCFEstadoJur() {
        return eCFEstadoJur;
    }

    public void seteCFEstadoJur(String eCFEstadoJur) {
        this.eCFEstadoJur = eCFEstadoJur;
    }

    @Override
    public String toString() {
        return descricao; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SituacaoTributaria other = (SituacaoTributaria) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
