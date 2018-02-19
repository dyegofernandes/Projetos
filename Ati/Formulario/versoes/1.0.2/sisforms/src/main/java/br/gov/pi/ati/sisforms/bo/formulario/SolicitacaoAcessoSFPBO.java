package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.SolicitacaoAcessoSFPDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoSFP;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitacaoAcessoSFPBO extends AbstractBusinessObject<SolicitacaoAcessoSFP> {

    @EJB
    private SolicitacaoAcessoSFPDAO solicitacaoAcessoSFPDAO;

    @Override
    public SolicitacaoAcessoSFPDAO getDAO() {
        return solicitacaoAcessoSFPDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(SolicitacaoAcessoSFP solicitacaoAcessoSFP) throws BusinessException {
        if (solicitacaoAcessoSFP.getPerfilsSolicitados().size() < 1) {
            throw new BusinessException("Informe um ou mais perfils para acesso!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
