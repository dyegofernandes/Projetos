/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class SecoesProduto implements Serializable {
    @Id
    @SequenceGenerator(name = "SecoesProduto", allocationSize = 1, sequenceName = "seq_secoesProduto")
    @GeneratedValue(generator = "SecoesProduto")
    private Long id;
    
    @NotBlank
    @Size(max = 50)
    private String codigo;
    
    @NotBlank
    @Size(max = 50)
    private String descricao;
    
    @NotAudited
    @OrderBy("codigo")
    @OneToMany(mappedBy = "secao")
    private List<GruposDeSecoes> grupos;
    
//    @NotAudited
//    @OrderBy("descricao")
//    @OneToMany(mappedBy = "secao")
//    private List<Produto> produtos;
       
    public SecoesProduto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<GruposDeSecoes> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<GruposDeSecoes> grupos) {
        this.grupos = grupos;
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
        final SecoesProduto other = (SecoesProduto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
