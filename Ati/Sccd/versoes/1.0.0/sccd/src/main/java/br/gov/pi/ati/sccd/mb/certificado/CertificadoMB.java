package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.CertificadoBO;
import br.gov.pi.ati.sccd.bo.certificado.ItemPedidoBO;
import br.gov.pi.ati.sccd.bo.certificado.PedidoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.certificado.Certificado;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoPedido;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
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
public class CertificadoMB extends AbstractBaseBean<Certificado> implements Serializable {

    @EJB
    private CertificadoBO certificadoBO;

    @EJB
    private PedidoBO pedidoBO;

    @EJB
    private ItemPedidoBO itemBO;

    private List<Pedido> pedidos;

    private List<ItemPedido> itensPedido;

    private List<Arquivo> arquivos;

    @Override
    public CertificadoBO getBO() {
        return certificadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "cliente.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("certificado")
                .leftJoinFetch("certificado.cliente", "contratoCliente")
                .leftJoinFetch("contratoCliente.cliente", "cliente")
                .leftJoinFetch("certificado.pedido", "pedido")
                .leftJoinFetch("certificado.titular", "titular")
                .leftJoinFetch("certificado.autoridadeCertificadora", "ac")
                .leftJoinFetch("titular.tipoCertificado", "tipoCertificado");
    }

    @Override
    public void init() {
        pedidos = new ArrayList<Pedido>();
        itensPedido = new ArrayList<ItemPedido>();

        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
        }

        if (getEntity().getCliente() != null) {
            ContratoCliente contratoCliente = getDAO().getInitialized(getEntity().getCliente());

            if (contratoCliente != null) {
                Cliente cliente = getDAO().getInitialized(contratoCliente.getCliente());

                pedidos = pedidoBO.pedidosPeloCliente(cliente);
            }
        }

        if (getEntity().getPedido() != null) {
            Pedido pedido = getDAO().getInitialized(getEntity().getPedido());

            if (pedido != null) {
                itensPedido = pedidoBO.itensPedidoSituacao(pedido, false);
            }

        }
    }

    @Override
    public void save() {
        getEntity().setArquivos(arquivos);
        super.save();
    }

    @Override
    public void postSave() {

        ItemPedido item = getDAO().getInitialized(getEntity().getTitular());
        item.setAtendido(true);
        itemBO.getDAO().saveOrMerge(item, true);

        Pedido pedido = getDAO().getInitialized(getEntity().getPedido());

        List<ItemPedido> itens = getDAO().getInitialized(pedido.getItens());

        int contador = 0;

        for (ItemPedido iten : itens) {
            if (iten.isAtendido()) {
                contador++;
            }
        }

        if (itens.size() == contador) {
            pedido.setSituacao(SituacaoPedido.ATENDIDO);
        } else {
            pedido.setSituacao(SituacaoPedido.PARCIALMENTE_ATENDIDO);
        }

        pedidoBO.getDAO().saveOrMerge(pedido, true);

        super.postSave();
    }

    @Override
    public void delete() {
        Certificado certificado = getDAO().unique("id", getId());
        ItemPedido item = getDAO().getInitialized(certificado.getTitular());

        item.setAtendido(false);
        itemBO.getDAO().saveOrMerge(item, true);

        super.delete();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public boolean verificarSeEhPJ() {
        if (getEntity().getTitular() != null) {
            ItemPedido titular = getDAO().getInitialized(getEntity().getTitular());
            TipoCertificado tipoCertificado = getDAO().getInitialized(titular.getTipoCertificado());
            if (tipoCertificado.getTipoPessoa() == TipoPessoa.JURIDICA) {
                return true;
            }

        }

        return false;
    }

    public void pegarPedidos() {

        pedidos = new ArrayList<Pedido>();
        itensPedido = new ArrayList<ItemPedido>();
        getEntity().setPedido(null);
        getEntity().setTitular(null);

        if (getEntity().getCliente() != null) {
            ContratoCliente contratoCliente = getDAO().getInitialized(getEntity().getCliente());

            if (contratoCliente != null) {
                Cliente cliente = getDAO().getInitialized(contratoCliente.getCliente());

                pedidos = pedidoBO.pedidosPeloCliente(cliente);
            }
        }
    }

    public void pegarTitulares() {
        getEntity().setTitular(null);
        itensPedido = new ArrayList<ItemPedido>();

        if (getEntity().getPedido() != null) {
            Pedido pedido = getDAO().getInitialized(getEntity().getPedido());

            if (pedido != null) {
                itensPedido = pedidoBO.itensPedidoSituacao(pedido, false);
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
