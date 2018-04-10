package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ContatoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Contato;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import com.xpert.persistence.query.Restrictions;
import br.com.pagcontascarne.util.Utils;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContatoBO extends AbstractBusinessObject<Contato> {

    @EJB
    private ContatoDAO contatoDAO;

    @Override
    public ContatoDAO getDAO() {
        return contatoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Contato contato) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Contato> listar(FiltrosBusca filtros) {
        Restrictions restrictions = new Restrictions();
        
        if(filtros.getFranquia()!=null){
            restrictions.add("franquia", filtros.getFranquia());
        }

        if (filtros.getConvenio() != null) {
            restrictions.add("convenio", filtros.getConvenio());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.like("contato.nome", filtros.getNome());
        }

        if (!Utils.isNullOrEmpty(filtros.getEmail())) {
            restrictions.add("contato.email", filtros.getEmail());
        }

        if (!Utils.isNullOrEmpty(filtros.getTelefone())) {
            restrictions.add("contato.telefones", filtros.getTelefone());
        }

        return getDAO().getQueryBuilder().from(Contato.class, "contato").leftJoinFetch("contato.convenio", "convenio")
                .leftJoinFetch("convenio.franquia", "franquia").add(restrictions).orderBy("convenio, contato.nome").getResultList();
    }

}
