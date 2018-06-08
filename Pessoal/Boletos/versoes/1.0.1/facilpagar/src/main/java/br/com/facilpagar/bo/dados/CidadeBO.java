package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.CidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Cidade;
import br.com.facilpagar.modelo.dados.Uf;
import br.com.facilpagar.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeBO extends AbstractBusinessObject<Cidade> {

    @EJB
    private CidadeDAO cidadeDAO;

    @Override
    public CidadeDAO getDAO() {
        return cidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("uf", "nome");
    }

    @Override
    public void validate(Cidade cidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Cidade> listarCidadePeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("cidade.nome", nome);
        }

        return getDAO().getQueryBuilder().from(Cidade.class, "cidade").leftJoinFetch("cidade.uf", "uf").add(restrictions).orderBy("uf, cidade.nome").getResultList();
    }

    public List<Cidade> listarCidadePeloNomeEEstado(Uf uf, String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("cidade.nome", nome);
        }

        if (uf != null) {
            restrictions.add("uf", uf);
        } else {
            return null;
        }

        return getDAO().getQueryBuilder().from(Cidade.class, "cidade").leftJoinFetch("cidade.uf", "uf").add(restrictions).orderBy("uf, cidade.nome").getResultList();
    }

}
