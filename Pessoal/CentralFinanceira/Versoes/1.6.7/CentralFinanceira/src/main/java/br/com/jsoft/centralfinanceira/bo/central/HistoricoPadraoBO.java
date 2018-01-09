package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.HistoricoPadraoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.HistoricoPadrao;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class HistoricoPadraoBO extends AbstractBusinessObject<HistoricoPadrao> {

    @EJB
    private HistoricoPadraoDAO historicoPadraoDAO;

    @Override
    public HistoricoPadraoDAO getDAO() {
        return historicoPadraoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "descricao", "tipo");
    }

    @Override
    public void validate(HistoricoPadrao historicoPadrao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
