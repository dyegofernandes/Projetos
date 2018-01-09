package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.RequerimentoBO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.Requerimento;
import br.gov.pi.ati.sisforms.modelo.vos.RequerimentoVO;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
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
public class RequerimentoMB extends AbstractBaseBean<Requerimento> implements Serializable {

    @EJB
    private RequerimentoBO requerimentoBO;
    
    private Usuario usuarioAtual = SessaoUtils.getUser();

    @Override
    public void init() {
        if(getEntity().getId()==null){
            getEntity().setUsuario(usuarioAtual);
        }
    }

    @Override
    public RequerimentoBO getBO() {
        return requerimentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarPdf(Requerimento requerimento) {
        HashMap params = new HashMap();
        String imgBrasao = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/brasao4.jpg");
        String imgAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/atiFundoBranco.png");
        String imgFace = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/facebook.png");
        String imgInstagram = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/instagram.jpg");
        String imgTwitter = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/twitter.png");

        RequerimentoVO requerimentoVO = new RequerimentoVO(requerimento);

        params.put("URL_IMG_ICON_PI", imgBrasao);
        params.put("URL_IMG_ICON_ATI", imgAti);
        params.put("URL_IMG_ICON_FACE", imgFace);
        params.put("URL_IMG_ICON_INSTAGRAM", imgInstagram);
        params.put("URL_IMG_ICON_TWITTER", imgTwitter);
        params.put("DATA_SOLICITACAO", Utils.convertDateToString(requerimento.getDataSolicitacao(), 12));

        List<RequerimentoVO> requerimentos = new ArrayList<RequerimentoVO>();

        requerimentos.add(requerimentoVO);

        FacesJasper.createJasperReport(requerimentos, params,
                "/WEB-INF/report/formulario/requerimento.jasper", "Requerimento - "+ requerimento.getAssuntoRequerimento().getDescricao() + ".pdf");

    }
}
