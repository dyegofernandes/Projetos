package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.CargaHorariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.CargaHoraria;

/**
 *
 * @author Juniel
 */
@Stateless
public class CargaHorariaBO extends AbstractBusinessObject<CargaHoraria> {

    @EJB
    private CargaHorariaDAO cargaHorariaDAO;
    
    @Override
    public CargaHorariaDAO getDAO() {
        return cargaHorariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CargaHoraria cargaHoraria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
