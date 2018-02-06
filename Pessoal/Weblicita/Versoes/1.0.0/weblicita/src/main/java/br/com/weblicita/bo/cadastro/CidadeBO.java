package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.CidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Cidade;
import br.com.weblicita.util.Utils;
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
//        return new UniqueFields().add("estado", "nome");
        return null;
    }

    @Override
    public void validate(Cidade cidade) throws BusinessException {
        Restrictions restrictions = new Restrictions();
        restrictions.startGroup();
        restrictions.equals("UPPER(nome)", cidade.getNome().toUpperCase());
        restrictions.add("estado", cidade.getEstado());
        restrictions.endGroup();
        restrictions.or().startGroup();
        restrictions.add("codigo", cidade.getCodigo());
        restrictions.endGroup();

        Cidade cidadeTemp = (Cidade) getDAO().getQueryBuilder().from(Cidade.class).add(restrictions).getSingleResult();

        if (cidadeTemp != null) {
            throw new BusinessException("Já existe uma Cidade cadastrada para o Estado informado com esse nome ou código!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Cidade> produtoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }
}
