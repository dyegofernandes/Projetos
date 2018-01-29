package br.com.weblicita.bo.licitacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.licitacao.ProponenteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.licitacao.Proponente;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProponenteBO extends AbstractBusinessObject<Proponente> {

    @EJB
    private ProponenteDAO proponenteDAO;
    
    @Override
    public ProponenteDAO getDAO() {
        return proponenteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Proponente proponente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
