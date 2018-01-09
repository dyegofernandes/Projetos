package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.CalGuiaItemBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.CalGuiaItem;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CalGuiaItemMB extends AbstractBaseBean<CalGuiaItem> implements Serializable {

    @EJB
    private CalGuiaItemBO calGuiaItemBO;

    @Override
    public CalGuiaItemBO getBO() {
        return calGuiaItemBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
