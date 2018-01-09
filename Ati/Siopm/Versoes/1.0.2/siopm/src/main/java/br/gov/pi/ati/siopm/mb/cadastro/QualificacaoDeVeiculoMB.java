package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.QualificacaoDeVeiculoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class QualificacaoDeVeiculoMB extends AbstractBaseBean<QualificacaoDeVeiculo> implements Serializable {

    @EJB
    private QualificacaoDeVeiculoBO qualificacaoDeVeiculoBO;

    @Override
    public QualificacaoDeVeiculoBO getBO() {
        return qualificacaoDeVeiculoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}