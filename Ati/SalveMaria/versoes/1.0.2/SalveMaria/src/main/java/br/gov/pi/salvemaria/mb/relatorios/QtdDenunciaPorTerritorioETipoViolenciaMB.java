/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.mb.relatorios;

import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.vos.DenunciaPorTerritorioPrincipalVO;
import br.gov.pi.salvemaria.modelo.vos.DestribuicaoViolenciaPorTDVO;
import br.gov.pi.salvemaria.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Juniel
 */
@ManagedBean
public class QtdDenunciaPorTerritorioETipoViolenciaMB implements Serializable {

    private Date dataInicial;
    private Date dataFinal;

    @EJB
    private DenunciaBO denunciaBO;
//    private List<DenunciaPorTerritorioPrincipalVO> denuncias = new ArrayList<DenunciaPorTerritorioPrincipalVO>();
    private List<DestribuicaoViolenciaPorTDVO> denuncias = new ArrayList<DestribuicaoViolenciaPorTDVO>();
   
    @PostConstruct
    public void init() {

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

    public List<DestribuicaoViolenciaPorTDVO> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<DestribuicaoViolenciaPorTDVO> denuncias) {
        this.denuncias = denuncias;
    }

   
    
    public String getPeriodo() {
        String periodo = "";
        if (dataInicial != null) {
            periodo = periodo.concat("(");
            periodo = periodo.concat(Utils.convertDateToString(dataInicial, "dd/MM/yyyy"));
            periodo = periodo.concat(" - ");
        } else {
            periodo = periodo.concat("(01/01/2017 - ");
        }

        if (dataFinal != null) {
            periodo = periodo.concat(Utils.convertDateToString(dataFinal, "dd/MM/yyyy"));
            periodo = periodo.concat(")");
        } else {
            periodo = periodo.concat(Utils.convertDateToString(new Date(), "dd/MM/yyyy"));
            periodo = periodo.concat(")");
        }

        return periodo;
    }

    public void buscar() {
        denuncias = denunciaBO.designacaoPorFormaViolenciaPorTD(dataInicial, dataFinal);
    }
    
    

}
