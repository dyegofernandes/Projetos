package br.com.ejccard.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.ejccard.bo.cadastro.EquipeBO;
import br.com.ejccard.modelo.cadastro.Equipe;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EquipeMB extends AbstractBaseBean<Equipe> implements Serializable {

    @EJB
    private EquipeBO equipeBO;

    @Override
    public EquipeBO getBO() {
        return equipeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
