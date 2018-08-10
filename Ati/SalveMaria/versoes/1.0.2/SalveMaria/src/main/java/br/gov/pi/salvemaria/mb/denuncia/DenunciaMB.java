package br.gov.pi.salvemaria.mb.denuncia;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
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
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.vos.DenunciaVO;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import br.gov.pi.salvemaria.util.SessaoUtils;
import br.gov.pi.salvemaria.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import static org.apache.commons.io.FilenameUtils.getExtension;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DenunciaMB extends AbstractBaseBean<Denuncia> implements Serializable {

    @EJB
    private DenunciaBO denunciaBO;

    private Filtros filtro;

    private Usuario usuarioAtual;

    private List<Arquivo> arquivos;

    private Situacao situacaoTemp;

    private Endereco endereco = new Endereco();

    private List<Situacao> situacoes = new ArrayList<Situacao>(Arrays.asList(Situacao.values()));

    private List<Denuncia> denuncias;
    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private BairroBO bairroBO;

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

        usuarioAtual = SessaoUtils.getUser();

        denuncias = new ArrayList<Denuncia>();

        filtro = new Filtros();

        filtro.setUnidade(usuarioAtual.getUnidade());

        arquivos = new ArrayList<Arquivo>();

        if (getEntity().getId() != null) {
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
        }

        situacaoTemp = getEntity().getSituacao();
    }

    @Override
    public void save() {

        if (situacaoTemp != getEntity().getSituacao()) {
            if ((situacaoTemp == Situacao.NOVA) && getEntity().getSituacao() == Situacao.DENUNCIA_SUBMETIDA) {
                getEntity().setDataAtendimento(new Date());
                getEntity().setHoraAtendimento(new Date());
            }

            if (situacaoTemp == Situacao.DENUNCIA_SUBMETIDA && (getEntity().getSituacao() == Situacao.DENUNCIA_NEGATIVADA
                    || getEntity().getSituacao() == Situacao.DENUNCIA_POSITIVADA || getEntity().getSituacao() == Situacao.TROTE)
                    || getEntity().getSituacao() == Situacao.DENUNCIA_POSITIVADA_SEM) {
                getEntity().setDataDeFechamento(new Date());
                getEntity().setHoraDeFechamento(new Date());
            }
        }

        getEntity().setEndereco(endereco);
        getEntity().setArquivos(arquivos);

        super.save();
    }

    @Override
    public void postSave() {
//        setEntity(new Denuncia());
//        endereco = new Endereco();
//        arquivos = new ArrayList<Arquivo>();
    }

    @Override
    public void postDelete() {
        buscar();
        super.postDelete(); 
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

    public void removerArquivo(Arquivo arquivo) {
        arquivos.remove(arquivo);
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public Filtros getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtros filtro) {
        this.filtro = filtro;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public List<Bairro> getBairros() {
        if (filtro.getCidade() != null) {
            return bairroBO.bairrosPelaCidade(filtro.getCidade());
        }

        return null;
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

    public void limparBairroEOutrosCampos() {
        getEntity().setEndereco(new Endereco());
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Situacao> getSituacoes() {
        if (getEntity().getId() != null) {
            if (getEntity().getSituacao() == Situacao.NOVA) {
                situacoes.remove(Situacao.DENUNCIA_NEGATIVADA);
                situacoes.remove(Situacao.DENUNCIA_POSITIVADA);
                situacoes.remove(Situacao.DENUNCIA_POSITIVADA_SEM);
//                situacoes.remove(Situacao.NOVA);
                situacoes.remove(Situacao.TROTE);
            } else {
                situacoes.remove(Situacao.NOVA);

            }
        } else {
            situacoes.remove(Situacao.DENUNCIA_NEGATIVADA);
            situacoes.remove(Situacao.DENUNCIA_POSITIVADA);
            situacoes.remove(Situacao.DENUNCIA_POSITIVADA_SEM);
            situacoes.remove(Situacao.DENUNCIA_SUBMETIDA);
            situacoes.remove(Situacao.TROTE);
        }

        return situacoes;
    }

    public void buscar() {
        denuncias = denunciaBO.listar(filtro);
    }
}
