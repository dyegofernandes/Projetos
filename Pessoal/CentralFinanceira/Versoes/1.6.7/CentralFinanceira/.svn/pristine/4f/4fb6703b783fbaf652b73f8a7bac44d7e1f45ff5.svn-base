/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.financeiro;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Cliente;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
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
 * dbo.CRS
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class CentroResultados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @Size(max = 40)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private CentroResultados centroResultadoMae;

    @NotAudited
    @OneToMany(mappedBy = "centroResultadoMae")
    private List<CentroResultados> centros;

    private boolean inativo = false;

    @NotAudited
    @OneToMany(mappedBy = "centroResultado")
    private List<ContasAPagar> contasAPaga;
    
    @NotAudited
    @OneToMany(mappedBy = "centroResultados")
    private List<Cliente> clientes;

    @NotAudited
    @OneToMany(mappedBy = "centroResultado")
    private List<Lancamentos> lancamentos;
    
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

    public CentroResultados getCentroResultadoMae() {
        return centroResultadoMae;
    }

    public void setCentroResultadoMae(CentroResultados centroResultadoMae) {
        this.centroResultadoMae = centroResultadoMae;
    }

    public List<CentroResultados> getCentros() {
        return centros;
    }

    public void setCentros(List<CentroResultados> centros) {
        this.centros = centros;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public List<ContasAPagar> getContasAPaga() {
        return contasAPaga;
    }

    public void setContasAPaga(List<ContasAPagar> contasAPaga) {
        this.contasAPaga = contasAPaga;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Lancamentos> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamentos> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final CentroResultados other = (CentroResultados) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
