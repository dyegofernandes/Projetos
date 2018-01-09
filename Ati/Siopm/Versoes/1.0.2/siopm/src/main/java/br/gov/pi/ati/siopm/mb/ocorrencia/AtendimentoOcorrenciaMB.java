/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.mb.ocorrencia;

import br.gov.pi.ati.siopm.bo.cadastro.NaturezaOcorrenciaBO;
import br.gov.pi.ati.siopm.bo.cadastro.OpcBO;
import br.gov.pi.ati.siopm.bo.cadastro.OpmBO;
import br.gov.pi.ati.siopm.bo.cadastro.ParametroSistemaBO;
import br.gov.pi.ati.siopm.bo.cadastro.PoligonoBO;
import br.gov.pi.ati.siopm.bo.cadastro.ResultadoOcorrenciaBO;
import br.gov.pi.ati.siopm.bo.cadastro.TerritorioBO;
import br.gov.pi.ati.siopm.bo.ocorrencia.OcorrenciaBO;
import br.gov.pi.ati.siopm.constante.Constantes;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Opc;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.ParametroSistema;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.enums.Anonimo;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoChamada;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import br.gov.pi.ati.siopm.util.GeometryUtils;
import br.gov.pi.ati.siopm.util.SessaoUtils;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.Restrictions;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.json.JSONArray;
import org.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
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
public class AtendimentoOcorrenciaMB extends AbstractBaseBean<Ocorrencia> implements Serializable {

    @EJB
    private OcorrenciaBO ocorrenciaBO;

    @EJB
    private NaturezaOcorrenciaBO naturezaBO;

    @EJB
    private ResultadoOcorrenciaBO resultadoBO;

    @EJB
    private PoligonoBO poligoBO;

    @EJB
    private OpmBO opmBO;

    @EJB
    private OpcBO opcBO;

    @EJB
    private TerritorioBO territorioBO;

    @EJB
    private ParametroSistemaBO parametroBO;

    private List<NaturezaOcorrencia> naturezas;

    private NaturezaOcorrencia naturezaAdd = new NaturezaOcorrencia();

    private List<PessoaEnvolvida> pessoasEnvolvidas;

    private PessoaEnvolvida pessoaAdd = new PessoaEnvolvida();

    private List<QualificacaoDeVeiculo> qualificacoesVeiculos;

    private QualificacaoDeVeiculo veiculoEnvolvidoAdd = new QualificacaoDeVeiculo();

    private String logradouro;

    private String latLong = "-5.0903678,-42.8105988";

    private String zoom = "12";

    private Endereco endereco;

    private Endereco enderecoTemp;

    private MapModel simpleModel;

    private List<Solicitante> solicitantes;

    private Solicitante solicitanteAdd;

    private Telefone telefone;

    private List<Ocorrencia> ocorrencias;

    private List<Ocorrencia> ocorrenciasMesma = new ArrayList<Ocorrencia>();

    private List<Organizacao> organizacoes;

    private Ocorrencia ocorrencia;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private ParametroSistema parametroSistema = new ParametroSistema();

    @Override
    public void init() {
        ocorrencia = new Ocorrencia();
        parametroSistema = parametroBO.getDAO().unique("id", 1L);
        solicitanteAdd = new Solicitante();
        solicitantes = new ArrayList<Solicitante>();
        telefone = new Telefone();
        endereco = new Endereco();
        enderecoTemp = new Endereco();
        logradouro = "";

        naturezas = new ArrayList<NaturezaOcorrencia>();
        pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();
        qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();
        organizacoes = new ArrayList<Organizacao>();
        marcaPontos();
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
        recarregarCodigo();
        if (ocorrencia.getClassificacaoChamada() == ClassificacaoChamada.TROTE) {
            ocorrencia.setSituacao(SituacaoOcorrencia.ENCERRADA);
            ocorrencia.setDataEncerramento(new Date());
            ocorrencia.setHoraEncerramento(new Date());
            ocorrencia.setDataAtendimento(new Date());
            ocorrencia.setHoraAtendimento(new Date());

            Restrictions restrictions = new Restrictions();
            restrictions.like("nome", "Trote");
            List<ResultadoOcorrencia> resultados = resultadoBO.getDAO().list(restrictions);

            ocorrencia.setResultados(resultados);

        }
        ocorrencia.setOrganizacoes(organizacoes);
        ocorrencia.setNaturezas(naturezas);
        ocorrencia.setPessoasEnvolvidas(pessoasEnvolvidas);
        ocorrencia.setQualificacoesVeiculos(qualificacoesVeiculos);
        ocorrencia.setEndereco(endereco);

        ocorrencia.setSolicitantes(solicitantes);
        if (ocorrencia.getId() == null) {
            organizacoesPorLatitudeELongitude(endereco.getLatitude(), endereco.getLongitude());
        }
        setEntity(ocorrencia);
        super.save();

    }

    @Override
    public void postSave() {
        latLong = (endereco.getLatitude() + "," + endereco.getLongitude());
        enderecoTemp = new Endereco();
        zoom = "16";
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('widgetOcorrencia').hide();");
        context.execute("PF('widgetListarOcorrencia').hide();");
        context.execute("PF('widgetOcorrenciaUpdate').hide();");
        limparCampos();
        marcaPontos();
        super.postSave();
    }

    public List<String> completeText(String query) throws IOException {

        if (query == null) {
            return null;
        }
        return logradouros(query);
    }

    private List<String> logradouros(String query) throws MalformedURLException, IOException {
        List<String> logradouros = new ArrayList<String>();

        String urlString = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=:BUSCA&key=:KEY";

        URL url = new URL(urlString.replace(":BUSCA", query.replace(" ", "%20")).replace(":KEY", Constantes.CHAVE_API_ATENDIMENTO_GOOGLE_MAPS));

        String retorno = Utils.pegarRetornoUrlGoogle(url);

        JSONObject jsonObjTest = new JSONObject(retorno);

        if (jsonObjTest.getString("status").equals("OK")) {
            JSONArray jsonArray = jsonObjTest.getJSONArray("predictions");
            for (Object jsonArray1 : jsonArray) {
                String logradouroTemp = ((JSONObject) jsonArray1).get("description").toString();
                logradouros.add(logradouroTemp);
            }

        }
        return logradouros;
    }

    public void zoomMaps() throws MalformedURLException, IOException {
        URL url = new URL(Constantes.URL_API_GOOGLE_POR_ENDERECO.concat(logradouro.replace(" ", "%20")));

        String retorno = Utils.pegarRetornoUrlGoogle(url);

        if (retorno != null) {
            JSONObject jsonObjTest = new JSONObject(retorno);

            if (atualizarEndereco(jsonObjTest)) {

                ocorrencia = new Ocorrencia();

                if (GeometryUtils.isPointInsidePolygon(Constantes.getLatitudesPiaui(), Constantes.getLongitudePiaui(), endereco.getLatitude(), endereco.getLongitude())) {

                    recarregarCodigo();
                    ocorrencia.setEndereco(endereco);

                    latLong = (endereco.getLatitude() + "," + endereco.getLongitude());

                    zoom = "15";

                    LatLng latLng = new LatLng(endereco.getLatitude(), endereco.getLongitude());

                    Marker markerZoom = new Marker(latLng, Utils.getAtributosMarcacaoDenuncia(ocorrencia, null, null));
                    markerZoom.setIcon(parametroSistema.getUrlImagens().concat("geral/WARNING_VERDE.png"));
                    markerZoom.setDraggable(true);
                    simpleModel.addOverlay(markerZoom);
                } else {
                    FacesMessageUtils.error("Ocorrência fora da área de jurisdição!");
                }
            }
        }

    }

    public void nova(PointSelectEvent event) throws MalformedURLException, IOException {
        if (event != null) {

            if (GeometryUtils.isPointInsidePolygon(Constantes.getLatitudesPiaui(), Constantes.getLongitudePiaui(), event.getLatLng().getLat(), event.getLatLng().getLng())) {
                String ltdLong = (event.getLatLng().getLat() + "," + event.getLatLng().getLng());
                

                URL url = new URL(Constantes.URL_API_GOOGLE_POR_LTD_LGT.concat(ltdLong));

                String retorno = Utils.pegarRetornoUrlGoogle(url);

                JSONObject jsonObjTest = new JSONObject(retorno);

                if (atualizarEndereco(jsonObjTest)) {
                    
                    ocorrencia = new Ocorrencia();
                    
                    ocorrencia.setEndereco(endereco);

                    recarregarCodigo();

                    ocorrenciasMesma = ocorrenciaBO.ocorrenciasPorBairroEData(endereco.getBairro(), ocorrencia.getDataOcorrencia());

                    latLong = (endereco.getLatitude() + "," + endereco.getLongitude());

                    zoom = "15";

                    LatLng latLng = new LatLng(endereco.getLatitude(), endereco.getLongitude());

                    Marker markerNova = new Marker(latLng, Utils.getAtributosMarcacaoDenuncia(ocorrencia, null, null));
                    markerNova.setIcon(parametroSistema.getUrlImagens().concat("geral/WARNING_VERDE.png"));
                    markerNova.setDraggable(true);
                    simpleModel.addOverlay(markerNova);
                }
            } else {
                FacesMessageUtils.error("Ocorrência fora da área de jurisdição!");
            }

        }
    }

    public void atualizar(OverlaySelectEvent event) throws MalformedURLException, IOException {

        Marker markerTemp = (Marker) event.getOverlay();

        String[] tituloQuebrado = new String[10];
        tituloQuebrado = (markerTemp.getTitle().split(Pattern.quote("\n")));
        String[] id = new String[2];
        id = tituloQuebrado[0].split(Pattern.quote(":"));

        limparCampos();

        if (id[1].equals(" -")) {

            ocorrencia = new Ocorrencia();

            recarregarCodigo();

            String ltdLong = (markerTemp.getLatlng().getLat() + "," + markerTemp.getLatlng().getLng());

            URL url = new URL(Constantes.URL_API_GOOGLE_POR_LTD_LGT.concat(ltdLong));

            String retorno = Utils.pegarRetornoUrlGoogle(url);

            JSONObject jsonObjTest = new JSONObject(retorno);

            if (atualizarEndereco(jsonObjTest)) {
                ocorrenciasMesma = ocorrenciaBO.ocorrenciasPorBairroEData(endereco.getBairro(), ocorrencia.getDataOcorrencia());

                RequestContext context = RequestContext.getCurrentInstance();

                if (ocorrenciasMesma.size() > 0) {
                    context.execute("PF('widgetListarOcorrencia').show();");
                } else {
                    context.execute("PF('widgetOcorrencia').show();");
                }
            }

        } else {
            ocorrencia = getBO().getDAO().unique("id", new Long(id[1].replace(" ", "")));
            carregarListas(ocorrencia);

            markerTemp.setDraggable(false);
            simpleModel.addOverlay(markerTemp);

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('widgetOcorrencia').show();");
        }

    }

    public void novaOcorrenciaList() {
        setEntity(new Ocorrencia());
        ocorrencia = new Ocorrencia();
        recarregarCodigo();
        endereco = enderecoTemp;
        solicitanteAdd = new Solicitante();
        solicitantes = new ArrayList<Solicitante>();
        telefone = new Telefone();
        naturezaAdd = new NaturezaOcorrencia();
        naturezas = new ArrayList<NaturezaOcorrencia>();
        pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();
        pessoaAdd = new PessoaEnvolvida();
        qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();
        ocorrenciasMesma = new ArrayList<Ocorrencia>();
    }

    public void marcaPontos() {
        simpleModel = new DefaultMapModel();
        ocorrencias = getBO().ocorrenciasPelaSituacao(SituacaoOcorrencia.PENDENTE);

        for (Ocorrencia ocorrenciaTemp : ocorrencias) {
            LatLng latLng = new LatLng(ocorrenciaTemp.getEndereco().getLatitude(), ocorrenciaTemp.getEndereco().getLongitude());
            List<NaturezaOcorrencia> naturezaTemp = getBO().getDAO().getInitialized(ocorrenciaTemp.getNaturezas());
            Marker markerTemp = new Marker(latLng, Utils.getAtributosMarcacaoDenuncia(ocorrenciaTemp, naturezaTemp, null));

            if (ocorrenciaTemp.getClassificacaoOcorrencia() == ClassificacaoOcorrencia.POLICIAL_EM_PERIGO
                    || ocorrenciaTemp.getClassificacaoOcorrencia() == ClassificacaoOcorrencia.URGENTE) {
                markerTemp.setIcon(parametroSistema.getUrlImagens().concat("geral/WARNING_VERMELHO.png"));
            } else {
                markerTemp.setIcon(parametroSistema.getUrlImagens().concat("geral/WARNING_AMARELO.png"));
            }
            simpleModel.addOverlay(markerTemp);
        }
    }

    public void moverPonto(MarkerDragEvent event) throws MalformedURLException, IOException {
        Marker markerTemp = event.getMarker();

        ocorrencia = new Ocorrencia();

        String ltdLong = (markerTemp.getLatlng().getLat() + "," + markerTemp.getLatlng().getLng());

        URL url = new URL(Constantes.URL_API_GOOGLE_POR_LTD_LGT.concat(ltdLong));

        String retorno = Utils.pegarRetornoUrlGoogle(url);

        JSONObject jsonObjTest = new JSONObject(retorno);

        atualizarEndereco(jsonObjTest);

        ocorrencia.setEndereco(endereco);

        markerTemp.setTitle(Utils.getAtributosMarcacaoDenuncia(ocorrencia, null, null));

    }

    public void limparCampos() {

        setEntity(new Ocorrencia());
        ocorrencia = new Ocorrencia();
        solicitanteAdd = new Solicitante();
        endereco = new Endereco();
        solicitantes = new ArrayList<Solicitante>();
        telefone = new Telefone();
        naturezaAdd = new NaturezaOcorrencia();
        naturezas = new ArrayList<NaturezaOcorrencia>();
        pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();
        pessoaAdd = new PessoaEnvolvida();
        qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();
        latLong = "-5.0903678,-42.8105988";
        ocorrenciasMesma = new ArrayList<Ocorrencia>();
        zoom = "12";
    }

    public void carregarListas(Ocorrencia ocor) {
        ocorrencia = ocor;
        solicitantes = getBO().getDAO().getInitialized(ocorrencia.getSolicitantes());
        endereco = getBO().getDAO().getInitialized(ocorrencia.getEndereco());
        naturezas = getBO().getDAO().getInitialized(ocorrencia.getNaturezas());
        pessoasEnvolvidas = getBO().getDAO().getInitialized(ocorrencia.getPessoasEnvolvidas());
        qualificacoesVeiculos = getBO().getDAO().getInitialized(ocorrencia.getQualificacoesVeiculos());
        organizacoes = getBO().getDAO().getInitialized(ocorrencia.getOrganizacoes());
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
            } else {
                if (json.getString("status").equals("OVER_QUERY_LIMIT")) {
                    FacesMessageUtils.error("Quantidade excessiva por segundos atingida. Tente novamente depois de 10 segundos.");
                }
            }
        }

        return false;
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
            if (Utils.isNullOrEmpty(pessoaAdd.getDescricao())) {
                FacesMessageUtils.error("Descrição da Pessoa Envolvida é obrigatória!");
            } else {
                if (pessoaAdd.getSexo() != null) {
                    pessoasEnvolvidas.add(pessoaAdd);
                    pessoaAdd = new PessoaEnvolvida();
                } else {
                    FacesMessageUtils.error("Sexo da Pessoa Envolvida é obrigatório!");
                }
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

    public void recarregarCodigo() {
        Integer codigoAtual = getBO().getUltimoCodigo(ocorrencia.getAno());
        if (codigoAtual != null) {
            codigoAtual++;
            if (ocorrencia.getId() == null) {
                ocorrencia.setCodigo(codigoAtual);
            }
        }
    }

    private void organizacoesPorLatitudeELongitude(double latidude, double longitude) {
        List<Territorio> territorios = territorioBO.territorioPelasCoordenadas(latidude, longitude);

        List<Opm> opms = opmBO.opmPelosTerritorios(territorios);

        if (opms != null) {
            for (Opm opm : opms) {
                organizacoes.add((Organizacao) opm);
            }
        }

        List<Opc> opcs = opcBO.opcPelosTerritorios(territorios);

        if (opcs != null) {
            for (Opc opc : opcs) {
                organizacoes.add((Organizacao) opc);
            }
        }
    }

    public List<NaturezaOcorrencia> getNaturezasAtivas() {
        return naturezaBO.listarAtivos();
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

    public Solicitante getSolicitanteAdd() {
        return solicitanteAdd;
    }

    public void setSolicitanteAdd(Solicitante solicitanteAdd) {
        this.solicitanteAdd = solicitanteAdd;
    }

    public List<Ocorrencia> getOcorrenciasMesma() {
        return ocorrenciasMesma;
    }

    public void setOcorrenciasMesma(List<Ocorrencia> ocorrenciasMesma) {
        this.ocorrenciasMesma = ocorrenciasMesma;
    }
}
