/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro;

import br.com.aprove.modelo.faturamento.Venda;
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
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class NaturezasDeOperacoes implements Serializable {
    @Id
    @SequenceGenerator(name = "NaturezasDeOperacoes", allocationSize = 1, sequenceName = "seq_naturezasDeOperacoes")
    @GeneratedValue(generator = "NaturezasDeOperacoes")
    private Long id;
    
    @NotNull
    private Long codigo;
    
    @NotBlank
    @Size(max = 50)
    private String nome;
    
    @NotAudited
    @OrderBy("id")
    @OneToMany(mappedBy = "natureza")
    private List<Venda> venda;

    public NaturezasDeOperacoes() {
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final NaturezasDeOperacoes other = (NaturezasDeOperacoes) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
