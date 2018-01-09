package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.ArquivoRelatorioDeViagemDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeViagem;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoRelatorioDeViagemBO extends AbstractBusinessObject<ArquivoRelatorioDeViagem> {

    @EJB
    private ArquivoRelatorioDeViagemDAO arquivoRelatorioDeViagemDAO;
    
    @Override
    public ArquivoRelatorioDeViagemDAO getDAO() {
        return arquivoRelatorioDeViagemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ArquivoRelatorioDeViagem arquivoRelatorioDeViagem) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
