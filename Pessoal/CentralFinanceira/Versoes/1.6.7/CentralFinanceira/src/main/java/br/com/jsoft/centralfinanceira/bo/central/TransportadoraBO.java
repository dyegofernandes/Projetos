package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.TransportadoraDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Transportadora;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TransportadoraBO extends AbstractBusinessObject<Transportadora> {

    @EJB
    private TransportadoraDAO transportadoraDAO;
    
    @Override
    public TransportadoraDAO getDAO() {
        return transportadoraDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","nome");
    }

    @Override
    public void validate(Transportadora transportadora) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
