/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.modelo.vos;

import br.com.pagcontascarne.modelo.dados.Banco;
import br.com.pagcontascarne.modelo.dados.Cidade;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Deposito;
import br.com.pagcontascarne.modelo.dados.Franquia;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.modelo.dados.Uf;
import br.com.pagcontascarne.modelo.enums.Ativo;
import br.com.pagcontascarne.modelo.enums.SituacaoBoleto;
import br.com.pagcontascarne.modelo.enums.SituacaoDeposito;
import br.com.pagcontascarne.modelo.enums.TipoPessoa;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class FiltrosBusca implements Serializable {
    
    private Franquia franquia;

    private Convenio convenio;

    private Cliente cliente;

    private Banco banco1;

    private Banco banco2;

    private Deposito deposito;

    private String codigo;

    private Produto produto;

    private TipoPessoa tipoPessoa;

    private String cpf_cnpj;

    private String nome_fantasia;

    private String nome_razao_social;

    private String login;

    private String rg_insc_estadual;

    private Date dataInicial1;

    private Date dataFinal1;

    private Date dataInicial2;

    private Date dataFinal2;

    private Date dataInicial3;

    private Date dataFinal3;

    private String endereco;

    private Cidade cidade;

    private String email;

    private Uf estado;

    private String bairro;

    private String telefone;

    private String nome;

    private Ativo ativo;

    private String sigla;

    private SituacaoBoleto situacaoBoleto;

    private SituacaoDeposito situacaoDeposito;

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

    public Banco getBanco1() {
        return banco1;
    }

    public void setBanco1(Banco banco1) {
        this.banco1 = banco1;
    }

    public Banco getBanco2() {
        return banco2;
    }

    public void setBanco2(Banco banco2) {
        this.banco2 = banco2;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getNome_razao_social() {
        return nome_razao_social;
    }

    public void setNome_razao_social(String nome_razao_social) {
        this.nome_razao_social = nome_razao_social;
    }

    public String getRg_insc_estadual() {
        return rg_insc_estadual;
    }

    public void setRg_insc_estadual(String rg_insc_estadual) {
        this.rg_insc_estadual = rg_insc_estadual;
    }

    public Date getDataInicial1() {
        return dataInicial1;
    }

    public void setDataInicial1(Date dataInicial1) {
        this.dataInicial1 = dataInicial1;
    }

    public Date getDataFinal1() {
        return dataFinal1;
    }

    public void setDataFinal1(Date dataFinal1) {
        this.dataFinal1 = dataFinal1;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Uf getEstado() {
        return estado;
    }

    public void setEstado(Uf estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicial2() {
        return dataInicial2;
    }

    public void setDataInicial2(Date dataInicial2) {
        this.dataInicial2 = dataInicial2;
    }

    public Date getDataFinal2() {
        return dataFinal2;
    }

    public void setDataFinal2(Date dataFinal2) {
        this.dataFinal2 = dataFinal2;
    }

    public Date getDataInicial3() {
        return dataInicial3;
    }

    public void setDataInicial3(Date dataInicial3) {
        this.dataInicial3 = dataInicial3;
    }

    public Date getDataFinal3() {
        return dataFinal3;
    }

    public void setDataFinal3(Date dataFinal3) {
        this.dataFinal3 = dataFinal3;
    }

    public SituacaoBoleto getSituacaoBoleto() {
        return situacaoBoleto;
    }

    public void setSituacaoBoleto(SituacaoBoleto situacaoBoleto) {
        this.situacaoBoleto = situacaoBoleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public SituacaoDeposito getSituacaoDeposito() {
        return situacaoDeposito;
    }

    public void setSituacaoDeposito(SituacaoDeposito situacaoDeposito) {
        this.situacaoDeposito = situacaoDeposito;
    }

    public Franquia getFranquia() {
        return franquia;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

}
