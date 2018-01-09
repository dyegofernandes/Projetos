package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ParticipanteBO;
import br.gov.pi.ati.sisforms.modelo.formulario.Participante;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ParticipanteMB extends AbstractBaseBean<Participante> implements Serializable {

    @EJB
    private ParticipanteBO participanteBO;

    @Override
    public ParticipanteBO getBO() {
        return participanteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
