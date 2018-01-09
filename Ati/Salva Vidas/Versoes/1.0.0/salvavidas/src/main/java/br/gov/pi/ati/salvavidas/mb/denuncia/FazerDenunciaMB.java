package br.gov.pi.ati.salvavidas.mb.denuncia;

import br.gov.pi.ati.salvavidas.bo.cadastro.PoligonoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.salvavidas.bo.denuncia.DenunciaBO;
import br.gov.pi.ati.salvavidas.constante.Constantes;
import br.gov.pi.ati.salvavidas.modelo.cadastro.AutorDenuncia;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Denunciado;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Poligono;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Ponto;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Vitima;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Arquivo;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Denuncia;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Endereco;
import br.gov.pi.ati.salvavidas.modelo.enums.Anonimo;
import br.gov.pi.ati.salvavidas.util.GeometryUtils;
import br.gov.pi.ati.salvavidas.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.Restrictions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.json.JSONArray;
import org.primefaces.model.map.MapModel;
import org.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FazerDenunciaMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private PoligonoBO poligoBO;

    private String latLong = "-5.0903678,-42.8105988";

    private String zoom = "12";

    private Endereco endereco;

    private MapModel simpleModel;

    private Poligono piaui = new Poligono();

    private String logradouro;

    private Denuncia denuncia;

    private AutorDenuncia autorDenuncia;

    private List<Vitima> vitimas;

    private Vitima vitimaAdd;

    private List<Denunciado> denunciados;

    private Denunciado denunciadoAdd;

    private List<Arquivo> arquivos;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public List<Vitima> getVitimas() {
        return vitimas;
    }

    public void setVitimas(List<Vitima> vitimas) {
        this.vitimas = vitimas;
    }

    public List<Denunciado> getDenunciados() {
        return denunciados;
    }

    public void setDenunciados(List<Denunciado> denunciados) {
        this.denunciados = denunciados;
    }

    public Vitima getVitimaAdd() {
        return vitimaAdd;
    }

    public void setVitimaAdd(Vitima vitimaAdd) {
        this.vitimaAdd = vitimaAdd;
    }

    public Denunciado getDenunciadoAdd() {
        return denunciadoAdd;
    }

    public void setDenunciadoAdd(Denunciado denunciadoAdd) {
        this.denunciadoAdd = denunciadoAdd;
    }

    public AutorDenuncia getAutorDenuncia() {
        return autorDenuncia;
    }

    public void setAutorDenuncia(AutorDenuncia autorDenuncia) {
        this.autorDenuncia = autorDenuncia;
    }

    @Override
    public DenunciaBO getBO() {
        return denunciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        simpleModel = new DefaultMapModel();
        denuncia = new Denuncia();
        piaui = poligoBO.getDAO().unique("nome", "PIAUÍ");
        endereco = new Endereco();
        arquivos = new ArrayList<Arquivo>();
        vitimas = new ArrayList<Vitima>();
        vitimaAdd = new Vitima();
        denunciados = new ArrayList<Denunciado>();
        denunciadoAdd = new Denunciado();
        autorDenuncia = new AutorDenuncia();
    }

    @Override
    public void save() {
        denuncia.setAutoDenuncia(autorDenuncia);
        denuncia.setEndereco(endereco);
        denuncia.setArquivos(arquivos);
        denuncia.setVitimas(vitimas);
        denuncia.setDenunciados(denunciados);
        setEntity(denuncia);
        super.save();

    }

    @Override
    public void postSave() {
        LatLng latLng = new LatLng(endereco.getLatitude(), endereco.getLongitude());
        Marker marker = new Marker(latLng, Utils.getAtributosMarcacaoDenuncia(denuncia));
        latLong = (endereco.getLatitude() + "," + endereco.getLongitude());
        zoom = "18";
        simpleModel.addOverlay(marker);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('widgetDenuncia').hide();");
        limparCampos();
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

        URL url = new URL(urlString.replace(":BUSCA", query.replace(" ", "%20")).replace(":KEY", Constantes.CHAVE_API_GOOGLE_MAPS));

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
        String urlString = "http://maps.googleapis.com/maps/api/geocode/json?address=:BUSCA";

        URL url = new URL(urlString.replace(":BUSCA", logradouro.replace(" ", "%20")));

        String retorno = Utils.pegarRetornoUrlGoogle(url);

        JSONObject jsonObjTest = new JSONObject(retorno);

        if (jsonObjTest.getString("status").equals("OK")) {
            JSONArray jsonArray = jsonObjTest.getJSONArray("results");
            for (Object jsonArray1 : jsonArray) {
                org.json.JSONObject geometrico = (org.json.JSONObject) ((org.json.JSONObject) jsonArray1).get("geometry");
                org.json.JSONObject localizacao = (org.json.JSONObject) geometrico.get("location");
                latLong = (localizacao.getDouble("lat") + "," + localizacao.getDouble("lng"));
            }
            zoom = "18";
        }
    }

    public void novaOcorrencia(PointSelectEvent event) throws MalformedURLException, IOException {

        if (event != null) {
            denuncia = new Denuncia();

            List<Ponto> pontos = getBO().getDAO().getInitialized(piaui.getPontos());

            int size = pontos.size();

            if (size > 0) {
                double[] x = new double[size];
                double[] y = new double[size];

                for (int i = 0; i < size; i++) {
                    x[i] = pontos.get(i).getLatitude();
                    y[i] = pontos.get(i).getLongitude();
                }
                if (GeometryUtils.isPointInsidePolygon(x, y, event.getLatLng().getLat(), event.getLatLng().getLng())) {
                    String ltdLong = (event.getLatLng().getLat() + "," + event.getLatLng().getLng());
                    String urlString = "http://maps.googleapis.com/maps/api/geocode/json?latlng=:BUSCA".replace(":BUSCA", ltdLong);

                    URL url = new URL(urlString);

                    String retorno = Utils.pegarRetornoUrlGoogle(url);

                    JSONObject jsonObjTest = new JSONObject(retorno);

                    if (jsonObjTest.getString("status").equals("OK")) {
                        JSONArray jsonArray = jsonObjTest.getJSONArray("results");
                        JSONArray enderecoJson = (JSONArray) ((JSONObject) jsonArray.get(0)).get("address_components");

                        endereco.setLogradouro(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Endereco"));
                        endereco.setNumero(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Numero"));
                        endereco.setBairro(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Bairro"));
                        endereco.setCidade(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Cidade"));
                        endereco.setEstado(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Estado"));
                        endereco.setPais(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Pais"));
                        endereco.setCep(Utils.enderecoPorNomeAtributoJson(enderecoJson, "Cep"));

                        String enderecoFormatado = ((JSONObject) jsonArray.get(0)).get("formatted_address").toString();
                        endereco.setEnderecoFormatado(enderecoFormatado);
                        JSONObject geometrico = (JSONObject) ((JSONObject) jsonArray.get(0)).get("geometry");
                        JSONObject localizacao = (JSONObject) geometrico.get("location");
                        endereco.setLatitude(localizacao.getDouble("lat"));
                        endereco.setLongitude(localizacao.getDouble("lng"));

                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('widgetDenuncia').show();");
                    } else {
                        FacesMessageUtils.error("Endereço não localizado!");
                    }
                } else {
                    FacesMessageUtils.error("Ocorrência fora da área de jurisdição!");
                }
            } else {
                FacesMessageUtils.error("Não existe área cadastrada para esse usuário!");
            }
        }

    }

    public void atualizar(OverlaySelectEvent event) {

        Marker marker = (Marker) event.getOverlay();

        Restrictions restrictions = new Restrictions();

        restrictions.add("endereco.latitude", marker.getLatlng().getLat());
        restrictions.add("endereco.longitude", marker.getLatlng().getLng());

        limparCampos();

        denuncia = (Denuncia) getBO().getDAO().getQueryBuilder().from(Denuncia.class, "denuncia").
                leftJoinFetch("denuncia.endereco", "endereco").add(restrictions).getSingleResult();

        autorDenuncia = getBO().getDAO().getInitialized(denuncia.getAutoDenuncia());
        endereco = getBO().getDAO().getInitialized(denuncia.getEndereco());
        arquivos = getBO().getDAO().getInitialized(denuncia.getArquivos());
        vitimas = getBO().getDAO().getInitialized(denuncia.getVitimas());
        denunciados = getBO().getDAO().getInitialized(denuncia.getDenunciados());

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('widgetDenuncia').show();");
    }

    public void limparCampos() {
        denuncia = new Denuncia();
        endereco = new Endereco();
        arquivos = new ArrayList<Arquivo>();
        vitimas = new ArrayList<Vitima>();
        vitimaAdd = new Vitima();
        denunciados = new ArrayList<Denunciado>();
        denunciadoAdd = new Denunciado();
        autorDenuncia = new AutorDenuncia();
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

    public void addVitima() {
        if (vitimaAdd != null) {
            if (Utils.isNullOrEmpty(vitimaAdd.getNome())) {
                FacesMessageUtils.error("Nome da vítima é obrigatório!");
            } else {
                vitimas.add(vitimaAdd);
                vitimaAdd = new Vitima();
            }
        } else {
            FacesMessageUtils.error("Vítima é obrigatória!");
        }
    }

    public void removerVitima(Vitima vitima) {
        vitimas.remove(vitima);
    }

    public void addDenunciado() {
        if (denunciadoAdd != null) {
            if (Utils.isNullOrEmpty(denunciadoAdd.getNome())) {
                FacesMessageUtils.error("Nome da denunciado é obrigatório!");
            } else {
                denunciados.add(denunciadoAdd);
                denunciadoAdd = new Denunciado();
            }

        } else {
            FacesMessageUtils.error("Denunciado é obrigatório!");
        }
    }

    public void removerDenunciado(Denunciado denunciado) {
        denunciados.remove(denunciado);
    }

    public void limparAutor() {
        if (denuncia.getAnomino() == Anonimo.SIM) {
            autorDenuncia = new AutorDenuncia();
        }
    }
}
