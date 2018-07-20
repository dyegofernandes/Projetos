package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.ExecucaoOrcamentariaDAO;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class ExecucaoOrcamentariaBO extends AbstractBusinessObject<ExecucaoOrcamentaria> {

    @EJB
    private ExecucaoOrcamentariaDAO execucaoOrcamentariaDAO;

    @Override
    public ExecucaoOrcamentariaDAO getDAO() {
        return execucaoOrcamentariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ExecucaoOrcamentaria execucaoOrcamentaria) throws BusinessException {
        
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<AcaoOrcamentaria> execucaoOrcamentariaAcaoOrcamentaria(UnidadeOrcamentaria unidade, String nome) {
        Restrictions restrictions = new Restrictions();

        if (unidade == null) {
            return null;
        }

        restrictions.add("unidade", unidade);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("acao.codigo", nome);
            } else {
                restrictions.like("acao.nome", nome);
            }
        }

        List<ExecucaoOrcamentaria> execucoes = getDAO().getQueryBuilder().from(ExecucaoOrcamentaria.class, "execucao").leftJoinFetch("execucao.acaoOrcamentaria", "acao")
                .leftJoinFetch("acao.unidadeOrcamentaria", "unidade").add(restrictions).orderBy("acao.codigo").getResultList();

        List<AcaoOrcamentaria> acoes = new ArrayList<AcaoOrcamentaria>();

        for (ExecucaoOrcamentaria execucoe : execucoes) {
            if (!acoes.contains(execucoe.getAcaoOrcamentaria())) {
                acoes.add(execucoe.getAcaoOrcamentaria());
            }

        }

        return acoes;
    }
    
    public List<AcaoOrcamentaria> execucaoOrcamentariaAcaoOrcamentariaPorUnidades(List<UnidadeOrcamentaria> unidades, String nome) {
        Restrictions restrictions = new Restrictions();

        if (unidades == null) {
            return null;
        }else{
            if(unidades.size()<1){
                return null;
            }
        }

        restrictions.in("unidade", unidades);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("acao.codigo", nome);
            } else {
                restrictions.like("acao.nome", nome);
            }
        }

        List<ExecucaoOrcamentaria> execucoes = getDAO().getQueryBuilder().from(ExecucaoOrcamentaria.class, "execucao").leftJoinFetch("execucao.acaoOrcamentaria", "acao")
                .leftJoinFetch("acao.unidadeOrcamentaria", "unidade").add(restrictions).orderBy("acao.codigo").getResultList();

        List<AcaoOrcamentaria> acoes = new ArrayList<AcaoOrcamentaria>();

        for (ExecucaoOrcamentaria execucoe : execucoes) {
            if (!acoes.contains(execucoe.getAcaoOrcamentaria())) {
                acoes.add(execucoe.getAcaoOrcamentaria());
            }

        }

        return acoes;
    }

    public List<FonteDeRecurso> execucaoOrcamentariaFonte(AcaoOrcamentaria acao, String nome) {
        Restrictions restrictions = new Restrictions();

        if (acao == null) {
            return null;
        }

        restrictions.add("acao", acao);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("fonte.codigo", nome);
            } else {
                restrictions.like("fonte.nome", nome);
            }
        }
        
        List<ExecucaoOrcamentaria> execucoes = getDAO().getQueryBuilder().from(ExecucaoOrcamentaria.class, "execucao").leftJoinFetch("execucao.acaoOrcamentaria", "acao")
                .leftJoinFetch("execucao.fonteDeRecurso", "fonte").add(restrictions).orderBy("fonte.codigo").getResultList();

        List<FonteDeRecurso> fontes = new ArrayList<FonteDeRecurso>();
        for (ExecucaoOrcamentaria execucoe : execucoes) {
            if(!fontes.contains(execucoe.getFonteDeRecurso())){
                fontes.add(execucoe.getFonteDeRecurso());
            }
        }
        return fontes;
    }

    public List<ExecucaoOrcamentaria> execucaoOrcamentariaNatureza(AcaoOrcamentaria acao, FonteDeRecurso fonte, String nome) {
        Restrictions restrictions = new Restrictions();

        if (acao == null) {
            return null;
        }

        if (fonte == null) {
            return null;
        }

        restrictions.add("acao", acao);
        restrictions.add("fonte", fonte);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("natureza.codigo", nome);
            } else {
                restrictions.like("natureza.nome", nome);
            }
        }

        return getDAO().getQueryBuilder().select("execucao").from(ExecucaoOrcamentaria.class, "execucao").leftJoin("execucao.acaoOrcamentaria", "acao")
                .leftJoinFetch("execucao.fonteDeRecurso", "fonte").leftJoinFetch("execucao.naturezaDaDespesa", "natureza").add(restrictions)
                .orderBy("natureza.codigo").getResultList();
    }

}
