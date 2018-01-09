package br.com.jsoft.centralfinanceira.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.financeiro.ReceitaDespesaBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ReceitaDespesaMB extends AbstractBaseBean<ReceitaDespesa> implements Serializable {

    @EJB
    private ReceitaDespesaBO receitaDespesaBO;

    @Override
    public ReceitaDespesaBO getBO() {
        return receitaDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "receitaDespesaMae,id";
    }

    @Override
    public void init() {
        Empresa empresa = receitaDespesaBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);

    }
}
