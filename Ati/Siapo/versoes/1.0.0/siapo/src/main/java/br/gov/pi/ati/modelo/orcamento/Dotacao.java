/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Dotacao implements Serializable {

    @Id
    @SequenceGenerator(name = "Dotacao", sequenceName = "dotacao_id_seq")
    @GeneratedValue(generator = "Dotacao")
    private Long id;
    
//    @ManyToOne
//    @JoinTable(name="depesapublica_dotacao",
//    joinColumns={@JoinColumn(name="dotacao_id")},
//    inverseJoinColumns={@JoinColumn(name="despesapublica_id")})
//    private DespesaPublica despesaPublica;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExecucaoOrcamentaria execucaoOrcamentaria;

    @ManyToMany(targetEntity = ProgramacaoFinanceira.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ProgramacaoFinanceira> programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

    @ManyToOne(fetch = FetchType.LAZY)
    private MetaProduto produtoLDO;

    @NotNull
    private BigDecimal quantidadeRealizada = BigDecimal.ZERO;

    @NotNull
    private BigDecimal metaAcumulada = BigDecimal.ZERO;

    @NotBlank
    @Size(max = 3)
    private String subelemento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHomologacao;

    private boolean homologado = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario responsavel;

    @ManyToMany(targetEntity = Municipio.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Municipio> cidades = new ArrayList<Municipio>();

    private boolean geraQuantificador = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProgramacaoFinanceira> getProgramacaoFinanceira() {
        return programacaoFinanceira;
    }

    public void setProgramacaoFinanceira(List<ProgramacaoFinanceira> programacaoFinanceira) {
        this.programacaoFinanceira = programacaoFinanceira;
    }

    public MetaProduto getProdutoLDO() {
        return produtoLDO;
    }

    public void setProdutoLDO(MetaProduto produtoLDO) {
        this.produtoLDO = produtoLDO;
    }

    public BigDecimal getQuantidadeRealizada() {
        return quantidadeRealizada;
    }

    public void setQuantidadeRealizada(BigDecimal quantidadeRealizada) {
        this.quantidadeRealizada = quantidadeRealizada;
    }

    public List<Municipio> getCidades() {
        return cidades;
    }

    public void setCidades(List<Municipio> cidades) {
        this.cidades = cidades;
    }

    public boolean isGeraQuantificador() {
        return geraQuantificador;
    }

    public void setGeraQuantificador(boolean geraQuantificador) {
        this.geraQuantificador = geraQuantificador;
    }

    public String getSubelemento() {
        return subelemento;
    }

    public void setSubelemento(String subelemento) {
        this.subelemento = subelemento;
    }

    public Date getDataHomologacao() {
        return dataHomologacao;
    }

    public void setDataHomologacao(Date dataHomologacao) {
        this.dataHomologacao = dataHomologacao;
    }

    public boolean isHomologado() {
        return homologado;
    }

    public void setHomologado(boolean homologado) {
        this.homologado = homologado;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public ExecucaoOrcamentaria getExecucaoOrcamentaria() {
        return execucaoOrcamentaria;
    }

    public void setExecucaoOrcamentaria(ExecucaoOrcamentaria execucaoOrcamentaria) {
        this.execucaoOrcamentaria = execucaoOrcamentaria;
    }

    public BigDecimal getGAP() {
        BigDecimal valor = BigDecimal.ZERO;

        if (quantidadeRealizada != null && metaAcumulada != null) {
            valor = valor.add(quantidadeRealizada).subtract(metaAcumulada);
        }

        return valor;
    }

    public BigDecimal getMetaAcumulada() {
        return metaAcumulada;
    }

    public void setMetaAcumulada(BigDecimal metaAcumulada) {
        this.metaAcumulada = metaAcumulada;
    }

//    public DespesaPublica getDespesaPublica() {
//        return despesaPublica;
//    }
//
//    public void setDespesaPublica(DespesaPublica despesaPublica) {
//        this.despesaPublica = despesaPublica;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Dotacao other = (Dotacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
