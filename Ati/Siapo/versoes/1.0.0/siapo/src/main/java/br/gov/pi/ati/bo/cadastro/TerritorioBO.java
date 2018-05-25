package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.TerritorioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
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
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(Territorio territorio) throws BusinessException {
        if (territorio.getMunicipios().size() < 1) {
            throw new BusinessException("Um ou mais municípios deve ser adicionado!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Territorio> territorioPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
