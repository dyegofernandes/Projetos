package br.com.politicalpartysystem.mb.mensagem;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.mensagem.MessageBoardsBO;
import br.com.politicalpartysystem.modelo.mensagem.MessageBoards;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MessageBoardsMB extends AbstractBaseBean<MessageBoards> implements Serializable {

    @EJB
    private MessageBoardsBO messageBoardsBO;

    @Override
    public MessageBoardsBO getBO() {
        return messageBoardsBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
