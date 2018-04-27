package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.AgendamentoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.Contato;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
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
public class AgendamentoCalendarioMB extends AbstractBaseBean<Agendamento> implements Serializable {

    @EJB
    private AgendamentoBO agendamentoBO;

    private ScheduleModel eventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ItemPedido itemPedido;

    private List<Contato> contatos;

    private Contato contatoAdd;

    private List<ArquivoAgendamento> arquivos;

    @Override
    public AgendamentoBO getBO() {
        return agendamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        eventModel = new DefaultScheduleModel();

        itemPedido = new ItemPedido();

        contatoAdd = new Contato();

        contatos = new ArrayList<Contato>();

        arquivos = new ArrayList<ArquivoAgendamento>();
    }

    @Override
    public void save() {
        getEntity().setProtocolo(getProtocolo());
        getEntity().setItemPedido(itemPedido);
        getEntity().setArquivos(arquivos);
        getEntity().setContatos(contatos);

        super.save();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        FacesMessageUtils.error("Horário Reservado!!");
    }

    public void onDateSelect(SelectEvent selectEvent) {

        RequestContext context = RequestContext.getCurrentInstance();

        Date dataInicial = (Date) selectEvent.getObject();

        if (dataInicial.before(new Date())) {
            FacesMessageUtils.error("Reservas não pode ser feita para datas ou horários passados!!");
        } else {
            if (ehSexta(dataInicial)) {
                FacesMessageUtils.error("Apenas expediente Interno!");
            } else {
                getEntity().setDataInicial(dataInicial);
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(dataInicial);
                calendario.add(Calendar.MINUTE, 30);

                getEntity().setDataFinal(calendario.getTime());

                context.execute("PF('widgetAgendamento').show();");
            }

        }

//        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessageUtils.error("Horário Reservado!!");
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private String getProtocolo() {

        String protocolo = "AG.";

        String anoAtual = Utils.getDateString(new Date(), "yy");

        Long id = (Long) getDAO().getQueryBuilder().from(Agendamento.class).max("id");

        Cliente orgao = getDAO().getInitialized(getEntity().getCliente());

        if (orgao.getCodigo() != null) {
            protocolo = protocolo.concat(Utils.inserirZeroAEsquerda(orgao.getCodigo().toString(), 3));
        } else {
            protocolo = protocolo.concat("000");
        }

        protocolo = protocolo.concat(".2.");

        if (id != null) {
            Agendamento agendamento = getDAO().getInitialized(getDAO().unique("id", id));
            String[] codigoTemp = new String[2];

            codigoTemp = agendamento.getProtocolo().split("/");

            Integer sequencial = new Integer(codigoTemp[0].substring(codigoTemp[0].length() - 6, codigoTemp[0].length()));

            sequencial++;

            protocolo = protocolo.concat(Utils.inserirZeroAEsquerda(sequencial.toString(), 6));

        } else {
            protocolo = protocolo.concat("000001/");
        }

        return protocolo.concat(anoAtual);
    }

    public static String getDateString(Date data, String pattern) {
        SimpleDateFormat formataData = null;

        if (data == null) {
            return "";
        }

        formataData = new SimpleDateFormat(pattern);

        return formataData.format(data);
    }

    private boolean ehSexta(Date data) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);

        if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            return true;
        }

        return false;
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
        ArquivoAgendamento arquivo = new ArquivoAgendamento();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public void removerArquivo(ArquivoAgendamento arquivo) {
        arquivos.remove(arquivo);
    }

    public void addContato() {
        if (!Utils.isNullOrEmpty(contatoAdd.getNome())) {
            if (!Utils.isNullOrEmpty(contatoAdd.getNumero())) {
                if (numJahAdicionado(contatoAdd.getNumero())) {
                    FacesMessageUtils.error("Número já encontrado na lista de contatos!");
                } else {
                    contatos.add(contatoAdd);
                    contatoAdd = new Contato();
                }
            } else {
                FacesMessageUtils.error("Número do Contato é obrigatório!!");
            }
        } else {
            FacesMessageUtils.error("Nome do Contato é obrigatório!!");
        }
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }

    private boolean numJahAdicionado(String num) {
        for (Contato contato : contatos) {
            if (contato.getNumero().equals(num)) {
                return true;
            }
        }
        return false;
    }
}
