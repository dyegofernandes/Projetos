package br.com.jsoft.centralfinanceira.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.financeiro.LancamentosBO;
import br.com.jsoft.centralfinanceira.dao.financeiro.ReceitaDespesaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoReceita;
import br.com.jsoft.centralfinanceira.modelo.enums.NaturezaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.OrigemLancamento;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDespesaEnum;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LancamentosMB extends AbstractBaseBean<Lancamentos> implements Serializable {

    @EJB
    private LancamentosBO lancamentosBO;

    @EJB
    private ReceitaDespesaDAO receitaDespesaDAO;

    private List<ReceitaDespesa> listaReceitaDespesaSoAnalitica;

    @Override
    public LancamentosBO getBO() {
        return lancamentosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id, data, estabelecimento";
    }

    @Override
    public void init() {
        listaReceitaDespesaSoAnalitica = receitaDespesaDAO.list("tipo", TipoDespesaEnum.ANALITICO, "receitaDespesaMae, id");

        Empresa empresa = lancamentosBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);
    }

    @Override
    public void save() {
        getEntity().setOrigem(OrigemLancamento.MANUAL);
        super.save();
    }

    public LancamentosBO getLancamentosBO() {
        return lancamentosBO;
    }

    public void setLancamentosBO(LancamentosBO lancamentosBO) {
        this.lancamentosBO = lancamentosBO;
    }

    public List<ReceitaDespesa> getListaReceitaDespesaSoAnalitica() {
        return listaReceitaDespesaSoAnalitica;
    }

    public void setListaReceitaDespesaSoAnalitica(List<ReceitaDespesa> listaReceitaDespesaSoAnalitica) {
        this.listaReceitaDespesaSoAnalitica = listaReceitaDespesaSoAnalitica;
    }

    public void setarNatureza() {
        ReceitaDespesa receitaDespesa = lancamentosBO.getDAO().getInitialized(getEntity().getReceitaDespesa());

        if (receitaDespesa != null) {
            getEntity().setNatureza(receitaDespesa.getNatureza());
        }
    }

}
