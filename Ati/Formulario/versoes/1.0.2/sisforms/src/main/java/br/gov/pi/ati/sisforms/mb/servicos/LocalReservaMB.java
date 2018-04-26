package br.gov.pi.ati.sisforms.mb.servicos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.LocalReservaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.TipoLocal;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import java.util.List;



/**
 *
 * @author Juniel, Nilson, Samuel, Yago
 */
@ManagedBean
@ViewScoped
public class LocalReservaMB extends AbstractBaseBean<LocalReserva> implements Serializable {

    @EJB
    private LocalReservaBO localReservaBO;

    @Override
    public LocalReservaBO getBO() {
        return localReservaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    private List<TipoLocal> tipos;
    
    private List<LocalReserva> locais;
    Usuario usuarioAtual;
    private FiltrosVO filtros;
    @Override
    public void init() {
        
        usuarioAtual = SessaoUtils.getUser();
        filtros  = new FiltrosVO();
        filtros.setUsuario(usuarioAtual);
        
        Orgao orgao = getDAO().getInitialized(usuarioAtual.getOrgao());
        
        if(getEntity().getId()==null){
            getEntity().setOrgao(orgao);
        }
        locais = getBO().locaisPorOrgao(orgao);
    }
    
    public List<LocalReserva> getLocais() {
        return locais;
    }

    public void setLocais(List<LocalReserva> Locais) {
        this.locais = Locais;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public LocalReservaBO getLocalReservaBO() {
        return localReservaBO;
    }

    public void setLocalReservaBO(LocalReservaBO localReservaBO) {
        this.localReservaBO = localReservaBO;
    }
    
   public void buscar() {
        
        locais = localReservaBO.listarLocais(filtros);
    }

    public List<TipoLocal> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoLocal> tipos) {
        this.tipos = tipos;
    }
   
   
   public List<Orgao> orgaoAutocompletePeloNome(String nome) {
        return getBO().orgaoPeloNome(nome);
    }
    
   
}
