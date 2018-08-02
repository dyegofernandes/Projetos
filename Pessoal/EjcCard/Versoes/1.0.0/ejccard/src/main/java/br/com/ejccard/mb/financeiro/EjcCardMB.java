package br.com.ejccard.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.ejccard.bo.financeiro.EjcCardBO;
import br.com.ejccard.modelo.financeiro.EjcCard;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EjcCardMB extends AbstractBaseBean<EjcCard> implements Serializable {

    @EJB
    private EjcCardBO ejcCardBO;

    @Override
    public EjcCardBO getBO() {
        return ejcCardBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
