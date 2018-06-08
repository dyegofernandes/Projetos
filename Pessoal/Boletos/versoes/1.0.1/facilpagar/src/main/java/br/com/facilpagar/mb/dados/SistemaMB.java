package br.com.facilpagar.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.facilpagar.bo.dados.SistemaBO;
import br.com.facilpagar.modelo.dados.Sistema;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SistemaMB extends AbstractBaseBean<Sistema> implements Serializable {

    @EJB
    private SistemaBO sistemaBO;

    @Override
    public SistemaBO getBO() {
        return sistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        try {
            getBO().gerarToken(getEntity());
        } catch (OAuthSystemException ex) {
            Logger.getLogger(SistemaMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OAuthProblemException ex) {
            Logger.getLogger(SistemaMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.postSave();
    }

}
