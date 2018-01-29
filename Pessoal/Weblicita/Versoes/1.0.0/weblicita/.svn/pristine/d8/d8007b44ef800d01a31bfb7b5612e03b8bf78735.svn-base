package br.com.weblicita.mb.licitacao;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.PesquisaDePrecoBO;
import br.com.weblicita.modelo.cadastro.Documento;
import br.com.weblicita.modelo.licitacao.Licitante;
import br.com.weblicita.modelo.licitacao.PesquisaDePreco;
import br.com.weblicita.modelo.licitacao.Proponente;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.context.RequestContext;
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
public class PesquisaDePrecoMB extends AbstractBaseBean<PesquisaDePreco> implements Serializable {

    private List<Proponente> proponentes;

    private List<Licitante> licitantes;

    private Proponente proponenteAdd;

    private Licitante licitanteAdd;

    @EJB
    private PesquisaDePrecoBO pesquisaDePrecoBO;

    @Override
    public PesquisaDePrecoBO getBO() {
        return pesquisaDePrecoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        carregarListas();
    }

    public void carregarListas() {
        proponentes = new ArrayList<Proponente>();
        licitantes = new ArrayList<Licitante>();
        proponenteAdd = new Proponente();
        licitanteAdd = new Licitante();

        if (getEntity().getId() != null) {
            proponentes = getDAO().getInitialized(getEntity().getProponentes());
            licitantes = getDAO().getInitialized(getEntity().getLicitantes());
        }
    }

    public void addProponente() {
        if (proponenteAdd.getFornecedor() != null) {
            if (proponenteAdd.getDocumentos().size() > 0) {
                if (proponenteJahAdicionado(proponenteAdd)) {
                    FacesMessageUtils.error("Fornecedor já foi adicionado na lista!");
                } else {
                    proponentes.add(proponenteAdd);
                    proponenteAdd = new Proponente();
                }

            } else {
                FacesMessageUtils.error("Um ou mais arquivos são obrigatórios!");
            }
        } else {
            FacesMessageUtils.error("Fornecedor é obrigatório!");
        }
    }

    public void removerProponente(Proponente proponente) {
        proponentes.remove(proponente);
    }

    private boolean proponenteJahAdicionado(Proponente proponente) {
        for (Proponente propo : proponentes) {
            if (propo.getFornecedor().equals(proponente.getFornecedor())) {
                return true;
            }
        }
        return false;
    }

    public void addLicitante() {
        if (licitanteAdd.getFornecedor() != null) {
            if (licitanteAdd.getDocumentos().size() > 0) {
                if (licitanteJahAdicionado(licitanteAdd)) {
                    FacesMessageUtils.error("Fornecedor já foi adicionado na lista!");
                } else {
                    licitantes.add(licitanteAdd);
                    licitanteAdd = new Licitante();
                }

            } else {
                FacesMessageUtils.error("Um ou mais arquivos são obrigatórios!");
            }
        } else {
            FacesMessageUtils.error("Fornecedor é obrigatório!");
        }
    }

    public StreamedContent download(Documento arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (Documento) proxy.getHibernateLazyInitializer().getImplementation();
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

    public void uploadArquivoProponente(FileUploadEvent event) throws FileNotFoundException, IOException {
        Documento arquivo = new Documento();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        proponenteAdd.getDocumentos().add(arquivo);
    }

    public void removerArquivoProponente(Documento arquivo) {
        proponenteAdd.getDocumentos().remove(arquivo);
    }

    public void uploadArquivoLicitante(FileUploadEvent event) throws FileNotFoundException, IOException {
        Documento arquivo = new Documento();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        licitanteAdd.getDocumentos().add(arquivo);
    }

    public void removerArquivoLicitante(Documento arquivo) {
        licitanteAdd.getDocumentos().remove(arquivo);
    }

    public void removerLicitante(Licitante licitante) {
        licitantes.remove(licitante);
    }

    private boolean licitanteJahAdicionado(Licitante licitante) {
        for (Licitante lici : licitantes) {
            if (lici.getFornecedor().equals(licitante.getFornecedor())) {
                return true;
            }
        }
        return false;
    }

    public void abrirTelaProponente() {

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetProponentes').show();");
    }

    public void abrirTelaLicitante() {

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetLicitantes').show();");
    }

    public List<Proponente> getProponentes() {
        return proponentes;
    }

    public void setProponentes(List<Proponente> proponentes) {
        this.proponentes = proponentes;
    }

    public List<Licitante> getLicitantes() {
        return licitantes;
    }

    public void setLicitantes(List<Licitante> licitantes) {
        this.licitantes = licitantes;
    }

    public PesquisaDePrecoBO getPesquisaDePrecoBO() {
        return pesquisaDePrecoBO;
    }

    public void setPesquisaDePrecoBO(PesquisaDePrecoBO pesquisaDePrecoBO) {
        this.pesquisaDePrecoBO = pesquisaDePrecoBO;
    }

    public Proponente getProponenteAdd() {
        return proponenteAdd;
    }

    public void setProponenteAdd(Proponente proponenteAdd) {
        this.proponenteAdd = proponenteAdd;
    }

    public Licitante getLicitanteAdd() {
        return licitanteAdd;
    }

    public void setLicitanteAdd(Licitante licitanteAdd) {
        this.licitanteAdd = licitanteAdd;
    }

}
