package br.com.jsoft.centralfinanceira.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.financeiro.CentroResultadosBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.financeiro.CentroResultados;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CentroResultadosMB extends AbstractBaseBean<CentroResultados> implements Serializable {

    @EJB
    private CentroResultadosBO centroResultadosBO;

    @Override
    public CentroResultadosBO getBO() {
        return centroResultadosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        Empresa empresa = centroResultadosBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);

    }
}
