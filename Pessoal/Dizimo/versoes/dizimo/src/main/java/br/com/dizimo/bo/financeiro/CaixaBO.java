package br.com.dizimo.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.financeiro.CaixaDAO;
import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.enums.StatusCaixa;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.financeiro.Caixa;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class CaixaBO extends AbstractBusinessObject<Caixa> {

    @EJB
    private CaixaDAO caixaDAO;

    @Override
    public CaixaDAO getDAO() {
        return caixaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();
        uniqueFields.add(new UniqueField(Restriction.equals("status", StatusCaixa.ABERTO), "usuario").setMessage("Você só pode abrir um caixa por vez!"));
        return uniqueFields;
    }

    @Override
    public void validate(Caixa caixa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Caixa caixaAberto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        Restrictions restrictions = new Restrictions();

        restrictions.add("caixa.usuario", usuario);

        restrictions.add("caixa.status", StatusCaixa.ABERTO);

        return (Caixa) getDAO().getQueryBuilder().select("caixa").from(Caixa.class, "caixa").add(restrictions).getSingleResult();
    }

}
