package br.gov.pi.salvemaria.mb.cadastro;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.Circunscricao_BairroBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class Circunscricao_BairroMB extends AbstractBaseBean<Circunscricao_Bairro> implements Serializable {

    @EJB
    private Circunscricao_BairroBO circunscricao_BairroBO;

    @EJB
    private BairroBO bairroBO;

    private Bairro bairroAdd;

    private List<Bairro> bairrosAutocomplete = new ArrayList<Bairro>();

    private List<Bairro> bairros = new ArrayList<Bairro>();

    private List<Bairro> bairrosDeletados = new ArrayList<Bairro>();

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

        if (getEntity().getId() != null) {
            bairros = bairroBO.bairrosPelaCircunscricao(getEntity());
            bairroPorCidade();
        }
    }

    @Override
    public void save() {
        if (bairros.size() > 0) {
            super.save();
            for (Bairro bairroTemp : bairros) {
                bairroBO.getDAO().saveOrMerge(bairroTemp, true);
            }

            for (Bairro bairroTemp : bairrosDeletados) {
                try {
                    bairroBO.getDAO().remove(bairroTemp, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(Circunscricao_BairroMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            FacesMessageUtils.error("É necessário ao menos um bairro para o cadastro de uma Circunscrição!");
        }

    }

    public void addBairro() {
        if (bairroAdd == null) {
            FacesMessageUtils.error("O bairro deve ser informada!");
        } else {
            if (bairroJaAdd(bairroAdd)) {
                FacesMessageUtils.error("A cidade já foi adicionada na lista!");
            } else {
                bairroAdd.setCircunscricao_Bairro(getEntity());
                bairros.add(bairroAdd);
                bairroAdd = new Bairro();
            }
        }
    }

    public void removerBairro(Bairro bairro) {
        if (bairro == null) {
            FacesMessageUtils.error("O bairro deve ser informada!");
        }
        if (bairro.getId() != null) {
            bairrosDeletados.add(bairro);
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
