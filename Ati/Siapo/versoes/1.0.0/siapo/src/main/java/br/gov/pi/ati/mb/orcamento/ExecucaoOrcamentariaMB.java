package br.gov.pi.ati.mb.orcamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.ExecucaoOrcamentariaBO;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ExecucaoOrcamentariaMB extends AbstractBaseBean<ExecucaoOrcamentaria> implements Serializable {

    @EJB
    private ExecucaoOrcamentariaBO execucaoOrcamentariaBO;

    @Override
    public ExecucaoOrcamentariaBO getBO() {
        return execucaoOrcamentariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
