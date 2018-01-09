package br.gov.pi.salvemaria.mb.denuncia;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.bo.denuncia.ArquivoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import br.gov.pi.salvemaria.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
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
import org.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DenunciaPublicaMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    @EJB
    private UnidadeBO unidadeBO;

    @EJB
    private ArquivoBO arquivoBO;

    private Filtros filtro;

    private List<Arquivo> arquivos;

    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private BairroBO bairroBO;

    private Endereco endereco;

    private Cidade cidade;

    private boolean flagTelefone = false;

    private MapModel simpleModel;

    private String ltdZoom = "-5.0920108";

    private String lgtZoom = "-42.8037597";

    private String zoom = "16";

    private String buscaMaps;

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
        endereco = new Endereco();
        arquivos = new ArrayList<Arquivo>();
        simpleModel = new DefaultMapModel();
    }

    @Override
    public void save() {
        getEntity().setEndereco(endereco);
        getEntity().setArquivos(arquivos);
        super.save();
    }

    @Override
    public void postSave() {
        setEntity(new Denuncia());
        endereco = new Endereco();
        arquivos = new ArrayList<Arquivo>();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public String getLtdZoom() {
        return ltdZoom;
    }

    public void setLtdZoom(String ltdZoom) {
        this.ltdZoom = ltdZoom;
    }

    public String getLgtZoom() {
        return lgtZoom;
    }

    public void setLgtZoom(String lgtZoom) {
        this.lgtZoom = lgtZoom;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public void setBuscaMaps(String buscaMaps) {
        this.buscaMaps = buscaMaps;
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

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Cidade> cidades() {
        if (filtro.getCircunscricao() != null) {
            return cidadeBO.cidadePelaCircunscricao(filtro.getCircunscricao());
        }

        return cidadeBO.getDAO().listAll("nome");
    }

    public List<Bairro> getTodosOsBairros() {
        return bairroBO.listarTodos();
    }

    public List<Cidade> getCidades() {
        return cidadeBO.listarCidadePeloEstado(22L);
    }

    public List<Bairro> getBairros() {
        List<Bairro> bairros = null;
        if (cidade != null) {
            bairros = bairroBO.listarBairrosPelaCidade(cidade);
        }

        return bairros;
    }

    public void getLtdAndLgtZoomCidade() throws MalformedURLException, IOException {
        if (cidade != null && getEntity().getEndereco().getBairro() != null) {
            String stringBusca = "";
            String nomeCidade = cidade.getNome().concat(" - PI");
            String nomeLogradouro = "";
            String numeroEndereco = "";
            String referenciaEndereco = "";
            String cepEndereco = "";

            stringBusca = stringBusca.concat(nomeLogradouro.equals("") ? nomeLogradouro : nomeLogradouro.concat(", "))
                    .concat(numeroEndereco.equals("") ? numeroEndereco : numeroEndereco.concat(", "))
                    .concat(referenciaEndereco.equals("") ? referenciaEndereco : referenciaEndereco.concat(", "))
                    .concat(cepEndereco);

            stringBusca = stringBusca.equals("") ? stringBusca.concat(nomeCidade) : stringBusca.concat(", ").concat(nomeCidade);

            URL url = new URL(("http://maps.googleapis.com/maps/api/geocode/json?address=BUSCA_PELO_VALOR&sensor=false".replace("BUSCA_PELO_VALOR", stringBusca.replace(" ", "+"))));
            String stringJson = Utils.pegarRetornoUrlGoogle(url);
            if (stringJson != null) {
                if (!stringJson.equals("")) {
                    JSONObject jsonObjTest = new JSONObject(stringJson);

                    JSONArray jsonArray = jsonObjTest.getJSONArray("results");

                    if (jsonArray.length() > 0) {
                        setLtdZoom(Utils.pegarLatitude(stringJson));
                        setLgtZoom(Utils.pegarLongitude(stringJson));

                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('widgetDetailMaps').show();");
                    }
                }
            }
        } else {
            FacesMessageUtils.error("Cidade e Bairro são obrigatórios!");
        }
    }

    public void getLtdAndLgt() throws MalformedURLException, IOException {
        if (buscaMaps.equals("")) {
            FacesMessageUtils.error("Cidade e Bairro são obrigatórios!");
        } else {
            URL url = new URL(("http://maps.googleapis.com/maps/api/geocode/json?address=BUSCA_PELO_VALOR&sensor=false"
                    .replace("BUSCA_PELO_VALOR", buscaMaps.replace(" ", "+"))));
            String stringJson = Utils.pegarRetornoUrlGoogle(url);
            if (stringJson != null) {
                if (!stringJson.equals("")) {
                    JSONObject jsonObjTest = new JSONObject(stringJson);

                    JSONArray jsonArray = jsonObjTest.getJSONArray("results");

                    if (jsonArray.length() > 0) {
                        setLtdZoom(Utils.pegarLatitude(stringJson));
                        setLgtZoom(Utils.pegarLongitude(stringJson));

                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('widgetDetailMaps').show();");
                    }
                }
            }
        }
    }

    public String getBuscaMaps() {
        buscaMaps = "";
        if (cidade != null && getEntity().getEndereco().getBairro() != null) {
            String bairroECidade = getBO().getDAO().getInitialized(getEntity().getEndereco().getBairro()).getNome()
                    .concat(", ").concat(cidade.getNome().concat(" - PI"));

            if (getEntity().getEndereco().getEndereco() != null) {
                buscaMaps = buscaMaps.concat(getEntity().getEndereco().getEndereco());
                zoom = "17";
            }

            if (!Utils.isNullOrEmpty(getEntity().getEndereco().getNumero())) {
                if (buscaMaps.equals("")) {
                    buscaMaps = buscaMaps.concat(getEntity().getEndereco().getNumero());
                } else {
                    buscaMaps = buscaMaps.concat(", ").concat(getEntity().getEndereco().getNumero());
                }

                zoom = "20";
            }

            if (!Utils.isNullOrEmpty(getEntity().getEndereco().getComplemento())) {
                if (buscaMaps.equals("")) {
                    buscaMaps = buscaMaps.concat(getEntity().getEndereco().getComplemento());
                } else {
                    buscaMaps = buscaMaps.concat(", ").concat(getEntity().getEndereco().getComplemento());
                }
                zoom = "20";
            }

            if (!Utils.isNullOrEmpty(getEntity().getEndereco().getCep())) {
                if (buscaMaps.equals("")) {
                    buscaMaps = buscaMaps.concat(getEntity().getEndereco().getCep());
                } else {
                    buscaMaps = buscaMaps.concat(", ").concat(getEntity().getEndereco().getCep());
                }

                zoom = "16";
            }

            if (buscaMaps.equals("")) {
                buscaMaps = buscaMaps.concat(bairroECidade);
            } else {
                buscaMaps = buscaMaps.concat(", ").concat(bairroECidade);
            }
        }
        return buscaMaps;
    }

    public void pointSelect(PointSelectEvent event) {
        simpleModel = new DefaultMapModel();
        if (event != null) {
            Marker marker = new Marker(event.getLatLng());
            simpleModel.addOverlay(marker);
            getEntity().getEndereco().setLatitude(event.getLatLng().getLat() + "");
            getEntity().getEndereco().setLongitude(event.getLatLng().getLng() + "");
        }
    }

    public void limparBairroEOutrosCampos() {
        getEntity().setEndereco(new Endereco());
    }
}
