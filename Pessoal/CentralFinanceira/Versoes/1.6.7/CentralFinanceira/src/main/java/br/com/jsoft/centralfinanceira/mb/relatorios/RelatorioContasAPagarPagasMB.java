/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.mb.relatorios;

import br.com.jsoft.centralfinanceira.bo.financeiro.ContasAPagarBO;
import br.com.jsoft.centralfinanceira.modelo.enums.OrdenacaoContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDeBusca;
import br.com.jsoft.centralfinanceira.vo.ConsultarContasAPagarEreceberVO;
import br.com.jsoft.centralfinanceira.vo.ContasAPagarVO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RelatorioContasAPagarPagasMB implements Serializable {

    @EJB
    private ContasAPagarBO contasAPagarBO;

    private ConsultarContasAPagarEreceberVO filtros;

    private List<ContasAPagarVO> contasAPagar;

    @PostConstruct
    public void init() {
        filtros = new ConsultarContasAPagarEreceberVO();
        contasAPagar = contasAPagarBO.getDAO().relatorioVencimento(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, OrdenacaoContasAPagar.FORNECEDOR_CENTRO_DE_RESULTADO, TipoDeBusca.PAGOS);
    }

    public void buscar() {
        contasAPagar = contasAPagarBO.getDAO().relatorioVencimento(filtros.getVencimentoInicial(), filtros.getVencimentoFinal(), filtros.getEntradaInicial(), filtros.getEntradaFinal(),
                filtros.getCancelamentoInicial(), filtros.getCancelamentoFinal(), filtros.getTipoDocumento() != null ? filtros.getTipoDocumento().getId() : null,
                filtros.getCentroResultados() != null ? filtros.getCentroResultados().getId() : null, filtros.getGrupoReceitaDespesa() != null ? filtros.getGrupoReceitaDespesa().getId() : null,
                filtros.getEstabelecimento() != null ? filtros.getEstabelecimento().getId() : null, filtros.getGrupoFornecedor() != null ? filtros.getGrupoFornecedor().getId() : null,
                filtros.getReceitaDespesa() != null ? filtros.getReceitaDespesa().getId() : null, filtros.getFornecedor() != null ? filtros.getFornecedor().getId() : null,
                null, null, null, filtros.getTituloVencimento(), filtros.getOrdenacao() != null ? filtros.getOrdenacao() : OrdenacaoContasAPagar.FORNECEDOR_CENTRO_DE_RESULTADO, TipoDeBusca.PAGOS);
    }

    public void limpar() {
        filtros = new ConsultarContasAPagarEreceberVO();
    }

    public List<ContasAPagarVO> getContasAPagar() {
        return contasAPagar;
    }

    public void setContasAPagar(List<ContasAPagarVO> contasAPagar) {
        this.contasAPagar = contasAPagar;
    }

    public ConsultarContasAPagarEreceberVO getFiltros() {
        return filtros;
    }

    public void setFiltros(ConsultarContasAPagarEreceberVO filtros) {
        this.filtros = filtros;
    }

}
