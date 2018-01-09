package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ControleDeCertificadoBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ControleDeCertificado;
import com.xpert.persistence.query.JoinBuilder;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ControleDeCertificadoMB extends AbstractBaseBean<ControleDeCertificado> implements Serializable {

    @EJB
    private ControleDeCertificadoBO controleDeCertificadoBO;

    @Override
    public ControleDeCertificadoBO getBO() {
        return controleDeCertificadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "controleDeCertificado.dataAprovacao ASC";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("controleDeCertificado").leftJoinFetch("controleDeCertificado.orgao", "orgao")
                .leftJoinFetch("controleDeCertificado.tipoCertificado", "tipoCertificado");
    }
}
