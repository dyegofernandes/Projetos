package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.MunicipioBO;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MunicipioMB extends AbstractBaseBean<Municipio> implements Serializable {

    @EJB
    private MunicipioBO municipioBO;

    @Override
    public MunicipioBO getBO() {
        return municipioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public List<Municipio> autocomplete(String nome) {
        return getBO().municipiosPeloNome(nome);
    }
}
