package br.com.dizimo.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.EnderecoBO;
import br.com.dizimo.modelo.cadastro.Endereco;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EnderecoMB extends AbstractBaseBean<Endereco> implements Serializable {

    @EJB
    private EnderecoBO enderecoBO;

    @Override
    public EnderecoBO getBO() {
        return enderecoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
