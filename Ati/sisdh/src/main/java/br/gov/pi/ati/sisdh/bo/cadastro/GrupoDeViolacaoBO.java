package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.GrupoDeViolacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.GrupoDeViolacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoDeViolacaoBO extends AbstractBusinessObject<GrupoDeViolacao> {

    @EJB
    private GrupoDeViolacaoDAO grupoDeViolacaoDAO;
    
    @Override
    public GrupoDeViolacaoDAO getDAO() {
        return grupoDeViolacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(GrupoDeViolacao grupoDeViolacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
