package br.com.aprove.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.BancoBO;
import br.com.aprove.modelo.cadastro.Banco;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class BancoMB extends AbstractBaseBean<Banco> implements Serializable {

    @EJB
    private BancoBO bancoBO;

    @Override
    public BancoBO getBO() {
        return bancoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if(getId()!=null){
            FacesUtils.redirect("/view/cadastro/banco/listBanco.jsf");
        }else{
            setEntity(new Banco());
        }
    }
}
