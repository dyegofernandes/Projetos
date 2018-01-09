package com.ebol.bo.venda;

import com.ebol.dao.venda.BoletoDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.VendaDAO;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Venda;
import com.ebol.modelo.vos.FiltroBusca;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class VendaBO extends AbstractBusinessObject<Venda> {

    @EJB
    private VendaDAO vendaDAO;

    @EJB
    private BoletoDAO boletoDAO;

    @Override
    public VendaDAO getDAO() {
        return vendaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Venda venda) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Venda> vendasPorConvenio(FiltroBusca filtro) {
        List<Venda> lista = new ArrayList<Venda>();
        Restrictions restrictions = new Restrictions();
        Convenio convenio = new Convenio();

        if (filtro.getConvenio() != null) {
            convenio = boletoDAO.getInitialized(filtro.getConvenio());
            restrictions.add("convenio", convenio);
        } else {
            if (!filtro.getUsuario().isSuperUsuario()) {
                convenio = boletoDAO.getInitialized(filtro.getUsuario().getConvenio());
                restrictions.add("convenio", convenio);
            }
        }
        if (filtro.getCliente() != null) {
            restrictions.add("cliente", filtro.getCliente());
        }

        if (filtro.getReferenteA() != null) {
            if (!filtro.getReferenteA().equals("")) {
                restrictions.like("referenteA", filtro.getReferenteA());
            }
        }
        
        if (filtro.getDescricao() != null) {
            if (!filtro.getDescricao().equals("")) {
                restrictions.like("descricao", filtro.getDescricao());
            }
        }
        
        lista = vendaDAO.list(restrictions, "convenio, referenteA");
        
        return lista;
    }

}
