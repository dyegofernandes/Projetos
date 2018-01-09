/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.vos;

import java.util.List;

/**
 *
 * @author Juniel
 */
public class RelatorioDeRepasseVO {
    
    private String nomeOrgao;
    
    private String cnpjOrgao;
    
    private List<RelatorioDeRepasseAuxVO> repasses;
    
    private String totalValorBruto;
    
    private String totalValorBCalc;
    
    private String totalFonte113;
    
    private String totalValor11;
    
    private String totalValor20;
    
    private String totalDoValorTotal;

    public String getNomeOrgao() {
        return nomeOrgao;
    }

    public void setNomeOrgao(String nomeOrgao) {
        this.nomeOrgao = nomeOrgao;
    }

    public String getCnpjOrgao() {
        return cnpjOrgao;
    }

    public void setCnpjOrgao(String cnpjOrgao) {
        this.cnpjOrgao = cnpjOrgao;
    }

    public List<RelatorioDeRepasseAuxVO> getRepasses() {
        return repasses;
    }

    public void setRepasses(List<RelatorioDeRepasseAuxVO> repasses) {
        this.repasses = repasses;
    }

    public String getTotalValorBruto() {
        return totalValorBruto;
    }

    public void setTotalValorBruto(String totalValorBruto) {
        this.totalValorBruto = totalValorBruto;
    }

    public String getTotalValorBCalc() {
        return totalValorBCalc;
    }

    public void setTotalValorBCalc(String totalValorBCalc) {
        this.totalValorBCalc = totalValorBCalc;
    }

    public String getTotalFonte113() {
        return totalFonte113;
    }

    public void setTotalFonte113(String totalFonte113) {
        this.totalFonte113 = totalFonte113;
    }

    public String getTotalValor11() {
        return totalValor11;
    }

    public void setTotalValor11(String totalValor11) {
        this.totalValor11 = totalValor11;
    }

    public String getTotalValor20() {
        return totalValor20;
    }

    public void setTotalValor20(String totalValor20) {
        this.totalValor20 = totalValor20;
    }

    public String getTotalDoValorTotal() {
        return totalDoValorTotal;
    }

    public void setTotalDoValorTotal(String totalDoValorTotal) {
        this.totalDoValorTotal = totalDoValorTotal;
    }
    
    
}
