package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.cadastro.ArquivoRelatorioDeViagemBO;
import br.gov.pi.ati.sisforms.bo.formulario.AtividadeRelatorioViagemBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.RelatorioDeViagemBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeViagem;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.AtividadeRelatorioViagem;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import br.gov.pi.ati.sisforms.modelo.vos.AtividadesRelatorioViagensVO;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RelatorioDeViagemMB extends AbstractBaseBean<RelatorioDeViagem> implements Serializable {

    @EJB
    private RelatorioDeViagemBO relatorioDeViagemBO;

    @EJB
    private AtividadeRelatorioViagemBO atividadeBO;

    @EJB
    private ArquivoRelatorioDeViagemBO arquivoBO;

    private List<RelatorioDeViagem> lista = new ArrayList<RelatorioDeViagem>();

    private List<ArquivoRelatorioDeViagem> arquivos;

    private List<ArquivoRelatorioDeViagem> arquivosDeletados;

    private String descricao = null;

    private Date dataAtividade = null;

    private List<AtividadeRelatorioViagem> atividades = new ArrayList<AtividadeRelatorioViagem>();

    private List<AtividadeRelatorioViagem> atividadesDeletadas = new ArrayList<AtividadeRelatorioViagem>();

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosVO filtros = new FiltrosVO();

    @Override
    public void init() {

        if (!usuarioAtual.isSuperUsuario()) {
            filtros.setUsuario(usuarioAtual);
        }

        buscar();

        arquivos = new ArrayList<ArquivoRelatorioDeViagem>();
        arquivosDeletados = new ArrayList<ArquivoRelatorioDeViagem>();
        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
        } else {
            carregarListas(getEntity());
        }
    }

    @Override
    public RelatorioDeViagemBO getBO() {
        return relatorioDeViagemBO;
    }

    @Override
    public void save() {
        if (atividades.size() > 0) {
            super.save();
            for (AtividadeRelatorioViagem atividade : atividades) {
                atividadeBO.getDAO().saveOrMerge(atividade, true);
            }
            for (AtividadeRelatorioViagem atividade : atividadesDeletadas) {
                try {
                    atividadeBO.getDAO().delete(atividade, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(RelatorioDeViagemMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (ArquivoRelatorioDeViagem arquivo : arquivos) {
                arquivoBO.getDAO().saveOrMerge(arquivo, true);
            }
            for (ArquivoRelatorioDeViagem arquivo : arquivosDeletados) {
                try {
                    arquivoBO.getDAO().remove(arquivo, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(RelatorioDeViagemMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesMessageUtils.error("Informe uma ou mais Atividades!");
        }
    }

    @Override
    public void delete() {
        RelatorioDeViagem viagem = relatorioDeViagemBO.getDAO().unique("id", getId());
        List<AtividadeRelatorioViagem> atividadesAseremDeletadas = atividadeBO.getDAO().list("relatorioDeViagem", viagem);

        for (AtividadeRelatorioViagem atividadesAseremDeletada : atividadesAseremDeletadas) {
            try {
                atividadeBO.remove(atividadesAseremDeletada);
            } catch (DeleteException ex) {
                Logger.getLogger(RelatorioDeViagemMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        super.delete();
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void addAtividade() {
        if (descricao != null) {
            if (!descricao.equals("")) {
                if (dataAtividade != null) {
                    AtividadeRelatorioViagem atividade = new AtividadeRelatorioViagem();
                    atividade.setRelatorioDeViagem(getEntity());
                    atividade.setDescricao(descricao);
                    atividade.setDataAtividade(dataAtividade);

                    atividades.add(atividade);

                    descricao = null;
                    dataAtividade = null;
                } else {
                    FacesMessageUtils.error("A data da atividade é obrigatória!");
                }
            } else {
                FacesMessageUtils.error("Descrição da atividade é obrigatória!");
            }
        } else {
            FacesMessageUtils.error("Descrição da atividade é obrigatória!");
        }
    }

    public void removerAtividade(AtividadeRelatorioViagem atividade) {
        if (atividade.getId() != null) {
            atividadesDeletadas.add(atividade);
        }
        atividades.remove(atividade);
    }

    public void carregarAtividades(RelatorioDeViagem viagem) {
        if (viagem != null) {
            atividades = atividadeBO.lista(viagem);
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public List<AtividadeRelatorioViagem> getAtividades() {
        return atividades;
    }

    public List<ArquivoRelatorioDeViagem> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoRelatorioDeViagem> arquivos) {
        this.arquivos = arquivos;
    }

    public void gerarPdf(RelatorioDeViagem form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/piaui_terra_querida.jpg");
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati.jpg");
        String caminhoSubrelatorio = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/report/formulario/");

        carregarAtividades(form);

        params.put("LOGO_PI", imgLogoPI);
        params.put("LOGO_ATI", imgLogoAti);
        params.put("NOME", form.getNome() != null ? "Nome: ".concat(form.getNome()) : "Nome: ");
        params.put("LOTACAO", form.getLotacao() != null ? "Lotação: ".concat(form.getLotacao()) : "Lotação: ");
        params.put("CARGO_OU_FUNCAO", form.getCargoOuFuncao() != null ? "Cargo/Função:".concat(form.getCargoOuFuncao()) : "Cargo/Função: ");
        params.put("CPF", form.getCpf() != null ? "CPF: ".concat(form.getCpf()) : "CPF: ");
        params.put("MATRICULA", form.getMatricula() != null ? "Matricula: ".concat(form.getMatricula()) : "Matricula: ");
        params.put("TRAJETO", form.getTrajeto() != null ? "Trajeto: ".concat(form.getTrajeto()) : "Trajeto: ");
        params.put("DATA_SAIDA", form.getDataSaida() != null ? "Data Saída: ".concat(Utils.convertDateToString(form.getDataSaida(), "dd/MM/yyyy")) : "Data Saída: ");
        params.put("DATA_CHEGATA", form.getDataChegada() != null ? "Data Chegada: ".concat(Utils.convertDateToString(form.getDataChegada(), "dd/MM/yyyy")) : "Data Chegada: ");
        params.put("DURACAO_AFASTAMENTO", form.getDuracaoAfastamento() != null ? "Duração do Afastamento: "
                .concat(form.getDuracaoAfastamento().toString()) : "Duração do Afastamento: ");
        params.put("MODALIDADE", form.getModalidadeDoTransporte() != null ? "Modalidade do Transporte: "
                .concat(form.getModalidadeDoTransporte()) : "Modalidade do Transporte: ");
        params.put("DATA_EMISSAO", form.getDataEmissao() != null ? Utils.convertDateToString(form.getDataEmissao(), "dd/MM/yyyy HH:mm") : "");
        params.put("RELATO_VIAGEM", form.getRelatoViagem() != null ? "Relato da Viagem: ".concat(form.getRelatoViagem()) : "Relato da Viagem:");

        params.put("SUBREPORT_DIR", caminhoSubrelatorio);

        List<AtividadesRelatorioViagensVO> atividadesVO = new ArrayList<AtividadesRelatorioViagensVO>();

        for (AtividadeRelatorioViagem atividadesVO1 : atividades) {
            atividadesVO.add(new AtividadesRelatorioViagensVO(atividadesVO1));
        }

        params.put("ATIVIDADES", atividadesVO);

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/relatorioDeViagens.jasper", "Relatório de Viagens" + ".pdf");

    }

    public void carregarListas(RelatorioDeViagem relatorio) {
        carregarAtividades(relatorio);
        listaDeArquivos(relatorio);
    }

    public void listaDeArquivos(RelatorioDeViagem relatorio) {
        arquivos = arquivoBO.getDAO().list("relatorioDeViagem", relatorio);
    }

    public StreamedContent download(ArquivoRelatorioDeViagem arquivo) throws IOException {

        if (arquivo instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) arquivo;
            arquivo = (ArquivoRelatorioDeViagem) proxy.getHibernateLazyInitializer().getImplementation();
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
        ArquivoRelatorioDeViagem arquivo = new ArquivoRelatorioDeViagem();
        arquivo.setRelatorioDeViagem(getEntity());
        UploadedFile uploadedFile = event.getFile();
        arquivo.setNome(uploadedFile.getFileName());
        arquivo.setExtensao(getExtension(uploadedFile.getFileName()));
        String base64AsString = new String(Base64.encode(uploadedFile.getContents()));
        arquivo.setConteudo(base64AsString);
        arquivos.add(arquivo);
    }

    public void removerArquivo(ArquivoRelatorioDeViagem arquivo) {
        if (arquivo.getId() != null) {
            arquivosDeletados.add(arquivo);
        }

        arquivos.remove(arquivo);
    }

    public List<RelatorioDeViagem> getLista() {
        return lista;
    }

    public void setLista(List<RelatorioDeViagem> lista) {
        this.lista = lista;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public void buscar() {
        lista = getBO().listar(filtros);
    }
}
