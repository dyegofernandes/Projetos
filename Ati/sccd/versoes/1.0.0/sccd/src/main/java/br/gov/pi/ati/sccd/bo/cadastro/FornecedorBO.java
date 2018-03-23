package br.gov.pi.ati.sccd.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.cadastro.FornecedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.cadastro.Fornecedor;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;

/**
 *
 * @author Juniel
 */
@Stateless
public class FornecedorBO extends AbstractBusinessObject<Fornecedor> {

    @EJB
    private FornecedorDAO fornecedorDAO;

    @Override
    public FornecedorDAO getDAO() {
        return fornecedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();

        UniqueField uniqueCNPJAtivo = new UniqueField(Restriction.equals("ativo", true), "cnpj").setMessage("Já existe um contrato ativo para esse CNPJ!");

        uniqueFields.add(uniqueCNPJAtivo);

        UniqueField uniqueNomeAtivo = new UniqueField(Restriction.equals("ativo", true), "nome").setMessage("Já existe um contrato ativo para esse Nome!");

        uniqueFields.add(uniqueNomeAtivo);

        return uniqueFields;
    }

    @Override
    public void validate(Fornecedor fornecedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<Fornecedor> fornecedoresAtivos(){
        return getDAO().list("ativo", true, "nome");
    }

}
