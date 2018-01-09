package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.GrupoReceitaDespesaBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoReceitaDespesa;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GrupoReceitaDespesaMB extends AbstractBaseBean<GrupoReceitaDespesa> implements Serializable {

    @EJB
    private GrupoReceitaDespesaBO grupoReceitaDespesaBO;

    @Override
    public GrupoReceitaDespesaBO getBO() {
        return grupoReceitaDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        Empresa empresa = grupoReceitaDespesaBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);
    }
}
