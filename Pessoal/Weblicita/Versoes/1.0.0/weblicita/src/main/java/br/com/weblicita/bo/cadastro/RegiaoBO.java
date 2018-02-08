package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.RegiaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Regiao;
import com.xpert.core.exception.UniqueFieldException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.core.validation.UniqueFieldsValidation;
import com.xpert.persistence.query.Restriction;

/**
 *
 * @author Juniel
 */
@Stateless
public class RegiaoBO extends AbstractBusinessObject<Regiao> {

    @EJB
    private RegiaoDAO regiaoDAO;

    @Override
    public RegiaoDAO getDAO() {
        return regiaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validateUniqueFields(Regiao regiao) throws UniqueFieldException {
        Restriction restriction = new Restriction("UPPER(TRANSLATE(descricao,'ÁÀÂÃÄáàâãäÉÈÊËéèêëÍÌÎÏíìîïÓÒÕÔÖóòôõöÚÙÛÜúùûüÇç','AAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUUuuuuCc'))", 
                regiao.getDescricao().toUpperCase());
        UniqueField uniqueField = new UniqueField(restriction).setMessage("Já existe região cadastrado com essa descrição: ".concat(regiao.getDescricao().toUpperCase()));

        UniqueFields uniqueFields = new UniqueFields();
        uniqueFields.add(uniqueField);

        UniqueFieldsValidation.validateUniqueFields(uniqueFields, regiao, getDAO());
    }

    @Override
    public void validate(Regiao regiao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
