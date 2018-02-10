package br.com.weblicita.bo.licitacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.licitacao.PedidoLicitacaoDAO;
import br.com.weblicita.modelo.controleacesso.Usuario;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.licitacao.PedidoLicitacao;
import br.com.weblicita.util.SessaoUtils;
import br.com.weblicita.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class PedidoLicitacaoBO extends AbstractBusinessObject<PedidoLicitacao> {

    @EJB
    private PedidoLicitacaoDAO pedidoLicitacaoDAO;

    @Override
    public PedidoLicitacaoDAO getDAO() {
        return pedidoLicitacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("numeroLicitacao").add("orgaoSolicitante", "numeroProcessoAdministrativo");
    }

    @Override
    public void validate(PedidoLicitacao pedidoLicitacao) throws BusinessException {
        List<ItemLicitacao> itens = getDAO().getInitialized(pedidoLicitacao.getItens());

        PedidoLicitacao pedido = getDAO().unique("numeroLicitacao", pedidoLicitacao.getNumeroProcessoAdministrativo());

        if (pedido != null) {
            throw new BusinessException("Não pode existir um Número Administrativo igual a um Código de Licitação existente");
        }

        if (itens == null) {
            throw new BusinessException("Um ou mais itens são obrigatórios!");
        } else {
            if (itens.size() < 1) {
                throw new BusinessException("Um ou mais itens são obrigatórios!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String gerarCodigoPedido() {
        String codigo = "";

        String anoAtual = Utils.getAno(new Date());

        Long id = (Long) getDAO().getQueryBuilder().from(PedidoLicitacao.class).max("id");

        PedidoLicitacao pedido = getDAO().unique("id", id);

        if (pedido != null) {
            String[] codigoTemp = new String[2];

            codigoTemp = pedido.getNumeroLicitacao().split("\\.");

            String anoPedido = codigoTemp[1];

            Integer sequencial = new Integer(codigoTemp[0]);

            if (anoAtual.equals(anoPedido)) {
                sequencial++;
                codigo = codigo.concat(Utils.inserirZeroDireita(sequencial.toString(), 10)).concat(".").concat(anoPedido);
            } else {
                codigo = codigo.concat(Utils.inserirZeroDireita("1", 10)).concat(".").concat(anoAtual);
            }

        } else {
            codigo = codigo.concat(Utils.inserirZeroDireita("1", 10)).concat(".").concat(anoAtual);
        }

        return codigo;
    }

    public List<PedidoLicitacao> listaPeloNumProcessoAdmin(String numero) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(numero)) {
            restrictions.like("numeroLicitacao", numero);
        }

        return getDAO().list(restrictions, "numeroLicitacao");
    }

    public PedidoLicitacao pedidoPeloNumeroLicitacaoOuDocumento(String numero) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(numero)) {
            restrictions.like("numeroLicitacao", numero);
        }

        return getDAO().unique(restrictions);
    }

    public PedidoLicitacao pedidoPeloProcessoAdministrativo(String numero) {
        Usuario usuarioAtual = SessaoUtils.getUser();

        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (Utils.isNullOrEmpty(numero)) {
            return null;
        } else {
            restrictions.add("numeroProcessoAdministrativo", numero);
        }

        if (usuarioAtual.getOrgao() == null) {
            return null;
        } else {
            restrictions.add("orgaoSolicitante", usuarioAtual.getOrgao());
        }

        return getDAO().unique(restrictions);
    }

}
