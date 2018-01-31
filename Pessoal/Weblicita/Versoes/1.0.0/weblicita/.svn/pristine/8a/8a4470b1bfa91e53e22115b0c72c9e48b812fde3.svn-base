package br.com.weblicita.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.RubricaOrcamentariaBO;
import br.com.weblicita.modelo.cadastro.RubricaOrcamentaria;
import br.com.weblicita.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RubricaOrcamentariaMB extends AbstractBaseBean<RubricaOrcamentaria> implements Serializable {

    @EJB
    private RubricaOrcamentariaBO rubricaOrcamentariaBO;

    private boolean renderizarCampo;

    private boolean somenteLeitura;

    private boolean renderizarFormulario;

    private String legenda = "";

    @Override
    public RubricaOrcamentariaBO getBO() {
        return rubricaOrcamentariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        renderizarCampo = false;
        somenteLeitura = false;
        renderizarFormulario = false;
    }

    @Override
    public void postSave() {
        renderizarCampo = false;
        somenteLeitura = false;
        renderizarFormulario = false;
        setEntity(new RubricaOrcamentaria());
    }

    @Override
    public void save() {
        super.save();
    }

    public void novo() {
        setEntity(new RubricaOrcamentaria());
        renderizarCampo = true;
        somenteLeitura = false;
        renderizarFormulario = true;
    }

    public void excluir() {
        if (getEntity().getId() != null) {
            remove();
            setEntity(new RubricaOrcamentaria());
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
        } else {
            FacesMessageUtils.error("Informe a Rubrica a ser desativado!");
        }
    }

    public void editar() {
        if (getEntity().getId() != null) {
            renderizarCampo = true;
            somenteLeitura = false;
            renderizarFormulario = true;
        } else {
            FacesMessageUtils.error("Informe Rubrica a ser editado!");
        }
    }

    public void buscar() {
        if (!Utils.isNullOrEmpty(legenda)) {
            RubricaOrcamentaria rubrica = getDAO().unique("legenda", legenda);
            if (rubrica != null) {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = true;
                setEntity(rubrica);
            } else {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = false;
                FacesMessageUtils.error("Rubrica não encontrado!");
            }
        } else {
            renderizarCampo = false;
            somenteLeitura = true;
            renderizarFormulario = false;
            FacesMessageUtils.error("Informe a legenda para busca!");
        }
    }

    public boolean isRenderizarCampo() {
        return renderizarCampo;
    }

    public void setRenderizarCampo(boolean renderizarCampo) {
        this.renderizarCampo = renderizarCampo;
    }

    public boolean isSomenteLeitura() {
        return somenteLeitura;
    }

    public void setSomenteLeitura(boolean somenteLeitura) {
        this.somenteLeitura = somenteLeitura;
    }

    public boolean isRenderizarFormulario() {
        return renderizarFormulario;
    }

    public void setRenderizarFormulario(boolean renderizarFormulario) {
        this.renderizarFormulario = renderizarFormulario;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public List<RubricaOrcamentaria> autocomplete(String nome) {
        return getBO().rubricaPelaLegnda(nome);
    }
}
