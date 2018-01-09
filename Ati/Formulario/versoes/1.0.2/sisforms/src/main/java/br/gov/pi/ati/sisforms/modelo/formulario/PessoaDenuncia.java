/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class PessoaDenuncia implements Serializable {

    @Id
    @SequenceGenerator(name = "PessoaDenuncia", sequenceName = "seq_pessoaDenuncia")
    @GeneratedValue(generator = "PessoaDenuncia")
    private Long id;

    @Size(max = 255)
    private String nome;

    private Integer idade;

    @Size(max = 255)
    private String endereco;

    @Size(max = 255)
    private String bairro;

    @Size(max = 255)
    private String pontoDeReferencia;

    @Size(max = 255)
    private String telefone;

    @NotAudited
    @OneToMany(mappedBy = "identificacaoVitima")
    private List<FormularioDeDenunciaLGBT> identicacoesVitimas;

    @NotAudited
    @OneToMany(mappedBy = "pessoaDenunciada")
    private List<FormularioDeDenunciaLGBT> pessoasDenunciadas;

    @NotAudited
    @OneToMany(mappedBy = "pessoaDenunciante")
    private List<FormularioDeDenunciaLGBT> pessoasDenunciantes;

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
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PessoaDenuncia other = (PessoaDenuncia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
