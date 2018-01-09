package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.FornecedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.Fornecedor;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.vo.FiltroVO;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author juniel
 */
@Stateless
public class FornecedorBO extends AbstractBusinessObject<Fornecedor> {

    @EJB
    private FornecedorDAO fornecedorDAO;

    @Override
    public FornecedorDAO getDAO() {
        return fornecedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "cnpj");
    }

    @Override
    public void validate(Fornecedor fornecedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Fornecedor> listarFornecedores(FiltroVO filtros) {
        List<Fornecedor> fornecedores = null;
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Restrictions restrictions = new Restrictions();
        
        if (filtros.getCodigo1() != null) {
            restrictions.add("fornecedor.id", filtros.getCodigo1());
        }
        
        if (filtros.getAtivo() == null) {
            List<Boolean> lista = new ArrayList<Boolean>();
            lista.add(Boolean.TRUE);
            lista.add(Boolean.FALSE);
            restrictions.in("fornecedor.ativo", lista);
        } else {
            restrictions.add("fornecedor.ativo", filtros.getAtivo());
        }
        
        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("fornecedor.razaoSocial", filtros.getNome());
        }

        if (filtros.getCnpj() != null && !filtros.getCnpj().equals("")) {
            restrictions.add("fornecedor.cnpj", filtros.getCnpj());
        }
        
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

        if (filtros.getLojas().size() > 0) {
            restrictions.in("empresa", filtros.getLojas());
        }

        fornecedores = getDAO().getQueryBuilder().select("fornecedor").from(Fornecedor.class, "fornecedor").leftJoinFetch("fornecedor.empresa", "empresa")
                .leftJoinFetch("fornecedor.cidade", "cidade").add(restrictions).orderBy("empresa, fornecedor.razaoSocial").getResultList();
//        filtros.setLojas(new ArrayList<Loja_Filial>());
        return fornecedores;
    }

}
