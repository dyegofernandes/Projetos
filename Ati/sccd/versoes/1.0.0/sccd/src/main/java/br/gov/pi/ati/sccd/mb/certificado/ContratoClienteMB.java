package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.ContratoClienteBO;
import br.gov.pi.ati.sccd.bo.certificado.ContratoFornecedorBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoFornecedor;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.JoinBuilder;
import com.xpert.persistence.query.Restrictions;
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
public class ContratoClienteMB extends AbstractBaseBean<ContratoCliente> implements Serializable {

    @EJB
    private ContratoClienteBO contratoClienteBO;

    @EJB
    private ContratoFornecedorBO contraFornecedorBO;

    private List<TipoCertificadoAux> certificados;

    private List<TipoCertificadoFornecedor> certificadosFornecedor;
    
    private TipoCertificadoAux certificadoAdd;

    private List<Arquivo> arquivos;

    @Override
    public ContratoClienteBO getBO() {
        return contratoClienteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "cliente.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("contratoCliente")
                .leftJoinFetch("contratoCliente.contratoFornecedor", "contratoFornecedor")
                .leftJoinFetch("contratoFornecedor.fornecedor", "fornecedor")
                .leftJoinFetch("contratoCliente.cliente", "cliente");
    }

    @Override
    public void init() {
        certificadoAdd = new TipoCertificadoAux();
        certificados = new ArrayList<TipoCertificadoAux>();
        certificadosFornecedor = new ArrayList<TipoCertificadoFornecedor>();
        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            ContratoFornecedor contratoFornecedor = getDAO().getInitialized(getEntity().getContratoFornecedor());
            certificadosFornecedor = getDAO().getInitialized(contratoFornecedor.getCertificados());
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
        if (getEntity().getContratoFornecedor() != null) {
            if (certificadoAdd.getTipo() != null) {
                if (certificadoAdd.getValor() != null) {
                    if (getEntity().getCliente() != null) {
                        if (certificadoAdd.getValor().doubleValue() > 0) {
                            if (getEntity().getCliente().isIsento()) {
                                FacesMessageUtils.error("Valor deve ser zero para clientes isentos!");
                            } else {
                                if (certificadoJaAdicionado(certificadoAdd.getTipo())) {
                                    FacesMessageUtils.error("Já foi encontrado esse tipo de certificado na lista!");
                                } else {
                                    certificados.add(certificadoAdd);
                                    certificadoAdd = new TipoCertificadoAux();
                                }
                            }

                        } else {
                            if (getEntity().getCliente().isIsento()) {
                                if (certificadoJaAdicionado(certificadoAdd.getTipo())) {
                                    FacesMessageUtils.error("Já foi encontrado esse tipo de certificado na lista!");
                                } else {
                                    certificados.add(certificadoAdd);
                                    certificadoAdd = new TipoCertificadoAux();
                                }
                            } else {
                                FacesMessageUtils.error("Valor deve ser zero para clientes isentos!");
                            }
                        }
                    } else {
                        FacesMessageUtils.error("Informe o cliente!");
                    }
                } else {
                    FacesMessageUtils.error("Valor é obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Tipo do certificado é obrigatório! Informe o Contrato de Fornecedor!");
            }
        } else {
            FacesMessageUtils.error("Forncedor é obrigatório!");
        }

    }

    public void removerCertificado(TipoCertificadoAux certificado) {
        certificados.remove(certificado);
    }

    private boolean certificadoJaAdicionado(TipoCertificado certificado) {
        for (TipoCertificadoAux certificado1 : certificados) {
            if (certificado1.getTipo().equals(certificado)) {
                return true;
            }
        }
        return false;
    }

    private ContratoFornecedor getContratosFornecedores() {
        ContratoFornecedor contratosFornecedor = null;
        if (getEntity().getDataInicio() != null && getEntity().getDataFinal() != null) {
            Restrictions restrictions = new Restrictions();
            restrictions.lessEqualsThan("dataInicio", getEntity().getDataInicio());
            restrictions.greaterEqualsThan("dataFinal", getEntity().getDataFinal());
            restrictions.add("ativo", true);
            contratosFornecedor = contraFornecedorBO.getDAO().unique(restrictions);
        }

        return contratosFornecedor;
    }

    public List<TipoCertificadoAux> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<TipoCertificadoAux> certificados) {
        this.certificados = certificados;
    }

    public TipoCertificadoAux getCertificadoAdd() {
        return certificadoAdd;
    }

    public void setCertificadoAdd(TipoCertificadoAux certificadoAdd) {
        this.certificadoAdd = certificadoAdd;
    }

    public void chanceFornecedor() {
        certificados = new ArrayList<TipoCertificadoAux>();

        if (getEntity().getContratoFornecedor() != null) {
            certificadosFornecedor = getDAO().getInitialized(getEntity().getContratoFornecedor().getCertificados());
        } else {
            certificadosFornecedor = new ArrayList<TipoCertificadoFornecedor>();
        }
    }

    public List<TipoCertificado> getTiposCertificacos() {
        if (certificadoAdd.getTipoCertificadoFornecedor() != null) {
            return getDAO().getInitialized(certificadoAdd.getTipoCertificadoFornecedor().getTiposCertificados());
        }

        return null;
    }

    public List<TipoCertificadoFornecedor> getCertificadosFornecedorSelecionado() {
        if (getEntity().getContratoFornecedor() != null) {
            return getDAO().getInitialized(getEntity().getContratoFornecedor().getCertificados());
        }
        return null;
    }

    public List<ContratoCliente> todos() {
        return getBO().contratos();
    }

    public List<ContratoCliente> contratosAtivo() {
        return getBO().contratosAtivo();
    }

    public boolean renderizarPanel() {
        Cliente cliente = getDAO().getInitialized(getEntity().getCliente());

        if (cliente != null) {
            return !cliente.isIsento();
        }

        return false;
    }

    public void selecionarCertificado() {
        if (certificadoAdd.getTipo() != null) {

        }
    }

    public List<ContratoCliente> autocompleteAtivosPeloNomeDoCliente(String nome) {
        return getBO().contratosAtivoPeloNomeCliente(nome);
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

    public List<TipoCertificadoFornecedor> getCertificadosFornecedor() {
        return certificadosFornecedor;
    }

    public void setCertificadosFornecedor(List<TipoCertificadoFornecedor> certificadosFornecedor) {
        this.certificadosFornecedor = certificadosFornecedor;
    }

}
