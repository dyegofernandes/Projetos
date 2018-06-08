/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "dados")
public class Produto implements Serializable {

    @Id
    @SequenceGenerator(schema ="dados",allocationSize = 1, name = "Produto", sequenceName = "dados.seq_produto_id")
    @GeneratedValue(generator = "Produto")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;
    
    @NotNull
    private BigDecimal valor_base;

    @Size(max = 50)
    @NotBlank
    private String nome;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "produto")
    private List<Boleto> boletos;
    
    @Override
    public String toString() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValor_base() {
        return valor_base;
    }

    public void setValor_base(BigDecimal valor_base) {
        this.valor_base = valor_base;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
