package br.gov.pi.ati.mb.orcamento;

import br.gov.pi.ati.bo.cadastro.AcaoOrcamentariaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.DespesaPublicaBO;
import br.gov.pi.ati.bo.orcamento.MetaProdutoBO;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import br.gov.pi.ati.modelo.orcamento.Dotacao;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;
import br.gov.pi.ati.util.SessaoUtils;
import br.gov.pi.ati.webservice.process.ProcessBO;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DespesaPublicaMB extends AbstractBaseBean<DespesaPublica> implements Serializable {

    @EJB
    private DespesaPublicaBO despesaPublicaBO;

    @EJB
    private AcaoOrcamentariaBO acaoBO;

    @EJB
    private MetaProdutoBO produtoBO;

    private List<Dotacao> dotacoes;

    private Dotacao dotacaoAdd;

    private ProgramacaoFinanceira programacaoAdd;

    private List<ProgramacaoFinanceira> programacaoFinanceira;

    private List<Municipio> cidades;

    private Territorio territorio;

    private Usuario usuarioAtual;

    private List<UnidadeOrcamentaria> unidades;

    @Override
    public DespesaPublicaBO getBO() {
        return despesaPublicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());

        dotacoes = new ArrayList<Dotacao>();

        programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();
        
        programacaoAdd = new ProgramacaoFinanceira();

        cidades = new ArrayList<Municipio>();

        if (getEntity().getId() != null) {
            dotacoes = getDAO().getInitialized(getEntity().getDotacao());
        }
    }

    @Override
    public void save() {
        getEntity().setDotacao(dotacoes);
        super.save();
    }

    public List<Dotacao> getDotacoes() {
        return dotacoes;
    }

    public void setDotacoes(List<Dotacao> dotacoes) {
        this.dotacoes = dotacoes;
    }

    public ProgramacaoFinanceira getProgramacaoAdd() {
        return programacaoAdd;
    }

    public void setProgramacaoAdd(ProgramacaoFinanceira programacaoAdd) {
        this.programacaoAdd = programacaoAdd;
    }

    public List<ProgramacaoFinanceira> getProgramacaoFinanceira() {
        return programacaoFinanceira;
    }

    public void setProgramacaoFinanceira(List<ProgramacaoFinanceira> programacaoFinanceira) {
        this.programacaoFinanceira = programacaoFinanceira;
    }

    public List<Municipio> getCidades() {
        return cidades;
    }

    public void setCidades(List<Municipio> cidades) {
        this.cidades = cidades;
    }

    public Dotacao getDotacaoAdd() {
        return dotacaoAdd;
    }

    public void setDotacaoAdd(Dotacao dotacaoAdd) {
        this.dotacaoAdd = dotacaoAdd;
    }

    public Territorio getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Territorio territorio) {
        this.territorio = territorio;
    }

    public List<UnidadeOrcamentaria> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeOrcamentaria> unidades) {
        this.unidades = unidades;
    }

    public void novoDotacao() {
        if (getEntity().getUnidadeOrcamentaria() != null) {
            dotacaoAdd = new Dotacao();

            programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

            cidades = new ArrayList<Municipio>();

            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("PF('widgetNovo').show();");
        } else {
            FacesMessageUtils.error("Unidade Orçamentária é obrigatória!!");
        }

    }

    public void editarDotacao(Dotacao dotacao) {
        if (getEntity().getUnidadeOrcamentaria() != null) {
            dotacaoAdd = new Dotacao();
            dotacaoAdd = dotacao;
            cidades = getDAO().getInitialized(dotacao.getCidades());
            programacaoFinanceira = getDAO().getInitialized(dotacao.getProgramacaoFinanceira());
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("PF('widgetNovo').show();");
        } else {
            FacesMessageUtils.error("Unidade Orçamentária é obrigatória!!");
        }

    }

    public void detalharDotacao(Dotacao dotacao) {
        dotacaoAdd = new Dotacao();
        dotacaoAdd = dotacao;

        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('widgetDetail').show();");
    }

    public void incluirDotacao() {
        if (dotacaoAdd.getAcaoOrcamentaria() != null) {
            if (dotacaoAdd.getFonteDeRecurso() != null) {
                if (dotacaoAdd.getNaturezaDaDespesa() != null) {
                    if (programacaoFinanceira.size() > 0) {
                        if (dotacaoAdd.getProdutoLDO() != null) {
                            if (dotacaoAdd.getQuantidadeRealizada() != null) {
                                if (cidades.size() > 0) {
                                    if (dotacaoJahAdicionada(dotacaoAdd)) {
                                        FacesMessageUtils.error("Não pode conter Dotação com os mesmo atributos informados: Ação Orçamentaria, Fonte de Recurso e Natureza!");
                                    } else {
                                        dotacaoAdd.setCidades(cidades);
                                        dotacaoAdd.setProgramacaoFinanceira(programacaoFinanceira);
                                        dotacoes.add(dotacaoAdd);
                                        RequestContext context = RequestContext.getCurrentInstance();
                                        context.execute("PF('widgetNovo').hide();");
                                        dotacaoAdd = new Dotacao();
                                    }
                                } else {
                                    FacesMessageUtils.error("Municipio (s) é (são) obrigatório (s)!");
                                }
                            } else {
                                FacesMessageUtils.error("Quantidade realizada é obrigatória!");
                            }
                        } else {
                            FacesMessageUtils.error("Produto LDO é obrigatório!");
                        }
                    } else {
                        FacesMessageUtils.error("Programação Financeira é obrigatória!");
                    }
                } else {
                    FacesMessageUtils.error("Natureza da Despesa é obrigatória!");
                }
            } else {
                FacesMessageUtils.error("Fonte de Recurso é obrigatória!");
            }
        } else {
            FacesMessageUtils.error("Ação Orçamentária é obrigatória!");
        }

    }

    public void removerDotacao(Dotacao dotacao) {
        dotacoes.remove(dotacao);
    }

    private boolean dotacaoJahAdicionada(Dotacao dotacao) {
        for (Dotacao dota : dotacoes) {
            if (dota.getAcaoOrcamentaria().equals(dotacao.getAcaoOrcamentaria()) && dota.getFonteDeRecurso().equals(dotacao.getFonteDeRecurso())
                    && dota.getNaturezaDaDespesa().equals(dotacao.getNaturezaDaDespesa())) {
                return true;
            }
        }
        return false;
    }

    public void adicionarProgramacao() {
        if (programacaoAdd.getMes() != null) {
            if (programacaoAdd.getAno() != null) {
                if (programacaoAdd.getValor() != null) {
                    if (programacaoJahAdd(programacaoAdd)) {
                        FacesMessageUtils.error("Programação com esse Mês e Ano já foram incluidos!");
                    } else {
                        programacaoFinanceira.add(programacaoAdd);
                        programacaoAdd = new ProgramacaoFinanceira();
                    }

                } else {
                    FacesMessageUtils.error("Valor é obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Ano é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Mês é obrigatório!");
        }
    }

    public void removerProgramacao(ProgramacaoFinanceira programcao) {
        programacaoFinanceira.remove(programcao);
    }

    private boolean programacaoJahAdd(ProgramacaoFinanceira programacao) {
        for (ProgramacaoFinanceira pro : programacaoFinanceira) {
            if ((pro.getAno().compareTo(programacao.getAno()) == 0) && (pro.getMes() == programacao.getMes())) {
                return true;
            }
        }
        return false;
    }

    public void pegarDescricao() {
        String descricao = ProcessBO.getDescricao(getEntity().getNumeroProcesso());

        if (descricao != null) {
            getEntity().setDescricaoDespesa(descricao);
        } else {
            FacesMessageUtils.error("Processo não encontrado!");
        }
    }

    public List<AcaoOrcamentaria> autocompleteAcao(String nome) {
        return acaoBO.listarPeloNomeEUnidadeOrcamentaria(nome, getEntity().getUnidadeOrcamentaria());
    }

    public List<MetaProduto> autocompleteProduto(String nome) {
        return produtoBO.metaPeloNomeEUnidadeOrcamentaria(nome, getEntity().getUnidadeOrcamentaria());
    }
}
