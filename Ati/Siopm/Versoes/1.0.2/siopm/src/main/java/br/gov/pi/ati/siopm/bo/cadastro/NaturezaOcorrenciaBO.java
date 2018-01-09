package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.NaturezaOcorrenciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaOcorrenciaBO extends AbstractBusinessObject<NaturezaOcorrencia> {

    @EJB
    private NaturezaOcorrenciaDAO naturezaOcorrenciaDAO;

    @Override
    public NaturezaOcorrenciaDAO getDAO() {
        return naturezaOcorrenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(NaturezaOcorrencia naturezaOcorrencia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<NaturezaOcorrencia> listarAtivos() {
        return getDAO().list("ativo", true, "codigo, nome");
    }

    public List<NaturezaOcorrencia> naturezasPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
