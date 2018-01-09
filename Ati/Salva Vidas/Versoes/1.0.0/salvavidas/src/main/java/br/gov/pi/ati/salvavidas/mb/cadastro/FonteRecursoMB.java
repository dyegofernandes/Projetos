package br.gov.pi.ati.salvavidas.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.salvavidas.bo.cadastro.FonteRecursoBO;
import br.gov.pi.ati.salvavidas.modelo.cadastro.FonteRecurso;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FonteRecursoMB extends AbstractBaseBean<FonteRecurso> implements Serializable {

    @EJB
    private FonteRecursoBO fonteRecursoBO;

    @Override
    public FonteRecursoBO getBO() {
        return fonteRecursoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
