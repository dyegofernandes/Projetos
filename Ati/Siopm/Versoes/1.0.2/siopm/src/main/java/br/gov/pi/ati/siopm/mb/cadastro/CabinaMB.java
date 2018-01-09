package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.CabinaBO;
import br.gov.pi.ati.siopm.bo.cadastro.CidadeBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Cabina;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CabinaMB extends AbstractBaseBean<Cabina> implements Serializable {

    @EJB
    private CabinaBO cabinaBO;
    
    @EJB
    private CidadeBO cidadeBO;

    private Opm opmAdd;

    private List<Opm> opms;

    @Override
    public CabinaBO getBO() {
        return cabinaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        if (getEntity().getId() != null) {
            opms = getBO().getDAO().getInitialized(getEntity().getOpms());
        } else {
            opms = new ArrayList<Opm>();
        }
    }

    @Override
    public void save() {
        getEntity().setOpms(opms);
        super.save();
    }

    public void addOpm() {
        if (opmAdd != null) {
            opms.add(opmAdd);
        } else {
            FacesMessageUtils.error("Opm é obrigatória!!");
        }
    }

    public void removerOpm(Opm opm) {
        if (opm != null) {
            opms.remove(opm);
        }
    }

    public Opm getOpmAdd() {
        return opmAdd;
    }

    public void setOpmAdd(Opm opmAdd) {
        this.opmAdd = opmAdd;
    }

    public List<Opm> getOpms() {
        return opms;
    }

    public void setOpms(List<Opm> opms) {
        this.opms = opms;
    }
    
    public List<Cidade> getCidades() {
        return cidadeBO.listarCidadePeloEstado(17L);
    }

}
