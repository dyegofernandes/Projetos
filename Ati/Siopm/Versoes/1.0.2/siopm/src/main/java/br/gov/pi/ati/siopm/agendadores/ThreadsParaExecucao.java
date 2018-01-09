package br.gov.pi.ati.siopm.agendadores;

import br.gov.pi.ati.siopm.bo.cadastro.PatrulhaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.enums.StatusViaturaEnum;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.persistence.query.Restrictions;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author Juniel
 * @see classe para execução de threads
 */
@Singleton
public class ThreadsParaExecucao {
    
    @EJB
    private PatrulhaBO patrulhaBO;
    
    @Schedule(dayOfMonth = "*", hour = "*", minute = "*")
    private void inativarPatrulha() throws ParseException {
        
        Restrictions restrictions = new Restrictions();
        restrictions.add("ativo", true);
        
        List<Patrulha> patrulhas = patrulhaBO.getDAO().list(restrictions);
        
        for (Patrulha patrulha : patrulhas) {
            if (!Utils.verificarSeDataEhMaiorQueDataAtual(patrulha.getFimTurno(), patrulha.getFimHoraTurno())) {
                patrulha.setAtivo(false);
                patrulha.setStatus(StatusViaturaEnum.INDISPONIVEL);
                patrulhaBO.getDAO().saveOrMerge(patrulha);
            }
        }
        
    }
}
