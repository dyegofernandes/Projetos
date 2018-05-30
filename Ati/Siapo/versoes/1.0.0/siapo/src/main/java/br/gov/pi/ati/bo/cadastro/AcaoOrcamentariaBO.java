package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.AcaoOrcamentariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcaoOrcamentariaBO extends AbstractBusinessObject<AcaoOrcamentaria> {

    @EJB
    private AcaoOrcamentariaDAO acaoOrcamentariaDAO;

    @Override
    public AcaoOrcamentariaDAO getDAO() {
        return acaoOrcamentariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AcaoOrcamentaria acaoOrcamentaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<AcaoOrcamentaria> listarPeloNomeEUnidadeOrcamentaria(String nome, UnidadeOrcamentaria unidade) {
        Restrictions restrictions = new Restrictions();

        if (unidade != null) {
            restrictions.add("unidadeOrcamentaria", unidade);
        } else {
            return null;
        }

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("acao.codigo", nome);
            } else {
                restrictions.like("acao.nome", nome);
            }
        }

        return getDAO().getQueryBuilder().select("acao").from(AcaoOrcamentaria.class, "acao").leftJoin("acao.unidadeOrcamentaria", "unidadeOrcamentaria")
                .leftJoinFetch("acao.funcao", "funcao").leftJoinFetch("acao.subfuncao", "subfuncao").leftJoinFetch("acao.programa", "programa")
                .add(restrictions).orderBy("unidadeOrcamentaria, acao.nome").getResultList();
    }

}
