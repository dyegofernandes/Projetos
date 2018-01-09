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
public class RepassesVO {

    private String cnpj;

    private String nome;
    
    private String cnpjENome;

    private List<UnidadeVO> unidades = new ArrayList<UnidadeVO>();
    
    private BigDecimal totalSalarioBrutoOrgao;
    
    private BigDecimal totalBcalcOrgao;
    
    private BigDecimal totalDescontoInssOrgao;
    
    private BigDecimal totalDesconto20Orgao;
    
    private BigDecimal totalValorTotalOrgao;
    
    private Integer registroPorOrgaos;

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

    public List<UnidadeVO> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeVO> unidades) {
        this.unidades = unidades;
    }

    public String getCnpjENome() {
        return cnpjENome;
    }

    public void setCnpjENome(String cnpjENome) {
        this.cnpjENome = cnpjENome;
    }

    public BigDecimal getTotalSalarioBrutoOrgao() {
        return totalSalarioBrutoOrgao;
    }

    public void setTotalSalarioBrutoOrgao(BigDecimal totalSalarioBrutoOrgao) {
        this.totalSalarioBrutoOrgao = totalSalarioBrutoOrgao;
    }

    public BigDecimal getTotalBcalcOrgao() {
        return totalBcalcOrgao;
    }

    public void setTotalBcalcOrgao(BigDecimal totalBcalcOrgao) {
        this.totalBcalcOrgao = totalBcalcOrgao;
    }

    public BigDecimal getTotalDescontoInssOrgao() {
        return totalDescontoInssOrgao;
    }

    public void setTotalDescontoInssOrgao(BigDecimal totalDescontoInssOrgao) {
        this.totalDescontoInssOrgao = totalDescontoInssOrgao;
    }

    public BigDecimal getTotalDesconto20Orgao() {
        return totalDesconto20Orgao;
    }

    public void setTotalDesconto20Orgao(BigDecimal totalDesconto20Orgao) {
        this.totalDesconto20Orgao = totalDesconto20Orgao;
    }

    public BigDecimal getTotalValorTotalOrgao() {
        return totalValorTotalOrgao;
    }

    public void setTotalValorTotalOrgao(BigDecimal totalValorTotalOrgao) {
        this.totalValorTotalOrgao = totalValorTotalOrgao;
    }

    public Integer getRegistroPorOrgaos() {
        return registroPorOrgaos;
    }

    public void setRegistroPorOrgaos(Integer registroPorOrgaos) {
        this.registroPorOrgaos = registroPorOrgaos;
    }

    @Override
    public String toString() {
        return cnpj.concat(" - ").concat(nome); //To change body of generated methods, choose Tools | Templates.
    }

}
