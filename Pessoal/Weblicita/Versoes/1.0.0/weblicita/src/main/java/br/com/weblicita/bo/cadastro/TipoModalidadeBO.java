package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.TipoModalidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.TipoModalidade;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoModalidadeBO extends AbstractBusinessObject<TipoModalidade> {

    @EJB
    private TipoModalidadeDAO tipoModalidadeDAO;
    
    @Override
    public TipoModalidadeDAO getDAO() {
        return tipoModalidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("descricao");
    }

    @Override
    public void validate(TipoModalidade tipoModalidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
