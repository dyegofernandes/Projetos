package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.CidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.Estado;
import br.gov.pi.salvemaria.modelo.vos.Filtros;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeBO extends AbstractBusinessObject<Cidade> {

    @EJB
    private CidadeDAO cidadeDAO;

    @Override
    public CidadeDAO getDAO() {
        return cidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome", "estado");
    }

    @Override
    public void validate(Cidade cidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Cidade cidadePeloNomeEestado(String nome, Estado estado) {
        if (nome == null || nome.equals("") || estado == null) {
            return null;
        }
        Restrictions restrictions = new Restrictions();
        restrictions.add("estado", estado);
        restrictions.add("nome", nome);
        return (Cidade) cidadeDAO.unique(restrictions);
    }

    public List<Cidade> cidadeSemCircunscricao() {
        Restrictions restrictions = new Restrictions();
        restrictions.isNull("circunscricao");
        return cidadeDAO.list(restrictions, "nome");
    }

    public List<Cidade> cidadePelaCircunscricao(Circunscricao circus) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("circunscricao", circus);
        return cidadeDAO.list(restrictions, "nome");
    }

    public List<Cidade> listar(Filtros filtros) {
        Restrictions restrictions = new Restrictions();

        return cidadeDAO.getQueryBuilder().from(Cidade.class, "cidade").leftJoinFetch("cidade.estado", "estado")
                .add(restrictions).orderBy("estado, cidade.nome").getResultList();
    }
}
