package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.DespesaPublicaDAO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class DespesaPublicaBO extends AbstractBusinessObject<DespesaPublica> {

    @EJB
    private DespesaPublicaDAO despesaPublicaDAO;

    @Override
    public DespesaPublicaDAO getDAO() {
        return despesaPublicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DespesaPublica despesaPublica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<DespesaPublica> consultar(List<UnidadeOrcamentaria> unidades, String numeroProcesso, AcaoOrcamentaria acaoOrcamentaria, FonteDeRecurso fonte, NaturezaDeDespesa natureza, AcaoEstrategica acaoEstrategica, Produto produto) {
        Restrictions restrictions = new Restrictions();

        if (unidades != null) {
            if (unidades.size() > 0) {
                restrictions.in("unidade", unidades);
            }
        }

        if (Utils.isNullOrEmpty(numeroProcesso)) {
            restrictions.add("despesa.numeroProcesso", numeroProcesso);
        }

        List<DespesaPublica> depesasas = getDAO().getQueryBuilder().selectDistinct("despesa").from(DespesaPublica.class, "despesa")
                .leftJoinFetch("despesa.unidadeOrcamentaria", "unidade").leftJoinFetch("despesa.dotacao", "dotacoes").orderBy("unidade").getResultList();

        return depesasas;
    }

}
