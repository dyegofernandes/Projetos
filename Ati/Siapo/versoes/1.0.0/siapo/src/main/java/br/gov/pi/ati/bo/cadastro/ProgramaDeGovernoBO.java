package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ProgramaDeGovernoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramaDeGovernoBO extends AbstractBusinessObject<ProgramaDeGoverno> {

    @EJB
    private ProgramaDeGovernoDAO programaDeGovernoDAO;

    @Override
    public ProgramaDeGovernoDAO getDAO() {
        return programaDeGovernoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo,unidadeOrcamentaria").add("nome,unidadeOrcamentaria");
    }

    @Override
    public void validate(ProgramaDeGoverno programaDeGoverno) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
