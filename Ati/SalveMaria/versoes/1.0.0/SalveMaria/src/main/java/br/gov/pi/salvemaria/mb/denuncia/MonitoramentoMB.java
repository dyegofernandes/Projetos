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
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MonitoramentoMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private ArquivoBO arquivoBO;

    private List<Arquivo> arquivos;

    private List<Arquivo> arquivosDeletados;

    private MapModel simpleModel;

    private List<Denuncia> denunciasPanico = new ArrayList<Denuncia>();
    private List<Denuncia> denunciasNormal = new ArrayList<Denuncia>();

    private Filtros filtro = new Filtros();

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
        simpleModel = new DefaultMapModel();
        adicionarMarcacao();
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

        adicionarMarcacao();
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public List<Denuncia> getDenunciasPanico() {
        return denunciasPanico;
    }

    public List<Denuncia> getDenunciasNormal() {
        return denunciasNormal;
    }

    public void adicionarMarcacao() {
        denunciasPanico = new ArrayList<Denuncia>();
        denunciasNormal = new ArrayList<Denuncia>();
        filtro.setSituacao(Situacao.NOVA);
        List<Denuncia> denuncias = denunciaBO.listar(filtro);
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getTipo() == TipoDenuncia.DENUNCIA) {
                denunciasNormal.add(denuncia);
            }

            if (denuncia.getTipo() == TipoDenuncia.PANICO) {
                denunciasPanico.add(denuncia);
            }

            if (denuncia.getEndereco().getLatitude() != null && denuncia.getEndereco().getLongitude() != null) {
                if (!denuncia.getEndereco().getLatitude().equals("") && !denuncia.getEndereco().getLongitude().equals("")) {
                    Marker marker = new Marker(new LatLng(Double.valueOf(denuncia.getEndereco().getLatitude()), Double.valueOf(denuncia.getEndereco().getLongitude())),
                            denuncia.getId() + "");
                    if (denuncia.getTipo() == TipoDenuncia.PANICO) {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/red-dot.png");
                    } else {
                        marker.setIcon("http://maps.google.com/mapfiles/ms/icons/yellow-dot.png");
                    }

                    simpleModel.addOverlay(marker);
                }

            }
        }
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

    public void listaDeArquivos(Denuncia denuncia) {
        arquivos = arquivoBO.listarArquivos(denuncia);
    }

    public void salvar() {

        denunciaBO.getDAO().saveOrMerge(getEntity(), true);

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

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

}
