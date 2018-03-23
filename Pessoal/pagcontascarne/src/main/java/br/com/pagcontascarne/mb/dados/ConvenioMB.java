package br.com.pagcontascarne.mb.dados;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ConvenioBO;
import br.com.pagcontascarne.modelo.dados.Convenio;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ConvenioMB extends AbstractBaseBean<Convenio> implements Serializable {

    @EJB
    private ConvenioBO convenioBO;

    @Override
    public ConvenioBO getBO() {
        return convenioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public void chanceTipoPessoa() {
        getEntity().setCpf_cnpj(null);
        getEntity().setInsc_est(null);
        getEntity().setNome_fantasia(null);
        getEntity().setRazao_social(null);
    }
    
    public List<Convenio> autocomplete(String nome){
        return getBO().conveniosPeloNomeOrCnpjOuCpf(nome);
    }
}
