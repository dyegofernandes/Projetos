package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.RepresentanteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Representante;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class RepresentanteBO extends AbstractBusinessObject<Representante> {

    @EJB
    private RepresentanteDAO representanteDAO;
    
    @Override
    public RepresentanteDAO getDAO() {
        return representanteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","nome");
    }

    @Override
    public void validate(Representante representante) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
