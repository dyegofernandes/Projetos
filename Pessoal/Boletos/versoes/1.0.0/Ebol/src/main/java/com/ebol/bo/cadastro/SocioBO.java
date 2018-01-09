package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.SocioDAO;
import com.ebol.modelo.cadastro.Convenio;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Socio;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class SocioBO extends AbstractBusinessObject<Socio> {

    @EJB
    private SocioDAO socioDAO;
    
    @Override
    public SocioDAO getDAO() {
        return socioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio","nome");
    }

    @Override
    public void validate(Socio socio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<Socio> sociosPorConvenio(Convenio convenio){
        return socioDAO.list("convenio", convenio, "nome");
    }

}
