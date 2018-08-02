/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.formulario;

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

/**
 *
 * @author Juniel
 */
@Entity
public class ItemFormAcessoConteudo implements Serializable {

    @Id
    @SequenceGenerator(name = "ItemFormAcessoConteudo", sequenceName = "seq_itemFormAcessoConteudo")
    @GeneratedValue(generator = "ItemFormAcessoConteudo")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private FormAcessoConteudo formAcessoConteudo;

    @Size(max = 255)
    @NotBlank
    private String siteAserLiberado;

    @Size(max = 600)
    @NotBlank
    private String descricaoLiberacao;

    public Long getId() {
        return id;
    }

    public FormAcessoConteudo getFormAcessoConteudo() {
        return formAcessoConteudo;
    }

    public void setFormAcessoConteudo(FormAcessoConteudo formAcessoConteudo) {
        this.formAcessoConteudo = formAcessoConteudo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteAserLiberado() {
        return siteAserLiberado;
    }

    public void setSiteAserLiberado(String siteAserLiberado) {
        this.siteAserLiberado = siteAserLiberado;
    }

    public String getDescricaoLiberacao() {
        return descricaoLiberacao;
    }

    public void setDescricaoLiberacao(String descricaoLiberacao) {
        this.descricaoLiberacao = descricaoLiberacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ItemFormAcessoConteudo other = (ItemFormAcessoConteudo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
