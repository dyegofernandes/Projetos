package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.GerenteBO;
import br.com.weblicita.modelo.cadastro.Gerente;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GerenteMB extends AbstractBaseBean<Gerente> implements Serializable {

    @EJB
    private GerenteBO gerenteBO;

    @Override
    public GerenteBO getBO() {
        return gerenteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
