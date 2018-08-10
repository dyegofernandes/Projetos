package br.gov.pi.ati.sisdh.bo.denuncia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.denuncia.DenunciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import br.gov.pi.ati.sisdh.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restriction;
import java.util.Date;

/**
 *
 * @author Juniel
 */
@Stateless
public class DenunciaBO extends AbstractBusinessObject<Denuncia> {

    @EJB
    private DenunciaDAO denunciaDAO;

    @Override
    public DenunciaDAO getDAO() {
        return denunciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        UniqueFields uniqueFields = new UniqueFields();
        uniqueFields.add(new UniqueField("numeroDenuncia").setMessage("Número da Denúncia já foi encontrado no Sistema, clique novamente em salvar para gerar outro número!!!"));
        return uniqueFields;
    }

    @Override
    public void validate(Denuncia denuncia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String gerarCodigo() {
        String dataAtualString = Utils.convertDateToString(new Date(), "yyyyMMdd");
        Long id = (Long) getDAO().getQueryBuilder().from(Denuncia.class).max("id");

        Denuncia denuncia = getDAO().unique("id", id);

        if (denuncia != null) {
            if (denuncia.getNumeroDenuncia().substring(0, 8).equals(dataAtualString)) {
                Integer codigoTemp = new Integer(denuncia.getNumeroDenuncia()) + 1;
                return codigoTemp.toString();
            }
        }

        return dataAtualString.concat("000001");
    }

}
