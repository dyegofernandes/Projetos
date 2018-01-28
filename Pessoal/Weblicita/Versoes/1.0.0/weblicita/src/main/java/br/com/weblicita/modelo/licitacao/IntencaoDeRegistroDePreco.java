/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.licitacao;

import br.com.weblicita.modelo.cadastro.Orgao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class IntencaoDeRegistroDePreco implements Serializable {

    @Id
    @SequenceGenerator(name = "IntencaoDeRegistroDePreco", allocationSize = 1, sequenceName = "intencaoDeRegistroDePreco_id_seq")
    @GeneratedValue(generator = "IntencaoDeRegistroDePreco")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgaoReceptor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PedidoLicitacao objetoDeInteresse;

    @ManyToMany(targetEntity = ItemLicitacao.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ItemLicitacao> itens = new ArrayList<ItemLicitacao>();

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDaManifestacao = new Date();

    @NotBlank
    @Size(max = 250)
    private String nomeSolicitante;

    @NotBlank
    @Size(max = 250)
    private String cargoSolicitante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orgao getOrgaoReceptor() {
        return orgaoReceptor;
    }

    public void setOrgaoReceptor(Orgao orgaoReceptor) {
        this.orgaoReceptor = orgaoReceptor;
    }

    public PedidoLicitacao getObjetoDeInteresse() {
        return objetoDeInteresse;
    }

    public void setObjetoDeInteresse(PedidoLicitacao objetoDeInteresse) {
        this.objetoDeInteresse = objetoDeInteresse;
    }

    public List<ItemLicitacao> getItens() {
        return itens;
    }

    public void setItens(List<ItemLicitacao> itens) {
        this.itens = itens;
    }

    public Date getDataDaManifestacao() {
        return dataDaManifestacao;
    }

    public void setDataDaManifestacao(Date dataDaManifestacao) {
        this.dataDaManifestacao = dataDaManifestacao;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getCargoSolicitante() {
        return cargoSolicitante;
    }

    public void setCargoSolicitante(String cargoSolicitante) {
        this.cargoSolicitante = cargoSolicitante;
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
        final IntencaoDeRegistroDePreco other = (IntencaoDeRegistroDePreco) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
