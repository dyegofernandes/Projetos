package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.ReservaLocalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

        BusinessException exception = new BusinessException();

        if (reservaLocal.getDataInicio().after(reservaLocal.getDataFinal())) {
            exception.add("Data inicial não pode ser maior que a data final.");
        }

        exception.check();

        if (reservaLocal.getDataInicio().before(new Date())) {
            exception.add("Data inicial deve ser maior ou igual a data atual.");
        }
        
        exception.check();

        if (verificarSeTaNoIntervalo(reservaLocal)) {
            exception.add("Já existe reservas para esse local nas datas informadas!");
        }
        
        exception.check();
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    //        where (s2 < e1 and e2 > s1) or (s1 < e2 and e1 > s2)
    private boolean verificarSeTaNoIntervalo(ReservaLocal reserva) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("l", reserva.getLocalReserva());
        restrictions.startGroup();
        restrictions.startGroup().greaterThan("r.dataFinal", reserva.getDataInicio(), TemporalType.TIMESTAMP).lessThan("dataInicio", reserva.getDataFinal(), TemporalType.TIMESTAMP).endGroup();
        restrictions.or();
        restrictions.startGroup().lessThan("r.dataInicio", reserva.getDataFinal(), TemporalType.TIMESTAMP).greaterThan("r.dataFinal ", reserva.getDataInicio(), TemporalType.TIMESTAMP).endGroup();
        restrictions.endGroup();
        List<ReservaLocal> reservas = getDAO().getQueryBuilder().select("r").from(ReservaLocal.class, "r").leftJoinFetch("r.localReserva", "l")
                .add(restrictions).getResultList();

        if (reservas.size() > 0) {
            return true;
        }

        return false;
    }

    public List<ReservaLocal> locaisPelaReserva(ReservaLocal reserva) {

        List<ReservaLocal> reservas = new ArrayList<ReservaLocal>();

        Calendar inicio = Calendar.getInstance();
        inicio.setTime(reserva.getDataInicio());
        Calendar fim = Calendar.getInstance();
        fim.setTime(reserva.getDataFinal());

        Calendar calInicio = Calendar.getInstance();
        calInicio.setTime(inicio.getTime());

        for (Date dt = inicio.getTime(); dt.compareTo(fim.getTime()) <= 0;) {
            calInicio.add(Calendar.DATE, +1);

            Calendar calFim = Calendar.getInstance();
            calFim.setTime(calInicio.getTime());
            calFim.set(Calendar.HOUR_OF_DAY, fim.get(Calendar.HOUR_OF_DAY));

            ReservaLocal reservaTemp = new ReservaLocal();

            reservaTemp.setLocalReserva(reserva.getLocalReserva());
            reservaTemp.setDataInicio(calInicio.getTime());

            reservaTemp.setDataFinal(calFim.getTime());
            reservaTemp.setNomeSolicitante(reserva.getNomeSolicitante());
            reservaTemp.setObservacao(reserva.getObservacao());
            reservaTemp.setArquivos(reserva.getArquivos());

            reservas.add(reservaTemp);
            dt = calInicio.getTime();
        }

        return reservas;
    }

    public void saveAll(List<ReservaLocal> reservas) throws BusinessException {

        for (ReservaLocal reserva : reservas) {
            try {
                save(reserva);
            } catch (Exception e) {

            }

        }
    }

}
