package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.TabelaInssDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.util.Calendar;
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
public class TabelaInssBO extends AbstractBusinessObject<TabelaInss> {
    
    @EJB
    private TabelaInssDAO tabelaInssDAO;
    
    @Override
    public TabelaInssDAO getDAO() {
        return tabelaInssDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("anoDeVingencia");
    }
    
    @Override
    public void validate(TabelaInss tabelaInss) throws BusinessException {
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
    public TabelaInss getTabelaAtual() {
        Calendar cal = Calendar.getInstance();

        int ano = cal.get(Calendar.YEAR);

        TabelaInss tabela = getDAO().unique("anoDeVingencia", ano);

        if (tabela == null) {
            tabela = (TabelaInss) getDAO().getQueryBuilder().from(TabelaInss.class).setMaxResults(1).orderBy("anoDeVingencia DESC").getSingleResult();
        }

        return tabela;
    }  
    
}
