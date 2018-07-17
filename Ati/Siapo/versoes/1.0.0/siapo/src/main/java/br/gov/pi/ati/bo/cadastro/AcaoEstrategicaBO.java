package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.AcaoEstrategicaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcaoEstrategicaBO extends AbstractBusinessObject<AcaoEstrategica> {

    @EJB
    private AcaoEstrategicaDAO acaoEstrategicaDAO;

    @Override
    public AcaoEstrategicaDAO getDAO() {
        return acaoEstrategicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("unidadeOrcamentaria", "nome");
    }

    @Override
    public void validate(AcaoEstrategica acaoEstrategica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<AcaoEstrategica> acaoPeloNomeEUnidades( List<UnidadeOrcamentaria> unidades, String nome) {
        Restrictions restrictions = new Restrictions();

        List<UnidadeOrcamentaria> unidadesDeAcesso = getDAO().getInitialized(unidades);

        if (unidadesDeAcesso != null) {
            if (unidadesDeAcesso.size() > 0) {
                restrictions.in("unidade", unidadesDeAcesso);
            }
        }

        restrictions.add("acao.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("acao.codigo", nome);
            } else {
                restrictions.like("acao.nome", nome);
            }

        }

        return getDAO().getQueryBuilder().select("acao").from(AcaoEstrategica.class, "acao").leftJoinFetch("acao.unidadeOrcamentaria", "unidade")
                .add(restrictions).orderBy("unidade, acao.nome").getResultList();
    }

}
