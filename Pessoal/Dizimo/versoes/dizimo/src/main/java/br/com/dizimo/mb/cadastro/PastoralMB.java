package br.com.dizimo.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.PastoralBO;
import br.com.dizimo.modelo.cadastro.Pastoral;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PastoralMB extends AbstractBaseBean<Pastoral> implements Serializable {

    @EJB
    private PastoralBO pastoralBO;

    @Override
    public PastoralBO getBO() {
        return pastoralBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
