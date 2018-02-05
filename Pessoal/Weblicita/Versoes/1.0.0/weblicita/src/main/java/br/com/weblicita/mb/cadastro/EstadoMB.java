package br.com.weblicita.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.EstadoBO;
import br.com.weblicita.modelo.cadastro.Estado;
import br.com.weblicita.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.Restrictions;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EstadoMB extends AbstractBaseBean<Estado> implements Serializable {

    @EJB
    private EstadoBO estadoBO;

    private boolean renderizarCampo;

    private boolean somenteLeitura;

    private boolean renderizarFormulario;

    private String nome = "";

    @Override
    public EstadoBO getBO() {
        return estadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Estado> autocomplete(String nome) {
        return getBO().estadoPeloNome(nome);
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
        setEntity(new Estado());
    }

    @Override
    public void save() {
        super.save(); //To change body of generated methods, choose Tools | Templates.
    }

    public void novo() {
        setEntity(new Estado());
        renderizarCampo = true;
        somenteLeitura = false;
        renderizarFormulario = true;
    }

    public void excluir() {
        if (getEntity().getId() != null) {
            remove();
            setEntity(new Estado());
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
        } else {
            FacesMessageUtils.error("Informe o Estado a ser desativado!");
        }
    }

    public void editar() {
        if (getEntity().getId() != null) {
            renderizarCampo = true;
            somenteLeitura = false;
            renderizarFormulario = true;
        } else {
            FacesMessageUtils.error("Informe o Estado a ser editado!");
        }
    }

    public void buscar() {
        setEntity(new Estado());
        if (!Utils.isNullOrEmpty(nome)) {
            Restrictions restrictions = new Restrictions();
            restrictions.equals("UPPER(nome)", nome.toUpperCase());
            Estado estadoTemp = getDAO().unique(restrictions);
            if (estadoTemp != null) {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = true;
                setEntity(estadoTemp);
            } else {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = false;
                FacesMessageUtils.error("Estado não encontrado!");
            }
        } else {
            renderizarCampo = false;
            somenteLeitura = true;
            renderizarFormulario = false;
            FacesMessageUtils.error("Informe o nome para busca!");
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
