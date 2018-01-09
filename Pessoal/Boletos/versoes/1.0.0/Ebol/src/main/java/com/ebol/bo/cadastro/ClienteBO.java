package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.ClienteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.vos.FiltroBusca;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class ClienteBO extends AbstractBusinessObject<Cliente> {

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public ClienteDAO getDAO() {
        return clienteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("convenio", "cpfOrCnpj");
    }

    @Override
    public void validate(Cliente cliente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Cliente> clientesPorConvenio(FiltroBusca filtro) {
        List<Cliente> lista = new ArrayList<Cliente>();
        Restrictions restrictions = new Restrictions();
        Convenio convenio = new Convenio();

        if (filtro.getConvenio() != null) {
            convenio = clienteDAO.getInitialized(filtro.getConvenio());
            restrictions.add("convenio", convenio);
        } else {
            if (!filtro.getUsuario().isSuperUsuario()) {
                convenio = clienteDAO.getInitialized(filtro.getUsuario().getConvenio());
                restrictions.add("convenio", convenio);
            }
        }

        if (filtro.getNome() != null) {
            if (!filtro.getNome().equals("")) {
                restrictions.like("completoOuRsocial", filtro.getNome());
            }
        }

        if (filtro.getApelido() != null) {
            if (!filtro.getApelido().equals("")) {
                restrictions.like("nomeOuFantasia", filtro.getApelido());
            }
        }

        if (filtro.getCpfCnpj() != null) {
            if (!filtro.getCpfCnpj().equals("")) {
                restrictions.add("cpfOrCnpj", filtro.getCpfCnpj());
            }
        }

        if (filtro.getTipoPessoa() != null) {
            restrictions.add("fisicOujur", filtro.getTipoPessoa());
        }

        lista = clienteDAO.list(restrictions, "convenio, nomeOuFantasia");

        return lista;
    }

}
