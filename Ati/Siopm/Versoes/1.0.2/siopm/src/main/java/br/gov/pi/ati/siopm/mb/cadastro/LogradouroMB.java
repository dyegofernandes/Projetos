package br.gov.pi.ati.siopm.mb.cadastro;

import br.gov.pi.ati.siopm.bo.cadastro.BairroBO;
import br.gov.pi.ati.siopm.bo.cadastro.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.LogradouroBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Logradouro;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.JoinBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LogradouroMB extends AbstractBaseBean<Logradouro> implements Serializable {

    @EJB
    private LogradouroBO logradouroBO;

    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private BairroBO bairroBO;

    private List<Bairro> bairrosLogradouro;

    private Bairro bairroAdd = new Bairro();

    @Override
    public void init() {
        if (getEntity().getId() != null) {
            bairrosLogradouro = getBO().getDAO().getInitialized(getEntity().getBairros());
        } else {
            bairrosLogradouro = new ArrayList<Bairro>();
        }
    }

    @Override
    public void postSave() {
        setEntity(new Logradouro());
        bairrosLogradouro = new ArrayList<Bairro>();
        bairroAdd = new Bairro();
    }

    @Override
    public void save() {
        getEntity().setBairros(bairrosLogradouro);
        super.save();
    }

    @Override
    public LogradouroBO getBO() {
        return logradouroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "cidade.nome, logradouro.logradouro";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("logradouro")
                .leftJoinFetch("logradouro.cidade", "cidade");
    }

    public List<Cidade> getCidades() {
        return cidadeBO.listarCidadePeloEstado(17L);
    }

    public List<Bairro> getBairros() {
        List<Bairro> bairros = null;
        if (getEntity().getCidade() != null) {
            bairros = bairroBO.getDAO().list("cidade", getEntity().getCidade(), "nome");
        }
        return bairros;
    }

    public List<Bairro> getBairrosLogradouro() {
        return bairrosLogradouro;
    }

    public void setBairrosLogradouro(List<Bairro> bairrosLogradouro) {
        this.bairrosLogradouro = bairrosLogradouro;
    }

    public Bairro getBairroAdd() {
        return bairroAdd;
    }

    public void setBairroAdd(Bairro bairroAdd) {
        this.bairroAdd = bairroAdd;
    }

    public void addBairro() {
        if (bairroAdd != null) {
            bairrosLogradouro.add(bairroAdd);
            bairroAdd = new Bairro();
        }else{
            FacesMessageUtils.error("Bairro é obrigatório!");
        }
        
    }

    public void removerBairro(Bairro bairro) {
        bairrosLogradouro.add(bairro);
    }
}
