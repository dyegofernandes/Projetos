package br.gov.pi.ati.cfcpm.mb.mb;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.cfcpm.bo.cadastro.ArquivoBO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.Arquivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class ArquivoMB extends AbstractBaseBean<Arquivo> implements Serializable {

    @EJB
    private ArquivoBO arquivoBO;

    @Override
    public ArquivoBO getBO() {
        return arquivoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
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
        outputStream.write(Base64.decode(arquivo.getConteudo()));
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        UploadedFile uploadedFile = event.getFile();
        getEntity().setNome(uploadedFile.getFileName());
        getEntity().setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        getEntity().setConteudo(base64AsString);

        super.save();
    }
}
