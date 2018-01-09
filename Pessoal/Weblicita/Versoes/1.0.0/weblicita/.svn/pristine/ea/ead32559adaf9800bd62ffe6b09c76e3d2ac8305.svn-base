package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.TipoModalidadeBO;
import br.com.weblicita.modelo.cadastro.TipoModalidade;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TipoModalidadeMB extends AbstractBaseBean<TipoModalidade> implements Serializable {

    @EJB
    private TipoModalidadeBO tipoModalidadeBO;

    @Override
    public TipoModalidadeBO getBO() {
        return tipoModalidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
