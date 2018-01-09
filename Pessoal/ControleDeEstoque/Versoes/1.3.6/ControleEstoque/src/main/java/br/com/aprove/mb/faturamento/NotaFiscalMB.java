package br.com.aprove.mb.faturamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.faturamento.NotaFiscalBO;
import br.com.aprove.bo.faturamento.VendaBO;
import br.com.aprove.dao.faturamento.NotaFiscalDAO;
import br.com.aprove.modelo.faturamento.NotaFiscal;
import br.com.aprove.modelo.faturamento.Venda;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class NotaFiscalMB extends AbstractBaseBean<NotaFiscal> implements Serializable {

    @EJB
    private NotaFiscalBO notaFiscalBO;

    @EJB
    NotaFiscalDAO notaDAO;

    @EJB
    private VendaBO vendaBO;

    NotaFiscal notaConfirmada;

    List<Venda> vendasFechadas;

    public NotaFiscal getNotaConfirmada() {
        return notaConfirmada;
    }

    public void setNotaConfirmada(NotaFiscal notaConfirmada) {
        this.notaConfirmada = notaConfirmada;
    }

    @Override
    public NotaFiscalBO getBO() {
        return notaFiscalBO;
    }

    @Override
    public void init() {
        notaConfirmada = new NotaFiscal();
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("view/faturamento/notaFiscal/listNotaFiscal.jsf");
        } else {
            setEntity(new NotaFiscal());
        }
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarArquivoTextNfe(NotaFiscal nota) throws IOException, InterruptedException {
        Venda venda = notaDAO.getInitialized(nota.getVenda());
        String texto = vendaBO.gerarTxtNota(venda, nota.getNumeroNota().toString(), nota.getNumChaveDeAcesso());
        Thread.sleep(5000);
        FacesUtils.download(texto.getBytes(), "text/plain", "NotaFiscalArquivoTexto" + nota.getId() + ".txt");
    }

    private String gerarChaveAcesso() {
        if (getEntity().getVenda() != null) {
            return notaFiscalBO.gerarChave(getEntity());
        }
        return null;
    }

    private Long pegaUltimoNumNota() {
        if (getEntity().getVenda() != null) {
            return notaFiscalBO.pegarUltimoNumNota(getEntity().getVenda());
        }
        return null;
    }

    public void carregarValores() {
        getEntity().setNumeroNota(pegaUltimoNumNota());
        getEntity().setNumChaveDeAcesso(gerarChaveAcesso());
    }

    public void setarChaveAcesso() {
        getEntity().setNumChaveDeAcesso(gerarChaveAcesso());
    }

    public void gerarNFe(NotaFiscal nota) {
        notaFiscalBO.visualizarNFe(nota);
    }

    public void confirmarNota() {
        notaFiscalBO.confirmarNFe(notaConfirmada);
        FacesMessageUtils.info("Nota Fiscal Confirmada com sucesso!");

    }

    public void cancelarNota(NotaFiscal nota) {
        notaFiscalBO.cancelarNFe(nota);
        FacesMessageUtils.info("Nota Fiscal Cancelada com sucesso!");
    }

    public void carregaVendasPorLoja() {
        vendasFechadas = new ArrayList<Venda>();
        String queryString = "SELECT * FROM venda where ativo = true and id not in (SELECT venda_id FROM notafiscal) ORDER BY id";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            Venda venda = new Venda();

            if (tupla[0] != null) {
                venda = vendaBO.getDAO().unique("id", ((BigInteger) tupla[0]).longValue());
                vendasFechadas.add(venda);
            }

        }

    }

    public List<Venda> getVendasFechadas() {
        return vendasFechadas;
    }

    public void setVendasFechadas(List<Venda> vendasFechadas) {
        this.vendasFechadas = vendasFechadas;
    }

}
