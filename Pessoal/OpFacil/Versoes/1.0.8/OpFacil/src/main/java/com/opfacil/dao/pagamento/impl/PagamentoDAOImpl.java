package com.opfacil.dao.pagamento.impl;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.VOs.PagamentoVO;
import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.pagamento.PagamentoDAO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.enums.SituacaoOp;
import com.opfacil.modelo.enums.SituacaoOpRealizadas;
import com.opfacil.modelo.pagamento.Pagamento;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class PagamentoDAOImpl extends BaseDAOImpl<Pagamento> implements PagamentoDAO {

    @Override
    public Class getEntityClass() {
        return Pagamento.class;
    }

    @Override
    public List<PagamentoVO> getPagamentosRealizados(FiltroDeBusca filtros) {
        List<PagamentoVO> pagamentos = new ArrayList<PagamentoVO>();
        Calendar c = Calendar.getInstance();
        c.set(1990, 0, 1); // 1/1/1990  
        Date dataInicialTemp = c.getTime();
        Date dataFinalTemp = new Date();

        String queryString = "SELECT nu_op,"
                + " dt_emissao,"
                + " dt_pagamento,"
                + " hora,"
                + " nm_favorecido,"
                + " cpf,"
                + " rg,"
                + " orgao_emissor,"
                + " vl_op,"
                + " situacao_op,"
                + " empresa,"
                + " id_servico,"
                + " agente,"
                + " pos,"
                + " pos_nome_fantasia,"
                + " pos_cidade,"
                + " pos_bairro,"
                + " sistema,"
                + " cd_op,"
                + " dt_vencimento "
                + "FROM importa.pagamentos WHERE codbanco LIKE :codEmpresa";

        Query query;

        if (filtros.getSituacaoOpRealizadas() != null) {
            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.PAGA) {
                queryString = queryString.concat(" AND dt_pagamento between :dataInicial AND :dataFinal");
            }
            queryString = queryString.concat(" AND UPPER(situacao_op) LIKE :situacao");
        }

        if (filtros.getCpf() != null) {
            if (!filtros.getCpf().equals("")) {
                queryString = queryString.concat(" AND cpf LIKE :cpfFiltro");
            }
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                queryString = queryString.concat(" AND UPPER(nm_favorecido) LIKE :nomeFiltro");
            }
        }

        if (filtros.getNumOp() != null) {
            if (!filtros.getNumOp().equals("")) {
                queryString = queryString.concat(" AND UPPER(nu_op) LIKE :numOp");
            }
        }

        if (filtros.getRg() != null) {
            if (!filtros.getRg().equals("")) {
                queryString = queryString.concat(" AND rg LIKE :rgFiltro");
            }
        }

        query = getEntityManager().createNativeQuery(queryString);

        if (filtros.getSituacaoOpRealizadas() != null) {

            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.PAGA) {
                query.setParameter("situacao", "%".concat("PAGA").concat("%"));
            }
            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.EXPIRADA) {
                query.setParameter("situacao", "%".concat("EXPIRADA").concat("%"));
            }
            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.DISPONIVEL) {
                query.setParameter("situacao", "%".concat("DISPONIVEL").concat("%"));
            }
            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.DEVOLVIDA) {
                query.setParameter("situacao", "%".concat("DEVOLVIDA").concat("%"));
            }
            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.CANCELADA) {
                query.setParameter("situacao", "%".concat("CANCELADA").concat("%"));
            }
        }

        if (filtros.getEmpresa() != null) {
            query.setParameter("codEmpresa", "%".concat(filtros.getEmpresa().getCdBanco()).concat("%"));
        } else {
            Empresa empresaUsuario = getInitialized(filtros.getUsuario().getEmpresa());
            query.setParameter("codEmpresa", "%".concat(empresaUsuario.getCdBanco()).concat("%"));
        }

        if (filtros.getCpf() != null) {
            if (!filtros.getCpf().equals("")) {
                query.setParameter("cpfFiltro", "%".concat(filtros.getCpf()).concat("%"));
            }
        }

        if (filtros.getRg() != null) {
            if (!filtros.getRg().equals("")) {
                query.setParameter("rgFiltro", "%".concat(filtros.getRg()).concat("%"));
            }
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                query.setParameter("nomeFiltro", "%".concat(filtros.getNome().toUpperCase()).concat("%"));
            }
        }

        if (filtros.getNumOp() != null) {
            if (!filtros.getNumOp().equals("")) {
                query.setParameter("numOp", "%".concat(filtros.getNumOp().toUpperCase()).concat("%"));
            }
        }
        
        if (filtros.getSituacaoOpRealizadas() != null) {
            if (filtros.getSituacaoOpRealizadas() == SituacaoOpRealizadas.PAGA) {
                query.setParameter("dataInicial", filtros.getDataInicial() != null ? filtros.getDataInicial() : dataInicialTemp);

                query.setParameter("dataFinal", filtros.getDataFinal() != null ? filtros.getDataFinal() : dataFinalTemp);
            }
        }
        
        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            PagamentoVO pagamento = new PagamentoVO();

            pagamento.setNumeroOp(((String) tupla[0]));
            pagamento.setDataEmissao((Date) tupla[1]);
            pagamento.setDataPagamento((Date) tupla[2]);
            pagamento.setHoraPagamento((String) tupla[3]);
            pagamento.setNomeFavorecido((String) tupla[4]);
            pagamento.setCpf((String) tupla[5]);
            pagamento.setRg((String) tupla[6]);
            pagamento.setOrgaoEmissor((String) tupla[7]);
            pagamento.setValorOp((BigDecimal) tupla[8]);
            pagamento.setSituacaoOp((String) tupla[9]);
            pagamento.setEmpresa((String) tupla[10]);
            pagamento.setIdServico((Integer) tupla[11]);
            pagamento.setAgente((Integer) tupla[12]);
            pagamento.setPos((Integer) tupla[13]);
            pagamento.setPosNomeFantasia((String) tupla[14]);
            pagamento.setPosCidade((String) tupla[15]);
            pagamento.setPosBairro((String) tupla[16]);
            pagamento.setSistema((String) tupla[17]);
            pagamento.setCodigoOp((Integer) tupla[18]);
            pagamento.setDataVencimento((Date) tupla[19]);

            pagamentos.add(pagamento);

        }
        return pagamentos;
    }

    @Override
    public List<Pagamento> listarPagamentosPorStatus(Long usuarioID, Long empresaID, Date dataInicial, Date dataFinal, SituacaoOp situacao) {
        List<Pagamento> pagamentos;
        Restrictions restrictions = new Restrictions();

        if (empresaID != null) {
            restrictions.equals("empresa_id", empresaID);
        }
        if (usuarioID != null) {
            restrictions.equals("empresa_id", usuarioID);
        }

        restrictions.equals("situacao", situacao);
        pagamentos = list(restrictions);

        return pagamentos;

    }

    private String getCodigoEmpresa(String nome) {
        String nova = nome.substring(0, nome.indexOf("-"));
        return Integer.valueOf(nova.replaceAll(" ", "")).toString();
    }

    private String convertPeriodo(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");

        return formatador.format(data);
    }

}
