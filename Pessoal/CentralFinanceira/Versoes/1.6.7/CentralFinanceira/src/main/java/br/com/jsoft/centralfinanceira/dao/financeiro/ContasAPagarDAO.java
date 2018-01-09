package br.com.jsoft.centralfinanceira.dao.financeiro;

import br.com.jsoft.centralfinanceira.modelo.enums.OrdenacaoContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDeBusca;
import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.vo.ContasAPagarVO;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KillerBeeTwo
 */
@Local
public interface ContasAPagarDAO extends BaseDAO<ContasAPagar> {

    public List<ContasAPagarVO> relatorioVencimento(Date vencimentoInicial, Date vencimentoFinal, Date entradaInicial, Date entradaFinal,
            Date cancelamentoInicial, Date cancelamentoFinal, Long idTipoDocumento, Long idCentroResultados, Long idGrupoDespesas,
            Long idEstabelecimento, Long idGrupoFornecedor, Long idDespesa, Long idFornecedor, Long idContaFinanceira, Long idBanco,
            Long idUsuario, String tituloVencimento, OrdenacaoContasAPagar orderby, TipoDeBusca tipoBusca);
}
