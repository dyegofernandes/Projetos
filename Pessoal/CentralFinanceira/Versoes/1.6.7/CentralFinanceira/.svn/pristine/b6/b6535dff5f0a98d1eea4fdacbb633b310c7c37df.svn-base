package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.EstabelecimentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Estabelecimento;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class EstabelecimentoBO extends AbstractBusinessObject<Estabelecimento> {

    @EJB
    private EstabelecimentoDAO estabelecimentoDAO;
    
    @Override
    public EstabelecimentoDAO getDAO() {
        return estabelecimentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","nome");
    }

    @Override
    public void validate(Estabelecimento estabelecimento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
