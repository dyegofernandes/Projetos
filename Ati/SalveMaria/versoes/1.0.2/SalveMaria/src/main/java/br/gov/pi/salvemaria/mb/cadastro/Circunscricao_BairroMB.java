package br.gov.pi.salvemaria.mb.cadastro;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.Circunscricao_BairroBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.CircunscricaoBairro;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class Circunscricao_BairroMB extends AbstractBaseBean<CircunscricaoBairro> implements Serializable {

    @EJB
    private Circunscricao_BairroBO circunscricao_BairroBO;

    @EJB
    private BairroBO bairroBO;

    private Bairro bairroAdd;

    private List<Bairro> bairrosAutocomplete = new ArrayList<Bairro>();

    private List<Bairro> bairros;

    @Override
    public Circunscricao_BairroBO getBO() {
        return circunscricao_BairroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void init() {
        bairroAdd = new Bairro();
        bairros = new ArrayList<Bairro>();

        if (getEntity().getId() != null) {
            bairros = bairroBO.getDAO().getInitialized(getEntity().getBairros());
            Collections.sort(bairros);
            bairroPorCidade();
        }
    }

    @Override
    public void save() {
        getEntity().setBairros(bairros);
        super.save();
    }

    public void addBairro() {
        if (bairroAdd == null) {
            FacesMessageUtils.error("O bairro deve ser informada!");
        } else {
            if (bairroJaAdd(bairroAdd)) {
                FacesMessageUtils.error("A cidade já foi adicionada na lista!");
            } else {
                bairros.add(bairroAdd);
                Collections.sort(bairros);
                bairroAdd = new Bairro();
            }
        }
    }

    public void removerBairro(Bairro bairro) {
        if (bairro == null) {
            FacesMessageUtils.error("O bairro deve ser informada!");
        }
        bairros.remove(bairro);
    }

    public Bairro getBairroAdd() {
        return bairroAdd;
    }

    public void setBairroAdd(Bairro bairroAdd) {
        this.bairroAdd = bairroAdd;
    }

    public List<Bairro> getBairrosAutocomplete() {

        return bairrosAutocomplete;
    }

    public void bairroPorCidade() {
        if (getEntity().getCidade() != null) {
            bairrosAutocomplete = bairroBO.bairrosPelaCidade(getEntity().getCidade());
        } else {
            bairrosAutocomplete = new ArrayList<Bairro>();
            bairroAdd = new Bairro();
        }
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    private boolean bairroJaAdd(Bairro bairro) {
        for (Bairro bairroTemp : bairros) {
            if (bairroTemp.equals(bairro)) {
                return true;
            }
        }
        return false;
    }

}
