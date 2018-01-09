/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.enums.Destacar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class GrupoReceitaDespesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @Size(max = 40)
    @NotBlank
    private String nome;

    private Destacar destacar;

    private boolean quebraPagina = false;

    private boolean totalizarResult = false;
    
    @NotAudited
    @OneToMany(mappedBy = "grupo")
    private List<ReceitaDespesa> receitasDespesas;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Destacar getDestacar() {
        return destacar;
    }

    public void setDestacar(Destacar destacar) {
        this.destacar = destacar;
    }

    public boolean isQuebraPagina() {
        return quebraPagina;
    }

    public void setQuebraPagina(boolean quebraPagina) {
        this.quebraPagina = quebraPagina;
    }

    public boolean isTotalizarResult() {
        return totalizarResult;
    }

    public void setTotalizarResult(boolean totalizarResult) {
        this.totalizarResult = totalizarResult;
    }

    public List<ReceitaDespesa> getReceitasDespesas() {
        return receitasDespesas;
    }

    public void setReceitasDespesas(List<ReceitaDespesa> receitasDespesas) {
        this.receitasDespesas = receitasDespesas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final GrupoReceitaDespesa other = (GrupoReceitaDespesa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
