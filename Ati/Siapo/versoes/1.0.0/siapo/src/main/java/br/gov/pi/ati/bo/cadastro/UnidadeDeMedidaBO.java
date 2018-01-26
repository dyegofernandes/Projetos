package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.UnidadeDeMedidaDAO;
import br.gov.pi.ati.modelo.cadastro.Produto;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.UnidadeDeMedida;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeDeMedidaBO extends AbstractBusinessObject<UnidadeDeMedida> {

    @EJB
    private UnidadeDeMedidaDAO unidadeDeMedidaDAO;

    @Override
    public UnidadeDeMedidaDAO getDAO() {
        return unidadeDeMedidaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(UnidadeDeMedida unidadeDeMedida) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<UnidadeDeMedida> unidadePeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
