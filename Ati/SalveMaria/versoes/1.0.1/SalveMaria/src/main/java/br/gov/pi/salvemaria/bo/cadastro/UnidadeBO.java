package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.UnidadeDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.modelo.enums.TipoUnidade;
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
    private CircunscricaoBO circuPorCidadeBO;

    @EJB
    private Circunscricao_BairroBO circuPorBairroBO;

    @EJB
    private BairroBO bairroBO;

    @Override
    public UnidadeDAO getDAO() {
        return unidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome", "sigla");
    }

    @Override
    public void validate(Unidade unidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Unidade unidadePeloBairro(Bairro bairro, TipoDenuncia tipo) {
        Restrictions restrictions = new Restrictions();

        if (bairro == null) {
            return null;
        }

        Unidade unidade = null;

        Cidade cidade = unidadeDAO.getInitialized(bairro.getCidade());

        if (tipo == TipoDenuncia.DENUNCIA) {
            restrictions.add("tipo", TipoUnidade.DRPC);
        } else {
            restrictions.add("tipo", TipoUnidade.BPM);
        }
        restrictions.add("circunscricao", cidade.getCircunscricao());
        
        unidade = unidadeDAO.unique(restrictions);

        return unidade;
    }
}
