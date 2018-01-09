package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.ArquivoRelatorioDeVisitaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeVisita;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoRelatorioDeVisitaBO extends AbstractBusinessObject<ArquivoRelatorioDeVisita> {

    @EJB
    private ArquivoRelatorioDeVisitaDAO arquivoRelatorioDeVisitaDAO;
    
    @Override
    public ArquivoRelatorioDeVisitaDAO getDAO() {
        return arquivoRelatorioDeVisitaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ArquivoRelatorioDeVisita arquivoRelatorioDeVisita) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
