package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.CategoriaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Categoria;
import br.com.facilpagar.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author jj
 */
@Stateless
public class CategoriaBO extends AbstractBusinessObject<Categoria> {

    @EJB
    private CategoriaDAO categoriaDAO;
    
    @Override
    public CategoriaDAO getDAO() {
        return categoriaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(Categoria categoria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<Categoria> listarCategoriaPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("categoria.nome", nome);
        }

        return getDAO().getQueryBuilder().from(Categoria.class, "categoria").add(restrictions).orderBy("categoria.nome").getResultList();
    }

}
