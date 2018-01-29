package br.com.weblicita.bo.licitacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.licitacao.PesquisaDePrecoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.licitacao.PesquisaDePreco;
import br.com.weblicita.modelo.licitacao.Proponente;
import br.com.weblicita.util.Utils;

/**
 *
 * @author Juniel
 */
@Stateless
public class PesquisaDePrecoBO extends AbstractBusinessObject<PesquisaDePreco> {

    @EJB
    private PesquisaDePrecoDAO pesquisaDePrecoDAO;

    @Override
    public PesquisaDePrecoDAO getDAO() {
        return pesquisaDePrecoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PesquisaDePreco pesquisaDePreco) throws BusinessException {
        List<Proponente> proponentes = getDAO().getInitialized(pesquisaDePreco.getProponentes());

        if (proponentes == null && Utils.isNullOrEmpty(pesquisaDePreco.getObservacao())) {
            throw new BusinessException("Observação é obrigatória se não existir Proponentes!");
        } else {
            if (proponentes.size() < 1 && Utils.isNullOrEmpty(pesquisaDePreco.getObservacao())) {
                throw new BusinessException("Observação é obrigatória se não existir Proponentes!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
