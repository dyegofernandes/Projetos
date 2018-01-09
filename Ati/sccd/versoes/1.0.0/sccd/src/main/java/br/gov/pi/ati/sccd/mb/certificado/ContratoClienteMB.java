package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.ContratoClienteBO;
import br.gov.pi.ati.sccd.bo.certificado.ContratoFornecedorBO;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContratoClienteMB extends AbstractBaseBean<ContratoCliente> implements Serializable {

    @EJB
    private ContratoClienteBO contratoClienteBO;

    @EJB
    private ContratoFornecedorBO contraFornecedorBO;

    private List<TipoCertificadoAux> certificados;

    private TipoCertificadoAux certificadoAdd;

    @Override
    public ContratoClienteBO getBO() {
        return contratoClienteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        certificadoAdd = new TipoCertificadoAux();
        certificados = new ArrayList<TipoCertificadoAux>();
    }

    @Override
    public void save() {
        getEntity().setContratoFornecedor(getContratosFornecedores());
        getEntity().setCertificados(certificados);
        super.save();
    }

    @Override
    public void postSave() {
        certificadoAdd = new TipoCertificadoAux();
        certificados = new ArrayList<TipoCertificadoAux>();
        super.postSave();
    }

    public void addCertificado() {
        if (certificadoAdd.getTipo() != null) {
            if (certificadoAdd.getValor() != null) {
                if (certificadoAdd.getValor().doubleValue() > 0) {
                    if (certificadoJaAdicionado(certificadoAdd.getTipo())) {
                        FacesMessageUtils.error("Já foi encontrado esse tipo de certificado na lista!");
                    } else {
                        certificados.add(certificadoAdd);
                        certificadoAdd = new TipoCertificadoAux();
                    }
                } else {
                    FacesMessageUtils.error("Valor deve ser maior que zero!");
                }
            } else {
                FacesMessageUtils.error("Valor é obrigatório!");
            }

        } else {
            FacesMessageUtils.error("Tipo do certificado é obrigatório!");
        }

    }

    public void removerCertificado(TipoCertificadoAux certificado) {
        certificados.remove(certificado);
    }

    private boolean certificadoJaAdicionado(TipoCertificado certificado) {
        for (TipoCertificadoAux certificado1 : certificados) {
            if (certificado1.getTipo().equals(certificado)) {
                return true;
            }
        }
        return false;
    }

    private ContratoFornecedor getContratosFornecedores() {
        ContratoFornecedor contratosFornecedor = null;
        if (getEntity().getDataInicio() != null && getEntity().getDataFinal() != null) {
            Restrictions restrictions = new Restrictions();
            restrictions.lessEqualsThan("dataInicio", getEntity().getDataInicio());
            restrictions.greaterEqualsThan("dataFinal", getEntity().getDataFinal());
            restrictions.add("ativo", true);
            contratosFornecedor = contraFornecedorBO.getDAO().unique(restrictions);
        }

        return contratosFornecedor;
    }

    public List<TipoCertificadoAux> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<TipoCertificadoAux> certificados) {
        this.certificados = certificados;
    }

    public TipoCertificadoAux getCertificadoAdd() {
        return certificadoAdd;
    }

    public void setCertificadoAdd(TipoCertificadoAux certificadoAdd) {
        this.certificadoAdd = certificadoAdd;
    }
}
