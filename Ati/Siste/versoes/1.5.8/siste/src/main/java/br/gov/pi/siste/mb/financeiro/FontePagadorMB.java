package br.gov.pi.siste.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.financeiro.FontePagadorBO;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.FontePagador;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FontePagadorMB extends AbstractBaseBean<FontePagador> implements Serializable {

    @EJB
    private FontePagadorBO fontePagadorBO;
    
    private FiltrosVO filtros;

    private Usuario usuarioAtual = SessaoUtils.getUser();
    
    private List<FontePagador> fontesPagadoras;
    
    @Override
    public void init(){
        filtros = new FiltrosVO();

        if (getEntity().getId()!=null) {
            getEntity().setOrgao(usuarioAtual.getOrgao());
        }

        filtros.setUsuario(usuarioAtual);

        fontesPagadoras = fontePagadorBO.listarFontesPagadoras(filtros);
    }

    public void buscar() {

        filtros.setUsuario(usuarioAtual);

        fontesPagadoras = fontePagadorBO.listarFontesPagadoras(filtros);
        
    }
    
    public List<Orgao> orgaoAutocompletePeloNome(String nome) {
        return getBO().orgaoPeloNome(nome);
    }
    
    @Override
    public FontePagadorBO getBO() {
        return fontePagadorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void postSave() {
        setEntity(new FontePagador());
    }

    public FontePagadorBO getFontePagadorBO() {
        return fontePagadorBO;
    }

    public void setFontePagadorBO(FontePagadorBO fontePagadorBO) {
        this.fontePagadorBO = fontePagadorBO;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public List<FontePagador> getFontesPagadoras() {
        return fontesPagadoras;
    }

    public void setFontesPagadoras(List<FontePagador> fontesPagadoras) {
        this.fontesPagadoras = fontesPagadoras;
    }
    
}
