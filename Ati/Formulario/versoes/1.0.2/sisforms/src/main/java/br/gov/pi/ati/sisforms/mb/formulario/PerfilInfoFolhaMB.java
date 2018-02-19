package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.PerfilInfoFolhaBO;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilInfoFolha;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PerfilInfoFolhaMB extends AbstractBaseBean<PerfilInfoFolha> implements Serializable {

    @EJB
    private PerfilInfoFolhaBO perfilInfoFolhaBO;

    @Override
    public PerfilInfoFolhaBO getBO() {
        return perfilInfoFolhaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
