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
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.modelo.dados.Uf;
import br.com.pagcontascarne.modelo.enums.TipoPessoa;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class FiltrosBusca implements Serializable {

    private Convenio convenio;

    private Cliente cliente;

    private Banco banco1;

    private Banco banco2;

    private Deposito deposito;

    private String codigo;

    private Produto produto;

    private TipoPessoa tipoPessoa =TipoPessoa.PJ;

    private String cpf_cnpj;

    private String nome_fantasia;

    private String nome_razao_social;

    private String rg_insc_estadual;

    private Date dataInicial;

    private Date dataFinal;

    private String endereco;

    private Cidade cidade;

    private String email;

    private Uf estado;

    private String bairro;

    private String telefone;

    private String nome;

    private boolean ativo = true;

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

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
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

}
