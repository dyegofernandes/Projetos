package br.gov.pi.ati.cfcpm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.cfcpm.dao.cadastro.FormularioDeInscricaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioDeInscricao;
import br.gov.pi.ati.cfcpm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormularioDeInscricaoBO extends AbstractBusinessObject<FormularioDeInscricao> {

    @EJB
    private FormularioDeInscricaoDAO formularioDeInscricaoDAO;

    @Override
    public FormularioDeInscricaoDAO getDAO() {
        return formularioDeInscricaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf").add("identidade");
    }

    @Override
    public void validate(FormularioDeInscricao formularioDeInscricao) throws BusinessException {
        if (Utils.getTempoAtendimentoEmAnos(formularioDeInscricao.getDataDeNomeacao(), new Date()) < 3) {
            throw new BusinessException("Inscrição só pode ser feita para quem tem 3 ou mais anos de Nomeação!");
        }

        if (verificarDataInscricao(formularioDeInscricao.getDataInscricao())) {
            throw new BusinessException("Prazo de inscrição encerrado no dia 02/10/2017 as 23:59:59!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    private static boolean verificarDataInscricao(Date dataInscricao) {

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTime(new Date());

        dataFinal.set(Calendar.DAY_OF_MONTH, 2);
        dataFinal.set(Calendar.MONTH, 10);
        dataFinal.set(Calendar.YEAR, 2017);

        dataFinal.set(Calendar.HOUR_OF_DAY, 23);
        dataFinal.set(Calendar.MINUTE, 59);
        dataFinal.set(Calendar.SECOND, 59);

        if (dataInscricao.after(dataFinal.getTime())) {
            return true;
        }

        System.out.println(dataFinal.getTime());

        return false;
    }

}
