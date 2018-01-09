package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.HistoricoPadraoBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.HistoricoPadrao;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class HistoricoPadraoMB extends AbstractBaseBean<HistoricoPadrao> implements Serializable {

    @EJB
    private HistoricoPadraoBO historicoPadraoBO;

    @Override
    public HistoricoPadraoBO getBO() {
        return historicoPadraoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }

    @Override
    public void init() {
        Empresa empresa = historicoPadraoBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);

    }
}
