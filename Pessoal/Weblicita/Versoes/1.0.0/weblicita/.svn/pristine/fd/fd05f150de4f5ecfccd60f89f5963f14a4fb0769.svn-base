package br.com.weblicita.mb.cadastro;

import br.com.weblicita.bo.cadastro.AdministradorFornecedorBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.FornecedorBO;
import br.com.weblicita.bo.cadastro.TelefoneBO;
import br.com.weblicita.modelo.cadastro.AdministradorFornecedor;
import br.com.weblicita.modelo.cadastro.Fornecedor;
import br.com.weblicita.modelo.cadastro.Telefone;
import br.com.weblicita.modelo.cadastro.enums.TipoDeSocio;
import com.xpert.faces.utils.FacesMessageUtils;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FornecedorMB extends AbstractBaseBean<Fornecedor> implements Serializable {

    @EJB
    private FornecedorBO fornecedorBO;

    @EJB
    private TelefoneBO telefoneBO;

    @EJB
    private AdministradorFornecedorBO administradoresBO;

    private String telefone = "";

    private String nome = "";

    private String cpf = "";

    private TipoDeSocio tipo = null;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoDeSocio getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeSocio tipo) {
        this.tipo = tipo;
    }

    @Override
    public FornecedorBO getBO() {
        return fornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        if (getEntity().getId() != null) {
        }
    }

    @Override
    public void save() {
        super.save();
    }

    public void addTelefone() {
        if (telefone.equals("")) {
            FacesMessageUtils.error("O número do telefone é obrigatório!");
        } else {
            Telefone telefoneTemp = new Telefone();
            telefoneTemp.setNumero(telefone);
            getEntity().getTelefones().add(telefoneTemp);

            telefone = "";
        }
    }

    public void removerTelefone(Telefone telefone) {
        getEntity().getTelefones().remove(telefone);
    }

    public void addAdministrador() {
        if (nome.equals("")) {
            FacesMessageUtils.error("O nome é obrigatório!");
        } else {
            if (tipo != null) {
                AdministradorFornecedor adminTemp = new AdministradorFornecedor();
                adminTemp.setCpf(cpf);
                adminTemp.setNome(nome);
                adminTemp.setTipo(tipo);
                getEntity().getAdministradores().add(adminTemp);
                cpf = "";
                nome = "";
                tipo = null;
            } else {
                FacesMessageUtils.error("O Tipo é obrigatório!");
            }

        }
    }

    public void removerAdministrador(AdministradorFornecedor admin) {
        getEntity().getAdministradores().remove(admin);
    }

}
