package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.BairroBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import br.gov.pi.ati.siopm.modelo.cadastro.Setor;
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
public class BairroMB extends AbstractBaseBean<Bairro> implements Serializable {

    @EJB
    private BairroBO bairroBO;

    private Setor setor = new Setor();

    private List<Setor> setores;

    @Override
    public void init() {
        if (getEntity().getId() != null) {
            setores = getBO().getDAO().getInitialized(getEntity().getSetores());
        }else{
            setores = new ArrayList<Setor>();
        } 
    }

    @Override
    public void postSave() {
        setor = new Setor();
        setores = new ArrayList<Setor>();
        setEntity(new Bairro());
    }

    @Override
    public void save() {
        getEntity().setSetores(setores);
        super.save();
    }

    @Override
    public BairroBO getBO() {
        return bairroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "cidade.nome, bairro.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("bairro")
                .leftJoinFetch("bairro.cidade", "cidade");
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public void addSetor() {
        if (setor.getNome() != null) {
            if (!setor.getNome().equals("")) {
                if (verificaSeJaExiste(setor.getNome())) {
                    FacesMessageUtils.error("Setor já foi adicionado!");
                } else {
                    setores.add(setor);
                    setor = new Setor();
                }

            } else {
                FacesMessageUtils.error("Nome do Setor é Obrigatório!");
            }

        } else {
            FacesMessageUtils.error("Nome do Setor é Obrigatório!");
        }
    }

    public void removerSetor(Setor setor) {
        setores.remove(setor);
    }

    public boolean verificaSeJaExiste(String nome) {
        for (Setor setore : setores) {
            if (nome.equals(setore.getNome())) {
                return true;
            }
        }
        return false;
    }

    public void buscarSetores() {
        setores = getBO().getDAO().getInitialized(getEntity().getSetores());
    }
}
