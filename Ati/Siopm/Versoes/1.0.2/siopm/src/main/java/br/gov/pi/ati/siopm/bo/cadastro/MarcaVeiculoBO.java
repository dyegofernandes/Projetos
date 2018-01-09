package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.MarcaVeiculoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaVeiculo;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class MarcaVeiculoBO extends AbstractBusinessObject<MarcaVeiculo> {

    @EJB
    private MarcaVeiculoDAO marcaVeiculoDAO;
    
    @Override
    public MarcaVeiculoDAO getDAO() {
        return marcaVeiculoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return  new UniqueFields().add("nome");
    }

    @Override
    public void validate(MarcaVeiculo marcaVeiculo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
