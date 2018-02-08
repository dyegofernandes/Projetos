package br.gov.pi.ati.mb.orcamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaProdutoBO;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MetaProdutoMB extends AbstractBaseBean<MetaProduto> implements Serializable {

    @EJB
    private MetaProdutoBO metaProdutoBO;

    @Override
    public MetaProdutoBO getBO() {
        return metaProdutoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
