package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ResultadoOcorrenciaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ResultadoOcorrenciaMB extends AbstractBaseBean<ResultadoOcorrencia> implements Serializable {

    @EJB
    private ResultadoOcorrenciaBO resultadoOcorrenciaBO;

    @Override
    public ResultadoOcorrenciaBO getBO() {
        return resultadoOcorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new ResultadoOcorrencia());
    }

    public List<ResultadoOcorrencia> autocomplete(String nome) {
        return getBO().resultadoOcorrenciaPeloNome(nome);
    }

}
