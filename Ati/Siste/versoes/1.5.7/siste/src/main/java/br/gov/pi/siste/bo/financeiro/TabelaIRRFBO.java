package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.TabelaIRRFDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;

/**
 *
 * @author Juniel
 */
@Stateless
public class TabelaIRRFBO extends AbstractBusinessObject<TabelaIRRF> {

    @EJB
    private TabelaIRRFDAO tabelaIRRFDAO;

    @Override
    public TabelaIRRFDAO getDAO() {
        return tabelaIRRFDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("anoDeVingencia");
    }

    @Override
    public void validate(TabelaIRRF tabelaIRRF) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public TabelaIRRF getTabelaAtual() {
        Calendar cal = Calendar.getInstance();

        int ano = cal.get(Calendar.YEAR);

        TabelaIRRF tabela = getDAO().unique("anoDeVingencia", ano);

        if (tabela == null) {
            tabela = (TabelaIRRF) getDAO().getQueryBuilder().from(TabelaIRRF.class).setMaxResults(1).orderBy("anoDeVingencia DESC").getSingleResult();
        }

        return tabela;
    }  

}
