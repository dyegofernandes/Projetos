package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.PerfilInfoFolhaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilInfoFolha;

/**
 *
 * @author Juniel
 */
@Stateless
public class PerfilInfoFolhaBO extends AbstractBusinessObject<PerfilInfoFolha> {

    @EJB
    private PerfilInfoFolhaDAO perfilInfoFolhaDAO;
    
    @Override
    public PerfilInfoFolhaDAO getDAO() {
        return perfilInfoFolhaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PerfilInfoFolha perfilInfoFolha) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
