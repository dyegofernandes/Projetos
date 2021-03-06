package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.CargoBO;
import br.com.weblicita.modelo.cadastro.Cargo;
import br.com.weblicita.util.SessaoUtils;
import br.com.weblicita.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CargoMB extends AbstractBaseBean<Cargo> implements Serializable {

    @EJB
    private CargoBO cargoBO;
    
    private boolean renderizarCampo;

    private boolean somenteLeitura;

    private boolean renderizarFormulario;

    private String nome = "";

    @Override
    public CargoBO getBO() {
        return cargoBO;
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
        setEntity(new Cargo());
    }

    @Override
    public void save() {
        getEntity().setCodigo(getBO().gerarCodigo());
        super.save(); 
    }

    public void novo() {
        setEntity(new Cargo());
        getEntity().setOrgao(SessaoUtils.getUser().getOrgao());
        getEntity().setCodigo(getBO().gerarCodigo());
        renderizarCampo = true;
        somenteLeitura = false;
        renderizarFormulario = true;
    }

    public void excluir() {
        if (getEntity().getId() != null) {
            remove();
            setEntity(new Cargo());
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
        } else {
            FacesMessageUtils.error("Informe o Cargo a ser desativado!");
        }
    }

    public void editar() {
        if (getEntity().getId() != null) {
            renderizarCampo = true;
            somenteLeitura = false;
            renderizarFormulario = true;
        } else {
            FacesMessageUtils.error("Informe o Cargo a ser editado!");
        }
    }
    
    public void desativar() {
        if (getEntity().getId() != null) {
            getEntity().setAtivo(false);
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
            super.save();

        } else {
            FacesMessageUtils.error("Carregue a Cargo que será desativado!!");
        }
    }

    public void ativar() {
        if (getEntity().getId() != null) {
            getEntity().setAtivo(true);
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
            super.save();

        } else {
            FacesMessageUtils.error("Carregue a Cargo que será ativado!!");
        }
    }

    public void buscar() {
        if (!Utils.isNullOrEmpty(nome)) {
            Cargo cargoTemp = getDAO().unique("UPPER(TRANSLATE(nome,'ÁÀÂÃÄáàâãäÉÈÊËéèêëÍÌÎÏíìîïÓÒÕÔÖóòôõöÚÙÛÜúùûüÇç','AAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUUuuuuCc'))", 
                    Utils.removerAcentos(nome.toUpperCase()));
            if (cargoTemp != null) {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = true;
                setEntity(cargoTemp);
                getEntity().setOrgao(SessaoUtils.getUser().getOrgao());
            } else {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = false;
                FacesMessageUtils.error("Cargo não encontrado!");
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
    
    public boolean habilitarBotaoDesativar() {
        return getEntity().getId() != null && getEntity().isAtivo();
    }

    public boolean habilitarBotaoAtivar() {
        return getEntity().getId() != null && !getEntity().isAtivo();
    }
}
