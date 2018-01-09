package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.SubFuncaoBO;
import br.gov.pi.ati.modelo.cadastro.SubFuncao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SubFuncaoMB extends AbstractBaseBean<SubFuncao> implements Serializable {

    @EJB
    private SubFuncaoBO subFuncaoBO;

    @Override
    public SubFuncaoBO getBO() {
        return subFuncaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
