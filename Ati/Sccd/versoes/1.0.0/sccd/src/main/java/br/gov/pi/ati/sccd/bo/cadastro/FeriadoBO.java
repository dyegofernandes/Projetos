package br.gov.pi.ati.sccd.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.cadastro.FeriadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.cadastro.Feriado;
import com.xpert.core.validation.UniqueFields;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class FeriadoBO extends AbstractBusinessObject<Feriado> {

    @EJB
    private FeriadoDAO feriadoDAO;
    
    @Override
    public FeriadoDAO getDAO() {
        return feriadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("dataInicial");
    }

    @Override
    public void validate(Feriado feriado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public Feriado feriadoPelaData(Date data){
        return (Feriado) getDAO().getQueryBuilder().select("feriado").from(Feriado.class, "feriado").add("feriado.dataInicial", data).getSingleResult();
    }

}
