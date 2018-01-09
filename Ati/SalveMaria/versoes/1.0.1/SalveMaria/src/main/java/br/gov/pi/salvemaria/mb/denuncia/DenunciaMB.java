package br.gov.pi.salvemaria.mb.denuncia;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import br.gov.pi.salvemaria.bo.cadastro.CircunscricaoBO;
import br.gov.pi.salvemaria.bo.cadastro.Circunscricao_BairroBO;
import br.gov.pi.salvemaria.bo.denuncia.ArquivoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.vos.DenunciaVO;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import br.gov.pi.salvemaria.util.SessaoUtils;
import br.gov.pi.salvemaria.util.Utils;
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
public class DenunciaMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private ArquivoBO arquivoBO;

    private Filtros filtro;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Arquivo> arquivos;

    private List<Arquivo> arquivosDeletados;

    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private BairroBO bairroBO;

    @EJB
    private CircunscricaoBO circusBO;

    @EJB
    private Circunscricao_BairroBO circusBairroBO;

    private Endereco endereco;

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
        filtro = new Filtros();

        filtro.setUsuario(usuarioAtual);

        arquivos = new ArrayList<Arquivo>();
        arquivosDeletados = new ArrayList<Arquivo>();
        endereco = new Endereco();

        if (getEntity().getId() != null) {
            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
            listaDeArquivos(getEntity());
        }
    }

    @Override
    public void save() {

        getEntity().setEndereco(endereco);

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
        outputStream.write(Base64.decode(arquivo.getConteudo()));
        outputStream.flush();
        outputStream.close();

        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }

    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        Arquivo arquivo = new Arquivo();
        arquivo.setDenuncia(getEntity());
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public void gerarPdf(Denuncia denuncia) {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_POLICIA", caminhoImg.concat("/logoPolicia.png"));
        params.put("LOGO_ATI", caminhoImg.concat("/ati_novo.png"));
        params.put("LOGO_ESTADO", caminhoImg.concat("/piaui_terra_querida.jpg"));
        params.put("DATA_EMISSAO", Utils.convertDateToString(new Date(), "dd/MM/yyyy HH:mm"));
        params.put("ANO_EMISSAO", Utils.convertDateToString(new Date(), "yyyy"));
        params.put("NOME_USUARIO", "Resp. pelo Registro: ".concat(usuarioAtual.getNome()));
        params.put("ID_USUARIO", usuarioAtual.getId().toString());

        List<DenunciaVO> denuncias = new ArrayList<DenunciaVO>();

        denuncias.add(new DenunciaVO(denuncia));

        FacesJasper.createJasperReport(denuncias, params,
                "/WEB-INF/report/formularioDenuncia.jasper", "Denuncia ".concat(denuncia.getId() + "") + ".pdf");

    }

    public void removerArquivo(Arquivo arquivo) {
        if (arquivo.getId() != null) {
            arquivosDeletados.remove(arquivo);
        }

        arquivos.remove(arquivo);
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void listaDeArquivos(Denuncia denuncia) {
        arquivos = arquivoBO.listarArquivos(denuncia);
    }

    public List<Denuncia> getDenuncias() {
        List<Denuncia> denuncias = null;

        denuncias = denunciaBO.listar(filtro);

        return denuncias;
    }

    public Filtros getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtros filtro) {
        this.filtro = filtro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Bairro> getBairros() {
        if (filtro.getCidade() != null) {
            return bairroBO.bairrosPelaCidade(filtro.getCidade());
        }

        return null;
    }

    public List<Cidade> cidades() {
        if (filtro.getCircunscricao() != null) {
            return cidadeBO.cidadePelaCircunscricao(filtro.getCircunscricao());
        }

        return cidadeBO.getDAO().listAll("nome");
    }

    public List<Bairro> getTodosOsBairros() {
        return bairroBO.listarTodos();
    }
}
