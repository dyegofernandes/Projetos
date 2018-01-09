package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.GrupoClienteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoCliente;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class GrupoClienteBO extends AbstractBusinessObject<GrupoCliente> {

    @EJB
    private GrupoClienteDAO grupoClienteDAO;
    
    @Override
    public GrupoClienteDAO getDAO() {
        return grupoClienteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","nome");
    }

    @Override
    public void validate(GrupoCliente grupoCliente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
