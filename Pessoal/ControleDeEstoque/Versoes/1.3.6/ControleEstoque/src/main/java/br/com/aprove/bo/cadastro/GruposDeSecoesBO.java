package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.GruposDeSecoesDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.GruposDeSecoes;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class GruposDeSecoesBO extends AbstractBusinessObject<GruposDeSecoes> {

    @EJB
    private GruposDeSecoesDAO gruposDeSecoesDAO;
    
    @Override
    public GruposDeSecoesDAO getDAO() {
        return gruposDeSecoesDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(GruposDeSecoes gruposDeSecoes) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
