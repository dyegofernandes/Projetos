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
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import br.gov.pi.siste.modelo.financeiro.FontePagador;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import br.gov.pi.siste.util.Utils;

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

    private boolean existeMultiplo = false;

    private String codigo;
    
    private String unidade;

    private String cargo;

    private String referenciaAnterior = "";

    private String financeiroAnt;

    private Referencia referenciaA;

    private String fonteA;

    private BigDecimal valorAnt;

    private BigDecimal valorBCalcAnt;

    private BigDecimal desconto1Ant;

    private BigDecimal desconto2Ant;

    private BigDecimal valorTotalAnt;

    private BigDecimal maiorPorcentagem;

    private BigDecimal issAnt;

    private BigDecimal sestSenatAnt;

    private BigDecimal irrfAnt;

    private BigDecimal baseIrrfAnt;

    private BigDecimal pensaoAnt;

    private Unidade unidadeFiltro;

    private FiltrosVO filtros;

    private Utils util = new Utils();

    private Usuario usuarioAtual;

    private List<Movimento> movimentosPorUsuario = new ArrayList<Movimento>();

    private List<Unidade> unidades = new ArrayList<Unidade>();

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

        unidades = unidadeBO.listarUnidades(filtros);

//        movimentosPorUsuario = movimentoBO.listarMovimentos(filtros);
        if (getEntity().getId() != null) {
            carregarDadosVelhos();
        } else {
            carregarDadosNovos();
        }

        if (!SessaoUtils.getUser().isSuperUsuario()) {
            unidadeFiltro = usuarioAtual.getUnidade();
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
        if (getEntity().getReferencia() != null && getEntity().getInss() != null && getEntity().getIr() != null) {
            Servidor servidorTemp = servidorBO.getServidorPeloCodigo(unidadeFiltro, codigo);

            if (servidorTemp != null) {
                existeMultiplo = movimentoBO.trabalhadorApareceNaCompetencia(getEntity().getReferencia(), servidorTemp);
                if (existeMultiplo) {
                    getEntity().setOcorrencia(Ocorrencia.MULTIPLOS_VINCULOS);
                } else {
                    getEntity().setOcorrencia(null);
                }
                getEntity().setServidor(servidorTemp);
// 
                unidade = servidorTemp.getDadosFuncionais().getUnidade().toString();
                cargo = servidorTemp.getDadosFuncionais().getCargo().toString();
                
                Movimento movimentoAnterior = movimentoBO.movimentoAnteriorTrabalhador(servidorTemp, referenciaA);

                if (movimentoAnterior != null) {
                    financeiroAnt = movimentoAnterior.getFinanceiro().getDescricao();
                    fonteA = getBO().getDAO().getInitialized(movimentoAnterior.getFonte()).toString();
                    valorAnt = movimentoAnterior.getValor();
                    valorBCalcAnt = movimentoAnterior.getValorBCalc();
                    desconto1Ant = movimentoAnterior.getDesconto1();
                    desconto2Ant = movimentoAnterior.getDesconto2();
                    valorTotalAnt = movimentoAnterior.getValorTotalDos11BCalc();
                    issAnt = movimentoAnterior.getIss();
                    irrfAnt = movimentoAnterior.getIrrf();
                    baseIrrfAnt = movimentoAnterior.getBaseIrrf();
                    sestSenatAnt = movimentoAnterior.getSestSenat();
                    pensaoAnt = movimentoAnterior.getPensao();
                } else {
                    financeiroAnt = "";
                    fonteA = null;
                    valorAnt = BigDecimal.ZERO;
                    valorBCalcAnt = BigDecimal.ZERO;;
                    desconto1Ant = BigDecimal.ZERO;;
                    desconto2Ant = BigDecimal.ZERO;;
                    valorTotalAnt = BigDecimal.ZERO;
                    issAnt = BigDecimal.ZERO;
                    irrfAnt = BigDecimal.ZERO;
                    baseIrrfAnt = BigDecimal.ZERO;
                    sestSenatAnt = BigDecimal.ZERO;
                    pensaoAnt = BigDecimal.ZERO;
                }
            } else {
                if (codigo != null && !codigo.equals("")) {
                    FacesMessageUtils.error("Não existe Servidor com esse CPF: ".concat(util.format("###.###.###-##", codigo).concat(" cadastrado para essa Unidade!")));
                    limparCampos();
                }

            }
        } else {
            FacesMessageUtils.error("Não existe Competência em Aberto, Tabela Inss ou Tabela IRRF Cadastrada no Sistema, entre em contato com o Administrador do Sistema!");

        }
    }

    private String getMes(String periodo) {
        return periodo.substring(4, 6);
    }

    private String getAno(String periodo) {
        return periodo.substring(0, 4);
    }

    public void calcularDesconto() {

        AliquotaInss aliquota = aliquotaInssBO.pegarAliquota(getEntity().getInss(), getEntity().getValor());

        if (aliquota != null) {
            maiorPorcentagem = aliquotaInssBO.pegarMaiorPorcentagem(getEntity().getInss());
            if (aliquota.getValorFixo().compareTo(BigDecimal.ZERO) == 0) {
                getEntity().setValorBCalc(getEntity().getValor());
            } else {
                getEntity().setValorBCalc(aliquota.getSalarioInicial());
            }
            getEntity().setDesconto1(util.calcularPorcentagem(maiorPorcentagem, getEntity().getValorBCalc()));
            getEntity().setDesconto2(util.calcularPorcentagem(new BigDecimal(20), getEntity().getValorBCalc()));
        } else {
            FacesMessageUtils.error("Alíquota não cadastrada para esse valor!");
        }
    }

    public void calcularIss() {
//        if (getEntity().getServidor() != null && getEntity().getValor() != null) {
//            Servidor servidor = getBO().getDAO().getInitialized(getEntity().getServidor());
//            if (servidor.getNumInscPrefeitura() == null) {
//                DadosFuncionais dados = getBO().getDAO().getInitialized(servidor.getDadosFuncionais());
//                Unidade unidadeTemp = getBO().getDAO().getInitialized(dados.getUnidade());
//                getEntity().setIss(util.calcularPorcentagem(unidadeTemp.getPorcentagemIss(), getEntity().getValor()));
//            }
//        } else {
//            getEntity().setIss(BigDecimal.ZERO);
//        }
    }

    public void calcularIrrfEBase() {
        if (getEntity().getValor() != null && getEntity().getIr() != null) {
            BigDecimal base = aliquotaIRRFBO.baseIrrf(getEntity().getServidor(), getEntity().getIr(), getEntity().getValor(),
                    getEntity().getDesconto1(), getEntity().getPensao());
            BigDecimal desconto = aliquotaIRRFBO.calcularDesconto(getEntity().getIr(), base);
            getEntity().setBaseIrrf(base);
            getEntity().setIrrf(desconto);
        } else {
            getEntity().setBaseIrrf(BigDecimal.ZERO);
            getEntity().setIrrf(BigDecimal.ZERO);
        }
    }

    private void carregarDadosNovos() {
        Referencia referencia = referenciaBO.pegarUltimaRerenciaAberta();
        TabelaInss tabelaInss = tabelaInssBO.getTabelaAtual();
        TabelaIRRF tabelaIRRF = tabelaIrrfBO.getTabelaAtual();

        if (referencia != null) {
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

        if (tabelaInss != null) {
            getEntity().setInss(tabelaInss);
        } else {
            FacesMessageUtils.error("Movimento não pode ser cadastrado sem uma Tabela de Inss cadastrada!");
        }

        if (tabelaIRRF != null) {
            getEntity().setIr(tabelaIRRF);
        } else {
            FacesMessageUtils.error("Movimento não pode ser cadastrado sem uma Tabela de IR cadastrada!");
        }
    }

    private void carregarDadosVelhos() {
        Referencia referencia = movimentoBO.getDAO().getInitialized(getEntity().getReferencia());
        referenciaA = referenciaBO.getDAO().unique("codigo", util.periodoAnterior(referencia.getCodigo()));
        referenciaAnterior = referenciaA != null ? convertReferencia(referenciaA.getCodigo()) : convertReferencia(util.periodoAnterior(referencia.getCodigo()));
        Servidor servidorTemp = movimentoBO.getDAO().getInitialized(getEntity().getServidor());
        DadosFuncionais dados = getBO().getDAO().getInitialized(servidorTemp.getDadosFuncionais());
        Unidade unidadeTemp = getBO().getDAO().getInitialized(dados.getUnidade());
        Cargo cargoTemp = getBO().getDAO().getInitialized(dados.getCargo());
        unidade = unidadeTemp.getNome();
        cargo = cargoTemp.getNome();
        Restrictions restrictions = new Restrictions();
        Movimento movimentoAnterior = null;
        if (referenciaA != null) {
            restrictions.add("servidor", servidorTemp);
            restrictions.add("referencia", referenciaA);
            movimentoAnterior = movimentoBO.getDAO().unique(restrictions);
        }

        if (movimentoAnterior != null) {
            financeiroAnt = movimentoAnterior.getFinanceiro().getDescricao();
            fonteA = movimentoAnterior.getFonte().toString();
            valorAnt = movimentoAnterior.getValor();
            valorBCalcAnt = movimentoAnterior.getValorBCalc();
            desconto1Ant = movimentoAnterior.getDesconto1();
            desconto2Ant = movimentoAnterior.getDesconto2();
            valorTotalAnt = movimentoAnterior.getValorTotalDos11BCalc();
            issAnt = movimentoAnterior.getIss();
            irrfAnt = movimentoAnterior.getIrrf();
            sestSenatAnt = movimentoAnterior.getSestSenat();
            pensaoAnt = movimentoAnterior.getPensao();
            baseIrrfAnt = movimentoAnterior.getBaseIrrf();
        } else {
            financeiroAnt = "";
            fonteA = null;
            valorAnt = BigDecimal.ZERO;
            valorBCalcAnt = BigDecimal.ZERO;;
            desconto1Ant = BigDecimal.ZERO;;
            desconto2Ant = BigDecimal.ZERO;;
            valorTotalAnt = BigDecimal.ZERO;
            issAnt = BigDecimal.ZERO;
            irrfAnt = BigDecimal.ZERO;
            baseIrrfAnt = BigDecimal.ZERO;
            sestSenatAnt = BigDecimal.ZERO;
            pensaoAnt = BigDecimal.ZERO;
        }
    }

    private void limparCampos() {
        setEntity(new Movimento());
        codigo = "";
        unidade = "";
        cargo = "";
        financeiroAnt = "";
        fonteA = null;
        valorAnt = BigDecimal.ZERO;
        valorBCalcAnt = BigDecimal.ZERO;;
        desconto1Ant = BigDecimal.ZERO;;
        desconto2Ant = BigDecimal.ZERO;;
        valorTotalAnt = BigDecimal.ZERO;
        issAnt = BigDecimal.ZERO;
        irrfAnt = BigDecimal.ZERO;
        sestSenatAnt = BigDecimal.ZERO;
        pensaoAnt = BigDecimal.ZERO;
        baseIrrfAnt = BigDecimal.ZERO;
        carregarDadosNovos();
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

    private String convertReferencia(Integer ref) {
        String mes = util.inserirCaractere(util.getMesEmUmPeriodo(ref).toString(), 2, Formato.NUM);
        String resultado = mes.concat("/").concat(util.getAnoEmUmPeriodo(ref).toString());
        return resultado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Unidade getUnidadeFiltro() {
        return unidadeFiltro;
    }

    public void setUnidadeFiltro(Unidade unidadeFiltro) {
        this.unidadeFiltro = unidadeFiltro;
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

    public void gerarRecibo(Movimento movimento) {
        movimentoBO.gerarRecibo(movimento);
    }
}
