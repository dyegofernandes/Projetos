package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.PoligonoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
import br.gov.pi.ati.siopm.modelo.cadastro.Ponto;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoligonoBO extends AbstractBusinessObject<Poligono> {

    @EJB
    private PoligonoDAO poligonoDAO;

    @Override
    public PoligonoDAO getDAO() {
        return poligonoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("nome");
    }

    @Override
    public void validate(Poligono poligono) throws BusinessException {
        List<Ponto> pontos = getDAO().getInitialized(poligono.getPontos());
        if (pontos.size() < 3) {
            throw new BusinessException("Um polígono deve possuir três ou mais pontos!");
        }

    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
