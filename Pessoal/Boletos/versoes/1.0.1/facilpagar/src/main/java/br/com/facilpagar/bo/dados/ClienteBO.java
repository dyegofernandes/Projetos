package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.ClienteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Cliente;
import br.com.facilpagar.modelo.dados.Convenio;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.Utils;
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
        }else{
            return null;
        }
        
        

        return getDAO().list(restrictions, "nome_fantasia");
    }

    public List<Cliente> listar(FiltrosBusca filtros) {
        Restrictions restrictions = new Restrictions();

        if (filtros.getFranquia() != null) {
            restrictions.add("franquia", filtros.getFranquia());
        }

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (filtros.getTipoPessoa() != null) {
            restrictions.add("cliente.tipo_pessoa", filtros.getTipoPessoa());
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

        if (filtros.getEstado() != null) {
            restrictions.add("uf", filtros.getEstado());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("cliente.ativo", filtros.getAtivo().isStatus());
        }

        return getDAO().getQueryBuilder().from(Cliente.class, "cliente").leftJoinFetch("cliente.convenio", "convenio")
                .leftJoinFetch("convenio.franquia", "franquia").leftJoinFetch("cliente.cidade", "cidade").leftJoinFetch("cidade.uf", "uf")
                .add(restrictions).orderBy("uf, cidade, franquia, convenio, cliente.nome_fantasia").getResultList();
    }

}
