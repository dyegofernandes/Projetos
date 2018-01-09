package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.TipoDocumentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoDocumento;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TipoDocumentoBO extends AbstractBusinessObject<TipoDocumento> {

    @EJB
    private TipoDocumentoDAO tipoDocumentoDAO;

    @Override
    public TipoDocumentoDAO getDAO() {
        return tipoDocumentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "nome");
    }

    @Override
    public void validate(TipoDocumento tipoDocumento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
