package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.UnidadeOrcamentariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeOrcamentariaBO extends AbstractBusinessObject<UnidadeOrcamentaria> {

    @EJB
    private UnidadeOrcamentariaDAO unidadeOrcamentariaDAO;

    @Override
    public UnidadeOrcamentariaDAO getDAO() {
        return unidadeOrcamentariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo,unidadeGestora").add("nome,unidadeGestora").add("mnemonico,unidadeGestora");
    }

    @Override
    public void validate(UnidadeOrcamentaria unidadeOrcamentaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
