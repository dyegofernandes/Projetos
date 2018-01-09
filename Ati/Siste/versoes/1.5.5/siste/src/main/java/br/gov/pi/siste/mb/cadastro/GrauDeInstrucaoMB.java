package br.gov.pi.siste.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.GrauDeInstrucaoBO;
import br.gov.pi.siste.modelo.cadastro.GrauDeInstrucao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GrauDeInstrucaoMB extends AbstractBaseBean<GrauDeInstrucao> implements Serializable {

    @EJB
    private GrauDeInstrucaoBO grauDeInstrucaoBO;

    @Override
    public GrauDeInstrucaoBO getBO() {
        return grauDeInstrucaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }
    
    @Override
    public void postSave() {
        setEntity(new GrauDeInstrucao());
    }
}
