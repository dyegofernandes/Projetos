package br.gov.pi.ati.agendacultural.mb.eventos;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.eventos.EventoBO;
import br.gov.pi.ati.agendacultural.modelo.eventos.AgendaEvento;
import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;
import br.gov.pi.ati.agendacultural.modelo.eventos.ValorEvento;
import br.gov.pi.ati.agendacultural.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EventoMB extends AbstractBaseBean<Evento> implements Serializable {

    @EJB
    private EventoBO eventoBO;

    private AgendaEvento agendaAdd;

    private CategoriaEvento categoriaAdd;

    private ValorEvento valorAdd;

    private List<AgendaEvento> agendas;

    private List<CategoriaEvento> categorias;

    private List<ValorEvento> valores;

    @Override
    public EventoBO getBO() {
        return eventoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        agendaAdd = new AgendaEvento();
        agendas = new ArrayList<AgendaEvento>();
        valorAdd = new ValorEvento();
        categoriaAdd = new CategoriaEvento();
        valores = new ArrayList<ValorEvento>();
        categorias = new ArrayList<CategoriaEvento>();

        if (getEntity().getId() != null) {
            agendas = getBO().getDAO().getInitialized(getEntity().getAgenda());
            valores = getBO().getDAO().getInitialized(getEntity().getValores());
            categorias = getBO().getDAO().getInitialized(getEntity().getCategorias());
        }
    }

    @Override
    public void save() {
        getEntity().setAgenda(agendas);
        getEntity().setValores(valores);
        getEntity().setCategorias(categorias);
        super.save();
    }

    public void addAgenda() {
        if (getEntity().getDataInicio().after(getEntity().getDataFim())) {
            FacesMessageUtils.error("Data inicial não pode ser posterior a data final do Evento!");
        } else {
            if (agendaAdd != null) {
                if (Utils.isNullOrEmpty(agendaAdd.getDescricao())) {
                    FacesMessageUtils.error("Descrição da Agenda é obrigatória!");
                } else {
                    if (agendaAdd.getDataInicio() != null && agendaAdd.getDataFim() != null) {
                        if ((estaNoIntervalo(agendaAdd.getDataInicio(), getEntity().getDataInicio(), getEntity().getDataFim())
                                && estaNoIntervalo(agendaAdd.getDataFim(), getEntity().getDataInicio(), getEntity().getDataFim()))) {
                            if (agendaAdd.getDataInicio().after(agendaAdd.getDataFim())) {
                                FacesMessageUtils.error("Data Inicial não pode ser maior que a data Final!");
                            } else {
                                agendas.add(agendaAdd);
                                agendaAdd = new AgendaEvento();
                            }
                        } else {
                            FacesMessageUtils.error("Data Inicial/Final da Agenda tem que está dentro do intervaldo do Evento!");
                        }

                    } else {
                        FacesMessageUtils.error("Data Inicial/Final da Agenda é obrigatória!");
                    }

                }
            } else {
                FacesMessageUtils.error("Agenda é obrigatória!");
            }
        }
    }

    public void removerAgenda(AgendaEvento agenda) {
        agendas.remove(agenda);
    }

    public void addCategoria() {
        if (categoriaAdd != null) {
            if (verificarCategoriaAdd(categoriaAdd)) {
                FacesMessageUtils.error("Categoria do Evento já foi adicionada!");
            } else {
                categorias.add(categoriaAdd);
                categoriaAdd = new CategoriaEvento();
            }
        } else {
            FacesMessageUtils.error("Categoria do Evento é obrigatória!");
        }
    }

    public void removerCategoria(CategoriaEvento categoria) {
        categorias.remove(categoria);
    }

    public void addValorEvento() {
        if (valorAdd != null) {
            if (Utils.isNullOrEmpty(valorAdd.getDescricao())) {
                FacesMessageUtils.error("Descrição do Valor é obrigatória!");
            } else {
                if (valorAdd.getValor() != null) {
                    if (verificarValorAdd(valorAdd)) {
                        FacesMessageUtils.error("Já existe um valor com essa descrição adicionado!");
                    } else {
                        valores.add(valorAdd);
                        valorAdd = new ValorEvento();
                    }
                } else {
                    FacesMessageUtils.error("Valor do Evento é obrigatório!");
                }
            }
        } else {
            FacesMessageUtils.error("Valor do Evento é obrigatório!");
        }
    }

    public void removerValor(ValorEvento valor) {
        valores.remove(valor);
    }

    private boolean verificarDataAdicionada(AgendaEvento agenda) {
        for (AgendaEvento agenda1 : agendas) {
            if (agenda1.getDataInicio().compareTo(agenda.getDataInicio()) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarCategoriaAdd(CategoriaEvento categoria) {
        for (CategoriaEvento categoriaTemp : categorias) {
            if (categoriaTemp.equals(categoria)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarValorAdd(ValorEvento valor) {
        for (ValorEvento valorTemp : valores) {
            if (valorTemp.getDescricao().equals(valor.getDescricao())) {
                return true;
            }
        }

        return false;
    }

    public AgendaEvento getAgendaAdd() {
        return agendaAdd;
    }

    public void setAgendaAdd(AgendaEvento agendaAdd) {
        this.agendaAdd = agendaAdd;
    }

    public List<AgendaEvento> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<AgendaEvento> agendas) {
        this.agendas = agendas;
    }

    private boolean estaNoIntervalo(Date dataVerificada, Date dataInicial, Date dataFinal) {
        return dataVerificada.compareTo(dataInicial) >= 0 && dataVerificada.compareTo(dataFinal) <= 0;
    }

    public CategoriaEvento getCategoriaAdd() {
        return categoriaAdd;
    }

    public void setCategoriaAdd(CategoriaEvento categoriaAdd) {
        this.categoriaAdd = categoriaAdd;
    }

    public ValorEvento getValorAdd() {
        return valorAdd;
    }

    public void setValorAdd(ValorEvento valorAdd) {
        this.valorAdd = valorAdd;
    }

    public List<CategoriaEvento> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEvento> categorias) {
        this.categorias = categorias;
    }

    public List<ValorEvento> getValores() {
        return valores;
    }

    public void setValores(List<ValorEvento> valores) {
        this.valores = valores;
    }
    
    
}
