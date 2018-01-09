package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.CargoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class CargoBO extends AbstractBusinessObject<Cargo> {

    @EJB
    private CargoDAO cargoDAO;

    @Override
    public CargoDAO getDAO() {
        return cargoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("orgao", "codigo", "nome");
    }

    @Override
    public void validate(Cargo cargo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Cargo> listarCargos(FiltrosVO filtros) {

        List<Cargo> cargos = new ArrayList<Cargo>();

        Restrictions restrictions = new Restrictions();

        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());

        if (!usuario.isSuperUsuario()) {

            Orgao orgao = getDAO().getInitialized(usuario.getOrgao());

            restrictions.add("orgao", orgao);
        }

        if (filtros.getNomeCargo() != null && !filtros.getNomeCargo().equals("")) {
            restrictions.like("cargo.nome", filtros.getNomeCargo());
        }

        if (filtros.getCodigo() != null && !filtros.getCodigo().equals("")) {
            restrictions.add("cargo.codigo", filtros.getCodigo());
        }

        cargos = cargoDAO.getQueryBuilder().select("cargo").from(Cargo.class, "cargo").innerJoinFetch("cargo.orgao", "orgao").add(restrictions).orderBy("orgao, cargo.nome")
                .getResultList();

        return cargos;
    }

    public List<Cargo> listarCargos(Orgao orgao) {

        if (orgao == null) {
            return null;
        }

        List<Cargo> cargos = new ArrayList<Cargo>();

        Restrictions restrictions = new Restrictions();

        restrictions.add("orgao", orgao);

        cargos = cargoDAO.list(restrictions, "orgao, nome");

        return cargos;
    }

}
