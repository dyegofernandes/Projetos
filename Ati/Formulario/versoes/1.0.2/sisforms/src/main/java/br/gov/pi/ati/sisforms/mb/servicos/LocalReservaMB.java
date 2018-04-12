package br.gov.pi.ati.sisforms.mb.servicos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.LocalReservaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
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
    
    private List<LocalReserva> locais;
    
    
    @Override
    public void init() {
        Orgao orgao = getDAO().getInitialized(SessaoUtils.getUser().getOrgao());
        
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
    
   

    
}
