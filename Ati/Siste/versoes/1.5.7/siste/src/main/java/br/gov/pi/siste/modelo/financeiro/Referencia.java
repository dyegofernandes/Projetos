/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.financeiro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.gov.pi.siste.modelo.cadastro.enums.StatusReferencia;

/**
 *
 * @author Juniel
 */
@Entity // Competência
public class Referencia implements Serializable {

    @Id
    @SequenceGenerator(name = "Referencia", allocationSize = 1, sequenceName = "seq_referencia")
    @GeneratedValue(generator = "Referencia")
    private Long id;
    
    @NotNull
    private Integer codigo;
    
    @NotNull
    private StatusReferencia status = StatusReferencia.ABERTA;
    
    @Size(max = 120)
    private String obs;
    
    @NotAudited
    @OrderBy("codigo")
    @OneToMany(mappedBy = "referencia")
    private List<Movimento> movimentos;

    @Override
    public String toString() {
        if (codigo == null) {
            return "";
        }
        String valor = codigo + "";

        return getMes(valor).concat("/").concat(getAno(valor));
    }
    
    private String getMes(String periodo) {
        String str = periodo.toString();
        return str.substring(4, 6);
    }

    private String getAno(String periodo) {
        String str = periodo.toString();
        return str.substring(0, 4);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public StatusReferencia getStatus() {
        return status;
    }

    public void setStatus(StatusReferencia status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        if (obs != null) {
            obs = obs.trim().toUpperCase();
        }
        this.obs = obs;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Referencia other = (Referencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
