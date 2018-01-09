package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.PessoaDenunciaBO;
import br.gov.pi.ati.sisforms.modelo.formulario.PessoaDenuncia;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PessoaDenunciaMB extends AbstractBaseBean<PessoaDenuncia> implements Serializable {

    @EJB
    private PessoaDenunciaBO pessoaDenunciaBO;

    @Override
    public PessoaDenunciaBO getBO() {
        return pessoaDenunciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
