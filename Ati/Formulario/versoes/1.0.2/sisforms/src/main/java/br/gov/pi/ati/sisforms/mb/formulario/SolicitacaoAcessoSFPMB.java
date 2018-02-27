package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.TermoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.SolicitacaoAcessoSFPBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Termo;
import br.gov.pi.ati.sisforms.modelo.cadastro.TermoAceito;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoSFP;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import br.gov.pi.ati.sisforms.webservices.inforfolha.ServidorVO;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SolicitacaoAcessoSFPMB extends AbstractBaseBean<SolicitacaoAcessoSFP> implements Serializable {

    @EJB
    private SolicitacaoAcessoSFPBO solicitacaoAcessoSFPBO;

    @EJB
    private TermoBO termoBO;

    private Termo termoResponsabilidadeAtivo;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private boolean renderizarAceite;
    
    @Override
    public void init() {
        renderizarAceite = false;
        termoResponsabilidadeAtivo = termoBO.termoAtivoPorNome("TERMO DE RESPONSABILIDADE");
        
        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
            
            ServidorVO servidor = Utils.consultarServidorPeloCPF(usuarioAtual.getCpf());
            
            if (servidor != null) {
                getEntity().setTipo(TrabalhadorTipo.SERVIDOR);
                getEntity().setTelefone(servidor.getTelefone());
                getEntity().setCargoFuncao(servidor.getCargo());
            } else {
                getEntity().setTipo(TrabalhadorTipo.TERCEIRIZADO);
            }
            
        }
    }

    @Override
    public void postSave() {

    }

    @Override
    public void save() {

        super.save();

    }

    @Override
    public SolicitacaoAcessoSFPBO getBO() {
        return solicitacaoAcessoSFPBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarPdf(SolicitacaoAcessoSFP form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/brasao2.jpg");

        params.put("LOGO_PI", imgLogoPI);
        params.put("ORGAO", getEntity().getUsuario().getOrgao() != null ? "ÓRGÃO: ".concat(solicitacaoAcessoSFPBO.getDAO().getInitialized(getEntity().getUsuario().getOrgao()).getNome())
                : "ÓRGÃO:");
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataEmissao(), "dd/MM/yyyy HH:mm"));

        params.put("CPF", getEntity().getUsuario().getCpf() != null ? "CPF: ".concat(Utils.format("###.###.###-##", getEntity().getUsuario().getCpf())) : "CPF:");
        params.put("MATRICULA", getEntity().getUsuario().getMatricula() != null ? "MATRÍCULA: ".concat(getEntity().getUsuario().getMatricula()) : "MATRÍCULA:");
        params.put("TELEFONE", form.getTelefone() != null ? "TELEFONE: ".concat(form.getTelefone()) : "TELEFONE:");
        params.put("CARGO_FUNCAO", form.getCargoFuncao() != null ? "CARGO/FUNÇÃO: ".concat(form.getCargoFuncao()) : "CARGO/FUNÇÃO:");
        params.put("EMAIL", getEntity().getUsuario().getEmail() != null ? "E-MAIL: ".concat(getEntity().getUsuario().getEmail()) : "E-MAIL:");
        params.put("NOME", getEntity().getUsuario().getNome() != null ? "NOME: ".concat(getEntity().getUsuario().getNome()) : "NOME:");
        params.put("ORGAO_ACESSO", "Órgão(s) que o usuário terá acesso: ");
        params.put("OBS", form.getObservacao() != null ? "Observação: ".concat(form.getObservacao()) : "Observação:");
//        params.put("OP_C_INCLUSAO", form.getCadastro().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("OP_C_ALTERACAO", form.getCadastro().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("OP_C_CONSULTA", form.getCadastro().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("OP_F_INCLUSAO", form.getFinanceiro().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("OP_F_ALTERACAO", form.getFinanceiro().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("OP_F_CONSULTA", form.getFinanceiro().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("OP_D_INCLUSAO", form.getDependente().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("OP_D_ALTERACAO", form.getDependente().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("OP_D_CONSULTA", form.getDependente().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("OP_P_INCLUSAO", form.getPensaoJudicial().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("OP_P_ALTERCAO", form.getPensaoJudicial().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("OP_P_CONSULTA", form.getPensaoJudicial().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("OP_O_AFASTA", form.getOcorrencia().isAfastamentoLicenca() ? "(X) Afastamento/Licenças" : "( ) Afastamento/Licenças");
//        params.put("OP_O_EXO", form.getOcorrencia().isExoneracao() ? "(X) Exonerações" : "( ) Exonerações");
//        params.put("OP_O_APO", form.getOcorrencia().isAposentadoria() ? "(X) Aposentadorias" : "( ) Aposentadorias");
//        params.put("OP_O_DISP", form.getOcorrencia().isDisposicao() ? "(X) Disposições" : "( ) Disposições");
//        params.put("OP_O_ENQ", form.getOcorrencia().isEnquadramento() ? "(X) Enquadramento/Promoções" : "(X) Enquadramento/Promoções");
//        params.put("AR_C_INCLUSAO", form.getCadastroSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("AR_C_ALTERACAO", form.getCadastroSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("AR_C_CONSULTA", form.getCadastroSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("AR_F_INCLUSAO", form.getFinanceiroSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("AR_F_ALTERACAO", form.getFinanceiroSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("AR_F_CONSULTA", form.getFinanceiroSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("AR_D_INCLUSAO", form.getDependenteSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("AR_D_ALTERACAO", form.getDependenteSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("AR_D_CONSULTA", form.getDependenteSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("AR_P_INCLUSAO", form.getPensaoJudicialSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
//        params.put("AR_P_ALTERCAO", form.getPensaoJudicialSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
//        params.put("AR_P_CONSULTA", form.getPensaoJudicialSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
//        params.put("AR_O_AFASTA", form.getOcorrenciaSEAD().isAfastamentoLicenca() ? "(X) Afastamento/Licenças" : "( ) Afastamento/Licenças");
//        params.put("AR_O_EXO", form.getOcorrenciaSEAD().isExoneracao() ? "(X) Exonerações" : "( ) Exonerações");
//        params.put("AR_O_APO", form.getOcorrenciaSEAD().isAposentadoria() ? "(X) Aposentadorias" : "( ) Aposentadorias");
//        params.put("AR_O_DISP", form.getOcorrenciaSEAD().isDisposicao() ? "(X) Disposições" : "( ) Disposições");
//        params.put("AR_O_ENQ", form.getOcorrenciaSEAD().isEnquadramento() ? "(X) Enquadramento/Promoções" : "(X) Enquadramento/Promoções");
        params.put("TEXTO_UM", Utils.getTextoUmSFP());
        params.put("TEXTO_DOIS", Utils.getTextoDoisSFP());

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/solicitacaoAcessoSFP.jasper", "Solicitacao de acesso SFP" + ".pdf");

    }
    
    public void renderAceitar() {
        renderizarAceite = true;
    }
    
    public void aceitar() {
        
        if (termoResponsabilidadeAtivo != null) {
            TermoAceito termoAceito = new TermoAceito();
            termoAceito.setTermo(termoResponsabilidadeAtivo);
            getEntity().setTermoAceito(termoAceito);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('widgetTermoDetail').hide();");
            FacesMessageUtils.info("Termo de Responsabilidade aceito em: ".concat(Utils.convertDateToString(new Date(), "dd/MM/yyy HH:mm")));
        } else {
            FacesMessageUtils.error("Termo de Responsabilidade é obrigatório!");
        }
        
    }
    
    public Termo getTermoResponsabilidadeAtivo() {
        return termoResponsabilidadeAtivo;
    }
    
    public void setTermoResponsabilidadeAtivo(Termo termoResponsabilidadeAtivo) {
        this.termoResponsabilidadeAtivo = termoResponsabilidadeAtivo;
    }
    
    public boolean isRenderizarAceite() {
        return renderizarAceite;
    }
    
    public void setRenderizarAceite(boolean renderizarAceite) {
        this.renderizarAceite = renderizarAceite;
    }
}
