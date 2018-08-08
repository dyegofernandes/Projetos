package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.OrientacaoSexualBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.OrientacaoSexual;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OrientacaoSexualMB extends AbstractBaseBean<OrientacaoSexual> implements Serializable {

    @EJB
    private OrientacaoSexualBO orientacaoSexualBO;

    @Override
    public OrientacaoSexualBO getBO() {
        return orientacaoSexualBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
