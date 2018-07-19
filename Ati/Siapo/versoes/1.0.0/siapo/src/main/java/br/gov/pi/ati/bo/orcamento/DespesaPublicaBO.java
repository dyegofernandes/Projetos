package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.DespesaPublicaDAO;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;
import javax.persistence.TemporalType;

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
        List<ProgramacaoFinanceira> programacoes = getDAO().getInitialized(despesaPublica.getProgramacaoFinanceira());

        if (programacoes.size() < 1) {
            throw new BusinessException("Programação financeira é obrigatória!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<DespesaPublica> consultar(Filtros filtros) {
        Restrictions restrictions = new Restrictions();

        if (filtros.getUnidadesOrcamentaria() != null) {
            if (filtros.getUnidadesOrcamentaria().size() > 0) {
                restrictions.in("unidade", filtros.getUnidadesOrcamentaria());
            } else {
                return null;
            }
        } else {
            return null;
        }

        if (!Utils.isNullOrEmpty(filtros.getNumProcesso())) {
            restrictions.add("despesa.numeroProcesso", filtros.getNumProcesso().toUpperCase());
        }

        if (!Utils.isNullOrEmpty(filtros.getSubElemento())) {
            restrictions.add("despesa.subelemento", filtros.getSubElemento().toUpperCase());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("despesa.homologado", filtros.getAtivo());
        }

        if (filtros.getAtivo2() != null) {
            restrictions.add("despesa.geraQuantificador", filtros.getAtivo2());
        }

        if (filtros.getUsuario() != null) {
            restrictions.add("despesa.responsavel", filtros.getUsuario());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("despesa.dataCadastro", filtros.getDataInicial(), TemporalType.DATE);
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("despesa.dataCadastro", filtros.getDataFinal(), TemporalType.DATE);
        }

        if (filtros.getDataInicial2() != null) {
            restrictions.greaterEqualsThan("despesa.dataHomologacao", filtros.getDataInicial2(), TemporalType.DATE);
        }

        if (filtros.getDataFinal2() != null) {
            restrictions.lessEqualsThan("despesa.dataHomologacao", filtros.getDataFinal2(), TemporalType.DATE);
        }

        if (filtros.getAcaoOrcamentaria() != null) {
            restrictions.add("acaoOrcamentaria", filtros.getAcaoOrcamentaria());
        }

        if (filtros.getFonteDeRecurso() != null) {
            restrictions.add("fonteDeRecurso", filtros.getFonteDeRecurso());
        }

        if (filtros.getNaturezaDespesa() != null) {
            restrictions.add("naturezaDaDespesa", filtros.getNaturezaDespesa());
        }

        List<DespesaPublica> depesasas = getDAO().getQueryBuilder().select("despesa").from(DespesaPublica.class, "despesa").leftJoinFetch("despesa.unidadeOrcamentaria", "unidade")
                .leftJoinFetch("despesa.produtoLDO", "produtoLDO").leftJoinFetch("produtoLDO.produto", "produto").leftJoinFetch("produtoLDO.unidadeMedida", "unidadeMedida")
                .leftJoinFetch("produtoLDO.metaAcao", "metaAcaoEstrategica").leftJoinFetch("metaAcaoEstrategica.acaoEstrategica", "acaoEstrategica")
                .leftJoinFetch("metaAcaoEstrategica.programaPPA", "programaPPA").leftJoinFetch("programaPPA.programaGov", "programaGov")
                .leftJoinFetch("despesa.execucaoOrcamentaria", "execucaoOrcamentaria").leftJoinFetch("execucaoOrcamentaria.acaoOrcamentaria", "acaoOrcamentaria")
                .leftJoinFetch("execucaoOrcamentaria.fonteDeRecurso", "fonteDeRecurso").leftJoinFetch("execucaoOrcamentaria.acaoOrcamentaria", "acaoOrcamentaria")
                .leftJoinFetch("execucaoOrcamentaria.naturezaDaDespesa", "naturezaDaDespesa").add(restrictions).orderBy("unidade").getResultList();
//
        return depesasas;
    }

}
