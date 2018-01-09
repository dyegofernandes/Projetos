package br.gov.pi.salvemaria.mb.denuncia;

import br.gov.pi.salvemaria.bo.denuncia.ArquivoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import com.xpert.persistence.exception.DeleteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.io.FilenameUtils.getExtension;
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
public class DenunciaMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private ArquivoBO arquivoBO;

    private List<Arquivo> arquivos;

    private List<Arquivo> arquivosDeletados;

    @Override
    public DenunciaBO getBO() {
        return denunciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        arquivos = new ArrayList<Arquivo>();
        arquivosDeletados = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            listaDeArquivos(getEntity());
        }
    }

    @Override
    public void save() {
        super.save(); 
        
        for (Arquivo arquivo : arquivos) {
            arquivoBO.getDAO().saveOrMerge(arquivo, true);
        }
        
        for (Arquivo arquivo : arquivosDeletados) {
            try {
                arquivoBO.getDAO().delete(arquivo, true);
            } catch (DeleteException ex) {
                Logger.getLogger(DenunciaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

    @Override
    public void delete() {
        Denuncia denuncia = denunciaBO.getDAO().unique("id", getId());
        arquivos = arquivoBO.listarArquivos(denuncia);
        for (Arquivo arquivo : arquivos) {
            try {
                arquivoBO.delete(arquivo.getId());
            } catch (DeleteException ex) {
                Logger.getLogger(DenunciaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        super.delete();
    }

    public StreamedContent download(Arquivo arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (Arquivo) proxy.getHibernateLazyInitializer().getImplementation();
        }

        String nomeArquivo = arquivo.getNome();
        String extensaoArquivo = arquivo.getExtensao();

        File file = File.createTempFile(nomeArquivo, extensaoArquivo);

        FileOutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(Base64.decodeBase64(arquivo.getConteudo()));
        outputStream.write(arquivo.getConteudo());
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        Arquivo arquivo = new Arquivo();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        arquivo.setConteudo(uploadedFile.getContents());
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void listaDeArquivos(Denuncia denuncia) {
        arquivos = arquivoBO.listarArquivos(denuncia);
    }
}
