package br.gov.pi.ati.cfcpm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.cfcpm.dao.cadastro.FormularioInscricaoSAVDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioInscricaoSAV;
import br.gov.pi.ati.cfcpm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormularioInscricaoSAVBO extends AbstractBusinessObject<FormularioInscricaoSAV> {

    @EJB
    private FormularioInscricaoSAVDAO formularioInscricaoSAVDAO;

    @Override
    public FormularioInscricaoSAVDAO getDAO() {
        return formularioInscricaoSAVDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf");
    }

    @Override
    public void validate(FormularioInscricaoSAV formularioInscricaoSAV) throws BusinessException {
        if (verificarDataInscricao(formularioInscricaoSAV.getDataInscricao())) {
            throw new BusinessException("Prazo de inscrição encerrado no dia 07/03/2018 as 23:59:59!");
        }

        Calendar fim = Calendar.getInstance();
        fim.set(2018, 3, 30, 0, 0, 0);
        if (Utils.diferencaEmAnos(formularioInscricaoSAV.getDataDeNascimento(), fim.getTime()) < 18 || Utils.getIdade(formularioInscricaoSAV.getDataDeNascimento()) > 23) {
            throw new BusinessException("Idade dos candidatos deve ser maior ou igual a 18 anos (completados até o dia 30.04.2018) e menor ou igual a 23!!");
        }

    }

    @Override
    public boolean isAudit() {
        return true;
    }

    private boolean verificarDataInscricao(Date dataInscricao) {

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTime(new Date());

        dataFinal.set(Calendar.DAY_OF_MONTH, 7);
        dataFinal.set(Calendar.MONTH, 2);
        dataFinal.set(Calendar.YEAR, 2018);

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
