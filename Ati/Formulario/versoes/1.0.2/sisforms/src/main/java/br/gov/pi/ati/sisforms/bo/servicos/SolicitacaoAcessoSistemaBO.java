package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.impl.SolicitacaoAcessoSistemaDAO;
import br.gov.pi.ati.sisforms.modelo.enums.NomeSistema;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.SolicitacaoAcessoSistema;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitacaoAcessoSistemaBO extends AbstractBusinessObject<SolicitacaoAcessoSistema> {

    @EJB
    private SolicitacaoAcessoSistemaDAO solicitacaoAcessoSistemaDAO;

    @Override
    public SolicitacaoAcessoSistemaDAO getDAO() {
        return solicitacaoAcessoSistemaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(SolicitacaoAcessoSistema solicitacaoAcessoSistema) throws BusinessException {
        
        if(solicitacaoAcessoSistema.getTipo()!=TrabalhadorTipo.SERVIDOR){
            throw new BusinessException("Acesso Permitido apenas para servidores do Estado!");
        }
        if (solicitacaoAcessoSistema.getAcessoAoSistema() == NomeSistema.INFOFOLHA && solicitacaoAcessoSistema.getPerfilsInfofolha().size() < 1) {
            throw new BusinessException("Selecione um ou mais Perfils para o Sistema InfoFolha!");
        }

        if (solicitacaoAcessoSistema.getAcessoAoSistema() == NomeSistema.SFP && solicitacaoAcessoSistema.getPerfilsSFP().size() < 1) {
            throw new BusinessException("Selecione um ou mais Perfils para o Sistema de Folha de Pagamento - SFP!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
