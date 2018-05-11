package br.gov.pi.ati.sccd.mb.certificado;

import br.gov.pi.ati.sccd.bo.cadastro.FeriadoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.AgendamentoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.Feriado;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sccd.modelo.enums.HeaderCalendario;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.core.exception.BusinessException;
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
public class AgendamentoCalendarioMB extends AbstractBaseBean<Agendamento> implements Serializable {

    @EJB
    private AgendamentoBO agendamentoBO;

    @EJB
    private FeriadoBO feriadoBO;

    private ScheduleModel eventModel;

    private ItemPedido itemPedido;

    private List<ArquivoAgendamento> arquivos;

    private TipoArquivoAgendamento tipo;

    private boolean comprovanteResidencia;

    private boolean contratoSocial;

    private boolean cnh;

    private boolean cpf;

    private boolean estatuto;

    private boolean leiDeCriacao;

    private boolean nomeacao;

    private boolean oficio;

    private boolean pis;

    private boolean rg;

    private boolean termo;

    private String headerCalendario;

    private Date dataInicial;

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

        headerCalendario = HeaderCalendario.MES.getDescricao();

        dataInicial = new Date();

        pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        eventModel = new DefaultScheduleModel();

        itemPedido = new ItemPedido();

        arquivos = new ArrayList<ArquivoAgendamento>();

        carregarAgenda();

    }

    @Override
    public void save() {
        getEntity().setProtocolo(getProtocolo());
        getEntity().setItemPedido(itemPedido);
        getEntity().setArquivos(arquivos);

        TipoPessoa tipoPessoa = getEntity().getItemPedido().getTipoCertificado().getTipoPessoa();

        if (oficio) {
            if (comprovanteResidencia) {
                if (termo) {
                    if (tipoPessoa == TipoPessoa.FISICA) {
                        if (cnh) {
                            super.save();
                        } else {
                            if (cpf && rg) {
                                super.save();
                            } else {
                                FacesMessageUtils.error("RG e CPF são obrigatórios no caso de não anexar a CNH!!!");
                            }
                        }
                    } else {
                        
                    }
                } else {
                    FacesMessageUtils.error("Termo de Titularidade e Responsabilidade é obrigatório!");
                }
            } else {
                if (tipoPessoa == TipoPessoa.FISICA) {
                    FacesMessageUtils.error("Comprovante de Endereço é obrigatório!");
                } else {
                    FacesMessageUtils.error("Comprovante de Endereço do Representante Legal é obrigatório!");
                }
            }
        } else {
            if (tipoPessoa == TipoPessoa.FISICA) {
                FacesMessageUtils.error("Ofício de Solicitação do Certificado Digital contendo o nome e CPF do titular é obrigatório!");
            } else {
                FacesMessageUtils.error("Ofício de Solicitação do Certificado Digital contendo o nome e o CNPJ da pessoa Jurídica, nome e CPF do representante legal é obrigatório!");
            }

        }

    }

    @Override
    public void postSave() {

        pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        carregarAgenda();

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetAgendamento').hide();");

        try {
            getBO().enviarEmail(TipoAssuntoEmail.SOLICITACAO_AGENDAMENTO, getEntity());
            FacesMessageUtils.info("Solicitação de Agendamento enviado para o email: ".concat(getEntity().getEmail()));
        } catch (BusinessException ex) {
            Logger.getLogger(AgendamentoCalendarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public void onDateSelect(SelectEvent selectEvent) {

        setEntity(new Agendamento());

        Date dataSolicitada = (Date) selectEvent.getObject();

        Feriado feriado = feriadoBO.feriadoPelaData(dataSolicitada);

        Calendar dataSolicitadaZerada = Calendar.getInstance();
        dataSolicitadaZerada.setTime(dataSolicitada);
        dataSolicitadaZerada.set(Calendar.HOUR_OF_DAY, 0);
        dataSolicitadaZerada.set(Calendar.MINUTE, 0);
        dataSolicitadaZerada.set(Calendar.SECOND, 0);
        dataSolicitadaZerada.set(Calendar.MILLISECOND, 0);

        if (feriado != null) {
            FacesMessageUtils.error(feriado.getDescricao());
        } else {
            if (verificarHoraZerada(dataSolicitada)) {
                Calendar dataAtualZerada = Calendar.getInstance();
                dataAtualZerada.setTime(new Date());
                dataAtualZerada.set(Calendar.HOUR_OF_DAY, 0);
                dataAtualZerada.set(Calendar.MINUTE, 0);
                dataAtualZerada.set(Calendar.SECOND, 0);
                dataAtualZerada.set(Calendar.MILLISECOND, 0);

                boolean passado = dataSolicitadaZerada.getTime().before(dataAtualZerada.getTime());
                if (passado) {
                    FacesMessageUtils.error("Reservas não pode ser feita para datas ou horários passados!!");
                } else {
                    headerCalendario = HeaderCalendario.DIA.getDescricao();
                    dataInicial = dataSolicitada;
                    carregarAgenda();
                }

            } else {
                RequestContext context = RequestContext.getCurrentInstance();

                if (dataSolicitada.before(new Date())) {
                    FacesMessageUtils.error("Reservas não pode ser feita para datas ou horários passados!!");
                } else {

                    getEntity().setDataInicial(dataSolicitada);
                    Calendar calendario = Calendar.getInstance();
                    calendario.setTime(dataSolicitada);
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
                FacesMessageUtils.error("Tipo de Arquivo: ".concat(tipo.getDescricao()).concat(" já foi adicionado!"));
            } else {
                verificarTipoArquivoAdd(tipo, true);
                arquivos.add(arquivo);
                tipo = null;

            }
        } else {
            FacesMessageUtils.error("Informe o tipo de Arquivo!");
        }

    }

    public void removerArquivo(ArquivoAgendamento arquivo) {
        verificarTipoArquivoAdd(arquivo.getTipo(), false);
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

    private void verificarTipoArquivoAdd(TipoArquivoAgendamento tipo, boolean boleano) {
        nomeacao = tipo == TipoArquivoAgendamento.NOMEACAO_DIARIO_OFICIAL;
        leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        switch (tipo.getNum()) {
            case 1:
                comprovanteResidencia = boleano;
                break;
            case 2:
                contratoSocial = boleano;
                break;
            case 3:
                cnh = boleano;
                break;
            case 4:
                cpf = boleano;
                break;
            case 5:
                estatuto = boleano;
                break;
            case 6:
                leiDeCriacao = boleano;
                break;
            case 7:
                nomeacao = boleano;
                break;
            case 8:
                oficio = boleano;
                break;
            case 9:
                pis = boleano;
                break;
            case 10:
                rg = boleano;
                break;
            case 11:
                termo = boleano;
                break;

        }

    }

    public void carregarAgenda() {
        List<Agendamento> agendamentos = getBO().agendamentosPelaData(new Date(), null);

        eventModel = new DefaultScheduleModel();

        for (Agendamento agendamento : agendamentos) {
            ScheduleEvent eventTemp = new DefaultScheduleEvent("Reservado", agendamento.getDataInicial(), agendamento.getDataFinal());
            eventModel.addEvent(eventTemp);
        }
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
