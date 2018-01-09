package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.QualificacaoDeVeiculoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;

/**
 *
 * @author Juniel
 */
@Stateless
public class QualificacaoDeVeiculoBO extends AbstractBusinessObject<QualificacaoDeVeiculo> {

    @EJB
    private QualificacaoDeVeiculoDAO qualificacaoDeVeiculoDAO;
    
    @Override
    public QualificacaoDeVeiculoDAO getDAO() {
        return qualificacaoDeVeiculoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(QualificacaoDeVeiculo qualificacaoDeVeiculo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
