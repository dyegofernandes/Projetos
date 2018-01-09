package br.gov.pi.ati.sisforms.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.cadastro.ArquivoRelatorioDeVisitaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeVisita;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ArquivoRelatorioDeVisitaMB extends AbstractBaseBean<ArquivoRelatorioDeVisita> implements Serializable {

    @EJB
    private ArquivoRelatorioDeVisitaBO arquivoRelatorioDeVisitaBO;

    @Override
    public ArquivoRelatorioDeVisitaBO getBO() {
        return arquivoRelatorioDeVisitaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
