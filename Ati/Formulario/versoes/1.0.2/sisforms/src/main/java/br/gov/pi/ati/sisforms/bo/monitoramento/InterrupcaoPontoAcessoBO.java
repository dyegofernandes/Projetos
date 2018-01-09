package br.gov.pi.ati.sisforms.bo.monitoramento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.monitoramento.InterrupcaoPontoAcessoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.TipoDeAcesso;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.monitoramento.InterrupcaoPontoAcesso;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class InterrupcaoPontoAcessoBO extends AbstractBusinessObject<InterrupcaoPontoAcesso> {

    @EJB
    private InterrupcaoPontoAcessoDAO interrupcaoPontoAcessoDAO;

    @Override
    public InterrupcaoPontoAcessoDAO getDAO() {
        return interrupcaoPontoAcessoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(InterrupcaoPontoAcesso interrupcaoPontoAcesso) throws BusinessException {
        if (interrupcaoPontoAcesso.getDataInicial() != null && interrupcaoPontoAcesso.getDataFinal() != null) {
            if (interrupcaoPontoAcesso.getDataInicial().after(interrupcaoPontoAcesso.getDataFinal())) {
                throw new BusinessException("Data Final deve ser maior que a Data Inicial!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<InterrupcaoPontoAcesso> listar(PontoAcesso ponto, TipoDeAcesso tipo, Date dataInicial, Date dataFinal,
            String numOS, String numSYSAID) {
        List<InterrupcaoPontoAcesso> lista = null;
        Restrictions restrictions = new Restrictions();

        if (ponto != null) {
            restrictions.add("ponto", ponto);
        }

        if (tipo != null) {
            restrictions.add("ponto.tipoAcesso", tipo);
        }

        if (dataInicial != null) {
            restrictions.greaterEqualsThan("interrupcao.dataInicial", dataInicial);
        }
        if (dataFinal != null) {
            restrictions.lessEqualsThan("interrupcao.dataFinal", dataFinal);
        }

        if (numOS != null) {
            if (!numOS.equals("")) {
                restrictions.add("interrupcao.numeroOrdemServico", numOS);
            }
        }

        if (numSYSAID != null) {
            if (!numSYSAID.equals("")) {
                restrictions.add("interrupcao.numeroSysaid", numSYSAID);
            }
        }

        lista = getDAO().getQueryBuilder().from(InterrupcaoPontoAcesso.class, "interrupcao").leftJoinFetch("interrupcao.indentificacao", "ponto").
                add(restrictions).orderBy("interrupcao.dataInicial DESC").getResultList();

        return lista;
    }

}
