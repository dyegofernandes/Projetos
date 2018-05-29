package br.gov.pi.ati.sccd.bo.certificado;

import br.gov.pi.ati.sccd.bo.email.EmailBO;
import br.gov.pi.ati.sccd.bo.email.ModeloEmailBO;
import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.AgendamentoDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Contato;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ArquivoAgendamento;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.email.ModeloEmail;
import br.gov.pi.ati.sccd.modelo.email.TipoAssuntoEmail;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Stateless
public class AgendamentoBO extends AbstractBusinessObject<Agendamento> {
    
    @EJB
    private AgendamentoDAO agendamentoDAO;
    
    @EJB
    private EmailBO emailBO;
    
    @EJB
    private ModeloEmailBO modeloEmailBO;
    
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
        
        ItemPedido item = getDAO().getInitialized(agendamento.getItemPedido());
        
        TipoCertificado tipoCertificado = getDAO().getInitialized(item.getTipoCertificado());
        
        Restrictions restrictions = new Restrictions();
        
        restrictions.add("itemPedido.cpfCnpjTitular", item.getCpfCnpjTitular());
        
        restrictions.equals("dataInicial", agendamento.getDataInicial(), TemporalType.DATE);
        
        Agendamento agendamentoTemp = getDAO().unique(restrictions);
        
        if (agendamentoTemp != null && !agendamento.equals(agendamentoTemp)) {
            if (tipoCertificado.getTipoPessoa() == TipoPessoa.FISICA) {
                throw new BusinessException("Já foi encontrato agendamento para esse CPF no dia informado!");
            } else {
                throw new BusinessException("Já foi encontrato agendamento para esse CNPJ no dia informado!");
            }
            
        }

//        Cliente cliente = getDAO().getInitialized(agendamento.getCliente());
        List<ArquivoAgendamento> arquivos = getDAO().getInitialized(agendamento.getArquivos());
        
        if (arquivos.size() < 1) {
            throw new BusinessException("Arquivos obrigatórios não anexados!");
        }
        
        if (Utils.isNullOrEmpty(agendamento.getEmail()) && Utils.isNullOrEmpty(agendamento.getEmailInstitucional())) {
            throw new BusinessException("Deve ser informado um email pessoal ou um email institucional!");
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
    
    public void enviarEmail(TipoAssuntoEmail assunto, Agendamento agendamento) throws BusinessException {
        ModeloEmail modelo = modeloEmailBO.getDAO().unique("tipoAssuntoEmail", assunto);
        
        if (modelo != null) {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("agendamento", agendamento);
            
            if (!Utils.isNullOrEmpty(agendamento.getEmailInstitucional())) {
                emailBO.enviar(modelo, parametros, agendamento.getEmailInstitucional());
            }
            
            if (!Utils.isNullOrEmpty(agendamento.getEmail())) {
                emailBO.enviar(modelo, parametros, agendamento.getEmail());
            }
        }
    }
    
}
