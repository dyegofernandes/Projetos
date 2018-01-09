package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.FormRegistroDominioBO;
import br.gov.pi.ati.sisforms.constante.ConstantesURL;
import br.gov.pi.ati.sisforms.modelo.formulario.FormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.formulario.FormRegistroDominio;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormRegistroDominioMB extends AbstractBaseBean<FormRegistroDominio> implements Serializable {

    @EJB
    private FormRegistroDominioBO formRegistroDominioBO;

    @Override
    public FormRegistroDominioBO getBO() {
        return formRegistroDominioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarPdf(FormRegistroDominio form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logo.png");
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati_novo.png");

        params.put("LOGO_PI", imgLogoPI);
        params.put("LOGO_ATI", imgLogoAti);

        List<FormRegistroDominio> formularios = new ArrayList<FormRegistroDominio>();

        formularios.add(form);

        FacesJasper.createJasperReport(formularios, params,
                "/WEB-INF/report/formulario/formularioRegistroDominio.jasper", "Formulario de Registro de Dominio" + ".pdf");

    }

    public void voltar() {
        FacesUtils.redirect("/index.jsf");
    }
}
