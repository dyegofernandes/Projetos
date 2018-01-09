package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.ContaBancariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.ContaBancaria;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.vo.FiltroVO;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ContaBancariaBO extends AbstractBusinessObject<ContaBancaria> {

    @EJB
    private ContaBancariaDAO contaBancariaDAO;

    @Override
    public ContaBancariaDAO getDAO() {
        return contaBancariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("loja", "principal");
    }

    @Override
    public void validate(ContaBancaria contaBancaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<ContaBancaria> listarContas(FiltroVO filtros) {
        List<ContaBancaria> contas = null;
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
        } else {
            Loja_Filial empresa;
            if (filtros.getLoja() != null) {
                empresa = getDAO().getInitialized(filtros.getLoja());
                filtros.getLojas().add(empresa);
            } else {
                if (filtros.getMatriz() != null) {
                    empresa = getDAO().getInitialized(filtros.getMatriz());
                    filtros.getLojas().add(empresa);
                }
            }
        }

        if (filtros.getBanco() != null && !filtros.getBanco().equals("")) {
            restrictions.like("conta.banco.nome", filtros.getBanco());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("conta.nomeTitularConta", filtros.getNome());
        }

        if (filtros.getCodigo() != null && !filtros.getCodigo().equals("")) {
            restrictions.like("conta.conta", filtros.getCodigo());
        }

        if (filtros.getCodigo2() != null && !filtros.getCodigo2().equals("")) {
            restrictions.like("conta.agencia", filtros.getCodigo2());
        }

        if (filtros.getLojas().size() > 0) {
            restrictions.in("empresa", filtros.getLojas());
        }

        contas = getDAO().getQueryBuilder().select("conta").from(ContaBancaria.class, "conta").leftJoinFetch("conta.loja", "empresa")
                .add(restrictions).orderBy("empresa, conta.banco, conta.nomeTitularConta").getResultList();

        return contas;
    }

}
