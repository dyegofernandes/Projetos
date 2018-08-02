package br.com.ejccard.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.ejccard.bo.cadastro.MembroBO;
import br.com.ejccard.modelo.cadastro.Membro;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MembroMB extends AbstractBaseBean<Membro> implements Serializable {

    @EJB
    private MembroBO membroBO;

    @Override
    public MembroBO getBO() {
        return membroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
