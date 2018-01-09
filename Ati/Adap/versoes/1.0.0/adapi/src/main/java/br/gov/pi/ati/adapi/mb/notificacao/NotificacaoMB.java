package br.gov.pi.ati.adapi.mb.notificacao;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.adapi.bo.notificacao.NotificacaoBO;
import br.gov.pi.ati.adapi.modelo.notificacao.Notificacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class NotificacaoMB extends AbstractBaseBean<Notificacao> implements Serializable {

    @EJB
    private NotificacaoBO notificacaoBO;

    @Override
    public NotificacaoBO getBO() {
        return notificacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
