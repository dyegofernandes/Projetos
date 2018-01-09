package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.SituacaoTributariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.SituacaoTributaria;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class SituacaoTributariaBO extends AbstractBusinessObject<SituacaoTributaria> {

    @EJB
    private SituacaoTributariaDAO situacaoTributariaDAO;
    
    @Override
    public SituacaoTributariaDAO getDAO() {
        return situacaoTributariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(SituacaoTributaria situacaoTributaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
