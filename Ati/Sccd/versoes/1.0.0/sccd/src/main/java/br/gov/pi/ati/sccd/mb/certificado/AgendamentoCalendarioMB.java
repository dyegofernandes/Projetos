package br.gov.pi.ati.sccd.mb.certificado;

import br.gov.pi.ati.sccd.bo.cadastro.FeriadoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.AgendamentoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.Contato;
import br.gov.pi.ati.sccd.modelo.cadastro.Feriado;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoArquivoAgendamento;
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
public class AgendamentoCalendarioMB extends AbstractBaseBean<Agendamento> implements Serializable {
    
    @EJB
    private AgendamentoBO agendamentoBO;
    
    @EJB
    private FeriadoBO feriadoBO;
    
    private ScheduleModel eventModel;
    
    private ItemPedido itemPedido;
    
    private List<Contato> contatos;
    
    private Contato contatoAdd;
    
    private List<ArquivoAgendamento> arquivos;
    
    private TipoArquivoAgendamento tipo;
    
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
        
        carregarAgenda();
        
    }
    
    @Override
    public void save() {
        getEntity().setProtocolo(getProtocolo());
        getEntity().setItemPedido(itemPedido);
        getEntity().setArquivos(arquivos);
        getEntity().setContatos(contatos);
        
        super.save();
    }
    
    @Override
    public void postSave() {
        carregarAgenda();
        
        RequestContext context = RequestContext.getCurrentInstance();
        
        context.execute("PF('widgetAgendamento').hide();");
        
        FacesMessageUtils.info("Solicitação de Agendamento enviado para o email: ".concat(getEntity().getEmail()));
        
        super.postSave();
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
    
    public List<Contato> getContatos() {
        return contatos;
    }
    
    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
    public Contato getContatoAdd() {
        return contatoAdd;
    }
    
    public void setContatoAdd(Contato contatoAdd) {
        this.contatoAdd = contatoAdd;
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
    
    public void onEventSelect(SelectEvent selectEvent) {
        FacesMessageUtils.error("Horário Reservado!!");
    }
    
    public void onDateSelect(SelectEvent selectEvent) {
        
        setEntity(new Agendamento());
        
        RequestContext context = RequestContext.getCurrentInstance();
        
        Date dataInicial = (Date) selectEvent.getObject();
        
        Feriado feriado = feriadoBO.feriadoPelaData(dataInicial);
        
        if (feriado != null) {
            FacesMessageUtils.error(feriado.getDescricao());
        } else {
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
                    getEntity().setSituacao(SituacaoAgendamento.NAO_CONFIRMADO);
                    
                    context.execute("PF('widgetAgendamento').show();");
                }
            }
        }
        
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
            
            protocolo = protocolo.concat(Utils.inserirZeroAEsquerda(sequencial.toString(), 6)).concat("/");
            
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
        
        if (tipo != null) {
            ArquivoAgendamento arquivo = new ArquivoAgendamento();
            UploadedFile uploadedFile = event.getFile();
            arquivo.setNome(uploadedFile.getFileName());
            arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
            String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
            arquivo.setConteudo(base64AsString);
            arquivo.setTipo(tipo);
            arquivos.add(arquivo);
            tipo = null;
        } else {
            FacesMessageUtils.error("Informe o tipo de Arquivo!");
        }
        
    }
    
    public void removerArquivo(ArquivoAgendamento arquivo) {
        arquivos.remove(arquivo);
    }
    
    private boolean arquivoJahAdicionado(ArquivoAgendamento arquivo) {
        for (ArquivoAgendamento arq : arquivos) {
            if (arquivo.getTipo().equals(arquivo.getTipo())) {
                return true;
            }
        }
        return false;
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
    
    private void carregarAgenda() {
        List<Agendamento> agendamentos = getBO().agendamentosPelaData(new Date(), null);
        
        eventModel = new DefaultScheduleModel();
        
        for (Agendamento agendamento : agendamentos) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent("Reservado", agendamento.getDataInicial(), agendamento.getDataFinal());
            eventModel.addEvent(eventTemp);
        }
    }
}
