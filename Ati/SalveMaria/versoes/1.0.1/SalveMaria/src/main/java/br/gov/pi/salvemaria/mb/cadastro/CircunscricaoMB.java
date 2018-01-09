package br.gov.pi.salvemaria.mb.cadastro;

import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.CircunscricaoBO;
import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CircunscricaoMB extends AbstractBaseBean<Circunscricao> implements Serializable {

    @EJB
    private CircunscricaoBO circunscricaoBO;

    @EJB
    private CidadeBO cidadeBO;

    private Cidade cidadeAdd;

    private List<Cidade> cidadesAutocomplete = new ArrayList<Cidade>();
    private List<Cidade> cidades = new ArrayList<Cidade>();
    private List<Cidade> cidadesDeletados = new ArrayList<Cidade>();

    @EJB
    private UnidadeBO unidadeBO;

    @Override
    public CircunscricaoBO getBO() {
        return circunscricaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void init() {
        cidadeAdd = new Cidade();
        if (getEntity().getId() != null) {
            cidades = cidadeBO.cidadePelaCircunscricao(getEntity());
        }
    }

    @Override
    public void save() {
        if (cidades.size() > 0) {
            super.save();
            for (Cidade cidade : cidades) {
                cidadeBO.getDAO().saveOrMerge(cidade, true);
            }

            for (Cidade cidade : cidadesDeletados) {
                try {
                    cidadeBO.getDAO().remove(cidade, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(CircunscricaoMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesMessageUtils.error("É necessário ao menos uma cidade para o cadastro de uma Circunscrição!");
        }
    }

    public void addCidade() {
        if (cidadeAdd == null) {
            FacesMessageUtils.error("A cidade deve ser informada!");
        } else {
            if (cidadeJaAdd(cidadeAdd)) {
                FacesMessageUtils.error("A cidade já foi adicionada na lista!");
            } else {
                cidadeAdd.setCircunscricao(getEntity());
                cidades.add(cidadeAdd);
                cidadeAdd = new Cidade();
            }

        }
    }

    public void removerCidade(Cidade cidade) {
        if (cidadeAdd == null) {
            FacesMessageUtils.error("A cidade deve ser informada!");
        }
        if (cidade.getId() != null) {
            cidadesDeletados.add(cidade);
        }
        cidades.remove(cidade);

    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public List<Cidade> getCidadesAutocomplete() {
        cidadesAutocomplete = cidadeBO.listar(null);
        return cidadesAutocomplete;
    }

    public Cidade getCidadeAdd() {
        return cidadeAdd;
    }

    public void setCidadeAdd(Cidade cidadeAdd) {
        this.cidadeAdd = cidadeAdd;
    }

    private boolean cidadeJaAdd(Cidade cidade) {
        for (Cidade cid : cidades) {
            if (cid.equals(cidade)) {
                return true;
            }
        }
        return false;
    }

}
