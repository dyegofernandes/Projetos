package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ListaLojaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja;

/**
 *
 * @author Juniel
 */
@Stateless
public class ListaLojaBO extends AbstractBusinessObject<ListaLoja> {

    @EJB
    private ListaLojaDAO listaLojaDAO;
    
    @Override
    public ListaLojaDAO getDAO() {
        return listaLojaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ListaLoja listaLoja) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
