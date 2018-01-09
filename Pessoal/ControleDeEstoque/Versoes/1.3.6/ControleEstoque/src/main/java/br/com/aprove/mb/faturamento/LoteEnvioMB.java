package br.com.aprove.mb.faturamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.faturamento.LoteEnvioBO;
import br.com.aprove.bo.faturamento.NotaFiscalBO;
import br.com.aprove.modelo.cadastro.enums.Ambiente;
import br.com.aprove.modelo.faturamento.LoteEnvio;
import br.com.aprove.modelo.faturamento.NotaFiscal;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LoteEnvioMB extends AbstractBaseBean<LoteEnvio> implements Serializable {

    @EJB
    private LoteEnvioBO loteEnvioBO;

    @EJB
    private NotaFiscalBO notaBO;

    private NotaFiscal notaAdd;

    private List<NotaFiscal> notasAutocomplete;

    private List<NotaFiscal> notas;

    private List<NotaFiscal> notasDeletadas;

    @Override
    public LoteEnvioBO getBO() {
        return loteEnvioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        notasDeletadas = new ArrayList<NotaFiscal>();
        notasAutocomplete = notaBO.notasAbertas();
        if (getEntity().getId() != null) {
            notas = notaBO.notasPorLote(getEntity());
        } else {
            notas = new ArrayList<NotaFiscal>();
        }
    }

    @Override
    public void save() {
        getEntity().setAmbiente(Ambiente.PRODUCAO);
        getEntity().setVersaoAplicacao("3.10");
        if (notas.size() > 0) {
            super.save();
            for (NotaFiscal notasAutocomplete1 : notas) {
                notaBO.getDAO().saveOrMerge(notasAutocomplete1, true);
            }
            for (NotaFiscal notasAutocomplete1 : notasDeletadas) {
                try {
                    notaBO.remove(notasAutocomplete1);
                } catch (DeleteException ex) {
                    Logger.getLogger(LoteEnvioMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesMessageUtils.error("Lote de Envio deve conter uma ou mais notas!");
        }

    }

    public void addNota() {
        if (notaAdd != null) {
            if (!verificarNotaAdicionada(notaAdd)) {
                FacesMessageUtils.error("Nota Fiscal já adicionada!");
            } else {
                notaAdd.setLoteEnvio(getEntity());
                notas.add(notaAdd);
            }

        } else {
            FacesMessageUtils.error("Nota Fiscal é obrigatória!");
        }
    }

    public void removerNota(NotaFiscal nota) {
        if (nota.getId() != null) {
            notasDeletadas.add(nota);
        }

        notas.remove(nota);
    }

    public void enviarLote() {
        FacesMessageUtils.error("Lote Enviado com Sucesso!");
    }

    public NotaFiscal getNotaAdd() {
        return notaAdd;
    }

    public void setNotaAdd(NotaFiscal notaAdd) {
        this.notaAdd = notaAdd;
    }

    public List<NotaFiscal> getNotasAutocomplete() {
        return notasAutocomplete;
    }

    public void setNotasAutocomplete(List<NotaFiscal> notasAutocomplete) {
        this.notasAutocomplete = notasAutocomplete;
    }

    public List<NotaFiscal> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaFiscal> notas) {
        this.notas = notas;
    }

    private boolean verificarNotaAdicionada(NotaFiscal nota) {
        for (NotaFiscal notasAutocomplete1 : notas) {
            if (nota.equals(notasAutocomplete1)) {
                return false;
            }
        }
        return true;
    }

}
