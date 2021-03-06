/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import br.com.jsoft.centralfinanceira.modelo.central.FatosRecarga;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class ConvenioRecarga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    private BigDecimal tarifa;

    @NotAudited
    @OneToMany(mappedBy = "conveniorecarga")
    private List<FatosRecarga> fatosboletos;
    
    @NotAudited
    @OneToMany(mappedBy = "conveniorecarga")
    private List<ComissaoRecargaGrupoLoja> comissoes;

    public ConvenioRecarga() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public List<FatosRecarga> getFatosboletos() {
        return fatosboletos;
    }

    public void setFatosboletos(List<FatosRecarga> fatosboletos) {
        this.fatosboletos = fatosboletos;
    }

    public List<ComissaoRecargaGrupoLoja> getComissoes() {
        return comissoes;
    }

    public void setComissoes(List<ComissaoRecargaGrupoLoja> comissoes) {
        this.comissoes = comissoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ConvenioRecarga other = (ConvenioRecarga) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
    
    
}
