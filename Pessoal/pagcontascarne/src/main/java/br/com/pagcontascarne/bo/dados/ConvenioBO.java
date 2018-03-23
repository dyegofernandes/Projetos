package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ConvenioDAO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Cliente;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.util.SessaoUtils;
import br.com.pagcontascarne.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioBO extends AbstractBusinessObject<Convenio> {

    @EJB
    private ConvenioDAO convenioDAO;

    @Override
    public ConvenioDAO getDAO() {
        return convenioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf_cnpj").add("razao_social").add("nome_fantasia");
    }

    @Override
    public void validate(Convenio convenio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<Convenio> conveniosPeloNomeOrCnpjOuCpf(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("cpf_cnpj", (nome.replace(".", "").replace("/", "").replace("-", "")));
            } else {
                restrictions.like("nome_fantasia", nome);
            }

        }
        
        return getDAO().list(restrictions, "nome_fantasia");
    }

}
