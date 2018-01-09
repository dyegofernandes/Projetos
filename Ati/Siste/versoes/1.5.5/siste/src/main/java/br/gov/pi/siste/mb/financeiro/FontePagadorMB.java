package br.gov.pi.siste.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.financeiro.FontePagadorBO;
import br.gov.pi.siste.modelo.financeiro.FontePagador;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FontePagadorMB extends AbstractBaseBean<FontePagador> implements Serializable {

    @EJB
    private FontePagadorBO fontePagadorBO;

    @Override
    public FontePagadorBO getBO() {
        return fontePagadorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void postSave() {
        setEntity(new FontePagador());
    }
}
