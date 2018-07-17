package br.gov.pi.ati.mb.orcamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.DotacaoBO;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.Dotacao;
import br.gov.pi.ati.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DotacaoMB extends AbstractBaseBean<Dotacao> implements Serializable {

    @EJB
    private DotacaoBO dotacaoBO;

    private Usuario usuarioAtual;

    private Filtros filtros;

    private List<UnidadeOrcamentaria> unidades;

    @Override
    public DotacaoBO getBO() {
        return dotacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());
    }

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public List<UnidadeOrcamentaria> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeOrcamentaria> unidades) {
        this.unidades = unidades;
    }

}
