/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.mb.padrao;

/**
 *
 * @author juniel
 */
import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.CircunscricaoBairro;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.TipoUnidade;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import br.gov.pi.salvemaria.util.SessaoUtils;
import br.gov.pi.salvemaria.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class DashboardView implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private UnidadeBO unidadeBO;

    private Filtros filtro = new Filtros();

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private Utils util = new Utils();

    private List<Denuncia> denunciasNovas = new ArrayList<Denuncia>();

    private List<Arquivo> arquivos;
    private DashboardModel model;
    private MapModel simpleModel;
    private int diario;
    private int mensal;
    private int semestral;
    private int anual;
    private int total;

    private String longitude;

    private String latitude;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();

        column1.addWidget("atalhos");
//        column1.addWidget("finance");

        column2.addWidget("maps");

        column3.addWidget("denuncias");
//        column3.addWidget("estatistica2");

        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);

        arquivos = new ArrayList<Arquivo>();
        simpleModel = new DefaultMapModel();

        filtro.setUsuario(usuarioAtual);
        List<Unidade> unidades = unidadeBO.getDAO().listAll();

        List<Denuncia> denuncias = denunciaBO.getDAO().listAll("dataDenuncia");

        for (Denuncia denuncia : denuncias) {
            if (denuncia.getDataDenuncia().compareTo(new Date()) == 0) {
                diario++;
            }
            if (denuncia.getDataDenuncia().compareTo(util.primeiroDiaDoMes()) >= 0 && denuncia.getDataDenuncia().compareTo(util.ultimoDiaDoMes()) <= 0) {
                mensal++;
            }
            if (denuncia.getDataDenuncia().compareTo(util.primeiroDiaSemestre()) >= 0 && denuncia.getDataDenuncia().compareTo(util.ultimoDiaSemestre()) <= 0) {
                semestral++;
            }
            if (denuncia.getDataDenuncia().compareTo(util.primeiroDiaDoAno()) >= 0 && denuncia.getDataDenuncia().compareTo(util.ultimoDiaDoMes()) <= 0) {
                anual++;
            }
        }

//        filtro.setDataDenunciaInicial(new Date());
//        filtro.setDataDenunciaFinal(new Date());
//        diario = denunciaBO.listar(filtro).size();
//
//        filtro.setDataDenunciaInicial(util.primeiroDiaDoMes());
//        filtro.setDataDenunciaFinal(util.ultimoDiaDoMes());
//        mensal = denunciaBO.listar(filtro).size();
//
//        filtro.setDataDenunciaInicial(util.primeiroDiaSemestre());
//        filtro.setDataDenunciaFinal(util.ultimoDiaSemestre());
//        semestral = denunciaBO.listar(filtro).size();
//
//        filtro.setDataDenunciaInicial(util.primeiroDiaDoAno());
//        filtro.setDataDenunciaFinal(util.ultiomoDiaDoAno());
//        anual = denunciaBO.listar(filtro).size();
//
//        filtro.setDataDenunciaInicial(null);
//        filtro.setDataDenunciaFinal(null);
        total = denuncias.size();

        latitude = "-5.08921";
        longitude = "-42.8016";

        Unidade unidade = denunciaBO.getDAO().getInitialized(usuarioAtual.getUnidade());
        if (unidade != null) {
            Circunscricao circu = denunciaBO.getDAO().getInitialized(unidade.getCircunscricao());
            CircunscricaoBairro circuBairro = denunciaBO.getDAO().getInitialized(unidade.getCircunscricaoBairro());

            if (circuBairro != null) {
                if (circuBairro.getLatitude() != null && circuBairro.getLongitude() != null) {
                    if (!circuBairro.getLatitude().equals("") && !circuBairro.getLongitude().equals("")) {
                        latitude = circuBairro.getLatitude();
                        longitude = circuBairro.getLongitude();
                    }
                }
            } else {
                if (circu != null) {
                    if (circu.getLatitude() != null && circu.getLongitude() != null) {
                        if (!circu.getLatitude().equals("") && !circu.getLongitude().equals("")) {
                            latitude = circu.getLatitude();
                            longitude = circu.getLongitude();
                        }
                    }
                }
            }
        }

        adicionarMarcacao(unidades);
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

    public MapModel getSimpleModel() {
        return simpleModel;
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

    public void adicionarMarcacao(List<Unidade> unidades) {

        for (Unidade unidade : unidades) {

            if (unidade.getEndereco().getLatitude() != null && unidade.getEndereco().getLongitude() != null) {
                if (!unidade.getEndereco().getLatitude().equals("") && !unidade.getEndereco().getLongitude().equals("")) {
                    Marker marker = new Marker(new LatLng(Double.valueOf(unidade.getEndereco().getLatitude()), Double.valueOf(unidade.getEndereco().getLongitude())),
                            unidade.getSigla() + "");
                    if (unidade.getTipo() == TipoUnidade.BPM) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/red-dot.png");
                    }
                    if (unidade.getTipo() == TipoUnidade.DRPC) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/yellow-dot.png");
                    }

                    if (unidade.getTipo() == TipoUnidade.CIPTUR) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/orange-dot.png");
                    }

                    if (unidade.getTipo() == TipoUnidade.DP) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/blue-dot.png");
                    }

                    if (unidade.getTipo() == TipoUnidade.PM) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/green-dot.png");
                    }

                    if (unidade.getTipo() == TipoUnidade.DDDM) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/pink-dott.png");
                    }

                    simpleModel.addOverlay(marker);
                }

            }

        }
    }

    private String getTotalPorFiltro(List<Denuncia> denuncias, int tipo) {
        Calendar dataInicial = Calendar.getInstance();
        Calendar dataFinal = Calendar.getInstance();

        int count = 0;

        if (tipo == 1) { //Diario
            dataInicial.set(Calendar.HOUR_OF_DAY, 0);
            dataInicial.set(Calendar.MINUTE, 0);
            dataInicial.set(Calendar.SECOND, 0);

            dataFinal.set(Calendar.HOUR_OF_DAY, 23);
            dataFinal.set(Calendar.MINUTE, 59);
            dataFinal.set(Calendar.SECOND, 59);
        }

        if (tipo == 2) {// mensal
            dataInicial.set(Calendar.DAY_OF_MONTH, 1);
            dataInicial.set(Calendar.HOUR_OF_DAY, 0);
            dataInicial.set(Calendar.MINUTE, 0);
            dataInicial.set(Calendar.SECOND, 0);

            dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getActualMaximum(Calendar.DAY_OF_MONTH));
            dataFinal.set(Calendar.HOUR_OF_DAY, 23);
            dataFinal.set(Calendar.MINUTE, 59);
            dataFinal.set(Calendar.SECOND, 59);
        }

        if (tipo == 3) {
            dataInicial.set(Calendar.DAY_OF_MONTH, 1);
            dataInicial.set(Calendar.HOUR_OF_DAY, 0);
            dataInicial.set(Calendar.MINUTE, 0);
            dataInicial.set(Calendar.SECOND, 0);

            dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getActualMaximum(Calendar.DAY_OF_MONTH));
            dataFinal.set(Calendar.HOUR_OF_DAY, 23);
            dataFinal.set(Calendar.MINUTE, 59);
            dataFinal.set(Calendar.SECOND, 59);
        }

        for (Denuncia denuncia : denuncias) {

        }
        return null;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

}
