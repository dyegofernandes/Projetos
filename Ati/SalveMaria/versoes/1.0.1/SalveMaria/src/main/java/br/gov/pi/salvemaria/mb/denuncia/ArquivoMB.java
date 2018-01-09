package br.gov.pi.salvemaria.mb.denuncia;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.denuncia.ArquivoBO;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ArquivoMB extends AbstractBaseBean<Arquivo> implements Serializable {

    @EJB
    private ArquivoBO arquivoBO;

    @Override
    public ArquivoBO getBO() {
        return arquivoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
