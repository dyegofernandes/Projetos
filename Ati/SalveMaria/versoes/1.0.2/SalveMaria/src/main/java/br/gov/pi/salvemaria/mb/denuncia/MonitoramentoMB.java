package br.gov.pi.salvemaria.mb.denuncia;

import br.gov.pi.salvemaria.bo.denuncia.ArquivoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.denuncia.DenunciaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.CircunscricaoBairro;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.vos.DenunciaVO;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import br.gov.pi.salvemaria.util.SessaoUtils;
import br.gov.pi.salvemaria.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
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
public class MonitoramentoMB extends AbstractBaseBean<Denuncia> implements Serializable {
    
    @EJB
    private DenunciaBO denunciaBO;
    
    @EJB
    private ArquivoBO arquivoBO;
    
    private List<Arquivo> arquivos;
        
    private MapModel simpleModel;
    
    private MapModel simpleModelRota;
    
    private List<Denuncia> denunciasPanico = new ArrayList<Denuncia>();
    private List<Denuncia> denunciasNormal = new ArrayList<Denuncia>();
    
    private Filtros filtro = new Filtros();
    
    private Usuario usuarioAtual = SessaoUtils.getUser();
    
    private String longitude;
    
    private String latitude;
    
    private Long maiorId = new Long(0);
    
    private boolean denunciaPanico = true;
    
    private boolean denunciaSigilosa = true;
    
    private Situacao situacaoTemp;
    
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
        
        arquivos = new ArrayList<Arquivo>();
        simpleModel = new DefaultMapModel();
        simpleModelRota = new DefaultMapModel();
        
        latitude = "-5.08921";
        longitude = "-42.8016";
        
        Unidade unidade = denunciaBO.getDAO().getInitialized(usuarioAtual.getUnidade());
        getEntity().setUnidade(unidade);
        if (unidade != null) {
            Circunscricao circu = denunciaBO.getDAO().getInitialized(unidade.getCircunscricao());
            CircunscricaoBairro circuBairro = denunciaBO.getDAO().getInitialized(unidade.getCircunscricaoBairro());
            
            if (circuBairro != null) {
                if (circuBairro.getLatitude() != null && circuBairro.getLongitude() != null) {
                    if (!circuBairro.getLatitude().equals("") && !circuBairro.getLongitude().equals("")) {
                        latitude = circuBairro.getLatitude();
                        longitude = circuBairro.getLongitude();
                    }
                }
            } else {
                if (circu != null) {
                    if (circu.getLatitude() != null && circu.getLongitude() != null) {
                        if (!circu.getLatitude().equals("") && !circu.getLongitude().equals("")) {
                            latitude = circu.getLatitude();
                            longitude = circu.getLongitude();
                        }
                    }
                }
            }
            
            denunciaPanico = unidade.getVisualizarDenunciaPanico();
            
            denunciaSigilosa = unidade.getVisualizarDenunciaNormal();
        }
        
        filtro.setUsuario(usuarioAtual);
        
        situacaoTemp = getEntity().getSituacao();
        
        adicionarMarcacao();
    }
    
    @Override
    public void save() {
        
        if ((situacaoTemp == Situacao.NOVA) && getEntity().getSituacao() == Situacao.DENUNCIA_SUBMETIDA) {
            getEntity().setDataAtendimento(new Date());
            getEntity().setHoraAtendimento(new Date());
        }
        
        getEntity().setArquivos(arquivos);
        
        super.save();
        
        adicionarMarcacao();
    }
    
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }
    
    public List<Denuncia> getDenunciasPanico() {
        return denunciasPanico;
    }
    
    public List<Denuncia> getDenunciasNormal() {
        return denunciasNormal;
    }
    
    public boolean isDenunciaPanico() {
        return denunciaPanico;
    }
    
    public boolean isDenunciaSigilosa() {
        return denunciaSigilosa;
    }
    
    public void adicionarMarcacao() {
        denunciasPanico = new ArrayList<Denuncia>();
        denunciasNormal = new ArrayList<Denuncia>();
        filtro.setSituacao(Situacao.NOVA);
        
        List<Denuncia> denuncias = denunciaBO.listar(filtro);
        
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getTipo() == TipoDenuncia.DENUNCIA) {
                denunciasNormal.add(denuncia);
            }
            
            if (denuncia.getTipo() == TipoDenuncia.PANICO) {
                denunciasPanico.add(denuncia);
            }
            
            if (Utils.ltdELgdNaoEhNullo(denuncia)) {
                Marker marker = new Marker(new LatLng(Double.valueOf(denuncia.getEndereco().getLatitude().replace(",", ".")), Double.valueOf(denuncia.getEndereco().getLongitude().replace(",", "."))),
                        Utils.getAtributosMarcacaoDenuncia(denuncia));
                if (denuncia.getTipo() == TipoDenuncia.PANICO) {
                    marker.setIcon("http://maps.google.com/mapfiles/ms/icons/red-dot.png");
                } else {
                    marker.setIcon("http://maps.google.com/mapfiles/ms/icons/yellow-dot.png");
                }
                
                simpleModel.addOverlay(marker);
            }
        }
        
        if (denunciasPanico.size() > 0) {
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("document.getElementById('audio-alerta').play();");
            FacesMessageUtils.error("Alerta de Denúncia!");
        }
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
        outputStream.flush();
        outputStream.close();
        
        return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
    }
    
    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        Arquivo arquivo = new Arquivo();
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
    }
    
    public void salvar() {
        
        if ((situacaoTemp == Situacao.NOVA) && getEntity().getSituacao() == Situacao.DENUNCIA_SUBMETIDA) {
            getEntity().setDataAtendimento(new Date());
            getEntity().setHoraAtendimento(new Date());
        }
        
        getEntity().setArquivos(arquivos);
        
        denunciaBO.getDAO().saveOrMerge(getEntity(), true);
        
    }
    
    public List<Arquivo> getArquivos() {
        return arquivos;
    }
    
    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
    
    public String getCidade() {
        String cidade = null;
        if (getEntity() != null) {
            if (getEntity().getEndereco() != null) {
                Bairro bairro = denunciaBO.getDAO().getInitialized(getEntity().getEndereco().getBairro());
                if (bairro != null) {
                    cidade = denunciaBO.getDAO().getInitialized(bairro.getCidade()).getNome();
                }
            }
        }
        return cidade;
        
    }
    
    public String getLongitude() {
        return longitude;
    }
    
    public String getLatitude() {
        return latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public MapModel getSimpleModelRota() {
        return simpleModelRota;
    }
    
    public void setSimpleModelRota(MapModel simpleModelRota) {
        this.simpleModelRota = simpleModelRota;
    }
    
    public void atenderDenuncia(Denuncia denuncia) throws InterruptedException {
        denuncia.setSituacao(Situacao.DENUNCIA_SUBMETIDA);
        denuncia.setDataAtendimento(new Date());
        denuncia.setHoraAtendimento(new Date());
        
        denuncia.setUnidade(usuarioAtual.getUnidade());
        denunciaBO.getDAO().saveOrMerge(denuncia, true);
        adicionarMarcacao();
        gerarPdf(denuncia);
    }
    
    public void addRota(Denuncia denuncia) {
        if (Utils.ltdELgdNaoEhNullo(denuncia)) {
            simpleModelRota = new DefaultMapModel();
            Marker marcacaoDenuncia = new Marker(new LatLng(Double.valueOf(denuncia.getEndereco().getLatitude()), Double.valueOf(denuncia.getEndereco().getLongitude())),
                    Utils.getAtributosMarcacaoDenuncia(denuncia));
            
            marcacaoDenuncia.setIcon("http://maps.google.com/mapfiles/ms/icons/red-dot.png");
            
            simpleModelRota.addOverlay(marcacaoDenuncia);
            
        } else {
            FacesMessageUtils.error("Não existe latitude e longitude para esta Denúncia!");
        }
    }
    
    public void gerarPdf(Denuncia denuncia) {
        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
        
        params.put("LOGO_POLICIA", caminhoImg.concat("/logoPolicia.png"));
        params.put("LOGO_ATI", caminhoImg.concat("/ati_novo.png"));
        params.put("LOGO_ESTADO", caminhoImg.concat("/brasao2.jpg"));
        params.put("DATA_EMISSAO", Utils.convertDateToString(new Date(), "dd/MM/yyyy HH:mm"));
        params.put("ANO_EMISSAO", Utils.convertDateToString(new Date(), "yyyy"));
        params.put("NOME_USUARIO", "Resp. pelo Registro: ".concat(usuarioAtual.getNome()));
        params.put("ID_USUARIO", usuarioAtual.getId().toString());
        
        List<DenunciaVO> denuncias = new ArrayList<DenunciaVO>();
        
        denuncias.add(new DenunciaVO(denuncia));
        
        FacesJasper.createJasperReport(denuncias, params,
                "/WEB-INF/report/formularioDenuncia.jasper", "Denuncia ".concat(denuncia.getId() + "") + ".pdf");
        
    }
    
}
