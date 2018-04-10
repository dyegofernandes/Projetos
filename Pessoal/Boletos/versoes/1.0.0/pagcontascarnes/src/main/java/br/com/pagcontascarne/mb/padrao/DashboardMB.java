/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.mb.padrao;

/**
 *
 * @author juniel
 */
import br.com.pagcontascarne.bo.dados.BoletoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean
@ViewScoped
public class DashboardMB implements Serializable {

    @EJB
    private BoletoBO boletoBO;

    private FiltrosBusca filtro = new FiltrosBusca();

    private Usuario usuarioAtual = SessaoUtils.getUser();


    private DashboardModel model;
    private int diario;
    private int mensal;
    private int semestral;
    private int anual;
    private int total;

    private String longitude;

    private String latitude;

    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();

        column1.addWidget("atalhos");
//        column1.addWidget("finance");

        column2.addWidget("graficos");

        column3.addWidget("totais");
//        column3.addWidget("estatistica2");

        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);

    }

    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());

        addMessage(message);
    }

    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");

        addMessage(message);
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DashboardModel getModel() {
        return model;
    }

    public int getDiario() {
        return diario;
    }

    public int getMensal() {
        return mensal;
    }

    public int getSemestral() {
        return semestral;
    }

    public int getAnual() {
        return anual;
    }

    public int getTotal() {
        return total;
    }

   

//    private String getTotalPorFiltro(List<Denuncia> denuncias, int tipo) {
//        Calendar dataInicial = Calendar.getInstance();
//        Calendar dataFinal = Calendar.getInstance();
//
//        int count = 0;
//
//        if (tipo == 1) { //Diario
//            dataInicial.set(Calendar.HOUR_OF_DAY, 0);
//            dataInicial.set(Calendar.MINUTE, 0);
//            dataInicial.set(Calendar.SECOND, 0);
//
//            dataFinal.set(Calendar.HOUR_OF_DAY, 23);
//            dataFinal.set(Calendar.MINUTE, 59);
//            dataFinal.set(Calendar.SECOND, 59);
//        }
//
//        if (tipo == 2) {// mensal
//            dataInicial.set(Calendar.DAY_OF_MONTH, 1);
//            dataInicial.set(Calendar.HOUR_OF_DAY, 0);
//            dataInicial.set(Calendar.MINUTE, 0);
//            dataInicial.set(Calendar.SECOND, 0);
//
//            dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getActualMaximum(Calendar.DAY_OF_MONTH));
//            dataFinal.set(Calendar.HOUR_OF_DAY, 23);
//            dataFinal.set(Calendar.MINUTE, 59);
//            dataFinal.set(Calendar.SECOND, 59);
//        }
//
//        if (tipo == 3) {
//            dataInicial.set(Calendar.DAY_OF_MONTH, 1);
//            dataInicial.set(Calendar.HOUR_OF_DAY, 0);
//            dataInicial.set(Calendar.MINUTE, 0);
//            dataInicial.set(Calendar.SECOND, 0);
//
//            dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getActualMaximum(Calendar.DAY_OF_MONTH));
//            dataFinal.set(Calendar.HOUR_OF_DAY, 23);
//            dataFinal.set(Calendar.MINUTE, 59);
//            dataFinal.set(Calendar.SECOND, 59);
//        }
//
//        for (Denuncia denuncia : denuncias) {
//
//        }
//        return null;
//    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

}
