package br.gov.pi.siste.mb.controleacesso;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.controleacesso.AcessoSistemaBO;
import br.gov.pi.siste.modelo.controleacesso.AcessoSistema;
import com.xpert.persistence.query.JoinBuilder;

/**
 *
 * @author ayslan
 */
@ManagedBean
@ViewScoped
public class AcessoSistemaMB extends AbstractBaseBean<AcessoSistema> implements Serializable {

    @EJB
    private AcessoSistemaBO acessoSistemaBO;

    @Override
    public AbstractBusinessObject getBO() {
        return acessoSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "acesso.id DESC";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("acesso").leftJoinFetch("acesso.usuario", "usuario").leftJoinFetch("usuario.orgao", "orgao").
                leftJoinFetch("usuario.unidade", "unidade");
    }
    
    
}
