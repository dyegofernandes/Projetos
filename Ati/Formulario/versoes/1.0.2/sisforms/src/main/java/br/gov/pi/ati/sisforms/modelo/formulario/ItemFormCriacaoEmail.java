/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Juniel
 */
@Entity
public class ItemFormCriacaoEmail implements Serializable {

    @Id
    @SequenceGenerator(name = "ItemFormCriacaoEmail", sequenceName = "seq_itemFormCriacaoEmail")
    @GeneratedValue(generator = "ItemFormCriacaoEmail")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private FormCriacaoEmail formCriacaoEmail;

    @Size(max = 255)
    @NotBlank
    private String nomeCompleto;

    @Size(max = 20)
    @NotBlank
    @CPF
    private String cpf;

    @Size(max = 50)
    private String rg;

    @Size(max = 255)
    private String endereco;

    @Size(max = 20)
    @NotBlank
    private String telefone;

    @Size(max = 250)
    private String emailPessoal;

    @Size(max = 250)
    private String matriculaEstado;

    @Size(max = 250)
    private String cargo;

    public ItemFormCriacaoEmail() {
    }

    public ItemFormCriacaoEmail(Long id, FormCriacaoEmail formCriacaoEmail, String nomeCompleto, String cpf, String rg, String endereco, String telefone, String emailPessoal, String matriculaEstado, String cargo) {
        this.id = id;
        this.formCriacaoEmail = formCriacaoEmail;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emailPessoal = emailPessoal;
        this.matriculaEstado = matriculaEstado;
        this.cargo = cargo;
    }

    public FormCriacaoEmail getFormCriacaoEmail() {
        return formCriacaoEmail;
    }

    public void setFormCriacaoEmail(FormCriacaoEmail formCriacaoEmail) {
        this.formCriacaoEmail = formCriacaoEmail;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getMatriculaEstado() {
        return matriculaEstado;
    }

    public void setMatriculaEstado(String matriculaEstado) {
        this.matriculaEstado = matriculaEstado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ItemFormCriacaoEmail other = (ItemFormCriacaoEmail) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
