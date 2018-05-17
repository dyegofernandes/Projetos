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
import com.xpert.persistence.query.Restrictions;

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
import javax.persistence.TemporalType;
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

    private ScheduleModel eventModel;

    private List<ReservaLocal> reservas;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private Usuario usuarioAtual;

    @Override
    public void init() {

        filtros = new FiltrosVO();

        usuarioAtual = SessaoUtils.getUser();

        Orgao orgao = getDAO().getInitialized(usuarioAtual.getOrgao());
        filtros.setOrgao(orgao);

        locais = getBO().locaisPorOrgao(orgao);
        

        init_reservas();

    }

    public void carregar_arquivos(ReservaLocal reserv) {
        if (reserv.getId() != null) {
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
            getBO().getDAO().remove(getEntity(), true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF(\'eventDialog\').hide();");
            init_reservas();
        } catch (DeleteException ex) {
            Logger.getLogger(ReservaLocalMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void remove_reserva(ReservaLocal reserva) {

        try {
            getBO().getDAO().remove(reserva, true);

            reservas = getBO().listarReservas(filtros);
        } catch (DeleteException ex) {
            Logger.getLogger(ReservaLocalMB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void save() {

        getEntity().setArquivos(arquivos);

        super.save();

    }

    @Override
    public void postSave() {
        RequestContext context = RequestContext.getCurrentInstance();

        String titulo = event.getTitle();
        if (titulo == null) {
            DefaultScheduleEvent newEvent = new DefaultScheduleEvent(getEntity().getTitulo(), getEntity().getDataInicio(), getEntity().getDataFinal(), "emp1");
            eventModel.addEvent(newEvent);
        }

        init_reservas();
        context.execute("PF(\'eventDialog\').hide();");
        super.postSave(); //To change body of generated methods, choose Tools | Templates.

    }

    public void selecionarEvento(SelectEvent selectEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        event = (ScheduleEvent) selectEvent.getObject();

        String titulo = event.getTitle();

        Long id = Long.parseLong(titulo.split(" ")[0]);

        ReservaLocal reserva = getBO().getDAO().getInitialized(getBO().getDAO().unique("id", id));

        setEntity(reserva);
        arquivos = getBO().getDAO().getInitialized(reserva.getArquivos());
        context.execute("PF(\'eventDialog\').show();");

    }
    
    public void selecionarEvento2(SelectEvent selectEvent){
        RequestContext context = RequestContext.getCurrentInstance();
        event = (ScheduleEvent) selectEvent.getObject();

        String titulo = event.getTitle();

        Long id = Long.parseLong(titulo.split(" ")[0]);

        ReservaLocal reserva = getBO().getDAO().getInitialized(getBO().getDAO().unique("id", id));

        setEntity(reserva);
        
        context.execute("PF(\'widgetReservaLocalDetail\').show();");
    }
    
    

    public void selecionarData(SelectEvent selectEvent) {

        RequestContext context = RequestContext.getCurrentInstance();
        Orgao orgao = getDAO().getInitialized(usuarioAtual.getOrgao());
        setEntity(new ReservaLocal());
        
        getEntity().setOrgao(orgao);
        arquivos = new ArrayList<Arquivo>();
        getEntity().setDataInicio((Date) selectEvent.getObject());
        getEntity().setDataFinal((Date) selectEvent.getObject());

        context.execute("PF(\'eventDialog\').show();");
    }

    public void moverEvento(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento Movido", "Dia delta:" + event.getDayDelta() + ", Minuto delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void redimensionarEvento(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento redimensionado", "Dia delta:" + event.getDayDelta() + ", Minuto delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void init_reservas() {
        
        reservas = getBO().listarReservas(filtros);

        eventModel = new DefaultScheduleModel();

        for (ReservaLocal reservax : reservas) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent(reservax.getId()+ " "+reservax.getTitulo() + " - " + reservax.getOrgaoSolicitante(), reservax.getDataInicio(), reservax.getDataFinal(), "emp1");
            eventModel.addEvent(eventTemp);

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

    public boolean validate(ReservaLocal reserva) {

        Date dataHoje = new Date();
        if (reserva.getId() == null) {
            //Verifica se data inicial não é menor que a data atual.
            if (reserva.getDataInicio().before(dataHoje)) {
                FacesMessageUtils.error("A data inicial não pode ser menor que a data atual");
                return false;
            }
            //Verifica se data inicial não é maior que a data final.
            if (reserva.getDataInicio().after(reserva.getDataFinal())) {
                FacesMessageUtils.error("A data inicial não pode ser maior que a data final");
                return false;
            }

            Restrictions restrictions = new Restrictions();
            Restrictions restrictions2 = new Restrictions();
            Restrictions restrictions3 = new Restrictions();
            Restrictions restrictions4 = new Restrictions();
            restrictions.add("local", reserva.getLocal());
            restrictions2.add("local", reserva.getLocal());
            restrictions3.add("local", reserva.getLocal());
            restrictions4.add("local", reserva.getLocal());

            restrictions2.greaterEqualsThan("dataFinal", reserva.getDataFinal(), TemporalType.TIMESTAMP);//Nessas 2 linhas a gente cria o data fim dentro do intervalo 
            restrictions2.lessEqualsThan("dataInicio", reserva.getDataFinal(), TemporalType.TIMESTAMP);

            restrictions3.lessEqualsThan("dataInicio", reserva.getDataInicio(), TemporalType.TIMESTAMP);//Nessas 2 linhas a gente cria o data inicio dentro do intervalo 
            restrictions3.greaterEqualsThan("dataFinal", reserva.getDataInicio(), TemporalType.TIMESTAMP);

            restrictions4.greaterEqualsThan("dataInicio", reserva.getDataInicio(), TemporalType.TIMESTAMP);
            restrictions4.lessEqualsThan("dataFinal", reserva.getDataFinal(), TemporalType.TIMESTAMP);

            List<ReservaLocal> agendamentos = new ArrayList<ReservaLocal>();

            //Verifica se a data Final esta entre uma data já reservada.
            if (getDAO().list(restrictions2) != null) {
                agendamentos = getDAO().list(restrictions2);
            }
            if (agendamentos.size() > 0) {
                FacesMessageUtils.error("Agendamentos não podem conter o mesmo local e a data final estar entre uma data já reservada!");
                return false;
            }
            //Verifica se a data inicial esta entre uma data já reservada.
            if (getDAO().list(restrictions3) != null) {
                agendamentos = getDAO().list(restrictions3);
            }
            if (agendamentos.size() > 0) {
                FacesMessageUtils.error("Agendamentos não podem conter o mesmo local e a data inicial estar entre uma data já reservada!");
                return false;
            }
            //Verifica se a data inicial esta antes e a data final depois de uma data já reservada.
            if (getDAO().list(restrictions4) != null) {
                agendamentos = getDAO().list(restrictions4);
            }
            if (agendamentos.size() > 0) {
                FacesMessageUtils.error("Agendamentos não podem conter o mesmo local e a data inicial estar antes de uma data já reservada e a data final depois!");
                return false;
            }
        }

        return true;
    }

    public void saveAll() throws BusinessException {

        //Esses valores seram usados no loop a seguir
        Calendar ini = Calendar.getInstance();
        ini.setTime(getEntity().getDataInicio());
        Calendar fim = Calendar.getInstance();
        fim.setTime(getEntity().getDataFinal());
        if (validate(getEntity())) {

            RequestContext context = RequestContext.getCurrentInstance();

            //aqui seram criadas as reservas
            for (Date dt = ini.getTime(); ini.before(fim); ini.add(Calendar.DATE, 1), dt = ini.getTime()) {
                //Essa variavél auxiliar está sendo usada para setar o horario final em todas as reservas
                Calendar calfim = Calendar.getInstance();
                calfim.setTime(dt);
                calfim.set(Calendar.HOUR_OF_DAY, fim.get(Calendar.HOUR_OF_DAY));

                //Aqui uma nova reserva surge
                ReservaLocal ag = new ReservaLocal();
                ag.setDataInicio(dt);

                ag.setDataFinal(calfim.getTime());

                ag.setTitulo(getEntity().getTitulo());
                ag.setLocal(getEntity().getLocal());
                ag.setSolicitante(getEntity().getSolicitante());
                ag.setOrgao(getEntity().getOrgao());
                ag.setContato(getEntity().getContato());
                ag.setFone_contato(getEntity().getFone_contato());
                ag.setObservacao(getEntity().getObservacao());
                ag.setOrgaoSolicitante(getEntity().getOrgaoSolicitante());
                ag.setNumero_oficio(getEntity().getNumero_oficio());
                ag.setNumero_protocolo(getEntity().getNumero_protocolo());
                ag.setUsuario(usuarioAtual);

                List<Arquivo> arquivotemp = new ArrayList();
                for (Arquivo arquivo : arquivos) {
                    Arquivo arq = new Arquivo();
                    arq.setConteudo(arquivo.getConteudo());
                    arq.setExtensao(arquivo.getExtensao());
                    arq.setNome(arquivo.getNome());
                    arquivotemp.add(arq);
                }
                ag.setArquivos(arquivotemp);

                //Aqui a reserva será salva
                getDAO().saveOrMerge(ag, true);

            }
            FacesMessageUtils.sucess();
            context.execute("PF('eventDialog').hide();");

        }
        init_reservas();
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
            reservas = reservaLocalBO.reservasPorOrgaoSolicitante(filtros.getOrgaoSolicitante());

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
        return getBO().localPeloNomeOrgao(nome, orgao);
    }
        
    public boolean testeUsuario(){
        if(usuarioAtual.isSuperUsuario()){
            return true;
        }
        
        Usuario user = getDAO().getInitialized(getEntity().getUsuario());
        if(user.equals(usuarioAtual)){
            return  true;
        }
        
        return false;
    }
    
    
    public boolean testeUsuarioList(ReservaLocal reserva){
        if(usuarioAtual.isSuperUsuario()){
            return true;
        }
        
        Usuario user = getDAO().getInitialized(reserva.getUsuario());
        if(user.equals(usuarioAtual)){
            return  true;
        }
        return false;
    }
}
