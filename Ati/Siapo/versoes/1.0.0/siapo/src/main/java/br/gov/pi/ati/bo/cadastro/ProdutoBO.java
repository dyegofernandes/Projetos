package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ProdutoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Produto;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProdutoBO extends AbstractBusinessObject<Produto> {

    @EJB
    private ProdutoDAO produtoDAO;
    
    @Override
    public ProdutoDAO getDAO() {
        return produtoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("orgao", "nome");
    }

    @Override
    public void validate(Produto produto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
