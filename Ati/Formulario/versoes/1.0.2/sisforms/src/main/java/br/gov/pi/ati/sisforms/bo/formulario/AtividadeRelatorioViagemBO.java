package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.AtividadeRelatorioViagemDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.AtividadeRelatorioViagem;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class AtividadeRelatorioViagemBO extends AbstractBusinessObject<AtividadeRelatorioViagem> {

    @EJB
    private AtividadeRelatorioViagemDAO atividadeRelatorioViagemDAO;
    
    @Override
    public AtividadeRelatorioViagemDAO getDAO() {
        return atividadeRelatorioViagemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AtividadeRelatorioViagem atividadeRelatorioViagem) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<AtividadeRelatorioViagem> lista(RelatorioDeViagem relatorio){
        List<AtividadeRelatorioViagem> atividades = new ArrayList<AtividadeRelatorioViagem>();
        
        if(relatorio!=null){
            atividades = getDAO().list("relatorioDeViagem", relatorio,"dataAtividade, descricao");
        }
        
        return atividades;
    }
}
