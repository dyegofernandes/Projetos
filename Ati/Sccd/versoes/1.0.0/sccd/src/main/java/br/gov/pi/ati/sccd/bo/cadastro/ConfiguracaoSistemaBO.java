package br.gov.pi.ati.sccd.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.cadastro.ConfiguracaoSistemaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.cadastro.ConfiguracaoSistema;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConfiguracaoSistemaBO extends AbstractBusinessObject<ConfiguracaoSistema> {

    @EJB
    private ConfiguracaoSistemaDAO configuracaoSistemaDAO;
    
    @Override
    public ConfiguracaoSistemaDAO getDAO() {
        return configuracaoSistemaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();

        UniqueField unique = new UniqueField(Restriction.equals("ativo", true)).setMessage("Só pode existir uma configuração de sistema ativa!");

        uniqueFields.add(unique);

        return uniqueFields;
    }

    @Override
    public void validate(ConfiguracaoSistema configuracaoSistema) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
