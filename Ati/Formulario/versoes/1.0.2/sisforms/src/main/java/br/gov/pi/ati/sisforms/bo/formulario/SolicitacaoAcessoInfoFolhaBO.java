package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.SolicitacaoAcessoInfoFolhaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoInfoFolha;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitacaoAcessoInfoFolhaBO extends AbstractBusinessObject<SolicitacaoAcessoInfoFolha> {

    @EJB
    private SolicitacaoAcessoInfoFolhaDAO solicitacaoAcessoInfoFolhaDAO;

    @Override
    public SolicitacaoAcessoInfoFolhaDAO getDAO() {
        return solicitacaoAcessoInfoFolhaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(SolicitacaoAcessoInfoFolha solicitacaoAcessoInfoFolha) throws BusinessException {
        if (solicitacaoAcessoInfoFolha.getOrgaosDeAcessos().size() < 1) {
            throw new BusinessException("Informe o (s) Órgão (s) de acesso do usuário!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
