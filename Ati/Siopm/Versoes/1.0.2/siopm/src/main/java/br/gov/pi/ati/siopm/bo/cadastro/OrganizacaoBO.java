package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.OrganizacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrganizacaoBO extends AbstractBusinessObject<Organizacao> {

    @EJB
    private OrganizacaoDAO organizacaoPolicialDAO;

    @Override
    public OrganizacaoDAO getDAO() {
        return organizacaoPolicialDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Organizacao organizacaoPolicial) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
