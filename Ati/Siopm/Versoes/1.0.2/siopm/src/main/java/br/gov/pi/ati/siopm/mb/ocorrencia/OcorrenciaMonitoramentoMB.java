package br.gov.pi.ati.siopm.mb.ocorrencia;

import br.gov.pi.ati.siopm.bo.cadastro.PatrulhaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.ocorrencia.OcorrenciaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;
import br.gov.pi.ati.siopm.modelo.cadastro.Arquivo;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediarioAux;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoChamada;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.StatusViaturaEnum;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OcorrenciaMonitoramentoMB extends AbstractBaseBean<Ocorrencia> implements Serializable {

    @EJB
    private OcorrenciaBO ocorrenciaBO;

    @EJB
    private PatrulhaBO patrulhaBO;

    private List<Ocorrencia> ocorrenciasPendentes = new ArrayList<Ocorrencia>();

    private List<Ocorrencia> ocorrenciasEncaminhadas = new ArrayList<Ocorrencia>();

    private List<Patrulha> patrulhasDisponiveis = new ArrayList<Patrulha>();

    private List<NaturezaOcorrencia> naturezas = new ArrayList<NaturezaOcorrencia>();

    private NaturezaOcorrencia naturezaAdd = new NaturezaOcorrencia();

    private List<Patrulha> patrulhas = new ArrayList<Patrulha>();

    private List<PessoaEnvolvida> pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();

    private PessoaEnvolvida pessoaAdd = new PessoaEnvolvida();

    private List<QualificacaoDeVeiculo> qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();

    private QualificacaoDeVeiculo veiculoEnvolvidoAdd = new QualificacaoDeVeiculo();

    private List<Arma> armas = new ArrayList<Arma>();

    private Arma armaAdd = new Arma();

    private List<LocalIntermediarioAux> locaisIntermediarios = new ArrayList<LocalIntermediarioAux>();

    private LocalIntermediarioAux localIntermediarioAdd = new LocalIntermediarioAux();

    private List<DrogaOcorrenciaItem> drogas = new ArrayList<DrogaOcorrenciaItem>();

    private DrogaOcorrenciaItem drogaAdd = new DrogaOcorrenciaItem();

    private List<ObjetoApreendido> objetos = new ArrayList<ObjetoApreendido>();

    private ObjetoApreendido objetovoAdd = new ObjetoApreendido();

    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    private DualListModel<Patrulha> patrulhasDualList = new DualListModel<Patrulha>();

    private Endereco endereco = new Endereco();

    private Solicitante solicitante = new Solicitante();

    @Override
    public void init() {
        carregarListas();
    }

    @Override
    public OcorrenciaBO getBO() {
        return ocorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Ocorrencia> getOcorrenciasPendentes() {
        return ocorrenciasPendentes;
    }

    public List<Ocorrencia> getOcorrenciasEncaminhadas() {
        return ocorrenciasEncaminhadas;
    }

    public List<Patrulha> getPatrulhasDisponiveis() {
        return patrulhasDisponiveis;
    }

    public void carregarListas() {
//        patrulhasDisponiveis = patrulhaBO.listarPatrulhasDisponiveis();
        ocorrenciasPendentes = ocorrenciaBO.ocorrenciasPelaSituacao(SituacaoOcorrencia.PENDENTE);
        ocorrenciasEncaminhadas = ocorrenciaBO.ocorrenciasPelaSituacao(SituacaoOcorrencia.ENCAMINHADA_VIATURA);
    }

    public void carregarListasParaOcorrencia() {
        naturezas = getBO().getDAO().getInitialized(getEntity().getNaturezas());
//        patrulhas = getBO().getDAO().getInitialized(getEntity().getPatrulhas());
        pessoasEnvolvidas = getBO().getDAO().getInitialized(getEntity().getPessoasEnvolvidas());
        qualificacoesVeiculos = getBO().getDAO().getInitialized(getEntity().getQualificacoesVeiculos());
        armas = getBO().getDAO().getInitialized(getEntity().getArmas());
        locaisIntermediarios = getBO().getDAO().getInitialized(getEntity().getLocaisIntermediarios());
        drogas = getBO().getDAO().getInitialized(getEntity().getDrogas());
        objetos = getBO().getDAO().getInitialized(getEntity().getObjetos());
        arquivos = getBO().getDAO().getInitialized(getEntity().getArquivos());
    }

    public OcorrenciaBO getOcorrenciaBO() {
        return ocorrenciaBO;
    }

    public void setOcorrenciaBO(OcorrenciaBO ocorrenciaBO) {
        this.ocorrenciaBO = ocorrenciaBO;
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

    public List<Patrulha> getPatrulhas() {
        return patrulhas;
    }

    public void setPatrulhas(List<Patrulha> patrulhas) {
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
        pessoasEnvolvidas.add(pessoaAdd);
        pessoaAdd = new PessoaEnvolvida();
    }

    public void removerPessoa(PessoaEnvolvida pessoa) {
        pessoasEnvolvidas.remove(pessoa);
    }

    public void carregarVeiculos() {
        if (getEntity().getId() != null) {
            qualificacoesVeiculos = getBO().getDAO().getInitialized(getEntity().getQualificacoesVeiculos());
        } else {
            qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();
        }
    }

    public void addVeiculos() {
        qualificacoesVeiculos.add(veiculoEnvolvidoAdd);
        veiculoEnvolvidoAdd = new QualificacaoDeVeiculo();
    }

    public void removerVeiculo(QualificacaoDeVeiculo veiculo) {
        qualificacoesVeiculos.remove(veiculo);
    }

    public void addArma() {
        armas.add(armaAdd);
    }

    public void removerArma(Arma arma) {
        armas.remove(arma);
    }

    public void addLocalIntermediario() {
        locaisIntermediarios.add(localIntermediarioAdd);
    }

    public void removerLocalIntermediario(LocalIntermediarioAux local) {
        locaisIntermediarios.remove(local);
    }

    public void addDroga() {
        drogas.add(drogaAdd);
    }

    public void removerDroga(DrogaOcorrenciaItem droga) {
        drogas.remove(droga);
    }

    public void addObjeto() {
        objetos.add(objetovoAdd);
    }

    public void removerObjeto(ObjetoApreendido obj) {
        objetos.remove(obj);
    }

    public void setarListasDePatrulhas() {
        List<Patrulha> patrulhasSelecionadas = new ArrayList<Patrulha>();
//        List<Patrulha> patrulhasDisponiveisTemp = patrulhaBO.listarPatrulhasDisponiveis();
//        patrulhasDualList = new DualListModel<Patrulha>(patrulhasDisponiveisTemp, patrulhasSelecionadas);
    }

    public DualListModel<Patrulha> getPatrulhasDualList() {
        return patrulhasDualList;
    }

    public void setPatrulhasDualList(DualListModel<Patrulha> patrulhasDualList) {
        this.patrulhasDualList = patrulhasDualList;
    }

    public void confirmaAtendimento() {
        if (patrulhasDualList.getTarget().size() > 0) {
            for (Patrulha patrulha : patrulhasDualList.getTarget()) {
                patrulha.setStatus(StatusViaturaEnum.ATENDENDO);
                patrulhaBO.getDAO().saveOrMerge(patrulha, true);
            }

            for (Patrulha patrulha : patrulhasDualList.getSource()) {
                patrulha.setStatus(StatusViaturaEnum.DISPONIVEL);
                patrulhaBO.getDAO().saveOrMerge(patrulha, true);
            }

//            getEntity().setPatrulhas(patrulhasDualList.getTarget());
            getEntity().setSituacao(SituacaoOcorrencia.ENCAMINHADA_VIATURA);
            getEntity().setDataAtendimento(new Date());
            getEntity().setHoraAtendimento(new Date());

//            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
//            solicitante = getBO().getDAO().getInitialized(getEntity().getSolicitante());
//            naturezas = getBO().getDAO().getInitialized(getEntity().getNaturezas());
            
//            getEntity().setNaturezas(naturezas);

            super.save();
        } else {
            FacesMessageUtils.error("Selecione pelo menos uma patrulha para a ocorrência!!");
        }
    }
}
