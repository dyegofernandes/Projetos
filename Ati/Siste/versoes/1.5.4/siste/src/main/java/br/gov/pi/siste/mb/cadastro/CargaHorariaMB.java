package br.gov.pi.siste.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.CargaHorariaBO;
import br.gov.pi.siste.modelo.cadastro.CargaHoraria;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CargaHorariaMB extends AbstractBaseBean<CargaHoraria> implements Serializable {

    @EJB
    private CargaHorariaBO cargaHorariaBO;

    @Override
    public CargaHorariaBO getBO() {
        return cargaHorariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }
    @Override
    public void postSave() {
        setEntity(new CargaHoraria());
    }
}
