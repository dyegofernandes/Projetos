package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.BairroDAO;
import br.gov.pi.salvemaria.dao.cadastro.CidadeRegiaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.CidadeRegiao;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroBO extends AbstractBusinessObject<Bairro> {

    @EJB
    private BairroDAO bairroDAO;

    @EJB
    private CidadeRegiaoDAO regiaoDAO;

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
        restrictions.add("bairro.nome", nome.toUpperCase());
        restrictions.add("cidade", cidade);

        return (Bairro) bairroDAO.getQueryBuilder().select("bairro").from(Bairro.class, "bairro").innerJoinFetch("bairro.regiao", "regiao")
                .innerJoinFetch("regiao.cidade", "cidade").add(restrictions).getSingleResult();
    }

}
