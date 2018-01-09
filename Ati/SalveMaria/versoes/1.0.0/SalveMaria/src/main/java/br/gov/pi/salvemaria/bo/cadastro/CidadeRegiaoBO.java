package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.CidadeRegiaoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.CidadeRegiao;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeRegiaoBO extends AbstractBusinessObject<CidadeRegiao> {

    @EJB
    private CidadeRegiaoDAO cidadeRegiaoDAO;
    
    @Override
    public CidadeRegiaoDAO getDAO() {
        return cidadeRegiaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CidadeRegiao cidadeRegiao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public CidadeRegiao regiaoPeloNomeECidade(String nome, Cidade cidade){
        Restrictions restrictions = new Restrictions();
        restrictions.add("regiao.nome", nome.toUpperCase());
        restrictions.add("cidade", cidade);
        
        return (CidadeRegiao) cidadeRegiaoDAO.getQueryBuilder().select("regiao").from(CidadeRegiao.class, "regiao")
                .innerJoinFetch("regiao.cidade", "cidade").add(restrictions).getSingleResult();
    }

}
