package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.NaturezaDeDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDeDespesaBO extends AbstractBusinessObject<NaturezaDeDespesa> {

    @EJB
    private NaturezaDeDespesaDAO naturezaDeDespesaDAO;

    @Override
    public NaturezaDeDespesaDAO getDAO() {
        return naturezaDeDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(NaturezaDeDespesa naturezaDeDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<NaturezaDeDespesa> listarPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("natureza.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("natureza.codigo", nome);
            } else {
                restrictions.like("natureza.nome", nome);
            }

        }

        return getDAO().getQueryBuilder().from(NaturezaDeDespesa.class, "natureza").add(restrictions).orderBy("natureza.nome").getResultList();
    }

    public List<NaturezaDeDespesa> listarPeloNome(List<NaturezaDeDespesa> naturezas, String nome) {
        Restrictions restrictions = new Restrictions();

        if (naturezas != null) {
            List<NaturezaDeDespesa> naturezasTemp = getDAO().getInitialized(naturezas);
            if (naturezasTemp.size() > 0) {
                restrictions.in("natureza", naturezasTemp);
            }else{
                return null;
            }
        } else {
            return null;
        }

        restrictions.add("natureza.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("natureza.codigo", nome);
            } else {
                restrictions.like("natureza.nome", nome);
            }

        }

        return getDAO().getQueryBuilder().select("natureza").from(NaturezaDeDespesa.class, "natureza").add(restrictions).orderBy("natureza.codigo").getResultList();
    }

}
