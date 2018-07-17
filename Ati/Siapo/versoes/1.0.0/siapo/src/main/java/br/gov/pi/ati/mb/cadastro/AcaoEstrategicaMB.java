package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.AcaoEstrategicaBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AcaoEstrategicaMB extends AbstractBaseBean<AcaoEstrategica> implements Serializable {

    @EJB
    private AcaoEstrategicaBO acaoEstrategicaBO;

    private Usuario usuario;

    private List<UnidadeOrcamentaria> unidades;

    @Override
    public AcaoEstrategicaBO getBO() {
        return acaoEstrategicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuario = SessaoUtils.getUser();
        unidades = getDAO().getInitialized(usuario.getUnidadesDeAcesso());
    }

    public List<AcaoEstrategica> autocomplete(String nome) {
        return getBO().acaoPeloNomeEUnidades(unidades, nome);
    }

}
