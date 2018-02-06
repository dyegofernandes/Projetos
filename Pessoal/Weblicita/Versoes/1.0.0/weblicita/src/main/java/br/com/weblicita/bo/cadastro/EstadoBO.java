package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.EstadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Estado;
import br.com.weblicita.modelo.cadastro.Pais;
import br.com.weblicita.util.Utils;
import com.xpert.core.exception.UniqueFieldException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.core.validation.UniqueFieldsValidation;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class EstadoBO extends AbstractBusinessObject<Estado> {

    @EJB
    private EstadoDAO estadoDAO;

    @Override
    public EstadoDAO getDAO() {
        return estadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
//        return new UniqueFields().add("pais", "nome").add("pais", "sigla");
        return null;
    }

//    @Override
//    public void validateUniqueFields(Estado estado) throws UniqueFieldException {
//        Restriction restriction = new Restriction("UPPER(nome)", estado.getNome().toUpperCase());
//        UniqueField uniqueField = new UniqueField(restriction).setMessage("Já existe estado cadastrado com esse nome: ".concat(estado.getNome().toUpperCase()));
//
//        UniqueFields uniqueFields = new UniqueFields();
//        uniqueFields.add(uniqueField);
//
//        Restriction restriction2 = new Restriction("UPPER(sigla)", estado.getSigla().toUpperCase());
//        UniqueField uniqueField2 = new UniqueField(restriction2).setMessage("Já existe estado cadastrado com essa sigla: ".concat(estado.getSigla().toUpperCase()));
//
//        UniqueField uniqueField3 = new UniqueField("pais").setMessage("Já existe estado cadastrado com esse nome/sigla para o país informado!");
//
//        uniqueFields.add(uniqueField3);
//        UniqueFieldsValidation.validateUniqueFields(uniqueFields, estado, getDAO());
//    }
    @Override
    public void validate(Estado estado) throws BusinessException {
        Restrictions restrictions = new Restrictions();
        restrictions.startGroup();
        restrictions.equals("UPPER(nome)", estado.getNome().toUpperCase());
        restrictions.add("pais", estado.getPais());
        restrictions.endGroup();
        restrictions.or();
        restrictions.startGroup();
        restrictions.equals("UPPER(sigla)", estado.getSigla().toUpperCase());
        restrictions.add("pais", estado.getPais()).endGroup();

        restrictions.or();

        restrictions.startGroup().add("codigo", estado.getCodigo()).endGroup();

        Estado estadoTemp = (Estado) getDAO().getQueryBuilder().from(Estado.class).add(restrictions).getSingleResult();

        if (estadoTemp != null) {
            throw new BusinessException("Já existe um Estado cadastrado para o País informado com esse nome, sigla ou código!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Estado> estadoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("nome", nome);
        }

        return getDAO().list(restrictions, "nome");
    }

}
