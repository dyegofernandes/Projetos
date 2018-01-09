/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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

    @Size(max = 260)
    @NotBlank
    private String endereco;

    @Size(max = 60)
    @NotBlank(message = "O número de Endereço é Obrigatório!")
    private String numero;

    @Size(max = 260)
    private String complemento;

    @Size(max = 256)
    @NotBlank
    private String bairro;

    @Size(max = 256)
    @NotBlank
    private String cidade;

    @Size(max = 60)
    @NotBlank(message = "O cep de Endereço é Obrigatório!")
    private String cep;
    
//    @NotBlank
    private String latitude;
    
//    @NotBlank
    private String longitude;

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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if (complemento != null) {
            complemento = complemento.trim().toUpperCase();
        }
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
