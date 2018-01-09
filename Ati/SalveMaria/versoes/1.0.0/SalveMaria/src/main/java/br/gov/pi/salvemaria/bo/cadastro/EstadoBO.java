package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.EstadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Estado;
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
        return new UniqueFields().add("sigla").add("nome");
    }

    @Override
    public void validate(Estado estado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Estado estadoPorNome(String nome) {
        if (nome == null || nome.equals("")) {
            return null;
        }
        Restrictions restrictions = new Restrictions();
        restrictions.add("nome", nome.toUpperCase());
        return estadoDAO.unique(restrictions);
    }

    public List<Estado> listarEstados(String nome, String sigla) {
        Restrictions restrictions = new Restrictions();
        List<Estado> estados = null;
        if (nome != null) {
            if (!nome.equals("")) {
                restrictions.like("nome", nome);
            }
        }
        if (sigla != null) {
            if (!sigla.equals("")) {
                restrictions.add("sigla", sigla);
            }
        }

        estados = estadoDAO.list(restrictions, "nome");

        return estados;
    }
}
