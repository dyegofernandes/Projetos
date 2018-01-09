package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.AliquotaIRRFDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.bo.cadastro.DadosFuncionaisBO;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.financeiro.AliquotaIRRF;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;
import br.gov.pi.siste.util.Utils;

/**
 *
 * @author Juniel
 */
@Stateless
public class AliquotaIRRFBO extends AbstractBusinessObject<AliquotaIRRF> {

    @EJB
    private AliquotaIRRFDAO aliquotaIRRFDAO;

    @EJB
    private DadosFuncionaisBO dadosBO;

    private Utils util = new Utils();

    @Override
    public AliquotaIRRFDAO getDAO() {
        return aliquotaIRRFDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AliquotaIRRF aliquotaIRRF) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public AliquotaIRRF getAliquotaPelo(TabelaIRRF tabela, BigDecimal valor) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("tabelaIRRF", tabela);

        restrictions.lessEqualsThan("salarioInicial", valor);

        restrictions.greaterEqualsThan("salarioFinal", valor);

        return getDAO().unique(restrictions);
    }

    public BigDecimal calcularDesconto(TabelaIRRF tabela, BigDecimal baseCalculo) {

        BigDecimal retorno = BigDecimal.ZERO;

        Restrictions restrictions = new Restrictions();

        restrictions.add("tabelaIRRF", tabela);

        restrictions.lessEqualsThan("salarioInicial", baseCalculo);

        restrictions.greaterEqualsThan("salarioFinal", baseCalculo);

        AliquotaIRRF irrf = getDAO().unique(restrictions);

        if (irrf != null) {
            retorno = util.calcularPorcentagem(irrf.getValor(), baseCalculo); // Calculo do desconto

            retorno = retorno.subtract(irrf.getParcelaADeduzir()); // Redução de acordo com o valor a deduzir
        }

        return retorno;
    }

    public BigDecimal baseIrrf(Servidor servidor, TabelaIRRF tabela, BigDecimal valor, BigDecimal inss, BigDecimal pensao) {

        if (tabela == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal base = BigDecimal.ZERO;
        DadosFuncionais dados = null;
        BigDecimal descontoTotalPorDependentes = BigDecimal.ZERO;

        tabela = getDAO().getInitialized(tabela);
        servidor = aliquotaIRRFDAO.getInitialized(servidor);
        if (servidor != null) {
            dados = dadosBO.getDAO().getInitialized(servidor.getDadosFuncionais());
        }

        Integer dependentes = 0;

        if (dados != null) {
            dependentes = dados.getQtdDepIr();
        }

        descontoTotalPorDependentes = tabela.getDeducaoPorDependentes().multiply(new BigDecimal(dependentes));
        //calculo da base de calculo irrf
        base = base.add(valor);
        base = base.subtract(inss);
        base = base.subtract(descontoTotalPorDependentes);

        if (pensao != null) {
            base = base.subtract(pensao);
        }

        return base;
    }

    public List<AliquotaIRRF> listarAliquotasPelaTabela(TabelaIRRF tabela) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("tabelaIRRF", tabela);

        return getDAO().list(restrictions);

    }
}
