package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ModalidadeDeAplicacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ModalidadeDeAplicacao;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModalidadeDeAplicacaoBO extends AbstractBusinessObject<ModalidadeDeAplicacao> {

    @EJB
    private ModalidadeDeAplicacaoDAO modalidadeDeAplicacaoDAO;
    
    @Override
    public ModalidadeDeAplicacaoDAO getDAO() {
        return modalidadeDeAplicacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(ModalidadeDeAplicacao modalidadeDeAplicacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
