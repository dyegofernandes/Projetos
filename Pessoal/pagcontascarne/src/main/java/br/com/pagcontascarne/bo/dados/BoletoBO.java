package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.BoletoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Boleto;
import com.xpert.core.validation.UniqueFields;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class BoletoBO extends AbstractBusinessObject<Boleto> {

    @EJB
    private BoletoDAO boletoDAO;

    @Override
    public BoletoDAO getDAO() {
        return boletoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nossonumero").add("cb");
    }

    @Override
    public void validate(Boleto boleto) throws BusinessException {
        if (boleto.getDt_vencimento().before(new Date())) {
            throw new BusinessException("Data do Vencimento do Boleto não pode ser interior a Data Atual!");
        }

        if (boleto.getQtd_total_parcela() < boleto.getNr_parcela()) {
            throw new BusinessException("Quantidade de Parcelas não pode ser menor que o Número de Parcelas!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
