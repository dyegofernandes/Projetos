/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.vo;

import br.com.aprove.modelo.cadastro.Cidade;
import br.com.aprove.modelo.cadastro.Estado;
import br.com.aprove.modelo.cadastro.Fornecedor;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.cadastro.enums.TipoDePessoa;
import br.com.aprove.modelo.cadastro.enums.TipoFornecedor;
import br.com.aprove.modelo.controleacesso.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class FiltroVO {
    
    private List<Loja_Filial> lojas = new ArrayList<Loja_Filial>();

    private TipoFornecedor tipoFornecedor;
    
    private String nome;
    
    private String descricao;
    
    private String fabricante;
    
    private String marca;
    
    private Boolean negativo;

    private String cnpj;

    private String codigo;
    
    private Long codigo1;
    
    private String codigo2;

    private Usuario usuario;

    private Loja_Filial matriz;

    private Loja_Filial loja;
    
    private Fornecedor fornecedor;
    
    private TipoDePessoa tipo =TipoDePessoa.JURIDICA;
    
    private Cidade cidade;
    
    private Estado estado;
    
    private Date dataInicial;
    
    private Date dataFinal;
    
    private BigDecimal valorInicial;
    
    private BigDecimal valorFinal;
    
    private BigDecimal valorInicial1;
    
    private BigDecimal valorFinal1;
    
    private Boolean ativo;
    
    private String banco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Loja_Filial getMatriz() {
        return matriz;
    }

    public void setMatriz(Loja_Filial matriz) {
        this.matriz = matriz;
    }

    public Loja_Filial getLoja() {
        return loja;
    }

    public void setLoja(Loja_Filial loja) {
        this.loja = loja;
    }

    public TipoDePessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePessoa tipo) {
        this.tipo = tipo;
    }

    public TipoFornecedor getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(TipoFornecedor tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Loja_Filial> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja_Filial> lojas) {
        this.lojas = lojas;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(Long codigo1) {
        this.codigo1 = codigo1;
    }

    public String getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getValorInicial1() {
        return valorInicial1;
    }

    public void setValorInicial1(BigDecimal valorInicial1) {
        this.valorInicial1 = valorInicial1;
    }

    public BigDecimal getValorFinal1() {
        return valorFinal1;
    }

    public void setValorFinal1(BigDecimal valorFinal1) {
        this.valorFinal1 = valorFinal1;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getNegativo() {
        return negativo;
    }

    public void setNegativo(Boolean negativo) {
        this.negativo = negativo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
  
}
