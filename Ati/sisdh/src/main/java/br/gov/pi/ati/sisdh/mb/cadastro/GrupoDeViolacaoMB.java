package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.GrupoDeViolacaoBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.GrupoDeViolacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GrupoDeViolacaoMB extends AbstractBaseBean<GrupoDeViolacao> implements Serializable {

    @EJB
    private GrupoDeViolacaoBO grupoDeViolacaoBO;

    @Override
    public GrupoDeViolacaoBO getBO() {
        return grupoDeViolacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
