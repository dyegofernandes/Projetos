package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.AgenteCobradorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.AgenteCobrador;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class AgenteCobradorBO extends AbstractBusinessObject<AgenteCobrador> {

    @EJB
    private AgenteCobradorDAO agenteCobradorDAO;
    
    @Override
    public AgenteCobradorDAO getDAO() {
        return agenteCobradorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "nome");
    }

    @Override
    public void validate(AgenteCobrador agenteCobrador) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
