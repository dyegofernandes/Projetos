package br.com.aprove.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.faturamento.EstoqueDAO;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import br.com.aprove.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.faturamento.Estoque;
import br.com.aprove.vo.FiltroVO;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;

/**
 *
 * @author juniel
 */
@Stateless
public class EstoqueBO extends AbstractBusinessObject<Estoque> {

    @EJB
    private EstoqueDAO estoqueDAO;

    @Override
    public EstoqueDAO getDAO() {
        return estoqueDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Estoque estoque) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Estoque> listarEstoque(FiltroVO filtros) {
        List<Estoque> estoques = null;
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Restrictions restrictions = new Restrictions();

        if (!usuario.isSuperUsuario()) {
            Loja_Filial empresa;
            if (usuario.getFilial() != null) {
                empresa = getDAO().getInitialized(usuario.getFilial());
                filtros.getLojas().add(empresa);
            } else {
                empresa = getDAO().getInitialized(usuario.getMatriz());
                filtros.getLojas().add(empresa);
            }
            restrictions.in("empresa", filtros.getLojas());
        }
        if (filtros.getLoja() != null) {
            restrictions.add("estoque.empresa", filtros.getLoja());
        }
        if (filtros.getAtivo() != null) {
            restrictions.add("estoque.ativo", filtros.getAtivo());
        }

        estoques = estoqueDAO.getQueryBuilder().select("estoque").from(Estoque.class, "estoque").
                leftJoinFetch("estoque.empresa", "empresa").leftJoinFetch("estoque.produto", "produto").add(restrictions).
                orderBy("estoque.produto.descricao").getResultList();

        return estoques;
    }

    @Override
    public void save(Estoque object) throws BusinessException {

        super.save(object);
    }

    private boolean verificaTipo(UnidadeDeMedida unidade) {
        if (unidade == UnidadeDeMedida.FRD || unidade == UnidadeDeMedida.CX || unidade == UnidadeDeMedida.DZ || unidade == UnidadeDeMedida.PCT) {
            return true;
        }
        return false;
    }

}
