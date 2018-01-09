package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.AliquotaInssDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;

/**
 *
 * @author Juniel
 */
@Stateless
public class AliquotaInssBO extends AbstractBusinessObject<AliquotaInss> {
    
    @EJB
    private AliquotaInssDAO aliquotaInssDAO;
    
    @Override
    public AliquotaInssDAO getDAO() {
        return aliquotaInssDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }
    
    @Override
    public void validate(AliquotaInss aliquotaInss) throws BusinessException {
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
    public AliquotaInss pegarAliquota(TabelaInss tabela, BigDecimal valor) {
        
        if (tabela == null || valor == null) {
            return null;
        }
        
        Restrictions restrictions = new Restrictions();
        
        restrictions.add("tabelaInss", tabela);
        
        restrictions.lessEqualsThan("salarioInicial", valor);
        
        restrictions.greaterEqualsThan("salarioFinal", valor);
        
        return getDAO().unique(restrictions);
    }
    
    public BigDecimal pegarMaiorPorcentagem(TabelaInss tabela) {
        
        if (tabela == null) {
            return null;
        }
        
        BigDecimal maiorAliquota = BigDecimal.ZERO;
        
        Restrictions restrictions = new Restrictions();
        
        restrictions.add("tabelaInss", tabela);
        
        List<AliquotaInss> listaDeInss = getDAO().list(restrictions);
        
        for (AliquotaInss inss : listaDeInss) {
            if (inss.getValor().compareTo(maiorAliquota) > 0) {
                maiorAliquota = inss.getValor();
            }
            
        }
        
        return maiorAliquota;
    }
    
    public List<AliquotaInss> listarAliquotasPelaTabela(TabelaInss tabela) {
        Restrictions restrictions = new Restrictions();
        
        restrictions.add("tabelaInss", tabela);
        
        return getDAO().list(restrictions);
    }
}
