package br.com.politicalpartysystem.mb.mensagem;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.mensagem.MailBoxBO;
import br.com.politicalpartysystem.modelo.mensagem.MailBox;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MailBoxMB extends AbstractBaseBean<MailBox> implements Serializable {

    @EJB
    private MailBoxBO mailBoxBO;

    @Override
    public MailBoxBO getBO() {
        return mailBoxBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
