package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.NaturezaDaViolacaoBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.NaturezaDaViolacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class NaturezaDaViolacaoMB extends AbstractBaseBean<NaturezaDaViolacao> implements Serializable {

    @EJB
    private NaturezaDaViolacaoBO naturezaDaViolacaoBO;

    @Override
    public NaturezaDaViolacaoBO getBO() {
        return naturezaDaViolacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
