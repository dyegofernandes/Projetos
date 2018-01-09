package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ModuloInfoFolhaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloInfoFolha;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModuloInfoFolhaBO extends AbstractBusinessObject<ModuloInfoFolha> {

    @EJB
    private ModuloInfoFolhaDAO moduloInfoFolhaDAO;
    
    @Override
    public ModuloInfoFolhaDAO getDAO() {
        return moduloInfoFolhaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ModuloInfoFolha moduloInfoFolha) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
