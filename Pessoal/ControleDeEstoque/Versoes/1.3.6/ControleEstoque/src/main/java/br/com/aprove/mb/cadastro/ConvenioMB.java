package br.com.aprove.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.ConvenioBO;
import br.com.aprove.modelo.cadastro.Convenio;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ConvenioMB extends AbstractBaseBean<Convenio> implements Serializable {

    @EJB
    private ConvenioBO convenioBO;

    @Override
    public ConvenioBO getBO() {
        return convenioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if(getId()!=null){
            FacesUtils.redirect("/view/cadastro/convenio/listConvenio.jsf");
        }else{
            setEntity(new Convenio());
        }
    }
}
