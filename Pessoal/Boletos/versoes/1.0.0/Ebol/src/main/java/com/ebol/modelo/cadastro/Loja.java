/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.cadastro;

import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.venda.OpLancada;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Loja implements Serializable {

    @Id
    @SequenceGenerator(schema="cadastro", allocationSize = 1, name = "Loja", sequenceName = "loja_id_seq")
    @GeneratedValue(generator = "Loja")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Banco banco;

    @Size(max = 50)
    @NotBlank
    private String nome;
   
    @Size(max = 50)
    @NotBlank
    private String razaosocial;

    @Size(max = 16)
    @NotBlank
    private String cnpj;

    @Size(max = 14)
    private String inscricaoEstadual;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

    @Size(max = 50)
    private String endereco;

    @Size(max = 25)
    private String bairro;

    @Size(max = 8)
    private String cep;

    private String latitude;

    private String longitude;

    private boolean ativo = true;
    
    private boolean valida = true;

    @NotAudited
    @OneToMany(mappedBy = "loja_rec")
    private List<Boleto> boletos;
    
    @NotAudited
    @OneToMany(mappedBy = "loja_credito")
    private List<OpLancada> opsLancadas;

    
    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
        this.nome = nome;
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

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<OpLancada> getOpsLancadas() {
        return opsLancadas;
    }

    public void setOpsLancadas(List<OpLancada> opsLancadas) {
        this.opsLancadas = opsLancadas;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Loja other = (Loja) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
