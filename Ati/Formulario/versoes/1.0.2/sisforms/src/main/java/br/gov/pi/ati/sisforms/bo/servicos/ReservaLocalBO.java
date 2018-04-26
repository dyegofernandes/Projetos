package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.ReservaLocalDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel, Nilson, Samuel, Yago
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
        return new UniqueFields().add("local", "dataInicio", "dataFinal").add("local", "dataInicio").add("local", "dataFinal");
    }

    @Override
    public void validate(ReservaLocal reserva) throws BusinessException {

        Date dataHoje = new Date();
        System.out.println(reserva.getTitulo());
        if (reserva.getDataInicio().before(dataHoje)) {
            System.out.println(reserva.getDataInicio());
                   
            throw new BusinessException("Data inicial não pode ser menor que a data atual.");
        }
        if (reserva.getDataInicio().after(reserva.getDataFinal())) {
            throw new BusinessException("Data inicial não pode ser maior que a data final.");
        }

        if (reserva.getLocal().getAtivo() != true) {
            throw new BusinessException("Local Inválido");
        }

        Restrictions restrictions = new Restrictions();
        Restrictions restrictions2 = new Restrictions();
        Restrictions restrictions3 = new Restrictions();
        Restrictions restrictions4 = new Restrictions();
        restrictions.add("local", reserva.getLocal());
        restrictions2.add("local", reserva.getLocal());
        restrictions3.add("local", reserva.getLocal());
        restrictions4.add("local", reserva.getLocal());

        //  restrictions.lessEqualsThan("dataInicio", agendamento.getDataInicio(), TemporalType.TIMESTAMP);//Nessas duas linhas a gente cria o intervalo entre os dois eventos.
        //  restrictions.greaterEqualsThan("dataFim",agendamento.getDataFim(), TemporalType.TIMESTAMP);
        restrictions2.greaterEqualsThan("dataFinal", reserva.getDataFinal(), TemporalType.TIMESTAMP);//Nessas 2 linhas a gente cria o data fim dentro do intervalo 
        restrictions2.lessEqualsThan("dataInicio", reserva.getDataFinal(), TemporalType.TIMESTAMP);

        restrictions3.lessEqualsThan("dataInicio", reserva.getDataInicio(), TemporalType.TIMESTAMP);//Nessas 2 linhas a gente cria o data inicio dentro do intervalo 
        restrictions3.greaterEqualsThan("dataFinal", reserva.getDataInicio(), TemporalType.TIMESTAMP);

        restrictions4.greaterEqualsThan("dataInicio", reserva.getDataInicio(), TemporalType.TIMESTAMP);
        restrictions4.lessEqualsThan("dataFinal", reserva.getDataFinal(), TemporalType.TIMESTAMP);

        List<ReservaLocal> agendamentos = new ArrayList<ReservaLocal>();
        //if(getDAO().list(restrictions)!= null){
        //              agendamentos = getDAO().list(restrictions);
        // }
        // if(agendamentos.size()>0){
        //     throw new BusinessException("Agendamentos não podem conter o mesmo local e estar entre a mesma data!");
        // }

        if (getDAO().list(restrictions2) != null) {
            agendamentos = getDAO().list(restrictions2);
        }
        if (agendamentos.size() > 0) {
            throw new BusinessException("Agendamentos não podem conter o mesmo local e a data Final estar entre uma data já reservada!");
        }

        if (getDAO().list(restrictions3) != null) {
            agendamentos = getDAO().list(restrictions3);
        }
        if (agendamentos.size() > 0) {
            throw new BusinessException("Agendamentos não podem conter o mesmo local e a data inicial estar entre uma data já reservada!");
        }
        if (getDAO().list(restrictions4) != null) {
            agendamentos = getDAO().list(restrictions4);
        }
        if (agendamentos.size() > 0) {
            throw new BusinessException("Agendamentos não podem conter o mesmo local e a data inicial estar antes de uma data já reservada e a data final depois!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    //        where (s2 < e1 and e2 > s1) or (s1 < e2 and e1 > s2)
    private boolean verificarSeTaNoIntervalo(ReservaLocal reserva) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("l", reserva.getLocal());
        restrictions.startGroup();
        restrictions.startGroup().greaterThan("r.dataFinal", reserva.getDataInicio(), TemporalType.TIMESTAMP).lessThan("dataInicio", reserva.getDataFinal(), TemporalType.TIMESTAMP).endGroup();
        restrictions.or();
        restrictions.startGroup().lessThan("r.dataInicio", reserva.getDataFinal(), TemporalType.TIMESTAMP).greaterThan("r.dataFinal ", reserva.getDataInicio(), TemporalType.TIMESTAMP).endGroup();
        restrictions.endGroup();
        List<ReservaLocal> reservas = getDAO().getQueryBuilder().select("r").from(ReservaLocal.class, "r").leftJoinFetch("r.localReserva", "l")
                .add(restrictions).getResultList();

        if(reservas.size() > 0) {
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

            reservaTemp.setLocal(reserva.getLocal());
            reservaTemp.setDataInicio(calInicio.getTime());

            reservaTemp.setDataFinal(calFim.getTime());
            reservaTemp.setSolicitante(reserva.getSolicitante());
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

    public List<LocalReserva> locaisPorOrgao(Orgao orgao) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("orgao", orgao);
        return getDAO().getQueryBuilder().from(LocalReserva.class, "localReserva").leftJoinFetch("localReserva.orgao", "orgao").
                add(restrictions).orderBy("orgao.nome").getResultList();
    }

    public List<ReservaLocal> reservasPorOrgao(Orgao orgao) {

        Restrictions restrictions = new Restrictions();
        if (orgao != null) {
            restrictions.add("orgao", orgao);
            }
        
        return getDAO().getQueryBuilder().from(ReservaLocal.class, "reservaLocal").leftJoinFetch("reservaLocal.orgao", "orgao").
                    add(restrictions).orderBy("orgao.nome").getResultList();

    }
    
     public List<ReservaLocal> reservasPorLocais(LocalReserva local) {

        Restrictions restrictions = new Restrictions();
        if (local != null) {
            restrictions.add("local", local);
            }
        
        return getDAO().getQueryBuilder().from(ReservaLocal.class, "reservaLocal").leftJoinFetch("reservaLocal.local", "local").
                    add(restrictions).orderBy("local.nome").getResultList();

    }
    
    public List<ReservaLocal> reservasPorDataInicial(Date dataInicial) {

        Restrictions restrictions = new Restrictions();
        if (dataInicial!= null) {
            restrictions.add("dataInicial", dataInicial);
            }
        
        return getDAO().getQueryBuilder().from(ReservaLocal.class, "reservaLocal").leftJoinFetch("reservaLocal.dataInicial", "datainicial").
                    add(restrictions).orderBy("dataInicial").getResultList();

    }

    public List<ReservaLocal> reservasPorDataFinal(Date dataFinal) {

        Restrictions restrictions = new Restrictions();
        if (dataFinal!= null) {
            restrictions.add("dataFinal", dataFinal);
            }
        
        return getDAO().getQueryBuilder().from(ReservaLocal.class, "reservaLocal").leftJoinFetch("reservaLocal.dataFinal", "datafinal").
                    add(restrictions).orderBy("dataFinal").getResultList();

    }
    
    public List<ReservaLocal> listarReservas(FiltrosVO filtros) {

        Restrictions restrictions = new Restrictions();

       
        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }
        if (filtros.getOrgaoSolicitante() != null) {
            restrictions.add("reserva.orgaoSolicitante", filtros.getOrgaoSolicitante());
        }
        
        if (filtros.getLocal() != null) {
            restrictions.add("reserva.local", filtros.getLocal());
        }

        if (filtros.getTitulo() != null && !filtros.getTitulo().equals("")) {
            restrictions.like("reserva.titulo", filtros.getTitulo());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("reserva.dataInicio", filtros.getDataInicial(), TemporalType.TIMESTAMP);
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("reserva.dataFinal", filtros.getDataFinal(), TemporalType.TIMESTAMP);
        }

        if (filtros.getSolicitante() != null&& !filtros.getSolicitante().equals("")) {
            restrictions.like("reserva.solicitante", filtros.getSolicitante());
        }
        
        return reservaLocalDAO.getQueryBuilder().from(ReservaLocal.class, "reserva").leftJoinFetch("reserva.orgaoSolicitante", "orgaosolicitante").
               leftJoinFetch("reserva.local", "local").leftJoinFetch("reserva.orgao", "orgao").
               add(restrictions).orderBy("orgao,local").getResultList();

    }

    public List<Orgao> orgaoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("orgao.nome", nome);
        }

        restrictions.add("orgao.ativo", true);

        return getDAO().getQueryBuilder().from(Orgao.class, "orgao").add(restrictions).orderBy("orgao.nome").getResultList();
    }

    public List<LocalReserva> localPeloNomeOrgao(String nome,Orgao orgao) {
        Restrictions restrictions = new Restrictions();
        if (orgao != null) {
            restrictions.add("orgao", orgao);
            }
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("local.nome", nome);
        }

        restrictions.add("orgao.ativo", true);

        return getDAO().getQueryBuilder().from(LocalReserva.class, "local").add(restrictions).orderBy("local.nome").getResultList();
    }


}
