package br.com.jsoft.centralfinanceira.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.financeiro.CentroResultadosDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.financeiro.CentroResultados;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class CentroResultadosBO extends AbstractBusinessObject<CentroResultados> {

    @EJB
    private CentroResultadosDAO centroResultadosDAO;
    
    @Override
    public CentroResultadosDAO getDAO() {
        return centroResultadosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","centroResultadoMae","nome");
    }

    @Override
    public void validate(CentroResultados centroResultados) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
