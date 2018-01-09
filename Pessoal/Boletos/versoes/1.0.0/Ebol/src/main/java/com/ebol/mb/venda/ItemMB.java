package com.ebol.mb.venda;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.ItemBO;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.venda.Item;
import com.ebol.modelo.vos.FiltroBusca;
import com.ebol.util.SessaoUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemMB extends AbstractBaseBean<Item> implements Serializable {

    @EJB
    private ItemBO itemBO;

    private List<Item> itens;
    
    private Convenio convenio;
    
    private Usuario usuario = new Usuario();
    
    private FiltroBusca filtros;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public ItemBO getBO() {
        return itemBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtros = new FiltroBusca();
        itens = new ArrayList<Item>();
        usuario = SessaoUtils.getUser();
        filtros.setUsuario(usuario);
        convenio = itemBO.getDAO().getInitialized(usuario.getConvenio());
        getEntity().setConvenio(convenio);
    }
    
    public List<Item> itensPorConvenio(){
        itens = itemBO.itensPorConvenio(filtros);
        
        return itens;
    }

    public FiltroBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroBusca filtros) {
        this.filtros = filtros;
    }

}
