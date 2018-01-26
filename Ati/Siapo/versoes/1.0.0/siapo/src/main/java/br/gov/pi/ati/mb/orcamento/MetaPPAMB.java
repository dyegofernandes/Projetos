package br.gov.pi.ati.mb.orcamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaPPABO;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.modelo.orcamento.Ldo;
import br.gov.pi.ati.modelo.orcamento.MetaPPA;
import br.gov.pi.ati.modelo.orcamento.TerritorioPPA;
import com.xpert.faces.utils.FacesMessageUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MetaPPAMB extends AbstractBaseBean<MetaPPA> implements Serializable {

    private List<Ldo> ldos;

    private List<TerritorioPPA> territorios;

    private Integer anoLDO;

    private BigDecimal valorLDO;

    private Territorio territorio;

    private BigDecimal valorTerritorio;

    @EJB
    private MetaPPABO metaPPABO;

    @Override
    public MetaPPABO getBO() {
        return metaPPABO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        ldos = new ArrayList<Ldo>();
        territorios = new ArrayList<TerritorioPPA>();

        if (getEntity().getId() != null) {
            ldos = getDAO().getInitialized(getEntity().getLdos());
            territorios = getDAO().getInitialized(getEntity().getTerritorios());
        }
    }

    @Override
    public void save() {
        getEntity().setLdos(ldos);
        getEntity().setTerritorios(territorios);
        super.save();
    }
    
    

    public void addLdo() {
        if (getEntity().getValorMeta() != null) {
            if (getEntity().getValorMeta().compareTo(BigDecimal.ZERO) > 0) {

                if (anoLDO != null && valorLDO != null) {
                    if (somaValorLDOs(valorLDO)) {
                        FacesMessageUtils.error("Somatório dos LDO não pode ser maior que o valor da meta PPA!");
                    } else {
                        Ldo ldo = new Ldo();
                        ldo.setAno(anoLDO);
                        ldo.setValor(valorLDO);
                        ldos.add(ldo);
                        anoLDO = null;
                        valorLDO = null;
                    }
                } else {
                    FacesMessageUtils.error("O ano e o valor do LDO são obrigatórios!");

                }

            } else {
                FacesMessageUtils.error("Valor da Meta do PPA deve ser maior que Zero!");
            }
        } else {
            FacesMessageUtils.error("Informe o valor da meta PPA!");
        }
    }

    public void removerLdo(Ldo ldo) {
        ldos.remove(ldo);
    }

    public void addTerritorio() {
        if (getEntity().getValorMeta() != null) {
            if (getEntity().getValorMeta().compareTo(BigDecimal.ZERO) > 0) {
                if (territorio != null && valorTerritorio != null) {
                    if (somaValorTerritorios(valorTerritorio)) {
                        FacesMessageUtils.error("Somatório dos LDO não pode ser maior que o valor da meta PPA!");
                    } else {
                        TerritorioPPA territorioTemp = new TerritorioPPA();
                        territorioTemp.setTerritorio(territorio);
                        territorioTemp.setValor(valorTerritorio);
                        territorios.add(territorioTemp);
                        territorio = null;
                        valorTerritorio = null;
                    }
                } else {
                    FacesMessageUtils.error("Território e valor do mesmo são obrigatórios!");
                }

            } else {
                FacesMessageUtils.error("Valor da Meta do PPA deve ser maior que Zero!");
            }
        } else {
            FacesMessageUtils.error("Informe o valor da meta PPA!");
        }
    }

    public void removerTerritorio(TerritorioPPA territorio) {
        territorios.remove(territorio);
    }

    private boolean somaValorTerritorios(BigDecimal valor) {
        BigDecimal soma = BigDecimal.ZERO;

        for (TerritorioPPA territorioTemp : territorios) {
            soma = soma.add(territorioTemp.getValor());
        }

        soma = soma.add(valor);

        if (soma.compareTo(getEntity().getValorMeta()) > 0) {
            return true;
        }

        return false;

    }

    private boolean somaValorLDOs(BigDecimal valor) {
        BigDecimal soma = BigDecimal.ZERO;
        for (Ldo ldo : ldos) {
            soma = soma.add(ldo.getValor());
        }

        soma = soma.add(valor);

        if (soma.compareTo(getEntity().getValorMeta()) > 0) {
            return true;
        }
        return false;
    }

    public List<Ldo> getLdos() {
        return ldos;
    }

    public void setLdos(List<Ldo> ldos) {
        this.ldos = ldos;
    }

    public List<TerritorioPPA> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<TerritorioPPA> territorios) {
        this.territorios = territorios;
    }

    public Integer getAnoLDO() {
        return anoLDO;
    }

    public void setAnoLDO(Integer anoLDO) {
        this.anoLDO = anoLDO;
    }

    public BigDecimal getValorLDO() {
        return valorLDO;
    }

    public void setValorLDO(BigDecimal valorLDO) {
        this.valorLDO = valorLDO;
    }

    public Territorio getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Territorio territorio) {
        this.territorio = territorio;
    }

    public BigDecimal getValorTerritorio() {
        return valorTerritorio;
    }

    public void setValorTerritorio(BigDecimal valorTerritorio) {
        this.valorTerritorio = valorTerritorio;
    }
    
    
}
