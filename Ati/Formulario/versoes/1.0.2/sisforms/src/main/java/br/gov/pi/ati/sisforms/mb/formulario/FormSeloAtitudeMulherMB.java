package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.ArquivoPublicoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.FormSeloAtitudeMulherBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoPublico;
import br.gov.pi.ati.sisforms.modelo.enums.NaturezaEmpresa;
import br.gov.pi.ati.sisforms.modelo.enums.TipoFormulario;
import br.gov.pi.ati.sisforms.modelo.formulario.FormSeloAtitudeMulher;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormSeloAtitudeMulherMB extends AbstractBaseBean<FormSeloAtitudeMulher> implements Serializable {

    @EJB
    private FormSeloAtitudeMulherBO formSeloAtitudeMulherBO;

    @EJB
    private ArquivoPublicoBO arquivoBO;

    private List<ArquivoPublico> listaArquivos = new ArrayList<ArquivoPublico>();

    @Override
    public FormSeloAtitudeMulherBO getBO() {
        return formSeloAtitudeMulherBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        listarArquivos();
    }

    public void gerarPdf(FormSeloAtitudeMulher form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/politicaMulheres.png");
//        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati_novo.png");

        params.put("LOGO_PI", imgLogoPI);
//        params.put("LOGO_ATI", imgLogoAti);
        params.put("LOGO_PI", imgLogoPI);
        params.put("RAZAO_SOCIAL", "Razão Social: ".concat(form.getRazaoSocial() != null ? form.getRazaoSocial() : ""));
        params.put("CNPJ", "CNPJ: ".concat(form.getCnpj() != null ? form.getCnpj() : ""));
        params.put("EMAIL", "Email: ".concat(form.getEmail() != null ? form.getEmail() : ""));
        params.put("TELEFONE", "Telefone: ".concat(form.getTelefone() != null ? form.getTelefone() : ""));
        params.put("RESPONSAVEL", "Responsável: ".concat(form.getResponsavel() != null ? form.getResponsavel() : ""));
        params.put("CPF", "CPF: ".concat(form.getCpf() != null ? form.getCpf() : ""));
        params.put("FUNCAO", "Função: ".concat(form.getFuncao() != null ? form.getFuncao() : ""));
        params.put("EMAIL_RESP", "Email: ".concat(form.getEmailResponsavel() != null ? form.getEmailResponsavel() : ""));
        params.put("TELEFONE_RESP", "Telefone: ".concat(form.getTelefoneResponsavel() != null ? form.getTelefoneResponsavel() : ""));
        params.put("NATUREZA", form.getNatureza() == NaturezaEmpresa.PRIVADA ? "( ) Pública  (X) Privada" : "(X) Pública  ( ) Privada");
        params.put("MUNICIPIO", "Município/UF: ".concat(form.getMunicipio() != null ? form.getMunicipio() : ""));
        params.put("ENDERECO", "Endereço: ".concat(form.getEndereco() != null ? form.getEndereco() : ""));
        params.put("PAGINA_WEB", "Página na web: ".concat(form.getPaginaWeb() != null ? form.getPaginaWeb() : ""));
        params.put("NOME_REPRE", "Nome: ".concat(form.getNomeRepresentante() != null ? form.getNomeRepresentante() : ""));
        params.put("CARGO_REPRE", "Cargo: ".concat(form.getCargoRepresentante() != null ? form.getCargoRepresentante() : ""));
        params.put("FONE_REPRE", "Fone: ".concat(form.getTelefoneRepresentante() != null ? form.getTelefoneRepresentante() : ""));
        params.put("EMAIL_REPRE", "E-mail: ".concat(form.getEmailRepresentante() != null ? form.getEmailRepresentante() : ""));
        params.put("JUSTIFICATIVA", form.getJustificativa() != null ? form.getJustificativa() : "");
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataEmissao(), 1));
        params.put("ANO", Utils.convertDateToString(new Date(), 11));

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/formularioSeloAtitudeMulher.jasper", "Formulario Selo Atitude Mulher" + ".pdf");

    }

    public void voltar() {
        FacesUtils.redirect("/index.jsf");
    }

    public StreamedContent download(ArquivoPublico arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (ArquivoPublico) proxy.getHibernateLazyInitializer().getImplementation();
        }

        String nomeArquivo = arquivo.getNome();
        String extensaoArquivo = arquivo.getExtensao();

        File file = File.createTempFile(nomeArquivo, extensaoArquivo);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(Base64.decode(arquivo.getConteudo()));
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public List<ArquivoPublico> getListaArquivos() {
        return listaArquivos;
    }

    public void listarArquivos() {
        listaArquivos = arquivoBO.getDAO().list("tipo", TipoFormulario.SELO_MULHER);
    }
}
