package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.GrupoLojaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.GrupoLoja;

/**
 *
 * @author juniel
 */
@Stateless
public class GrupoLojaBO extends AbstractBusinessObject<GrupoLoja> {

    @EJB
    private GrupoLojaDAO grupoLojaDAO;
    
    @Override
    public GrupoLojaDAO getDAO() {
        return grupoLojaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(GrupoLoja grupoLoja) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
