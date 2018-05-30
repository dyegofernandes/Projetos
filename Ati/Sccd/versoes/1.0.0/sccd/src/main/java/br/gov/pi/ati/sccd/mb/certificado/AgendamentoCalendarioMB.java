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
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sccd.modelo.enums.HeaderCalendario;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.util.Utils;
import br.gov.pi.ati.sccd.webservices.inforfolha.ServidorVO;
import br.gov.pi.ati.sccd.webservices.inforfolha.server.ServerWebservices;
import br.gov.pi.ati.sccd.webservices.inforfolha.server.ServerWebservicesPortType;
import com.thoughtworks.xstream.XStream;
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

    private List<TipoArquivoAgendamento> tipos;

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

    private boolean comissionado;

    private String headerCalendario;

    private Date dataInicial;

    private String informativo;

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

        informativo = "";

        tipos = new ArrayList<TipoArquivoAgendamento>();

        headerCalendario = HeaderCalendario.SEMANA.getDescricao();

        dataInicial = new Date();

        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

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

        if (!getEntity().getCliente().isIsento()) {
            if (oficio) {
                if (comprovanteResidencia) {
                    if (termo) {
                        if (tipoPessoa == TipoPessoa.FISICA) {
                            if (comissionado) {
                                if (nomeacao) {
                                    if (cnh) {
                                        super.save();
                                    } else {
                                        if (cpf && rg) {
                                            super.save();
                                        } else {
                                            FacesMessageUtils.error("Anexos com RG e CPF são obrigatórios no caso de não anexar a CNH!!!");
                                        }
                                    }
                                } else {
                                    FacesMessageUtils.error("Anexos com a Nomeação para Comissionado é obrigatória!");
                                }
                            } else {
                                if (cnh) {
                                    super.save();
                                } else {
                                    if (cpf && rg) {
                                        super.save();
                                    } else {
                                        FacesMessageUtils.error("Anexos com RG e CPF são obrigatórios no caso de não anexar a CNH!!!");
                                    }
                                }
                            }

                        } else {
                            if (nomeacao) {
                                if (cnh) {
                                    super.save();
                                } else {
                                    if (cpf && rg) {
                                        super.save();
                                    } else {
                                        FacesMessageUtils.error("Anexos com RG e CPF do representante legal são obrigatórios no caso de não anexar a CNH!!!");
                                    }
                                }
                            } else {
                                FacesMessageUtils.error("Anexos com a Nomeação do Representante Legal é obrigatório!!");
                            }

                        }
                    } else {
                        FacesMessageUtils.error("Anexos com Termo de Titularidade e Responsabilidade é obrigatório!");
                    }
                } else {
                    if (tipoPessoa == TipoPessoa.FISICA) {
                        FacesMessageUtils.error("Anexos com Comprovante de Residência é obrigatório!");
                    } else {
                        FacesMessageUtils.error("Anexos com Comprovante de Residência do Representante Legal é obrigatório!");
                    }
                }
            } else {
                if (tipoPessoa == TipoPessoa.FISICA) {
                    FacesMessageUtils.error("Anexos com Ofício de Solicitação do Certificado Digital contendo o nome e CPF do titular é obrigatório!");
                } else {
                    FacesMessageUtils.error("Anexos com Ofício de Solicitação do Certificado Digital contendo o nome e o CNPJ da pessoa Jurídica, nome e CPF do representante legal é obrigatório!");
                }

            }
        } else {
            if (comprovanteResidencia) {
                if (termo) {
                    if (tipoPessoa == TipoPessoa.FISICA) {
                        if (comissionado) {
                            if (nomeacao) {
                                if (cnh) {
                                    super.save();
                                } else {
                                    if (cpf && rg) {
                                        super.save();
                                    } else {
                                        FacesMessageUtils.error("Anexos com RG e CPF são obrigatórios no caso de não anexar a CNH!!!");
                                    }
                                }
                            } else {
                                FacesMessageUtils.error("Anexos com a Nomeação no Diário Oficial para Comissionado é obrigatória!");
                            }
                        } else {
                            if (cnh) {
                                super.save();
                            } else {
                                if (cpf && rg) {
                                    super.save();
                                } else {
                                    FacesMessageUtils.error("Anexos com RG e CPF são obrigatórios no caso de não anexar a CNH!!!");
                                }
                            }
                        }

                    } else {
                        if (nomeacao) {
                            if (cnh) {
                                super.save();
                            } else {
                                if (cpf && rg) {
                                    super.save();
                                } else {
                                    FacesMessageUtils.error("Anexos com RG e CPF do representante legal são obrigatórios no caso de não anexar a CNH!!!");
                                }
                            }
                        } else {
                            FacesMessageUtils.error("Anexos com a Nomeação do Representante Legal é obrigatório!!");
                        }

                    }
                } else {
                    FacesMessageUtils.error("Anexos com Termo de Titularidade e Responsabilidade é obrigatório!");
                }
            } else {
                if (tipoPessoa == TipoPessoa.FISICA) {
                    FacesMessageUtils.error("Anexos com Comprovante de Residência é obrigatório!");
                } else {
                    FacesMessageUtils.error("Anexos com Comprovante de Residência do Representante Legal é obrigatório!");
                }
            }
        }

    }

    @Override
    public void postSave() {

        tipos = new ArrayList<TipoArquivoAgendamento>();

        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        carregarAgenda();

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetAgendamento').hide();");

        try {
            getBO().enviarEmail(TipoAssuntoEmail.SOLICITACAO_AGENDAMENTO, getEntity());
            FacesMessageUtils.info("Solicitação de Agendamento enviado para os emails informados");
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

    public String getInformativo() {
        return informativo;
    }

    public void setInformativo(String informativo) {
        this.informativo = informativo;
    }

    public void onDateSelect(SelectEvent selectEvent) {

        informativo = "";

        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        setEntity(new Agendamento());

        tipos = new ArrayList<TipoArquivoAgendamento>();

        arquivos = new ArrayList<ArquivoAgendamento>();

        itemPedido = new ItemPedido();

        tipo = null;

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
//                dataAtualZerada.add(Calendar.DAY_OF_MONTH, 1);
                dataAtualZerada.set(Calendar.HOUR_OF_DAY, 0);
                dataAtualZerada.set(Calendar.MINUTE, 0);
                dataAtualZerada.set(Calendar.SECOND, 0);
                dataAtualZerada.set(Calendar.MILLISECOND, 0);

                boolean passado = dataSolicitadaZerada.getTime().before(dataAtualZerada.getTime());
                boolean dataAtual = dataSolicitadaZerada.getTime().equals(dataAtualZerada.getTime());
                if (passado || dataAtual) {
                    if (passado) {
                        FacesMessageUtils.error("Solicitação de Agendamento não pode ser feita para data que já passou!");
                    } else {
                        FacesMessageUtils.error("Solicitação de Agendamento não pode ser feita para data atual!");
                    }
                } else {
                    headerCalendario = HeaderCalendario.DIA.getDescricao();
                    dataInicial = dataSolicitada;
                    carregarAgenda();
                }

            } else {
                RequestContext context = RequestContext.getCurrentInstance();
                Calendar dataAtual = Calendar.getInstance();
                dataAtual.setTime(new Date());
                dataAtual.set(Calendar.HOUR_OF_DAY, 0);
                dataAtual.set(Calendar.MINUTE, 0);
                dataAtual.set(Calendar.SECOND, 0);
                dataAtual.set(Calendar.MILLISECOND, 0);
                boolean passado = dataSolicitadaZerada.getTime().before(dataAtual.getTime());
                boolean atual = dataSolicitadaZerada.getTime().equals(dataAtual.getTime());
                if (passado || atual) {
                    if (passado) {
                        FacesMessageUtils.error("Solicitação de Agendamento não pode ser feita para data que já passou!");
                    } else {
                        FacesMessageUtils.error("Solicitação de Agendamento não pode ser feita para data atual!");
                    }
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

    public void ehComissionado() {
        itemPedido.setNomeTitular(null);
        getEntity().setEmail(null);
        getEntity().setEmailInstitucional(null);
        getEntity().setTelefone(null);
        tipo = null;
        arquivos = new ArrayList<ArquivoAgendamento>();
        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        if (!Utils.isNullOrEmpty(itemPedido.getCpfCnpjTitular())) {
            ServerWebservices servicorService = new ServerWebservices();
            ServerWebservicesPortType servidor = servicorService.getServerWebservicesPort();

            String xmlString = servidor.servidorativoxml(itemPedido.getCpfCnpjTitular());

            ServidorVO servidorVO = new ServidorVO();

            XStream xstreamJason = new XStream();

            xstreamJason.alias("servidor", ServidorVO.class);

            Cliente cliente = getDAO().getInitialized(getEntity().getCliente());

            TipoCertificado tipoTemp = getDAO().getInitialized(itemPedido.getTipoCertificado());

            String xml = ("<?xml version=\"".concat("1.0\"").concat(" encoding=\"").concat("ISO-8859-1\"").concat("?>").concat("\n"));
            if (!xml.equals(xmlString)) {
                servidorVO = (ServidorVO) xstreamJason.fromXML(xmlString);

                itemPedido.setNomeTitular(servidorVO.getNome());

                if (servidorVO.getCategoria().equals("3")) {
                    comissionado = true;

                    if (cliente != null) {
                        if (cliente.isIsento()) {
                            if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                                informativo = getInformativoPF_orgao_isento_commissionado();
                            } else {
                                informativo = getInformativoPJ_orgao_isento();
                            }
                        } else {
                            if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                                informativo = getInformativoPF_orgao_nao_isento_commissionado();
                            } else {
                                informativo = getInformativoPJ_orgao_nao_isento();
                            }

                        }
                    }
                } else {
                    if (cliente != null) {
                        if (cliente.isIsento()) {
                            if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                                informativo = getInformativoPF_orgao_isento();
                            } else {
                                informativo = getInformativoPJ_orgao_isento();
                            }
                        } else {
                            if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                                informativo = getInformativoPF_orgao_nao_isento();
                            } else {
                                informativo = getInformativoPJ_orgao_nao_isento();
                            }

                        }
                    }
                }
            } else {
                if (cliente != null) {
                    if (cliente.isIsento()) {
                        if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                            informativo = getInformativoPF_orgao_isento();
                        } else {
                            informativo = getInformativoPJ_orgao_isento();
                        }
                    } else {
                        if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                            informativo = getInformativoPF_orgao_nao_isento();
                        } else {
                            informativo = getInformativoPJ_orgao_nao_isento();
                        }

                    }
                } else {
                    if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                        informativo = getInformativoPF_orgao_nao_isento();
                    } else {
                        informativo = getInformativoPJ_orgao_nao_isento();
                    }
                }
            }
        }
    }

    public void mudarCliente() {
        itemPedido = new ItemPedido();

        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        getEntity().setEmail(null);
        getEntity().setEmailInstitucional(null);
        getEntity().setItemPedido(null);
        getEntity().setTelefone(null);
        tipo = null;
    }

    public void mudarTipoCertificado() {

        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;

        Cliente cliente = getDAO().getInitialized(getEntity().getCliente());

        TipoCertificado tipoTemp = getDAO().getInitialized(itemPedido.getTipoCertificado());

        if (cliente != null) {
            if (cliente.isIsento()) {
                if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                    informativo = getInformativoPF_orgao_isento();
                } else {
                    informativo = getInformativoPJ_orgao_isento();
                }
            } else {
                if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                    informativo = getInformativoPF_orgao_nao_isento();
                } else {
                    informativo = getInformativoPJ_orgao_nao_isento();
                }

            }
        } else {
            if (tipoTemp.getTipoPessoa() == TipoPessoa.FISICA) {
                informativo = getInformativoPF_orgao_nao_isento();
            } else {
                informativo = getInformativoPJ_orgao_nao_isento();
            }
        }

        itemPedido.setCpfCnpjTitular(null);
        itemPedido.setNomeTitular(null);
        arquivos = new ArrayList<ArquivoAgendamento>();
        getEntity().setEmail(null);
        getEntity().setEmailInstitucional(null);
        getEntity().setItemPedido(null);
        getEntity().setTelefone(null);
        tipo = null;

    }

    public void fecharDetail() {
        comissionado = pis = nomeacao = leiDeCriacao = estatuto = contratoSocial = termo = cnh = rg = cpf = comprovanteResidencia = oficio = false;
        setEntity(new Agendamento());
        itemPedido = new ItemPedido();
        arquivos = new ArrayList<ArquivoAgendamento>();
        tipo = null;
        carregarAgenda();
    }

    private String getInformativoPF_orgao_isento() {
        return "<span bold;\\\\\\\"=\"\\&quot;\\&quot;\">Documentos necessários para o Certificado: <span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Pessoa Física</span></span><div style=\"\\&quot;font-weight:\" normal;\\\"=\"\" normal;\\\\\\\"=\"\\&quot;\\&quot;\"><ul><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Termo de Responsabilidade emitido no endereço: </span><a href=\"http://repositorio.serpro.gov.br/ajuda/usuarios/html/demo_1.html\">Clique Aqui (Tutorial)</a></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Comprovante de Residência (atualizado);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">CNH ou CPF e RG (coloridos).</span></li></ul></div>";
    }

    private String getInformativoPF_orgao_nao_isento() {
        return "<span bold;\\\\\\\"=\"\\&quot;\\&quot;\">Documentos necessários para o Certificado: <span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Pessoa Física</span></span><div style=\"\\&quot;font-weight:\" normal;\\\"=\"\" normal;\\\\\\\"=\"\\&quot;\\&quot;\"><ul><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Termo de Responsabilidade emitido no endereço: </span><a href=\"http://repositorio.serpro.gov.br/ajuda/usuarios/html/demo_1.html\">Clique Aqui (Tutorial)</a></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Comprovante de Residência (atualizado);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">CNH ou CPF e RG (coloridos);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Ofício de Solicitação constando o nome do Titular do Certificado.</span></li></ul></div>";
    }

    private String getInformativoPF_orgao_isento_commissionado() {
        return "<span bold;\\\\\\\"=\"\\&quot;\\&quot;\">Documentos necessários para o Certificado: <span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Pessoa Física</span></span><div style=\"\\&quot;font-weight:\" normal;\\\"=\"\" normal;\\\\\\\"=\"\\&quot;\\&quot;\"><ul><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Termo de Responsabilidade emitido no endereço: </span><a href=\"http://repositorio.serpro.gov.br/ajuda/usuarios/html/demo_1.html\">Clique Aqui (Tutorial)</a></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Comprovante de Residência (atualizado);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">CNH ou CPF e RG (coloridos);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Nomeação no Diário Oficial para os que são comissionados.</span></li></ul></div>";
    }

    private String getInformativoPF_orgao_nao_isento_commissionado() {
        return "<span bold;\\\\\\\"=\"\\&quot;\\&quot;\">Documentos necessários para o Certificado: <span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Pessoa Física</span></span><div style=\"\\&quot;font-weight:\" normal;\\\"=\"\" normal;\\\\\\\"=\"\\&quot;\\&quot;\"><ul><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Termo de Responsabilidade emitido no endereço: </span><a href=\"http://repositorio.serpro.gov.br/ajuda/usuarios/html/demo_1.html\">Clique Aqui (Tutorial)</a></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Comprovante de Residência (atualizado);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">CNH ou CPF e RG (coloridos);</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Ofício de Solicitação constando o nome do Titular do Certificado;</span></li><li><span style=\"\\&quot;font-size:\" 10pt;\\\"=\"\">Nomeação no Diário Oficial para os que são comissionados.</span></li></ul></div>";
    }

    private String getInformativoPJ_orgao_isento() {
        return "<span style=\"\\&quot;font-style:\" normal;=\"\" box-sizing:=\"\" border-box;=\"\" color:=\"\" rgb(51,=\"\" 51,=\"\" 51);=\"\" font-variant-ligatures:=\"\" orphans:=\"\" 2;=\"\" widows:=\"\" font-family:=\"\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Documentos necessários para o Certificado: <span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Pessoa Jurídica</span></span><div style=\"\\&quot;box-sizing:\" border-box;=\"\" color:=\"\" rgb(51,=\"\" 51,=\"\" 51);\\\"=\"\" helvetica=\"\\&quot;\\&quot;\" neue\\\",=\"\\&quot;\\&quot;\" helvetica,=\"\\&quot;\\&quot;\" arial,=\"\\&quot;\\&quot;\" sans-serif;=\"\\&quot;\\&quot;\" font-size:=\"\\&quot;\\&quot;\" 12px;=\"\\&quot;\\&quot;\" font-variant-ligatures:=\"\\&quot;\\&quot;\" normal;=\"\\&quot;\\&quot;\" orphans:=\"\\&quot;\\&quot;\" 2;=\"\\&quot;\\&quot;\" widows:=\"\\&quot;\\&quot;\" 2;\\\"=\"\\&quot;\\&quot;\"><ul><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Comprovante de Residência;</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Termo de Responsabilidade emitido no endereço:&nbsp;</span><span style=\"\\&quot;font-family:\" arial;=\"\" box-sizing:=\"\" border-box;\\\"=\"\"><a href=\"http://repositorio.serpro.gov.br/ajuda/usuarios/html/demo_2.html\">Clique aqui (Tutorial)</a></span><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">;</span></li><li><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">CNH ou RG e CPF do Representante Legal (<span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Colorido</span>);</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Nomeação do Representante Legal;</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Lei de criação, no caso de órgãos públicos, ou contrato social e seus aditivos no caso de entidades privadas;</span></li></ul></div>";
    }

    private String getInformativoPJ_orgao_nao_isento() {
        return "<span style=\"\\&quot;font-style:\" normal;=\"\" box-sizing:=\"\" border-box;=\"\" color:=\"\" rgb(51,=\"\" 51,=\"\" 51);=\"\" font-variant-ligatures:=\"\" orphans:=\"\" 2;=\"\" widows:=\"\" font-family:=\"\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Documentos necessários para o Certificado: <span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Pessoa Jurídica</span></span><div style=\"\\&quot;box-sizing:\" border-box;=\"\" color:=\"\" rgb(51,=\"\" 51,=\"\" 51);\\\"=\"\" helvetica=\"\\&quot;\\&quot;\" neue\\\",=\"\\&quot;\\&quot;\" helvetica,=\"\\&quot;\\&quot;\" arial,=\"\\&quot;\\&quot;\" sans-serif;=\"\\&quot;\\&quot;\" font-size:=\"\\&quot;\\&quot;\" 12px;=\"\\&quot;\\&quot;\" font-variant-ligatures:=\"\\&quot;\\&quot;\" normal;=\"\\&quot;\\&quot;\" orphans:=\"\\&quot;\\&quot;\" 2;=\"\\&quot;\\&quot;\" widows:=\"\\&quot;\\&quot;\" 2;\\\"=\"\\&quot;\\&quot;\"><ul><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Comprovante de Residência;</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Termo de Responsabilidade emitido no endereço:&nbsp;</span><span style=\"\\&quot;font-family:\" arial;=\"\" box-sizing:=\"\" border-box;\\\"=\"\"><a href=\"http://repositorio.serpro.gov.br/ajuda/usuarios/html/demo_2.html\">Clique aqui (Tutorial)</a></span><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">;</span></li><li><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">CNH ou RG e CPF do Representante Legal (<span style=\"\\&quot;font-weight:\" bold;\\\"=\"\">Colorido</span>);</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Nomeação do Representante Lega;</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Lei de criação, no caso de órgãos públicos, ou contrato social e seus aditivos no caso de entidades privadas;</span></li><li style=\"\\&quot;font-style:\" normal;=\"\" font-weight:=\"\" normal;\\\"=\"\"><span style=\"\\&quot;font-family:\" arial;=\"\" font-size:=\"\" small;\\\"=\"\">Ofício de Solicitação.</span></li></ul></div>";
    }
}
