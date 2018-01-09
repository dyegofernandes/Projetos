package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ModeloVeiculoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.ModeloVeiculo;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModeloVeiculoBO extends AbstractBusinessObject<ModeloVeiculo> {

    @EJB
    private ModeloVeiculoDAO modeloVeiculoDAO;

    @Override
    public ModeloVeiculoDAO getDAO() {
        return modeloVeiculoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("marca", "nome");
    }

    @Override
    public void validate(ModeloVeiculo modeloVeiculo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
