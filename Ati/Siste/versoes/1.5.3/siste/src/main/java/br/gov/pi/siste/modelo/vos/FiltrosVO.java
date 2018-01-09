/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.vos;

import java.math.BigDecimal;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.Referencia;

/**
 *
 * @author Juniel
 */
public class FiltrosVO {
    
    private String elementoDespesa;

    private Usuario usuario;

    private String codigo;

    private String codigoUnidade;

    private String codigoOrgao;

    private String cnpjOrgao;

    private String orgaoNome;

    private String cnpjUnidade;

    private String unidadeNome;

    private String cpf;

    private String nome;
    
    private String nomeCargo;

    private Referencia referencia;

    private String descricao;

    private BigDecimal limite;

    private Unidade unidade;

    private Orgao orgao;

    private String pis;

    private String rg;

    private Cargo cargo;

    private Cidade cidade;

    private boolean gfip = false;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCnpjOrgao() {
        return cnpjOrgao;
    }

    public void setCnpjOrgao(String cnpjOrgao) {
        this.cnpjOrgao = cnpjOrgao;
    }

    public String getOrgaoNome() {
        return orgaoNome;
    }

    public void setOrgaoNome(String orgaoNome) {
        this.orgaoNome = orgaoNome;
    }

    public String getCnpjUnidade() {
        return cnpjUnidade;
    }

    public void setCnpjUnidade(String cnpjUnidade) {
        this.cnpjUnidade = cnpjUnidade;
    }

    public String getUnidadeNome() {
        return unidadeNome;
    }

    public void setUnidadeNome(String unidadeNome) {
        this.unidadeNome = unidadeNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(String codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public String getCodigoOrgao() {
        return codigoOrgao;
    }

    public void setCodigoOrgao(String codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public boolean isGfip() {
        return gfip;
    }

    public void setGfip(boolean gfip) {
        this.gfip = gfip;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getElementoDespesa() {
        return elementoDespesa;
    }

    public void setElementoDespesa(String elementoDespesa) {
        this.elementoDespesa = elementoDespesa;
    }

    
}
