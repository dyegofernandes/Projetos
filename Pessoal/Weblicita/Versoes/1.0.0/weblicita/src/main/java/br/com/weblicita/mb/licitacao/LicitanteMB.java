package br.com.weblicita.mb.licitacao;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.LicitanteBO;
import br.com.weblicita.modelo.licitacao.Licitante;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LicitanteMB extends AbstractBaseBean<Licitante> implements Serializable {

    @EJB
    private LicitanteBO licitanteBO;

    @Override
    public LicitanteBO getBO() {
        return licitanteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
