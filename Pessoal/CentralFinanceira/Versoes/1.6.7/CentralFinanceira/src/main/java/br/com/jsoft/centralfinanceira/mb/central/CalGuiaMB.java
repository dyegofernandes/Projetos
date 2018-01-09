package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.CalGuiaBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.CalGuia;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CalGuiaMB extends AbstractBaseBean<CalGuia> implements Serializable {

    @EJB
    private CalGuiaBO calGuiaBO;

    @Override
    public CalGuiaBO getBO() {
        return calGuiaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
