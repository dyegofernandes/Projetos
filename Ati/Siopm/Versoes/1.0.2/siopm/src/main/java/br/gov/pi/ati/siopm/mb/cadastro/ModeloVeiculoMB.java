package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ModeloVeiculoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.ModeloVeiculo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ModeloVeiculoMB extends AbstractBaseBean<ModeloVeiculo> implements Serializable {

    @EJB
    private ModeloVeiculoBO modeloVeiculoBO;

    @Override
    public ModeloVeiculoBO getBO() {
        return modeloVeiculoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        setEntity(new ModeloVeiculo());
    }
    
}
