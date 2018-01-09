package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.RubricaOrcamentariaBO;
import br.com.weblicita.modelo.cadastro.RubricaOrcamentaria;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RubricaOrcamentariaMB extends AbstractBaseBean<RubricaOrcamentaria> implements Serializable {

    @EJB
    private RubricaOrcamentariaBO rubricaOrcamentariaBO;

    @Override
    public RubricaOrcamentariaBO getBO() {
        return rubricaOrcamentariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
