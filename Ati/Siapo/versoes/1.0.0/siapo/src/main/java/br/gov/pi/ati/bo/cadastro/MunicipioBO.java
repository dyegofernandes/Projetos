package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.MunicipioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class MunicipioBO extends AbstractBusinessObject<Municipio> {

    @EJB
    private MunicipioDAO municipioDAO;

    @Override
    public MunicipioDAO getDAO() {
        return municipioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(Municipio municipio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Municipio> municipiosPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
