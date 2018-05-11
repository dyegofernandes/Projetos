package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.AgendamentoBO;
import br.gov.pi.ati.sccd.bo.certificado.PedidoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sccd.modelo.enums.HeaderCalendario;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoPedido;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.JoinBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AgendamentoMB extends AbstractBaseBean<Agendamento> implements Serializable {

    @EJB
    private AgendamentoBO agendamentoBO;

    @EJB
    private PedidoBO pedidoBO;

    private ScheduleModel eventModel;

    private ItemPedido itemPedido;

    private TipoArquivoAgendamento tipo;

    private List<ArquivoAgendamento> arquivos;

    private SituacaoAgendamento situacaoTemp;

    private String headerCalendario;

    private Date dataInicial;

    @Override
    public AgendamentoBO getBO() {
        return agendamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "agendamento.dataInicial";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("agendamento")
                .leftJoinFetch("agendamento.itemPedido", "item")
                .leftJoinFetch("agendamento.cliente", "cliente")
                .leftJoinFetch("item.tipoCertificado", "tipoCertificado");
    }

    @Override
    public void init() {
        headerCalendario = HeaderCalendario.MES.getDescricao();

        dataInicial = new Date();

        situacaoTemp = getEntity().getSituacao();

        eventModel = new DefaultScheduleModel();

        itemPedido = new ItemPedido();

        arquivos = new ArrayList<ArquivoAgendamento>();

        if (getEntity().getId() != null) {
            itemPedido = getDAO().getInitialized(getEntity().getItemPedido());
            arquivos = getDAO().getInitialized(getEntity().getArquivos());
        }

        carregarAgenda();
    }

    @Override
    public void save() {
        getEntity().setItemPedido(itemPedido);
        getEntity().setArquivos(arquivos);

        if (getEntity().getSituacao() == SituacaoAgendamento.CONFIRMADO) {
            if (situacaoTemp == SituacaoAgendamento.NAO_CONFIRMADO) {
                getEntity().setDataAtendimento(new Date());
            }
        }
        super.save();
    }

    @Override
    public void postSave() {
        carregarAgenda();

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetAgendamento').hide();");

        if (situacaoTemp == SituacaoAgendamento.NAO_CONFIRMADO) {
            if (getEntity().getSituacao() == SituacaoAgendamento.CONFIRMADO) {

                Pedido pedido = new Pedido();

                pedido.setProtocolo(getEntity().getProtocolo());
                pedido.setCliente(getEntity().getCliente());
                pedido.setTipo(TipoPedido.AGENDAMENTO);
                pedido.setDataSolicitacao(getEntity().getDataInicial());

                List<Arquivo> arquivosTemp = new ArrayList<Arquivo>();

                for (ArquivoAgendamento arquivo : arquivos) {
                    Arquivo arquivoTemp = new Arquivo();

                    arquivoTemp.setNome(arquivo.getNome());
                    arquivoTemp.setConteudo(arquivo.getConteudo());
                    arquivoTemp.setExtensao(arquivo.getExtensao());
                    arquivoTemp.setTipo(arquivo.getTipo());

                    arquivosTemp.add(arquivoTemp);
                }

                List<ItemPedido> itens = new ArrayList<ItemPedido>();
                ItemPedido item = new ItemPedido();
                item.setCpfCnpjTitular(itemPedido.getCpfCnpjTitular());
                item.setNomeTitular(itemPedido.getNomeTitular());
                item.setTipoCertificado(itemPedido.getTipoCertificado());

                itens.add(item);

                pedido.setItens(itens);
                pedido.setArquivos(arquivosTemp);

                pedidoBO.getDAO().save(pedido, true);

                try {
                    getBO().enviarEmail(TipoAssuntoEmail.CONFIRMACAO_SOLICITACAO, getEntity());
                    FacesMessageUtils.info("Email de confirmação de Agendamento enviado para: ".concat(getEntity().getEmail()));
                } catch (BusinessException ex) {
                    Logger.getLogger(AgendamentoCalendarioMB.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                if (getEntity().getSituacao() == SituacaoAgendamento.CANCELADO) {
                    try {
                        getBO().enviarEmail(TipoAssuntoEmail.CANCELADO_AGENDAMENTO, getEntity());
                        FacesMessageUtils.info("Email de cancelamento de Agendamento enviado para: ".concat(getEntity().getEmail()));
                    } catch (BusinessException ex) {
                        Logger.getLogger(AgendamentoCalendarioMB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (getEntity().getSituacao() == SituacaoAgendamento.NAO_AUTORIZADO) {
                    try {
                        getBO().enviarEmail(TipoAssuntoEmail.NAO_AUTORIZADO_AGENDAMENTO, getEntity());
                        FacesMessageUtils.info("Email de Agendamento não autorizado enviado para: ".concat(getEntity().getEmail()));
                    } catch (BusinessException ex) {
                        Logger.getLogger(AgendamentoCalendarioMB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            if (situacaoTemp == SituacaoAgendamento.CONFIRMADO) {
                if (getEntity().getSituacao() == SituacaoAgendamento.CANCELADO) {
                    try {
                        getBO().enviarEmail(TipoAssuntoEmail.CANCELADO_AGENDAMENTO, getEntity());
                        FacesMessageUtils.info("Email de cancelamento de Agendamento enviado para: ".concat(getEntity().getEmail()));
                    } catch (BusinessException ex) {
                        Logger.getLogger(AgendamentoCalendarioMB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        super.postSave();
    }

    public void carregarAgenda() {
        List<Agendamento> agendamentos = getBO().agendamentosPelaData(new Date(), null);

        eventModel = new DefaultScheduleModel();

        for (Agendamento agendamento : agendamentos) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent(agendamento.getProtocolo().concat(": ").concat(agendamento.getSituacao().getDescricao()), agendamento.getDataInicial(), agendamento.getDataFinal());
            eventModel.addEvent(eventTemp);
        }
    }

    public StreamedContent download(ArquivoAgendamento arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (ArquivoAgendamento) proxy.getHibernateLazyInitializer().getImplementation();
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

        if (tipo != null) {

            ArquivoAgendamento arquivo = new ArquivoAgendamento();
            UploadedFile uploadedFile = event.getFile();
            arquivo.setNome(uploadedFile.getFileName());
            arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
            String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
            arquivo.setConteudo(base64AsString);
            arquivo.setTipo(tipo);
            if (arquivoJahAdicionado(arquivo)) {
                FacesMessageUtils.error("Tipo de Arquivo:".concat(tipo.getDescricao()).concat(" já foi adicionado!"));
            } else {
                arquivos.add(arquivo);
                tipo = null;
            }

        } else {
            FacesMessageUtils.error("Informe o tipo de Arquivo!");
        }

    }

    public void removerArquivo(ArquivoAgendamento arquivo) {
        arquivos.remove(arquivo);
    }

    private boolean arquivoJahAdicionado(ArquivoAgendamento arquivo) {
        for (ArquivoAgendamento arq : arquivos) {
            if (arq.getTipo().equals(arquivo.getTipo())) {
                return true;
            }
        }
        return false;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();

        String[] codigoTemp = new String[2];

        codigoTemp = event.getTitle().split("\\:");

        Agendamento agendamento = (Agendamento) getDAO().getQueryBuilder().select("agendamento").from(Agendamento.class, "agendamento")
                .leftJoinFetch("agendamento.itemPedido", "item").leftJoinFetch("agendamento.cliente", "cliente")
                .leftJoinFetch("item.tipoCertificado", "tipoCertificado").add("protocolo", codigoTemp[0]).getSingleResult();

        setEntity(agendamento);

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetAgendamento').show();");
    }

    public void onDateSelect(SelectEvent selectEvent) {

        Date dataSolicitada = (Date) selectEvent.getObject();

        if (verificarHoraZerada(dataSolicitada)) {
            headerCalendario = HeaderCalendario.DIA.getDescricao();
            dataInicial = dataSolicitada;
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public List<ArquivoAgendamento> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoAgendamento> arquivos) {
        this.arquivos = arquivos;
    }

    public TipoArquivoAgendamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoArquivoAgendamento tipo) {
        this.tipo = tipo;
    }

    public String getHeaderCalendario() {
        return headerCalendario;
    }

    public void setHeaderCalendario(String headerCalendario) {
        this.headerCalendario = headerCalendario;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public boolean verificarHoraZerada(Date data) {
        Calendar dataSolicitada = Calendar.getInstance();
        dataSolicitada.setTime(data);

        Calendar dataComHoraZero = Calendar.getInstance();
        dataComHoraZero.setTime(data);
        dataComHoraZero.set(Calendar.HOUR_OF_DAY, 0);
        dataComHoraZero.set(Calendar.MINUTE, 0);
        dataComHoraZero.set(Calendar.SECOND, 0);
        dataComHoraZero.set(Calendar.MILLISECOND, 0);

        if (dataSolicitada.getTime().equals(dataComHoraZero.getTime())) {
            return true;
        }

        return false;
    }
}
