package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ModuloInfoFolhaBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloInfoFolha;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ModuloInfoFolhaMB extends AbstractBaseBean<ModuloInfoFolha> implements Serializable {

    @EJB
    private ModuloInfoFolhaBO moduloInfoFolhaBO;

    @Override
    public ModuloInfoFolhaBO getBO() {
        return moduloInfoFolhaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
