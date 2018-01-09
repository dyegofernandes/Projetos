package com.opfacil.mb.documento;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.bo.cadastro.EmpresaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.documentos.DownloadArquivosBO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.documentos.Arquivo;
import com.opfacil.modelo.documentos.DownloadArquivos;
import com.opfacil.modelo.enums.TipoArquivo;
import com.opfacil.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class DownloadArquivosMB extends AbstractBaseBean<DownloadArquivos> implements Serializable {

    @EJB
    private DownloadArquivosBO downloadArquivosBO;

    @EJB
    private EmpresaBO empresaBO;

    private List<Empresa> empresas;

    private FiltroDeBusca campoDeBusca;

    private Arquivo arquivo;

    private List<DownloadArquivos> arquivos;

    @Override
    public void init() {
        campoDeBusca = new FiltroDeBusca();
        empresas = empresaBO.getListEmpresasAutorizadas(SessaoUtils.getUser());
        arquivos = downloadArquivosBO.listarArquivoPorEmpresa(campoDeBusca);
    }

    @Override
    public DownloadArquivosBO getBO() {
        return downloadArquivosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        arquivo = new Arquivo();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        arquivo.setConteudo(uploadedFile.getContents());
        getEntity().setArquivo(arquivo);

        FacesMessageUtils.info("Arquivo carregado com Sucesso!");
    }

    private String getExtension(String name) {
        return name.replaceAll(".+\\.(.+)", "$1");
    }

    public StreamedContent downloadArquivo(Arquivo arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (Arquivo) proxy.getHibernateLazyInitializer().getImplementation();
        }

        String nomeArquivo = arquivo.getNome();
        String extensaoArquivo = arquivo.getExtensao();

        File file = File.createTempFile(nomeArquivo, extensaoArquivo);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(arquivo.getConteudo());
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public List<DownloadArquivos> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<DownloadArquivos> arquivos) {
        this.arquivos = arquivos;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public FiltroDeBusca getCampoDeBusca() {
        return campoDeBusca;
    }

    public void setCampoDeBusca(FiltroDeBusca campoDeBusca) {
        this.campoDeBusca = campoDeBusca;
    }

    public void buscar() {
        arquivos = downloadArquivosBO.listarArquivoPorEmpresa(campoDeBusca);
    }

    @Override
    public void delete() {
        super.delete();
        arquivos = downloadArquivosBO.listarArquivoPorEmpresa(campoDeBusca);
    }

    public void cancelar(DownloadArquivos arquivo) {
        getEntity().setTipo(TipoArquivo.CANCELADA);
        downloadArquivosBO.getDAO().saveOrMerge(arquivo, true);
        arquivos = downloadArquivosBO.listarArquivoPorEmpresa(campoDeBusca);
    }

}
