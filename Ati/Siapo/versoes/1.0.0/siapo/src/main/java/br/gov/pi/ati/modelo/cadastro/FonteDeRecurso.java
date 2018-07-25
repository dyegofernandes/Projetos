/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.cadastro.enums.TipoDeFonte;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class FonteDeRecurso implements Serializable {

    @Id
    @SequenceGenerator(name = "FonteDeRecurso", sequenceName = "fontederecurso_seq_id")
    @GeneratedValue(generator = "FonteDeRecurso")
    private Long id;

    @NotBlank
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @Size(max = 60)
    @NotBlank
    private String mnemonico;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoDeFonte tipoFonte;

    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoDeFonte grupoDeFonte;

    private boolean ativo = true;

    @OneToMany(mappedBy = "fonteDeRecurso")
    @NotAudited
    private List<ExecucaoOrcamentaria> execucoes;

    @Override
    public String toString() {
        if (codigo != null && nome != null) {
            return codigo.concat(" - ").concat(nome);
        }

        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }

    public GrupoDeFonte getGrupoDeFonte() {
        return grupoDeFonte;
    }

    public void setGrupoDeFonte(GrupoDeFonte grupoDeFonte) {
        this.grupoDeFonte = grupoDeFonte;
    }

    public String getMnemonico() {
        return mnemonico;
    }

    public void setMnemonico(String mnemonico) {
        this.mnemonico = mnemonico;
    }

    public TipoDeFonte getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(TipoDeFonte tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ExecucaoOrcamentaria> getExecucoes() {
        return execucoes;
    }

    public void setExecucoes(List<ExecucaoOrcamentaria> execucoes) {
        this.execucoes = execucoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FonteDeRecurso other = (FonteDeRecurso) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
