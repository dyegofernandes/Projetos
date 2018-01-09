/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.vos;

import com.ebol.modelo.cadastro.Banco;
import com.ebol.modelo.cadastro.Cidade;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.enuns.SituacaoBoleto;
import com.ebol.modelo.enuns.TipoPessoa;
import com.ebol.modelo.venda.Venda;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class FiltroBusca {

    private Banco banco;

    private String referenteA;

    private String descricao;

    private Venda venda;

    private Convenio convenio;

    private Usuario usuario;

    private Cliente cliente;

    private Date dataInicial;

    private Date dataFinal;

    private SituacaoBoleto situacao;

    private Boolean travado;

    private Boolean ativo;

    private BigDecimal unitario;

    private String nome;

    private String apelido;

    private String cpfCnpj;

    private Cidade cidade;

    private TipoPessoa tipoPessoa;

    public String getReferenteA() {
        return referenteA;
    }

    public void setReferenteA(String referenteA) {
        this.referenteA = referenteA;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public SituacaoBoleto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoBoleto situacao) {
        this.situacao = situacao;
    }

    public Boolean isTravado() {
        return travado;
    }

    public void setTravado(Boolean travado) {
        this.travado = travado;
    }

    public BigDecimal getUnitario() {
        return unitario;
    }

    public void setUnitario(BigDecimal unitario) {
        this.unitario = unitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
