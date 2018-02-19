package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.OrgaoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.SolicitacaoAcessoInfoFolhaBO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoInfoFolha;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import br.gov.pi.ati.sisforms.webservices.inforfolha.ServidorVO;
import com.xpert.faces.utils.FacesJasper;
import java.util.HashMap;
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

    private Usuario usuarioAtual = SessaoUtils.getUser();

    @Override
    public void init() {
        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);

            ServidorVO servidor = Utils.consultarServidorPeloCPF(usuarioAtual.getCpf());

            if (servidor != null) {
                getEntity().setTipo(TrabalhadorTipo.SERVIDOR);
                getEntity().setTelefone(servidor.getTelefone());
                getEntity().setCargoFuncao(servidor.getCargo());
                getEntity().setMatricula(servidor.getMatricula());
            } else {
                getEntity().setTipo(TrabalhadorTipo.TERCEIRIZADO);
            }

        }
    }

    @Override
    public void postSave() {
        setEntity(new SolicitacaoAcessoInfoFolha());
    }

    @Override
    public void save() {
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
//        params.put("ORGAO", form.getOrgao() != null ? "ÓRGÃO: ".concat(solicitacaoAcessoInfoFolhaBO.getDAO().getInitialized(form.getOrgao()).getNome())
//                : "ÓRGÃO: ");
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataEmissao(), "dd/MM/yyyy HH:mm"));

        params.put("CPF", getEntity().getUsuario().getCpf() != null ? "CPF: ".concat(Utils.format("###.###.###-##", getEntity().getUsuario().getCpf())) : "CPF:");
        params.put("MATRICULA", form.getMatricula() != null ? "MATRÍCULA: ".concat(form.getMatricula()) : "MATRÍCULA: ");
        params.put("TELEFONE", form.getTelefone() != null ? "TELEFONE: ".concat(form.getTelefone()) : "TELEFONE:");
        params.put("CARGO_FUNCAO", form.getCargoFuncao() != null ? "CARGO/FUNÇÃO: ".concat(form.getCargoFuncao()) : "CARGO/FUNÇÃO:");
        params.put("EMAIL", "E-MAIL: ".concat(getEntity().getUsuario().getEmail()));
        params.put("NOME", "NOME: ".concat(getEntity().getUsuario().getNome()));
//        params.put("M_CONTRACHEQUE", form.getModulo().isContracheque() ? "(X) Contracheque" : "( ) Contracheque");
//        params.put("M_FICHA", form.getModulo().isFichaFinanceira() ? "(X) Ficha Financeira do Servidor" : "( ) Ficha Financeira do Servidor");
//        params.put("M_GFIP", form.getModulo().isGfip() ? "(X) GFIP" : "( ) GFIP");
//        params.put("M_RELATORIO", form.getModulo().isRelatorio() ? "(X) Relatórios" : "( ) Relatórios");
//        params.put("A_CONTRACHEQUE", form.getModuloSead().isContracheque() ? "(X) Contracheque" : "( ) Contracheque");
//        params.put("A_FICHA", form.getModuloSead().isFichaFinanceira() ? "(X) Ficha Financeira do Servidor" : "( ) Ficha Financeira do Servidor");
//        params.put("A_GFIP", form.getModuloSead().isGfip() ? "(X) GFIP" : "( ) GFIP");
//        params.put("A_RELATORIO", form.getModuloSead().isRelatorio() ? "(X) Relatórios" : "( ) Relatórios");
        params.put("ORGAO_ACESSO", "Órgão(s) que o usuário terá acesso: ");
        params.put("OBS", form.getObservacao() != null ? "Observação: ".concat(form.getObservacao()) : "Observação:");
        params.put("TEXTO_UM", Utils.getTextoUmINFOFOLHA());
        params.put("TEXTO_DOIS", Utils.getTextoDoisINFOFOLHA());

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/solicitacaoAcessoInfoFolha.jasper", "Solicitacao de acesso Infofolha" + ".pdf");
    }

}
