/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.vos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class UnidadeVO {
    
    private String orgao;

    private String codigo;

    private String cnpj;

    private String nome;

    List<MovimentoVO> movimentos = new ArrayList<MovimentoVO>();
    
    private BigDecimal totalSalarioBrutoUnidade;
    
    private BigDecimal totalBcalcUnidade;
    
    private BigDecimal totalDescontoInssUnidade;
    
    private BigDecimal totalDesconto20Unidade;
    
    private BigDecimal totalValorTotalUnidade;
    
    private Integer registrosPorUnidade;

    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<MovimentoVO> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<MovimentoVO> movimentos) {
        this.movimentos = movimentos;
    }

    public BigDecimal getTotalSalarioBrutoUnidade() {
        return totalSalarioBrutoUnidade;
    }

    public void setTotalSalarioBrutoUnidade(BigDecimal totalSalarioBrutoUnidade) {
        this.totalSalarioBrutoUnidade = totalSalarioBrutoUnidade;
    }

    public BigDecimal getTotalBcalcUnidade() {
        return totalBcalcUnidade;
    }

    public void setTotalBcalcUnidade(BigDecimal totalBcalcUnidade) {
        this.totalBcalcUnidade = totalBcalcUnidade;
    }

    public BigDecimal getTotalDescontoInssUnidade() {
        return totalDescontoInssUnidade;
    }

    public void setTotalDescontoInssUnidade(BigDecimal totalDescontoInssUnidade) {
        this.totalDescontoInssUnidade = totalDescontoInssUnidade;
    }

    public BigDecimal getTotalDesconto20Unidade() {
        return totalDesconto20Unidade;
    }

    public void setTotalDesconto20Unidade(BigDecimal totalDesconto20Unidade) {
        this.totalDesconto20Unidade = totalDesconto20Unidade;
    }

    public BigDecimal getTotalValorTotalUnidade() {
        return totalValorTotalUnidade;
    }

    public void setTotalValorTotalUnidade(BigDecimal totalValorTotalUnidade) {
        this.totalValorTotalUnidade = totalValorTotalUnidade;
    }

    public Integer getRegistrosPorUnidade() {
        return registrosPorUnidade;
    }

    public void setRegistrosPorUnidade(Integer registrosPorUnidade) {
        this.registrosPorUnidade = registrosPorUnidade;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

}
