package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.AgendamentoDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.Contato;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class AgendamentoBO extends AbstractBusinessObject<Agendamento> {

    @EJB
    private AgendamentoDAO agendamentoDAO;

    @Override
    public AgendamentoDAO getDAO() {
        return agendamentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() { //Verificar se o mesmo cpf tenta reservar varios agendamento no mesmo dia
        return new UniqueFields().add("dataInicial").add("dataFinal");
    }

    @Override
    public void validate(Agendamento agendamento) throws BusinessException {
        Cliente cliente = getDAO().getInitialized(agendamento.getCliente());

        List<ArquivoAgendamento> arquivos = getDAO().getInitialized(agendamento.getArquivos());

        List<Contato> contatos = getDAO().getInitialized(agendamento.getContatos());

        if (contatos.size() < 1) {
            throw new BusinessException("Informe um ou mais telefones para contatos!");
        }

        if (arquivos.size() < 1) {
            throw new BusinessException("Arquivos obrigatórios não anexados!");
        } else {
            if (cliente.isIsento()) {
                for (ArquivoAgendamento arquivo : arquivos) {
                    
                }
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Agendamento> agendamentosPelaData(Date dataInicial, Date dataFinal) {
        Restrictions restrictions = new Restrictions();

        if (dataInicial != null) {
            restrictions.greaterEqualsThan("agendamento.dataInicial", dataInicial, TemporalType.DATE);
        }

        if (dataFinal != null) {
            restrictions.lessEqualsThan("agendamento.dataFinal", dataFinal, TemporalType.DATE);
        }
        
        restrictions.startGroup().add("agendamento.situacao", SituacaoAgendamento.CONFIRMADO).or().add("agendamento.situacao", 
                SituacaoAgendamento.NAO_CONFIRMADO).endGroup();

        return getDAO().getQueryBuilder().select("agendamento").from(Agendamento.class, "agendamento").add(restrictions).getResultList();
    }

}
