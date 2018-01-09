package br.gov.pi.ati.cfcpm.mb.mb;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.cfcpm.bo.cadastro.FormularioDeInscricaoBO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioDeInscricao;
import br.gov.pi.ati.cfcpm.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesUtils;
import java.util.HashMap;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormularioDeInscricaoMB extends AbstractBaseBean<FormularioDeInscricao> implements Serializable {
    
    @EJB
    private FormularioDeInscricaoBO formularioDeInscricaoBO;
    
    @Override
    public FormularioDeInscricaoBO getBO() {
        return formularioDeInscricaoBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void init() {
        
    }
    
    @Override
    public void postSave() {
//        setEntity(new FormularioDeInscricao());
        super.postSave();
    }
    
    public void gerarPdf(FormularioDeInscricao formulario) {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
        
        params.put("LOGO_ESTADO", caminhoImg.concat("/logo.png"));
        params.put("LOGO_ATI", caminhoImg.concat("/ati_novo.png"));
        params.put("DATA_INSCRICAO", Utils.convertDateToString(formulario.getDataInscricao(), "dd/MM/yyyy HH:mm"));
        params.put("CODIGO", formulario.getId().toString());
        
        params.put("NOME", formulario.getNome());
        params.put("RG", formulario.getIdentidade());
        params.put("CPF", Utils.format("###.###.###.##", formulario.getCpf()));
        params.put("NOMEACAO", Utils.convertDateToString(formulario.getDataDeNomeacao(), "dd/MM/yyyy"));
        params.put("NASCIMENTO", Utils.convertDateToString(formulario.getDataDeNascimento(), "dd/MM/yyyy"));
        params.put("SEXO", formulario.getSexo().getDescricao());
        params.put("LOTACAO", formulario.getLotacao());
        
        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formularioDeInscricao.jasper", "Inscricao ".concat(formulario.getId() + "") + ".pdf");
        
    }
    
    public void novo() {
        setEntity(new FormularioDeInscricao());
    }
    
}
