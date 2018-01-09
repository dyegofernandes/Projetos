package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.FonteDeRecursoBO;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FonteDeRecursoMB extends AbstractBaseBean<FonteDeRecurso> implements Serializable {

    @EJB
    private FonteDeRecursoBO fonteDeRecursoBO;

    @Override
    public FonteDeRecursoBO getBO() {
        return fonteDeRecursoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
