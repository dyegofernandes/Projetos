package br.com.pagcontascarne.mb.dados;

import br.com.pagcontascarne.bo.controleacesso.UsuarioBO;
import br.com.pagcontascarne.bo.dados.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ConvenioBO;
import br.com.pagcontascarne.modelo.controleacesso.SituacaoUsuario;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Cidade;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Uf;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
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
    
    private Usuario usuarioAtual = SessaoUtils.getUser();
    
    private FiltrosBusca filtros;
    
    private List<Convenio> convenios;
    
    @Override
    public ConvenioBO getBO() {
        return convenioBO;
    }
    
    @Override
    public void init() {
        filtros = new FiltrosBusca();
        filtros.setFranquia(usuarioAtual.getFranquia());
        if (getEntity().getCidade() != null) {
            Cidade cidadeTemp = getDAO().getInitialized(getEntity().getCidade());
            ufFilter = getDAO().getInitialized(cidadeTemp.getUf());
        } else {
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
