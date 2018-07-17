package br.gov.pi.ati.mb.orcamento;

import br.gov.pi.ati.bo.cadastro.AcaoOrcamentariaBO;
import br.gov.pi.ati.bo.controleacesso.UsuarioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.DespesaPublicaBO;
import br.gov.pi.ati.bo.orcamento.ExecucaoOrcamentariaBO;
import br.gov.pi.ati.bo.orcamento.MetaProdutoBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import br.gov.pi.ati.modelo.orcamento.Dotacao;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;
import br.gov.pi.ati.util.SessaoUtils;
import br.gov.pi.ati.util.Utils;
import br.gov.pi.ati.webservice.process.ProcessBO;
import com.xpert.faces.utils.FacesMessageUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    private MetaProdutoBO produtoBO;

    @EJB
    private UsuarioBO usuarioBO;

    @EJB
    private ExecucaoOrcamentariaBO execucaoBO;

    private List<Dotacao> dotacoes;

    private Dotacao dotacaoAdd;

    private ProgramacaoFinanceira programacaoAdd;

    private List<ProgramacaoFinanceira> programacaoFinanceira;

    private List<Municipio> cidades;

    private Territorio territorio;

    private Usuario usuarioAtual;

    private Filtros filtros;

    private List<DespesaPublica> despesas;

    private List<UnidadeOrcamentaria> unidades;

    private List<Integer> anos;

    private FonteDeRecurso fonte;

    private Integer anoAtual;

    private AcaoOrcamentaria acaoOrcamentaria;

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
        anos = new ArrayList<Integer>();

        anoAtual = new Integer(Utils.convertDateToString(new Date(), "yyyy"));

        anos.add(anoAtual);

        anos.add(anoAtual + 1);

        usuarioAtual = SessaoUtils.getUser();

        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());

        despesas = new ArrayList<DespesaPublica>();

        dotacoes = new ArrayList<Dotacao>();

        programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

        programacaoAdd = new ProgramacaoFinanceira();

        cidades = new ArrayList<Municipio>();

        filtros = new Filtros();

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

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public List<DespesaPublica> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<DespesaPublica> despesas) {
        this.despesas = despesas;
    }

    public List<Integer> getAnos() {
        return anos;
    }

    public void setAnos(List<Integer> anos) {
        this.anos = anos;
    }

    public FonteDeRecurso getFonte() {
        return fonte;
    }

    public void setFonte(FonteDeRecurso fonte) {
        this.fonte = fonte;
    }

    public AcaoOrcamentaria getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }

    public void setAcaoOrcamentaria(AcaoOrcamentaria acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }

    public void novoDotacao() {
        if (getEntity().getUnidadeOrcamentaria() != null) {
            dotacaoAdd = new Dotacao();

            fonte = new FonteDeRecurso();

            acaoOrcamentaria = new AcaoOrcamentaria();

            programacaoFinanceira = new ArrayList<ProgramacaoFinanceira>();

            programacaoAdd = new ProgramacaoFinanceira();

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
            dotacaoAdd = getDAO().getInitialized(dotacao);
            cidades = getDAO().getInitialized(dotacaoAdd.getCidades());
            programacaoFinanceira = getDAO().getInitialized(dotacaoAdd.getProgramacaoFinanceira());
            ExecucaoOrcamentaria execucaoTemp = getDAO().getInitialized(dotacaoAdd.getExecucaoOrcamentaria());
            if (execucaoTemp != null) {
                fonte = getDAO().getInitialized(execucaoTemp.getFonteDeRecurso());
                acaoOrcamentaria = getDAO().getInitialized(execucaoTemp.getAcaoOrcamentaria());
            }
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("PF('widgetEditar').show();");
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

    public void salvarDotacao() {
        if (programacaoFinanceira.size() > 0) {
            if (cidades.size() > 0) {
                RequestContext context = RequestContext.getCurrentInstance();

                context.execute("PF('widgetEditar').hide();");
            } else {
                FacesMessageUtils.error("Informe um ou mais municípios!!");
            }
        } else {
            FacesMessageUtils.error("Adicione uma ou mais programações financeira!");
        }

    }

    public void incluirDotacao() {
        if (dotacaoAdd.getExecucaoOrcamentaria() != null) {
            if (programacaoFinanceira.size() > 0) {
                if (dotacaoAdd.getProdutoLDO() != null) {
                    if (cidades.size() > 0) {
                        if (dotacaoAdd.isGeraQuantificador()) {
                            if (dotacaoAdd.getQuantidadeRealizada() != null) {
                                dotacaoAdd.setCidades(cidades);
                                dotacaoAdd.setProgramacaoFinanceira(programacaoFinanceira);
                                dotacoes.add(dotacaoAdd);
                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('widgetNovo').hide();");
                                dotacaoAdd = new Dotacao();
                            } else {
                                FacesMessageUtils.error("Quantidade realizada é obrigatória!");
                            }
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
                    FacesMessageUtils.error("Produto LDO é obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Programação Financeira é obrigatória!");
            }
        } else {
            FacesMessageUtils.error("Natureza de Despesa é obrigatória!!");
        }
    }

    public void removerDotacao(Dotacao dotacao) {
        dotacoes.remove(dotacao);
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

    public void desmarcaQuantificador() {
        if (!dotacaoAdd.isGeraQuantificador()) {
            dotacaoAdd.setQuantidadeRealizada(null);
        }
    }

    public void mudarAcaoOrcamentaria() {
        dotacaoAdd.setExecucaoOrcamentaria(null);
        dotacaoAdd.setProdutoLDO(null);
    }

    public void mudarFonteDeRecurso() {
        dotacaoAdd.setExecucaoOrcamentaria(null);
    }

    public void desmarcarQuantificador() {
        dotacaoAdd.setQuantidadeRealizada(BigDecimal.ZERO);
    }

    public void buscar() {
        despesas = despesaPublicaBO.consultar(filtros.getUnidadesOrcamentaria(), filtros.getCodigo(), filtros.getAcaoOrcamentaria(),
                filtros.getFonteDeRecurso(), filtros.getNaturezaDespesa(), filtros.getAcaoEstrategica(), filtros.getProduto());
    }

    public List<Usuario> autocompleteUsuario(String nome) {
        if (getEntity().getUnidadeOrcamentaria() != null) {
            return usuarioBO.usuariosPeloUnidadeOrcamentaria(getEntity().getUnidadeOrcamentaria(), nome);
        }

        return null;
    }

    public List<ExecucaoOrcamentaria> autocompleteExecucaoNatureza(String nome) {
        return execucaoBO.execucaoOrcamentariaNatureza(acaoOrcamentaria, fonte, nome);
    }

    public List<AcaoOrcamentaria> autocompleteAcao(String nome) {
        return execucaoBO.execucaoOrcamentariaAcaoOrcamentaria(getEntity().getUnidadeOrcamentaria(), nome);
    }

    public List<FonteDeRecurso> autocompleteFonte(String nome) {
        return execucaoBO.execucaoOrcamentariaFonte(acaoOrcamentaria, nome);
    }

    public List<MetaProduto> autocompleteProduto(String nome) {
        if (dotacaoAdd.getExecucaoOrcamentaria() != null) {
            AcaoOrcamentaria acaoOrcamentariaTemp = getDAO().getInitialized(dotacaoAdd.getExecucaoOrcamentaria().getAcaoOrcamentaria());
            AcaoEstrategica acaoTemp = getDAO().getInitialized(acaoOrcamentariaTemp.getAcaoEstrategica());
            return produtoBO.metaPelaAcaoEstrategica(acaoTemp, nome);
        }

        return null;
    }

    public BigDecimal getTotalExercicioVingente() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProgramacaoFinanceira program : programacaoFinanceira) {
            if (program.getAno().equals(anoAtual)) {
                total = total.add(program.getValor());
            }
        }

        return total;
    }

    public BigDecimal getTotalProximoExercicio() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProgramacaoFinanceira program : programacaoFinanceira) {
            if (!program.getAno().equals(anoAtual)) {
                total = total.add(program.getValor());
            }
        }

        return total;
    }

    public BigDecimal getTotalAcumulado() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProgramacaoFinanceira program : programacaoFinanceira) {
            total = total.add(program.getValor());
        }

        return total;
    }
}
