package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.StateBO;
import br.com.politicalpartysystem.modelo.cadastro.State;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class StateMB extends AbstractBaseBean<State> implements Serializable {

    @EJB
    private StateBO stateBO;

    @Override
    public StateBO getBO() {
        return stateBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
