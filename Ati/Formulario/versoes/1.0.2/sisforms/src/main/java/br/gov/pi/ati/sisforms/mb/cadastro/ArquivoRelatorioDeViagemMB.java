package br.gov.pi.ati.sisforms.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.cadastro.ArquivoRelatorioDeViagemBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeViagem;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ArquivoRelatorioDeViagemMB extends AbstractBaseBean<ArquivoRelatorioDeViagem> implements Serializable {

    @EJB
    private ArquivoRelatorioDeViagemBO arquivoRelatorioDeViagemBO;

    @Override
    public ArquivoRelatorioDeViagemBO getBO() {
        return arquivoRelatorioDeViagemBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
