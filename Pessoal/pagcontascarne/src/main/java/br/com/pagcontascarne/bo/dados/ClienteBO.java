package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ClienteDAO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.util.SessaoUtils;
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

    public List<Cliente> clientesPeloNomeOrCnpjOuCpf(String nome) {
        Usuario usuarioAtual = SessaoUtils.getUser();
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("cpf_cnpj", (nome.replace(".", "").replace("/", "").replace("-", "")));
            } else {
                restrictions.like("nome_fantasia", nome);
            }

        }

        if (usuarioAtual.getConvenio() != null) {
            restrictions.add("convenio", usuarioAtual.getConvenio());
        }

        return getDAO().list(restrictions, "nome_fantasia");
    }

}
