package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ProgramaDeGovernoBO;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ProgramaDeGovernoMB extends AbstractBaseBean<ProgramaDeGoverno> implements Serializable {

    @EJB
    private ProgramaDeGovernoBO programaDeGovernoBO;

    @Override
    public ProgramaDeGovernoBO getBO() {
        return programaDeGovernoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public List<ProgramaDeGoverno> autocomplete(String nome) {
        return getBO().programaPeloNome(nome);
    }
}
