package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.TermoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.Termo;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class TermoBO extends AbstractBusinessObject<Termo> {

    @EJB
    private TermoDAO termoDAO;

    @Override
    public TermoDAO getDAO() {
        return termoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Termo termo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Termo termoAtivoPorNome(String nome) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.equals("nome", nome);
        } else {
            return null;
        }

        return getDAO().unique(restrictions);
    }

}
