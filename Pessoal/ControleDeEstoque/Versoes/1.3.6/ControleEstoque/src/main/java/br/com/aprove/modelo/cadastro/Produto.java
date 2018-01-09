/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro;

import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import br.com.aprove.modelo.faturamento.Estoque;
import br.com.aprove.modelo.faturamento.ItemPedido;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class Produto implements Serializable {

    @Id
    @SequenceGenerator(name = "Produto", sequenceName = "seq_produto")
    @GeneratedValue(generator = "Produto")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial empresa;

    @NotBlank
    @Size(max = 200)
    private String descricao;

    @NotNull
    @Enumerated
    private UnidadeDeMedida unidadeDeVenda;

    @Enumerated
    private UnidadeDeMedida unidadeDeFracao;

    private BigDecimal qtdFracoes;

    @ManyToOne(fetch = FetchType.LAZY)
    private GruposDeSecoes grupo;

    @NotNull
    private BigDecimal ipi = BigDecimal.ZERO;

    @NotBlank
    @Size(max = 10)
    private String codigoNCM;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInclusao = new Date();

    private boolean ativo = true;
    
    private boolean produtoFracionado = false;

    @NotAudited
    @OrderBy("descricao")
    @OneToMany(mappedBy = "produto")
    private List<Estoque> estoques;
    
    @NotAudited
    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedido;

    @Override
    public String toString() {
        String descricaoProduto = "";

        if (descricao != null) {
            descricaoProduto = descricaoProduto.concat(descricao);
        }

        if (unidadeDeFracao != null) {
            descricaoProduto = descricaoProduto.concat(" - ").concat(unidadeDeFracao.getDescricao()).concat(qtdFracoes.toString());
        } else {
            descricaoProduto = descricaoProduto.concat(" - ").concat(unidadeDeVenda.getDescricao());
        }

        return descricaoProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GruposDeSecoes getGrupo() {
        return grupo;
    }

    public void setGrupo(GruposDeSecoes grupo) {
        this.grupo = grupo;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public Loja_Filial getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Loja_Filial empresa) {
        this.empresa = empresa;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public String getCodigoNCM() {
        return codigoNCM;
    }

    public void setCodigoNCM(String codigoNCM) {
        this.codigoNCM = codigoNCM;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    public UnidadeDeMedida getUnidadeDeFracao() {
        return unidadeDeFracao;
    }

    public void setUnidadeDeFracao(UnidadeDeMedida unidadeDeFracao) {
        this.unidadeDeFracao = unidadeDeFracao;
    }

    public UnidadeDeMedida getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public void setUnidadeDeVenda(UnidadeDeMedida unidadeDeVenda) {
        this.unidadeDeVenda = unidadeDeVenda;
    }

    public BigDecimal getQtdFracoes() {
        return qtdFracoes;
    }

    public void setQtdFracoes(BigDecimal qtdFracoes) {
        this.qtdFracoes = qtdFracoes;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public boolean isProdutoFracionado() {
        return produtoFracionado;
    }

    public void setProdutoFracionado(boolean produtoFracionado) {
        this.produtoFracionado = produtoFracionado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
