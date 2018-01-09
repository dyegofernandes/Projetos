package com.opfacil.dao.pagamento;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.VOs.PagamentoVO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.modelo.enums.SituacaoOp;
import com.xpert.persistence.dao.BaseDAO;
import com.opfacil.modelo.pagamento.Pagamento;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KillerBeeTwo
 */
@Local
public interface PagamentoDAO extends BaseDAO<Pagamento> {
    public List<PagamentoVO> getPagamentosRealizados(FiltroDeBusca filtros);
    public List<Pagamento> listarPagamentosPorStatus(Long usuarioID, Long empresaID, Date dataInicial, Date dataFinal, SituacaoOp situacao);
}
