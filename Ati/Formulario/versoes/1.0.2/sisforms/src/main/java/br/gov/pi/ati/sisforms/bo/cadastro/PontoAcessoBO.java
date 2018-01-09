package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.PontoAcessoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import br.gov.pi.ati.sisforms.util.Utils;

/**
 *
 * @author Juniel
 */
@Stateless
public class PontoAcessoBO extends AbstractBusinessObject<PontoAcesso> {

    @EJB
    private PontoAcessoDAO pontoAcessoDAO;

    @Override
    public PontoAcessoDAO getDAO() {
        return pontoAcessoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PontoAcesso pontoAcesso) throws BusinessException {
        if (!Utils.stringEhDoobleValido(pontoAcesso.getLatidude())) {
            throw new BusinessException("O formato da latitude é inválido!");
        }

        if (!Utils.stringEhDoobleValido(pontoAcesso.getLongitude())) {
            throw new BusinessException("O formato da longitude é inválido!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
