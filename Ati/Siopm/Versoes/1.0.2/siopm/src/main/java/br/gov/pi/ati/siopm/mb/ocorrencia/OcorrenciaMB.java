package br.gov.pi.ati.siopm.mb.ocorrencia;

import br.gov.pi.ati.siopm.bo.cadastro.NaturezaOcorrenciaBO;
import br.gov.pi.ati.siopm.bo.cadastro.ParametroSistemaBO;
import br.gov.pi.ati.siopm.bo.cadastro.PatrulhaBO;
import br.gov.pi.ati.siopm.bo.cadastro.ResultadoOcorrenciaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.ocorrencia.OcorrenciaBO;
import br.gov.pi.ati.siopm.constante.Constantes;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;
import br.gov.pi.ati.siopm.modelo.cadastro.Arquivo;
import br.gov.pi.ati.siopm.modelo.cadastro.Bombeiro;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.GuardaMunicipal;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediario;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediarioAux;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.ParametroSistema;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.cadastro.PatrulhaAux;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaFederal;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaRodoviariaFederal;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Samu;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Transito;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.enums.Anonimo;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoChamada;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.IconeViatura;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.StatusViaturaEnum;
import br.gov.pi.ati.siopm.modelo.enums.TipoApoio;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaVO;
import br.gov.pi.ati.siopm.util.GeometryUtils;
import br.gov.pi.ati.siopm.util.SessaoUtils;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.json.JSONArray;
import org.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OcorrenciaMB extends AbstractBaseBean<Ocorrencia> implements Serializable {

    @EJB
    private OcorrenciaBO ocorrenciaBO;

    @EJB
    private NaturezaOcorrenciaBO naturezaBO;

    @EJB
    private ResultadoOcorrenciaBO resultadoBO;

    @EJB
    private PatrulhaBO patrulhaBO;

    @EJB
    private ParametroSistemaBO parametroBO;

    private List<NaturezaOcorrencia> naturezas;

    private NaturezaOcorrencia naturezaAdd;

    private PatrulhaAux patrulhaAdd;

    private Patrulha patrulha;

    private List<PatrulhaAux> patrulhas;

    private List<PessoaEnvolvida> pessoasEnvolvidas;

    private PessoaEnvolvida pessoaAdd;

    private List<QualificacaoDeVeiculo> qualificacoesVeiculos;

    private QualificacaoDeVeiculo veiculoEnvolvidoAdd;

    private List<Arma> armas;

    private Arma armaAdd;

    private List<LocalIntermediarioAux> locaisIntermediarios;

    private LocalIntermediarioAux localIntermediarioAdd;

    private List<DrogaOcorrenciaItem> drogas;

    private DrogaOcorrenciaItem drogaAdd;

    private List<ObjetoApreendido> objetos;

    private ObjetoApreendido objetoAdd;

    private List<Arquivo> arquivos;

    private List<ResultadoOcorrencia> resultados;

    private List<Ocorrencia> ocorrenciasMesma = new ArrayList<Ocorrencia>();

    private ResultadoOcorrencia resultadoAdd;

    private String logradouro;

    private String latLong = "-5.0903678,-42.8105988";

    private String zoom = "12";

    private Endereco endereco;

    private MapModel simpleModel;

    private List<Solicitante> solicitantes;

    private Telefone telefone;

    private List<OcorrenciaVO> ocorrencias;

    private Ocorrencia ocorrencia;

    private Solicitante solicitanteAdd;

    private List<SituacaoOcorrencia> situacoes = new ArrayList<SituacaoOcorrencia>(Arrays.asList(SituacaoOcorrencia.values()));

    private List<ClassificacaoChamada> classificoesChamada = new ArrayList<ClassificacaoChamada>(Arrays.asList(ClassificacaoChamada.values()));

    private List<Organizacao> apoios;

    private List<Organizacao> organizacoes;

    private TipoApoio tipoApoio;

    private Organizacao apoio;

    private SituacaoOcorrencia situacaoTemp = null;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private ParametroSistema parametroSistema = new ParametroSistema();

    private Endereco enderecoTemp;

    private FiltrosVO filtros;

    @Override
    public void init() {
        ocorrencias = new ArrayList<OcorrenciaVO>();
        ocorrencia = new Ocorrencia();
        parametroSistema = parametroBO.getDAO().unique("id", 1L);
        solicitantes = new ArrayList<Solicitante>();
        telefone = new Telefone();
        simpleModel = new DefaultMapModel();
        endereco = new Endereco();
        enderecoTemp = new Endereco();
        naturezas = new ArrayList<NaturezaOcorrencia>();
        naturezaAdd = new NaturezaOcorrencia();
        veiculoEnvolvidoAdd = new QualificacaoDeVeiculo();
        pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();
        pessoaAdd = new PessoaEnvolvida();
        qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();
        armas = new ArrayList<Arma>();
        armaAdd = new Arma();
        locaisIntermediarios = new ArrayList<LocalIntermediarioAux>();
        drogas = new ArrayList<DrogaOcorrenciaItem>();
        localIntermediarioAdd = new LocalIntermediarioAux();
        drogaAdd = new DrogaOcorrenciaItem();
        objetoAdd = new ObjetoApreendido();
        objetos = new ArrayList<ObjetoApreendido>();
        patrulhas = new ArrayList<PatrulhaAux>();
        patrulhaAdd = new PatrulhaAux();
        patrulha = new Patrulha();
        arquivos = new ArrayList<Arquivo>();
        resultados = new ArrayList<ResultadoOcorrencia>();
        resultadoAdd = new ResultadoOcorrencia();
        apoio = new Bombeiro();
        apoios = new ArrayList<Organizacao>();
        organizacoes = new ArrayList<Organizacao>();
        tipoApoio = TipoApoio.BOMBEIRO;
        filtros = new FiltrosVO();

    }

    @Override
    public OcorrenciaBO getBO() {
        return ocorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void save() {
        ocorrencia.setNaturezas(naturezas);
        ocorrencia.setPessoasEnvolvidas(pessoasEnvolvidas);
        ocorrencia.setQualificacoesVeiculos(qualificacoesVeiculos);
        ocorrencia.setEndereco(endereco);
        ocorrencia.setSolicitantes(solicitantes);
        ocorrencia.setDrogas(drogas);
        ocorrencia.setArmas(armas);
        ocorrencia.setLocaisIntermediarios(locaisIntermediarios);
        ocorrencia.setObjetos(objetos);
        ocorrencia.setArquivos(arquivos);
        ocorrencia.setResultados(resultados);

        for (Organizacao apoioTemp : apoios) {
            organizacoes.add(apoioTemp);
        }
        ocorrencia.setOrganizacoes(organizacoes);
        ocorrencia.setPatrulhas(patrulhas);

        setEntity(ocorrencia);

        super.save();
    }

    @Override
    public void postSave() {
        latLong = (endereco.getLatitude() + "," + endereco.getLongitude());
        RequestContext context = RequestContext.getCurrentInstance();
        zoom = "16";
        context.execute("PF('widgetOcorrenciaNova').hide();");
        context.execute("PF('widgetListarOcorrencia').hide();");
        context.execute("PF('widgetOcorrenciaUpdate').hide();");

        if (ocorrencia.getSituacao() == SituacaoOcorrencia.ENCERRADA) {
            for (PatrulhaAux patrulhaAux : patrulhas) {
                Patrulha patrulhaTemp = getBO().getDAO().getInitialized(patrulhaAux.getPatrulha());
                patrulhaTemp.setStatus(StatusViaturaEnum.DISPONIVEL);
                patrulhaBO.getDAO().saveOrMerge(patrulhaTemp, true);
            }
        }

        if (ocorrencia.getSituacao() == SituacaoOcorrencia.ENCAMINHADA_VIATURA) {
            for (PatrulhaAux patrulhaAux : patrulhas) {
                Patrulha patrulhaTemp = getBO().getDAO().getInitialized(patrulhaAux.getPatrulha());
                patrulhaTemp.setStatus(StatusViaturaEnum.ATENDENDO);
                patrulhaBO.getDAO().saveOrMerge(patrulhaTemp, true);
            }
        }

        limparCampos();
        super.postSave();
    }

    public void atualizar(OverlaySelectEvent event) throws MalformedURLException, IOException {
        Marker markerTemp = (Marker) event.getOverlay();

        String[] tituloQuebrado = new String[10];
        tituloQuebrado = (markerTemp.getTitle().split(Pattern.quote("\n")));
        String[] id = new String[2];
        id = tituloQuebrado[0].split(Pattern.quote(":"));

        limparCampos();

        ocorrencia = new Ocorrencia();

        if (id[1].equals(" -")) {
            String ltdLong = (markerTemp.getLatlng().getLat() + "," + markerTemp.getLatlng().getLng());
            String urlString = "http://maps.googleapis.com/maps/api/geocode/json?latlng=:BUSCA".replace(":BUSCA", ltdLong);

            recarregarCodigo();

            URL url = new URL(urlString);

            String retorno = Utils.pegarRetornoUrlGoogle(url);

            JSONObject jsonObjTest = new JSONObject(retorno);

            atualizarEndereco(jsonObjTest);

            ocorrencia.setEndereco(endereco);
            ocorrenciasMesma = ocorrenciaBO.ocorrenciasPorBairroEData(endereco.getBairro(), ocorrencia.getDataOcorrencia());

            RequestContext context = RequestContext.getCurrentInstance();

            if (ocorrenciasMesma.size() > 0) {
                context.execute("PF('widgetListarOcorrencia').show();");
            } else {
                context.execute("PF('widgetOcorrenciaNova').show();");
            }
        } else {
            ocorrencia = getBO().getDAO().unique("id", new Long(id[1].replace(" ", "")));

            if (ocorrencia.getSituacao() == SituacaoOcorrencia.PENDENTE) {
                ocorrencia.setSituacao(SituacaoOcorrencia.ENCAMINHADA_VIATURA);
                ocorrencia.setDataAtendimento(new Date());
                ocorrencia.setHoraAtendimento(new Date());
            } else {
                if (ocorrencia.getSituacao() == SituacaoOcorrencia.ENCAMINHADA_VIATURA) {
                    ocorrencia.setSituacao(SituacaoOcorrencia.ENCERRADA);
                    ocorrencia.setDataEncerramento(new Date());
                    ocorrencia.setHoraEncerramento(new Date());
                }
            }

            solicitantes = getBO().getDAO().getInitialized(ocorrencia.getSolicitantes());
            endereco = getBO().getDAO().getInitialized(ocorrencia.getEndereco());
            naturezas = getBO().getDAO().getInitialized(ocorrencia.getNaturezas());
            pessoasEnvolvidas = getBO().getDAO().getInitialized(ocorrencia.getPessoasEnvolvidas());
            qualificacoesVeiculos = getBO().getDAO().getInitialized(ocorrencia.getQualificacoesVeiculos());
            armas = getBO().getDAO().getInitialized(ocorrencia.getArmas());
            drogas = getBO().getDAO().getInitialized(ocorrencia.getDrogas());
            objetos = getBO().getDAO().getInitialized(ocorrencia.getObjetos());
            arquivos = getBO().getDAO().getInitialized(ocorrencia.getArquivos());
            locaisIntermediarios = getBO().getDAO().getInitialized(ocorrencia.getLocaisIntermediarios());
            organizacoes = getBO().getDAO().getInitialized(ocorrencia.getOrganizacoes());

            for (Organizacao organizacao : organizacoes) {
                if (organizacao instanceof Bombeiro || organizacao instanceof Samu || organizacao instanceof Transito) {
                    apoios.add(organizacao);
                }
            }

            resultados = getBO().getDAO().getInitialized(ocorrencia.getResultados());
            patrulhas = getBO().getDAO().getInitialized(ocorrencia.getPatrulhas());

            situacaoTemp = ocorrencia.getSituacao();

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('widgetOcorrencia').show();");
        }

    }

    public void recarregarCodigo() {
        Integer codigoAtual = getBO().getUltimoCodigo(ocorrencia.getAno());
        if (codigoAtual != null) {
            codigoAtual++;
            if (ocorrencia.getId() == null) {
                ocorrencia.setCodigo(codigoAtual);
            }
        }
    }

    public void addSolicitante() {
        if (solicitanteAdd != null) {
            if (solicitanteAdd.getAnonimo() == Anonimo.NAO) {
                if (Utils.isNullOrEmpty(solicitanteAdd.getNome())) {
                    FacesMessageUtils.error("O nome do solicitante é obrigatório!");
                } else {
                    if (Utils.isNullOrEmpty(solicitanteAdd.getTelefone().getNumero())) {
                        FacesMessageUtils.error("O número telefone do solicitante é obrigatório!");
                    } else {
                        solicitantes.add(solicitanteAdd);
                        solicitanteAdd = new Solicitante();
                    }
                }
            } else {
                if (Utils.isNullOrEmpty(solicitanteAdd.getTelefone().getNumero())) {
                    FacesMessageUtils.error("O número telefone do solicitante é obrigatório!");
                } else {
                    solicitantes.add(solicitanteAdd);
                    solicitanteAdd = new Solicitante();
                }
            }

        } else {
            FacesMessageUtils.error("Solicitante é obrigatório!");
        }
    }

    public void removerSolicitante(Solicitante solicitante) {
        solicitantes.remove(solicitante);
    }

    public void addNatureza() {
        if (naturezaAdd != null) {
            if (naturezaJaAdicionada(naturezaAdd)) {
                FacesMessageUtils.error("Natureza já foi adicionada!");
            } else {
                naturezas.add(naturezaAdd);
                naturezaAdd = new NaturezaOcorrencia();
            }
        } else {
            FacesMessageUtils.error("Natureza é obrigatória!");
        }
    }

    private boolean naturezaJaAdicionada(NaturezaOcorrencia natureza) {
        for (NaturezaOcorrencia natureza1 : naturezas) {
            if (natureza1.equals(natureza)) {
                return true;
            }
        }
        return false;
    }

    public void removerNatueza(NaturezaOcorrencia natureza) {
        naturezas.remove(natureza);
    }

    public void addPessoas() {
        if (pessoaAdd != null) {
            if (Utils.isNullOrEmpty(pessoaAdd.getNome())) {
                FacesMessageUtils.error("Nome da Pessoa Envolvida é obrigatório!");
            } else {
                pessoasEnvolvidas.add(pessoaAdd);
                pessoaAdd = new PessoaEnvolvida();
            }

        } else {
            FacesMessageUtils.error("Pessoa Envolvida é obrigatório!");
        }

    }

    public void removerPessoa(PessoaEnvolvida pessoa) {
        pessoasEnvolvidas.remove(pessoa);
    }

    public void addVeiculos() {
        if (veiculoEnvolvidoAdd != null) {
            if (Utils.isNullOrEmpty(veiculoEnvolvidoAdd.getPlaca())) {
                FacesMessageUtils.error("Placa do Veículo é obrigatória!");
            } else {
                qualificacoesVeiculos.add(veiculoEnvolvidoAdd);
                veiculoEnvolvidoAdd = new QualificacaoDeVeiculo();

            }
        } else {
            FacesMessageUtils.error("Veiculo é obrigatório!");
        }

    }

    public void removerVeiculo(QualificacaoDeVeiculo veiculo) {
        qualificacoesVeiculos.remove(veiculo);
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

    public void addDrogas() {
        if (drogaAdd.getDroga() != null) {
            if (!verificarDrogaAdd(drogaAdd.getDroga())) {
                if (drogaAdd.getQuantidade() != null) {
                    if (drogaAdd.getUnidade() != null) {
                        drogas.add(drogaAdd);
                        drogaAdd = new DrogaOcorrenciaItem();
                    } else {
                        FacesMessageUtils.error("Unidade é obrigatória!");
                    }
                } else {
                    FacesMessageUtils.error("Quantidade é obrigatória!");
                }

            } else {
                FacesMessageUtils.error("Droga já foi adicionada!");
            }
        } else {
            FacesMessageUtils.error("Droga é obrigatória!");
        }
    }

    public void removerDroga(DrogaOcorrenciaItem droga) {
        drogas.remove(droga);
    }

    private boolean verificarDrogaAdd(DrogaOcorrencia droga) {
        for (DrogaOcorrenciaItem drogaTemp : drogas) {
            if (droga.equals(drogaTemp.getDroga())) {
                return true;
            }
        }
        return false;
    }

    public void addArma() {
        if (armaAdd.getTipo() != null) {
            if (!Utils.isNullOrEmpty(armaAdd.getNomeModelo())) {
                armas.add(armaAdd);
                armaAdd = new Arma();
            } else {
                FacesMessageUtils.error("Nome da Arma é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Tipo da Arma é obrigatório!");
        }

    }

    public void removerArma(Arma arma) {
        armas.remove(arma);
    }

    public void addlocaisIntermediario() {
        if (localIntermediarioAdd.getLocal() != null) {
            if (localAdicionado(localIntermediarioAdd.getLocal())) {
                FacesMessageUtils.error("Local já foi adicionado!");
            } else {
                if (localIntermediarioAdd.getHoraChegada() != null) {
                    if (localIntermediarioAdd.getHoraSaida() != null) {
                        if (localIntermediarioAdd.getHoraChegada().compareTo(localIntermediarioAdd.getHoraSaida()) > 0) {
                            FacesMessageUtils.error("Hora chegada não pode ser maior que a hora da Saída!");
                        } else {
                            locaisIntermediarios.add(localIntermediarioAdd);
                            localIntermediarioAdd = new LocalIntermediarioAux();
                        }

                    } else {
                        FacesMessageUtils.error("Hora saída é obrigatória!");
                    }
                } else {
                    FacesMessageUtils.error("Hora Chegada é obrigatória!");
                }
            }

        } else {
            FacesMessageUtils.error("Local é obrigatório!");
        }

    }

    public void removerLocalIntermediario(LocalIntermediarioAux local) {
        locaisIntermediarios.remove(local);
    }

    private boolean localAdicionado(LocalIntermediario localTemp) {
        for (LocalIntermediarioAux localAux : locaisIntermediarios) {
            if (localAux.getLocal().equals(localTemp)) {
                return true;
            }
        }
        return false;
    }

    public void addObjeto() {
        if (!Utils.isNullOrEmpty(objetoAdd.getDescricao())) {
            if (objetoJahAdicionado(objetoAdd.getDescricao())) {
                FacesMessageUtils.error("Objeto com essa descrição já foi adicionado!");
            } else {
                if (objetoAdd.getQuantidade() != null) {
                    objetos.add(objetoAdd);
                    objetoAdd = new ObjetoApreendido();
                } else {
                    FacesMessageUtils.error("Quantidade do Objeto é obrigatório!");
                }
            }

        } else {
            FacesMessageUtils.error("Descrição do Objeto é obrigatória!");
        }

    }

    public void removerObjeto(ObjetoApreendido obj) {
        objetos.remove(obj);
    }

    private boolean objetoJahAdicionado(String nome) {
        for (ObjetoApreendido objeto : objetos) {
            if (objeto.getDescricao().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public void addPatrulha() {
        if (patrulha != null) {
            if (!patrulhaJahAdd(patrulha)) {
                if (patrulhaAdd.getDataDespacho() != null && patrulhaAdd.getHoraDespacho() != null) {
                    patrulhaAdd.setPatrulha(patrulha);
                    patrulhas.add(patrulhaAdd);
                    patrulhaAdd = new PatrulhaAux();
                    patrulha = new Patrulha();
                } else {
                    FacesMessageUtils.error("Data e hora do despacho são obrigatórias!");
                }

            } else {
                FacesMessageUtils.error("Patrulha já foi adicionada");
            }

        } else {
            FacesMessageUtils.error("Patrulha é obrigatória");
        }
    }

    public void removerPatrulha(PatrulhaAux patrulha) {
        Patrulha patrulhaTemp = getBO().getDAO().getInitialized(patrulha.getPatrulha());
        patrulhaTemp.setStatus(StatusViaturaEnum.DISPONIVEL);

        patrulhaBO.getDAO().saveOrMerge(patrulhaTemp, true);

        patrulhas.remove(patrulha);
    }

    private boolean patrulhaJahAdd(Patrulha patrulha) {
        for (PatrulhaAux patrulhaTemp : patrulhas) {
            if (patrulha.equals(patrulhaTemp.getPatrulha())) {
                return true;
            }
        }
        return false;
    }

    public void addResultado() {
        if (resultadoAdd != null) {
            if (resultadoJahAdd(resultadoAdd)) {
                FacesMessageUtils.error("Resultado já adicionado");
            } else {
                resultados.add(resultadoAdd);
                resultadoAdd = new ResultadoOcorrencia();
            }
        } else {
            FacesMessageUtils.error("Resultado é obrigatório");
        }
    }

    public void removerResultado(ResultadoOcorrencia resultado) {
        resultados.remove(resultado);
    }

    private boolean resultadoJahAdd(ResultadoOcorrencia resultado) {
        for (ResultadoOcorrencia resultadoTemp : resultados) {
            if (resultadoTemp.equals(resultado)) {
                return true;
            }
        }
        return false;
    }

    private boolean atualizarEndereco(JSONObject json) {
        if (json != null) {
            if (json.getString("status").equals("OK")) {
                endereco = new Endereco();
                enderecoTemp = new Endereco();

                JSONArray jsonArray = json.getJSONArray("results");
                JSONArray enderecoJson = (JSONArray) ((JSONObject) jsonArray.get(0)).get("address_components");

                endereco.setLogradouro(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Endereco"));
                enderecoTemp.setLogradouro(endereco.getLogradouro());

                endereco.setNumero(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Numero"));
                enderecoTemp.setNumero(endereco.getNumero());

                endereco.setBairro(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Bairro"));
                enderecoTemp.setBairro(endereco.getBairro());

                endereco.setCidade(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Cidade"));
                enderecoTemp.setCidade(endereco.getCidade());

                endereco.setEstado(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Estado"));
                enderecoTemp.setEstado(endereco.getEstado());

                endereco.setPais(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Pais"));
                enderecoTemp.setPais(endereco.getPais());

                endereco.setCep(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Cep"));
                enderecoTemp.setCep(endereco.getCep());

                String enderecoFormatado = ((JSONObject) jsonArray.get(0)).get("formatted_address").toString();
                endereco.setEnderecoFormatado(enderecoFormatado);
                enderecoTemp.setEnderecoFormatado(endereco.getEnderecoFormatado());

                JSONObject geometrico = (JSONObject) ((JSONObject) jsonArray.get(0)).get("geometry");
                JSONObject localizacao = (JSONObject) geometrico.get("location");
                endereco.setLatitude(localizacao.getDouble("lat"));
                enderecoTemp.setLatitude(endereco.getLatitude());

                endereco.setLongitude(localizacao.getDouble("lng"));
                enderecoTemp.setLongitude(endereco.getLongitude());

                return true;
            }
        }

        return false;
    }

    public List<SituacaoOcorrencia> getSituacoes() {
        situacoes.remove(SituacaoOcorrencia.PENDENTE);
        return situacoes;
    }

    public List<NaturezaOcorrencia> getNaturezasAtivas() {
        return naturezaBO.listarAtivos();
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public PatrulhaAux getPatrulhaAdd() {
        return patrulhaAdd;
    }

    public void setPatrulhaAdd(PatrulhaAux patrulhaAdd) {
        this.patrulhaAdd = patrulhaAdd;
    }

    public Patrulha getPatrulha() {
        return patrulha;
    }

    public List<Ocorrencia> getOcorrenciasMesma() {
        return ocorrenciasMesma;
    }

    public void setOcorrenciasMesma(List<Ocorrencia> ocorrenciasMesma) {
        this.ocorrenciasMesma = ocorrenciasMesma;
    }

    public Solicitante getSolicitanteAdd() {
        return solicitanteAdd;
    }

    public void setSolicitanteAdd(Solicitante solicitanteAdd) {
        this.solicitanteAdd = solicitanteAdd;
    }

    public void setPatrulha(Patrulha patrulha) {
        this.patrulha = patrulha;
    }

    public List<ResultadoOcorrencia> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoOcorrencia> resultados) {
        this.resultados = resultados;
    }

    public ResultadoOcorrencia getResultadoAdd() {
        return resultadoAdd;
    }

    public void setResultadoAdd(ResultadoOcorrencia resultadoAdd) {
        this.resultadoAdd = resultadoAdd;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<NaturezaOcorrencia> getNaturezas() {
        return naturezas;
    }

    public void setNaturezas(List<NaturezaOcorrencia> naturezas) {
        this.naturezas = naturezas;
    }

    public NaturezaOcorrencia getNaturezaAdd() {
        return naturezaAdd;
    }

    public void setNaturezaAdd(NaturezaOcorrencia naturezaAdd) {
        this.naturezaAdd = naturezaAdd;
    }

    public List<PatrulhaAux> getPatrulhas() {
        return patrulhas;
    }

    public void setPatrulhas(List<PatrulhaAux> patrulhas) {
        this.patrulhas = patrulhas;
    }

    public List<PessoaEnvolvida> getPessoasEnvolvidas() {
        return pessoasEnvolvidas;
    }

    public void setPessoasEnvolvidas(List<PessoaEnvolvida> pessoasEnvolvidas) {
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }

    public PessoaEnvolvida getPessoaAdd() {
        return pessoaAdd;
    }

    public void setPessoaAdd(PessoaEnvolvida pessoaAdd) {
        this.pessoaAdd = pessoaAdd;
    }

    public List<QualificacaoDeVeiculo> getQualificacoesVeiculos() {
        return qualificacoesVeiculos;
    }

    public void setQualificacoesVeiculos(List<QualificacaoDeVeiculo> qualificacoesVeiculos) {
        this.qualificacoesVeiculos = qualificacoesVeiculos;
    }

    public QualificacaoDeVeiculo getVeiculoEnvolvidoAdd() {
        return veiculoEnvolvidoAdd;
    }

    public void setVeiculoEnvolvidoAdd(QualificacaoDeVeiculo veiculoEnvolvidoAdd) {
        this.veiculoEnvolvidoAdd = veiculoEnvolvidoAdd;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public List<LocalIntermediarioAux> getLocaisIntermediarios() {
        return locaisIntermediarios;
    }

    public void setLocaisIntermediarios(List<LocalIntermediarioAux> locaisIntermediarios) {
        this.locaisIntermediarios = locaisIntermediarios;
    }

    public List<DrogaOcorrenciaItem> getDrogas() {
        return drogas;
    }

    public void setDrogas(List<DrogaOcorrenciaItem> drogas) {
        this.drogas = drogas;
    }

    public List<ObjetoApreendido> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjetoApreendido> objetos) {
        this.objetos = objetos;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public DrogaOcorrenciaItem getDrogaAdd() {
        return drogaAdd;
    }

    public void setDrogaAdd(DrogaOcorrenciaItem drogaAdd) {
        this.drogaAdd = drogaAdd;
    }

    public Arma getArmaAdd() {
        return armaAdd;
    }

    public void setArmaAdd(Arma armaAdd) {
        this.armaAdd = armaAdd;
    }

    public LocalIntermediarioAux getLocalIntermediarioAdd() {
        return localIntermediarioAdd;
    }

    public void setLocalIntermediarioAdd(LocalIntermediarioAux localIntermediarioAdd) {
        this.localIntermediarioAdd = localIntermediarioAdd;
    }

    public ObjetoApreendido getObjetoAdd() {
        return objetoAdd;
    }

    public void setObjetoAdd(ObjetoApreendido objetoAdd) {
        this.objetoAdd = objetoAdd;
    }

    public List<OcorrenciaVO> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<OcorrenciaVO> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public List<Patrulha> getPatrulhaAutocomplente() {
        List<Opm> opms = new ArrayList<Opm>();

        for (Organizacao org : organizacoes) {
            if (org instanceof Opm) {
                opms.add((Opm) org);
            }
        }

        if (opms.size() < 1) {
            return null;
        }

        return patrulhaBO.listarPatrulhasDisponiveis(opms);
    }

    public List<Organizacao> getApoios() {
        return apoios;
    }

    public void setApoios(List<Organizacao> apoios) {
        this.apoios = apoios;
    }

    public List<ResultadoOcorrencia> getResultadoOcorrenciaAuto() {
        return resultadoBO.resultadoOcorrenciaAtivos();
    }

    public TipoApoio getTipoApoio() {
        return tipoApoio;
    }

    public void setTipoApoio(TipoApoio tipoApoio) {
        this.tipoApoio = tipoApoio;
    }

    public Organizacao getApoio() {
        return apoio;
    }

    public void setApoio(Organizacao apoio) {
        this.apoio = apoio;
    }

    public List<ClassificacaoChamada> getClassificoesChamada() {

        return classificoesChamada;
    }

    public void mudarSituacaoOcorrencia() {
        if (ocorrencia.getClassificacaoChamada() == ClassificacaoChamada.TROTE) {
            ocorrencia.setSituacao(SituacaoOcorrencia.ENCERRADA);
            ocorrencia.setDataEncerramento(new Date());
            ocorrencia.setHoraEncerramento(new Date());
        } else {
            ocorrencia.setSituacao(situacaoTemp);

            if (situacaoTemp == SituacaoOcorrencia.ENCERRADA) {
                ocorrencia.setDataEncerramento(new Date());
                ocorrencia.setHoraEncerramento(new Date());
            } else {
                ocorrencia.setDataEncerramento(null);
                ocorrencia.setHoraEncerramento(null);
            }

        }
    }

    public void limparCampos() {
        setEntity(new Ocorrencia());
        endereco = new Endereco();
        solicitantes = new ArrayList<Solicitante>();
        telefone = new Telefone();
        armas = new ArrayList<Arma>();
        armaAdd = new Arma();
        arquivos = new ArrayList<Arquivo>();
        drogas = new ArrayList<DrogaOcorrenciaItem>();
        locaisIntermediarios = new ArrayList<LocalIntermediarioAux>();
        naturezaAdd = new NaturezaOcorrencia();
        naturezas = new ArrayList<NaturezaOcorrencia>();
        objetos = new ArrayList<ObjetoApreendido>();
        pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();
        pessoaAdd = new PessoaEnvolvida();
        qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();
        patrulhas = new ArrayList<PatrulhaAux>();
        patrulhaAdd = new PatrulhaAux();
        patrulha = new Patrulha();
        resultados = new ArrayList<ResultadoOcorrencia>();
        resultadoAdd = new ResultadoOcorrencia();
        localIntermediarioAdd = new LocalIntermediarioAux();
        drogaAdd = new DrogaOcorrenciaItem();
        objetoAdd = new ObjetoApreendido();
        apoios = new ArrayList<Organizacao>();
        organizacoes = new ArrayList<Organizacao>();
        ocorrenciasMesma = new ArrayList<Ocorrencia>();
        latLong = "-5.0903678,-42.8105988";
        zoom = "12";
        apoio = new Bombeiro();
        tipoApoio = TipoApoio.BOMBEIRO;
        situacaoTemp = null;
    }

    public void mudarTipoApoio() {
        if (tipoApoio == TipoApoio.BOMBEIRO) {
            apoio = new Bombeiro();
        }

        if (tipoApoio == TipoApoio.SAMU) {
            apoio = new Samu();
        }

        if (tipoApoio == TipoApoio.TRANSITO) {
            apoio = new Transito();
        }

        if (tipoApoio == TipoApoio.GUARDA_MUNICIPAL) {
            apoio = new GuardaMunicipal();
        }

        if (tipoApoio == TipoApoio.POLICIA_RODOVIARIA_FEDERAL) {
            apoio = new PoliciaRodoviariaFederal();
        }

        if (tipoApoio == TipoApoio.POLICIA_FEDERAL) {
            apoio = new PoliciaFederal();
        }
    }

    public void addApoio() {
        if (apoio != null) {
            if (apoioJahAdd(apoio)) {
                FacesMessageUtils.error("Apoio já foi adicionado!");
            } else {
                apoios.add(apoio);
                tipoApoio = TipoApoio.BOMBEIRO;
                apoio = new Bombeiro();
            }

        } else {
            FacesMessageUtils.error("Apoio é obrigatório!");
        }
    }

    public void removerApoio(Organizacao org) {
        apoios.remove(org);
    }

    private boolean apoioJahAdd(Organizacao org) {
        for (Organizacao orgTemp : apoios) {
            if (orgTemp.equals(org)) {
                return true;
            }
        }

        return false;
    }

    public void buscar() {
        ocorrencias = ocorrenciaBO.ocorrencias(filtros);
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public void visualizarOcorrencia(Long id) {
        ocorrencia = ocorrenciaBO.getDAO().find(id);

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetOcorrenciaDetail').show();");
    }

    public void editarOcorrencia(Long id) {
        ocorrencia = ocorrenciaBO.getDAO().find(id);

        if (ocorrencia.getSituacao() == SituacaoOcorrencia.PENDENTE) {
            ocorrencia.setSituacao(SituacaoOcorrencia.ENCAMINHADA_VIATURA);
            ocorrencia.setDataAtendimento(new Date());
            ocorrencia.setHoraAtendimento(new Date());
        } else {
            if (ocorrencia.getSituacao() == SituacaoOcorrencia.ENCAMINHADA_VIATURA) {
                ocorrencia.setSituacao(SituacaoOcorrencia.ENCERRADA);
                ocorrencia.setDataEncerramento(new Date());
                ocorrencia.setHoraEncerramento(new Date());
            }
        }

        solicitantes = getBO().getDAO().getInitialized(ocorrencia.getSolicitantes());
        endereco = getBO().getDAO().getInitialized(ocorrencia.getEndereco());
        naturezas = getBO().getDAO().getInitialized(ocorrencia.getNaturezas());
        pessoasEnvolvidas = getBO().getDAO().getInitialized(ocorrencia.getPessoasEnvolvidas());
        qualificacoesVeiculos = getBO().getDAO().getInitialized(ocorrencia.getQualificacoesVeiculos());
        armas = getBO().getDAO().getInitialized(ocorrencia.getArmas());
        drogas = getBO().getDAO().getInitialized(ocorrencia.getDrogas());
        objetos = getBO().getDAO().getInitialized(ocorrencia.getObjetos());
        arquivos = getBO().getDAO().getInitialized(ocorrencia.getArquivos());
        locaisIntermediarios = getBO().getDAO().getInitialized(ocorrencia.getLocaisIntermediarios());
        organizacoes = getBO().getDAO().getInitialized(ocorrencia.getOrganizacoes());

        for (Organizacao organizacao : organizacoes) {
            if (organizacao instanceof Bombeiro || organizacao instanceof Samu || organizacao instanceof Transito) {
                apoios.add(organizacao);
            }
        }

        resultados = getBO().getDAO().getInitialized(ocorrencia.getResultados());
        patrulhas = getBO().getDAO().getInitialized(ocorrencia.getPatrulhas());

        situacaoTemp = ocorrencia.getSituacao();

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetOcorrencia').show();");
    }
}
