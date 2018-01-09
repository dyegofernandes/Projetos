package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.OrgaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoBO extends AbstractBusinessObject<Orgao> {

    @EJB
    private OrgaoDAO orgaoDAO;

    @Override
    public OrgaoDAO getDAO() {
        return orgaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cnpj");
    }

    @Override
    public void validate(Orgao orgao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Orgao> listarOrgaosPorUsuario(Usuario usuario) {
        List<Orgao> retorno = new ArrayList<Orgao>();

        if (usuario.isSuperUsuario()) {
            retorno = orgaoDAO.listAll();
        } else {
            Unidade unidade = orgaoDAO.getInitialized(usuario.getUnidade());
            Orgao orgao = orgaoDAO.getInitialized(unidade.getOrgao());
            retorno = orgaoDAO.list("id", orgao.getId());
        }

        return retorno;

    }

    public List<Orgao> listarOrgao(FiltrosVO filtros) {
        List<Orgao> orgaos = new ArrayList<Orgao>();

        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Unidade unidade = null;
        Orgao orgao = null;
        Restrictions restrictions = new Restrictions();

        if (!usuario.isSuperUsuario()) {
            unidade = getDAO().getInitialized(usuario.getUnidade());
            orgao = getDAO().getInitialized(unidade.getOrgao());

            restrictions.add("id", orgao.getId());
        } else {
            if (filtros.getOrgao() != null) {
                restrictions.add("id", filtros.getOrgao().getId());
            }
        }

        orgaos = orgaoDAO.list(restrictions);

        return orgaos;
    }

    public List<Orgao> orgaosPorUnidades(List<Unidade> unidades) {
        List<Orgao> orgaos = new ArrayList<Orgao>();
        for (Unidade unidade : unidades) {
            Orgao orgao = getDAO().getInitialized(unidade.getOrgao());
            if (!orgaos.contains(orgao)) {
                orgaos.add(orgao);
            }
        }

        return orgaos;
    }

}
