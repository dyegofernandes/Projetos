/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.cadastro;

import com.ebol.modelo.enuns.TipoRepasse;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Padrao_Cobranca implements Serializable {

    @Id
    @SequenceGenerator(schema = "cadastro", allocationSize = 1, name = "Padrao_Cobranca", sequenceName = "padrao_cobranca_id_seq")
    @GeneratedValue(generator = "Padrao_Cobranca")
    private Long id;

    @NotNull
    private TipoRepasse tipoRepasse = TipoRepasse.SEMANAL;

    @Size(max = 200)
    @NotBlank
    private String localPagto = "SOMENTE NOS POSTOS PAGCONTAS";

    private String mensagem;

    private String inicioCb = "867";

    private BigDecimal multa = new BigDecimal(2.0);

    private BigDecimal juros = new BigDecimal(0.27);

    private BigDecimal desconto = BigDecimal.ZERO;

    private BigDecimal comissao = new BigDecimal(3.0);

    private boolean retem_comissao = true;

    private boolean retem_cpmf = false;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Padrao_Cobranca other = (Padrao_Cobranca) obj;
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

    public TipoRepasse getTipoRepasse() {
        return tipoRepasse;
    }

    public void setTipoRepasse(TipoRepasse tipoRepasse) {
        this.tipoRepasse = tipoRepasse;
    }

    public String getLocalPagto() {
        return localPagto;
    }

    public void setLocalPagto(String localPagto) {
        this.localPagto = localPagto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getInicioCb() {
        return inicioCb;
    }

    public void setInicioCb(String inicioCb) {
        this.inicioCb = inicioCb;
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

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public boolean isRetem_comissao() {
        return retem_comissao;
    }

    public void setRetem_comissao(boolean retem_comissao) {
        this.retem_comissao = retem_comissao;
    }

    public boolean isRetem_cpmf() {
        return retem_cpmf;
    }

    public void setRetem_cpmf(boolean retem_cpmf) {
        this.retem_cpmf = retem_cpmf;
    }

}
