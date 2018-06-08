package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.DepositoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Deposito;
import br.com.facilpagar.modelo.dados.vos.BoletoVO;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.Utils;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class DepositoBO extends AbstractBusinessObject<Deposito> {

    @EJB
    private DepositoDAO depositoDAO;

    @Override
    public DepositoDAO getDAO() {
        return depositoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Deposito deposito) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Deposito> listar(FiltrosBusca filtros) {
        Restrictions restrictions = new Restrictions();
        
        if (filtros.getFranquia() != null) {
            restrictions.add("franquia", filtros.getFranquia());
        }

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (filtros.getBanco1() != null) {
            restrictions.add("banco", filtros.getBanco1());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.add("deposito.agencia", filtros.getNome());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("deposito.depositado", filtros.getAtivo().isStatus());
        }

        if (filtros.getDataInicial1() != null) {
            restrictions.greaterEqualsThan("deposito.dt_deposito", filtros.getDataInicial1(), TemporalType.DATE);
        }

        if (filtros.getDataFinal1() != null) {
            restrictions.lessEqualsThan("deposito.dt_deposito", filtros.getDataFinal1(), TemporalType.DATE);
        }

        if (filtros.getSituacaoDeposito() != null) {
            restrictions.add("deposito.situacao", filtros.getSituacaoDeposito());
        }

        return getDAO().getQueryBuilder().from(Deposito.class, "deposito").leftJoinFetch("deposito.convenio", "convenio").leftJoinFetch("deposito.franquia", "franquia")
                .leftJoinFetch("deposito.banco", "banco").add(restrictions).orderBy("convenio,deposito.dt_deposito, deposito.situacao").getResultList();
    }

    /**
     *
     * @param deposito
     * @return nossoNumero, dt_baixado, valor_recebido, valor_tarifa,
     * valor_deposito (valor_recebido-valor_tarifa)
     */
    public List<BoletoVO> boletos(Deposito deposito) {
        List<BoletoVO> boletos = new ArrayList<BoletoVO>();

        return boletos;
    }
}
