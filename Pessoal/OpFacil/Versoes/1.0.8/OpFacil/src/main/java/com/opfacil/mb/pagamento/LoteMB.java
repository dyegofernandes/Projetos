package com.opfacil.mb.pagamento;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.VOs.FuncionarioPorLote;
import com.opfacil.bo.cadastro.EmpresaBO;
import com.opfacil.bo.cadastro.FuncionarioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.pagamento.LoteBO;
import com.opfacil.bo.pagamento.PagamentoBO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.enums.SituacaoOp;
import com.opfacil.modelo.pagamento.Lote;
import com.opfacil.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LoteMB extends AbstractBaseBean<Lote> implements Serializable {

    @EJB
    private LoteBO loteBO;

    @EJB
    private EmpresaBO empresaBO;

    @EJB
    private FuncionarioBO funcionarioBO;

    @EJB
    private PagamentoBO pagamentoBO;

    private FiltroDeBusca campoDeBusca;

    private List<Empresa> empresas;

    private List<Lote> lotes;

    private List<Lote> lotesFiltrados;

    private List<MotivoPagamento> motivos;

    @Override
    public LoteBO getBO() {
        return loteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        campoDeBusca = new FiltroDeBusca();
        empresas = empresaBO.getListEmpresasAutorizadas(SessaoUtils.getUser());
        lotes = loteBO.listarLotePorUsuario(campoDeBusca);
        motivos = loteBO.listarMotivosEmLote();
    }

    @Override
    public void postSave() {
        setEntity(new Lote());
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

    public List<Lote> getLotesFiltrados() {
        return lotesFiltrados;
    }

    public void setLotesFiltrados(List<Lote> lotesFiltrados) {
        this.lotesFiltrados = lotesFiltrados;
    }

    public List<FuncionarioPorLote> funcionariosPorLote(Long id) {

        return loteBO.getFuncionariosPorLote(id);
    }

    public List<MotivoPagamento> getMotivos() {
        return motivos;
    }

    public LoteBO getLoteBO() {
        return loteBO;
    }

    public void setLoteBO(LoteBO loteBO) {
        this.loteBO = loteBO;
    }

    public EmpresaBO getEmpresaBO() {
        return empresaBO;
    }

    public void setEmpresaBO(EmpresaBO empresaBO) {
        this.empresaBO = empresaBO;
    }

    public FiltroDeBusca getCampoDeBusca() {
        return campoDeBusca;
    }

    public void setCampoDeBusca(FiltroDeBusca campoDeBusca) {
        this.campoDeBusca = campoDeBusca;
    }

    public void buscar() {
        if (campoDeBusca.getDataInicial() != null && campoDeBusca.getDataFinal() != null) {
            if (campoDeBusca.getDataInicial().after(campoDeBusca.getDataFinal())) {
                FacesMessageUtils.error("Data Inicial não pode ser maior que a Data Final!");
            } else {
                lotes = loteBO.listarLotePorUsuario(campoDeBusca);
            }
        } else {
            lotes = loteBO.listarLotePorUsuario(campoDeBusca);
        }

    }

    @Override
    public void save() {
        getEntity().setUsuario(SessaoUtils.getUser());
        super.save();
    }

    @Override
    public void delete() {
        List<FuncionarioPorLote> funcionarios = loteBO.getFuncionariosPorLote((Long) getId());
        int cont = 0;
        for (FuncionarioPorLote funcionario : funcionarios) {
            if (funcionario.getSituacao().equals(SituacaoOp.GERADA.getDescricao())) {
                cont++;
            }
        }

        if (cont > 0) {
            FacesMessageUtils.error("Lote não pode ser excluido pois existe funcionários dele que já foram gerado o Arquivo!");
        } else {
            for (FuncionarioPorLote funcionario : funcionarios) {
                try {
                    Restrictions restrictions = new Restrictions();
                    restrictions.add("funcionario_id", funcionario.getId());
                    restrictions.equals("dtPagamento", funcionario.getDataPagamento(), TemporalType.TIMESTAMP);
                    restrictions.equals("lote_id", getId());
                    pagamentoBO.delete(pagamentoBO.getDAO().unique(restrictions).getId());
                } catch (DeleteException ex) {
                    Logger.getLogger(LoteMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            super.delete();
        }

        lotes = loteBO.listarLotePorUsuario(campoDeBusca);
    }

    public BigDecimal getVlrTotal() {
        BigDecimal valor = BigDecimal.ZERO;
        if (getEntity().getQtdias() != null && getEntity().getVlrDia() != null) {
            valor = valor.add(getEntity().getVlrDia().multiply(BigDecimal.valueOf(getEntity().getQtdias().doubleValue())));
        }
        return valor;
    }

}
