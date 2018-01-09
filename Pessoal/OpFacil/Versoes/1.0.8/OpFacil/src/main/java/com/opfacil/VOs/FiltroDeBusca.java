/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.VOs;

import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.modelo.documentos.Arquivo;
import com.opfacil.modelo.enums.SituacaoOp;
import com.opfacil.modelo.enums.SituacaoOpRealizadas;
import com.opfacil.modelo.pagamento.Lote;
import java.util.Date;



/**
 *
 * @author Juniel
 */
public class FiltroDeBusca {

    private Empresa empresa;

    private MotivoPagamento motivo;

    private Funcionario funcionario;

    private Lote lote;

    private Usuario usuario;
    
    private Arquivo arquivo;

    private Date dataInicial;

    private Date dataFinal;

    private String cpf;

    private String nome;
    
    private String conteudo;

    private String cnpj;

    private String rg;

    private String nomeFantasia;

    private String razaoSocial;

    private String nomeMotivo;

    private String funcao;

    private SituacaoOp situacao;
    
    private SituacaoOpRealizadas situacaoOpRealizadas;
    
    private String numOp;

    private Boolean ativo;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public MotivoPagamento getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoPagamento motivo) {
        this.motivo = motivo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeMotivo() {
        return nomeMotivo;
    }

    public void setNomeMotivo(String nomeMotivo) {
        this.nomeMotivo = nomeMotivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }   

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public SituacaoOp getSituacao() {
        return situacao;
    }

    public SituacaoOpRealizadas getSituacaoOpRealizadas() {
        return situacaoOpRealizadas;
    }

    public void setSituacaoOpRealizadas(SituacaoOpRealizadas situacaoOpRealizadas) {
        this.situacaoOpRealizadas = situacaoOpRealizadas;
    }

    public String getNumOp() {
        return numOp;
    }

    public void setNumOp(String numOp) {
        this.numOp = numOp;
    }

    public void setSituacao(SituacaoOp situacao) {
        this.situacao = situacao;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    private void inicializar() {

    }

}
