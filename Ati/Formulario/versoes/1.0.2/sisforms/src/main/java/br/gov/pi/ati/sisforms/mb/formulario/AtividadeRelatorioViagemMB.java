package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.AtividadeRelatorioViagemBO;
import br.gov.pi.ati.sisforms.modelo.formulario.AtividadeRelatorioViagem;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AtividadeRelatorioViagemMB extends AbstractBaseBean<AtividadeRelatorioViagem> implements Serializable {

    @EJB
    private AtividadeRelatorioViagemBO atividadeRelatorioViagemBO;

    @Override
    public AtividadeRelatorioViagemBO getBO() {
        return atividadeRelatorioViagemBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
