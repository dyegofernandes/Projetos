package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.PessoaEnvolvidaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PessoaEnvolvidaMB extends AbstractBaseBean<PessoaEnvolvida> implements Serializable {

    @EJB
    private PessoaEnvolvidaBO pessoaEnvolvidaBO;

    @Override
    public PessoaEnvolvidaBO getBO() {
        return pessoaEnvolvidaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
