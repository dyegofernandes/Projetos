package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.MetaAcaoEstrategicaDAO;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaAcaoEstrategicaBO extends AbstractBusinessObject<MetaAcaoEstrategica> {

    @EJB
    private MetaAcaoEstrategicaDAO metaAcaoEstrategicaDAO;

    @Override
    public MetaAcaoEstrategicaDAO getDAO() {
        return metaAcaoEstrategicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MetaAcaoEstrategica metaAcaoEstrategica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<MetaAcaoEstrategica> listar(Filtros filtros) {

        Restrictions restrictions = new Restrictions();

        if (filtros.getUnidadeOrcamentaria() != null) {
            filtros.getUnidadesOrcamentaria().add(filtros.getUnidadeOrcamentaria());
        }

        if (filtros.getUnidadesOrcamentaria().size() > 0) {
            restrictions.in("unidadeOrcamentaria", filtros.getUnidadesOrcamentaria());
        }

        if (filtros.getProgramaDeGoverno() != null) {
            restrictions.add("programaGov", filtros.getProgramaDeGoverno());
        }
        
        if(!Utils.isNullOrEmpty(filtros.getNome())){
            restrictions.like("acaoEstrategica.nome", filtros.getNome());
        }
        
        if(!Utils.isNullOrEmpty(filtros.getCodigo())){
            restrictions.add("acaoEstrategica.codigo", filtros.getCodigo());
        }

        return getDAO().getQueryBuilder().from(MetaAcaoEstrategica.class, "metaAcao").leftJoinFetch("metaAcao.acaoEstrategica", "acaoEstrategica")
                .leftJoinFetch("acaoEstrategica.unidadeOrcamentaria", "unidadeOrcamentaria").leftJoinFetch("metaAcao.programaPPA", "programaPPA")
                .leftJoinFetch("programaPPA.programaGov", "programaGov").leftJoinFetch("metaAcao.receitas", "receitas")
                .add(restrictions).orderBy("unidadeOrcamentaria.nome, programaGov.nome, acaoEstrategica.codigo").getResultList();
    }
}
