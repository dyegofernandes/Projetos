package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.PatrulhaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.GuarnicaoViatura;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import br.gov.pi.ati.siopm.modelo.enums.StatusViaturaEnum;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class PatrulhaBO extends AbstractBusinessObject<Patrulha> {
    
    @EJB
    private PatrulhaDAO patrulhaDAO;
    
    @Override
    public PatrulhaDAO getDAO() {
        return patrulhaDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();
        uniqueFields.add(new UniqueField(Restriction.equals("ativo", true), "viatura").setMessage("Já existe uma patrulha ativa para viatura informada!"));
        return uniqueFields;
    }
    
    @Override
    public void validate(Patrulha patrulha) throws BusinessException {
        if (patrulha.getInicioTurno().after(patrulha.getFimTurno())) {
            throw new BusinessException("A data inicial do turno deve ser menor ou igual a data final!");
        }
        List<GuarnicaoViatura> guarnicoes = getDAO().getInitialized(patrulha.getGuarnicoes());
        if (guarnicoes.size() < 1) {
            throw new BusinessException("Uma Patrulha deve possuir um ou mais componentes na Guarnição!");
        } else {
            for (GuarnicaoViatura guarnicao : guarnicoes) {
                
            }
        }
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<Patrulha> listarPatrulhasDisponiveis(List<Opm> opms) {
        List<Patrulha> patrulhas;
        
        Restrictions restrictions = new Restrictions();
        
        restrictions.add("patrulha.status", StatusViaturaEnum.DISPONIVEL);
        
        restrictions.add("patrulha.ativo", true);
        
        if (opms != null) {
            if (opms.size() > 0) {
                restrictions.in("opm", opms);
            }
        }
        
        patrulhas = getDAO().getQueryBuilder().select("patrulha").from(Patrulha.class, "patrulha")
                .leftJoinFetch("patrulha.viatura", "viatura").leftJoinFetch("patrulha.opm", "opm").add(restrictions).getResultList();
        
        return patrulhas;
    }
    
    public List<Patrulha> patrulhasPeloNomeEOpmAtivas(String nome, List<Opm> opms) {
        List<Patrulha> patrulhas;
        
        Restrictions restrictions = new Restrictions();
        
        restrictions.add("patrulha.status", StatusViaturaEnum.DISPONIVEL);
        
        restrictions.add("patrulha.ativo", true);
        
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("viatura.nome", nome);
        }
        
        if (opms != null) {
            if (opms.size() > 0) {
                restrictions.in("opm", opms);
            }
        }
        
        patrulhas = getDAO().getQueryBuilder().select("patrulha").from(Patrulha.class, "patrulha").leftJoinFetch("patrulha.opm", "opm")
                .leftJoinFetch("patrulha.viatura", "viatura").add(restrictions).orderBy("viatura.prefixo").getResultList();
        
        return patrulhas;
    }
    
}
