/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.mb.relatorios;

import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.vos.QtdDenunciaPorTerritorioVO;
import br.gov.pi.salvemaria.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Juniel
 */
@ManagedBean
public class QtdDenunciaPorTerritorioMB implements Serializable {

    private PieChartModel graficoPizza1 = new PieChartModel();
    
    
    private Circunscricao territorio =  new Circunscricao();
    private Date dataInicial;
    private Date dataFinal;

    @EJB
    private DenunciaBO denunciaBO;
    private List<QtdDenunciaPorTerritorioVO> denuncias = new ArrayList<QtdDenunciaPorTerritorioVO>();

    @PostConstruct
    public void init() {
//        buscar();
//        criarGraficoPizza1();

    }

    private void criarGraficoPizza1() {
        graficoPizza1 = new PieChartModel();

        graficoPizza1.setTitle("Gráfico de Denúncia");
        graficoPizza1.setLegendPosition("e");
        graficoPizza1.setShowDataLabels(true);
        graficoPizza1.setShadow(true);

        for (QtdDenunciaPorTerritorioVO denuncia : denuncias) {
            graficoPizza1.set(denuncia.getNomeTerritorio(), denuncia.getQuantidade());
        }
    }

    public PieChartModel getGraficoPizza1() {
        return graficoPizza1;
    }

    public void setGraficoPizza1(PieChartModel graficoPizza1) {
        this.graficoPizza1 = graficoPizza1;
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

    public List<QtdDenunciaPorTerritorioVO> getDenuncias() {
        return denuncias;
    }

    public Circunscricao getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Circunscricao territorio) {
        this.territorio = territorio;
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

    public Integer getTotal() {
        Integer total = new Integer(0);

        for (QtdDenunciaPorTerritorioVO denuncia : denuncias) {
            total = total + denuncia.getQuantidade();
        }

        return total;
    }

    public void buscar() {
        denuncias = denunciaBO.qtdDenunciaPorTerritorio(territorio, dataInicial, dataFinal);
        criarGraficoPizza1();
    }

}
