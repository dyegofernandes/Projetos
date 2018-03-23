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

import com.xpert.persistence.exception.DeleteException;
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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import static org.apache.commons.io.FilenameUtils.getExtension;
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
 * @author Juniel, Nilson, Samuel, Yago
 */
@ManagedBean
@ViewScoped
public class ReservaLocalMB extends AbstractBaseBean<ReservaLocal> implements Serializable {

    

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
    
    private StreamedContent down_file;
    
    private List<Arquivo> arquivos;
    
    private ReservaLocal reserva;
    
    private ScheduleModel eventModel;


    private ScheduleEvent event = new DefaultScheduleEvent();


    @Override
    public void init() {
        
        
        
        init_reservas();
        
        reserva = new ReservaLocal();
        
        try {
            down_init_arquivo();
        } catch (IOException ex) {
            Logger.getLogger(ReservaLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ReservaLocalMB(){        
        
    }
    
    public void carregar_arquivos(ReservaLocal reserv){
        if(reserv.getId() != null){
            arquivos = getDAO().getInitialized(reserv.getArquivos());
            
        }
    }
   
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    
    
    
    public ScheduleModel getEventModel() {
        return eventModel;
    }
    
    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void update() {
        reserva.setArquivos(arquivos);
        preSave();
        getBO().getDAO().update(reserva);
        postSave();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('widgetReservaLocalUpdate').hide();");
        //super.save(); //To change body of generated methods, choose Tools | Templates.

    }
    
    public void updateReserva(){
        preSave();
        getBO().getDAO().update(reserva);
        postSave();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('eventDialog').hide();");
    }
    
    
    
    @Override
    public void save() {
        getEntity().setArquivos(arquivos);

        super.save();

    }

    @Override
    public void postSave() {
        reserva = new ReservaLocal();
        String titulo=event.getTitle();
        if (titulo == null) { 
            DefaultScheduleEvent  newEvent = new DefaultScheduleEvent(reserva.getTitulo(), reserva.getDataInicio(), reserva.getDataFinal());
            eventModel.addEvent(newEvent);   
        } else { 
            //eventModel.updateEvent(event);    
        }
        
        
        
        init_reservas();
        super.postSave(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete() {
        if(event.getId() != null) {
            String titulo=event.getTitle();
            eventModel.deleteEvent(event);

            Long id = Long.parseLong(titulo.split(" ")[0]);
            try {
                getBO().getDAO().delete(id);
            } catch (DeleteException ex) {
                Logger.getLogger(ReservaLocalMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.delete(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void selecionarEvento(SelectEvent selectEvent) {

        event = (ScheduleEvent) selectEvent.getObject();
        
        String titulo=event.getTitle();

        Long id = Long.parseLong(titulo.split(" ")[0]);
        
        reserva = getBO().getDAO().getInitialized(getBO().getDAO().unique("id", id));
       
        setEntity(reserva);
        arquivos = getBO().getDAO().getInitialized(reserva.getArquivos());
    }

    public void selecionarData(SelectEvent selectEvent) {
        reserva = new ReservaLocal();
        arquivos = new ArrayList<Arquivo>();
        reserva.setDataInicio((Date) selectEvent.getObject());
        reserva.setDataFinal((Date) selectEvent.getObject());
    }

    public void moverEvento(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento Movido", "Dia delta:" + event.getDayDelta() + ", Minuto delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void redimensionarEvento(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento redimensionado", "Dia delta:" + event.getDayDelta() + ", Minuto delta:" + event.getMinuteDelta());

        addMessage(message);
    }
    public void init_reservas(){
        reserva = new ReservaLocal();
        eventModel = new DefaultScheduleModel();
        List<ReservaLocal> reservas = getBO().getDAO().listAll();
        for (ReservaLocal reservax : reservas) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent(reservax.getId()+" - "+reservax.getTitulo()+" - "+reservax.getSolicitante(),reservax.getDataInicio(), reservax.getDataFinal());
            eventModel.addEvent(eventTemp);
        }
    }
    
    public void down_init_arquivo() throws IOException{
        Long id = getEntity().getId();
        if(id!=null){
            ReservaLocal reservaX = getBO().getDAO().getInitialized(getBO().getDAO().unique("id", id));
            arquivos = getBO().getDAO().getInitialized(reservaX.getArquivos());

        }
        
    }
    
    public StreamedContent getDown_File() {
        return down_file;
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

    public void saveAll() throws BusinessException {
        
                Date dataFinal = reserva.getDataFinal();
                Date dataInicial = reserva.getDataInicio();
                System.out.println(reserva.getTitulo());
                Calendar ini = Calendar.getInstance();
                ini.setTime(dataInicial);
                Calendar fim = Calendar.getInstance();
                fim.setTime(dataFinal);
                ReservaLocal ag1 = reserva;
                
                if(fim.get(Calendar.DAY_OF_YEAR) > ini.get(Calendar.DAY_OF_YEAR)){
                    for (Date dt = ini.getTime(); ini.before(fim); ini.add(Calendar.DATE, 1), dt = ini.getTime()) {
                        Calendar calfim = Calendar.getInstance();
                        calfim.setTime(dt);
                        calfim.set(Calendar.HOUR_OF_DAY,fim.get(Calendar.HOUR_OF_DAY));

                        ReservaLocal ag = new ReservaLocal();
                        ag.setDataInicio(dt); 
                        ag.setDataFinal(calfim.getTime());
                      
                        ag.setTitulo(ag1.getTitulo());
                        ag.setLocal(ag1.getLocal());
                        ag.setSolicitante(ag1.getSolicitante());
                        ag.setOrgao(ag1.getOrgao());
                        ag.setFone(ag1.getFone());
                        ag.setObservacao(ag1.getObservacao());
                        
                        List<Arquivo> arquivotemp = new ArrayList();
                        for (Arquivo arquivo : arquivos) {
                            Arquivo arq = new Arquivo();
                            arq.setConteudo(arquivo.getConteudo());
                            arq.setExtensao(arquivo.getExtensao());
                            arq.setNome(arquivo.getNome());
                            arquivotemp.add(arq);
                        }
                        ag.setArquivos(arquivotemp);
                        
                        
                        if(dt.compareTo(dataInicial) == 1){
                            if(reserva.getId()==null){
                            getBO().save(ag);
                            postSave(); 
                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('eventDialog').hide();");
                            }else{
                                reserva.setArquivos(arquivos);
                                updateReserva();
                                }  
                        }else{
                            if(ag.getId() == null){
                                getBO().save(ag);
                                postSave(); 
                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('eventDialog').hide();");
                            }else{
                                reserva.setArquivos(arquivos);
                                updateReserva();
                                } 
                        }
                    }
                }else{
                    if(ag1.getId() == null){
                        ag1.setArquivos(arquivos);
                        getBO().save(ag1);
                        postSave();
                    }else{ 
                        reserva.setArquivos(arquivos); 
                        updateReserva();
                    }
                }

    }
    

    public ReservaLocal getReserva() {
        return reserva;
    }

    public void setReserva(ReservaLocal reserva) {
        this.reserva = reserva;
    }

    public ReservaLocalBO getReservaLocalBO() {
        return reservaLocalBO;
    }

    public void setReservaLocalBO(ReservaLocalBO reservaLocalBO) {
        this.reservaLocalBO = reservaLocalBO;
    }

    public StreamedContent getDown_file() {
        return down_file;
    }

    public void setDown_file(StreamedContent down_file) {
        this.down_file = down_file;
    }

    
    
    
}
