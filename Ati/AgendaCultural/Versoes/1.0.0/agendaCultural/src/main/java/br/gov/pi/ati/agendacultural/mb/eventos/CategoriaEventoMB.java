package br.gov.pi.ati.agendacultural.mb.eventos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.eventos.CategoriaEventoBO;
import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CategoriaEventoMB extends AbstractBaseBean<CategoriaEvento> implements Serializable {

    @EJB
    private CategoriaEventoBO categoriaEventoBO;

    @Override
    public CategoriaEventoBO getBO() {
        return categoriaEventoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
