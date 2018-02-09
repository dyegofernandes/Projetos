package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Item;
import br.com.weblicita.util.Utils;
import com.xpert.core.exception.UniqueFieldException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
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
        return new UniqueFields().add("descricao").add("codigo");
    }

    @Override
    public void validateUniqueFields(Item item) throws UniqueFieldException {
//        Restriction restriction = new Restriction("UPPER(descricao)", item.getDescricao().toUpperCase());
//        UniqueField uniqueField = new UniqueField(restriction).setMessage("Já existe item cadastrado com essa descrição: ".concat(item.getDescricao().toUpperCase()));
//        UniqueFieldsValidation.validateUniqueFields(uniqueField, item, getDAO());
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
            if (Utils.isNullOrEmpty(item.getCodigo())) {
                codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
            } else {
                codigoTemp = item.getCodigo().split("\\.");

                String anoOrgao = codigoTemp[1];

                Integer sequencial = new Integer(codigoTemp[2]);

                if (anoAtual.equals(anoOrgao)) {
                    sequencial++;
                    codigo = codigo.concat(anoOrgao).concat(".").concat(Utils.inserirZeroDireita(sequencial.toString(), 10));
                } else {
                    codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
                }
            }

        } else {
            codigo = codigo.concat(anoAtual).concat(".").concat(Utils.inserirZeroDireita("1", 10));
        }

        return codigo;
    }

    public List<Item> itensPelaDescricao(String descricao) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(descricao)) {
            restrictions.like("descricao", descricao);
        }

        return getDAO().list(restrictions, "descricao");
    }

    public Item itemPelaDescricao(String descricao) {
        Restrictions restrictions = new Restrictions();

        if (Utils.isNullOrEmpty(descricao)) {
            return null;
        }

        restrictions.equals("UPPER(descricao)", descricao.toUpperCase());

        return getDAO().unique(restrictions);
    }

}
