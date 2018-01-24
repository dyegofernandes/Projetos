package br.gov.pi.ati.sisforms.mb.servicos;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.ReservaLocalBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import com.lowagie.text.pdf.codec.Base64;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class ReservaLocalMB extends AbstractBaseBean<ReservaLocal> implements Serializable {

    private List<Arquivo> arquivos;

    @EJB
    private ReservaLocalBO reservaLocalBO;

    private ReservaLocal reserva;

    @Override
    public ReservaLocalBO getBO() {
        return reservaLocalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        reserva = new ReservaLocal();
        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            arquivos = getDAO().getInitialized(getEntity().getArquivos());
        }
    }

    @Override
    public void save() {
        getEntity().setArquivos(arquivos);

        super.save();

    }

    @Override
    public void postSave() {
        super.postSave();
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

    public void removerArquivo(Arquivo arquivo) throws IOException {
        arquivos.remove(arquivo);
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {

        UploadedFile uploadedFile = event.getFile();
        String base64AsString = new String(Base64.encodeBytes(uploadedFile.getContents()));

        Arquivo arquivo = new Arquivo();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public void saveAll() throws BusinessException {
        try {
            getBO().saveAll(getBO().locaisPelaReserva(getEntity()));
            FacesMessageUtils.info("Reserva (s) Gerada (s) Com Sucesso!");
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }

    }

    public void chancerDataInicial() {
        if (getEntity().getDataInicio() != null) {
            getEntity().setDataFinal(getEntity().getDataInicio());
        } else {
            getEntity().setDataFinal(null);
        }
    }

    public ReservaLocal getReserva() {
        return reserva;
    }

    public void setReserva(ReservaLocal reserva) {
        this.reserva = reserva;
    }

}
