package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.UfDAO;
import br.com.facilpagar.modelo.dados.Cidade;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Uf;
import br.com.facilpagar.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class UfBO extends AbstractBusinessObject<Uf> {

    @EJB
    private UfDAO DAO;

    @Override
    public UfDAO getDAO() {
        return DAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("sigla").add("nome");
    }

    @Override
    public void validate(Uf uf) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Uf> listarUFPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("uf.nome", nome);
        }

        return getDAO().getQueryBuilder().from(Uf.class, "uf").add(restrictions).orderBy("uf.nome").getResultList();
    }
}
