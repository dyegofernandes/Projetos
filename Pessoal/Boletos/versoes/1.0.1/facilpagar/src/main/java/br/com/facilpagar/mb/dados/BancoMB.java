package br.com.facilpagar.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.facilpagar.bo.dados.BancoBO;
import br.com.facilpagar.modelo.dados.Banco;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BancoMB extends AbstractBaseBean<Banco> implements Serializable {

    @EJB
    private BancoBO bancoBO;

    private FiltrosBusca filtros;

    private List<Banco> bancos;

    @Override
    public BancoBO getBO() {
        return bancoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtros = new FiltrosBusca();
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Banco> getBancos() {
        return bancos;
    }

    public void setBancos(List<Banco> bancos) {
        this.bancos = bancos;
    }

    public List<Banco> autocomplete(String nome) {
        return getBO().listarCodigoOuNome(nome);
    }

    public void buscar() {
        bancos = getBO().bancos(filtros);
    }
}
