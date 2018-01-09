package br.gov.pi.siste.mb.relatoriosMB;

import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.financeiro.ReferenciaBO;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.modelo.vos.MovimentoVO;
import br.gov.pi.siste.modelo.vos.PlanilhaControleAutonomosVO;
import br.gov.pi.siste.modelo.vos.RepassesVO;
import br.gov.pi.siste.modelo.vos.UnidadeVO;
import br.gov.pi.siste.modelo.vos.ValorUsadoPorUnidadeVO;
import br.gov.pi.siste.util.SessaoUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RelatorioMB extends AbstractBaseBean<Referencia> implements Serializable {

    @EJB
    private ReferenciaBO referenciaBO;

    @EJB
    private UnidadeBO unidadeBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosVO filtros;

    private List<RepassesVO> repasses;

    private List<PlanilhaControleAutonomosVO> planilha;

    private List<Unidade> unidades = new ArrayList<Unidade>();

    private List<UnidadeVO> unidadesVO = new ArrayList<UnidadeVO>();

    private List<ValorUsadoPorUnidadeVO> valoresUsadosPorUnidade = new ArrayList<ValorUsadoPorUnidadeVO>();

    @Override
    public ReferenciaBO getBO() {
        return referenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "codigo DESC";
    }

    @Override
    public void init() {
        filtros = new FiltrosVO();

        filtros.setUsuario(usuarioAtual);

    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public List<RepassesVO> getRepasses() {
        return repasses;
    }

    public void setRepasses(List<RepassesVO> repasses) {
        this.repasses = repasses;
    }

    public List<PlanilhaControleAutonomosVO> getPlanilha() {
        return planilha;
    }

    public void setPlanilha(List<PlanilhaControleAutonomosVO> planilha) {
        this.planilha = planilha;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public List<ValorUsadoPorUnidadeVO> getValoresUsadosPorUnidade() {
        return valoresUsadosPorUnidade;
    }

    public List<UnidadeVO> getUnidadesVO() {
        return unidadesVO;
    }

    public void setUnidadesVO(List<UnidadeVO> unidadesVO) {
        this.unidadesVO = unidadesVO;
    }

    public void gerarRelatorioDeAutonomos() {
        referenciaBO.relatorioDeControleAutonomes(filtros);
    }

    public void gerarRelatorioRepasses() {
        referenciaBO.relatorioRepasses(filtros);
    }

    public void gerarListaAutonomos() {
        planilha = referenciaBO.listaControleAutonomos(filtros);
    }

    public void gerarListaRepasses() {
        repasses = referenciaBO.listaRepasses(filtros);
    }

    public List<MovimentoVO> listarMovimentosVO(UnidadeVO unidadeVO) {
        List<MovimentoVO> movimentos = new ArrayList<MovimentoVO>();

        for (RepassesVO repasse : repasses) {
            for (UnidadeVO unidade : repasse.getUnidades()) {
                if (unidade.equals(unidadeVO)) {
                    for (MovimentoVO movimento : unidade.getMovimentos()) {
                        movimentos.add(movimento);
                    }
                    break;
                }
            }
        }
        return movimentos;
    }

    public List<UnidadeVO> listarUnidadesVO(RepassesVO repasse) {
        List<UnidadeVO> unidVO = new ArrayList<UnidadeVO>();
        for (RepassesVO repasseTemp : repasses) {
            if (repasse.equals(repasseTemp)) {
                for (UnidadeVO unidade : repasse.getUnidades()) {
                    unidVO.add(unidade);
                }
                break;
            }
        }

        return unidVO;
    }

    public void carregarUnidadesPorOrgao() {
        if (filtros.getOrgao() != null) {
            unidades = unidadeBO.unidadesPorOrgao(filtros.getOrgao());
        } else {
            filtros.setUnidade(new Unidade());
            unidades = new ArrayList<Unidade>();
        }
    }

    public void listarValorUsadoPorUnidade() {
        valoresUsadosPorUnidade = referenciaBO.listarValorUsadoPorUnidadePF(filtros);
    }
}
