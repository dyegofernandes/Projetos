package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.GrauDeInstrucaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.GrauDeInstrucao;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrauDeInstrucaoBO extends AbstractBusinessObject<GrauDeInstrucao> {

    @EJB
    private GrauDeInstrucaoDAO grauDeInstrucaoDAO;
    
    @Override
    public GrauDeInstrucaoDAO getDAO() {
        return grauDeInstrucaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo", "descricao");
    }

    @Override
    public void validate(GrauDeInstrucao grauDeInstrucao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
