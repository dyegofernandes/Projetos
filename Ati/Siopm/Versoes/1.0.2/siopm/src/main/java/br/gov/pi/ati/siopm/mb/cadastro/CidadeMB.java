package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.CidadeBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import com.xpert.persistence.query.JoinBuilder;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CidadeMB extends AbstractBaseBean<Cidade> implements Serializable {

    @EJB
    private CidadeBO cidadeBO;

    @Override
    public CidadeBO getBO() {
        return cidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "estado.nome, cidade.nome";
    }
    
    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("cidade")
                .leftJoinFetch("cidade.estado", "estado");
    }

    @Override
    public void postSave() {
        setEntity(new Cidade());
    }
    
    
}
