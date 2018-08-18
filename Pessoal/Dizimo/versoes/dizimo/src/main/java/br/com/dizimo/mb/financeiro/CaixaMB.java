package br.com.dizimo.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.financeiro.CaixaBO;
import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.enums.StatusCaixa;
import br.com.dizimo.modelo.financeiro.Caixa;
import br.com.dizimo.util.SessaoUtils;
import com.xpert.persistence.query.JoinBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CaixaMB extends AbstractBaseBean<Caixa> implements Serializable {

    @EJB
    private CaixaBO caixaBO;

    private Usuario usuarioAtual;

    private StatusCaixa statusTemp;

    private List<StatusCaixa> situacoes = new ArrayList<StatusCaixa>(Arrays.asList(StatusCaixa.values()));

    @Override
    public CaixaBO getBO() {
        return caixaBO;
    }

    public List<StatusCaixa> getSituacoes() {
        return situacoes;
    }

    @Override
    public String getDataModelOrder() {
        return "caixa.abertura";
    }
    
    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("caixa")
                .leftJoinFetch("caixa.usuario", "usuario");
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();

        if (getEntity().getId() != null) {
            statusTemp = getEntity().getStatus();
        } else {
            getEntity().setUsuario(usuarioAtual);

            situacoes.remove(StatusCaixa.FECHADO);
            statusTemp = StatusCaixa.ABERTO;
        }
    }

    @Override
    public void save() {

        super.save();
    }

    public void mudarStatus() {
        if (getEntity().getStatus() != null) {
            if (getEntity().getStatus() == StatusCaixa.ABERTO) {
                getEntity().setAbertura(new Date());
                getEntity().setFechamento(null);
            } else {
                getEntity().setFechamento(new Date());
            }
        } else {
            getEntity().setAbertura(null);
            getEntity().setFechamento(null);
        }
    }

}
