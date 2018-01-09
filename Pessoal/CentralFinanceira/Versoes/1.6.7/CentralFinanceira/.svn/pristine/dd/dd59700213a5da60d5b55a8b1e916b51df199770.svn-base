package br.com.jsoft.centralfinanceira.dao.financeiro.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.financeiro.ContasAPagarDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Banco;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Estabelecimento;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Fornecedor;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoFornecedor;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoReceitaDespesa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoDocumento;
import br.com.jsoft.centralfinanceira.modelo.enums.OrdenacaoContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.enums.Quitado;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDeBusca;
import br.com.jsoft.centralfinanceira.modelo.financeiro.CentroResultados;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentos;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import br.com.jsoft.centralfinanceira.vo.ContasAPagarVO;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import com.xpert.utils.DateUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TemporalType;
import org.joda.time.Days;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ContasAPagarDAOImpl extends BaseDAOImpl<ContasAPagar> implements ContasAPagarDAO {

    @Override
    public Class getEntityClass() {
        return ContasAPagar.class;
    }

    @Override
    public List<ContasAPagarVO> relatorioVencimento(Date vencimentoInicial, Date vencimentoFinal, Date entradaInicial, Date entradaFinal,
            Date cancelamentoInicial, Date cancelamentoFinal, Long idTipoDocumento, Long idCentroResultados, Long idGrupoDespesas,
            Long idEstabelecimento, Long idGrupoFornecedor, Long idDespesa, Long idFornecedor, Long idContaFinanceira, Long idBanco,
            Long idUsuario, String tituloVencimento, OrdenacaoContasAPagar orderby, TipoDeBusca tipoBusca) {

        List<ContasAPagarVencimentos> vencimentos = new ArrayList<ContasAPagarVencimentos>();

        List<ContasAPagarVO> vencimentosVO = new ArrayList<ContasAPagarVO>();

        QueryBuilder queryBuilder = getQueryBuilder();

        Restrictions restrictions = new Restrictions();

        if (vencimentoInicial != null) {
            restrictions.greaterEqualsThan("cpv.data", vencimentoInicial, TemporalType.TIMESTAMP);
        }

        if (vencimentoFinal != null) {
            restrictions.lessEqualsThan("cpv.data", vencimentoFinal, TemporalType.TIMESTAMP);
        }

        if (entradaInicial != null) {
            restrictions.greaterEqualsThan("cp.entrada", entradaInicial, TemporalType.TIMESTAMP);
        }

        if (entradaFinal != null) {
            restrictions.lessEqualsThan("cp.entrada", entradaFinal, TemporalType.TIMESTAMP);
        }

        if (cancelamentoInicial != null) {
            restrictions.greaterEqualsThan("cpv.data", vencimentoInicial, TemporalType.TIMESTAMP);
        }

        if (cancelamentoFinal != null) {
            restrictions.lessEqualsThan("cpv.data", vencimentoFinal, TemporalType.TIMESTAMP);
        }

        if (idTipoDocumento != null) {
            restrictions.equals("td.id", idTipoDocumento);
        }

        if (idCentroResultados != null) {
            restrictions.equals("cr.id", idCentroResultados);
        }

        if (idGrupoDespesas != null) {
            restrictions.equals("grd.id", idGrupoDespesas);
        }

        if (idEstabelecimento != null) {
            restrictions.equals("es.id", idEstabelecimento);
        }

        if (idGrupoFornecedor != null) {
            restrictions.equals("gfn.id", idGrupoFornecedor);
        }

        if (idDespesa != null) {
            restrictions.equals("rd.id", idDespesa);
        }

        if (idFornecedor != null) {
            restrictions.equals("fn.id", idFornecedor);
        }

//        if (idContaFinanceira != null) {
//            restrictions.equals("cf.id", idContaFinanceira);
//        }
//
//        if (idBanco != null) {
//            restrictions.equals("ban.id", idBanco);
//        }
//
//        if (idUsuario != null) {
//            restrictions.equals("", idUsuario);
//        }
        if (tituloVencimento != null && !tituloVencimento.equals("")) {
            restrictions.like("cpv.numTitulo", tituloVencimento);
        }

        if (tipoBusca != null) {
            if (tipoBusca == TipoDeBusca.ENTRADAS) {

            }
            if (tipoBusca == TipoDeBusca.PAGOS) {
                restrictions.equals("cpv.quitado", Quitado.SIM);
            }
            if (tipoBusca == TipoDeBusca.EM_ABERTO) {
                restrictions.equals("cpv.quitado", Quitado.NAO);
                restrictions.isNull("cpv.dataCancelamento");
            }
            if (tipoBusca == TipoDeBusca.CANCELADADAS) {
                restrictions.isNotNull("cpv.dataCancelamento");
            }
        }
//innerJoinFetch("cp.contaFinanceira", "cf") e  .innerJoinFetch("cf.banco", "ban")
        vencimentos = queryBuilder.select("cpv").from(ContasAPagarVencimentos.class, "cpv").innerJoinFetch("cpv.contasAPagar", "cp").
                innerJoinFetch("cp.centroResultado", "cr").innerJoinFetch("cp.estabelecimento", "es").
                innerJoinFetch("cp.fornecedor", "fn").innerJoinFetch("cp.receitaDespesa", "rd").innerJoinFetch("cp.tipoDeDocumento", "td").
                innerJoinFetch("rd.grupo", "grd").innerJoinFetch("fn.grupoFornecedor", "gfn").
                add(restrictions).orderBy(orderby.getOrdenacao()).setMaxResults(5000).getResultList();

        for (ContasAPagarVencimentos vencimento : vencimentos) {
            ContasAPagarVO vencimentoTemp = new ContasAPagarVO();
            
            Integer atraso = dataDiff(vencimento.getData() != null ? vencimento.getData() : new Date(), new Date());
            
            vencimentoTemp.setAtraso(atraso < 0 ? 0 : atraso);

            ContasAPagar contasAPagarTemp = vencimento != null ? getInitialized(vencimento.getContasAPagar()) : new ContasAPagar();
//            ContaFinanceira contaFinanceira = contasAPagarTemp != null ? getInitialized(contasAPagarTemp.getContaFinanceira()) : new ContaFinanceira();
            Estabelecimento estabelecimento = contasAPagarTemp != null ? getInitialized(contasAPagarTemp.getEstabelecimento()) : new Estabelecimento();
            TipoDocumento tipoDocumento = contasAPagarTemp != null ? getInitialized(contasAPagarTemp.getTipoDeDocumento()) : new TipoDocumento();
//            Banco banco = contaFinanceira != null ? getInitialized(contaFinanceira.getBanco()) : new Banco();
            Fornecedor fornecedor = contasAPagarTemp != null ? getInitialized(contasAPagarTemp.getFornecedor()) : new Fornecedor();
            GrupoFornecedor grupoFornecedor = fornecedor != null ? getInitialized(fornecedor.getGrupoFornecedor()) : new GrupoFornecedor();
            CentroResultados centroResultado = contasAPagarTemp != null ? getInitialized(contasAPagarTemp.getCentroResultado()) : new CentroResultados();
            ReceitaDespesa receitaDespesa = contasAPagarTemp != null ? getInitialized(contasAPagarTemp.getReceitaDespesa()) : new ReceitaDespesa();
            GrupoReceitaDespesa grupoReceitaDespesa = receitaDespesa != null ? getInitialized(receitaDespesa.getGrupo()) : new GrupoReceitaDespesa();

//            vencimentoTemp.setBanco(banco.getNome());
            vencimentoTemp.setCancelado(BigDecimal.ZERO);
            vencimentoTemp.setCentroDeResultados(centroResultado.getId() + " - ".concat(centroResultado.getNome()));
//            vencimentoTemp.setContaFinanceira(contaFinanceira.getNome().concat(" - ").concat(contaFinanceira.getCc().concat(" - ").concat(contaFinanceira.getAgencia())));
            vencimentoTemp.setContasAPagar(contasAPagarTemp.getId() + "");
            vencimentoTemp.setDesconto(vencimento.getDesconto());
            vencimentoTemp.setDespesa(receitaDespesa.getId() + " - ".concat(receitaDespesa.getNome()));
            vencimentoTemp.setDocumento(contasAPagarTemp.getDocumento());
            vencimentoTemp.setEntrada(contasAPagarTemp.getEntrada());
            vencimentoTemp.setEstabelecimento(estabelecimento.getNome());
            vencimentoTemp.setFornecedor(fornecedor.getNome());
            vencimentoTemp.setGrupoDeDespesas(grupoReceitaDespesa.getNome());
            vencimentoTemp.setGrupoFornecedor(grupoFornecedor.getNome());
            vencimentoTemp.setJuros(BigDecimal.ZERO);
            vencimentoTemp.setSaldo(vencimento.getValor());
            vencimentoTemp.setTipoDocumento(tipoDocumento.getNome());
            vencimentoTemp.setTituloVencimento(vencimento.getNumTitulo());
            vencimentoTemp.setUsuario(null);
            vencimentoTemp.setValor(vencimento.getValor());
            vencimentoTemp.setValorPago(vencimento.getValorBruto());
            vencimentoTemp.setVencimento(vencimento.getData());
            vencimentoTemp.setCancelamento(vencimento.getDataCancelamento());
            vencimentoTemp.setQuitado(vencimento.getQuitado().getDescricao());

            vencimentosVO.add(vencimentoTemp);
        }

        return vencimentosVO;
    }

    /**
     * Método para comparar as das e retornar o numero de dias de diferença
     * entre elas
     *
     * Compare two date and return the difference between them in days.
     *
     * @param dataLow The lowest date
     * @param dataHigh The highest date
     *
     * @return int
     */
    private int dataDiff(Date dataLow, Date dataHigh) {

        GregorianCalendar startTime = new GregorianCalendar();
        GregorianCalendar endTime = new GregorianCalendar();

        GregorianCalendar curTime = new GregorianCalendar();
        GregorianCalendar baseTime = new GregorianCalendar();

        startTime.setTime(dataLow);
        endTime.setTime(dataHigh);

        int dif_multiplier = 1;

        // Verifica a ordem de inicio das datas  
        if (dataLow.compareTo(dataHigh) < 0) {
            baseTime.setTime(dataHigh);
            curTime.setTime(dataLow);
            dif_multiplier = 1;
        } else {
            baseTime.setTime(dataLow);
            curTime.setTime(dataHigh);
            dif_multiplier = -1;
        }

        int result_years = 0;
        int result_months = 0;
        int result_days = 0;

        // Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando  
        // no total de dias. Ja leva em consideracao ano bissesto  
        while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR)
                || curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {

            int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
            result_months += max_day;
            curTime.add(GregorianCalendar.MONTH, 1);

        }

        // Marca que é um saldo negativo ou positivo  
        result_months = result_months * dif_multiplier;

        // Retirna a diferenca de dias do total dos meses  
        result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));

        return result_years + result_months + result_days;
    }
}
