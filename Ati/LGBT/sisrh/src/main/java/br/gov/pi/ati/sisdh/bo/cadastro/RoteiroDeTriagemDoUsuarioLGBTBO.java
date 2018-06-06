package br.gov.pi.ati.sisdh.bo.cadastro;

import br.gov.pi.ati.sisdh.dao.cadastro.RoteiroDeTriagemDoUsuarioLGBTDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.RoteiroDeTriagemDoUsuarioLGBT;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class RoteiroDeTriagemDoUsuarioLGBTBO extends AbstractBusinessObject<RoteiroDeTriagemDoUsuarioLGBT> {
    
    @EJB
    private RoteiroDeTriagemDoUsuarioLGBTDAO roteiroDeTriagemDoUsuarioLGBTDAO;
    
    @Override
    public RoteiroDeTriagemDoUsuarioLGBTDAO getDAO() {
        return roteiroDeTriagemDoUsuarioLGBTDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo", "ano").add("registroSocialNum", "registroSocialAno").add("cpf").add("rg");
    }
    
    @Override
    public void validate(RoteiroDeTriagemDoUsuarioLGBT roteiroDeTriagemDoUsuarioLGBT) throws BusinessException {
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
    public Integer getUltimoCodigo(Integer ano) {
        return (Integer) getDAO().getQueryBuilder().from(RoteiroDeTriagemDoUsuarioLGBT.class).add("ano", ano).max("codigo");
    }
    
}
