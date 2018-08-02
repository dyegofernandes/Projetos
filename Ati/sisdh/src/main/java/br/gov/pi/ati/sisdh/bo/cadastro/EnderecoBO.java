package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.EnderecoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.Endereco;

/**
 *
 * @author ads01
 */
@Stateless
public class EnderecoBO extends AbstractBusinessObject<Endereco> {

    @EJB
    private EnderecoDAO enderecoDAO;
    
    @Override
    public EnderecoDAO getDAO() {
        return enderecoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Endereco endereco) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
