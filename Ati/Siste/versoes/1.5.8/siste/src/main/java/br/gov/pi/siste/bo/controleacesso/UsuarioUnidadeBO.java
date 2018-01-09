package br.gov.pi.siste.bo.controleacesso;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.controleacesso.UsuarioUnidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.controleacesso.UsuarioUnidade;

/**
 *
 * @author Juniel
 */
@Stateless
public class UsuarioUnidadeBO extends AbstractBusinessObject<UsuarioUnidade> {

    @EJB
    private UsuarioUnidadeDAO usuarioUnidadeDAO;
    
    @Override
    public UsuarioUnidadeDAO getDAO() {
        return usuarioUnidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(UsuarioUnidade usuarioUnidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
