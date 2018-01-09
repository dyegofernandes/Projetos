package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.PessoaDenunciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.PessoaDenuncia;

/**
 *
 * @author Juniel
 */
@Stateless
public class PessoaDenunciaBO extends AbstractBusinessObject<PessoaDenuncia> {

    @EJB
    private PessoaDenunciaDAO pessoaDenunciaDAO;
    
    @Override
    public PessoaDenunciaDAO getDAO() {
        return pessoaDenunciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PessoaDenuncia pessoaDenuncia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
