/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Unidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Unidade", sequenceName = "seq_unidade")
    @GeneratedValue(generator = "Unidade")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Orgao orgao;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    @NotBlank
    private String sigla;

    @NotAudited
    @OneToMany(mappedBy = "unidadeOrigem")
    private List<Denuncia> denunciasOrigem;

    @NotAudited
    @OneToMany(mappedBy = "unidadeResponsavel")
    private List<Denuncia> denunciasResponsaveis;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla != null) {
            sigla = sigla.trim().toUpperCase();
        }
        this.sigla = sigla;
    }

    public List<Denuncia> getDenunciasOrigem() {
        return denunciasOrigem;
    }

    public void setDenunciasOrigem(List<Denuncia> denunciasOrigem) {
        this.denunciasOrigem = denunciasOrigem;
    }

    public List<Denuncia> getDenunciasResponsaveis() {
        return denunciasResponsaveis;
    }

    public void setDenunciasResponsaveis(List<Denuncia> denunciasResponsaveis) {
        this.denunciasResponsaveis = denunciasResponsaveis;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
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
        final Unidade other = (Unidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
