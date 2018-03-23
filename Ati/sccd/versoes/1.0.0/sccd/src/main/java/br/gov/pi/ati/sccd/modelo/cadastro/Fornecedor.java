/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.cadastro;

import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Fornecedor implements Serializable {

    @Id
    @SequenceGenerator(name = "Fornecedor", sequenceName = "fornecedor_id_seq")
    @GeneratedValue(generator = "Fornecedor")
    private Long id;

    @Size(max = 250)
    @NotBlank
    private String cnpj;

    @Size(max = 250)
    @NotBlank
    private String nome;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<ContratoFornecedor> contratos;
    
    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<AutoridadeCertificadora> autoridades;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public List<ContratoFornecedor> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoFornecedor> contratos) {
        this.contratos = contratos;
    }

    public List<AutoridadeCertificadora> getAutoridades() {
        return autoridades;
    }

    public void setAutoridades(List<AutoridadeCertificadora> autoridades) {
        this.autoridades = autoridades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
