/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class DespesaPublica implements Serializable {

    @Id
    @SequenceGenerator(name = "DespesaPublica", sequenceName = "despesaPublica_id_seq")
    @GeneratedValue(generator = "DespesaPublica")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private UnidadeOrcamentaria unidadeOrcamentaria;

    @NotBlank
    @Size(max = 50)
    private String numeroProcesso; //AA.002.1.008295/17

    @NotBlank
    @Column(columnDefinition = "Text")
    private String descricaoDespesa;
    
    @NotBlank
    @Size(max = 100)
    private String resumoDaDespesa;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataCadastro = new Date();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ExecucaoOrcamentaria execucaoOrcamentaria;

    @ManyToMany(targetEntity = ProgramacaoFinanceira.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ProgramacaoFinanceira> programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
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

//    @OneToMany(targetEntity = Dotacao.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @JoinTable(name = "depesapublica_dotacao",
//    joinColumns = { @JoinColumn(name = "despesapublica_id") }, 
//    inverseJoinColumns = { @JoinColumn(name = "dotacao_id") })
//    private List<Dotacao> dotacao = new ArrayList<Dotacao>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnidadeOrcamentaria getUnidadeOrcamentaria() {
        return unidadeOrcamentaria;
    }

    public void setUnidadeOrcamentaria(UnidadeOrcamentaria unidadeOrcamentaria) {
        this.unidadeOrcamentaria = unidadeOrcamentaria;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        if (numeroProcesso != null) {
            numeroProcesso = numeroProcesso.trim().toUpperCase();
        }
        this.numeroProcesso = numeroProcesso;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public String getResumoDaDespesa() {
        return resumoDaDespesa;
    }

    public void setResumoDaDespesa(String resumoDaDespesa) {
        this.resumoDaDespesa = resumoDaDespesa;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ExecucaoOrcamentaria getExecucaoOrcamentaria() {
        return execucaoOrcamentaria;
    }

    public void setExecucaoOrcamentaria(ExecucaoOrcamentaria execucaoOrcamentaria) {
        this.execucaoOrcamentaria = execucaoOrcamentaria;
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

    public BigDecimal getMetaAcumulada() {
        return metaAcumulada;
    }

    public void setMetaAcumulada(BigDecimal metaAcumulada) {
        this.metaAcumulada = metaAcumulada;
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

    @Override
    public String toString() {
        return numeroProcesso;
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
        final DespesaPublica other = (DespesaPublica) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
