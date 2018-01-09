package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ParametroSistemaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.ParametroSistema;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ParametroSistemaMB extends AbstractBaseBean<ParametroSistema> implements Serializable {

    @EJB
    private ParametroSistemaBO parametroSistemaBO;

    @Override
    public ParametroSistemaBO getBO() {
        return parametroSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
