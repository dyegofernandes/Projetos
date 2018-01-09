/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.faturamento;

import br.com.aprove.modelo.cadastro.enums.Ambiente;
import br.com.aprove.modelo.cadastro.enums.LoteIndicadorProcessamento;
import br.com.aprove.modelo.cadastro.enums.UnidadeFederativa;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class LoteEnvio implements Serializable {

    @Id
    @SequenceGenerator(name = "LoteEnvio", allocationSize = 1, sequenceName = "seq_loteEnvio")
    @GeneratedValue(generator = "LoteEnvio")
    private Long id;

    @NotBlank
    private String versaoEnvio;

    @NotNull
    private LoteIndicadorProcessamento indicadorProcessamento;
    
//    @NotBlank
    private String versaoRetorno;

    @NotNull
    private Ambiente ambiente;

    @NotBlank
    private String versaoAplicacao;

    private String status;

    private String motivo;

    private UnidadeFederativa uf;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRecebimento;

    private String protocoloRecebimentoSincrono;
    
    private String recibo;
    
    private String tempoMedio;
    
    @NotAudited
    @OneToMany(mappedBy = "loteEnvio")
    private List<NotaFiscal> notaFiscal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersaoEnvio() {
        return versaoEnvio;
    }

    public void setVersaoEnvio(String versaoEnvio) {
        this.versaoEnvio = versaoEnvio;
    }

    public LoteIndicadorProcessamento getIndicadorProcessamento() {
        return indicadorProcessamento;
    }

    public void setIndicadorProcessamento(LoteIndicadorProcessamento indicadorProcessamento) {
        this.indicadorProcessamento = indicadorProcessamento;
    }

    public String getVersaoRetorno() {
        return versaoRetorno;
    }

    public void setVersaoRetorno(String versaoRetorno) {
        this.versaoRetorno = versaoRetorno;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return versaoAplicacao;
    }

    public void setVersaoAplicacao(String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public UnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativa uf) {
        this.uf = uf;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getProtocoloRecebimentoSincrono() {
        return protocoloRecebimentoSincrono;
    }

    public void setProtocoloRecebimentoSincrono(String protocoloRecebimentoSincrono) {
        this.protocoloRecebimentoSincrono = protocoloRecebimentoSincrono;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(String tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public List<NotaFiscal> getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(List<NotaFiscal> notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final LoteEnvio other = (LoteEnvio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
