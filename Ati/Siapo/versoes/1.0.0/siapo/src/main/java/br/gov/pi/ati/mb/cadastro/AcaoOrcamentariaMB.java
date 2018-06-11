package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.AcaoOrcamentariaBO;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AcaoOrcamentariaMB extends AbstractBaseBean<AcaoOrcamentaria> implements Serializable {

    private FonteDeRecurso fonteRecursoAdd;

    private List<FonteDeRecurso> fontesRecurso;

    @EJB
    private AcaoOrcamentariaBO acaoOrcamentariaBO;

    @Override
    public AcaoOrcamentariaBO getBO() {
        return acaoOrcamentariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        fontesRecurso = new ArrayList<FonteDeRecurso>();

        if (getEntity().getId() != null) {
            fontesRecurso = getDAO().getInitialized(getEntity().getFontesDeRecurso());
        }
    }

    @Override
    public void save() {
        getEntity().setFontesDeRecurso(fontesRecurso);
        super.save();
    }

    public void addFonteRecurso() {
        if (fonteRecursoAdd != null) {
            if (fonteJahAdicionada(fonteRecursoAdd)) {
                FacesMessageUtils.error("Fonte já foi adicionada!");
            } else {
                fontesRecurso.add(fonteRecursoAdd);
                fonteRecursoAdd = null;
            }
        } else {
            FacesMessageUtils.error("Fonte de Recurso é obrigatória!");
        }
    }

    public void removerFonteRecurso(FonteDeRecurso fonte) {
        fontesRecurso.remove(fonte);
    }

    public boolean fonteJahAdicionada(FonteDeRecurso fonte) {
        for (FonteDeRecurso fonteTemp : fontesRecurso) {
            if (fonteTemp.equals(fonte)) {
                return true;
            }
        }
        return false;
    }
}
