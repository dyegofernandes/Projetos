package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.CircunscricaoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;

/**
 *
 * @author Juniel
 */
@Stateless
public class CircunscricaoBO extends AbstractBusinessObject<Circunscricao> {

    @EJB
    private CircunscricaoDAO circunscricaoDAO;

    @Override
    public CircunscricaoDAO getDAO() {
        return circunscricaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Circunscricao circunscricao) throws BusinessException {
        List<Cidade> cidades = getDAO().getInitialized(circunscricao.getCidades());

        if (cidades.size() < 1) {
            throw new BusinessException("É necessário ao menos uma cidade para o cadastro de uma Circunscrição!!");
        }

    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
