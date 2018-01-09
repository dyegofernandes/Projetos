package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.ListaLojaBO;
import br.com.jsoft.centralfinanceira.dao.central.ListaLoja_LojaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja_Loja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Loja;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restrictions;
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
public class ListaLojaMB extends AbstractBaseBean<ListaLoja> implements Serializable {

    @EJB
    private ListaLojaBO listaLojaBO;

    @EJB
    private ListaLoja_LojaDAO listaLoja_LojaDAO;

    QueryBuilder queryBuilder;
    Restrictions restrictions;
    private List<ListaLoja_Loja> listaLojas_Loja;
    private List<ListaLoja_Loja> listaLojas_LojaDeletados;

    private Loja lojaAdd;

    public List<ListaLoja_Loja> getListaLojas_LojaDeletados() {
        return listaLojas_LojaDeletados;
    }

    public void setListaLojas_LojaDeletados(List<ListaLoja_Loja> listaLojas_LojaDeletados) {
        this.listaLojas_LojaDeletados = listaLojas_LojaDeletados;
    }

    public List<ListaLoja_Loja> getListaLojas_Loja() {
        return listaLojas_Loja;
    }

    public void setListaLojas_Loja(List<ListaLoja_Loja> listaLojas_Loja) {
        this.listaLojas_Loja = listaLojas_Loja;
    }

    public Loja getLojaAdd() {
        return lojaAdd;
    }

    public void setLojaAdd(Loja lojaAdd) {
        this.lojaAdd = lojaAdd;
    }

    @Override
    public ListaLojaBO getBO() {
        return listaLojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {

        listaLojas_Loja = new ArrayList<ListaLoja_Loja>();
        listaLojas_LojaDeletados = new ArrayList<ListaLoja_Loja>();
        if (getEntity().getId() != null) {
            queryBuilder = listaLoja_LojaDAO.getQueryBuilder();
            restrictions = new Restrictions();
            restrictions.equals("l.id", getEntity().getId());

            listaLojas_Loja = new ArrayList<ListaLoja_Loja>();
            listaLojas_Loja = queryBuilder.from(ListaLoja_Loja.class, "ll").leftJoinFetch("ll.listaLoja", "l").add(restrictions).getResultList();

        }
    }

    @Override
    public void save() {
        if (listaLojas_Loja.size() < 1) {
            FacesMessageUtils.error("É obrigatório associar ao menos uma Loja ao cadastro!");
        } else {
            super.save();
            for (ListaLoja_Loja loja : listaLojas_Loja) {
                listaLoja_LojaDAO.saveOrMerge(loja, true);
            }

            for (ListaLoja_Loja loja : listaLojas_LojaDeletados) {
                try {
                    listaLoja_LojaDAO.remove(loja, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(ListaLojaMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    @Override
    public void delete() {
        queryBuilder = listaLoja_LojaDAO.getQueryBuilder();
        restrictions = new Restrictions();
        restrictions.equals("l.id", getEntity().getId());
        List<ListaLoja_Loja> deletadas = queryBuilder.from(ListaLoja_Loja.class, "ll").leftJoinFetch("ll.listaLoja", "l").add(restrictions).getResultList();

        for (ListaLoja_Loja loja : deletadas) {
            try {
                listaLoja_LojaDAO.remove(loja, true);
            } catch (DeleteException ex) {
                Logger.getLogger(ListaLojaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        super.delete();
    }

    public void addLoja() {
        if (lojaAdd != null) {
            if (verificaLoja(lojaAdd)) {
                FacesMessageUtils.error("Loja já adicionada!");
            } else {
                ListaLoja_Loja novo = new ListaLoja_Loja();
                novo.setListaLoja(getEntity());
                novo.setLoja(lojaAdd);
                novo.setId(null);
                listaLojas_Loja.add(novo);
                lojaAdd = null;
            }
        } else {
            FacesMessageUtils.error("Loja é obrigatório!");
        }
    }

    public void removerLoja(ListaLoja_Loja removida) {
        if (removida.getId() != null) {
            listaLojas_Loja.remove(removida);
            listaLojas_LojaDeletados.add(removida);
        } else {
            listaLojas_Loja.remove(removida);
        }
    }

    private boolean verificaLoja(Loja loja) {
        for (ListaLoja_Loja loja1 : listaLojas_Loja) {
            if (loja1.getLoja().equals(loja)) {
                return true;
            }
        }
        return false;
    }

}
