package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.BairroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroBO extends AbstractBusinessObject<Bairro> {

    @EJB
    private BairroDAO bairroDAO;

    @Override
    public BairroDAO getDAO() {
        return bairroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Bairro bairro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public Bairro bairroPeloNomeECidade(String nome, Cidade cidade) {
        if (cidade == null || nome == null || nome.equals("")) {
            return null;
        }
        Restrictions restrictions = new Restrictions();
        restrictions.add("bairro.nome", nome);
        restrictions.add("cidade", cidade);

        return (Bairro) bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .innerJoinFetch("bairro.cidade", "cidade").add(restrictions).getSingleResult();
    }

    public List<Bairro> bairrosPelaCidade(Cidade cidade) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("cidade", cidade);

        if (cidade == null) {
            return null;
        }

        return bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .innerJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("bairro.nome").getResultList();
    }

    public List<Bairro> bairrosSemCircunscricao(Cidade cidade) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("cidade", cidade);
        restrictions.isNull("bairro.circunscricao_Bairro");

        if (cidade == null) {
            return null;
        }

        return bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .innerJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("cidade, bairro.nome").getResultList();
    }

    public List<Bairro> bairrosPelaCircunscricao(Circunscricao_Bairro circus) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("bairro.circunscricao_Bairro", circus);

        if (circus == null) {
            return null;
        }

        return bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .innerJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("cidade, bairro.nome").getResultList();
    }

    public Bairro bairrosPrincipalPela(Cidade cidade) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("cidade", cidade);
        restrictions.add("principal", true);

        if (cidade == null) {
            return null;
        }

        return (Bairro) bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .innerJoinFetch("bairro.cidade", "cidade").add(restrictions).getSingleResult();
    }

    public List<Bairro> listarTodos() {

        return bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .innerJoinFetch("bairro.cidade", "cidade").orderBy("cidade, bairro.nome").getResultList();
    }
}
