package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.ContratoFornecedorBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoFornecedor;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.JoinBuilder;
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
public class ContratoFornecedorMB extends AbstractBaseBean<ContratoFornecedor> implements Serializable {

    @EJB
    private ContratoFornecedorBO contratoFornecedorBO;

    private List<TipoCertificadoFornecedor> certificados;

    private TipoCertificadoFornecedor certificadoAdd;

    private List<Arquivo> arquivos;

    @Override
    public ContratoFornecedorBO getBO() {
        return contratoFornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "fornecedor.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("contratoFornecedor")
                .leftJoinFetch("contratoFornecedor.fornecedor", "fornecedor");
    }

    @Override
    public void init() {
        certificadoAdd = new TipoCertificadoFornecedor();
        certificados = new ArrayList<TipoCertificadoFornecedor>();
        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            certificados = getDAO().getInitialized(getEntity().getCertificados());
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
        }
    }

    @Override
    public void save() {
        getEntity().setCertificados(certificados);
        getEntity().setArquivos(arquivos);
        super.save();
    }

    @Override
    public void postSave() {
        super.postSave();
    }

    public void addCertificado() {
        if (certificadoAdd.getTiposCertificados().size() > 0) {
            if (!Utils.isNullOrEmpty(certificadoAdd.getNome())) {
                if (certificadoAdd.getQuantidade() != null) {
                    if (certificadoAdd.getQuantidade().doubleValue() > 0) {
                        if (certificadoAdd.getValor() != null) {
                            if (certificadoAdd.getValor().doubleValue() > 0) {
                                if (certificadoJaAdicionado(certificadoAdd.getNome())) {
                                    FacesMessageUtils.error("Já foi encontrado certificado com esse nome na lista!");
                                } else {
                                    certificados.add(certificadoAdd);
                                    certificadoAdd = new TipoCertificadoFornecedor();
                                }
                            } else {
                                FacesMessageUtils.error("Valor deve ser maior que zero!");
                            }
                        } else {
                            FacesMessageUtils.error("Valor é obrigatório!");
                        }
                    } else {
                        FacesMessageUtils.error("Quantidade deve ser maior que zero!");
                    }
                } else {
                    FacesMessageUtils.error("Quantidade é obrigatória!");
                }
            } else {
                FacesMessageUtils.error("Nome do Certificado é obrigatório!");
            }

        } else {
            FacesMessageUtils.error("Um ou mais Tipos de Certificado é obrigatório!");
        }

    }

    public void removerCertificado(TipoCertificadoFornecedor certificado) {
        certificados.remove(certificado);
    }

    private boolean certificadoJaAdicionado(String nome) {
        for (TipoCertificadoFornecedor certificado1 : certificados) {
            if (certificado1.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public List<TipoCertificadoFornecedor> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<TipoCertificadoFornecedor> certificados) {
        this.certificados = certificados;
    }

    public TipoCertificadoFornecedor getCertificadoAdd() {
        return certificadoAdd;
    }

    public void setCertificadoAdd(TipoCertificadoFornecedor certificadoAdd) {
        this.certificadoAdd = certificadoAdd;
    }

    public List<ContratoFornecedor> contratosAtivos() {
//        return getBO().contratosAtivoPeloNome(null);
        return getBO().todos();
    }

    public List<ContratoFornecedor> autocomplete(String nome) {
        return getBO().contratosAtivoPeloNome(nome);
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
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
}
