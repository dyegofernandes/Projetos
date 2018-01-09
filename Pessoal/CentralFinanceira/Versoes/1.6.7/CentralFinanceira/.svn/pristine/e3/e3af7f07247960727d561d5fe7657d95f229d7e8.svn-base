/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class GrupoLoja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    @Size(max = 30)
    private String att;

    private boolean juntar = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Banco banco;

    @Size(max = 10)
    private String agencia;

    @Size(max = 15)
    private String conta;

    @Size(max = 15)
    private String tipoConta;

    @Size(max = 50)
    private String titular;

    @NotNull
    private BigDecimal garantia = BigDecimal.ZERO;

    @NotNull
    private BigDecimal iss = BigDecimal.ZERO;
    
    private boolean naodepositar = false;
    
    private String obs;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private CalGuia calguia;
    
    @Temporal(TemporalType.DATE)
    private Date titular_nascimento;
    
    @Size(max = 20)
    private String titular_rg;
    
    @Size(max = 20)
    private String titular_rgemissor;
    
    @Size(max = 11)
    private String titular_cpf;
    
    @Size(max = 100)
    @Email
    private String titular_email;
    
    @Size(max = 100)
    @Email
    private String titular_email2;
    
    @NotNull
    private BigDecimal comissaoOp;
    
    @Size(max = 50)
    private String proprietario;
    
    @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<GrupoLojaCredito> gruposLojaCreditos;
    
    @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<Loja> lojas;
    
    @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<GrupoLojaDebito> gruposLojaDebitos;
    
    @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<ExcexBoleto> excexboletos;
    
    @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<ComissaoCreditoGrupoLoja> comissoesCreditos;
    
     @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<ComissaoRecargaGrupoLoja> comissoesRecargas;
     
     @NotAudited
    @OneToMany(mappedBy = "grupoLoja")
    private List<ComissaoBBGrupoLoja> comissoesBB;

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public boolean isJuntar() {
        return juntar;
    }

    public void setJuntar(boolean juntar) {
        this.juntar = juntar;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getGarantia() {
        return garantia;
    }

    public void setGarantia(BigDecimal garantia) {
        this.garantia = garantia;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public boolean isNaodepositar() {
        return naodepositar;
    }

    public void setNaodepositar(boolean naodepositar) {
        this.naodepositar = naodepositar;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public CalGuia getCalguia() {
        return calguia;
    }

    public void setCalguia(CalGuia calguia) {
        this.calguia = calguia;
    }

    public Date getTitular_nascimento() {
        return titular_nascimento;
    }

    public void setTitular_nascimento(Date titular_nascimento) {
        this.titular_nascimento = titular_nascimento;
    }

    public String getTitular_rg() {
        return titular_rg;
    }

    public void setTitular_rg(String titular_rg) {
        this.titular_rg = titular_rg;
    }

    public String getTitular_rgemissor() {
        return titular_rgemissor;
    }

    public void setTitular_rgemissor(String titular_rgemissor) {
        this.titular_rgemissor = titular_rgemissor;
    }

    public String getTitular_cpf() {
        return titular_cpf;
    }

    public void setTitular_cpf(String titular_cpf) {
        this.titular_cpf = titular_cpf;
    }

    public String getTitular_email() {
        return titular_email;
    }

    public void setTitular_email(String titular_email) {
        this.titular_email = titular_email;
    }

    public String getTitular_email2() {
        return titular_email2;
    }

    public void setTitular_email2(String titular_email2) {
        this.titular_email2 = titular_email2;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public List<GrupoLojaCredito> getGruposLojaCreditos() {
        return gruposLojaCreditos;
    }

    public void setGruposLojaCreditos(List<GrupoLojaCredito> gruposLojaCreditos) {
        this.gruposLojaCreditos = gruposLojaCreditos;
    }

    public List<GrupoLojaDebito> getGruposLojaDebitos() {
        return gruposLojaDebitos;
    }

    public void setGruposLojaDebitos(List<GrupoLojaDebito> gruposLojaDebitos) {
        this.gruposLojaDebitos = gruposLojaDebitos;
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public BigDecimal getComissaoOp() {
        return comissaoOp;
    }

    public void setComissaoOp(BigDecimal comissaoOp) {
        this.comissaoOp = comissaoOp;
    }

    public List<ExcexBoleto> getExcexboletos() {
        return excexboletos;
    }

    public void setExcexboletos(List<ExcexBoleto> excexboletos) {
        this.excexboletos = excexboletos;
    }

    public List<ComissaoCreditoGrupoLoja> getComissoesCreditos() {
        return comissoesCreditos;
    }

    public void setComissoesCreditos(List<ComissaoCreditoGrupoLoja> comissoesCreditos) {
        this.comissoesCreditos = comissoesCreditos;
    }

    public List<ComissaoRecargaGrupoLoja> getComissoesRecargas() {
        return comissoesRecargas;
    }

    public void setComissoesRecargas(List<ComissaoRecargaGrupoLoja> comissoesRecargas) {
        this.comissoesRecargas = comissoesRecargas;
    }

    public List<ComissaoBBGrupoLoja> getComissoesBB() {
        return comissoesBB;
    }

    public void setComissoesBB(List<ComissaoBBGrupoLoja> comissoesBB) {
        this.comissoesBB = comissoesBB;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final GrupoLoja other = (GrupoLoja) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
