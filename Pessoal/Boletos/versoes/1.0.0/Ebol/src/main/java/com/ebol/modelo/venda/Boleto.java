/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.venda;

import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.enuns.SituacaoBoleto;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "venda")
public class Boleto implements Serializable {
    @Id
    @SequenceGenerator(schema="venda", allocationSize = 1, name = "Boleto", sequenceName = "boleto_id_seq")
    @GeneratedValue(generator = "Boleto")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Venda venda;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cliente cliente;
    
    private Long nossoNumero;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja_rec;
    
    private boolean travado = false;
    
    @Size(max = 100)
    private String referenteA;
    
    @NotNull
    private Integer parcela = new Integer(1);
    
    private Integer totalParcela = new Integer(1);
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    
    @Size(max = 100)
    private String instrucao_exclusiva;
      
    private BigDecimal valor_cobrado; 
    
    private BigDecimal desconto;
    
    private BigDecimal multa;
    
    private BigDecimal juros;
    
    private SituacaoBoleto situacao = SituacaoBoleto.EMABERTO;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date impressao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date criacao = new Date();
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_baixado;
    
    private BigDecimal valor_recebido;
    
    private BigDecimal tarifa;

    @NotAudited
    @OneToMany(mappedBy = "boleto")
    private List<Credito> creditos;
    
    @NotAudited
    @OneToMany(mappedBy = "boleto")
    private List<Debito> debitos;
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Boleto other = (Boleto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja_rec() {
        return loja_rec;
    }

    public void setLoja_rec(Loja loja_rec) {
        this.loja_rec = loja_rec;
    }

    public boolean isTravado() {
        return travado;
    }

    public void setTravado(boolean travado) {
        this.travado = travado;
    }

    public String getReferenteA() {
        return referenteA;
    }

    public void setReferenteA(String referenteA) {
        this.referenteA = referenteA;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getInstrucao_exclusiva() {
        return instrucao_exclusiva;
    }

    public void setInstrucao_exclusiva(String instrucao_exclusiva) {
        this.instrucao_exclusiva = instrucao_exclusiva;
    }

    public BigDecimal getValor_cobrado() {
        return valor_cobrado;
    }

    public void setValor_cobrado(BigDecimal valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public SituacaoBoleto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoBoleto situacao) {
        this.situacao = situacao;
    }

    public Date getImpressao() {
        return impressao;
    }

    public void setImpressao(Date impressao) {
        this.impressao = impressao;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getData_baixado() {
        return data_baixado;
    }

    public void setData_baixado(Date data_baixado) {
        this.data_baixado = data_baixado;
    }

    public BigDecimal getValor_recebido() {
        return valor_recebido;
    }

    public void setValor_recebido(BigDecimal valor_recebido) {
        this.valor_recebido = valor_recebido;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public List<Credito> getCreditos() {
        return creditos;
    }

    public void setCreditos(List<Credito> creditos) {
        this.creditos = creditos;
    }

    public List<Debito> getDebitos() {
        return debitos;
    }

    public void setDebitos(List<Debito> debitos) {
        this.debitos = debitos;
    }

    public Long getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public Integer getTotalParcela() {
        return totalParcela;
    }

    public void setTotalParcela(Integer totalParcela) {
        this.totalParcela = totalParcela;
    }
    
    
}
