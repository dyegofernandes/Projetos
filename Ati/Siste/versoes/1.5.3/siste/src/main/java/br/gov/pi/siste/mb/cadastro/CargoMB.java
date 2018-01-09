package br.gov.pi.siste.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.persistence.query.JoinBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.CargoBO;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CargoMB extends AbstractBaseBean<Cargo> implements Serializable {

    @EJB
    private CargoBO cargoBO;

    private List<Cargo> cargos;

    private FiltrosVO filtros;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public CargoBO getCargoBO() {
        return cargoBO;
    }

    public void setCargoBO(CargoBO cargoBO) {
        this.cargoBO = cargoBO;
    }

    @Override
    public CargoBO getBO() {
        return cargoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    @Override
    public void init() {
        filtros = new FiltrosVO();

        if (!usuarioAtual.isSuperUsuario()) {
            getEntity().setOrgao(usuarioAtual.getOrgao());
        }

        filtros.setUsuario(usuarioAtual);

        cargos = cargoBO.listarCargos(filtros);
    }

    @Override
    public void postSave() {
        setEntity(new Cargo());
    }

    public void buscar() {

        filtros.setUsuario(usuarioAtual);

        cargos = cargoBO.listarCargos(filtros);
    }

    @Override
    public void delete() {
        super.delete();
        cargos = cargoBO.listarCargos(filtros);
    }

}
