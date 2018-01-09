package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.DadosFuncionaisDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;

/**
 *
 * @author Juniel
 */
@Stateless
public class DadosFuncionaisBO extends AbstractBusinessObject<DadosFuncionais> {

    @EJB
    private DadosFuncionaisDAO dadosFuncionaisDAO;
    
    @Override
    public DadosFuncionaisDAO getDAO() {
        return dadosFuncionaisDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DadosFuncionais dadosFuncionais) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
