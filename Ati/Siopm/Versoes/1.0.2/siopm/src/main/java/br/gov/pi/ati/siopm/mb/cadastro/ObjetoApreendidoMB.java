package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ObjetoApreendidoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ObjetoApreendidoMB extends AbstractBaseBean<ObjetoApreendido> implements Serializable {

    @EJB
    private ObjetoApreendidoBO objetoApreendidoBO;

    @Override
    public ObjetoApreendidoBO getBO() {
        return objetoApreendidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
