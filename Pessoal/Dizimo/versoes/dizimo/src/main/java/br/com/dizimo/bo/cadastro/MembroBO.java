package br.com.dizimo.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.cadastro.MembroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.cadastro.Membro;
import br.com.dizimo.modelo.cadastro.Sede;
import br.com.dizimo.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class MembroBO extends AbstractBusinessObject<Membro> {

    @EJB
    private MembroDAO membroDAO;

    @Override
    public MembroDAO getDAO() {
        return membroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Membro membro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Membro> membrosPelaSede(Sede sede, String nome) {

        Restrictions restrictions = new Restrictions();

        Sede sedeTemp = getDAO().getInitialized(sede);

        if (sedeTemp == null) {
            return null;
        }

        restrictions.add("sede", sedeTemp);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("membro.codigo", nome);
            } else {
                restrictions.like("membro.nome", nome);
            }

        }

        return getDAO().getQueryBuilder().select("membro").from(Membro.class, "membro").leftJoinFetch("membro.sede", "sede")
                .add(restrictions).orderBy("sede, membro.nome").getResultList();
    }
}
