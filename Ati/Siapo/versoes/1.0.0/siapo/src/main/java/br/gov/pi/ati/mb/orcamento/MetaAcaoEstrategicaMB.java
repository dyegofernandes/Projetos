package br.gov.pi.ati.mb.orcamento;

import br.gov.pi.ati.bo.cadastro.AcaoEstrategicaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaAcaoEstrategicaBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import br.gov.pi.ati.util.SessaoUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MetaAcaoEstrategicaMB extends AbstractBaseBean<MetaAcaoEstrategica> implements Serializable {

    @EJB
    private MetaAcaoEstrategicaBO metaAcaoEstrategicaBO;

    @EJB
    private AcaoEstrategicaBO acaoEstrategicaBO;

    private List<MetaAcaoEstrategica> metas;

    private Filtros filtros;

    private Usuario usuario;

    private List<UnidadeOrcamentaria> unidades;

    @Override
    public MetaAcaoEstrategicaBO getBO() {
        return metaAcaoEstrategicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        metas = new ArrayList<MetaAcaoEstrategica>();
        filtros = new Filtros();
        usuario = SessaoUtils.getUser();
        unidades = getDAO().getInitialized(usuario.getUnidadesDeAcesso());
        filtros.setUnidadesOrcamentaria(unidades);
    }

    @Override
    public void save() {
        super.save();
    }

    public List<MetaAcaoEstrategica> getMetas() {
        return metas;
    }

    public void setMetas(List<MetaAcaoEstrategica> metas) {
        this.metas = metas;
    }

    public Filtros getFiltros() {
        return filtros;
    }

    public List<AcaoEstrategica> autocompleteAcaoEstrategica(String nome) {
        return acaoEstrategicaBO.acaoPeloNomeEUnidades(unidades, nome);
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

    public void buscar() {
        metas = metaAcaoEstrategicaBO.listar(filtros);
    }
}
