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

import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.util.Utils;

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
        if (orgao != null) {
            restrictions.add("orgao", orgao);
            }
        return getDAO().getQueryBuilder().from(LocalReserva.class, "localReserva").leftJoinFetch("localReserva.orgao", "orgao").
                add(restrictions).orderBy("orgao.nome").getResultList();
    }

    public List<LocalReserva> listarLocais (FiltrosVO filtros) {
         Restrictions restrictions = new Restrictions();

       
        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }
        
        if (filtros.getTipo() != null) {
            restrictions.like("tipo", filtros.getTipo());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("local.nome", filtros.getNome());
        }

        
        return localReservaDAO.getQueryBuilder().from(LocalReserva.class, "local").leftJoinFetch("local.orgao", "orgao").
               add(restrictions).orderBy("orgao").getResultList();

    }
    
    public List<Orgao> orgaoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("orgao.nome", nome);
        }

        restrictions.add("orgao.ativo", true);

        return getDAO().getQueryBuilder().from(Orgao.class, "orgao").add(restrictions).orderBy("orgao.nome").getResultList();
    }
}
