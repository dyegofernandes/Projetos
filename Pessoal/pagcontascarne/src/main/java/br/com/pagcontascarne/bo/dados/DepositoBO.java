package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.DepositoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Deposito;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.Utils;
import com.xpert.persistence.query.Restrictions;

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

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (filtros.getBanco1() != null) {
            restrictions.add("banco", filtros.getBanco1());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.add("deposito.agencia", filtros.getNome());
        }

        if (filtros.isAtivo()) {
            restrictions.add("deposito.depositado", filtros.isAtivo());
        }

        return getDAO().getQueryBuilder().from(Deposito.class, "deposito").leftJoinFetch("deposito.convenio", "convenio")
                .leftJoinFetch("deposito.banco", "banco").add(restrictions).orderBy("convenio,dt_deposito").getResultList();
    }

}
