package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ModalidadeDeAplicacaoBO;
import br.gov.pi.ati.modelo.cadastro.ModalidadeDeAplicacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ModalidadeDeAplicacaoMB extends AbstractBaseBean<ModalidadeDeAplicacao> implements Serializable {

    @EJB
    private ModalidadeDeAplicacaoBO modalidadeDeAplicacaoBO;

    @Override
    public ModalidadeDeAplicacaoBO getBO() {
        return modalidadeDeAplicacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
