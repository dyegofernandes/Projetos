package br.com.weblicita.mb.contrato;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.contrato.ContratoBO;
import br.com.weblicita.modelo.contrato.Contrato;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContratoMB extends AbstractBaseBean<Contrato> implements Serializable {

    @EJB
    private ContratoBO contratoBO;

    @Override
    public ContratoBO getBO() {
        return contratoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
