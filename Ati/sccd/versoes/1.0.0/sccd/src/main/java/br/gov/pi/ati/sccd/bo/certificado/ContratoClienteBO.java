package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.impl.ContratoClienteDAO;
import br.gov.pi.ati.sccd.dao.certificado.impl.ContratoFornecedorDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContratoClienteBO extends AbstractBusinessObject<ContratoCliente> {

    @EJB
    private ContratoClienteDAO contratoClienteDAO;

    @EJB
    private ContratoFornecedorDAO contraFornecedorDAO;

    @Override
    public ContratoClienteDAO getDAO() {
        return contratoClienteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();

        UniqueField unique = new UniqueField(Restriction.equals("ativo", true), "cliente").setMessage("Já existe um contrato ativo para esse Cliente!");

        uniqueFields.add(unique);

        uniqueFields.add("numeroContrato");

        return uniqueFields;
    }

    @Override
    public void validate(ContratoCliente contratoCliente) throws BusinessException {
        List<TipoCertificadoAux> certificados = getDAO().getInitialized(contratoCliente.getCertificados());

        if (contratoCliente.getDataInicio().after(contratoCliente.getDataFinal())) {
            throw new BusinessException("Data inicial deve ser menor que a Data final do Contrato!");
        }

        if (certificados.size() < 1) {
            throw new BusinessException("Um ou mais Certificados são obrigatórios!");
        }

        if (contratoCliente.getContratoFornecedor() == null) {
            throw new BusinessException("Não foi encontrado contrato de fornecedor vingente para as datas informadas!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
