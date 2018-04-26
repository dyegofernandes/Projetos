package br.gov.pi.ati.sccd.mb.certificado;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.AgendamentoBO;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AgendamentoMB extends AbstractBaseBean<Agendamento> implements Serializable {

    @EJB
    private AgendamentoBO agendamentoBO;

    @Override
    public AgendamentoBO getBO() {
        return agendamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
