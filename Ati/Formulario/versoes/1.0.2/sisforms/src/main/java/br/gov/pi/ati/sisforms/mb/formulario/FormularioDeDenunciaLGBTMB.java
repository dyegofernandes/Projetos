package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.FormularioDeDenunciaLGBTBO;
import br.gov.pi.ati.sisforms.modelo.formulario.FormularioDeDenunciaLGBT;
import br.gov.pi.ati.sisforms.modelo.formulario.PessoaDenuncia;
import com.xpert.persistence.query.JoinBuilder;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FormularioDeDenunciaLGBTMB extends AbstractBaseBean<FormularioDeDenunciaLGBT> implements Serializable {

    @EJB
    private FormularioDeDenunciaLGBTBO formularioDeDenunciaLGBTBO;

    private PessoaDenuncia identificacaoVitima;
    private PessoaDenuncia pessoaDenunciada;
    private PessoaDenuncia pessoaDenunciante;

    public PessoaDenuncia getIdentificacaoVitima() {
        return identificacaoVitima;
    }

    public void setIdentificacaoVitima(PessoaDenuncia identificacaoVitima) {
        this.identificacaoVitima = identificacaoVitima;
    }

    public PessoaDenuncia getPessoaDenunciada() {
        return pessoaDenunciada;
    }

    public void setPessoaDenunciada(PessoaDenuncia pessoaDenunciada) {
        this.pessoaDenunciada = pessoaDenunciada;
    }

    public PessoaDenuncia getPessoaDenunciante() {
        return pessoaDenunciante;
    }

    public void setPessoaDenunciante(PessoaDenuncia pessoaDenunciante) {
        this.pessoaDenunciante = pessoaDenunciante;
    }

    @Override
    public FormularioDeDenunciaLGBTBO getBO() {
        return formularioDeDenunciaLGBTBO;
    }

    @Override
    public String getDataModelOrder() {
        return "formulario.id";
    }

    @Override
    public void init() {
        if (getEntity().getId() != null) {
            identificacaoVitima = getBO().getDAO().getInitialized(getEntity().getIdentificacaoVitima());
            pessoaDenunciada = getBO().getDAO().getInitialized(getEntity().getPessoaDenunciada());
            pessoaDenunciante = getBO().getDAO().getInitialized(getEntity().getPessoaDenunciante());
        } else {
            identificacaoVitima = new PessoaDenuncia();
            pessoaDenunciada = new PessoaDenuncia();
            pessoaDenunciante = new PessoaDenuncia();
        }

    }

    @Override
    public void save() {
        getEntity().setIdentificacaoVitima(identificacaoVitima);
        getEntity().setPessoaDenunciada(pessoaDenunciada);
        getEntity().setPessoaDenunciante(pessoaDenunciante);
        super.save(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postSave() {
        setEntity(new FormularioDeDenunciaLGBT());
        identificacaoVitima = new PessoaDenuncia();
        pessoaDenunciada = new PessoaDenuncia();
        pessoaDenunciante = new PessoaDenuncia();
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("formulario")
                .leftJoinFetch("formulario.identificacaoVitima", "identificacaoVitima").leftJoinFetch("formulario.pessoaDenunciada", "pessoaDenunciada")
                .leftJoinFetch("formulario.pessoaDenunciante", "pessoaDenunciante");
    }
}
