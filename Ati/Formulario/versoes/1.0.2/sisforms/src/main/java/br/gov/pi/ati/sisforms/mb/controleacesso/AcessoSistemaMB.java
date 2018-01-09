package br.gov.pi.ati.sisforms.mb.controleacesso;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.controleacesso.AcessoSistemaBO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.AcessoSistema;

/**
 *
 * @author ayslan
 */
@ManagedBean
@ViewScoped
public class AcessoSistemaMB extends AbstractBaseBean<AcessoSistema> implements Serializable {

    @EJB
    private AcessoSistemaBO acessoSistemaBO;

    @Override
    public AbstractBusinessObject getBO() {
        return acessoSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id DESC";
    }
}
