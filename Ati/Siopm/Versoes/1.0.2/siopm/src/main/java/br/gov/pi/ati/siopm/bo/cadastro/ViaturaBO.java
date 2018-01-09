package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ViaturaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.ApelidoViatura;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class ViaturaBO extends AbstractBusinessObject<Viatura> {

    @EJB
    private ViaturaDAO viaturaDAO;

    @Override
    public ViaturaDAO getDAO() {
        return viaturaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("prefixo");
    }

    @Override
    public void validate(Viatura viatura) throws BusinessException {

        List<ApelidoViatura> apelidos = getDAO().getInitialized(viatura.getApelidos());

        if (apelidos.size() < 1) {
            throw new BusinessException("Informe um ou mais apelido!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Viatura> viaturasAtivasPorNome(String nome) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("viatura.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("viatura.prefixo", nome);
        }

        return getDAO().getQueryBuilder().select("viatura").from(Viatura.class, "viatura")
                .leftJoinFetch("viatura.marcaModelo", "marcaModelo").leftJoinFetch("marcaModelo.marca", "marca")
                .add(restrictions).orderBy("viatura.prefixo").getResultList();
    }

    public List<String> apelidosPorViatura(Viatura viatura) {

        if (viatura == null) {
            return null;
        }

        List<String> apelidosStrings = new ArrayList<String>();

        List<ApelidoViatura> apelidos = getDAO().getInitialized(viatura.getApelidos());

        for (ApelidoViatura apelido : apelidos) {
            apelidosStrings.add(apelido.getNome());
        }

        return apelidosStrings;
    }
}
