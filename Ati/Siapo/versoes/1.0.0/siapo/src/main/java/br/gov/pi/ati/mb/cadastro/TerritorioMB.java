package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.TerritorioBO;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TerritorioMB extends AbstractBaseBean<Territorio> implements Serializable {

    private List<Municipio> municipios;

    private Municipio municipio;

    @EJB
    private TerritorioBO territorioBO;

    @Override
    public TerritorioBO getBO() {
        return territorioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        municipios = new ArrayList<Municipio>();

        if (getEntity().getId() != null) {
            municipios = getDAO().getInitialized(getEntity().getMunicipios());
        }
    }

    @Override
    public void save() {
        getEntity().setMunicipios(municipios);
        super.save();
    }

    public void addMunicipio() {
        if (municipio != null) {
            if (municipioJahAdd(municipio)) {
                FacesMessageUtils.error("Municipio já foi adicionado na lista!");
            } else {
                municipios.add(municipio);
                municipio = null;
            }

        } else {
            FacesMessageUtils.error("Municipio é obrigatório!");
        }
    }

    public void removerMunicipio(Municipio municipio) {
        municipios.remove(municipio);
    }

    private boolean municipioJahAdd(Municipio municipio) {
        for (Municipio municipio1 : municipios) {
            if (municipio.equals(municipio1)) {
                return true;
            }
        }
        return false;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Territorio> municipiosPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }
}
