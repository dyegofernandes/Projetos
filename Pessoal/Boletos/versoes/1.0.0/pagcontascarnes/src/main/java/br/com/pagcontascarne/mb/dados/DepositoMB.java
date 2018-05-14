package br.com.pagcontascarne.mb.dados;

import br.com.pagcontascarne.bo.dados.ConvenioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.DepositoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Deposito;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DepositoMB extends AbstractBaseBean<Deposito> implements Serializable {

    @EJB
    private DepositoBO depositoBO;

    @EJB
    private ConvenioBO convenioBO;

    private Usuario usuarioAtual;

    private List<Deposito> depositos;

    private FiltrosBusca filtros;

    private List<Convenio> convenios;

    private List<Convenio> conveniosFiltros;

    @Override
    public DepositoBO getBO() {
        return depositoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();
        filtros = new FiltrosBusca();

        filtros.setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
        filtros.setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        depositos = new ArrayList<Deposito>();
        convenios = new ArrayList<Convenio>();
        conveniosFiltros = new ArrayList<Convenio>();
        pegarConveniosFiltros();
        if (getEntity().getId() == null) {
            getEntity().setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        } else {
            convenios = convenioBO.convenioPelaFranquia(getEntity().getFranquia());
        }
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public List<Convenio> getConveniosFiltros() {
        return conveniosFiltros;
    }

    public void setConveniosFiltros(List<Convenio> conveniosFiltros) {
        this.conveniosFiltros = conveniosFiltros;
    }

    public void buscar() {
        depositos = getBO().listar(filtros);
    }

    public void pegarConvenios() {
        convenios = new ArrayList<Convenio>();

        if (getEntity().getFranquia() != null) {
            convenios = convenioBO.convenioPelaFranquia(getEntity().getFranquia());
        }
    }

    public void pegarConveniosFiltros() {
        conveniosFiltros = new ArrayList<Convenio>();

        if (filtros.getFranquia() != null) {
            conveniosFiltros = convenioBO.convenioPelaFranquia(filtros.getFranquia());
        }
    }

    public List<Convenio> convenioPeloNomeEFranquia(String nome) {
        return convenioBO.conveniosPeloNomeOrCnpjOuCpfEFranquia(usuarioAtual.getFranquia(), nome);
    }
}
