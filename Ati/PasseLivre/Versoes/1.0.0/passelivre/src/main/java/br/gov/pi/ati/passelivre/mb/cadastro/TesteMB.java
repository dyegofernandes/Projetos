package br.gov.pi.ati.passelivre.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.passelivre.bo.cadastro.TesteBO;
import br.gov.pi.ati.passelivre.modelo.cadastro.Teste;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class TesteMB extends AbstractBaseBean<Teste> implements Serializable {

    @EJB
    private TesteBO testeBO;

    @Override
    public TesteBO getBO() {
        return testeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
