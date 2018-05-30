/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private AcaoOrcamentaria acaoOrcamentaria;

    @ManyToOne(fetch = FetchType.LAZY)
    private FonteDeRecurso fonteDeRecurso;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturezaDeDespesa naturezaDaDespesa;

    @ManyToMany(targetEntity = ProgramacaoFinanceira.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ProgramacaoFinanceira> programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

    @ManyToOne(fetch = FetchType.LAZY)
    private MetaProduto produtoLDO;

    private BigDecimal quantidadeRealizada;

    @ManyToMany(targetEntity = Municipio.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Municipio> cidades = new ArrayList<Municipio>();

    private boolean geraQuantificador = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcaoOrcamentaria getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(AcaoOrcamentaria acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    public FonteDeRecurso getFonteDeRecurso() {
        return fonteDeRecurso;
    }

    public void setFonteDeRecurso(FonteDeRecurso fonteDeRecurso) {
        this.fonteDeRecurso = fonteDeRecurso;
    }

    public NaturezaDeDespesa getNaturezaDaDespesa() {
        return naturezaDaDespesa;
    }

    public void setNaturezaDaDespesa(NaturezaDeDespesa naturezaDaDespesa) {
        this.naturezaDaDespesa = naturezaDaDespesa;
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
