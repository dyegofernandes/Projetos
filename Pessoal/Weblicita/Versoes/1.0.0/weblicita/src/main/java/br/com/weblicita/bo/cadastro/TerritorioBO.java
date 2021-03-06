package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.TerritorioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Territorio;
import br.com.weblicita.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class TerritorioBO extends AbstractBusinessObject<Territorio> {

    @EJB
    private TerritorioDAO territorioDAO;

    @Override
    public TerritorioDAO getDAO() {
        return territorioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Territorio territorio) throws BusinessException {

        Restrictions restrictions = new Restrictions();
        restrictions.equals("UPPER(TRANSLATE(descricao,'ÁÀÂÃÄáàâãäÉÈÊËéèêëÍÌÎÏíìîïÓÒÕÔÖóòôõöÚÙÛÜúùûüÇç','AAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUUuuuuCc'))",
                Utils.removerAcentos(territorio.getDescricao()).toUpperCase());
        restrictions.add("estado", territorio.getEstado());

        Territorio territorioTemp = getDAO().unique(restrictions);

        if (territorioTemp != null) {
            if (!territorioTemp.equals(territorio)) {
                throw new BusinessException("Já existe um Territorio cadastrado com essa descrição para esse Estado!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
