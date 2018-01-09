package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.OrgaoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.SolicitacaoAcessoInfoFolhaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloInfoFolha;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoInfoFolha;
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
public class SolicitacaoAcessoInfoFolhaMB extends AbstractBaseBean<SolicitacaoAcessoInfoFolha> implements Serializable {

    @EJB
    private SolicitacaoAcessoInfoFolhaBO solicitacaoAcessoInfoFolhaBO;

    @EJB
    private OrgaoBO orgaoBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Orgao> orgaosAcesso;

    private ModuloInfoFolha modulo = new ModuloInfoFolha();

    private ModuloInfoFolha moduloSEAD = new ModuloInfoFolha();

    private Orgao orgaoAdd = null;

    @Override
    public void init() {
        carregarOrgaoAcesso();

        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);

        } else {
            modulo = getBO().getDAO().getInitialized(getEntity().getModulo());
            moduloSEAD = getBO().getDAO().getInitialized(getEntity().getModuloSead());
        }
    }

    @Override
    public void postSave() {
        setEntity(new SolicitacaoAcessoInfoFolha());
        getEntity().setUsuario(usuarioAtual);
        orgaosAcesso = new ArrayList<Orgao>();
        modulo = new ModuloInfoFolha();
        moduloSEAD = new ModuloInfoFolha();
    }

    @Override
    public void save() {
        getEntity().setOrgaosDeAcessos(orgaosAcesso);
        getEntity().setModulo(modulo);
        getEntity().setModuloSead(moduloSEAD);
        super.save();
    }

    @Override
    public SolicitacaoAcessoInfoFolhaBO getBO() {
        return solicitacaoAcessoInfoFolhaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarPdf(SolicitacaoAcessoInfoFolha form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/brasao2.jpg");

        params.put("LOGO_PI", imgLogoPI);
        params.put("ORGAO", form.getOrgao() != null ? "ÓRGÃO: ".concat(solicitacaoAcessoInfoFolhaBO.getDAO().getInitialized(form.getOrgao()).getNome())
                : "ÓRGÃO: ");
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataEmissao(), 12));

        params.put("CPF", form.getCpf() != null ? "CPF: ".concat(Utils.format("###.###.###-##", form.getCpf())) : "CPF:");
        params.put("MATRICULA", form.getMatricula() != null ? "MATRÍCULA: ".concat(form.getMatricula()) : "MATRÍCULA: ");
        params.put("TELEFONE", form.getTelefone() != null ? "TELEFONE: ".concat(form.getTelefone()) : "TELEFONE:");
        params.put("CARGO_FUNCAO", form.getCargoFuncao() != null ? "CARGO/FUNÇÃO: ".concat(form.getCargoFuncao()) : "CARGO/FUNÇÃO:");
        params.put("EMAIL", form.getEmail() != null ? "E-MAIL: ".concat(form.getEmail()) : "E-MAIL:");
        params.put("NOME", form.getNome() != null ? "NOME: ".concat(form.getNome()) : "NOME:");
        params.put("M_CONTRACHEQUE", form.getModulo().isContracheque() ? "(X) Contracheque" : "( ) Contracheque");
        params.put("M_FICHA", form.getModulo().isFichaFinanceira() ? "(X) Ficha Financeira do Servidor" : "( ) Ficha Financeira do Servidor");
        params.put("M_GFIP", form.getModulo().isGfip() ? "(X) GFIP" : "( ) GFIP");
        params.put("M_RELATORIO", form.getModulo().isRelatorio() ? "(X) Relatórios" : "( ) Relatórios");
        params.put("A_CONTRACHEQUE", form.getModuloSead().isContracheque() ? "(X) Contracheque" : "( ) Contracheque");
        params.put("A_FICHA", form.getModuloSead().isFichaFinanceira() ? "(X) Ficha Financeira do Servidor" : "( ) Ficha Financeira do Servidor");
        params.put("A_GFIP", form.getModuloSead().isGfip() ? "(X) GFIP" : "( ) GFIP");
        params.put("A_RELATORIO", form.getModuloSead().isRelatorio() ? "(X) Relatórios" : "( ) Relatórios");
        params.put("ORGAO_ACESSO", "Órgão(s) que o usuário terá acesso: ");
        params.put("OBS", form.getObservacao() != null ? "Observação: ".concat(form.getObservacao()) : "Observação:");
        params.put("TEXTO_UM", Utils.getTextoUmINFOFOLHA());
        params.put("TEXTO_DOIS", Utils.getTextoDoisINFOFOLHA());

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/solicitacaoAcessoInfoFolha.jasper", "Solicitacao de acesso Infofolha" + ".pdf");
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

            orgaoAdd = null;
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

                    XStream xstreamJason = new XStream();

                    ServerWebservices servicorService = new ServerWebservices();
                    ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

                    String xmlString = servidor.servidorativoxml((getEntity().getCpf().replace(".", "")
                            .replace("-", "")));

                    xstreamJason.alias("servidor", ServidorVO.class);
                    String xml = ("<?xml version=\"".concat("1.0\"").concat(" encoding=\"").concat("ISO-8859-1\"").concat("?>").concat("\n"));
                    if (!xml.equals(xmlString)) {
                        servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);

                        getEntity().setCargoFuncao(!servidorVO.getFuncao().equals("") ? servidorVO.getFuncao() : servidorVO.getCargo());
                        getEntity().setEmail(servidorVO.getEmail());
                        getEntity().setMatricula(servidorVO.getMatricula());
                        getEntity().setNome(servidorVO.getNome());
                        getEntity().setTelefone(servidorVO.getTelefone());
                        Orgao orgao = orgaoBO.getDAO().unique("codigo", servidorVO.getOrgao());
                        getEntity().setOrgao(orgao);
                    } else {
                        FacesMessageUtils.error("Servidor não encontrado!");
                    }

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

    public ModuloInfoFolha getModulo() {
        return modulo;
    }

    public void setModulo(ModuloInfoFolha modulo) {
        this.modulo = modulo;
    }

    public ModuloInfoFolha getModuloSEAD() {
        return moduloSEAD;
    }

    public void setModuloSEAD(ModuloInfoFolha moduloSEAD) {
        this.moduloSEAD = moduloSEAD;
    }

}
