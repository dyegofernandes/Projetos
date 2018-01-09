package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ItemDaRequisicaoDeMaterialDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemDaRequisicaoDeMaterial;
import br.gov.pi.ati.sisforms.modelo.formulario.RequisicaoDeMaterial;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemDaRequisicaoDeMaterialBO extends AbstractBusinessObject<ItemDaRequisicaoDeMaterial> {

    @EJB
    private ItemDaRequisicaoDeMaterialDAO itemDaRequisicaoDeMaterialDAO;

    @Override
    public ItemDaRequisicaoDeMaterialDAO getDAO() {
        return itemDaRequisicaoDeMaterialDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemDaRequisicaoDeMaterial itemDaRequisicaoDeMaterial) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<ItemDaRequisicaoDeMaterial> listarItensPorRequisicao(RequisicaoDeMaterial requisicao) {
        List<ItemDaRequisicaoDeMaterial> itens = null;

        Restrictions restrictions = new Restrictions();

        restrictions.add("requisicaoDeMaterial", requisicao);

        if (requisicao != null) {
            itens = itemDaRequisicaoDeMaterialDAO.list(restrictions, "discriminacao");
        }

        return itens;
    }
}
