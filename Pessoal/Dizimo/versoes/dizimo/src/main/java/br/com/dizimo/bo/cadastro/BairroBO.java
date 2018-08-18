package br.com.dizimo.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.cadastro.BairroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.cadastro.Bairro;
import br.com.dizimo.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroBO extends AbstractBusinessObject<Bairro> {

    @EJB
    private BairroDAO bairroDAO;

    @Override
    public BairroDAO getDAO() {
        return bairroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Bairro bairro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Bairro> bairroPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("bairro.nome", nome);
        }

        return getDAO().getQueryBuilder().select("bairro").from(Bairro.class, "bairro").leftJoin("bairro.cidade", "cidade")
                .add(restrictions).orderBy("bairro.nome").getResultList();
    }

}
