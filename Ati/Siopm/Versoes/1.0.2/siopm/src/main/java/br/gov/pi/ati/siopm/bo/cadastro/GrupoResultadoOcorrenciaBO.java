package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.GrupoResultadoOcorrenciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.GrupoResultadoOcorrencia;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoResultadoOcorrenciaBO extends AbstractBusinessObject<GrupoResultadoOcorrencia> {

    @EJB
    private GrupoResultadoOcorrenciaDAO grupoResultadoOcorrenciaDAO;
    
    @Override
    public GrupoResultadoOcorrenciaDAO getDAO() {
        return grupoResultadoOcorrenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("nome");
    }

    @Override
    public void validate(GrupoResultadoOcorrencia grupoResultadoOcorrencia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
