package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.MetaAcaoEstrategicaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaAcaoEstrategicaBO extends AbstractBusinessObject<MetaAcaoEstrategica> {

    @EJB
    private MetaAcaoEstrategicaDAO metaAcaoEstrategicaDAO;
    
    @Override
    public MetaAcaoEstrategicaDAO getDAO() {
        return metaAcaoEstrategicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MetaAcaoEstrategica metaAcaoEstrategica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
