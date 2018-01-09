package br.com.aprove.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.GruposDeSecoesBO;
import br.com.aprove.modelo.cadastro.GruposDeSecoes;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class GruposDeSecoesMB extends AbstractBaseBean<GruposDeSecoes> implements Serializable {

    @EJB
    private GruposDeSecoesBO gruposDeSecoesBO;

    @Override
    public GruposDeSecoesBO getBO() {
        return gruposDeSecoesBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/gruposDeSecoes/listGruposDeSecoes.jsf");
        } else {
            setEntity(new GruposDeSecoes());
        }
    }
}
