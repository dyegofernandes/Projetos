package br.com.pagcontascarne.mb.dados;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.DepositoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Deposito;
import br.com.pagcontascarne.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DepositoMB extends AbstractBaseBean<Deposito> implements Serializable {

    @EJB
    private DepositoBO depositoBO;
    
    Usuario usuarioAtual = SessaoUtils.getUser();

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
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        }
    }
    
}
