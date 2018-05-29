package br.gov.pi.siste.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.CargaHorariaBO;
import br.gov.pi.siste.modelo.cadastro.CargaHoraria;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CargaHorariaMB extends AbstractBaseBean<CargaHoraria> implements Serializable {

    @EJB
    private CargaHorariaBO cargaHorariaBO;

    private FiltrosVO filtros;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<CargaHoraria> cargasHorarias;

    @Override
    public CargaHorariaBO getBO() {
        return cargaHorariaBO;
    }

    @Override
    public void init() {
        filtros = new FiltrosVO();

        if (getEntity().getId() != null) {
            getEntity().setOrgao(usuarioAtual.getOrgao());
        }

        filtros.setUsuario(usuarioAtual);

        cargasHorarias = cargaHorariaBO.listarCargasHorarias(filtros);
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }

    @Override
    public void postSave() {
        setEntity(new CargaHoraria());
    }

    public void buscar() {

        filtros.setUsuario(usuarioAtual);

        cargasHorarias = cargaHorariaBO.listarCargasHorarias(filtros);
    }

    public CargaHorariaBO getCargaHorariaBO() {
        return cargaHorariaBO;
    }

    public void setCargaHorariaBO(CargaHorariaBO cargaHorariaBO) {
        this.cargaHorariaBO = cargaHorariaBO;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public List<CargaHoraria> getCargasHorarias() {
        return cargasHorarias;
    }

    public void setCargasHorarias(List<CargaHoraria> cargasHorarias) {
        this.cargasHorarias = cargasHorarias;
    }

    public List<Orgao> orgaoAutocompletePeloNome(String nome) {
        return getBO().orgaoPeloNome(nome);
    }

}
