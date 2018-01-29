package br.com.weblicita.mb.licitacao;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.ProponenteBO;
import br.com.weblicita.modelo.licitacao.Proponente;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ProponenteMB extends AbstractBaseBean<Proponente> implements Serializable {

    @EJB
    private ProponenteBO proponenteBO;

    @Override
    public ProponenteBO getBO() {
        return proponenteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
