package br.gov.pi.ati.agendacultural.mb.eventos;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.eventos.PortfolioBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Arquivo;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Fone;
import br.gov.pi.ati.agendacultural.modelo.enums.DiaSemana;
import br.gov.pi.ati.agendacultural.modelo.eventos.DiaVisitacaoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.HistoricoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.LinkPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.Portfolio;
import br.gov.pi.ati.agendacultural.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
public class PortfolioMB extends AbstractBaseBean<Portfolio> implements Serializable {

    private List<DiaSemana> dias;

    private List<DiaSemana> diasSelected;

    private Date horaInicial;

    private Date horaFinal;

    private List<DiaVisitacaoPortfolio> diasVisitacao;

    private List<Arquivo> imagens;

    private List<HistoricoPortfolio> historicos;

    private List<LinkPortfolio> links;

    private Fone foneAdd;

    private List<Fone> fones;

    private HistoricoPortfolio historicoAdd;

    private LinkPortfolio linkAdd;

    private Endereco endereco;

    @EJB
    private PortfolioBO portfolioBO;

    @Override
    public PortfolioBO getBO() {
        return portfolioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        foneAdd = new Fone();
        fones = new ArrayList<Fone>();
        dias = Arrays.asList(DiaSemana.values());
        diasSelected = new ArrayList<DiaSemana>();
        diasVisitacao = new ArrayList<DiaVisitacaoPortfolio>();
        imagens = new ArrayList<Arquivo>();
        historicos = new ArrayList<HistoricoPortfolio>();
        historicoAdd = new HistoricoPortfolio();
        links = new ArrayList<LinkPortfolio>();
        linkAdd = new LinkPortfolio();
        endereco = new Endereco();

        if (getEntity().getId() != null) {
            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
            diasVisitacao = getBO().getDAO().getInitialized(getEntity().getDiaHoraVisitacao());
            imagens = getBO().getDAO().getInitialized(getEntity().getArquivos());
            links = getBO().getDAO().getInitialized(getEntity().getLinks());
            historicos = getBO().getDAO().getInitialized(getEntity().getHistoricos());
            fones = getBO().getDAO().getInitialized(getEntity().getFones());
        }
    }

    @Override
    public void save() {
        getEntity().setEndereco(endereco);
        getEntity().setDiaHoraVisitacao(diasVisitacao);
        getEntity().setArquivos(imagens);
        getEntity().setLinks(links);
        getEntity().setHistoricos(historicos);
        getEntity().setFones(fones);
        super.save();
    }

    public void addDias() {
        if (diasSelected.size() > 0) {
            if (horaInicial != null && horaFinal != null) {
                if (horaInicial.after(horaFinal) || horaInicial.equals(horaFinal)) {
                    FacesMessageUtils.error("Hora inicial deve ser menor que a hora final!");
                } else {
                    for (DiaSemana dia : diasSelected) {
                        DiaVisitacaoPortfolio diaAdd = new DiaVisitacaoPortfolio();
                        diaAdd.setDiaSemana(dia);
                        diaAdd.setHorarioFinal(horaFinal);
                        diaAdd.setHorarioInicial(horaInicial);

                        diasVisitacao.add(diaAdd);
                    }

                    diasSelected = new ArrayList<DiaSemana>();
                    horaFinal = null;
                    horaInicial = null;
                }
            } else {
                FacesMessageUtils.error("Hora inicial e Final são obrigatórias!");
            }
        } else {
            FacesMessageUtils.error("Seleciona ao menos um dia!");
        }
    }

    public void removerDia(DiaVisitacaoPortfolio dia) {
        diasVisitacao.remove(dia);
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
        imagens.add(arquivo);
    }

    private void criarArquivo() {

    }

    public void removerArquivo(Arquivo arquivo) {
        imagens.remove(arquivo);
    }

    public void addHistorico() {
        if (historicoAdd != null) {
            if (Utils.isNullOrEmpty(historicoAdd.getHistorico())) {
                FacesMessageUtils.error("Descrição do Histórico obrigatória!");
            } else {
                historicos.add(historicoAdd);
                historicoAdd = new HistoricoPortfolio();
            }
        } else {
            FacesMessageUtils.error("Histórico é obrigatório!");
        }
    }

    public void removerHistorico(HistoricoPortfolio historico) {
        historicos.remove(historico);
    }

    public void addLink() {
        if (linkAdd != null) {
            if (Utils.isNullOrEmpty(linkAdd.getDescricaoLink())) {
                FacesMessageUtils.error("Descrição do Link obrigatória!");
            } else {
                if (Utils.isNullOrEmpty(linkAdd.getLink())) {
                    FacesMessageUtils.error("Link é obrigatório!");
                } else {
                    links.add(linkAdd);
                    linkAdd = new LinkPortfolio();
                }
            }
        } else {
            FacesMessageUtils.error("Link é obrigatório!");
        }
    }

    public void removerLink(LinkPortfolio link) {
        links.remove(link);
    }

    public void addFones() {
        if (Utils.isNullOrEmpty(foneAdd.getDdd())) {
            FacesMessageUtils.error("DDD é Obrigatório!");
        } else {
            if (Utils.isNullOrEmpty(foneAdd.getNumero())) {
                FacesMessageUtils.error("Número é Obrigatório!");
            } else {
                fones.add(foneAdd);
                foneAdd = new Fone();
            }
        }
    }

    public void removerFone(Fone fone) {
        fones.remove(fone);
    }

    public List<DiaSemana> getDias() {
        return dias;
    }

    public void setDias(List<DiaSemana> dias) {
        this.dias = dias;
    }

    public List<DiaSemana> getDiasSelected() {
        return diasSelected;
    }

    public void setDiasSelected(List<DiaSemana> diasSelected) {
        this.diasSelected = diasSelected;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public List<DiaVisitacaoPortfolio> getDiasVisitacao() {
        return diasVisitacao;
    }

    public void setDiasVisitacao(List<DiaVisitacaoPortfolio> diasVisitacao) {
        this.diasVisitacao = diasVisitacao;
    }

    public List<Arquivo> getImagens() {
        return imagens;
    }

    public void setImagens(List<Arquivo> imagens) {
        this.imagens = imagens;
    }

    public List<HistoricoPortfolio> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoPortfolio> historicos) {
        this.historicos = historicos;
    }

    public List<LinkPortfolio> getLinks() {
        return links;
    }

    public void setLinks(List<LinkPortfolio> links) {
        this.links = links;
    }

    public HistoricoPortfolio getHistoricoAdd() {
        return historicoAdd;
    }

    public void setHistoricoAdd(HistoricoPortfolio historicoAdd) {
        this.historicoAdd = historicoAdd;
    }

    public LinkPortfolio getLinkAdd() {
        return linkAdd;
    }

    public void setLinkAdd(LinkPortfolio linkAdd) {
        this.linkAdd = linkAdd;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Fone getFoneAdd() {
        return foneAdd;
    }

    public void setFoneAdd(Fone foneAdd) {
        this.foneAdd = foneAdd;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }

}
