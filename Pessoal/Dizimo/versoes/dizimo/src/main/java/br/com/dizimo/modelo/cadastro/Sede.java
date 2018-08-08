/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.cadastro;

import br.com.dizimo.modelo.controleacesso.Usuario;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Sede implements Serializable {

    @Id
    @SequenceGenerator(name = "Sede", sequenceName = "sede_seq_id")
    @GeneratedValue(generator = "Sede")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sede sedePai;

    @Size(max = 250)
    @NotBlank
    private String nomeFantasia;

    @Size(max = 250)
    @NotBlank
    private String razaoSocial;

    @Size(max = 50)
    @NotBlank
    private String cnpj;

    @Size(max = 250)
    private String telefones;

    @Size(max = 250)
    private String emails;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();
    
    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "sedePai")
    private List<Sede> sedeFilhas;
    
    @NotAudited
    @OneToMany(mappedBy = "sede")
    private List<Usuario> usuarios;

    @Override
    public String toString() {
        return nomeFantasia; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sede getSedePai() {
        return sedePai;
    }

    public void setSedePai(Sede sedePai) {
        this.sedePai = sedePai;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Sede> getSedeFilhas() {
        return sedeFilhas;
    }

    public void setSedeFilhas(List<Sede> sedeFilhas) {
        this.sedeFilhas = sedeFilhas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Sede other = (Sede) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
