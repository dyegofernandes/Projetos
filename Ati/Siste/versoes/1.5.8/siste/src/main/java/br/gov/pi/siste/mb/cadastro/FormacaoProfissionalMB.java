package br.gov.pi.siste.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.FormacaoProfissionalBO;
import br.gov.pi.siste.modelo.cadastro.FormacaoProfissional;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormacaoProfissionalMB extends AbstractBaseBean<FormacaoProfissional> implements Serializable {

    @EJB
    private FormacaoProfissionalBO formacaoProfissionalBO;

    @Override
    public FormacaoProfissionalBO getBO() {
        return formacaoProfissionalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void postSave() {
        setEntity(new FormacaoProfissional());
    }
}
