package br.gov.pi.ati.sccd.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.cadastro.TipoCertificadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoCertificadoBO extends AbstractBusinessObject<TipoCertificado> {

    @EJB
    private TipoCertificadoDAO tipoCertificadoDAO;

    @Override
    public TipoCertificadoDAO getDAO() {
        return tipoCertificadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("sigla").add("nome");
    }

    @Override
    public void validate(TipoCertificado tipoCertificado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
