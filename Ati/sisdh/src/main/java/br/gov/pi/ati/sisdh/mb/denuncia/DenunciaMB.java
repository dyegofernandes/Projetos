package br.gov.pi.ati.sisdh.mb.denuncia;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.denuncia.DenunciaBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Unidade;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisdh.modelo.denuncia.Arquivo;
import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import br.gov.pi.ati.sisdh.util.SessaoUtils;
import com.xpert.faces.utils.FacesJasper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class DenunciaMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    private Usuario usuarioAtual;

    private List<Arquivo> arquivos;

    private List<Denuncia> denuncias;

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
        usuarioAtual = SessaoUtils.getUser();

        denuncias = new ArrayList<Denuncia>();

        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
        }else{
            Unidade unidadeOrigem = getDAO().getInitialized(usuarioAtual.getUnidade());
            getEntity().setUnidadeOrigem(unidadeOrigem);
        }
    }

    @Override
    public void save() {
        getEntity().setArquivos(arquivos);
        super.save(); //To change body of generated methods, choose Tools | Templates.
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
        Arquivo arquivo = new Arquivo();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public void removerArquivo(Arquivo arquivo) {
        arquivos.remove(arquivo);
    }

    public void gerarPdf(Denuncia denuncia) {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_POLICIA", caminhoImg.concat("/logoPolicia.png"));
        params.put("LOGO_ATI", caminhoImg.concat("/ati_novo.png"));
        params.put("LOGO_ESTADO", caminhoImg.concat("/brasao2.jpg"));
//        params.put("DATA_EMISSAO", Utils.convertDateToString(new Date(), "dd/MM/yyyy HH:mm"));
//        params.put("ANO_EMISSAO", Utils.convertDateToString(new Date(), "yyyy"));
        params.put("NOME_USUARIO", "Resp. pelo Registro: ".concat(usuarioAtual.getNome()));
        params.put("ID_USUARIO", usuarioAtual.getId().toString());

//        List<DenunciaVO> denuncias = new ArrayList<DenunciaVO>();
//
//        denuncias.add(new DenunciaVO(denuncia));
        FacesJasper.createJasperReport(denuncias, params,
                "/WEB-INF/report/formularioDenuncia.jasper", "Denuncia ".concat(denuncia.getId() + "") + ".pdf");

    }
}
