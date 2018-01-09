/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.cadastro;

import br.gov.pi.ati.sisforms.modelo.formulario.ControleDeCertificado;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class TipoCertificado implements Serializable {

    @Id
    @SequenceGenerator(name = "TipoCertificado", sequenceName = "tipoCertificado_id_seq")
    @GeneratedValue(generator = "TipoCertificado")
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String sigla;

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotNull
    private Integer validade;

    private boolean ativo = true;
    
    @NotAudited
    @OneToMany(mappedBy = "tipoCertificado")
    private List<ControleDeCertificado> controlesCertificados;

    @Override
    public String toString() {
        return sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValidade() {
        return validade;
    }

    public void setValidade(Integer validade) {
        this.validade = validade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ControleDeCertificado> getControlesCertificados() {
        return controlesCertificados;
    }

    public void setControlesCertificados(List<ControleDeCertificado> controlesCertificados) {
        this.controlesCertificados = controlesCertificados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TipoCertificado other = (TipoCertificado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
