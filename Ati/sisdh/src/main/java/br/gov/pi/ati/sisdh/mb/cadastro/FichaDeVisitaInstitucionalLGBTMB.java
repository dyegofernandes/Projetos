package br.gov.pi.ati.sisdh.mb.cadastro;

import br.gov.pi.ati.sisdh.bo.cadastro.FichaDeVisitaInstitucionalLGBTBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.FichaDeVisitaInstitucionalLGBT;
import br.gov.pi.ati.sisdh.modelo.cadastro.ProfissionalDeReferenciaFichaVisita;
import br.gov.pi.ati.sisdh.util.Utils;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FichaDeVisitaInstitucionalLGBTMB extends AbstractBaseBean<FichaDeVisitaInstitucionalLGBT> implements Serializable {

    @EJB
    private FichaDeVisitaInstitucionalLGBTBO fichaDeVisitaInstitucionalLGBTBO;

    private List<ProfissionalDeReferenciaFichaVisita> profissionais;

    private String nome;

    private String telefone;

    @Override
    public FichaDeVisitaInstitucionalLGBTBO getBO() {
        return fichaDeVisitaInstitucionalLGBTBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        if (getEntity().getId() != null) {
            profissionais = getBO().getDAO().getInitialized(getEntity().getProfissionais());
        } else {
            profissionais = new ArrayList<ProfissionalDeReferenciaFichaVisita>();
        }
    }

    @Override
    public void save() {
        getEntity().setProfissionais(profissionais);

        super.save();
    }

    @Override
    public void postSave() {
        nome = "";
        telefone = "";
        profissionais = new ArrayList<ProfissionalDeReferenciaFichaVisita>();
        setEntity(new FichaDeVisitaInstitucionalLGBT());
    }

    public List<ProfissionalDeReferenciaFichaVisita> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<ProfissionalDeReferenciaFichaVisita> profissionais) {
        this.profissionais = profissionais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addProfissional() {
        if (Utils.isNullOrEmpty(nome)) {
            FacesMessageUtils.error("Nome é obrigatório!");
        } else {
            ProfissionalDeReferenciaFichaVisita profissional = new ProfissionalDeReferenciaFichaVisita();
            profissional.setNome(nome);
            profissional.setTelefone(telefone);
            profissionais.add(profissional);
            nome = "";
            telefone = "";
        }
    }

    public void removerProfissional(ProfissionalDeReferenciaFichaVisita profissional) {
        profissionais.remove(profissional);
    }

}
