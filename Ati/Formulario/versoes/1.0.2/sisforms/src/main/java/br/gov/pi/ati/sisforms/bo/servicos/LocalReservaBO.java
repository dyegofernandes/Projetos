package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.LocalReservaDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;

import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;

import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;


/**
 *
 * @author Juniel, Nilson, Samuel, Yago
 */
@Stateless
public class LocalReservaBO extends AbstractBusinessObject<LocalReserva> {

    @EJB
    private LocalReservaDAO localReservaDAO;

    @Override
    public LocalReservaDAO getDAO() {
        return localReservaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(LocalReserva localReserva) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<LocalReserva> locaisPorOrgao(Orgao orgao){
        Restrictions restrictions = new Restrictions();
        restrictions.add("orgao", orgao);
        return getDAO().getQueryBuilder().from(LocalReserva.class, "localReserva").leftJoinFetch("localReserva.orgao", "orgao").
                add(restrictions).orderBy("orgao.nome").getResultList();
    }
    
    
}
