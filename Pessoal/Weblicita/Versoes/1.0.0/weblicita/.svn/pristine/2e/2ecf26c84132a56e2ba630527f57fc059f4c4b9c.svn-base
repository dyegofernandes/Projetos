package br.com.weblicita.bo.licitacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.licitacao.LicitanteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.licitacao.Licitante;

/**
 *
 * @author Juniel
 */
@Stateless
public class LicitanteBO extends AbstractBusinessObject<Licitante> {

    @EJB
    private LicitanteDAO licitanteDAO;
    
    @Override
    public LicitanteDAO getDAO() {
        return licitanteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Licitante licitante) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
