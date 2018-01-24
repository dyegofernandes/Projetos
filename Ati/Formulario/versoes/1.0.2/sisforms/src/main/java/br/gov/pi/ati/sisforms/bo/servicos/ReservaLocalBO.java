package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.ReservaLocalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import br.gov.pi.ati.sisforms.util.Utils;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReservaLocalBO extends AbstractBusinessObject<ReservaLocal> {

    @EJB
    private ReservaLocalDAO reservaLocalDAO;

    @Override
    public ReservaLocalDAO getDAO() {
        return reservaLocalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ReservaLocal reservaLocal) throws BusinessException {
        Restrictions restrictions;

        if (reservaLocal.getDataInicio().after(reservaLocal.getDataFinal())) {
            throw new BusinessException("Data inicial não pode ser maior que a data final.");
        }

        if (reservaLocal.getDataInicio().before(new Date())) {
            throw new BusinessException("Data inicial deve ser maior ou igual a data atual.");
        }

        if (verificarSeTaNoIntervalo(reservaLocal.getDataInicio(), reservaLocal.getDataFinal())) {
            throw new BusinessException("Já existe reservas para esse local nas datas informadas!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    //        where (s2 < e1 and e2 > s1) or (s1 < e2 and e1 > s2)
    private boolean verificarSeTaNoIntervalo(Date dataInicio, Date dataFim) {

        String queryString = ("select * from reservalocal r where ('DATA_INICIO' < r.datafinal and 'DATA_FIM' > r.datainicio) or (r.datainicio < 'DATA_FIM' and datafinal > 'DATA_INICIO')"
                .replace("DATA_INICIO", Utils.convertDateToString(dataInicio, "yyyy-MM-dd HH:mm"))
                .replace("DATA_FIM", Utils.convertDateToString(dataFim, "yyyy-MM-dd HH:mm")));

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        if (resultado.size() > 0) {
            return true;
        }

        return false;
    }

}
