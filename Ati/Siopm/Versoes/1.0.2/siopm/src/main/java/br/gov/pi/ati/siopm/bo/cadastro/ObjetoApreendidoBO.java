package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ObjetoApreendidoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;

/**
 *
 * @author Juniel
 */
@Stateless
public class ObjetoApreendidoBO extends AbstractBusinessObject<ObjetoApreendido> {

    @EJB
    private ObjetoApreendidoDAO objetoApreendidoDAO;
    
    @Override
    public ObjetoApreendidoDAO getDAO() {
        return objetoApreendidoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ObjetoApreendido objetoApreendido) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
