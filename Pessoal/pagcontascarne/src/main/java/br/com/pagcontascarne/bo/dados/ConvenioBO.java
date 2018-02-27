package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ConvenioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Convenio;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioBO extends AbstractBusinessObject<Convenio> {

    @EJB
    private ConvenioDAO convenioDAO;

    @Override
    public ConvenioDAO getDAO() {
        return convenioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf_cnpj").add("razao_social").add("nome_fantasia");
    }

    @Override
    public void validate(Convenio convenio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
