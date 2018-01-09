package br.com.aprove.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.Loja_FilialBO;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.util.SessaoUtils;
import br.com.aprove.vo.FiltroVO;
import com.xpert.faces.utils.FacesUtils;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class Loja_FilialMB extends AbstractBaseBean<Loja_Filial> implements Serializable {

    @EJB
    private Loja_FilialBO loja_FilialBO;

    private FiltroVO filtros;

    private Usuario usuarioAtual;

    private List<Loja_Filial> lojas;

    @Override
    public Loja_FilialBO getBO() {
        return loja_FilialBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        filtros = new FiltroVO();

        filtros.setUsuario(usuarioAtual);

        lojas = loja_FilialBO.listarLoja_Filial(filtros);

        if (!usuarioAtual.isSuperUsuario()) {
            if (usuarioAtual.getMatriz() != null) {
                getEntity().setMatriz(usuarioAtual.getMatriz());
            }
        }
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/loja_Filial/listLoja_Filial.jsf");
        } else {
            setEntity(new Loja_Filial());
        }

        if (!usuarioAtual.isSuperUsuario()) {
            if (usuarioAtual.getMatriz() != null) {
                getEntity().setMatriz(usuarioAtual.getMatriz());
            }
        }
    }

    public void buscar() {
        lojas = loja_FilialBO.listarLoja_Filial(filtros);
    }

    public FiltroVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroVO filtros) {
        this.filtros = filtros;
    }

    public List<Loja_Filial> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja_Filial> lojas) {
        this.lojas = lojas;
    }
    
    
}
