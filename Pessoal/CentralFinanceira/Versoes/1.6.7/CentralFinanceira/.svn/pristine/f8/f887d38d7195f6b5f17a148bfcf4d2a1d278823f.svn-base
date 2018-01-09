/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * dbo.COB
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class AgenteCobrador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @Size(max = 40)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Banco banco;

    @Size(max = 4)
    private String prefAg;

    @Size(max = 1)
    private String dVPrefAg;

    @Size(max = 12)
    private String conta;

    @Size(max = 2)
    private String dvConta;

    @Size(max = 20)
    private String convenio;

    private Integer idBloquete;

    @Size(max = 20)
    private String bloqueteInico;

    @Size(max = 20)
    private String bloqueteFim;

    private Integer sequencialRemessa;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContaFinanceira contaFinanceira;

    @Size(max = 5)
    private String codigoResponsab;

    @Size(max = 1)
    private String codigoResponsabDV;

    @Size(max = 6)
    private String bordero;

    @Max(value = 99)
    private Integer diasProtesto;

    @ManyToOne(fetch = FetchType.LAZY)
    private InstrucaoCobranca instrucao1;

    @ManyToOne(fetch = FetchType.LAZY)
    private InstrucaoCobranca instrucao2;

    @Size(max = 6)
    private String convenente;

    @Size(max = 8)
    private String contratoCalcao;

    private Integer diasMulta;

    @NotAudited
    @OneToMany(mappedBy = "agenteCobrador")
    private List<Cliente> clientes;

    @Override
    public String toString() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getPrefAg() {
        return prefAg;
    }

    public void setPrefAg(String prefAg) {
        this.prefAg = prefAg;
    }

    public String getdVPrefAg() {
        return dVPrefAg;
    }

    public void setdVPrefAg(String dVPrefAg) {
        this.dVPrefAg = dVPrefAg;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getDvConta() {
        return dvConta;
    }

    public void setDvConta(String dvConta) {
        this.dvConta = dvConta;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Integer getIdBloquete() {
        return idBloquete;
    }

    public void setIdBloquete(Integer idBloquete) {
        this.idBloquete = idBloquete;
    }

    public String getBloqueteInico() {
        return bloqueteInico;
    }

    public void setBloqueteInico(String bloqueteInico) {
        this.bloqueteInico = bloqueteInico;
    }

    public String getBloqueteFim() {
        return bloqueteFim;
    }

    public void setBloqueteFim(String bloqueteFim) {
        this.bloqueteFim = bloqueteFim;
    }

    public Integer getSequencialRemessa() {
        return sequencialRemessa;
    }

    public void setSequencialRemessa(Integer sequencialRemessa) {
        this.sequencialRemessa = sequencialRemessa;
    }

    public ContaFinanceira getContaFinanceira() {
        return contaFinanceira;
    }

    public void setContaFinanceira(ContaFinanceira contaFinanceira) {
        this.contaFinanceira = contaFinanceira;
    }

    public String getCodigoResponsab() {
        return codigoResponsab;
    }

    public void setCodigoResponsab(String codigoResponsab) {
        this.codigoResponsab = codigoResponsab;
    }

    public String getCodigoResponsabDV() {
        return codigoResponsabDV;
    }

    public void setCodigoResponsabDV(String codigoResponsabDV) {
        this.codigoResponsabDV = codigoResponsabDV;
    }

    public String getBordero() {
        return bordero;
    }

    public void setBordero(String bordero) {
        this.bordero = bordero;
    }

    public Integer getDiasProtesto() {
        return diasProtesto;
    }

    public void setDiasProtesto(Integer diasProtesto) {
        this.diasProtesto = diasProtesto;
    }

    public InstrucaoCobranca getInstrucao1() {
        return instrucao1;
    }

    public void setInstrucao1(InstrucaoCobranca instrucao1) {
        this.instrucao1 = instrucao1;
    }

    public InstrucaoCobranca getInstrucao2() {
        return instrucao2;
    }

    public void setInstrucao2(InstrucaoCobranca instrucao2) {
        this.instrucao2 = instrucao2;
    }

    public String getConvenente() {
        return convenente;
    }

    public void setConvenente(String convenente) {
        this.convenente = convenente;
    }

    public String getContratoCalcao() {
        return contratoCalcao;
    }

    public void setContratoCalcao(String contratoCalcao) {
        this.contratoCalcao = contratoCalcao;
    }

    public Integer getDiasMulta() {
        return diasMulta;
    }

    public void setDiasMulta(Integer diasMulta) {
        this.diasMulta = diasMulta;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AgenteCobrador other = (AgenteCobrador) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
