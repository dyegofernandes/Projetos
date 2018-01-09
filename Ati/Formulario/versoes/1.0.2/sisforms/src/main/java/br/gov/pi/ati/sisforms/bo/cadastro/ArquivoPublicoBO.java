package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.ArquivoPublicoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoPublico;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoPublicoBO extends AbstractBusinessObject<ArquivoPublico> {

    @EJB
    private ArquivoPublicoDAO arquivoPublicoDAO;
    
    @Override
    public ArquivoPublicoDAO getDAO() {
        return arquivoPublicoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ArquivoPublico arquivoPublico) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
