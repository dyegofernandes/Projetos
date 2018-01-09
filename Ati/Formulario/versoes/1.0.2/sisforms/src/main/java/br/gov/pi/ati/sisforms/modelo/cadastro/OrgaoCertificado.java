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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class OrgaoCertificado implements Serializable {

    @Id
    @SequenceGenerator(name = "OrgaoCertificado", sequenceName = "seq_orgaoCertificado")
    @GeneratedValue(generator = "OrgaoCertificado")
    private Long id;

//    @NotBlank
//    @Size(max = 50)
//    private String codigo;

    @Size(max = 50)
    private String cnpj;

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    private String sigla;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<ControleDeCertificado> controlesCertificados;

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(String codigo) {
//        this.codigo = codigo;
//    }

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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<ControleDeCertificado> getControlesCertificados() {
        return controlesCertificados;
    }

    public void setControlesCertificados(List<ControleDeCertificado> controlesCertificados) {
        this.controlesCertificados = controlesCertificados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final OrgaoCertificado other = (OrgaoCertificado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
