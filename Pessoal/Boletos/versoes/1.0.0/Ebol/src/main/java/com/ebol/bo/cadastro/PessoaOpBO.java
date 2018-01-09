package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.PessoaOpDAO;
import com.ebol.modelo.cadastro.Convenio;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.PessoaOp;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class PessoaOpBO extends AbstractBusinessObject<PessoaOp> {

    @EJB
    private PessoaOpDAO pessoaOpDAO;

    @Override
    public PessoaOpDAO getDAO() {
        return pessoaOpDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio", "cpf").add("convenio", "nome").add("convenio", "rg");
    }

    @Override
    public void validate(PessoaOp pessoaOp) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<PessoaOp> pessoasPorConvenio(Convenio convenio) {
        return pessoaOpDAO.list("convenio", convenio, "nome");
    }
}
