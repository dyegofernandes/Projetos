package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.EstadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Estado;
import br.com.weblicita.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class EstadoBO extends AbstractBusinessObject<Estado> {

    @EJB
    private EstadoDAO estadoDAO;

    @Override
    public EstadoDAO getDAO() {
        return estadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("pais", "nome").add("pais", "sigla");
    }

    @Override
    public void validate(Estado estado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Estado> estadoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
