package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.DepositoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
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

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Deposito> depositos;

    private FiltrosBusca filtros;

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
        filtros = new FiltrosBusca();
        filtros.setConvenio(usuarioAtual.getConvenio());
        depositos = new ArrayList<Deposito>();
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
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

    public void buscar() {
        depositos = getBO().listar(filtros);
    }

}
