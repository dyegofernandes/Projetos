/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.enums.FinanceiroMovimento;
import br.gov.pi.siste.modelo.cadastro.enums.Ocorrencia;
import br.gov.pi.siste.modelo.cadastro.enums.TipoPessoa;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Movimento implements Serializable {

    @Id
    @SequenceGenerator(name = "Movimento", allocationSize = 1, sequenceName = "seq_movimento")
    @GeneratedValue(generator = "Movimento")
    private Long id;

    @NotNull
    private TipoPessoa tipo = TipoPessoa.PF;

    @Size(max = 260)
    private String cnpj;

    @Size(max = 260)
    private String razaoSocial;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Servidor servidor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Referencia referencia; //Competência

    @NotNull
    private FinanceiroMovimento financeiro = FinanceiroMovimento.REMUNERACAO_DE_SERVICO_EVENTUAL;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private FontePagador fonte;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private BigDecimal valorBCalc;

    @NotNull
    private BigDecimal desconto1;//inss

    private BigDecimal desconto2;

    @NotNull
    private BigDecimal irrf = BigDecimal.ZERO;

    @NotNull
    private BigDecimal baseIrrf = BigDecimal.ZERO;

    private BigDecimal iss = BigDecimal.ZERO;

    private BigDecimal baseIss = BigDecimal.ZERO;

    private BigDecimal sestSenat = BigDecimal.ZERO;

    private BigDecimal BaseSestSenat = BigDecimal.ZERO;

    private BigDecimal pensao = BigDecimal.ZERO;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private TabelaInss inss;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private TabelaIRRF ir;

    @Size(max = 250)
    @NotBlank
    private String observacao;

    @Size(max = 7)
    private String neMov;

    @Size(max = 7)
    private String nlMov;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private Ocorrencia ocorrencia;

    private boolean travado = false;

    @Temporal(TemporalType.DATE)
    private Date dataInclusao = new Date();

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        if (razaoSocial != null) {
            razaoSocial = razaoSocial.trim().toUpperCase();
        }
        this.razaoSocial = razaoSocial;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorTotalDos11mais20Bruto() {
        BigDecimal total = BigDecimal.ZERO;

        if (valor != null && desconto1 != null && desconto2 != null) {
            total = valor.subtract(desconto1).subtract(desconto2);
        }

        return total;
    }

    public BigDecimal getValorTotalDos11Bruto() {
        BigDecimal total = BigDecimal.ZERO;

        if (valor != null && desconto1 != null) {
            total = valor.subtract(desconto1);
        }

        return total;
    }

    public BigDecimal getValorTotalDos11mais20BCalc() {
        BigDecimal total = BigDecimal.ZERO;

        if (valor != null && desconto1 != null && desconto2 != null) {
            total = valor.subtract(desconto1).subtract(desconto2);
        }

        return total;
    }

    public BigDecimal getValorTotalDos11BCalc() {
        BigDecimal total = BigDecimal.ZERO;

        if (valor != null && desconto1 != null) {
            total = valor.subtract(desconto1);
        }

        return total;
    }

    public BigDecimal getValorLiquido() {
        BigDecimal total = BigDecimal.ZERO;

        if (valor != null) {
            total = total.add(valor);

            if (desconto1 != null) {
                total = total.subtract(desconto1);
            }

//            if (iss != null) {
//                total = total.subtract(iss);
//            }

            if (sestSenat != null) {
                total = total.subtract(sestSenat);
            }

            if (irrf != null) {
                total = total.subtract(irrf);
            }

            if (pensao != null) {
                total = total.subtract(pensao);
            }
        }

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public FinanceiroMovimento getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(FinanceiroMovimento financeiro) {
        this.financeiro = financeiro;
    }

    public BigDecimal getBaseIrrf() {
        return baseIrrf;
    }

    public void setBaseIrrf(BigDecimal baseIrrf) {
        this.baseIrrf = baseIrrf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public BigDecimal getBaseIss() {
        return baseIss;
    }

    public void setBaseIss(BigDecimal baseIss) {
        this.baseIss = baseIss;
    }

    public BigDecimal getBaseSestSenat() {
        return BaseSestSenat;
    }

    public void setBaseSestSenat(BigDecimal BaseSestSenat) {
        this.BaseSestSenat = BaseSestSenat;
    }

    public TabelaInss getInss() {
        return inss;
    }

    public void setInss(TabelaInss inss) {
        this.inss = inss;
    }

    public TabelaIRRF getIr() {
        return ir;
    }

    public void setIr(TabelaIRRF ir) {
        this.ir = ir;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        if (observacao != null) {
            observacao = observacao.trim().toUpperCase();
        }
        this.observacao = observacao;
    }

    public String getNeMov() {
        return neMov;
    }

    public void setNeMov(String neMov) {
        this.neMov = neMov;
    }

    public String getNlMov() {
        return nlMov;
    }

    public void setNlMov(String nlMov) {
        this.nlMov = nlMov;
    }

    public BigDecimal getValorBCalc() {
        return valorBCalc;
    }

    public void setValorBCalc(BigDecimal valorBCalc) {
        this.valorBCalc = valorBCalc;
    }

    public BigDecimal getDesconto1() {
        return desconto1;
    }

    public void setDesconto1(BigDecimal desconto1) {
        this.desconto1 = desconto1;
    }

    public BigDecimal getDesconto2() {
        return desconto2;
    }

    public void setDesconto2(BigDecimal desconto2) {
        this.desconto2 = desconto2;
    }

    public FontePagador getFonte() {
        return fonte;
    }

    public void setFonte(FontePagador fonte) {
        this.fonte = fonte;
    }

    public boolean isTravado() {
        return travado;
    }

    public void setTravado(boolean travado) {
        this.travado = travado;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public BigDecimal getSestSenat() {
        return sestSenat;
    }

    public void setSestSenat(BigDecimal sestSenat) {
        this.sestSenat = sestSenat;
    }

    public BigDecimal getPensao() {
        return pensao;
    }

    public void setPensao(BigDecimal pensao) {
        this.pensao = pensao;
    }

    public BigDecimal getIrrf() {
        return irrf;
    }

    public void setIrrf(BigDecimal irrf) {
        this.irrf = irrf;
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
        final Movimento other = (Movimento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
