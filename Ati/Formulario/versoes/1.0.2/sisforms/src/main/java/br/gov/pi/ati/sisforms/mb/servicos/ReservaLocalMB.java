package br.gov.pi.ati.sisforms.mb.servicos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.ReservaLocalBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import com.lowagie.text.pdf.codec.Base64;
import com.xpert.core.exception.BusinessException;
import br.gov.pi.ati.sisforms.util.SessaoUtils;

import com.xpert.faces.utils.FacesMessageUtils;
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
    
    private FiltrosVO filtros;
       
    private List<LocalReserva> locais;
            
    private StreamedContent down_file;
    
    private List<Arquivo> arquivos;
    
    private ReservaLocal reserva;
    
    private ScheduleModel eventModel;

    private List<ReservaLocal> reservas;
    
    private ScheduleEvent event = new DefaultScheduleEvent();

    private Usuario usuarioAtual;
            
    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();
        filtros  = new FiltrosVO();
        filtros.setUsuario(usuarioAtual);
        
        Orgao orgao = getDAO().getInitialized(usuarioAtual.getOrgao());
        if(getEntity().getId()==null){
            getEntity().setOrgao(orgao);
        }
        locais = getBO().locaisPorOrgao(orgao);
        reservas = getBO().reservasPorOrgao(orgao);
        init_reservas();
        
        reserva = new ReservaLocal();
        
        try {
            down_init_arquivo();
        } catch (IOException ex) {
            Logger.getLogger(ReservaLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public List<ReservaLocal> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaLocal> reservas) {
        this.reservas = reservas;
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

    
    public void del() {
        
  
                
                eventModel.deleteEvent(event);

                
                try {
                    getBO().getDAO().remove(reserva, true);
                    Orgao orgao = getDAO().getInitialized(SessaoUtils.getUser().getOrgao());
                    reservas = getBO().reservasPorOrgao(orgao);
                } catch (DeleteException ex) {
                    Logger.getLogger(ReservaLocalMB.class.getName()).log(Level.SEVERE, null, ex);
                }
       RequestContext context = RequestContext.getCurrentInstance();
       context.execute("PF(\'eventDialog\').hide();");
    }
   
    
    public void remove_reserva(ReservaLocal reserva) {
        
                try {
                    getBO().getDAO().remove(reserva,true);
                    Orgao orgao = getDAO().getInitialized(SessaoUtils.getUser().getOrgao());
                    reservas = getBO().reservasPorOrgao(orgao);
                } catch (DeleteException ex) {
                    Logger.getLogger(ReservaLocalMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            

       
    }
    
    public void update() {
        reserva.setArquivos(arquivos);
        
        preSave();
        getBO().getDAO().update(reserva);
        postSave();
        FacesMessageUtils.sucess();
        RequestContext context = RequestContext.getCurrentInstance();
       
        context.execute("PF('widgetReservaLocalUpdate').update();");
        context.execute("PF('widgetReservaLocalUpdate').hide();");
    }
    
    public void updateReserva(){
        reserva.setArquivos(arquivos);
        preSave();
        getBO().getDAO().update(reserva);
        postSave();
        RequestContext context = RequestContext.getCurrentInstance();
    
        context.execute("PF(\'eventDialog\').hide();");
    }
    
    
    @Override
    public void save() {
        getEntity().setArquivos(arquivos);

        super.save();

    }

    @Override
    public void postSave() {
        RequestContext context = RequestContext.getCurrentInstance();
        reserva = new ReservaLocal();
        String titulo=event.getTitle();
        if (titulo == null) { 
            DefaultScheduleEvent  newEvent = new DefaultScheduleEvent(reserva.getTitulo(), reserva.getDataInicio(), reserva.getDataFinal(), "emp1");
            eventModel.addEvent(newEvent);   
        } 
        
        init_reservas();
        context.execute("PF(\'eventDialog\').hide();");
        super.postSave(); //To change body of generated methods, choose Tools | Templates.
        
    }
    

    
    
    public void selecionarEvento(SelectEvent selectEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        event = (ScheduleEvent) selectEvent.getObject();
        
        String titulo=event.getTitle();

        Long id = Long.parseLong(titulo.split(" ")[0]);
        
        reserva = getBO().getDAO().getInitialized(getBO().getDAO().unique("id", id));
       
        setEntity(reserva);
        arquivos = getBO().getDAO().getInitialized(reserva.getArquivos());
        context.execute("PF('eventDialog').show();");
        
        
    }

    public void selecionarData(SelectEvent selectEvent) {
        
        RequestContext context = RequestContext.getCurrentInstance();
        reserva = new ReservaLocal();
        arquivos = new ArrayList<Arquivo>();
        reserva.setDataInicio((Date) selectEvent.getObject());
        reserva.setDataFinal((Date) selectEvent.getObject());

        context.execute("PF('eventDialog').show();");
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
        
        Orgao orgao = getDAO().getInitialized(SessaoUtils.getUser().getOrgao());
        
        
        eventModel = new DefaultScheduleModel();
        reservas = getBO().reservasPorOrgao(orgao);
        /*System.out.println(orgao.getNome());*/
        for (ReservaLocal reservax : reservas) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent(reservax.getId()+" - "+reservax.getTitulo()+" - "+reservax.getSolicitante(),reservax.getDataInicio(), reservax.getDataFinal(),"emp1");
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

    public List<LocalReserva> getLocais() {
        return locais;
    }

    public void setLocais(List<LocalReserva> locais) {
        this.locais = locais;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }
    
    
    
    
    
    public void saveAll() throws BusinessException {
                RequestContext context = RequestContext.getCurrentInstance();
                
                Date dataFinal = reserva.getDataFinal();
                Date dataInicial = reserva.getDataInicio();
                //System.out.println(reserva.getTitulo());
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
                        ag.setOrgao(ag1.getLocal().getOrgao());
                        ag.setContato(ag1.getContato());
                        ag.setObservacao(ag1.getObservacao());
                        ag.setOrgaoSolicitante(ag1.getOrgaoSolicitante());
                        
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
                            
                            context.execute("PF('eventDialog').hide();");
                            }else{
                                reserva.setArquivos(arquivos);
                                updateReserva();
                                
                                }  
                        }else{
                            if(ag.getId() == null){
                                getBO().save(ag);
                                postSave(); 
                                
                                context.execute("PF('eventDialog').hide();");
                            }else{
                                reserva.setArquivos(arquivos);
                                updateReserva();
                                } 
                        }
                    }
                }else{
                    if(ag1.getId() == null){
                        ag1.setOrgao(ag1.getLocal().getOrgao());
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

    
    public void carregarReservasPorOrgaoSolicitante() {
        if (filtros.getOrgaoSolicitante() != null) {
            reservas = reservaLocalBO.reservasPorOrgao(filtros.getOrgaoSolicitante());
            
        } else {
            filtros.setReserva(new ReservaLocal());
            reservas = new ArrayList<ReservaLocal>();
        }
    }
    
    public void carregarReservasPorLocal() {
        if (filtros.getLocal() != null) {
            reservas = reservaLocalBO.reservasPorLocais(filtros.getLocal());
        } else {
            filtros.setReserva(new ReservaLocal());
            reservas = new ArrayList<ReservaLocal>();
        }
    }
    
    public void carregarReservasPorDataInicial() {
        if (filtros.getLocal() != null) {
            reservas = reservaLocalBO.reservasPorDataInicial(filtros.getDataInicial());
        } else {
            filtros.setReserva(new ReservaLocal());
            reservas = new ArrayList<ReservaLocal>();
        }
    }
    
    public void carregarReservasPorDataFinal() {
        if (filtros.getLocal() != null) {
            reservas = reservaLocalBO.reservasPorDataFinal(filtros.getDataFinal());
        } else {
            filtros.setReserva(new ReservaLocal());
            reservas = new ArrayList<ReservaLocal>();
        }
    }
    
    public void buscar() {
        
        reservas = reservaLocalBO.listarReservas(filtros);
    }
    
    public List<Orgao> orgaoAutocompletePeloNome(String nome) {
        return getBO().orgaoPeloNome(nome);
    }
    
    public List<LocalReserva> localAutocompletePeloNome(String nome) {
        Orgao orgao = getDAO().getInitialized(usuarioAtual.getOrgao());
        return getBO().localPeloNomeOrgao(nome,orgao);
    }
    
    
}
