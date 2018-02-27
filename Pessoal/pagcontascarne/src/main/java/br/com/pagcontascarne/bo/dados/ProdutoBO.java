package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ProdutoDAO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.util.SessaoUtils;
import br.com.pagcontascarne.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProdutoBO extends AbstractBusinessObject<Produto> {

    @EJB
    private ProdutoDAO produtoDAO;

    @Override
    public ProdutoDAO getDAO() {
        return produtoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio", "nome");
    }

    @Override
    public void validate(Produto produto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Produto> produtosPeloNomeEConvenio(String nome) {
        Usuario usuarioAtual = SessaoUtils.getUser();
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome_fantasia", nome);
        }

        if (usuarioAtual.getConvenio() != null) {
            restrictions.add("convenio", usuarioAtual.getConvenio());
        }

        return getDAO().list(restrictions, "nome");
    }
}
