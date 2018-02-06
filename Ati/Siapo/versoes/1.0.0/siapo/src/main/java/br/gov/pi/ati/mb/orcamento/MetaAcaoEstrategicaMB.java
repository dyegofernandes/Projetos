package br.gov.pi.ati.mb.orcamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaAcaoEstrategicaBO;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MetaAcaoEstrategicaMB extends AbstractBaseBean<MetaAcaoEstrategica> implements Serializable {

    @EJB
    private MetaAcaoEstrategicaBO metaAcaoEstrategicaBO;

    @Override
    public MetaAcaoEstrategicaBO getBO() {
        return metaAcaoEstrategicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
