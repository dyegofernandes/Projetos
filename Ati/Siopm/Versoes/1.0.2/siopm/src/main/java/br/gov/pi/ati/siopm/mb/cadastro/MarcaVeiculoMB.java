package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.MarcaVeiculoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaVeiculo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MarcaVeiculoMB extends AbstractBaseBean<MarcaVeiculo> implements Serializable {

    @EJB
    private MarcaVeiculoBO marcaVeiculoBO;

    @Override
    public MarcaVeiculoBO getBO() {
        return marcaVeiculoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new MarcaVeiculo());
    }
}
