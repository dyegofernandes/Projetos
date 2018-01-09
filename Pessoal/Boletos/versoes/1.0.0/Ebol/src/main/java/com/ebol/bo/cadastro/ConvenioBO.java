package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.ConvenioDAO;
import com.ebol.modelo.cadastro.Banco;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.vos.FiltroBusca;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioBO extends AbstractBusinessObject<Convenio> {

    @EJB
    private ConvenioDAO convenioDAO;

    @Override
    public ConvenioDAO getDAO() {
        return convenioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpfCnpj").add("email").add("fantasia").add("nomePos").add("razaoSocial");
    }

    @Override
    public void validate(Convenio convenio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Convenio> listarConvenios(FiltroBusca filtros) {
        List<Convenio> convenios = null;
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Convenio convenio = null;
        Restrictions restrictions = new Restrictions();

        if (!usuario.isSuperUsuario()) {
            Banco banco = getDAO().getInitialized(usuario.getBanco());
            restrictions.add("banco", banco);
            if (usuario.getConvenio() != null) {
                convenio = getDAO().getInitialized(usuario.getConvenio());
                restrictions.add("convenio.id", convenio.getId());
            }
        } else {
            if (filtros.getBanco() != null) {
                restrictions.add("banco", filtros.getBanco());
            }

            if (filtros.getConvenio() != null) {
                convenio = getDAO().getInitialized(filtros.getConvenio());
                restrictions.add("convenio.id", convenio.getId());
            }
        }

        if (filtros.getCpfCnpj() != null && !filtros.getCpfCnpj().equals("")) {
            restrictions.add("convenio.cpfCnpj", filtros.getCpfCnpj());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.add("convenio.razaoSocial", filtros.getNome());
        }

        if (filtros.getApelido() != null && !filtros.getApelido().equals("")) {
            restrictions.add("convenio.fantasia", filtros.getApelido());
        }

        if (filtros.getCidade() != null) {
            restrictions.add("convenio.cidade", filtros.getCidade());
        }

        convenios = getDAO().getQueryBuilder().select("convenio").from(Convenio.class, "convenio").leftJoinFetch("convenio.banco", "banco").
                leftJoinFetch("convenio.cidade", "cidade").add(restrictions).orderBy("banco, convenio.razaoSocial").getResultList();

        return convenios;
    }

}
