/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.cadastro;

import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
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

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    @NotBlank
    private String sigla;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private CidadeRegiao regiao;
    
    @NotAudited
    @OneToMany(mappedBy = "unidade")
    private List<Denuncia> denuncias;

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
        if (nome != null) {
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }

    public CidadeRegiao getRegiao() {
        return regiao;
    }

    public void setRegiao(CidadeRegiao regiao) {
        this.regiao = regiao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if(sigla!=null){
            sigla = sigla.trim().toUpperCase();
        }
        this.sigla = sigla;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
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
