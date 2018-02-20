package br.gov.pi.ati.sisforms.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.cadastro.TermoBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Termo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TermoMB extends AbstractBaseBean<Termo> implements Serializable {

    @EJB
    private TermoBO termoBO;

    @Override
    public TermoBO getBO() {
        return termoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
