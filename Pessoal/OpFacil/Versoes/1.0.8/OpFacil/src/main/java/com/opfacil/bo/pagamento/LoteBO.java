package com.opfacil.bo.pagamento;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.VOs.FuncionarioPorLote;
import com.opfacil.dao.cadastro.FuncionarioDAO;
import com.opfacil.dao.cadastro.MotivoPagamentoDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.pagamento.LoteDAO;
import com.opfacil.dao.pagamento.PagamentoDAO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.modelo.enums.SituacaoOp;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.pagamento.Lote;
import com.opfacil.modelo.pagamento.Pagamento;
import com.opfacil.util.SessaoUtils;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class LoteBO extends AbstractBusinessObject<Lote> {

    @EJB
    private LoteDAO loteDAO;

    @EJB
    private PagamentoDAO pagamentoDAO;

    @EJB
    private FuncionarioDAO funcionarioDAO;

    @EJB
    private MotivoPagamentoDAO motivoDAO;

    private SimpleDateFormat formataData = new SimpleDateFormat("yyyyMMdd");

    @Override
    public LoteDAO getDAO() {
        return loteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void save(Lote lote) throws BusinessException {

        List<Funcionario> funcionarios;

        Restrictions restrictions = new Restrictions();

        Empresa empresa = loteDAO.getInitialized(lote.getEmpresa());

        MotivoPagamento motivo = loteDAO.getInitialized(lote.getMotivoPagamento());

        if (lote.getId() != null) {

            restrictions.equals("lote_id", lote.getId());
            List<Pagamento> pagamentos = pagamentoDAO.list(restrictions);
            for (Pagamento pagamento : pagamentos) {
                pagamento.setDtPagamento(lote.getDtPagamento());
                pagamento.setMotivoPagamento(motivo);
                pagamento.setValorPagto(lote.getVlrTotal());

                pagamentoDAO.saveOrMerge(pagamento);
            }
        } else {

            restrictions.equals("empresa_id", empresa.getId());
            restrictions.equals("ativo", true);
            Long ultimoId = ((Long) pagamentoDAO.getQueryBuilder().from(Pagamento.class).max("id", 0)) + 1;
            funcionarios = funcionarioDAO.list(restrictions);

            for (Funcionario func : funcionarios) {
                Pagamento pagamento = new Pagamento();
                pagamento.setFuncionario(func);
                pagamento.setEmpresa(empresa);
                pagamento.setLote(lote);
                pagamento.setMotivoPagamento(motivo);
                pagamento.setDtPagamento(lote.getDtPagamento());
                pagamento.setSituacao(SituacaoOp.NAOGERADA);
                pagamento.setUsuario(lote.getUsuario());
                pagamento.setValorPagto(lote.getVlrTotal());
                pagamento.setOp(formataData.format(new Date()).concat(ultimoId.toString()).concat("OF"));
                
                pagamentoDAO.saveOrMerge(pagamento);
                ultimoId++;
            }
        }

        super.save(lote);

    }

    @Override
    public void validate(Lote lote) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Lote> getLotesAutorizadosPorUsuario(Usuario usuario) {
        List<Lote> lotes;
        QueryBuilder queryBuilder = loteDAO.getQueryBuilder();
        if (usuario.isSuperUsuario()) {
            lotes = queryBuilder.select("lote").from(Lote.class, "lote").innerJoinFetch("lote.empresa", "e").innerJoinFetch("lote.motivoPagamento", "m").getResultList();
        } else {
            Empresa empresa = loteDAO.getInitialized(usuario.getEmpresa());
            lotes = queryBuilder.select("lote").from(Lote.class, "lote").innerJoinFetch("lote.empresa", "e").innerJoinFetch("lote.motivoPagamento", "m").equals("e.id", empresa.getId()).getResultList();
        }
        return lotes;
    }

    public List<Lote> listarLotePorUsuario(FiltroDeBusca filtros) {
        List<Lote> lotes;
        Restrictions restrictions = new Restrictions();

        if (SessaoUtils.getUser().isSuperUsuario()) {
            if (filtros.getEmpresa() != null) {
                restrictions.add("empresa", filtros.getEmpresa());
            }
        } else {
            if (filtros.getEmpresa() != null) {
                restrictions.add("empresa", filtros.getEmpresa());
            } else {
                restrictions.add("empresa", SessaoUtils.getUser().getEmpresa());
            }
        }

        if (filtros.getMotivo() != null) {
            restrictions.add("motivoPagamento", filtros.getMotivo());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("dtPagamento", filtros.getDataInicial(), TemporalType.TIMESTAMP);
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("dtPagamento", filtros.getDataFinal(), TemporalType.TIMESTAMP);
        }

        lotes = loteDAO.list(restrictions, "empresa_id");

        return lotes;
    }

    public List<MotivoPagamento> listarMotivosEmLote() {
        Restrictions restrictions = new Restrictions();
        restrictions.equals("lote", true);

        return motivoDAO.list(restrictions, "nome");

    }

    public List<FuncionarioPorLote> getFuncionariosPorLote(Long idLote) {
        List<FuncionarioPorLote> funcionarios = new ArrayList<FuncionarioPorLote>();

        String queryString = "select f.nome, e.nomefantasia, mp.nome as motivopagamento, p.dtpagamento, p.valorpagto, p.situacao, f.id from funcionario f "
                + "left join pagamento p on ( f.id=p.funcionario_id) "
                + "left join empresa e on (p.empresa_id = e.id) "
                + "left join motivopagamento mp on (p.motivopagamento_id=mp.id) "
                + "where p.lote_id=" + idLote;

        queryString = queryString.concat("ORDER BY f.nome");
        
        Query query;
        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            FuncionarioPorLote funcionario = new FuncionarioPorLote();
            funcionario.setNome((String) tupla[0]);
            funcionario.setEmpresa((String) tupla[1]);
            funcionario.setMotivo((String) tupla[2]);
            funcionario.setDataPagamento((Date) tupla[3]);
            funcionario.setValorPagamento((BigDecimal) tupla[4]);
            funcionario.setSituacao(getSituacao((Integer) tupla[5]));
            funcionario.setId(((BigInteger) tupla[6]).longValue());

            funcionarios.add(funcionario);
        }

        return funcionarios;
    }

    private String getSituacao(Integer opcao) {
        String descricao = "";
        if (opcao == SituacaoOp.GERADA.getNum()) {
            descricao = SituacaoOp.GERADA.getDescricao();
        }
        if (opcao == SituacaoOp.NAOGERADA.getNum()) {
            descricao = SituacaoOp.NAOGERADA.getDescricao();
        }
        if (opcao == SituacaoOp.CANCELADA.getNum()) {
            descricao = SituacaoOp.CANCELADA.getDescricao();
        }
        return descricao;
    }
}
