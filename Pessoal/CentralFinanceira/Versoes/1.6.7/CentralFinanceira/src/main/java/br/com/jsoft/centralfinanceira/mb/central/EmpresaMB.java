package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.EmpresaBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class EmpresaMB extends AbstractBaseBean<Empresa> implements Serializable {

    @EJB
    private EmpresaBO empresaBO;

    @Override
    public EmpresaBO getBO() {
        return empresaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
