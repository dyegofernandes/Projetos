package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.ItemDAO;
import com.ebol.modelo.cadastro.Convenio;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Item;
import com.ebol.modelo.vos.FiltroBusca;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemBO extends AbstractBusinessObject<Item> {

    @EJB
    private ItemDAO itemDAO;

    @Override
    public ItemDAO getDAO() {
        return itemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio", "descricao");
    }

    @Override
    public void validate(Item item) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Item> itensPorConvenio(FiltroBusca filtro) {
        List<Item> lista = new ArrayList<Item>();
        Restrictions restrictions = new Restrictions();
        Convenio convenio = new Convenio();
        
        if (filtro.getConvenio() != null) {
            convenio = itemDAO.getInitialized(filtro.getConvenio());
            restrictions.add("convenio", convenio);
        } else {
            if (!filtro.getUsuario().isSuperUsuario()) {
                convenio = itemDAO.getInitialized(filtro.getUsuario().getConvenio());
                restrictions.add("convenio", convenio);
            }
        }
        if (filtro.getDescricao() != null) {
            if (!filtro.getDescricao().equals("")) {
                restrictions.like("descricao", filtro.getDescricao());
            }
        }
        if(filtro.getUnitario()!=null){
            restrictions.equals("unitario", filtro.getUnitario());
        }
        
        lista = itemDAO.list(restrictions, "convenio, descricao");
        
        return lista;
    }

}
