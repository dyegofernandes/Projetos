package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.DeliberacaoBO;
import br.gov.pi.ati.sisforms.modelo.formulario.Deliberacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DeliberacaoMB extends AbstractBaseBean<Deliberacao> implements Serializable {

    @EJB
    private DeliberacaoBO deliberacaoBO;

    @Override
    public DeliberacaoBO getBO() {
        return deliberacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
