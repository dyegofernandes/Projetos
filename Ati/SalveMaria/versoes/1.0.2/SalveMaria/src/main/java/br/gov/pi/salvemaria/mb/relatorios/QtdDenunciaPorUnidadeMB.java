/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.mb.relatorios;

import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.vos.QtdDenunciaPorUnidadeVO;
import br.gov.pi.salvemaria.util.Utils;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Juniel
 */
@ManagedBean
public class QtdDenunciaPorUnidadeMB extends AbstractBaseBean<Denuncia> implements Serializable {

    private PieChartModel graficoPizza1 = new PieChartModel();

    private Date dataInicial;
    private Date dataFinal;
    private Unidade unidade = new Unidade();

    @EJB
    private DenunciaBO denunciaBO;
    private List<QtdDenunciaPorUnidadeVO> denuncias = new ArrayList<QtdDenunciaPorUnidadeVO>();

    @Override
    public void init() {
//        unidade = new Unidade();
//        buscar();
    }

    private void criarGraficoPizza1() {
        graficoPizza1 = new PieChartModel();

        graficoPizza1.setTitle("Gráfico de Denúncia");
        graficoPizza1.setLegendPosition("e");
        graficoPizza1.setShowDataLabels(true);
        graficoPizza1.setShadow(true);

        for (QtdDenunciaPorUnidadeVO denuncia : denuncias) {
            graficoPizza1.set(denuncia.getNomeUnidade(), denuncia.getQuantidade());
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<QtdDenunciaPorUnidadeVO> getDenuncias() {
        return denuncias;
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

        for (QtdDenunciaPorUnidadeVO denuncia : denuncias) {
            total = total + denuncia.getQuantidade();
        }

        return total;
    }

    public void buscar() {
        
        denuncias = denunciaBO.qtdDenunciaPorUnidade(unidade, dataInicial, dataFinal);
         criarGraficoPizza1();

    }

    @Override
    public AbstractBusinessObject getBO() {
        return denunciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

}
