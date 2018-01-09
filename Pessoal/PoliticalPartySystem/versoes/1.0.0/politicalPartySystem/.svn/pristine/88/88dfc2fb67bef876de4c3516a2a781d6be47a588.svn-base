package br.com.politicalpartysystem.mb.mensagem;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.mensagem.MessengerBO;
import br.com.politicalpartysystem.modelo.mensagem.Messenger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MessengerMB extends AbstractBaseBean<Messenger> implements Serializable {

    @EJB
    private MessengerBO messengerBO;

    @Override
    public MessengerBO getBO() {
        return messengerBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
