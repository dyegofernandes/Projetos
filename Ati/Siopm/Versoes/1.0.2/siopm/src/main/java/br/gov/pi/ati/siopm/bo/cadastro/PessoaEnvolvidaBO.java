package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.PessoaEnvolvidaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;

/**
 *
 * @author Juniel
 */
@Stateless
public class PessoaEnvolvidaBO extends AbstractBusinessObject<PessoaEnvolvida> {

    @EJB
    private PessoaEnvolvidaDAO pessoaEnvolvidaDAO;
    
    @Override
    public PessoaEnvolvidaDAO getDAO() {
        return pessoaEnvolvidaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PessoaEnvolvida pessoaEnvolvida) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
