package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.NaturezaOcorrenciaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class NaturezaOcorrenciaMB extends AbstractBaseBean<NaturezaOcorrencia> implements Serializable {

    @EJB
    private NaturezaOcorrenciaBO naturezaOcorrenciaBO;

    @Override
    public NaturezaOcorrenciaBO getBO() {
        return naturezaOcorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "codigo";
    }

    public List<NaturezaOcorrencia> autocomplete(String nome) {
        return getBO().naturezasPeloNome(nome);
    }
}
