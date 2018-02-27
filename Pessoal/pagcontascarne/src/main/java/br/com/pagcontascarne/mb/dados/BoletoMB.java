package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.BoletoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Boleto;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.util.SessaoUtils;
import br.com.pagcontascarne.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletoMB extends AbstractBaseBean<Boleto> implements Serializable {

    @EJB
    private BoletoBO boletoBO;

    private List<Boleto> boletos;

    Usuario usuarioAtual = SessaoUtils.getUser();

    private boolean pular;

    private Date dataMinima = new Date();

    private Date dataMaxima;

    @Override
    public BoletoBO getBO() {
        return boletoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        }
    }

    public boolean isPular() {
        return pular;
    }

    public void setPular(boolean pular) {
        this.pular = pular;
    }

    public Date getDataMinima() {
        return dataMinima;
    }

    public void setDataMinima(Date dataMinima) {
        this.dataMinima = dataMinima;
    }

    public Date getDataMaxima() {
        return dataMaxima;
    }

    public void setDataMaxima(Date dataMaxima) {
        this.dataMaxima = dataMaxima;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public String onFlowProcess(FlowEvent event) {
        if (pular) {
            pular = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public void mudarProduto() {
        if (getEntity().getProduto() != null) {
            Produto produto = getDAO().getInitialized(getEntity().getProduto());
            calcularValores(produto.getValor_base());
        } else {
            FacesMessageUtils.error("Produto é obrigatório!");
        }
    }

    public void calcularValores(BigDecimal valor) {
        if (valor != null) {
            if (getEntity().getConvenio() != null) {
                Convenio convenio = getDAO().getInitialized(getEntity().getConvenio());

                BigDecimal desconto = Utils.calcularPorcentagem(convenio.getDesconto(), valor);
                BigDecimal juros = Utils.calcularPorcentagem(convenio.getJuros(), valor);
                BigDecimal multa = Utils.calcularPorcentagem(convenio.getMulta(), valor);

                getEntity().setVl_nominal(valor);
                getEntity().setVl_desconto(desconto);
                getEntity().setVl_juros(juros);
                getEntity().setVl_multa(multa);

            } else {
                getEntity().setVl_nominal(BigDecimal.ZERO);
                getEntity().setVl_desconto(BigDecimal.ZERO);
                getEntity().setVl_juros(BigDecimal.ZERO);
                getEntity().setVl_multa(BigDecimal.ZERO);
            }
        } else {
            FacesMessageUtils.error("O valor deve ser informado!");
        }
    }

    public void gerarBoletos() {
        if (getEntity().getConvenio() != null) {
            if (getEntity().getCliente() != null) {
                if (getEntity().getProduto() != null) {
                    if (getEntity().getVl_nominal() != null) {
                        if (getEntity().getQtd_total_parcela() != null) {
                            if (getEntity().getDt_vencimento() != null) {
                                if (getEntity().getQtd_total_parcela() > 0) {
                                    Convenio convenio = getDAO().getInitialized(getEntity().getConvenio());
                                    BigDecimal valorParcela = getEntity().getVl_nominal().
                                            divide(new BigDecimal(getEntity().getQtd_total_parcela()), 2, RoundingMode.DOWN);
                                    Calendar vencimento = Calendar.getInstance();

                                    BigDecimal desconto = Utils.calcularPorcentagem(convenio.getDesconto(), valorParcela);
                                    BigDecimal juros = Utils.calcularPorcentagem(convenio.getJuros(), valorParcela);
                                    BigDecimal multa = Utils.calcularPorcentagem(convenio.getMulta(), valorParcela);
                                    for (int i = 0; i < getEntity().getQtd_total_parcela(); i++) {

                                        Boleto boletoTemp = new Boleto();
                                        boletoTemp.setConvenio(getEntity().getConvenio());
                                        boletoTemp.setProduto(getEntity().getProduto());
                                        boletoTemp.setCliente(getEntity().getCliente());
                                        boletoTemp.setDt_criacao(new Date());

                                        boletoTemp.setInstrucao_exclusiva(getEntity().getInstrucao_exclusiva());

                                        boletoTemp.setBanco(convenio.getBanco());

                                        vencimento.setTime(getEntity().getDt_vencimento());
                                        vencimento.add(Calendar.MONTH, i);
                                        boletoTemp.setDt_vencimento(vencimento.getTime());

                                        boletoTemp.setNr_parcela(i + 1);
                                        boletoTemp.setQtd_total_parcela(getEntity().getQtd_total_parcela());
                                        boletoTemp.setVl_nominal(valorParcela);
                                        boletoTemp.setVl_desconto(desconto);
                                        boletoTemp.setVl_juros(juros);
                                        boletoTemp.setVl_multa(multa);

                                        boletoTemp.setReferentea("Referente à parcela " + boletoTemp.getNr_parcela() + "/" + boletoTemp.getQtd_total_parcela());

                                        boletos.add(boletoTemp);
                                    }
                                } else {
                                    FacesMessageUtils.error("Quantidade Total de Parcelas deve ser maior que Zero!");
                                }
                            }
                        } else {
                            FacesMessageUtils.error("Quantidade Total de Parcelas é obrigatória!");
                        }
                    } else {
                        FacesMessageUtils.error("Valor do Boleto obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Produto/Serviço obrigatório!");
                }
            } else {
                FacesMessageUtils.error("Cliente é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Convênio é obrigatório!");
        }
    }
}
