package br.com.aprove.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.GrupoLojaBO;
import br.com.aprove.modelo.cadastro.GrupoLoja;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class GrupoLojaMB extends AbstractBaseBean<GrupoLoja> implements Serializable {

    @EJB
    private GrupoLojaBO grupoLojaBO;

    @Override
    public GrupoLojaBO getBO() {
        return grupoLojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/grupoLoja/listGrupoLoja.jsf");
        } else {
            setEntity(new GrupoLoja());
        }
    }
}
