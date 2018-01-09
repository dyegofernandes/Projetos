package br.gov.pi.siste.mb.financeiro;

import br.gov.pi.siste.bo.cadastro.CargoBO;
import br.gov.pi.siste.bo.cadastro.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.DadosFuncionaisBO;
import br.gov.pi.siste.bo.cadastro.ServidorBO;
import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import br.gov.pi.siste.bo.financeiro.AliquotaIRRFBO;
import br.gov.pi.siste.bo.financeiro.AliquotaInssBO;
import br.gov.pi.siste.bo.financeiro.MovimentoBO;
import br.gov.pi.siste.bo.financeiro.ReferenciaBO;
import br.gov.pi.siste.bo.financeiro.TabelaIRRFBO;
import br.gov.pi.siste.bo.financeiro.TabelaInssBO;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import br.gov.pi.siste.modelo.cadastro.Endereco;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.cadastro.enums.Formato;
import br.gov.pi.siste.modelo.cadastro.enums.Ocorrencia;
import br.gov.pi.siste.modelo.cadastro.enums.TipoPessoa;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.AliquotaIRRF;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import br.gov.pi.siste.util.Utils;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MovimentoMB extends AbstractBaseBean<Movimento> implements Serializable {

    @EJB
    private MovimentoBO movimentoBO;

    @EJB
    private TabelaIRRFBO tabelaIrrfBO;

    @EJB
    private TabelaInssBO tabelaInssBO;

    @EJB
    private ReferenciaBO referenciaBO;

    @EJB
    private ServidorBO servidorBO;

    @EJB
    private AliquotaInssBO aliquotaInssBO;

    @EJB
    private AliquotaIRRFBO aliquotaIRRFBO;

    @EJB
    private UnidadeBO unidadeBO;

    @EJB
    DadosFuncionaisBO dadosBO;

    @EJB
    private CargoBO cargoBO;

    @EJB
    private CidadeBO cidadeBO;

    private TabelaIRRF tabelaIRRF;

    private TabelaInss tabelaInss;

    private boolean existeMultiplo = false;

    private String unidade;

    private String cargo;

    private String referenciaAnterior = "";

    private String referenciaAtual = "";

    private String financeiroAnt;

    private Referencia referenciaA;

    private String fonteA;

    private String tipoPessoaAnt;

    private BigDecimal valorAnt;

    private BigDecimal valorBCalcAnt;

    private BigDecimal desconto1Ant;

    private BigDecimal porcInss;

    private BigDecimal desconto2Ant;

    private BigDecimal valorTotalAnt;

    private BigDecimal maiorPorcentagem;

    private BigDecimal issAnt;

    private BigDecimal baseIssAnt;

    private BigDecimal porcIss;

    private BigDecimal sestSenatAnt;

    private BigDecimal baseSestSenatAnt;

    private BigDecimal porcSestSenat;

    private BigDecimal irrfAnt;

    private BigDecimal baseIrrfAnt;

    private BigDecimal porcIrrf;

    private BigDecimal pensaoAnt;

    private FiltrosVO filtros;

    private Utils util = new Utils();

    private Usuario usuarioAtual;

    private List<Movimento> movimentosPorUsuario = new ArrayList<Movimento>();

    private List<Unidade> unidades = new ArrayList<Unidade>();

    private BigDecimal aliquotaIrrf;

    private BigDecimal deducaoIrrf;

    private DualListModel<Movimento> movimentosDualList = new DualListModel<Movimento>();

    @Override
    public MovimentoBO getBO() {
        return movimentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "referencia, servidor";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

        if (getEntity().getId() != null) {
            carregarDadosVelhos();
        } else {
            carregarDadosNovos();
        }

    }

    @Override
    public void postSave() {
        limparCampos();
    }

    @Override
    public void delete() {
        super.delete();
        movimentosPorUsuario = movimentoBO.listarMovimentos(filtros);
    }

    public void buscar() {
        movimentosPorUsuario = movimentoBO.listarMovimentos(filtros);
    }

    public List<Cidade> getCidades() {
        return cidadeBO.listarCidadesPorEstado("Piauí");
    }

    public List<Cargo> getCargos() {
        Orgao orgao = null;

        if (filtros.getOrgao() != null) {
            orgao = filtros.getOrgao();
        } else {
            if (!usuarioAtual.isSuperUsuario()) {
                if (usuarioAtual.getOrgao() != null) {
                    orgao = usuarioAtual.getOrgao();
                }
            }
        }

        return cargoBO.listarCargos(orgao);
    }

    public void carregarMovimentosPorReferencia() {
        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

        filtros.setReferencia(referenciaA);

        List<Movimento> movimentosAnt = movimentoBO.listarMovimentos(filtros);

        filtros.setReferencia(getEntity().getReferencia());

        List<Movimento> movimentosAtual = movimentoBO.listarMovimentos(filtros);

//Verificar se o movimento já existe na competencia atual
        List<Movimento> movRemovidos = new ArrayList<Movimento>();
        for (Movimento movAtual : movimentosAtual) {
            for (Movimento movAnt : movimentosAnt) {
                if (movAtual.getServidor().equals(movAnt.getServidor())) {
                    movRemovidos.add(movAnt);
                }
            }
        }

        movimentosAnt.removeAll(movRemovidos);

        List<Movimento> movimentosSelecionados = new ArrayList<Movimento>();

        movimentosDualList = new DualListModel<Movimento>(movimentosAnt, movimentosSelecionados);
    }

    @Override
    public void save() {
        super.save();

    }

    public void salvarAll() {
        if (getEntity().getReferencia() != null) {
            if (movimentosDualList.getTarget().size() > 0) {
                for (Movimento mov : movimentosDualList.getTarget()) {
                    movimentoBO.clonarMovimento(mov, getEntity().getReferencia());
                }
                FacesMessageUtils.info("Movimentos selecionados foram clonados com sucesso da competência: ".concat(referenciaAnterior)
                        .concat(" para: ").concat(referenciaAtual));

                movimentosPorUsuario = movimentoBO.listarMovimentos(filtros);

            } else {
                FacesMessageUtils.error("Selecione um ou mais movimentos");
            }
        } else {
            FacesMessageUtils.error("Não existe competência em aberto!!");
        }
    }

    public void setarCidade() {
        if (filtros.getUnidade() != null) {
            Endereco endereco = getBO().getDAO().getInitialized(filtros.getUnidade().getEndereco());
            Cidade cidade = getBO().getDAO().getInitialized(endereco.getCidade());
            filtros.setCidade(cidade);
        } else {
            filtros.setCidade(null);
        }
    }

    public void carregarUnidadesPorOrgao() {
        if (filtros.getOrgao() != null) {
            unidades = unidadeBO.unidadesPorOrgao(filtros.getOrgao());
        } else {
            filtros.setUnidade(new Unidade());
            unidades = new ArrayList<Unidade>();
        }
    }

    public void buscarServidor() {
        if (getEntity().getReferencia() != null && tabelaInss != null && tabelaInss != null) {
            Servidor servidorTemp = servidorBO.getServidorPeloCodigo(usuarioAtual.getUnidade() != null ? usuarioAtual.getUnidade()
                    : filtros.getUnidade(), filtros.getCpf());

            if (servidorTemp != null) {
                existeMultiplo = movimentoBO.trabalhadorApareceNaCompetencia(getEntity().getReferencia(), servidorTemp);
                if (existeMultiplo) {
                    getEntity().setOcorrencia(Ocorrencia.MULTIPLOS_VINCULOS);
                } else {
                    getEntity().setOcorrencia(null);
                }
                getEntity().setServidor(servidorTemp);

//                unidade = servidorTemp.getDadosFuncionais().getUnidade().toString();
//                cargo = servidorTemp.getDadosFuncionais().getCargo().toString();
                Movimento movimentoAnterior = movimentoBO.movimentoAnteriorTrabalhador(servidorTemp, referenciaA);

                if (movimentoAnterior != null) {
                    financeiroAnt = movimentoAnterior.getFinanceiro().getDescricao();
                    fonteA = getBO().getDAO().getInitialized(movimentoAnterior.getFonte()).toString();
//                    fonteA = "".concat(movimentoAnterior.getFonte().getCodigo().toString()).concat(" - ").concat(movimentoAnterior.getFonte().getNome());
                    tipoPessoaAnt = movimentoAnterior.getTipo().getDescricao();
                    valorAnt = movimentoAnterior.getValor();
                    valorBCalcAnt = movimentoAnterior.getValorBCalc();
                    desconto1Ant = movimentoAnterior.getDesconto1();
                    desconto2Ant = movimentoAnterior.getDesconto2();
                    valorTotalAnt = movimentoAnterior.getValorTotalDos11BCalc();
                    issAnt = movimentoAnterior.getIss();
                    baseIssAnt = movimentoAnterior.getBaseIss();
                    irrfAnt = movimentoAnterior.getIrrf();
                    baseIrrfAnt = movimentoAnterior.getBaseIrrf();
                    sestSenatAnt = movimentoAnterior.getSestSenat();
                    baseSestSenatAnt = movimentoAnterior.getBaseSestSenat();
                    pensaoAnt = movimentoAnterior.getPensao();
                } else {
                    financeiroAnt = null;
                    fonteA = null;
                    valorAnt = null;
                    valorBCalcAnt = null;
                    desconto1Ant = null;
                    desconto2Ant = null;
                    valorTotalAnt = null;
                    issAnt = null;
                    baseIssAnt = null;
                    irrfAnt = null;
                    baseIrrfAnt = null;
                    sestSenatAnt = null;
                    baseSestSenatAnt = null;
                    pensaoAnt = null;
                }
            } else {
                FacesMessageUtils.error("Não existe Servidor com esse CPF: ".concat(util.format("###.###.###-##", filtros.getCpf()).concat(" cadastrado para essa Unidade!")));
                limparCampos();
            }
        } else {
            FacesMessageUtils.error("Não existe Competência em Aberto, Tabela Inss ou Tabela IRRF Cadastrada no Sistema, entre em contato com o Administrador do Sistema!");

        }
    }

    public String getReferenciaAtual() {
        return referenciaAtual;
    }

    public void calcularBases() {
        calculaBaseIss();
        calcularBaseSestSenat();
        calcularBaseInss();
        calcularIrrfEBase();
    }

    public void calcularBaseInss() {
        if (getEntity().getValor() != null) {
            if (getEntity().getTipo() == TipoPessoa.PF) {
                if (getEntity().getInss() != null) {
                    AliquotaInss aliquota = aliquotaInssBO.pegarAliquota(getEntity().getInss(), getEntity().getValor());

                    if (aliquota.getValorFixo().compareTo(BigDecimal.ZERO) == 0) {
                        getEntity().setValorBCalc(getEntity().getValor());
                    } else {
                        getEntity().setValorBCalc(aliquota.getSalarioInicial());
                    }
                    calcularValorPelaPorcInss();
                }
            }
            if (getEntity().getTipo() == TipoPessoa.PJ) {
                getEntity().setValorBCalc(getEntity().getValor());
                calcularValorPelaPorcInss();
            }

            calcularPorcPeloValorInss();
        }
    }

    public void calcularPorcPeloValorInss() {
        if (getEntity().getValorBCalc() != null && getEntity().getDesconto1() != null) {
            porcInss = util.calcularPorcPeloValor(getEntity().getValorBCalc(), getEntity().getDesconto1());
        }
    }

    public void calcularValorPelaPorcInss() {
        if (porcInss != null) {
            getEntity().setDesconto1(util.calcularPorcentagem(porcInss, getEntity().getValorBCalc()));
        } else {
            getEntity().setDesconto1(util.calcularPorcentagem(new BigDecimal(11), getEntity().getValorBCalc()));
        }
        if (getEntity().getTipo() == TipoPessoa.PF) {
            getEntity().setDesconto2(util.calcularPorcentagem(new BigDecimal(20), getEntity().getValorBCalc()));
        } else {
            getEntity().setDesconto2(BigDecimal.ZERO);
        }
    }

    public void calculaBaseIss() {
        if (getEntity().getValor() != null) {
            getEntity().setBaseIss(getEntity().getValor());
        }
    }

    public void calcularValorIssPelaPorc() {
        if (getEntity().getBaseIss() != null && porcIss != null) {
            getEntity().setIss(util.calcularPorcentagem(porcIss, getEntity().getBaseIss()));
        }
    }

    public void calculaPorcPeloValorIss() {
        if (getEntity().getIss() != null && getEntity().getBaseIss() != null) {
            porcIss = util.calcularPorcPeloValor(getEntity().getBaseIss(), getEntity().getIss());
        }
    }

    public void calcularBaseSestSenat() {
        if (getEntity().getValor() != null) {
            getEntity().setBaseSestSenat((util.calcularPorcentagem(new BigDecimal(20), getEntity().getValor())));
        }
    }

    public void calcularValorPelaPorcSestSenat() {
        if (getEntity().getBaseSestSenat() != null && porcSestSenat != null) {
            getEntity().setSestSenat(util.calcularPorcentagem(porcSestSenat, getEntity().getBaseSestSenat()));
        }
    }

    public void calcularPorcPeloValorSestSenat() {
        if (getEntity().getSestSenat() != null && getEntity().getBaseSestSenat() != null) {
            porcSestSenat = util.calcularPorcPeloValor(getEntity().getBaseSestSenat(), getEntity().getSestSenat());
        }
    }

    public void calcularIrrfEBase() {
        if (getEntity().getValor() != null) {
            if (getEntity().getTipo() == TipoPessoa.PF) {
                if (getEntity().getIr() != null) {
                    BigDecimal valor = getEntity().getValor();

                    if (getEntity().getPensao() != null) {
                        valor = valor.subtract(getEntity().getPensao());
                    }

                    if (getEntity().getDesconto1() != null) {
                        valor = valor.subtract(getEntity().getDesconto1());
                    }

                    if (getEntity().getServidor() != null) {
                        Servidor servidor = getDAO().getInitialized(getEntity().getServidor());
                        DadosFuncionais dados = getDAO().getInitialized(servidor.getDadosFuncionais());
                        if (dados.getQtdDepIr() != null) {
                            BigDecimal valorTotalPorDependentes = movimentoBO.getDAO().getInitialized(getEntity().getIr()).getDeducaoPorDependentes().
                                    multiply(new BigDecimal(dados.getQtdDepIr()));
                            if (valor.compareTo(valorTotalPorDependentes) > 0) {
                                valor = valor.subtract(valorTotalPorDependentes);
                            }

                        }
                    }

                    getEntity().setBaseIrrf(valor);

                    if (getEntity().getBaseIrrf() != null) {
                        AliquotaIRRF aliquotaIrrfTemp = aliquotaIRRFBO.aliquotaPeloValor(getEntity().getIr(), getEntity().getBaseIrrf());

                        aliquotaIrrf = aliquotaIrrfTemp.getValor();

                        deducaoIrrf = aliquotaIrrfTemp.getParcelaADeduzir();
                    }

                    calcularDescontoPelaBaseIrrf();
                }
            }
            if (getEntity().getTipo() == TipoPessoa.PJ) {
                getEntity().setBaseIrrf(getEntity().getValor());
                calcularDescontoPelaBaseIrrf();
            }
        }
    }

    public void calcularDescontoPelaBaseIrrf() {
        if (getEntity().getBaseIrrf() != null) {
            if (getEntity().getTipo() == TipoPessoa.PF) {
                if (deducaoIrrf != null && aliquotaIrrf != null) {
                    BigDecimal irrfTemp = util.calcularPorcentagem(aliquotaIrrf, getEntity().getBaseIrrf());
                    irrfTemp = irrfTemp.subtract(deducaoIrrf);
                    getEntity().setIrrf(irrfTemp);
                }
            }

            if (getEntity().getTipo() == TipoPessoa.PJ) {
                getEntity().setIrrf(util.calcularPorcentagem(new BigDecimal(1.5), getEntity().getBaseIrrf()));
                porcIrrf = new BigDecimal(1.5);
            }
        }
    }

    public void calcularValorPelaPorcIrrf() {
        if (getEntity().getBaseIrrf() != null && porcIrrf != null) {
            getEntity().setIrrf(util.calcularPorcentagem(porcIrrf, getEntity().getBaseIrrf()));
        }
    }

    public void calcularPorcPeloValorIrrf() {
        if (getEntity().getBaseIrrf() != null && getEntity().getIrrf() != null) {
            porcIrrf = util.calcularPorcPeloValor(getEntity().getBaseIrrf(), getEntity().getIrrf());
        }
    }

    public BigDecimal getValorLiquido() {
        BigDecimal liquido = BigDecimal.ZERO;

        if (getEntity().getValor() != null) {
            liquido = liquido.add(getEntity().getValor());
        }

        if (getEntity().getPensao() != null) {
            liquido = liquido.subtract(getEntity().getPensao());
        }

        if (getEntity().getDesconto1() != null) {
            liquido = liquido.subtract(getEntity().getDesconto1());
        }

        return liquido;
    }

    private void carregarDadosNovos() {
        Referencia referencia = referenciaBO.pegarUltimaRerenciaAberta();
        tabelaInss = tabelaInssBO.getTabelaAtual();
        tabelaIRRF = tabelaIrrfBO.getTabelaAtual();

        if (referencia != null) {
//            referenciaAtual = getBO().getDAO().getInitialized(referencia).toString();
            getEntity().setReferencia(referencia);
            referenciaA = referenciaBO.getDAO().unique("codigo", util.periodoAnterior(referencia.getCodigo()));
            if (referenciaA != null) {
                referenciaAnterior = convertReferencia(referenciaA.getCodigo());
            } else {
                referenciaAnterior = convertReferencia(util.periodoAnterior(referencia.getCodigo()));
            }
        } else {
            FacesMessageUtils.error("Movimento não pode ser cadastrado sem Competência em Aberto!");
        }

        if (tabelaInss == null) {
            FacesMessageUtils.error("Movimento não pode ser cadastrado sem uma Tabela de Inss cadastrada!");
        } else {
            getEntity().setInss(tabelaInss);
        }

        if (tabelaIRRF == null) {
            FacesMessageUtils.error("Movimento não pode ser cadastrado sem uma Tabela de IR cadastrada!");
        } else {
            getEntity().setIr(tabelaIRRF);
        }
    }

    public void carregarDadosVelhos() {
        Referencia referencia = movimentoBO.getDAO().getInitialized(getEntity().getReferencia());
        referenciaAtual = referencia.toString();
        referenciaA = referenciaBO.getDAO().unique("codigo", util.periodoAnterior(referencia.getCodigo()));
        referenciaAnterior = referenciaA != null ? convertReferencia(referenciaA.getCodigo()) : convertReferencia(util.periodoAnterior(getEntity().getReferencia().getCodigo()));
//        Servidor servidorTemp = movimentoBO.getDAO().getInitialized(getEntity().getServidor());
//        DadosFuncionais dados = getBO().getDAO().getInitialized(servidorTemp.getDadosFuncionais());
//        Unidade unidadeTemp = getBO().getDAO().getInitialized(dados.getUnidade());
//        Cargo cargoTemp = getBO().getDAO().getInitialized(dados.getCargo());
//        unidade = unidadeTemp.getNome();
//        cargo = cargoTemp.getNome();
        porcInss = util.calcularPorcPeloValor(getEntity().getValorBCalc(), getEntity().getDesconto1());
        if (getEntity().getBaseIss() != null && getEntity().getIss() != null) {
            porcIss = util.calcularPorcPeloValor(getEntity().getBaseIss(), getEntity().getIss());
        }
        if (getEntity().getBaseSestSenat() != null && getEntity().getSestSenat() != null) {
            porcSestSenat = util.calcularPorcPeloValor(getEntity().getBaseSestSenat(), getEntity().getSestSenat());
        }
        porcIrrf = util.calcularPorcPeloValor(getEntity().getBaseIrrf(), getEntity().getIrrf());

        AliquotaIRRF aliquota = aliquotaIRRFBO.aliquotaPeloValor(getEntity().getIr(), getEntity().getBaseIrrf());
        deducaoIrrf = aliquota.getParcelaADeduzir();
        aliquotaIrrf = aliquota.getValor();
        Restrictions restrictions = new Restrictions();
        Movimento movimentoAnterior = null;
        if (referenciaA != null) {
            restrictions.add("servidor", getEntity().getServidor());
            restrictions.add("referencia", referenciaA);
            movimentoAnterior = movimentoBO.getDAO().unique(restrictions);
        }

        if (movimentoAnterior != null) {
            financeiroAnt = movimentoAnterior.getFinanceiro().getDescricao();
            tipoPessoaAnt = movimentoAnterior.getTipo().getDescricao();
            fonteA = getBO().getDAO().getInitialized(movimentoAnterior.getFonte()).toString();
            valorAnt = movimentoAnterior.getValor();
            valorBCalcAnt = movimentoAnterior.getValorBCalc();
            desconto1Ant = movimentoAnterior.getDesconto1();
            desconto2Ant = movimentoAnterior.getDesconto2();
            valorTotalAnt = movimentoAnterior.getValorTotalDos11BCalc();
            issAnt = movimentoAnterior.getIss();
            baseIssAnt = movimentoAnterior.getBaseIss();
            irrfAnt = movimentoAnterior.getIrrf();
            sestSenatAnt = movimentoAnterior.getSestSenat();
            baseSestSenatAnt = movimentoAnterior.getSestSenat();
            pensaoAnt = movimentoAnterior.getPensao();
            baseIrrfAnt = movimentoAnterior.getBaseIrrf();
        } else {
            financeiroAnt = null;
            fonteA = null;
            tipoPessoaAnt = null;
            valorAnt = null;
            valorBCalcAnt = null;
            desconto1Ant = null;
            desconto2Ant = null;
            valorTotalAnt = null;
            issAnt = null;
            baseIssAnt = null;
            irrfAnt = null;
            baseIrrfAnt = null;
            sestSenatAnt = null;
            baseSestSenatAnt = null;
            pensaoAnt = null;
            baseSestSenatAnt = null;
        }
    }

    private void limparCampos() {
        setEntity(new Movimento());
//        unidade = "";
//        cargo = "";
        porcInss = null;
        porcIrrf = null;
        porcIss = null;
        porcSestSenat = null;
        financeiroAnt = "";
        tipoPessoaAnt = null;
        fonteA = null;
        valorAnt = null;
        valorBCalcAnt = null;
        desconto1Ant = null;
        desconto2Ant = null;
        valorTotalAnt = null;
        issAnt = null;
        baseIssAnt = null;
        irrfAnt = null;
        sestSenatAnt = null;
        baseSestSenatAnt = null;
        pensaoAnt = null;
        baseIrrfAnt = null;
        carregarDadosNovos();
    }

    public DualListModel<Movimento> getMovimentosDualList() {
        return movimentosDualList;
    }

    public void setMovimentosDualList(DualListModel<Movimento> movimentosDualList) {
        this.movimentosDualList = movimentosDualList;
    }

    public BigDecimal getValorBCalcAnt() {
        return valorBCalcAnt;
    }

    public void setValorBCalcAnt(BigDecimal valorBCalcAnt) {
        this.valorBCalcAnt = valorBCalcAnt;
    }

    public BigDecimal getDesconto1Ant() {
        return desconto1Ant;
    }

    public void setDesconto1Ant(BigDecimal desconto1Ant) {
        this.desconto1Ant = desconto1Ant;
    }

    public BigDecimal getDesconto2Ant() {
        return desconto2Ant;
    }

    public void setDesconto2Ant(BigDecimal desconto2Ant) {
        this.desconto2Ant = desconto2Ant;
    }

    public BigDecimal getAliquotaIrrf() {
        return aliquotaIrrf;
    }

    public BigDecimal getDeducaoIrrf() {
        return deducaoIrrf;
    }

    public BigDecimal getValorTotalAnt() {
        return valorTotalAnt;
    }

    public void setValorTotalAnt(BigDecimal valorTotalAnt) {
        this.valorTotalAnt = valorTotalAnt;
    }

    public String getFonteA() {
        return fonteA;
    }

    public void setFonteA(String fonteA) {
        this.fonteA = fonteA;
    }

    public String getTipoPessoaAnt() {
        return tipoPessoaAnt;
    }

    public void setTipoPessoaAnt(String tipoPessoaAnt) {
        this.tipoPessoaAnt = tipoPessoaAnt;
    }

    public BigDecimal getIssAnt() {
        return issAnt;
    }

    public void setIssAnt(BigDecimal issAnt) {
        this.issAnt = issAnt;
    }

    public BigDecimal getSestSenatAnt() {
        return sestSenatAnt;
    }

    public void setSestSenatAnt(BigDecimal sestSenatAnt) {
        this.sestSenatAnt = sestSenatAnt;
    }

    public BigDecimal getIrrfAnt() {
        return irrfAnt;
    }

    public void setIrrfAnt(BigDecimal irrfAnt) {
        this.irrfAnt = irrfAnt;
    }

    public BigDecimal getBaseIssAnt() {
        return baseIssAnt;
    }

    public void setBaseIssAnt(BigDecimal baseIssAnt) {
        this.baseIssAnt = baseIssAnt;
    }

    public BigDecimal getPorcInss() {
        return porcInss;
    }

    public void setPorcInss(BigDecimal porcInss) {
        this.porcInss = porcInss;
    }

    public BigDecimal getPorcIss() {
        return porcIss;
    }

    public void setPorcIss(BigDecimal porcIss) {
        this.porcIss = porcIss;
    }

    public BigDecimal getPorcSestSenat() {
        return porcSestSenat;
    }

    public void setPorcSestSenat(BigDecimal porcSestSenat) {
        this.porcSestSenat = porcSestSenat;
    }

    public BigDecimal getPorcIrrf() {
        return porcIrrf;
    }

    public void setPorcIrrf(BigDecimal porcIrrf) {
        this.porcIrrf = porcIrrf;
    }

    public BigDecimal getBaseSestSenatAnt() {
        return baseSestSenatAnt;
    }

    public void setBaseSestSenatAnt(BigDecimal baseSestSenatAnt) {
        this.baseSestSenatAnt = baseSestSenatAnt;
    }

    private String convertReferencia(Integer ref) {
        String mes = util.inserirCaractere(util.getMesEmUmPeriodo(ref).toString(), 2, Formato.NUM);
        String resultado = mes.concat("/").concat(util.getAnoEmUmPeriodo(ref).toString());
        return resultado;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getBaseIrrfAnt() {
        return baseIrrfAnt;
    }

    public void setBaseIrrfAnt(BigDecimal baseIrrfAnt) {
        this.baseIrrfAnt = baseIrrfAnt;
    }

    public BigDecimal getPensaoAnt() {
        return pensaoAnt;
    }

    public void setPensaoAnt(BigDecimal pensaoAnt) {
        this.pensaoAnt = pensaoAnt;
    }

    public String getReferenciaAnterior() {
        return referenciaAnterior;
    }

    public void setReferenciaAnterior(String referenciaAnterior) {
        this.referenciaAnterior = referenciaAnterior;
    }

    public BigDecimal getValorAnt() {
        return valorAnt;
    }

    public void setValorAnt(BigDecimal valorAnt) {
        this.valorAnt = valorAnt;
    }

    public Utils getUtil() {
        return util;
    }

    public String getFinanceiroAnt() {
        return financeiroAnt;
    }

    public void setFinanceiroAnt(String financeiroAnt) {
        this.financeiroAnt = financeiroAnt;
    }

    public List<Movimento> getMovimentosPorUsuario() {
        return movimentosPorUsuario;
    }

    public void setMovimentosPorUsuario(List<Movimento> movimentosPorUsuario) {
        this.movimentosPorUsuario = movimentosPorUsuario;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public BigDecimal getMaiorPorcentagem() {
        return maiorPorcentagem;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public BigDecimal getTotalValor() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Movimento movimento : movimentosPorUsuario) {
            valor = valor.add(movimento.getValor());
        }

        return valor;
    }

    public boolean isExisteMultiplo() {
        return existeMultiplo;
    }

    public BigDecimal getTotalBaseCalculo() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Movimento movimento : movimentosPorUsuario) {
            valor = valor.add(movimento.getValorBCalc());
        }

        return valor;
    }

    public BigDecimal getTotalDescontoInss() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Movimento movimento : movimentosPorUsuario) {
            valor = valor.add(movimento.getDesconto1());
        }

        return valor;
    }

    public BigDecimal getTotalDescontoVinte() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Movimento movimento : movimentosPorUsuario) {
            valor = valor.add(movimento.getDesconto2());
        }

        return valor;
    }

    public BigDecimal getTotalTotal() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Movimento movimento : movimentosPorUsuario) {
            valor = valor.add(movimento.getValorTotalDos11Bruto());
        }

        return valor;
    }

    public BigDecimal getValorLiquidoAnt() {
        BigDecimal total = BigDecimal.ZERO;

        if (valorAnt != null) {
            total = total.add(valorAnt);

            if (desconto1Ant != null) {
                total = total.subtract(desconto1Ant);
            }

            if (issAnt != null) {
                total = total.subtract(issAnt);
            }

            if (sestSenatAnt != null) {
                total = total.subtract(sestSenatAnt);
            }

            if (irrfAnt != null) {
                total = total.subtract(irrfAnt);
            }

            if (pensaoAnt != null) {
                total = total.subtract(pensaoAnt);
            }
        }

        return total;
    }

    public void limparIrrfEInss() {
        getEntity().setBaseIrrf(null);
        getEntity().setIrrf(null);
        getEntity().setDesconto1(null);
        getEntity().setValorBCalc(null);
        porcInss = null;
        porcIrrf = null;
        deducaoIrrf = null;
        aliquotaIrrf = null;
        calcularBaseInss();
        calcularIrrfEBase();
    }

    public void gerarRecibo(Movimento movimento) {
        movimentoBO.gerarRecibo(movimento);
    }

}
