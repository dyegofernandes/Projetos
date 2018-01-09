/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.passelivre.modelo.cadastro;

import br.gov.pi.ati.passelivre.modelo.enums.TipoEndereco;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @SequenceGenerator(name = "Endereco", sequenceName = "endereco_id_seq")
    @GeneratedValue(generator = "Endereco")
    private Long id;

//    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipo_endereco;

    @Size(max = 256)
    @NotBlank(message = "A descrição do Bairro é Obrigatória!")
    private String logradouro;

    @Size(max = 256)
    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull
    private Bairro bairro;

    @Size(max = 10)
    @NotBlank
    private String cep;

    @Size(max = 10)
    @NotBlank
    private String fone1;

    @Size(max = 10)
    @NotBlank
    private String fone2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEndereco getTipo_endereco() {
        return tipo_endereco;
    }

    public void setTipo_endereco(TipoEndereco tipo_endereco) {
        this.tipo_endereco = tipo_endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
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
        final Endereco other = (Endereco) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
