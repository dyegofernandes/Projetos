package br.com.dizimo.mb.financeiro;

import br.com.dizimo.bo.cadastro.MembroBO;
import br.com.dizimo.bo.financeiro.CaixaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.financeiro.DizimoBO;
import br.com.dizimo.modelo.cadastro.Membro;
import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.financeiro.Caixa;
import br.com.dizimo.modelo.financeiro.Dizimo;
import br.com.dizimo.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DizimoMB extends AbstractBaseBean<Dizimo> implements Serializable {

    @EJB
    private DizimoBO dizimoBO;

    @EJB
    private CaixaBO caixaBO;
    
    @EJB
    private MembroBO membroBO;

    private Usuario usuarioAtual;

    @Override
    public DizimoBO getBO() {
        return dizimoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
            Caixa caixaTemp = caixaBO.caixaAberto(usuarioAtual);
            if (caixaTemp != null) {
                getEntity().setCaixa(caixaTemp);
            }
        }
    }
    
    public List<Membro> getMembros(String nome){
        return membroBO.membrosPelaSede(usuarioAtual.getSede(), nome);
    }

}
