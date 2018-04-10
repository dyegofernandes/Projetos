package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ProdutoDAO;
import br.com.pagcontascarne.modelo.dados.Convenio;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
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

    public List<Produto> produtosPeloNomeEConvenio(String nome, Convenio convenio) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome_fantasia", nome);
        }

        if (convenio != null) {
            restrictions.add("convenio", convenio);
        } else {
            return null;
        }

        return getDAO().list(restrictions, "nome");
    }

    public List<Produto> listar(FiltrosBusca filtros) {
        Restrictions restrictions = new Restrictions();

        if (filtros.getFranquia() != null) {
            restrictions.add("franquia", filtros.getFranquia());
        }
        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.add("produto.nome", filtros.getNome());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("produto.ativo", filtros.getAtivo().isStatus());
        }

        return getDAO().getQueryBuilder().from(Produto.class, "produto").leftJoinFetch("produto.convenio", "convenio")
                .leftJoinFetch("convenio.franquia", "franquia").add(restrictions).orderBy("franquia, convenio, produto.nome").getResultList();
    }
}
