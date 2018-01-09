package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.CadastroPessoalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.CadastroPessoal;

/**
 *
 * @author Juniel
 */
@Stateless
public class CadastroPessoalBO extends AbstractBusinessObject<CadastroPessoal> {

    @EJB
    private CadastroPessoalDAO cadastroPessoalDAO;

    @Override
    public CadastroPessoalDAO getDAO() {
        return cadastroPessoalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf").add("carteiraDeTrabalho.pisPasepNit");
    }

    @Override
    public void validate(CadastroPessoal cadastroPessoal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void save(CadastroPessoal object) throws BusinessException {
        validate(object);
        validateUniqueFields(object);
        //Colocado o merge pois estava bugando com o save por causa dos cascade 
        object = getDAO().merge(object, true);
    }
    
    

    public CadastroPessoal listarCadastro(String cpf) {
        CadastroPessoal cadastro = new CadastroPessoal();
        Restrictions restrictions = new Restrictions();

        restrictions.add("cpf", (cpf.replace(".", "").replace("-", "")));

        cadastro = (CadastroPessoal) cadastroPessoalDAO.getQueryBuilder().select("cadastro").from(CadastroPessoal.class, "cadastro").leftJoinFetch("cadastro.carteiraDeTrabalho", "carteira")
                .leftJoinFetch("cadastro.rg", "rg").leftJoinFetch("cadastro.endereco", "endereco").leftJoinFetch("cadastro.naturalidade", "naturalidade")
                .leftJoinFetch("cadastro.titulo", "titulo").leftJoinFetch("cadastro.grauDeInstrucao", "grauDeInstrucao").leftJoinFetch("cadastro.formacaoProfissional", "formacaoProfissional")
                .add(restrictions).getSingleResult();
        return cadastro;

    }

}
