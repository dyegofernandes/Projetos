package br.gov.pi.siste.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.CidadeBO;
import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import br.gov.pi.siste.modelo.cadastro.Cidade;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UnidadeMB extends AbstractBaseBean<Unidade> implements Serializable {

    @EJB
    private UnidadeBO unidadeBO;

    @EJB
    private CidadeBO cidadeBO;

    private FiltrosVO filtros;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Unidade> unidades;

    private List<Unidade> unidadesPorLimite;

    private List<Cidade> cidades;

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public List<Unidade> getUnidadesPorLimite() {
        return unidadesPorLimite;
    }

    public void setUnidadesPorLimite(List<Unidade> unidadesPorLimite) {
        this.unidadesPorLimite = unidadesPorLimite;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public UnidadeBO getBO() {
        return unidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void init() {
        filtros = new FiltrosVO();

        if (!usuarioAtual.isSuperUsuario()) {
            getEntity().setOrgao(usuarioAtual.getOrgao());
        }

        filtros.setUsuario(usuarioAtual);

        unidades = unidadeBO.listarUnidades(filtros);

        cidades = cidadeBO.listarCidadesPorEstado("Piauí");
    }

    @Override
    public void postSave() {
        setEntity(new Unidade());
    }

    public void buscar() {
        unidades = unidadeBO.listarUnidades(filtros);
    }

    @Override
    public void delete() {
        super.delete(); 
        unidades = unidadeBO.listarUnidades(filtros);   
    }
    
    

}
