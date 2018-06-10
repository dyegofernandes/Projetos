/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados;

import br.com.facilpagar.modelo.enums.SituacaoBoleto;
import br.com.facilpagar.modelo.enums.SituacaoRegistro;
import br.com.facilpagar.modelo.enums.TipoRepasse;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(schema = "dados")
public class Boleto implements Serializable {

    @Id
    @SequenceGenerator(schema = "dados", allocationSize = 1, name = "Boleto", sequenceName = "dados.seq_boleto_id")
    @GeneratedValue(generator = "Boleto")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Banco banco;

    @Size(max = 44)
    @NotBlank
    private String cb;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TipoRepasse tiporepasse = TipoRepasse.S;

    @NotNull
    private Long nossonumero;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dt_criacao = new Date();

    @Temporal(TemporalType.DATE)
    private Date dt_baixado;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dt_vencimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_impressao;

    @Temporal(TemporalType.DATE)
    private Date dt_adepositar;

    private boolean deposito_gerado = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Deposito deposito;

    @Size(max = 100)
//    @NotBlank
    private String instrucao_exclusiva;

    @NotNull
    private BigDecimal vl_juros = BigDecimal.ZERO;

    @NotNull
    private BigDecimal vl_multa;

    @NotNull
    private BigDecimal vl_desconto = BigDecimal.ZERO;

    @NotNull
    private BigDecimal vl_nominal;

    @NotNull
    private BigDecimal vl_recebido = BigDecimal.ZERO;

    @NotNull
    private BigDecimal vl_tarifa = BigDecimal.ZERO;

    @NotNull
    private Integer nr_parcela = 1;

    @NotNull
    private Integer qtd_total_parcela = 1;

    @Size(max = 100)
    @NotBlank
    private String referentea;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private SituacaoBoleto situacao = SituacaoBoleto.EM_ABERTO;
    
    @Column(columnDefinition = "Text")
    private String motivo_recusa;
    
    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private SituacaoRegistro situacao_registro = SituacaoRegistro.NAO_REGISTRADO;

    private boolean travado = false;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public TipoRepasse getTiporepasse() {
        return tiporepasse;
    }

    public void setTiporepasse(TipoRepasse tiporepasse) {
        this.tiporepasse = tiporepasse;
    }

    public Long getNossonumero() {
        return nossonumero;
    }

    public void setNossonumero(Long nossonumero) {
        this.nossonumero = nossonumero;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Date getDt_baixado() {
        return dt_baixado;
    }

    public void setDt_baixado(Date dt_baixado) {
        this.dt_baixado = dt_baixado;
    }

    public Date getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public Date getDt_impressao() {
        return dt_impressao;
    }

    public void setDt_impressao(Date dt_impressao) {
        this.dt_impressao = dt_impressao;
    }

    public Date getDt_adepositar() {
        return dt_adepositar;
    }

    public void setDt_adepositar(Date dt_adepositar) {
        this.dt_adepositar = dt_adepositar;
    }

    public boolean isDeposito_gerado() {
        return deposito_gerado;
    }

    public void setDeposito_gerado(boolean deposito_gerado) {
        this.deposito_gerado = deposito_gerado;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public String getInstrucao_exclusiva() {
        return instrucao_exclusiva;
    }

    public void setInstrucao_exclusiva(String instrucao_exclusiva) {
        this.instrucao_exclusiva = instrucao_exclusiva;
    }

    public BigDecimal getVl_juros() {
        return vl_juros;
    }

    public void setVl_juros(BigDecimal vl_juros) {
        this.vl_juros = vl_juros;
    }

    public BigDecimal getVl_multa() {
        return vl_multa;
    }

    public void setVl_multa(BigDecimal vl_multa) {
        this.vl_multa = vl_multa;
    }

    public BigDecimal getVl_desconto() {
        return vl_desconto;
    }

    public void setVl_desconto(BigDecimal vl_desconto) {
        this.vl_desconto = vl_desconto;
    }

    public BigDecimal getVl_nominal() {
        return vl_nominal;
    }

    public void setVl_nominal(BigDecimal vl_nominal) {
        this.vl_nominal = vl_nominal;
    }

    public BigDecimal getVl_recebido() {
        return vl_recebido;
    }

    public void setVl_recebido(BigDecimal vl_recebido) {
        this.vl_recebido = vl_recebido;
    }

    public BigDecimal getVl_tarifa() {
        return vl_tarifa;
    }

    public void setVl_tarifa(BigDecimal vl_tarifa) {
        this.vl_tarifa = vl_tarifa;
    }

    public Integer getNr_parcela() {
        return nr_parcela;
    }

    public void setNr_parcela(Integer nr_parcela) {
        this.nr_parcela = nr_parcela;
    }

    public Integer getQtd_total_parcela() {
        return qtd_total_parcela;
    }

    public void setQtd_total_parcela(Integer qtd_total_parcela) {
        this.qtd_total_parcela = qtd_total_parcela;
    }

    public String getReferentea() {
        return referentea;
    }

    public void setReferentea(String referentea) {
        this.referentea = referentea;
    }

    public SituacaoBoleto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoBoleto situacao) {
        this.situacao = situacao;
    }

    public boolean isTravado() {
        return travado;
    }

    public void setTravado(boolean travado) {
        this.travado = travado;
    }

    public String getMotivo_recusa() {
        return motivo_recusa;
    }

    public void setMotivo_recusa(String motivo_recusa) {
        this.motivo_recusa = motivo_recusa;
    }

    public SituacaoRegistro getSituacao_registro() {
        return situacao_registro;
    }

    public void setSituacao_registro(SituacaoRegistro situacao_registro) {
        this.situacao_registro = situacao_registro;
    }

    public BigDecimal getVl_deposito() {
        BigDecimal vl_deposito = BigDecimal.ZERO;

        if (vl_recebido != null && vl_tarifa != null) {
            return vl_recebido.subtract(vl_tarifa);
        }

        return vl_deposito;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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

}
