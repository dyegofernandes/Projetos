package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.DespesaPublicaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;

/**
 *
 * @author Juniel
 */
@Stateless
public class DespesaPublicaBO extends AbstractBusinessObject<DespesaPublica> {

    @EJB
    private DespesaPublicaDAO despesaPublicaDAO;
    
    @Override
    public DespesaPublicaDAO getDAO() {
        return despesaPublicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DespesaPublica despesaPublica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
