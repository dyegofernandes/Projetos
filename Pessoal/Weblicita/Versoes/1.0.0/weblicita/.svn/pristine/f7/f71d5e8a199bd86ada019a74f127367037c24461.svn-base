package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Item;
import br.com.weblicita.modelo.cadastro.Orgao;
import br.com.weblicita.util.Utils;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemBO extends AbstractBusinessObject<Item> {

    @EJB
    private ItemDAO itemDAO;

    @Override
    public ItemDAO getDAO() {
        return itemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Item item) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String gerarCodigo() {
//IT.ANO.10 
        String codigo = "IT.";

        String anoAtual = Utils.getAno(new Date());

        Long id = (Long) getDAO().getQueryBuilder().from(Item.class).max("id");

        Item item = getDAO().unique("id", id);

        if (item != null) {
            String[] codigoTemp = new String[3];

            codigoTemp = item.getCodigo().split("\\.");

            String anoOrgao = codigoTemp[1];

            Integer sequencial = new Integer(codigoTemp[2]);

            if (anoAtual.equals(anoOrgao)) {
                sequencial++;
                codigo = codigo.concat(anoOrgao).concat(".").concat(Utils.inserirZeroDireita(sequencial.toString(), 10));
            } else {
                codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
            }

        } else {
            codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
        }

        return codigo;
    }

}
