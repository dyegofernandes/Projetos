package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.CargaHorariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.CargaHoraria;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class CargaHorariaBO extends AbstractBusinessObject<CargaHoraria> {

    @EJB
    private CargaHorariaDAO cargaHorariaDAO;
    
    @Override
    public CargaHorariaDAO getDAO() {
        return cargaHorariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("orgao");
    }

    @Override
    public void validate(CargaHoraria cargaHoraria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<CargaHoraria> listarCargasHorarias(FiltrosVO filtros) {


        Restrictions restrictions = new Restrictions();

        
        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }

        if (filtros.getDescricao() != null && !filtros.getDescricao().equals("")) {
            restrictions.like("cargaHoraria.descricao", filtros.getDescricao());
        }

        return cargaHorariaDAO.getQueryBuilder().from(CargaHoraria.class, "cargaHoraria")
                .leftJoinFetch("cargaHoraria.orgao", "orgao")
                .add(restrictions)
                .orderBy("orgao.nome, cargaHoraria.descricao")
                .getResultList();

        
    }
    
    
    public List<Orgao> orgaoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("orgao.sigla", nome);
        }

        return getDAO().getQueryBuilder().from(Orgao.class, "orgao").add(restrictions).orderBy("orgao.nome").getResultList();
    }

}
