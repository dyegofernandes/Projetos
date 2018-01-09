package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.MovimentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.dao.cadastro.OrgaoDAO;
import br.gov.pi.siste.modelo.cadastro.Cargo;
import br.gov.pi.siste.modelo.cadastro.CarteiraTrabalho;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import br.gov.pi.siste.modelo.cadastro.Endereco;
import br.gov.pi.siste.modelo.cadastro.Estado;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Rg;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import br.gov.pi.siste.modelo.financeiro.FontePagador;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.modelo.vos.RelatorioDeRepasseAuxVO;
import br.gov.pi.siste.modelo.vos.RelatorioDeRepasseVO;
import br.gov.pi.siste.util.SessaoUtils;
import br.gov.pi.siste.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.query.QueryBuilder;
import java.util.HashMap;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@Stateless
public class MovimentoBO extends AbstractBusinessObject<Movimento> {

    @EJB
    private MovimentoDAO movimentoDAO;

    @EJB
    private OrgaoDAO orgaoDAO;

    @EJB
    private AliquotaInssBO inssBO;

    @EJB
    private AliquotaIRRFBO irrfBO;

    @EJB
    private ReferenciaBO referenciaBO;

    private Utils util = new Utils();

    private Usuario usuarioAtual;

    @Override
    public MovimentoDAO getDAO() {
        return movimentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("servidor", "referencia", "financeiro");
    }

    @Override
    public void validate(Movimento movimento) throws BusinessException {
        usuarioAtual = SessaoUtils.getUser();
        BigDecimal valorAtual = BigDecimal.ZERO;
        Restrictions restrictions = new Restrictions();
        Servidor servidor = getDAO().getInitialized(movimento.getServidor());

        if (servidor == null) {
            throw new BusinessException("Trabalhador é Obrigatório!");
        }

        DadosFuncionais dados = getDAO().getInitialized(servidor.getDadosFuncionais());
        Unidade unidade = getDAO().getInitialized(dados.getUnidade());
        restrictions.add("servidor.dadosFuncionais.unidade", unidade);
        restrictions.add("referencia", movimento.getReferencia());

        if (movimento.getId() != null) {
            restrictions.notIn("id", movimento.getId());
        }
        valorAtual = valorAtual.add(movimento.getValor());

        BigDecimal somaTotal = (BigDecimal) movimentoDAO.getQueryBuilder().add(restrictions).from(Movimento.class).sum("valor", BigDecimal.ZERO);
        somaTotal = somaTotal.add(valorAtual);
        if (!usuarioAtual.isSuperUsuario() && somaTotal.compareTo(unidade.getValorLimite()) > 0) {
            throw new BusinessException("O valor total da Unidade ultrapassado! Entre em contato com o administrador!");
        }

        if (!(movimento.getValor().compareTo(BigDecimal.ZERO) > 0)) {
            throw new BusinessException("O valor do movimento deve ser maior que Zero!");
        }

        if (!(movimento.getValor().compareTo(movimento.getDesconto1()) > 0)) {
            throw new BusinessException("O valor do movimento deve ser maior que o valor do desconto Inss!");
        }

        if (!(movimento.getValorBCalc().compareTo(BigDecimal.ZERO) > 0)) {
            throw new BusinessException("O valor da base de cálculo do movimento deve ser maior que Zero!");
        }
        if (descontoMaiorQueTeto(movimento.getInss(), movimento.getDesconto1())) {
            throw new BusinessException("O valor do desconto do Inss não pode ser maior que o Teto do Inss");
        }

    }

    private boolean descontoMaiorQueTeto(TabelaInss tabela, BigDecimal desconto) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("tabelaInss", tabela);
        restrictions.greaterThan("valorFixo", BigDecimal.ZERO);
        AliquotaInss aliquota = inssBO.getDAO().unique(restrictions);

        if (aliquota != null) {

            if (desconto.compareTo(aliquota.getValorFixo()) > 0) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    /**
     * @author Juniel Alves
     * @param Referencia referencia, Servidor servidor
     * @return boolean
     * @description Método verifica se o cpf esta em um movimento na competencia
     * de acordo com o cpf
     */
    public boolean trabalhadorApareceNaCompetencia(Referencia referencia, Servidor servidor) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("referencia", referencia);
        restrictions.add("servidor.cpf", servidor.getCpf());

        List<Movimento> movimentos = movimentoDAO.getQueryBuilder().selectDistinct("movimento").from(Movimento.class, "movimento")
                .innerJoinFetch("movimento.referencia", "referencia").innerJoinFetch("movimento.servidor", "servidor")
                .add(restrictions).getResultList();

        for (Movimento movimento : movimentos) {
            Servidor servidorMov = getDAO().getInitialized(movimento.getServidor());
            if (!servidor.equals(servidorMov)) {
                if (servidor.getCpf().equals(servidorMov.getCpf())) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<Movimento> listarMovimentos(FiltrosVO filtros) {

        Restrictions restrictions = new Restrictions();
        Unidade unidade = null;
        Orgao orgao = null;
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());

        List<Movimento> movimentos;

        if (!usuario.isSuperUsuario()) {
            unidade = getDAO().getInitialized(usuario.getUnidade());
            orgao = getDAO().getInitialized(usuario.getOrgao());
            restrictions.add("orgao", orgao);
            if (usuario.getUnidade() != null) {
                restrictions.add("unidade", unidade);
            } else {
                if (filtros.getUnidade() != null) {
                    unidade = getDAO().getInitialized(filtros.getUnidade());
                    restrictions.add("unidade", unidade);
                }
            }

        } else {
            if (filtros.getOrgao() != null) {
                restrictions.add("orgao", filtros.getOrgao());
            }
            if (filtros.getUnidade() != null) {
                unidade = getDAO().getInitialized(filtros.getUnidade());
                restrictions.add("unidade", unidade);
            }
        }

        if (filtros.getCpf() != null && !filtros.getCpf().equals("")) {
            restrictions.add("servidor.cpf", filtros.getCpf());
        }

        if (filtros.getReferencia() != null) {
            restrictions.add("referencia", filtros.getReferencia());
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("servidor.nome", filtros.getNome());
        }

        if (filtros.getCargo() != null) {
            restrictions.add("cargo", filtros.getCargo());
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }

        QueryBuilder query = movimentoDAO.getQueryBuilder().select("movimento").from(Movimento.class, "movimento").innerJoin("movimento.fonte", "fonte").
                innerJoin("movimento.ir", "tabelairrf").innerJoin("movimento.inss", "tabelainss").innerJoinFetch("movimento.servidor", "servidor").
                innerJoinFetch("movimento.referencia", "referencia").innerJoinFetch("servidor.dadosFuncionais", "dados").innerJoinFetch("dados.unidade", "unidade").
                innerJoinFetch("unidade.endereco", "endereco").innerJoinFetch("endereco.cidade", "cidade").innerJoinFetch("dados.cargo", "cargo").
                innerJoinFetch("unidade.orgao", "orgao").add(restrictions).innerJoinFetch("servidor.carteiraDeTrabalho", "carteira");

        if (filtros.isGfip()) {
            query = query.orderBy("referencia.codigo Desc, orgao.cnpj, unidade.cnpj, carteira.pisPasepNit");
        } else {
            query = query.orderBy("referencia.codigo Desc, orgao, unidade, servidor.nome");
        }

        movimentos = query.getResultList();

        return movimentos;
    }
    
    public Movimento movimentoAnteriorTrabalhador(Servidor servidor, Referencia referencia){
        Movimento movimento = null;
        Restrictions restrictions = new Restrictions();
        restrictions.add("servidor", servidor);
        restrictions.add("referencia", referencia);
        
        QueryBuilder query = movimentoDAO.getQueryBuilder().select("movimento").from(Movimento.class, "movimento").innerJoin("movimento.fonte", "fonte").
                innerJoin("movimento.ir", "tabelairrf").innerJoin("movimento.inss", "tabelainss").innerJoinFetch("movimento.servidor", "servidor").
                innerJoinFetch("movimento.referencia", "referencia").innerJoinFetch("servidor.dadosFuncionais", "dados").innerJoinFetch("dados.unidade", "unidade").
                innerJoinFetch("unidade.endereco", "endereco").innerJoinFetch("endereco.cidade", "cidade").innerJoinFetch("dados.cargo", "cargo").
                innerJoinFetch("unidade.orgao", "orgao").add(restrictions).innerJoinFetch("servidor.carteiraDeTrabalho", "carteira");
       
        movimento = (Movimento) query.getSingleResult();
        
        return movimento;
    }

    public List<RelatorioDeRepasseVO> relatorioRepasses(Referencia referencia) {
        List<Orgao> orgaos = orgaoDAO.listAll("nome");

        List<RelatorioDeRepasseVO> lista = new ArrayList<RelatorioDeRepasseVO>();
        List<Movimento> movimentos = movimentoDAO.list("referencia", referencia, "servidor.nome");

        for (Orgao orgaoTemp : orgaos) {
            RelatorioDeRepasseVO repasseTemp = new RelatorioDeRepasseVO();

            repasseTemp.setCnpjOrgao(util.format("##.###.###/####-##", orgaoTemp.getCnpj()));

            repasseTemp.setNomeOrgao(util.format("##.###.###/####-##", orgaoTemp.getCnpj()).concat(" - ").concat(orgaoTemp.getNome()));

            BigDecimal totalValorBruto = BigDecimal.ZERO;

            BigDecimal totalValorBCalc = BigDecimal.ZERO;

            BigDecimal totalValor11 = BigDecimal.ZERO;

            BigDecimal totalValor20 = BigDecimal.ZERO;

            BigDecimal totalDoValorTotal = BigDecimal.ZERO;

            List<RelatorioDeRepasseAuxVO> listaMovimentosRepasses = new ArrayList<RelatorioDeRepasseAuxVO>();

            for (Movimento movimento : movimentos) {
                FontePagador fonte = movimentoDAO.getInitialized(movimento.getFonte());
                Servidor servidor = movimentoDAO.getInitialized(movimento.getServidor());
                DadosFuncionais dados = movimentoDAO.getInitialized(servidor.getDadosFuncionais());
                CarteiraTrabalho carteira = movimentoDAO.getInitialized(servidor.getCarteiraDeTrabalho());
                Unidade unidade = movimentoDAO.getInitialized(dados.getUnidade());
                Orgao orgao = movimentoDAO.getInitialized(unidade.getOrgao());

                if (orgao.equals(orgaoTemp)) {
                    RelatorioDeRepasseAuxVO repasse = new RelatorioDeRepasseAuxVO();
                    repasse.setCpf(servidor.getCpf());
                    repasse.setCredor(servidor.getNome());
                    repasse.setUnidade(unidade.getNome());
                    repasse.setNit(carteira.getPisPasepNit());
                    repasse.setHistorico(movimento.getObservacao());
                    repasse.setNe(movimento.getNeMov());
                    repasse.setNl(movimento.getNlMov());
                    repasse.setValorBruto(util.moeda(movimento.getValor()));
                    repasse.setValorBCalc(util.moeda(movimento.getValorBCalc()));
                    repasse.setFonte113(fonte.getCodigo().toString());
                    repasse.setValor11(util.moeda(movimento.getDesconto1()));
                    repasse.setValor20(util.moeda(movimento.getDesconto2()));
                    repasse.setValorTotal(util.moeda(movimento.getValorTotalDos11BCalc()));

                    totalValorBCalc = totalValorBCalc.add(movimento.getValorBCalc());
                    totalValorBruto = totalValorBruto.add(movimento.getValor());
                    totalValor11 = totalValor11.add(movimento.getDesconto1());
                    totalValor20 = totalValor20.add(movimento.getDesconto2());
                    totalDoValorTotal = totalDoValorTotal.add(movimento.getValorTotalDos11BCalc());

                    listaMovimentosRepasses.add(repasse);

                    repasseTemp.setRepasses(listaMovimentosRepasses);
                }

            }

            if (repasseTemp.getRepasses() != null) {
                repasseTemp.setTotalValorBruto(util.moeda(totalValorBruto));
                repasseTemp.setTotalValorBCalc(util.moeda(totalValorBCalc));
                repasseTemp.setTotalFonte113(" - ");
                repasseTemp.setTotalValor11(util.moeda(totalValor11));
                repasseTemp.setTotalValor20(util.moeda(totalValor20));
                repasseTemp.setTotalDoValorTotal(util.moeda(totalDoValorTotal));
                lista.add(repasseTemp);
            }
        }

        return lista;
    }

    public boolean travarMovimentos(Referencia referencia) {
        List<Movimento> movimentos = getDAO().list("referencia", referencia);

        if (movimentos.size() < 1) {
            return false;
        }
        for (Movimento movimento : movimentos) {
            movimento.setTravado(true);

            getDAO().saveOrMerge(movimento, true);
        }

        return true;
    }

    public void destravarMovimento(Referencia referencia) {
        List<Movimento> movimentos = getDAO().list("referencia", referencia);

        for (Movimento movimento : movimentos) {
            movimento.setTravado(false);

            getDAO().saveOrMerge(movimento, true);
        }
    }

    public void gerarRecibo(Movimento movimento) {
        HashMap params = new HashMap();
        String brasao = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/brasao2.png");

        Servidor servidor = getDAO().getInitialized(movimento.getServidor());
        CarteiraTrabalho carteira = getDAO().getInitialized(servidor.getCarteiraDeTrabalho());
        Rg rg = getDAO().getInitialized(servidor.getRg());
        DadosFuncionais dados = getDAO().getInitialized(servidor.getDadosFuncionais());
        Unidade unidade = getDAO().getInitialized(dados.getUnidade());
        Cargo cargo = getDAO().getInitialized(dados.getCargo());
        Endereco endereco = getDAO().getInitialized(servidor.getEndereco());
        Cidade cidadeEnd = getDAO().getInitialized(endereco.getCidade());
        Estado estadoEnd = getDAO().getInitialized(cidadeEnd.getEstado());

        BigDecimal valorLiquido = BigDecimal.ZERO;
        BigDecimal inss = BigDecimal.ZERO;
        BigDecimal iss = BigDecimal.ZERO;
        BigDecimal sestSenat = BigDecimal.ZERO;
        BigDecimal irrf = BigDecimal.ZERO;

        if (movimento.getIss() != null) {
            iss = movimento.getIss();
        }

        if (movimento.getDesconto1() != null) {
            inss = movimento.getDesconto1();
        }

        if (movimento.getSestSenat() != null) {
            sestSenat = movimento.getSestSenat();
        }

        if (movimento.getIrrf() != null) {
            irrf = movimento.getIrrf();
        }

        valorLiquido = movimento.getValor().subtract(iss).subtract(sestSenat).subtract(irrf).subtract(inss);

        params.put("BRASAO", brasao);
        params.put("UNIDADE_NOME", unidade.getNome().toUpperCase());
        params.put("UNIDADE_CNPJ", util.format("##.###.###/####-##", unidade.getCnpj()));
        params.put("VALOR_LIQUIDO", valorLiquido);
        params.put("LIQUIDO_POR_EXTENSO", util.valorPorExtenso(valorLiquido.doubleValue()));
        params.put("INSS", inss);
        params.put("INSS_POR_EXETENSO", util.valorPorExtenso(inss.doubleValue()));
        params.put("ISS", iss);
        params.put("ISS_POR_EXTENSO", util.valorPorExtenso(iss.doubleValue()));
        params.put("SEST_SENAT", sestSenat);
        params.put("SEST_SENAT_POR_EXTENSO", util.valorPorExtenso(sestSenat.doubleValue()));
        params.put("IRRF", irrf);
        params.put("IRRF_POR_EXTENSO", util.valorPorExtenso(irrf.doubleValue()));

        params.put("DESCRICAO_SERVICO", movimento.getObservacao());
        params.put("LOCAL_PRESTACAO_SERVICO", unidade.getNome());

        params.put("SERVIDOR_NOME", servidor.getNome().toUpperCase());
        params.put("SERVIDOR_CARGO", cargo.getNome());
        params.put("SERVIDOR_ENDERECO", endereco.getEndereco().concat(", ").concat(endereco.getNumero()).concat(" - ").
                concat(endereco.getBairro()));

        params.put("SERVIDOR_CEP", endereco.getCep());
        params.put("SERVIDOR_CIDADE", cidadeEnd.getNome());
        params.put("SERVIDOR_ESTADO", estadoEnd.getSigla());
        params.put("SERVIDOR_RG", rg.getNumero());
        params.put("SERVIDOR_CPF", util.format("###.###.###-##", servidor.getCpf()));
        params.put("SERVICOR_PASSAPORTE", servidor.getPassaporte());
        params.put("SERVIDOR_INSCRICAO_PREF", servidor.getNumInscPrefeitura());
        params.put("SERVIDOR_PIS", carteira.getPisPasepNit());

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/relatorios/ReciboPagamento.jasper", "Recibo de Pagamento.pdf");

    }

}
