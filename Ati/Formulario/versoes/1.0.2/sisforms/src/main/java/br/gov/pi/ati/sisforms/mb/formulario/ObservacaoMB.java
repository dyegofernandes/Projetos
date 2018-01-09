package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ObservacaoBO;
import br.gov.pi.ati.sisforms.modelo.formulario.Observacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ObservacaoMB extends AbstractBaseBean<Observacao> implements Serializable {

    @EJB
    private ObservacaoBO observacaoBO;

    @Override
    public ObservacaoBO getBO() {
        return observacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
