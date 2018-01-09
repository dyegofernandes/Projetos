package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.GrupoFornecedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoFornecedor;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class GrupoFornecedorBO extends AbstractBusinessObject<GrupoFornecedor> {

    @EJB
    private GrupoFornecedorDAO grupoFornecedorDAO;

    @Override
    public GrupoFornecedorDAO getDAO() {
        return grupoFornecedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "nome");
    }

    @Override
    public void validate(GrupoFornecedor grupoFornecedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
