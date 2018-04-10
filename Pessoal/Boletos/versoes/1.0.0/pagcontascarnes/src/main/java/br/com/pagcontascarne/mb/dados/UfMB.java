package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.UfBO;
import br.com.pagcontascarne.modelo.dados.Uf;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UfMB extends AbstractBaseBean<Uf> implements Serializable {

    @EJB
    private UfBO BO;

    @Override
    public UfBO getBO() {
        return BO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Uf> autocomplete(String nome) {
        return getBO().listarUFPeloNome(nome);
    }
}
