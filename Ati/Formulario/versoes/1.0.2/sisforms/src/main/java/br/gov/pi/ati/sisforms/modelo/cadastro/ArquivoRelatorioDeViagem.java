/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.cadastro;

import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ArquivoRelatorioDeViagem implements Serializable {

    @Id
    @SequenceGenerator(name = "ArquivoRelatorioDeViagem", allocationSize = 1, sequenceName = "seq_arquivoRelatorioDeViagem")
    @GeneratedValue(generator = "ArquivoRelatorioDeViagem")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private RelatorioDeViagem relatorioDeViagem;

    @NotBlank
    private String nome;

    @NotBlank
    private String extensao;

    @NotBlank
    @Column(columnDefinition = "Text")
    private String conteudo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelatorioDeViagem getRelatorioDeViagem() {
        return relatorioDeViagem;
    }

    public void setRelatorioDeViagem(RelatorioDeViagem relatorioDeViagem) {
        this.relatorioDeViagem = relatorioDeViagem;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ArquivoRelatorioDeViagem other = (ArquivoRelatorioDeViagem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
