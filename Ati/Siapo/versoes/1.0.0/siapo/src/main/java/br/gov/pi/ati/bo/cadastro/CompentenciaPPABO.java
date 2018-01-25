package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.CompentenciaPPADAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.CompentenciaPPA;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class CompentenciaPPABO extends AbstractBusinessObject<CompentenciaPPA> {

    @EJB
    private CompentenciaPPADAO compentenciaPPADAO;

    @Override
    public CompentenciaPPADAO getDAO() {
        return compentenciaPPADAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();
        uniqueFields.add(new UniqueField(Restriction.equals("ativo", true)).setMessage("Já existe uma competência ativa!"));

        return uniqueFields;
    }

    @Override
    public void validate(CompentenciaPPA compentenciaPPA) throws BusinessException {
        if (compentenciaPPA.getDataInicial().after(compentenciaPPA.getDataFinal())) {
            throw new BusinessException("Data inicial não pode ser maior que a data final!");
        }

        if ((new Integer(Utils.getAno(compentenciaPPA.getDataFinal())) - new Integer(Utils.getAno(compentenciaPPA.getDataInicial()))) != 3) {
            throw new BusinessException("Periodo do PPA dever ser igual a 4 anos!!");
        }

    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Integer> periodoPelaCompetencia() {

        CompentenciaPPA competenciaTemp = getDAO().getInitialized(getDAO().unique("ativo", true));

        List<Integer> lista = new ArrayList<Integer>();

        Integer anoInicio = new Integer(Utils.getAno(competenciaTemp.getDataInicial()));

        lista.add(anoInicio);

        lista.add(anoInicio + 1);

        Integer anoFim = new Integer(Utils.getAno(competenciaTemp.getDataFinal()));

        lista.add(anoFim - 1);

        lista.add(anoFim);

        return lista;
    }

}
