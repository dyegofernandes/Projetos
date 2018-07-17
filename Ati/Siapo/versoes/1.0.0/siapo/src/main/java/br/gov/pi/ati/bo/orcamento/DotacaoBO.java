package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.DotacaoDAO;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.Dotacao;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class DotacaoBO extends AbstractBusinessObject<Dotacao> {

    @EJB
    private DotacaoDAO dotacaoDAO;

    @Override
    public DotacaoDAO getDAO() {
        return dotacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Dotacao dotacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Dotacao> dotacoes(Filtros filtros) {
        Restrictions restrictions = new Restrictions();

        if (filtros.getUnidadesOrcamentaria() != null) {
            if (filtros.getUnidadesOrcamentaria().size() > 0) {
                restrictions.in("unidadeOrcamentaria", filtros.getUnidadesOrcamentaria());
            }
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("dotacao.homologado", filtros.getAtivo());
        }

        return getDAO().getQueryBuilder().select("dotacao").from(Dotacao.class, "dotacao").leftJoinFetch("dotacao.despesaPublica", "despesaPublica")
                .leftJoinFetch("dotacao.execucaoOrcamentaria", "execucaoOrcamentaria").leftJoinFetch("execucaoOrcamentaria.acaoOrcamentaria", "acaoOrcamentaria")
                .leftJoinFetch("acaoOrcamentaria.unidadeOrcamentaria", "unidadeOrcamentaria").leftJoinFetch("execucaoOrcamentaria.fonteDeRecurso", "fonteDeRecurso")
                .leftJoinFetch("execucaoOrcamentaria.naturezaDaDespesa", "naturezaDaDespesa").leftJoinFetch("dotacao.produtoLDO", "produtoLDO")
                .leftJoinFetch("produtoLDO.produto", "produto").add(restrictions).orderBy("")
                .getResultList();
    }

}
