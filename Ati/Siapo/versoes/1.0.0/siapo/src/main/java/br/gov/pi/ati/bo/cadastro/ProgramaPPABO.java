package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ProgramaPPADAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;
import br.gov.pi.ati.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramaPPABO extends AbstractBusinessObject<ProgramaPPA> {

    @EJB
    private ProgramaPPADAO programaPPADAO;

    @Override
    public ProgramaPPADAO getDAO() {
        return programaPPADAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ProgramaPPA programaPPA) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<ProgramaPPA> programaPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("pp.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("p.nome", nome);
        }

        return getDAO().getQueryBuilder().select("pp").from(ProgramaPPA.class, "pp").leftJoinFetch("pp.programaGov", "p").add(restrictions).orderBy("p.nome").getResultList();
    }



}
