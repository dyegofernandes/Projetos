package br.gov.pi.ati.sisforms.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.cadastro.PontoAcessoBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PontoAcessoMB extends AbstractBaseBean<PontoAcesso> implements Serializable {

    @EJB
    private PontoAcessoBO pontoAcessoBO;

    @Override
    public PontoAcessoBO getBO() {
        return pontoAcessoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
