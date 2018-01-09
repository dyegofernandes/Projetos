package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.TelefoneBO;
import br.com.weblicita.modelo.cadastro.Telefone;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TelefoneMB extends AbstractBaseBean<Telefone> implements Serializable {

    @EJB
    private TelefoneBO telefoneBO;

    @Override
    public TelefoneBO getBO() {
        return telefoneBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
