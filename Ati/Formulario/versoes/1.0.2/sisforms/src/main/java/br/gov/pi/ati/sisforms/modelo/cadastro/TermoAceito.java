/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.cadastro;

import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoInfoFolha;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class TermoAceito implements Serializable {

    @Id
    @SequenceGenerator(name = "TermoAceito", allocationSize = 1, sequenceName = "termoAceito_id_seq")
    @GeneratedValue(generator = "TermoAceito")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataAceitacao = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Termo termo;

    @NotAudited
    @OneToMany(mappedBy = "termoAceito")
    private List<SolicitacaoAcessoInfoFolha> solicitacaoesAcessoInfas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAceitacao() {
        return dataAceitacao;
    }

    public void setDataAceitacao(Date dataAceitacao) {
        this.dataAceitacao = dataAceitacao;
    }

    public Termo getTermo() {
        return termo;
    }

    public void setTermo(Termo termo) {
        this.termo = termo;
    }

    public List<SolicitacaoAcessoInfoFolha> getSolicitacaoesAcessoInfas() {
        return solicitacaoesAcessoInfas;
    }

    public void setSolicitacaoesAcessoInfas(List<SolicitacaoAcessoInfoFolha> solicitacaoesAcessoInfas) {
        this.solicitacaoesAcessoInfas = solicitacaoesAcessoInfas;
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
        final TermoAceito other = (TermoAceito) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
