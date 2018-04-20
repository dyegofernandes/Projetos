package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.MetaProdutoDAO;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaProdutoBO extends AbstractBusinessObject<MetaProduto> {

    @EJB
    private MetaProdutoDAO metaProdutoDAO;

    @Override
    public MetaProdutoDAO getDAO() {
        return metaProdutoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MetaProduto metaProduto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<MetaProduto> listar(Filtros filtros) {
        Restrictions restrictions = new Restrictions();

        if (filtros.getUnidadeOrcamentaria() != null) {
            filtros.getUnidadesOrcamentaria().add(filtros.getUnidadeOrcamentaria());
        }

        if (filtros.getUnidadesOrcamentaria().size() > 0) {
            restrictions.in("unidadeOrcamentaria", filtros.getUnidadesOrcamentaria());
        }

        if (filtros.getAcaoEstrategica() != null) {
            restrictions.add("acaoEstrategica", filtros.getAcaoEstrategica());
        }

        if (filtros.getProgramaDeGoverno() != null) {
            restrictions.add("programaGov", filtros.getProgramaDeGoverno());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.like("produto.nome", filtros.getNome());
        }

        return getDAO().getQueryBuilder().selectDistinct("meta").from(MetaProduto.class, "meta").leftJoinFetch("meta.produto", "produto")
                .leftJoinFetch("meta.metaAcao", "metaAcao").leftJoinFetch("metaAcao.acaoEstrategica", "acaoEstrategica")
                .leftJoinFetch("acaoEstrategica.unidadeOrcamentaria", "unidadeOrcamentaria")
                .leftJoinFetch("metaAcao.programaPPA", "programaPPA").leftJoinFetch("programaPPA.programaGov", "programaGov")
                .leftJoinFetch("programaPPA.competencia", "competencia")
                .leftJoin("meta.territorios", "territorios")
                .leftJoin("meta.ldos", "ldos")
                .add(restrictions).orderBy("unidadeOrcamentaria, produto.nome").getResultList();
    }
}
