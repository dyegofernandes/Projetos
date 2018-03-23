package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.ContratoFornecedorBO;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContratoFornecedorMB extends AbstractBaseBean<ContratoFornecedor> implements Serializable {

    @EJB
    private ContratoFornecedorBO contratoFornecedorBO;

    private List<TipoCertificadoAux> certificados;

    private TipoCertificadoAux certificadoAdd;

    @Override
    public ContratoFornecedorBO getBO() {
        return contratoFornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        certificadoAdd = new TipoCertificadoAux();
        certificados = new ArrayList<TipoCertificadoAux>();

        if (getEntity().getId() != null) {
            certificados = getDAO().getInitialized(getEntity().getCertificados());
        }
    }

    @Override
    public void save() {
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
            if (certificadoAdd.getQuantidade() != null) {
                if (certificadoAdd.getQuantidade().doubleValue() > 0) {
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
                    FacesMessageUtils.error("Quantidade deve ser maior que zero!");
                }
            } else {
                FacesMessageUtils.error("Quantidade é obrigatória!");
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

    public List<ContratoFornecedor> contratosAtivos() {
        return getBO().contratosAtivoPeloNome(null);
    }

    public List<ContratoFornecedor> autocomplete(String nome) {
        return getBO().contratosAtivoPeloNome(nome);
    }

}
