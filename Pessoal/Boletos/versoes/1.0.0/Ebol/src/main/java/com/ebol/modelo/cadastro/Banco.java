/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.cadastro;

import com.ebol.modelo.controleacesso.Usuario;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Banco implements Serializable {

    @Id
    @SequenceGenerator(schema = "cadastro", allocationSize = 1, name = "Banco", sequenceName = "banco_id_seq")
    @GeneratedValue(generator = "Banco")
    private Long id;

    @Size(max = 16)
    @NotBlank
    private String cnpj;
    
    @Size(max = 50)
    @NotBlank
    private String razaoSocial;
    
    @Size(max = 50)
    @NotBlank
    private String nomeFantasia;

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

    private boolean ativo = true;
    
    @NotAudited
    @OneToMany(mappedBy = "banco")
    private List<Usuario> usuarios;
    
    @NotAudited
    @OneToMany(mappedBy = "banco")
    private List<Convenio> convenios;
    
    @NotAudited
    @OneToMany(mappedBy = "banco")
    private List<Loja> lojas;

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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

    @Override
    public String toString() {
        return (cnpj.length() > 11 ? format("##.###.###/####-##", cnpj) : format("###.###.###-##", cnpj))
                .concat(" - ").concat(razaoSocial);
    }

    public String formtCpfOrCnpj(String x) {
        return (cnpj.length() > 11 ? format("##.###.###/####-##", cnpj) : format("###.###.###-##", cnpj));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Banco other = (Banco) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    private String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
