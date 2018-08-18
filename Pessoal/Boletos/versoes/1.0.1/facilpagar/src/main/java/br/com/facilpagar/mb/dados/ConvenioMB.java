package br.com.facilpagar.mb.dados;

import br.com.facilpagar.bo.controleacesso.UsuarioBO;
import br.com.facilpagar.bo.dados.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.facilpagar.bo.dados.ConvenioBO;
import br.com.facilpagar.modelo.controleacesso.SituacaoUsuario;
import br.com.facilpagar.modelo.controleacesso.Usuario;
import br.com.facilpagar.modelo.dados.Cidade;
import br.com.facilpagar.modelo.dados.Convenio;
import br.com.facilpagar.modelo.dados.Uf;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ConvenioMB extends AbstractBaseBean<Convenio> implements Serializable {

    @EJB
    private ConvenioBO convenioBO;

    @EJB
    private UsuarioBO usuarioBO;

    @EJB
    private CidadeBO cidadeBO;

    private Uf ufFilter;

    private Usuario usuarioAtual;

    private FiltrosBusca filtros;

    private List<Convenio> convenios;

    @Override
    public ConvenioBO getBO() {
        return convenioBO;
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        filtros = new FiltrosBusca();

        filtros.setFranquia(usuarioAtual.getFranquia());

        if (getEntity().getCidade() != null) {
            Cidade cidadeTemp = getDAO().getInitialized(getEntity().getCidade());
            ufFilter = getDAO().getInitialized(cidadeTemp.getUf());
        }

        if (getEntity().getId() == null) {
            getEntity().setFranquia(usuarioAtual.getFranquia());
        }
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        if (!getEntity().isAtivo()) {
            List<Usuario> usuarios = usuarioBO.getDAO().list("convenio.id", getEntity().getId());
            for (Usuario usuario : usuarios) {
                usuario.setSituacaoUsuario(SituacaoUsuario.INATIVO);
                usuarioBO.getDAO().saveOrMerge(usuario, true);
            }
        }
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public Uf getUfFilter() {
        return ufFilter;
    }

    public void setUfFilter(Uf ufFilter) {
        this.ufFilter = ufFilter;
    }

    public void chanceTipoPessoa() {
        getEntity().setCpf_cnpj(null);
        getEntity().setInsc_est(null);
        getEntity().setNome_fantasia(null);
        getEntity().setRazao_social(null);
    }

    public List<Convenio> autocomplete(String nome) {
        return getBO().conveniosPeloNomeOrCnpjOuCpf(nome);
    }

    public List<Cidade> autocompleteCidade(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(ufFilter, nome);
    }

    public void buscar() {
        convenios = getBO().convenios(filtros);
    }

    public List<Cidade> autocompleteCidadeFiltro(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(filtros.getEstado(), nome);
    }

}
