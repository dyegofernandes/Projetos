package br.gov.pi.ati.cfcpm.mb.mb;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.cfcpm.bo.cadastro.FormularioInscricaoSAVBO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioInscricaoSAV;
import br.gov.pi.ati.cfcpm.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import java.util.HashMap;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormularioInscricaoSAVMB extends AbstractBaseBean<FormularioInscricaoSAV> implements Serializable {

    @EJB
    private FormularioInscricaoSAVBO formularioInscricaoSAVBO;

    @Override
    public FormularioInscricaoSAVBO getBO() {
        return formularioInscricaoSAVBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public void gerarPdf(FormularioInscricaoSAV formulario) {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
        
        params.put("LOGO_ESTADO", caminhoImg.concat("/brasao.png"));
        params.put("LOGO_PM", caminhoImg.concat("/logo_pm.jpg"));
        params.put("DATA_INSCRICAO", Utils.convertDateToString(formulario.getDataInscricao(), "dd/MM/yyyy HH:mm"));
        params.put("CODIGO", formulario.getId().toString());
        
        params.put("NOME", formulario.getNome());
        params.put("RG", formulario.getIdentidade());
        params.put("ORGAO", formulario.getOrgao());
        params.put("CPF", Utils.format("###.###.###.##", formulario.getCpf()));
        params.put("NASCIMENTO", Utils.convertDateToString(formulario.getDataDeNascimento(), "dd/MM/yyyy"));
        params.put("SEXO", formulario.getSexo().getDescricao());
        params.put("ESCOLARIDADE", formulario.getEscolaridade());
        
        
        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formularioDeInscricaoSAV.jasper", "Inscricao ".concat(formulario.getId() + "") + ".pdf");
        
    }
    
    public void novo() {
        setEntity(new FormularioInscricaoSAV());
    }
}
