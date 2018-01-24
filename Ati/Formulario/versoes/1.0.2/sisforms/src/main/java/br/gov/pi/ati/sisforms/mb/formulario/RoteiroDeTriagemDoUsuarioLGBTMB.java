package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.RoteiroDeTriagemDoUsuarioLGBTBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoLGBT;
import br.gov.pi.ati.sisforms.modelo.formulario.AcolhimentoTriagemLgbt;
import br.gov.pi.ati.sisforms.modelo.formulario.AgendamentoTriagem;
import br.gov.pi.ati.sisforms.modelo.formulario.RoteiroDeTriagemDoUsuarioLGBT;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RoteiroDeTriagemDoUsuarioLGBTMB extends AbstractBaseBean<RoteiroDeTriagemDoUsuarioLGBT> implements Serializable {

    @EJB
    private RoteiroDeTriagemDoUsuarioLGBTBO roteiroDeTriagemDoUsuarioLGBTBO;

    private AcolhimentoTriagemLgbt acolhimento = new AcolhimentoTriagemLgbt();
    private AgendamentoTriagem agendamento = new AgendamentoTriagem();

    private List<AcolhimentoTriagemLgbt> acolhimentos;
    private List<AgendamentoTriagem> agendamentos;
    private List<ArquivoLGBT> arquivos;

    @Override
    public RoteiroDeTriagemDoUsuarioLGBTBO getBO() {
        return roteiroDeTriagemDoUsuarioLGBTBO;
    }

    @Override
    public String getDataModelOrder() {
        return "codigo, ano";
    }

    @Override
    public void init() {
        if (getEntity().getId() == null) {
            Integer codigoAtual = getBO().getUltimoCodigo(getEntity().getAno());
            if (codigoAtual != null) {
                codigoAtual++;
                getEntity().setCodigo(codigoAtual);
            }
            acolhimentos = new ArrayList<AcolhimentoTriagemLgbt>();
            agendamentos = new ArrayList<AgendamentoTriagem>();
            arquivos = new ArrayList<ArquivoLGBT>();
        } else {
            acolhimentos = getBO().getDAO().getInitialized(getEntity().getAcolhimentos());
            agendamentos = getBO().getDAO().getInitialized(getEntity().getAgendamentos());
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
        }
    }

    @Override
    public void save() {
        getEntity().setAcolhimentos(acolhimentos);
        getEntity().setAgendamentos(agendamentos);
        getEntity().setArquivos(arquivos);
        super.save();
    }

    @Override
    public void postSave() {
        acolhimentos = new ArrayList<AcolhimentoTriagemLgbt>();
        agendamentos = new ArrayList<AgendamentoTriagem>();
        arquivos = new ArrayList<ArquivoLGBT>();
        agendamento = new AgendamentoTriagem();
        acolhimento = new AcolhimentoTriagemLgbt();
        setEntity(new RoteiroDeTriagemDoUsuarioLGBT());
    }

    public void addAcolhimento() {
        acolhimentos.add(acolhimento);
        acolhimento = new AcolhimentoTriagemLgbt();

    }

    public void addAgendamento() {
        agendamentos.add(agendamento);
        agendamento = new AgendamentoTriagem();
    }

    public void removerAcolhimento(AcolhimentoTriagemLgbt acolhimento) {
        acolhimentos.remove(acolhimento);
    }

    public void removerAgendamento(AgendamentoTriagem agendamento) {
        agendamentos.remove(agendamento);
    }

    public AcolhimentoTriagemLgbt getAcolhimento() {
        return acolhimento;
    }

    public void setAcolhimento(AcolhimentoTriagemLgbt acolhimento) {
        this.acolhimento = acolhimento;
    }

    public AgendamentoTriagem getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(AgendamentoTriagem agendamento) {
        this.agendamento = agendamento;
    }

    public List<AcolhimentoTriagemLgbt> getAcolhimentos() {
        return acolhimentos;
    }

    public void setAcolhimentos(List<AcolhimentoTriagemLgbt> acolhimentos) {
        this.acolhimentos = acolhimentos;
    }

    public List<AgendamentoTriagem> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoTriagem> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<ArquivoLGBT> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoLGBT> arquivos) {
        this.arquivos = arquivos;
    }

    public StreamedContent download(ArquivoLGBT arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (ArquivoLGBT) proxy.getHibernateLazyInitializer().getImplementation();
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

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        ArquivoLGBT arquivo = new ArquivoLGBT();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public void removerArquivo(ArquivoLGBT arquivo) {
        arquivos.remove(arquivo);
    }

    public void gerarDadosExpedicaoCarteira(RoteiroDeTriagemDoUsuarioLGBT form) {
        HashMap params = new HashMap();
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/Logo_SASC.png");

        params.put("LOGO", imgLogoAti);
        params.put("NOME_SOCIAL", form.getNomeSocial());
        params.put("NOME_CIVIL", form.getNome());
        params.put("NATURALIDADE", form.getNaturalidade());
        params.put("RG", form.getRg());
        params.put("CPF", form.getCpf());
        params.put("REG_SOCIAL", (form.getRegistroSocialNum() != null ? form.getRegistroSocialNum() + "/" + form.getRegistroSocialAno()
                : ""));
        params.put("DATA_NASCIMENTO", form.getDataNascimento() != null ? "".concat(Utils.convertDateToString(form.getDataNascimento(), "dd/MM/yyyy"))
                : "");

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/expedicaoCarteiraIdendSocial.jasper", "Dados_Expedicao_Carteira" + ".pdf");

    }

}
