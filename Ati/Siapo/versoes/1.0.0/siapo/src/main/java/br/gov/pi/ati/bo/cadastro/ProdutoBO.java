package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ProdutoDAO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.util.SessaoUtils;
import br.gov.pi.ati.util.Utils;
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
        return new UniqueFields().add("acao", "nome");
    }

    @Override
    public void validate(Produto produto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Produto> produtoPeloNomeComAcao(AcaoEstrategica acao, String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("p.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("p.nome", nome);
        }

        if (acao != null) {
            restrictions.add("acao", acao);
        }

        restrictions.add("acao.ativo", true);

        return getDAO().getQueryBuilder().select("p").from(Produto.class, "p").leftJoinFetch("p.acao", "acao").
                leftJoinFetch("acao.unidadeOrcamentaria", "unidade").
                add(restrictions).orderBy("acao, p.nome").getResultList();
    }

    public List<Produto> produtoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        Usuario usuarioAtual = SessaoUtils.getUser();

        List<UnidadeOrcamentaria> unidadesDeAcesso = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());

        if (unidadesDeAcesso != null) {
            if (unidadesDeAcesso.size() > 0) {
                restrictions.in("unidade", unidadesDeAcesso);
            }
        }

        restrictions.add("p.ativo", true);
        restrictions.add("acao.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("p.nome", nome);
        }

        return getDAO().getQueryBuilder().select("p").from(Produto.class, "p").leftJoinFetch("p.acao", "acao").leftJoinFetch("acao.unidadeOrcamentaria", "unidade").
                add(restrictions).orderBy("acao, p.nome").getResultList();
    }

}
