package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.ArquivoRelatorioDeVisitaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.RelatorioDeVisitaBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeVisita;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeVisita;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.exception.DeleteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RelatorioDeVisitaMB extends AbstractBaseBean<RelatorioDeVisita> implements Serializable {

    @EJB
    private RelatorioDeVisitaBO relatorioDeVisitaBO;

    @EJB
    private ArquivoRelatorioDeVisitaBO arquivoBO;

    private List<RelatorioDeVisita> lista = new ArrayList<RelatorioDeVisita>();
    private List<ArquivoRelatorioDeVisita> arquivos;
    private List<ArquivoRelatorioDeVisita> arquivosDeletados;

    private Utils util = new Utils();
    private FiltrosVO filtros = new FiltrosVO();

    private Usuario usuarioAtual = SessaoUtils.getUser();

    @Override
    public void init() {
        if (!usuarioAtual.isSuperUsuario()) {
            filtros.setUsuario(usuarioAtual);
        }

        buscar();
        arquivos = new ArrayList<ArquivoRelatorioDeVisita>();
        arquivosDeletados = new ArrayList<ArquivoRelatorioDeVisita>();
        if (getEntity().getId() == null) {
            Integer numero = ultimoRelatorioVisitaNoAno();
            if (numero != null) {
                getEntity().setNumero(numero + 1);
            }

            getEntity().setUsuario(usuarioAtual);
        } else {
            listaDeArquivos(getEntity());
        }
    }

    @Override
    public void save() {
        super.save();
        for (ArquivoRelatorioDeVisita arquivo : arquivos) {
            arquivoBO.getDAO().saveOrMerge(arquivo, true);
        }

        for (ArquivoRelatorioDeVisita arquivo : arquivosDeletados) {
            try {
                arquivoBO.getDAO().remove(arquivo, true);
            } catch (DeleteException ex) {
                Logger.getLogger(RelatorioDeVisitaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public RelatorioDeVisitaBO getBO() {
        return relatorioDeVisitaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    private Integer ultimoRelatorioVisitaNoAno() {
        Integer maximo = (Integer) relatorioDeVisitaBO.getDAO().getQueryBuilder().from(RelatorioDeVisita.class)
                .add("ano", new Integer(Utils.convertDateToString(new Date(), "yyyy"))).max("numero");

        return maximo != null ? maximo : null;
    }

    public void gerarPdf(RelatorioDeVisita form) {
        HashMap params = new HashMap();
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/atiFundoBranco.png");

        params.put("LOGO_ATI", imgLogoAti);
        params.put("ORGAO", form.getOrgao() != null ? "Órgão Solicitante: ".concat(relatorioDeVisitaBO.getDAO().getInitialized(form.getOrgao()).getNome())
                : "Órgão Solicitante: ");
        params.put("DATA_EMISSAO", form.getDataEmissao() != null ? "".concat(Utils.convertDateToString(form.getDataEmissao(), "dd/MM/yyyy HH:mm"))
                : "");
        params.put("ANO", form.getAno() != null ? form.getAno().toString() : "");
        params.put("NUMERO", form.getNumero() != null ? form.getNumero().toString() : "");
        params.put("SOLICITADO_PO", form.getSolicitadoPor() != null ? "Solicitado por: ".concat(form.getSolicitadoPor()) : "Solicitado por: ");
        params.put("CONTATO", form.getContato() != null ? "Contato: ".concat(form.getContato()) : "Contato: ");
        params.put("TELEFONE", form.getTelefone() != null ? "Telefone: ".concat(form.getTelefone()) : "Telefone: ");
        params.put("EMAIL", form.getEmail() != null ? "Email: ".concat(form.getEmail()) : "Email: ");
        params.put("DATA_INICIO", form.getDataInicioVisita() != null ? Utils.convertDateToString(form.getDataInicioVisita(), "dd/MM/yyyy") : "");
        params.put("DATA_CONCLUSAO", form.getDataConclusaoVisita() != null ? Utils.convertDateToString(form.getDataConclusaoVisita(), "dd/MM/yyyy") : "");
        params.put("HORA_INICIO", form.getHoraInicioVisita() != null ? Utils.convertDateToString(form.getHoraInicioVisita(), "HH:mm") : "");
        params.put("HORA_CONCLUSAO", form.getHoraConclusaoVisita() != null ? Utils.convertDateToString(form.getHoraConclusaoVisita(), "HH:mm") : "");
        params.put("RESUMO", form.getResumo() != null ? form.getResumo() : "");
        params.put("SOLICITACAO", form.getSolicitacao() != null ? "Solicitação: ".concat(form.getSolicitacao()) : "Solicitação:");
        params.put("CONSTATACAO", form.getConstatacaoTecnica() != null ? "Constatação: ".concat(form.getConstatacaoTecnica()) : "Constatação: ");
        params.put("OBSERVACAO", form.getObservacaoCliente() != null ? "Observação (Cliente): ".concat(form.getConstatacaoTecnica()) : "Observação (Cliente): ");

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/relatorioDeVisita.jasper", "Relatorio de visita" + ".pdf");

    }

    public void listaDeArquivos(RelatorioDeVisita relatorio) {
        arquivos = arquivoBO.getDAO().list("relatorioDeVisita", relatorio);
    }

    public StreamedContent download(ArquivoRelatorioDeVisita arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (ArquivoRelatorioDeVisita) proxy.getHibernateLazyInitializer().getImplementation();
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
        ArquivoRelatorioDeVisita arquivo = new ArquivoRelatorioDeVisita();
        arquivo.setRelatorioDeVisita(getEntity());
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public List<RelatorioDeVisita> getLista() {
        return lista;
    }

    public void setLista(List<RelatorioDeVisita> lista) {
        this.lista = lista;
    }

    public Utils getUtil() {
        return util;
    }

    public void setUtil(Utils util) {
        this.util = util;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public List<ArquivoRelatorioDeVisita> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoRelatorioDeVisita> arquivos) {
        this.arquivos = arquivos;
    }

    public void removerArquivo(ArquivoRelatorioDeVisita arquivo) {
        if (arquivo.getId() != null) {
            arquivosDeletados.add(arquivo);
        }

        arquivos.remove(arquivo);
    }

    public void buscar() {
        lista = getBO().listar(filtros);
    }
}
