package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.PedidoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
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
public class PedidoMB extends AbstractBaseBean<Pedido> implements Serializable {

    @EJB
    private PedidoBO pedidoBO;

    private List<ItemPedido> itens;

    private ItemPedido itemAdd;

    private List<Arquivo> arquivos;

    @Override
    public PedidoBO getBO() {
        return pedidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "cliente.nome, pedido.dataSolicitacao";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("pedido")
                .leftJoinFetch("pedido.cliente", "cliente");
    }

    @Override
    public void init() {
        itemAdd = new ItemPedido();

        itens = new ArrayList<ItemPedido>();
        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            itens = getDAO().getInitialized(getEntity().getItens());
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
        }
    }

    @Override
    public void save() {
        getEntity().setItens(itens);
        getEntity().setArquivos(arquivos);
        super.save();
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public ItemPedido getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(ItemPedido itemAdd) {
        this.itemAdd = itemAdd;
    }

    public void adicionar() {
        if (itemAdd != null) {
            TipoCertificado tipoCertificaco = getDAO().getInitialized(itemAdd.getTipoCertificado());
            if (tipoCertificaco.getTipoPessoa() != null) {
                if (!Utils.isNullOrEmpty(itemAdd.getCpfCnpjTitular())) {
                    if (!Utils.isNullOrEmpty(itemAdd.getNomeTitular())) {
                        if (itemAdd.getTipoCertificado() != null) {
                            if (!itemJahAdicionado(itemAdd)) {
                                itens.add(itemAdd);
                                itemAdd = new ItemPedido();
                            } else {
                                if (tipoCertificaco.getTipoPessoa() == TipoPessoa.FISICA) {
                                    FacesMessageUtils.error("Titular com esse CPF já foi adicionado na lista!");
                                } else {
                                    FacesMessageUtils.error("Titular com esse CNPJ já foi adicionado na lista!");
                                }
                            }
                        } else {
                            FacesMessageUtils.error("Tipo de Certificado é Obrigatório!");
                        }
                    } else {
                        FacesMessageUtils.error("Nome do Titular é Obrigatório!");
                    }
                } else {
                    if (tipoCertificaco.getTipoPessoa() == TipoPessoa.FISICA) {
                        FacesMessageUtils.error("CPF é Obrigatório!");
                    } else {
                        FacesMessageUtils.error("CNPJ é Obrigatório!");
                    }
                }
            } else {
                FacesMessageUtils.error("Tipo de Pessoa é Obrigatório!");
            }
        }else{
            FacesMessageUtils.error("Tipo de Certificado é Obrigatório!");
        }
    }

    public void remover(ItemPedido item) {
        if (item.isAtendido()) {
            FacesMessageUtils.error("Item com a situação atendido não pode ser removido!");
        } else {
            itens.remove(item);
        }
    }

    private boolean itemJahAdicionado(ItemPedido item) {
        for (ItemPedido iten : itens) {
            if (iten.equals(item)) {
                return true;
            }
        }
        return false;
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
