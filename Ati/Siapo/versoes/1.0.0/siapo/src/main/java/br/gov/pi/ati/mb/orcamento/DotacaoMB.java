package br.gov.pi.ati.mb.orcamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.DotacaoBO;
import br.gov.pi.ati.modelo.orcamento.Dotacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DotacaoMB extends AbstractBaseBean<Dotacao> implements Serializable {

    @EJB
    private DotacaoBO dotacaoBO;

    @Override
    public DotacaoBO getBO() {
        return dotacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
