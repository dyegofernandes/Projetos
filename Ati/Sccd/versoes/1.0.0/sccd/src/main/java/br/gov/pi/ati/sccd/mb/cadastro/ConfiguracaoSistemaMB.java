package br.gov.pi.ati.sccd.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.cadastro.ConfiguracaoSistemaBO;
import br.gov.pi.ati.sccd.modelo.cadastro.ConfiguracaoSistema;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ConfiguracaoSistemaMB extends AbstractBaseBean<ConfiguracaoSistema> implements Serializable {

    @EJB
    private ConfiguracaoSistemaBO configuracaoSistemaBO;

    @Override
    public ConfiguracaoSistemaBO getBO() {
        return configuracaoSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
