package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ClienteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
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
        return new UniqueFields().add("convenio", "cpf_cnpj").add("convenio", "completo_razao_social").add("convenio", "nome_fantasia");
    }

    @Override
    public void validate(Cliente cliente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Cliente> clientesPeloNomeOrCnpjOuCpf(String nome, Convenio convenio) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("cpf_cnpj", (nome.replace(".", "").replace("/", "").replace("-", "")));
            } else {
                restrictions.like("nome_fantasia", nome);
            }

        }

        if (convenio != null) {
            restrictions.add("convenio", convenio);
        }

        return getDAO().list(restrictions, "nome_fantasia");
    }

    public List<Cliente> listar(FiltrosBusca filtros) {
        Restrictions restrictions = new Restrictions();

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (!Utils.isNullOrEmpty(filtros.getCpf_cnpj())) {
            restrictions.add("cliente.cpf_cnpj", filtros.getCpf_cnpj());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome_fantasia())) {
            restrictions.like("cliente.nome_fantisia", filtros.getNome_fantasia());
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }
        
        if (filtros.isAtivo()) {
            restrictions.add("cliente.ativo", filtros.isAtivo());
        }

        return getDAO().getQueryBuilder().from(Cliente.class, "cliente").leftJoinFetch("cliente.convenio", "convenio")
                .leftJoinFetch("cliente.cidade", "cidade").add(restrictions).orderBy("convenio, cliente.nome_fantasia")
                .getResultList();
    }
    
}
