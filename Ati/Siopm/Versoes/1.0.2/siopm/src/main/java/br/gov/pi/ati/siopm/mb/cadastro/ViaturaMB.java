package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ViaturaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.ApelidoViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.JoinBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ViaturaMB extends AbstractBaseBean<Viatura> implements Serializable {

    @EJB
    private ViaturaBO viaturaBO;

    private String apelidoAdd;

    private List<ApelidoViatura> apelidos;

    @Override
    public void init() {
        apelidos = new ArrayList<ApelidoViatura>();
        if (getEntity().getId() != null) {
            apelidos = getBO().getDAO().getInitialized(getEntity().getApelidos());
        }
    }

    @Override
    public ViaturaBO getBO() {
        return viaturaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "viatura.prefixo";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("viatura").leftJoinFetch("viatura.marcaModelo", "marcaModelo").
                leftJoinFetch("marcaModelo.marca", "marca");
    }

    @Override
    public void save() {
        getEntity().setApelidos(apelidos);
        super.save();
    }

    @Override
    public void postSave() {
        setEntity(new Viatura());
        apelidos = new ArrayList<ApelidoViatura>();
    }

    public List<Viatura> autocompletePeloNome(String nome) {
        return getBO().viaturasAtivasPorNome(nome);
    }

    public String getApelidoAdd() {
        return apelidoAdd;
    }

    public void setApelidoAdd(String apelidoAdd) {
        this.apelidoAdd = apelidoAdd;
    }

    public List<ApelidoViatura> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<ApelidoViatura> apelidos) {
        this.apelidos = apelidos;
    }

    public void addApelido() {
        if (Utils.isNullOrEmpty(apelidoAdd)) {
            FacesMessageUtils.error("Apelido é obrigatório!");
        } else {
            if (seApelidoJahExiste(apelidoAdd)) {
                FacesMessageUtils.error("Codinome já foi adicionado!");
            } else {
                ApelidoViatura ap = new ApelidoViatura();
                ap.setNome(apelidoAdd);
                apelidos.add(ap);
                apelidoAdd = "";
            }
        }
    }

    public void removerApelido(ApelidoViatura apelido) {
        apelidos.remove(apelido);
    }

    private boolean seApelidoJahExiste(String nome) {
        for (ApelidoViatura apelido : apelidos) {
            if (apelido.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}
