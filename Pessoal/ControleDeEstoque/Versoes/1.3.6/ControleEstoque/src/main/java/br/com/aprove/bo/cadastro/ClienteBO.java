package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.ClienteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.Cliente;
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
public class ClienteBO extends AbstractBusinessObject<Cliente> {

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public ClienteDAO getDAO() {
        return clienteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "cnpj");
    }

    @Override
    public void validate(Cliente cliente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Cliente> listarClientes(FiltroVO filtros) {
        List<Cliente> clientes = null;
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Restrictions restrictions = new Restrictions();

        if (filtros.getCodigo1() != null) {
            restrictions.add("cliente.id", filtros.getCodigo1());
        }
        
        if (filtros.getTipo() != null) {
            restrictions.add("cliente.tipoDePessoa", filtros.getTipo());
        }
        
        if (filtros.getCnpj() != null && !filtros.getCnpj().equals("")) {
            restrictions.add("cliente.cnpj", filtros.getCnpj());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("cliente.razaoSocial", filtros.getNome());
        }

        if (filtros.getAtivo() == null) {
            List<Boolean> lista = new ArrayList<Boolean>();
            lista.add(Boolean.TRUE);
            lista.add(Boolean.FALSE);
            restrictions.in("cliente.ativo", lista);
        } else {
            restrictions.add("cliente.ativo", filtros.getAtivo());
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
        }

        if (filtros.getLoja() != null) {
            Loja_Filial empresa = getDAO().getInitialized(filtros.getLoja());
            filtros.getLojas().add(empresa);
        }

        if (filtros.getLojas().size() > 0) {
            restrictions.in("empresa", filtros.getLojas());
        }

        clientes = getDAO().getQueryBuilder().select("cliente").from(Cliente.class, "cliente").leftJoinFetch("cliente.empresa", "empresa")
                .leftJoinFetch("cliente.cidadeEndereco", "cidadeEndereco").leftJoinFetch("cliente.fatura", "fatura").leftJoinFetch("cliente.recebimento", "recebimento")
                .leftJoinFetch("cliente.cidEndEmpresaTrabalho", "cidEndEmpresaTrabalho")
                .add(restrictions)
                .orderBy("empresa, cliente.razaoSocial").getResultList();

        return clientes;
    }

}
