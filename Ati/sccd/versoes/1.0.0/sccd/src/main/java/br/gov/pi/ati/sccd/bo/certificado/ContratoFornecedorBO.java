package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.impl.ContratoFornecedorDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContratoFornecedorBO extends AbstractBusinessObject<ContratoFornecedor> {

    @EJB
    private ContratoFornecedorDAO contratoFornecedorDAO;

    @Override
    public ContratoFornecedorDAO getDAO() {
        return contratoFornecedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {

        UniqueFields uniqueFields = new UniqueFields();

        UniqueField unique = new UniqueField(Restriction.equals("ativo", true), "fornecedor").setMessage("Já existe um contrato ativo para esse Fornecedor!");

        uniqueFields.add(unique);

        uniqueFields.add("numeroContrato");

        return uniqueFields;
    }

    @Override
    public void validate(ContratoFornecedor contratoFornecedor) throws BusinessException {
        List<TipoCertificadoAux> certificados = getDAO().getInitialized(contratoFornecedor.getCertificados());

        if (contratoFornecedor.getDataInicio().after(contratoFornecedor.getDataFinal())) {
            throw new BusinessException("Data inicial deve ser menor que a Data final do Contrato!");
        }

        if (certificados.size() < 1) {
            throw new BusinessException("Certificado é obrigatório!");
        }

    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<ContratoFornecedor> contratosAtivoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("fornecedor.nome", nome);
        }

        restrictions.add("contrato.ativo", true);

        return getDAO().getQueryBuilder().from(ContratoFornecedor.class, "contrato").leftJoinFetch("contrato.fornecedor", "fornecedor")
                .add(restrictions).orderBy("fornecedor.nome").getResultList();
    }
}
