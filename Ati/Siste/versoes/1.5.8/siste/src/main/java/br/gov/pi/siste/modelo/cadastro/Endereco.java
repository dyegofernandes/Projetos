/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

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
import br.gov.pi.siste.modelo.cadastro.enums.TipoEndereco;

/**
 *
 * @author Juniel
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @SequenceGenerator(name = "Endereco", sequenceName = "seq_endereco")
    @GeneratedValue(generator = "Endereco")
    private Long id;
    
    @NotNull
    private TipoEndereco tipo;

    @Size(max = 260)
    @NotBlank
    private String endereco;
    
    @Size(max = 60)
    @NotBlank(message = "O número de Endereço é Obrigatório!")
    private String numero;
    
    @Size(max = 60)
    @NotBlank(message = "O bairro de Endereço é Obrigatório!")
    private String bairro;

    @Size(max = 260)
    private String complemento;
    
    @Size(max = 60)
    @NotBlank(message = "O cep de Endereço é Obrigatório!")
    private String cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "A Cidade de Endereço é Obrigatória!")
    private Cidade cidade;
       

    @Override
    public String toString() {
        return endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco != null) {
            endereco = endereco.trim().toUpperCase();
        }
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro != null) {
            bairro = bairro.trim().toUpperCase();
        }
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if (complemento != null) {
            complemento = complemento.trim().toUpperCase();
        }
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
