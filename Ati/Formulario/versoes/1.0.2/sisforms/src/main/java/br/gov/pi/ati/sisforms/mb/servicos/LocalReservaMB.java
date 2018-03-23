package br.gov.pi.ati.sisforms.mb.servicos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.LocalReservaBO;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import java.util.List;
import javax.annotation.PostConstruct;

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
    
    private List<LocalReserva> Locais;
    
    @PostConstruct
    public void init() {
        
        Locais = getBO().getDAO().listAll();                         
    }
    
    public List<LocalReserva> getLocais() {
        return Locais;
    }

    public void setLocais(List<LocalReserva> Locais) {
        this.Locais = Locais;
    }
}
