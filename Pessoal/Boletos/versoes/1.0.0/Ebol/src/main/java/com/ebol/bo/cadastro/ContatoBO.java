package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.ContatoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Contato;
import com.ebol.modelo.cadastro.Convenio;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContatoBO extends AbstractBusinessObject<Contato> {

    @EJB
    private ContatoDAO contatoDAO;

    @Override
    public ContatoDAO getDAO() {
        return contatoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio", "nome");
    }

    @Override
    public void validate(Contato contato) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Contato> contatosPorConvenio(Convenio convenio) {
        return getDAO().list("convenio", convenio, "nome");
    }

}
