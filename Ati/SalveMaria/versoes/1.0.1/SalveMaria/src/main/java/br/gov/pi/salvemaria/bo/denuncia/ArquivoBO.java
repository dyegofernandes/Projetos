package br.gov.pi.salvemaria.bo.denuncia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.denuncia.ArquivoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoBO extends AbstractBusinessObject<Arquivo> {

    @EJB
    private ArquivoDAO arquivoDAO;

    @Override
    public ArquivoDAO getDAO() {
        return arquivoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Arquivo arquivo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Arquivo> listarArquivos(Denuncia denuncia) {
        return arquivoDAO.list("denuncia", denuncia, "nome");
    }

}
