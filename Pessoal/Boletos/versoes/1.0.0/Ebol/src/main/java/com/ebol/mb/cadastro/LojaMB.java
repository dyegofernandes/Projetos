package com.ebol.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.LojaBO;
import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.vos.FiltroBusca;
import com.ebol.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LojaMB extends AbstractBaseBean<Loja> implements Serializable {

    @EJB
    private LojaBO lojaBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();
    
    private FiltroBusca filtros;

    @Override
    public LojaBO getBO() {
        return lojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtros = new FiltroBusca();
        filtros.setUsuario(usuarioAtual);
    }

    public List<Loja> buscar() {
        return lojaBO.listarLoja(filtros);
    }
}
