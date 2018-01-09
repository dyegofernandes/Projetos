package br.gov.pi.ati.sisforms.mb.monitoramento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.monitoramento.InterrupcaoPontoAcessoBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.TipoDeAcesso;
import br.gov.pi.ati.sisforms.modelo.monitoramento.InterrupcaoPontoAcesso;
import br.gov.pi.ati.sisforms.modelo.vos.RelatorioInterrupcoesVO;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.query.JoinBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
public class InterrupcaoPontoAcessoMB extends AbstractBaseBean<InterrupcaoPontoAcesso> implements Serializable {

    @EJB
    private InterrupcaoPontoAcessoBO interrupcaoPontoAcessoBO;

    private List<Arquivo> arquivos;

    private PontoAcesso ponto = null;

    private TipoDeAcesso tipo = null;

    private Date dataInicial = null;

    private Date dataFinal = null;

    private String numOs = null;

    private String numeroSysaid = null;

    private List<InterrupcaoPontoAcesso> interrupcoes = new ArrayList<InterrupcaoPontoAcesso>();

    public PontoAcesso getPonto() {
        return ponto;
    }

    public void setPonto(PontoAcesso ponto) {
        this.ponto = ponto;
    }

    public TipoDeAcesso getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeAcesso tipo) {
        this.tipo = tipo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNumOs() {
        return numOs;
    }

    public void setNumOs(String numOs) {
        this.numOs = numOs;
    }

    public String getNumeroSysaid() {
        return numeroSysaid;
    }

    public void setNumeroSysaid(String numeroSysaid) {
        this.numeroSysaid = numeroSysaid;
    }

    public List<InterrupcaoPontoAcesso> getInterrupcoes() {
        return interrupcoes;
    }

    public void setInterrupcoes(List<InterrupcaoPontoAcesso> interrupcoes) {
        this.interrupcoes = interrupcoes;
    }

    @Override
    public InterrupcaoPontoAcessoBO getBO() {
        return interrupcaoPontoAcessoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "pontoAcesso.local";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("ipa").leftJoinFetch("ipa.indentificacao", "pontoAcesso");
    }

    @Override
    public void init() {
        buscar();

        if (getEntity().getId() != null) {
            arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
        } else {
            arquivos = new ArrayList<Arquivo>();
        }
    }

    @Override
    public void save() {
        getEntity().setArquivos(arquivos);
        super.save();
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

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public void gerarRelatorioInterrupcoes() {
        buscar();
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logoGovSite.png");
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/atiFundoBranco.png");
        params.put("LOGO_PI", imgLogoPI);
        params.put("LOGO_ATI", imgLogoAti);

        params.put("DATA_ATUAL", Utils.getDataPorExtenso(new Date()));
        params.put("PERIODO", Utils.getPeriodoPorExtenso(dataInicial, dataFinal));

        List<RelatorioInterrupcoesVO> relatorio = new ArrayList<RelatorioInterrupcoesVO>();

        Map<InterrupcaoPontoAcesso, List<InterrupcaoPontoAcesso>> mapaTotal = new TreeMap<InterrupcaoPontoAcesso, List<InterrupcaoPontoAcesso>>(new Comparator<InterrupcaoPontoAcesso>() {
            @Override
            public int compare(InterrupcaoPontoAcesso o1, InterrupcaoPontoAcesso o2) {
                return o1.getIndentificacao().getId().compareTo(o2.getIndentificacao().getId());
            }
        });

        List<InterrupcaoPontoAcesso> interrupcoesTemp = new ArrayList<InterrupcaoPontoAcesso>();

        for (InterrupcaoPontoAcesso interrupcao : interrupcoes) {
            if (!mapaTotal.containsKey(interrupcao)) {
                interrupcoesTemp = new ArrayList<InterrupcaoPontoAcesso>();
                interrupcoesTemp.add(interrupcao);
                mapaTotal.put(interrupcao, interrupcoesTemp);
            } else {
                mapaTotal.get(interrupcao).add(interrupcao);
            }
        }

        for (InterrupcaoPontoAcesso interrupcao : mapaTotal.keySet()) {
            List<InterrupcaoPontoAcesso> lista = mapaTotal.get(interrupcao);

            RelatorioInterrupcoesVO relaTemp = new RelatorioInterrupcoesVO();

            relaTemp.setIdLocal(interrupcao.getIndentificacao().getId());
            relaTemp.setLocal(interrupcao.getIndentificacao().getLocal());

            relaTemp.setQtd_interrupcoes(lista.size());

            BigDecimal tempoTotal = BigDecimal.ZERO;

            for (InterrupcaoPontoAcesso interrupcao2 : lista) {
                tempoTotal = tempoTotal.add(interrupcao2.getTempoInterrupcao());
            }

            relaTemp.setTempoTotal(tempoTotal);
            relaTemp.setObservacoes(lista.get(lista.size() - 1).getObservacoes());
            relaTemp.setNumDaOS(lista.get(lista.size() - 1).getNumeroOrdemServico());
            relatorio.add(relaTemp);
        }

        FacesJasper.createJasperReport(relatorio, params,
                "/WEB-INF/report/relatorios/relatorioInterrupcoes.jasper", "Relatorio_Semanal_Interrupcoes" + ".pdf");
    }

    public void buscar() {
        interrupcoes = getBO().listar(ponto, tipo, dataInicial, dataFinal, numOs, numeroSysaid);
    }

}
