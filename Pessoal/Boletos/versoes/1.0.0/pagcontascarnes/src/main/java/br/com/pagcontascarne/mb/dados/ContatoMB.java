package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ContatoBO;
import br.com.pagcontascarne.bo.dados.ConvenioBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Contato;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContatoMB extends AbstractBaseBean<Contato> implements Serializable {

    @EJB
    private ContatoBO contatoBO;
    
    @EJB
    private ConvenioBO convenioBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Contato> contatos;

    private FiltrosBusca filtros;
    
    private List<Convenio> conveniosFiltros;

    @Override
    public ContatoBO getBO() {
        return contatoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        contatos = new ArrayList<Contato>();
        filtros = new FiltrosBusca();
        filtros.setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
        filtros.setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        conveniosFiltros = new ArrayList<Convenio>();
        pegarConveniosFiltros();
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        }
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Convenio> getConveniosFiltros() {
        return conveniosFiltros;
    }

    public void setConveniosFiltros(List<Convenio> conveniosFiltros) {
        this.conveniosFiltros = conveniosFiltros;
    }

    public void buscar() {
        contatos = getBO().listar(filtros);
    }
    
    public void pegarConveniosFiltros() {
        conveniosFiltros = new ArrayList<Convenio>();

        if (filtros.getFranquia() != null) {
            conveniosFiltros = convenioBO.convenioPelaFranquia(filtros.getFranquia());
        }
    }
}
