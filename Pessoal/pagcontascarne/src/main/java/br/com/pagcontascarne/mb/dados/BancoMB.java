package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.BancoBO;
import br.com.pagcontascarne.modelo.dados.Banco;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BancoMB extends AbstractBaseBean<Banco> implements Serializable {

    @EJB
    private BancoBO bancoBO;

    @Override
    public BancoBO getBO() {
        return bancoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Banco> autocomplete(String nome) {
        return getBO().listarCodigoOuNome(nome);
    }
}
