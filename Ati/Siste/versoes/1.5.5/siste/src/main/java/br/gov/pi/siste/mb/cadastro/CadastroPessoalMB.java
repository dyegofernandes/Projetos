package br.gov.pi.siste.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.CadastroPessoalBO;
import br.gov.pi.siste.modelo.cadastro.CadastroPessoal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CadastroPessoalMB extends AbstractBaseBean<CadastroPessoal> implements Serializable {

    @EJB
    private CadastroPessoalBO cadastroPessoalBO;

    @Override
    public CadastroPessoalBO getBO() {
        return cadastroPessoalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void postSave() {
        setEntity(new CadastroPessoal());
    }
    
    
}
