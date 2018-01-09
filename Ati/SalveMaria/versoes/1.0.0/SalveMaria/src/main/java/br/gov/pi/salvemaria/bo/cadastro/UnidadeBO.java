package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.UnidadeDAO;
import br.gov.pi.salvemaria.modelo.cadastro.CidadeRegiao;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeBO extends AbstractBusinessObject<Unidade> {

    @EJB
    private UnidadeDAO unidadeDAO;

    @EJB
    private CidadeRegiaoBO regiaoBO;

    @Override
    public UnidadeDAO getDAO() {
        return unidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome", "sigla", "regiao");
    }

    @Override
    public void validate(Unidade unidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Unidade unidadePelaRegiao(CidadeRegiao regiao) {

        if (regiao == null) {
            return null;
        }
        CidadeRegiao regiaoTemp = getDAO().getInitialized(regiao);

        if (regiaoTemp.getNome().toUpperCase().equals("LESTE")) {
            regiaoTemp = regiaoBO.regiaoPeloNomeECidade("CENTRO", regiaoTemp.getCidade());
        }
        Unidade unidade = new Unidade();

        unidade = unidadeDAO.unique("regiao", regiaoTemp);

        return unidade;
    }

}
