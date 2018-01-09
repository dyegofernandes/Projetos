package br.gov.pi.ati.adapi.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.adapi.bo.cadastro.AnimalBO;
import br.gov.pi.ati.adapi.modelo.cadastro.Animal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AnimalMB extends AbstractBaseBean<Animal> implements Serializable {

    @EJB
    private AnimalBO animalBO;

    @Override
    public AnimalBO getBO() {
        return animalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
