package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.ReferenciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import br.gov.pi.siste.bo.cadastro.OrgaoBO;
import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.CarteiraTrabalho;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import br.gov.pi.siste.modelo.cadastro.Endereco;
import br.gov.pi.siste.modelo.cadastro.Estado;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.cadastro.enums.Formato;
import br.gov.pi.siste.modelo.cadastro.enums.StatusReferencia;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.sefip.ConstruirTxt;
import br.gov.pi.siste.modelo.sefip.RegistroTipo00;
import br.gov.pi.siste.modelo.sefip.RegistroTipo10;
import br.gov.pi.siste.modelo.sefip.RegistroTipo30;
import br.gov.pi.siste.modelo.sefip.RegistroTipo90;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.modelo.vos.MovimentoVO;
import br.gov.pi.siste.modelo.vos.PlanilhaControleAutonomosVO;
import br.gov.pi.siste.modelo.vos.RepassesVO;
import br.gov.pi.siste.modelo.vos.UnidadeVO;
import br.gov.pi.siste.modelo.vos.ValorUsadoPorUnidadeVO;
import br.gov.pi.siste.util.Utils;
import static com.xpert.Configuration.getEntityManager;
import javax.persistence.Query;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReferenciaBO extends AbstractBusinessObject<Referencia> {

    @EJB
    private ReferenciaDAO referenciaDAO;

    @EJB
    private MovimentoBO movimentoBO;

    @EJB
    private OrgaoBO orgaoBO;

    @EJB
    private UnidadeBO unidadeBO;

    @EJB
    private AliquotaIRRFBO irrfBO;

    private Utils util = new Utils();

    @Override
    public ReferenciaDAO getDAO() {
        return referenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(Referencia referencia) throws BusinessException {
        if (referencia.getStatus() == StatusReferencia.ABERTA) {
            if (verificarReferenciaAnterior(referencia, StatusReferencia.ABERTA)) {
                throw new BusinessException("Não pode cadastrar uma nova Competência se existir alguma em Aberto!!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Referencia pegarUltimaRerenciaAberta() {
        return getDAO().unique("status", StatusReferencia.ABERTA);
    }

    public boolean relatorioRepasses(FiltrosVO filtros) {
        HashMap params = new HashMap();
        String caminhoLogo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/06553564000138.png");
        String caminhoSubRelatorio = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/report/relatorios/");
        params.put("CAMINHO_IMAGEM", caminhoLogo);
        params.put("SUBREPORT_DIR", caminhoSubRelatorio);
        params.put("SUBREPORT_DIR2", caminhoSubRelatorio);
        params.put("DATA_ATUAL", util.convertDateToString(new Date(), 1));
        params.put("HORA_ATUAL", util.convertDateToString(new Date(), 5));
        params.put("USUARIO", util.inserirCaractere(filtros.getUsuario().getId().toString(), 5, Formato.NUM));
        params.put("VERSAO", "v. 1.0");
        params.put("COMPETENCIA", "COMPETÊNCIA: " + filtros.getReferencia().toString());
        params.put("NOME_SISTEMA", "Siste-@".concat(util.convertDateToString(new Date(), 11)).concat("ATI  "));

        List<RepassesVO> repasses = listaRepasses(filtros);
        if (repasses.size() > 0) {
            FacesJasper.createJasperReport(repasses, params,
                    "/WEB-INF/report/relatorios/repassesReport.jasper", "Relatorio de Repasses.pdf");
        } else {
            return true;
        }
        return false;
    }

    public boolean relatorioDeControleAutonomes(FiltrosVO filtros) {
        HashMap params = new HashMap();
        String caminhoLogo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/brasao2.png");
        params.put("CAMINHO_IMAGEM", caminhoLogo);
        params.put("DATA_ATUAL", util.convertDateToString(new Date(), 1));
        params.put("HORA_ATUAL", util.convertDateToString(new Date(), 5));
        params.put("USUARIO", util.inserirCaractere(filtros.getUsuario().getId().toString(), 5, Formato.NUM));
        params.put("VERSAO", "v. 1.0");
        params.put("COMPETENCIA", filtros.getReferencia().toString());
        params.put("NOME_SISTEMA", "Siste-@".concat(util.convertDateToString(new Date(), 11)).concat("ATI  "));

        List<PlanilhaControleAutonomosVO> planilha = listaControleAutonomos(filtros);
        if (planilha.size() > 0) {
            FacesJasper.createJasperReport(planilha, params,
                    "/WEB-INF/report/relatorios/ControleAutonomoReport.jasper", "Relatorio de Controle de Autonomo.pdf");
        } else {
            return true;
        }
        return false;
    }

    public List<RepassesVO> listaRepasses(FiltrosVO filtros) {

        List<Movimento> movimentos = movimentoBO.listarMovimentos(filtros); //Usuario e Referencia    

        List<Unidade> unidades = unidadeBO.unidadesPorMovimentos(movimentos);
        List<Orgao> orgaos = orgaoBO.orgaosPorUnidades(unidades);

        List<RepassesVO> repasses = new ArrayList<RepassesVO>();

        for (Orgao orgao : orgaos) {
            RepassesVO repasse = new RepassesVO(); //Lista orgaos do usuario (apenas um)
            repasse.setCnpj(util.format("##.###.###/####-##", orgao.getCnpj()));
            repasse.setNome(orgao.getNome());
            repasse.setCnpjENome(util.format("##.###.###/####-##", orgao.getCnpj()).concat(" - ").concat(orgao.getNome()));
            List<UnidadeVO> unidadesVO = new ArrayList<UnidadeVO>(); // Lista de UnidadesVO

            BigDecimal totalSalarioBrutoOrgaoTemp = BigDecimal.ZERO;

            BigDecimal totalBcalcOrgaoTemp = BigDecimal.ZERO;

            BigDecimal totalDescontoInssOrgaoTemp = BigDecimal.ZERO;

            BigDecimal totalDesconto20OrgaoTemp = BigDecimal.ZERO;

            BigDecimal totalValorTotalOrgaoTemp = BigDecimal.ZERO;

            Integer totalRegistrosGeral = new Integer(0);

            for (Unidade unidade : unidades) {
                UnidadeVO unidadeVO = new UnidadeVO();

                BigDecimal totalSalarioBrutoUnidadeTemp = BigDecimal.ZERO;

                BigDecimal totalBcalcUnidadeTemp = BigDecimal.ZERO;

                BigDecimal totalDescontoInssUnidadeTemp = BigDecimal.ZERO;

                BigDecimal totalDesconto20UnidadeTemp = BigDecimal.ZERO;

                BigDecimal totalValorTotalUnidadeTemp = BigDecimal.ZERO;

                Integer totalRegistros = new Integer(0);

                if (unidade.getOrgao().equals(orgao)) {
                    Orgao orgaoUnid = getDAO().getInitialized(unidade.getOrgao());
                    unidadeVO.setOrgao((util.format("##.###.###/####-##", orgaoUnid.getCnpj()).concat(" - ").concat(orgaoUnid.getNome())));
                    unidadeVO.setCnpj(util.format("##.###.###/####-##", unidade.getCnpj()));
                    unidadeVO.setCodigo(util.format("##.###.###/####-##", unidade.getCnpj()).concat(" - ").concat(unidade.getNome()));
                    unidadeVO.setNome(unidade.getNome());

                    List<MovimentoVO> movimentosVO = new ArrayList<MovimentoVO>();
                    for (Movimento movimento : movimentos) {
//                        Servidor servidor = getDAO().getInitialized(movimento.getServidor());
//                        CarteiraTrabalho carteira = getDAO().getInitialized(servidor.getCarteiraDeTrabalho());
//                        DadosFuncionais dados = getDAO().getInitialized(servidor.getDadosFuncionais());
//                        Unidade unidadeMov = getDAO().getInitialized(dados.getUnidade());
//                        FontePagador fonte = getDAO().getInitialized(movimento.getFonte());
                        MovimentoVO movimentoVO = new MovimentoVO();
                        if (movimento.getServidor().getDadosFuncionais().getUnidade().equals(unidade)) {
                            movimentoVO.setCpf(util.format("###.###.###-##", movimento.getServidor().getCpf()));
                            movimentoVO.setCredor(movimento.getServidor().getNome());
                            movimentoVO.setPisPasep(movimento.getServidor().getCarteiraDeTrabalho().getPisPasepNit());
                            movimentoVO.setValorBCalc(movimento.getValorBCalc());
                            movimentoVO.setValorBruto(movimento.getValor());
                            movimentoVO.setDescontoInss(movimento.getDesconto1());
                            movimentoVO.setDesconto20(movimento.getDesconto2());
                            movimentoVO.setDescricaoServico(movimento.getObservacao());
                            movimentoVO.setNotaEmpenho(movimento.getNeMov());
                            movimentoVO.setNotaLiquidacao(movimento.getNlMov());
                            movimentoVO.setFonte(movimento.getFonte().getCodigo().toString());
                            movimentoVO.setValorTotal(movimento.getValor().subtract(movimento.getDesconto1()));

                            totalSalarioBrutoUnidadeTemp = totalSalarioBrutoUnidadeTemp.add(movimento.getValor());
                            totalBcalcUnidadeTemp = totalBcalcUnidadeTemp.add(movimento.getValorBCalc());
                            totalDescontoInssUnidadeTemp = totalDescontoInssUnidadeTemp.add(movimento.getDesconto1());
                            totalDesconto20UnidadeTemp = totalDesconto20UnidadeTemp.add(movimento.getDesconto2());
                            totalValorTotalUnidadeTemp = totalValorTotalUnidadeTemp.add(movimento.getValorTotalDos11BCalc());
                            totalRegistros++;
                            totalRegistrosGeral++;
                            movimentosVO.add(movimentoVO); //add lista de movimentosVO
                        }
                    }
                    unidadeVO.setMovimentos(movimentosVO);
                    unidadeVO.setTotalSalarioBrutoUnidade(totalSalarioBrutoUnidadeTemp);
                    unidadeVO.setTotalBcalcUnidade(totalBcalcUnidadeTemp);
                    unidadeVO.setTotalDescontoInssUnidade(totalDescontoInssUnidadeTemp);
                    unidadeVO.setTotalDesconto20Unidade(totalDesconto20UnidadeTemp);
                    unidadeVO.setTotalValorTotalUnidade(totalValorTotalUnidadeTemp);
                    unidadeVO.setRegistrosPorUnidade(totalRegistros);

                    totalSalarioBrutoOrgaoTemp = totalSalarioBrutoOrgaoTemp.add(totalSalarioBrutoUnidadeTemp);
                    totalBcalcOrgaoTemp = totalBcalcOrgaoTemp.add(totalBcalcUnidadeTemp);
                    totalDescontoInssOrgaoTemp = totalDescontoInssOrgaoTemp.add(totalDescontoInssUnidadeTemp);
                    totalDesconto20OrgaoTemp = totalDesconto20OrgaoTemp.add(totalDesconto20UnidadeTemp);
                    totalValorTotalOrgaoTemp = totalValorTotalOrgaoTemp.add(totalValorTotalUnidadeTemp);

                    unidadesVO.add(unidadeVO);
                }
            }

            if (unidadesVO.size() > 0) {
                repasse.setUnidades(unidadesVO);

                repasse.setTotalSalarioBrutoOrgao(totalSalarioBrutoOrgaoTemp);
                repasse.setTotalBcalcOrgao(totalBcalcOrgaoTemp);
                repasse.setTotalDescontoInssOrgao(totalDescontoInssOrgaoTemp);
                repasse.setTotalDesconto20Orgao(totalDesconto20OrgaoTemp);
                repasse.setTotalValorTotalOrgao(totalValorTotalOrgaoTemp);
                repasse.setRegistroPorOrgaos(totalRegistrosGeral);

                repasses.add(repasse);

            }

        }

        return repasses;

    }

    public List<PlanilhaControleAutonomosVO> listaControleAutonomos(FiltrosVO filtros) {

        List<Movimento> movimentos = movimentoBO.listarMovimentos(filtros); //Usuario e Referencia    

        List<PlanilhaControleAutonomosVO> lista = new ArrayList<PlanilhaControleAutonomosVO>();

        for (Movimento movimento : movimentos) {
            PlanilhaControleAutonomosVO planilha = new PlanilhaControleAutonomosVO();
            planilha.setNumeroNota(movimento.getNeMov());
            planilha.setDataPagamento(util.convertDateToString(movimento.getDataPagamento(), 1));
            planilha.setElementoDespesa(filtros.getElementoDespesa());
//            Servidor servidor = getDAO().getInitialized(movimento.getServidor());
//            CarteiraTrabalho carteira = getDAO().getInitialized(servidor.getCarteiraDeTrabalho());
            planilha.setNitPisPasep(movimento.getServidor().getCarteiraDeTrabalho().getPisPasepNit());
            planilha.setNome(movimento.getServidor().getNome());
            planilha.setValorBruto(movimento.getValor());
            planilha.setInss(movimento.getDesconto1());
            BigDecimal irrf = movimento.getIrrf();
            planilha.setIrrf(irrf);

            if (movimento.getIss() != null) {
                planilha.setIss(movimento.getIss());
            }

            if (movimento.getSestSenat() != null) {
                planilha.setSestSenat(movimento.getSestSenat());
            }

            lista.add(planilha);
        }
        return lista;
    }

    public boolean verificarReferenciaAnterior(Referencia referenciaAtual, StatusReferencia status) {

        Restrictions restrictions = new Restrictions();

        if (status == StatusReferencia.PROCESSADA) {
            restrictions.add("codigo", util.periodoAnterior(referenciaAtual.getCodigo()));
            restrictions.add("status", StatusReferencia.FECHADA);
        } else {
            restrictions.add("status", status);
        }

        Referencia referenciaAnterior = referenciaDAO.unique(restrictions);

        if (referenciaAnterior == null) {
            return false;
        } else {
            if (referenciaAtual.equals(referenciaAnterior)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public Integer pegarProximaReferencia() {

        Integer periodoAtual = (Integer) getDAO().getQueryBuilder().from(Referencia.class).max("codigo", new Integer(0));
        Integer mes;
        Integer ano;
        String periodoProximo;

        if (periodoAtual > 0) {
            mes = util.getMesEmUmPeriodo(periodoAtual) + 1;
            ano = util.getAnoEmUmPeriodo(periodoAtual);
            if ((mes) > 12) {
                mes = 1;
                ano = (util.getAnoEmUmPeriodo(periodoAtual) + 1);
            }

            periodoProximo = (ano.toString().concat(util.inserirCaractere(mes.toString(), 2, Formato.NUM)));

        } else {
            periodoProximo = util.convertDateToString(new Date(), 9);
        }

        return new Integer(periodoProximo);
    }

    public String montarSefip(FiltrosVO filtros) {
        String corpo = "";
        List<Movimento> movimentos = movimentoBO.listarMovimentos(filtros); //Usuario e Referencia    

        List<Unidade> unidades = unidadeBO.unidadesPorMovimentos(movimentos);
        List<Orgao> orgaos = orgaoBO.orgaosPorUnidades(unidades);
        Endereco endereco;
        Cidade cidade;
        Estado estado;
        Referencia referencia;

        for (Orgao orgao : orgaos) {
            RegistroTipo00 tipo00 = new RegistroTipo00();
            RegistroTipo90 tipo90 = new RegistroTipo90();
            ConstruirTxt build = new ConstruirTxt();

            tipo00.set01_tipoRegistro("00"); // 00
            tipo00.set02_branco(""); // 
            tipo00.set03_tipoRemessa("1");//1 para gfip
            tipo00.set04_tipoInscricaoResp("1");
            tipo00.set05_inscricaoResp(orgao.getCnpj());
            tipo00.set06_nomeResp(util.retiraCaracteresEspeciais(orgao.getNome()));
            tipo00.set07_nomePessContato(util.retiraCaracteresEspeciais(orgao.getNomeContato()));

            endereco = getDAO().getInitialized(orgao.getEndereco());
            cidade = getDAO().getInitialized(endereco.getCidade());
            estado = getDAO().getInitialized(cidade.getEstado());
            referencia = getDAO().getInitialized(filtros.getReferencia());

            tipo00.set08_endereco(util.retiraCaracteresEspeciais(endereco.getEndereco()).concat(" ").concat(endereco.getNumero()));
            tipo00.set09_bairro(util.retiraCaracteresEspeciais(endereco.getBairro()));
            tipo00.set10_cep(util.retiraCaracteresEspeciais(endereco.getCep()));
            tipo00.set11_cidade(util.retiraCaracteresEspeciais(cidade.getNome()));
            tipo00.set12_unidadeFederacao(util.retiraCaracteresEspeciais(estado.getSigla()));
            tipo00.set13_telefoneContato(util.retiraCaracteresEspeciais(orgao.getTelefoneContato()));
            tipo00.set14_endInternContato(orgao.getEmailContato() != null ? orgao.getEmailContato() : "");
            tipo00.set15_competencia(referencia.getCodigo().toString());
            tipo00.set16_codRecolhimento(orgao.getCodigoRecolhimento());
            tipo00.set17_indRecolhFGTS("1");
            tipo00.set18_modalidadeArquivo("1");
            tipo00.set19_dataRecolhFGTS("");
            tipo00.set20_indRecolhPrevSocial("1");
            tipo00.set21_dataRecolhPrevSocial("");
            tipo00.set22_indRecolhAtrasoPrevSocial("");
            tipo00.set23_tipoInscFornFolhaPag("1");
            tipo00.set24_inscFornFolhaPag(orgao.getCnpj());
            tipo00.set25_branco("");
            tipo00.set26_finalLinha("*");

            corpo += build.setRegistroTipo00(tipo00);

            for (Unidade unidade : unidades) {
                RegistroTipo10 tipo10 = new RegistroTipo10();
                endereco = getDAO().getInitialized(unidade.getEndereco());
                cidade = getDAO().getInitialized(endereco.getCidade());
                estado = getDAO().getInitialized(cidade.getEstado());
                tipo10.set01_tipoRegistro("10");
                tipo10.set02_tipoInscricao_Empresa("1");
                tipo10.set03_inscricaoEmpresa(unidade.getCnpj());
                tipo10.set04_zeros("0");
                tipo10.set05_nomeEmpresa(util.retiraCaracteresEspeciais(unidade.getNome()));
                tipo10.set06_logradouro(util.retiraCaracteresEspeciais((endereco.getEndereco()).concat(" ").concat(endereco.getNumero())));
                tipo10.set07_bairro(util.retiraCaracteresEspeciais(endereco.getBairro()));
                tipo10.set08_cep(util.retiraCaracteresEspeciais(endereco.getCep()));
                tipo10.set09_cidade(util.retiraCaracteresEspeciais(cidade.getNome()));
                tipo10.set10_unidadeFederacao(estado.getSigla());
                tipo10.set11_telefone(util.retiraCaracteresEspeciais(unidade.getTelefoneContato()));
                tipo10.set12_indAlterEndereco("N");
                if (unidade.getCodigoCNAE() != null) {
                    tipo10.set13_cnae(unidade.getCodigoCNAE().equals("") ? orgao.getCodigoCNAE() : unidade.getCodigoCNAE());
                } else {
                    tipo10.set13_cnae(orgao.getCodigoCNAE());
                }
                tipo10.set14_indAlterCnae("N");
                tipo10.set15_aliquota_RAT(unidade.getAliquotaRAT() != null ? util.retiraCaracteresEspeciais(String.format("%.2f", unidade.getAliquotaRAT()).substring(0, 3))
                        : util.retiraCaracteresEspeciais(String.format("%.2f", orgao.getAliquotaRAT()).substring(0, 3)));
                tipo10.set16_codigo_Centralizacao("0"); // centralizador
                tipo10.set17_simples("1");
                if (unidade.getCodigoFPAS() != null) {
                    tipo10.set18_fpas(unidade.getCodigoFPAS().equals("") ? orgao.getCodigoFPAS() : unidade.getCodigoFPAS());
                } else {
                    tipo10.set18_fpas(orgao.getCodigoFPAS());
                }
                if (unidade.getOutraEntidade() != null) {
                    tipo10.set19_codOutrasEntidades(unidade.getOutraEntidade().equals("") ? orgao.getOutraEntidade() : unidade.getOutraEntidade());
                } else {
                    tipo10.set19_codOutrasEntidades(orgao.getOutraEntidade());
                }
                if (unidade.getPagamentoGPS() != null) {
                    tipo10.set20_codigoPagGps(unidade.getPagamentoGPS().equals("") ? orgao.getPagamentoGPS() : unidade.getPagamentoGPS());
                } else {
                    tipo10.set20_codigoPagGps(orgao.getPagamentoGPS());
                }
                tipo10.set21_percInsenFilantropia("");
                tipo10.set22_salarioFamilia("0");
                tipo10.set23_salarioMaternidade("0");
                tipo10.set24_contribDescEmpComp13("0");
                tipo10.set25_indValorNegatOuPosit("0");
                tipo10.set26_valorDevidPrevSocialComp13("0");
                tipo10.set27_banco("");
                tipo10.set28_agencia("");
                tipo10.set29_contaCorrente("");
                tipo10.set30_zeros("0");
                tipo10.set31_brancos("");
                tipo10.set32_finalLinha("*");

                corpo += build.setRegistroTipo10(tipo10);

                for (Movimento movimento : movimentos) {
                    Servidor servidor = getDAO().getInitialized(movimento.getServidor());
                    CarteiraTrabalho carteira = getDAO().getInitialized(servidor.getCarteiraDeTrabalho());
                    DadosFuncionais dados = getDAO().getInitialized(servidor.getDadosFuncionais());
                    Cargo cargo = getDAO().getInitialized(dados.getCargo());
                    Unidade unidadeMov = getDAO().getInitialized(dados.getUnidade());
                    if (unidade.equals(unidadeMov)) {
                        RegistroTipo30 tipo30 = new RegistroTipo30();
                        tipo30.set01_tipoRegistro("30");
                        tipo30.set02_tipoInscEmpresa("1");
                        tipo30.set03_inscEmpresa(unidadeMov.getCnpj());
                        tipo30.set04_tipoInscTomadorObraConstCivil("");
                        tipo30.set05_inscInscTomadorObraConstCivil("");
                        tipo30.set06_pisPasepCI(util.retiraCaracteresEspeciais(carteira.getPisPasepNit()));
                        tipo30.set07_dataAdmissao("");
                        tipo30.set08_categoriaTrabalhador(movimento.getFinanceiro().getNum() + "");
                        tipo30.set09_nomeTrabalhador(util.retiraCaracteresEspeciais(servidor.getNome()));
                        tipo30.set10_matriculaEmpregado("");
                        tipo30.set11_numeroCTPS("");
                        tipo30.set12_serieCTPS("");
                        tipo30.set13_dataOpcao("");
                        tipo30.set14_dataNascimento("");
                        tipo30.set15_cbo((cargo.getCodigo().substring(0, 4)));
                        tipo30.set16_remuneracaoSem13(util.retiraCaracteresEspeciais(String.format("%.2f", movimento.getValor())));
                        tipo30.set17_remuneracao13("0");
                        tipo30.set18_classeContribuicao("");
                        tipo30.set19_ocorrencia(movimento.getOcorrencia() != null ? util.inserirCaractere(movimento.getOcorrencia().getNum() + "", 2, Formato.NUM)
                                : util.inserirCaractere("", 2, Formato.ALFA));
                        tipo30.set20_valorDesconDoSegurado(util.retiraCaracteresEspeciais(String.format("%.2f", movimento.getDesconto1())));
                        tipo30.set21_remuneracaoBCalcContribPrevidenciaria("0");
                        tipo30.set22_baseCalc13SalPrevSocialMov("0");
                        tipo30.set23_BaseCalc13SalPrevSocialGPS("0");
                        tipo30.set24_brancos("");
                        tipo30.set25_finalLinha("*");

                        corpo += build.setRegistroTipo30(tipo30);
                    }

                }
            }
            tipo90.set01_tipoRegistro("90");
            tipo90.set02_marcaFinalRegistro("999999999999999999999999999999999999999999999999999");
            tipo90.set03_brancos("");
            tipo90.set04_finalLinha("*");

            corpo += build.setRegistroTipo90(tipo90);
        }

        return corpo;
    }

    public List<ValorUsadoPorUnidadeVO> listarValorUsadoPorUnidade(FiltrosVO filtros) {
        List<ValorUsadoPorUnidadeVO> lista = new ArrayList<ValorUsadoPorUnidadeVO>();
        String queryString = "select u.codigo, u.nome, sum(valor) as valor_usado, u.valorlimite as valor_disponivel, cast ((sum(valor)*100/u.valorlimite) as numeric(19,2)) as porcentagem "
                + "from movimento m left join referencia r on (r.id=m.referencia_id) left join servidor s on (s.id=m.servidor_id) left join dadosfuncionais d "
                + "on (d.id=s.dadosfuncionais_id) left join unidade u on (u.id=d.unidade_id) where r.id=REF_PASSADA ";

        if (filtros.getUnidade() != null) {
            queryString = queryString.concat("AND u.id=UNID_PASSADA ").replace("UNID_PASSADA", filtros.getUnidade().getId().toString());
        }

        if (filtros.getReferencia() != null) {
            queryString = queryString.concat("group by u.codigo, u.nome, u.valorlimite order by u.codigo;").
                    replace("filtros.getReferencia()", filtros.getReferencia().getId().toString());
            Query query;

            query = getEntityManager().createNativeQuery(queryString.replace("REF_PASSADA", filtros.getReferencia().getId().toString()));

            List<Object[]> resultado = query.getResultList();

            for (Object[] tupla : resultado) {
                ValorUsadoPorUnidadeVO unidade = new ValorUsadoPorUnidadeVO();

                if (tupla[0] != null) {
                    unidade.setCodigo((Integer) tupla[0]);
                }
                if (tupla[1] != null) {
                    unidade.setNome((String) tupla[1]);
                }
                if (tupla[2] != null) {
                    unidade.setValorUsado((BigDecimal) tupla[2]);
                }
                if (tupla[3] != null) {
                    unidade.setValorLimite((BigDecimal) tupla[3]);
                }
                if (tupla[4] != null) {
                    unidade.setPorcentagem((BigDecimal) tupla[4]);
                }
                lista.add(unidade);
            }

        }

        return lista;
    }

}
