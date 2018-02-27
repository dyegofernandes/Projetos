package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ContatoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Contato;
import br.com.pagcontascarne.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContatoMB extends AbstractBaseBean<Contato> implements Serializable {

    @EJB
    private ContatoBO contatoBO;

    Usuario usuarioAtual = SessaoUtils.getUser();

    @Override
    public ContatoBO getBO() {
        return contatoBO;
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
