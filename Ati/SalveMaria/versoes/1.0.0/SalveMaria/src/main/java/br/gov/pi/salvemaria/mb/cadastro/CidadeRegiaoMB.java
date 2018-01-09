package br.gov.pi.salvemaria.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.CidadeRegiaoBO;
import br.gov.pi.salvemaria.modelo.cadastro.CidadeRegiao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CidadeRegiaoMB extends AbstractBaseBean<CidadeRegiao> implements Serializable {

    @EJB
    private CidadeRegiaoBO cidadeRegiaoBO;

    @Override
    public CidadeRegiaoBO getBO() {
        return cidadeRegiaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
