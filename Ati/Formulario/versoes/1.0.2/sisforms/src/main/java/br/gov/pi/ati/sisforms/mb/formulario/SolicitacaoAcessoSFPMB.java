package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.OrgaoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.SolicitacaoAcessoSFPBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFP;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFPOcorrencia;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoSFP;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import br.gov.pi.ati.sisforms.webservices.inforfolha.server.ServerWebservices;
import br.gov.pi.ati.sisforms.webservices.inforfolha.server.ServerWebservicesPortType;
import br.gov.pi.ati.sisforms.webservices.inforfolha.ServidorVO;
import com.thoughtworks.xstream.XStream;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
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
public class SolicitacaoAcessoSFPMB extends AbstractBaseBean<SolicitacaoAcessoSFP> implements Serializable {

    @EJB
    private SolicitacaoAcessoSFPBO solicitacaoAcessoSFPBO;

    @EJB
    private OrgaoBO orgaoBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Orgao> orgaosAcesso;

    private Orgao orgaoAdd = new Orgao();

    private ModuloSFP cadastro = new ModuloSFP();
    private ModuloSFP financeiro = new ModuloSFP();
    private ModuloSFP dependente = new ModuloSFP();
    private ModuloSFP pensaoJudicial = new ModuloSFP();
    private ModuloSFPOcorrencia ocorrencia = new ModuloSFPOcorrencia();
    private ModuloSFP cadastroSEAD = new ModuloSFP();
    private ModuloSFP financeiroSEAD = new ModuloSFP();
    private ModuloSFP dependenteSEAD = new ModuloSFP();
    private ModuloSFP pensaoJudicialSEAD = new ModuloSFP();
    private ModuloSFPOcorrencia ocorrenciaSEAD = new ModuloSFPOcorrencia();

    @Override
    public void init() {
        carregarOrgaoAcesso();
        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
        } else {
            cadastro = getBO().getDAO().getInitialized(getEntity().getCadastro());
            financeiro = getBO().getDAO().getInitialized(getEntity().getFinanceiro());
            dependente = getBO().getDAO().getInitialized(getEntity().getDependente());
            pensaoJudicial = getBO().getDAO().getInitialized(getEntity().getPensaoJudicial());
            ocorrencia = getBO().getDAO().getInitialized(getEntity().getOcorrencia());
            cadastroSEAD = getBO().getDAO().getInitialized(getEntity().getCadastroSEAD());
            financeiroSEAD = getBO().getDAO().getInitialized(getEntity().getFinanceiroSEAD());
            dependenteSEAD = getBO().getDAO().getInitialized(getEntity().getDependenteSEAD());
            pensaoJudicialSEAD = getBO().getDAO().getInitialized(getEntity().getPensaoJudicialSEAD());
            ocorrenciaSEAD = getBO().getDAO().getInitialized(getEntity().getOcorrenciaSEAD());
        }

    }

    @Override
    public void postSave() {
        setEntity(new SolicitacaoAcessoSFP());
        getEntity().setUsuario(usuarioAtual);
        orgaosAcesso = new ArrayList<Orgao>();
        cadastro = new ModuloSFP();
        financeiro = new ModuloSFP();
        dependente = new ModuloSFP();
        pensaoJudicial = new ModuloSFP();
        ocorrencia = new ModuloSFPOcorrencia();
        cadastroSEAD = new ModuloSFP();
        financeiroSEAD = new ModuloSFP();
        dependenteSEAD = new ModuloSFP();
        pensaoJudicialSEAD = new ModuloSFP();
        ocorrenciaSEAD = new ModuloSFPOcorrencia();
    }

    @Override
    public void save() {
        getEntity().setOrgaosDeAcessos(orgaosAcesso);
        
        getEntity().setCadastro(cadastro);
        getEntity().setFinanceiro(financeiro);
        getEntity().setDependente(dependente);
        getEntity().setPensaoJudicial(pensaoJudicial);
        getEntity().setOcorrencia(ocorrencia);

        getEntity().setCadastroSEAD(cadastroSEAD);
        getEntity().setFinanceiroSEAD(financeiroSEAD);
        getEntity().setDependenteSEAD(dependenteSEAD);
        getEntity().setPensaoJudicialSEAD(pensaoJudicialSEAD);
        getEntity().setOcorrenciaSEAD(ocorrenciaSEAD);
        
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
        params.put("ORGAO", form.getOrgao() != null ? "ÓRGÃO: ".concat(solicitacaoAcessoSFPBO.getDAO().getInitialized(form.getOrgao()).getNome())
                : "ÓRGÃO:");
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataEmissao(), 12));

        params.put("CPF", form.getCpf() != null ? "CPF: ".concat(Utils.format("###.###.###-##", form.getCpf())) : "CPF:");
        params.put("MATRICULA", form.getMatricula() != null ? "MATRÍCULA: ".concat(form.getMatricula()) : "MATRÍCULA:");
        params.put("TELEFONE", form.getTelefone() != null ? "TELEFONE: ".concat(form.getTelefone()) : "TELEFONE:");
        params.put("CARGO_FUNCAO", form.getCargoFuncao() != null ? "CARGO/FUNÇÃO: ".concat(form.getCargoFuncao()) : "CARGO/FUNÇÃO:");
        params.put("EMAIL", form.getEmail() != null ? "E-MAIL: ".concat(form.getEmail()) : "E-MAIL:");
        params.put("NOME", form.getNome() != null ? "NOME: ".concat(form.getNome()) : "NOME:");
        params.put("ORGAO_ACESSO", "Órgão(s) que o usuário terá acesso: ");
        params.put("OBS", form.getObservacao() != null ? "Observação: ".concat(form.getObservacao()) : "Observação:");
        params.put("OP_C_INCLUSAO", form.getCadastro().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("OP_C_ALTERACAO", form.getCadastro().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("OP_C_CONSULTA", form.getCadastro().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("OP_F_INCLUSAO", form.getFinanceiro().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("OP_F_ALTERACAO", form.getFinanceiro().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("OP_F_CONSULTA", form.getFinanceiro().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("OP_D_INCLUSAO", form.getDependente().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("OP_D_ALTERACAO", form.getDependente().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("OP_D_CONSULTA", form.getDependente().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("OP_P_INCLUSAO", form.getPensaoJudicial().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("OP_P_ALTERCAO", form.getPensaoJudicial().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("OP_P_CONSULTA", form.getPensaoJudicial().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("OP_O_AFASTA", form.getOcorrencia().isAfastamentoLicenca() ? "(X) Afastamento/Licenças" : "( ) Afastamento/Licenças");
        params.put("OP_O_EXO", form.getOcorrencia().isExoneracao() ? "(X) Exonerações" : "( ) Exonerações");
        params.put("OP_O_APO", form.getOcorrencia().isAposentadoria() ? "(X) Aposentadorias" : "( ) Aposentadorias");
        params.put("OP_O_DISP", form.getOcorrencia().isDisposicao() ? "(X) Disposições" : "( ) Disposições");
        params.put("OP_O_ENQ", form.getOcorrencia().isEnquadramento() ? "(X) Enquadramento/Promoções" : "(X) Enquadramento/Promoções");
        params.put("AR_C_INCLUSAO", form.getCadastroSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("AR_C_ALTERACAO", form.getCadastroSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("AR_C_CONSULTA", form.getCadastroSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("AR_F_INCLUSAO", form.getFinanceiroSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("AR_F_ALTERACAO", form.getFinanceiroSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("AR_F_CONSULTA", form.getFinanceiroSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("AR_D_INCLUSAO", form.getDependenteSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("AR_D_ALTERACAO", form.getDependenteSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("AR_D_CONSULTA", form.getDependenteSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("AR_P_INCLUSAO", form.getPensaoJudicialSEAD().isInclusao() ? "(X) Inclusão" : "( ) Inclusão");
        params.put("AR_P_ALTERCAO", form.getPensaoJudicialSEAD().isAlteracao() ? "(X) Alteração" : "( ) Alteração");
        params.put("AR_P_CONSULTA", form.getPensaoJudicialSEAD().isConsulta() ? "(X) Consulta" : "( ) Consulta");
        params.put("AR_O_AFASTA", form.getOcorrenciaSEAD().isAfastamentoLicenca() ? "(X) Afastamento/Licenças" : "( ) Afastamento/Licenças");
        params.put("AR_O_EXO", form.getOcorrenciaSEAD().isExoneracao() ? "(X) Exonerações" : "( ) Exonerações");
        params.put("AR_O_APO", form.getOcorrenciaSEAD().isAposentadoria() ? "(X) Aposentadorias" : "( ) Aposentadorias");
        params.put("AR_O_DISP", form.getOcorrenciaSEAD().isDisposicao() ? "(X) Disposições" : "( ) Disposições");
        params.put("AR_O_ENQ", form.getOcorrenciaSEAD().isEnquadramento() ? "(X) Enquadramento/Promoções" : "(X) Enquadramento/Promoções");
        params.put("TEXTO_UM", Utils.getTextoUmSFP());
        params.put("TEXTO_DOIS", Utils.getTextoDoisSFP());

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/solicitacaoAcessoSFP.jasper", "Solicitacao de acesso SFP" + ".pdf");

    }

    public void carregarOrgaoAcesso() {
        if (getEntity().getId() != null) {
            orgaosAcesso = getBO().getDAO().getInitialized(getEntity().getOrgaosDeAcessos());
        } else {
            orgaosAcesso = new ArrayList<Orgao>();
        }
    }

    public void addOrgao() {
        if (orgaoAdd != null) {
            orgaosAcesso.add(orgaoAdd);
            orgaoAdd = new Orgao();
        } else {
            FacesMessageUtils.error("Órgão é obrigatório!!");
        }
    }

    public void removerOrgao(Orgao orgao) {
        orgaosAcesso.remove(orgao);
    }

    public List<Orgao> getOrgaosAcesso() {
        return orgaosAcesso;
    }

    public void setOrgaosAcesso(List<Orgao> orgaosAcesso) {
        this.orgaosAcesso = orgaosAcesso;
    }

    public Orgao getOrgaoAdd() {
        return orgaoAdd;
    }

    public void setOrgaoAdd(Orgao orgaoAdd) {
        this.orgaoAdd = orgaoAdd;
    }

    public void carregarDadosServidor() {
        if (getEntity().getCpf() != null) {
            if (!getEntity().getCpf().equals("")) {
                if (getEntity().getTipo() == TrabalhadorTipo.SERVIDOR) {

                    ServidorVO servidorVO = new ServidorVO();

                    XStream xstream = new XStream();
                    XStream xstreamJason = new XStream();

                    ServerWebservices servicorService = new ServerWebservices();
                    ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

                    String xmlString = servidor.servidorativoxml((getEntity().getCpf().replace(".", "")
                            .replace("-", "")));

                    System.out.println(xmlString);

                    xstreamJason.alias("servidor", ServidorVO.class);
                    servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);

                    getEntity().setCargoFuncao(!servidorVO.getFuncao().equals("") ? servidorVO.getFuncao() : servidorVO.getCargo());
                    getEntity().setEmail(servidorVO.getEmail());
                    getEntity().setMatricula(servidorVO.getMatricula());
                    getEntity().setNome(servidorVO.getNome());
                    getEntity().setTelefone(servidorVO.getTelefone());
                    Orgao orgao = orgaoBO.getDAO().unique("codigo", servidorVO.getOrgao());
                    getEntity().setOrgao(orgao);

                } else {

                }
            }
        }
    }

    public void limparCampos() {
        getEntity().setCargoFuncao(null);
        getEntity().setEmail(null);
        getEntity().setMatricula(null);
        getEntity().setNome(null);
        getEntity().setTelefone(null);
        getEntity().setOrgao(null);
        getEntity().setCpf(null);
    }

    public ModuloSFP getCadastro() {
        return cadastro;
    }

    public void setCadastro(ModuloSFP cadastro) {
        this.cadastro = cadastro;
    }

    public ModuloSFP getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(ModuloSFP financeiro) {
        this.financeiro = financeiro;
    }

    public ModuloSFP getDependente() {
        return dependente;
    }

    public void setDependente(ModuloSFP dependente) {
        this.dependente = dependente;
    }

    public ModuloSFP getPensaoJudicial() {
        return pensaoJudicial;
    }

    public void setPensaoJudicial(ModuloSFP pensaoJudicial) {
        this.pensaoJudicial = pensaoJudicial;
    }

    public ModuloSFPOcorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(ModuloSFPOcorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public ModuloSFP getCadastroSEAD() {
        return cadastroSEAD;
    }

    public void setCadastroSEAD(ModuloSFP cadastroSEAD) {
        this.cadastroSEAD = cadastroSEAD;
    }

    public ModuloSFP getFinanceiroSEAD() {
        return financeiroSEAD;
    }

    public void setFinanceiroSEAD(ModuloSFP financeiroSEAD) {
        this.financeiroSEAD = financeiroSEAD;
    }

    public ModuloSFP getDependenteSEAD() {
        return dependenteSEAD;
    }

    public void setDependenteSEAD(ModuloSFP dependenteSEAD) {
        this.dependenteSEAD = dependenteSEAD;
    }

    public ModuloSFP getPensaoJudicialSEAD() {
        return pensaoJudicialSEAD;
    }

    public void setPensaoJudicialSEAD(ModuloSFP pensaoJudicialSEAD) {
        this.pensaoJudicialSEAD = pensaoJudicialSEAD;
    }

    public ModuloSFPOcorrencia getOcorrenciaSEAD() {
        return ocorrenciaSEAD;
    }

    public void setOcorrenciaSEAD(ModuloSFPOcorrencia ocorrenciaSEAD) {
        this.ocorrenciaSEAD = ocorrenciaSEAD;
    }

}
