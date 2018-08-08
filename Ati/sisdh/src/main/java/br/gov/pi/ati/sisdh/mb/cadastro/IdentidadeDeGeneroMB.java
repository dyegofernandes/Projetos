package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.IdentidadeDeGeneroBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.IdentidadeDeGenero;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class IdentidadeDeGeneroMB extends AbstractBaseBean<IdentidadeDeGenero> implements Serializable {

    @EJB
    private IdentidadeDeGeneroBO identidadeDeGeneroBO;

    @Override
    public IdentidadeDeGeneroBO getBO() {
        return identidadeDeGeneroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
