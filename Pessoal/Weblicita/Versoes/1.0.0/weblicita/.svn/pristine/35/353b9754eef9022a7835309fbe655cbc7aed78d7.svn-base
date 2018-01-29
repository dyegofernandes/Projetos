/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.licitacao;

import br.com.weblicita.modelo.cadastro.Documento;
import br.com.weblicita.modelo.cadastro.Item;
import br.com.weblicita.modelo.cadastro.Orgao;
import br.com.weblicita.modelo.cadastro.RubricaOrcamentaria;
import br.com.weblicita.modelo.cadastro.enums.EditaPedido;
import br.com.weblicita.modelo.cadastro.enums.ParecerJuridico;
import br.com.weblicita.modelo.cadastro.enums.SituacaoPedido;
import br.com.weblicita.modelo.controleacesso.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class PedidoLicitacao implements Serializable {

    @Id
    @SequenceGenerator(name = "PedidoLicitacao", allocationSize = 1, sequenceName = "pedidoLicitacao_id_seq")
    @GeneratedValue(generator = "PedidoLicitacao")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private RubricaOrcamentaria rubricaOrcamentaria;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgaoSolicitante;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotBlank
    @Size(max = 60)
    private String codigo;

    @NotBlank
    @Size(max = 60)
    private String numeroProcessoAdministrativo;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataRequisicao;

    @NotBlank
    @Column(columnDefinition = "Text")
    private String objeto;

    @Column(columnDefinition = "Text")
    private String observacao;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDoReqistro = new Date();

    @ManyToMany(targetEntity = ItemLicitacao.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ItemLicitacao> itens = new ArrayList<ItemLicitacao>();

    @ManyToMany(targetEntity = Documento.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Documento> documentos = new ArrayList<Documento>();

    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacaoPedido;

    @Enumerated(EnumType.STRING)
    private EditaPedido editalPedido;

    @Enumerated(EnumType.STRING)
    private ParecerJuridico parecerJuridico;

    @NotBlank
    @Size(max = 250)
    private String nomeSolicitante;

    @NotBlank
    @Size(max = 250)
    private String cargoSolicitante;

    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return numeroProcessoAdministrativo.concat(" - ").concat(objeto.substring(0, objeto.length() < 100 ? objeto.length() : 100));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RubricaOrcamentaria getRubricaOrcamentaria() {
        return rubricaOrcamentaria;
    }

    public void setRubricaOrcamentaria(RubricaOrcamentaria rubricaOrcamentaria) {
        this.rubricaOrcamentaria = rubricaOrcamentaria;
    }

    public Orgao getOrgaoSolicitante() {
        return orgaoSolicitante;
    }

    public void setOrgaoSolicitante(Orgao orgaoSolicitante) {
        this.orgaoSolicitante = orgaoSolicitante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroProcessoAdministrativo() {
        return numeroProcessoAdministrativo;
    }

    public void setNumeroProcessoAdministrativo(String numeroProcessoAdministrativo) {
        this.numeroProcessoAdministrativo = numeroProcessoAdministrativo;
    }

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataDoReqistro() {
        return dataDoReqistro;
    }

    public void setDataDoReqistro(Date dataDoReqistro) {
        this.dataDoReqistro = dataDoReqistro;
    }

    public List<ItemLicitacao> getItens() {
        return itens;
    }

    public void setItens(List<ItemLicitacao> itens) {
        this.itens = itens;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public SituacaoPedido getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(SituacaoPedido situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }

    public EditaPedido getEditalPedido() {
        return editalPedido;
    }

    public void setEditalPedido(EditaPedido editalPedido) {
        this.editalPedido = editalPedido;
    }

    public ParecerJuridico getParecerJuridico() {
        return parecerJuridico;
    }

    public void setParecerJuridico(ParecerJuridico parecerJuridico) {
        this.parecerJuridico = parecerJuridico;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final PedidoLicitacao other = (PedidoLicitacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
