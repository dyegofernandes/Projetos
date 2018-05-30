package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ProgramaDeGovernoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramaDeGovernoBO extends AbstractBusinessObject<ProgramaDeGoverno> {

    @EJB
    private ProgramaDeGovernoDAO programaDeGovernoDAO;

    @Override
    public ProgramaDeGovernoDAO getDAO() {
        return programaDeGovernoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo,unidadeOrcamentaria").add("nome,unidadeOrcamentaria");
    }

    @Override
    public void validate(ProgramaDeGoverno programaDeGoverno) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<ProgramaDeGoverno> programaPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
