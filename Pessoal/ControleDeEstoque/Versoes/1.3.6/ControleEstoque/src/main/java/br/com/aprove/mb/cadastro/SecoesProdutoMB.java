package br.com.aprove.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.SecoesProdutoBO;
import br.com.aprove.modelo.cadastro.SecoesProduto;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class SecoesProdutoMB extends AbstractBaseBean<SecoesProduto> implements Serializable {

    @EJB
    private SecoesProdutoBO secoesProdutoBO;

    @Override
    public SecoesProdutoBO getBO() {
        return secoesProdutoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/secoesProduto/listSecoesProduto.jsf");
        } else {
            setEntity(new SecoesProduto());
        }
    }
}
