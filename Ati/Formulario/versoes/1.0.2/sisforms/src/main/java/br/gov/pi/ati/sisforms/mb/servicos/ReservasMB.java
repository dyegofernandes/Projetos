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
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.hibernate.proxy.HibernateProxy;
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
public class ReservasMB extends AbstractBaseBean<ReservaLocal> implements Serializable {

    private List<Arquivo> arquivos = new ArrayList<Arquivo>();
    ;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleModel eventModel;

    private ReservaLocal reserva;

    @EJB
    private ReservaLocalBO reservaLocalBO;

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
        iniciarReservas();
        reserva = new ReservaLocal();
    }

    @Override
    public void save() {

        getEntity().setArquivos(arquivos);

        super.save();

    }

    @Override
    public void postSave() {
        reserva = new ReservaLocal();
        iniciarReservas();
        super.postSave();
    }

    public ReservasMB() {

    }

    public void iniciarReservas() {
        eventModel = new DefaultScheduleModel();
        List<ReservaLocal> reservas = getBO().getDAO().listAll();
        for (ReservaLocal reserva : reservas) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent(reserva.getId() + " - " + reserva.getNomeSolicitante(), reserva.getDataInicio(), reserva.getDataFinal());
            eventModel.addEvent(eventTemp);
        }

    }

    public void selecionarEvento(SelectEvent selectEvent) {

        event = (ScheduleEvent) selectEvent.getObject();

        String titulo = event.getTitle();

        Long id = Long.parseLong(titulo.split(" ")[0]);

        ReservaLocal reserva = getBO().getDAO().getInitialized(getBO().getDAO().unique("id", id));

        setEntity(reserva);

        arquivos = getBO().getDAO().getInitialized(reserva.getArquivos());
    }

    public void selecionarData(SelectEvent selectEvent) {
        setEntity(new ReservaLocal());
        arquivos = new ArrayList<Arquivo>();
        getEntity().setDataInicio((Date) selectEvent.getObject());
        getEntity().setDataFinal((Date) selectEvent.getObject());
    }

    public void moverEvento(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento Movido", "Dia delta:" + event.getDayDelta() + ", Minuto delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void redimensionarEvento(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento redimensionado", "Dia delta:" + event.getDayDelta() + ", Minuto delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
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

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ReservaLocal getReserva() {
        return reserva;
    }

    public void setReserva(ReservaLocal reserva) {
        this.reserva = reserva;
    }

    public void saveAll() throws BusinessException {
        if (reserva != null) {
            try {
                getBO().saveAll(getBO().locaisPelaReserva(reserva));
                FacesMessageUtils.info("Reserva (s) Gerada (s) Com Sucesso!");
            } catch (BusinessException ex) {
                FacesMessageUtils.error(ex);
            }
        }
    }

}
