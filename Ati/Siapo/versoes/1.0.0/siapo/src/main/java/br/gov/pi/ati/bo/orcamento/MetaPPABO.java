package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.MetaPPADAO;
import br.gov.pi.ati.modelo.orcamento.Ldo;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.MetaPPA;
import br.gov.pi.ati.modelo.orcamento.TerritorioPPA;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaPPABO extends AbstractBusinessObject<MetaPPA> {

    @EJB
    private MetaPPADAO metaPPADAO;

    @Override
    public MetaPPADAO getDAO() {
        return metaPPADAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MetaPPA metaPPA) throws BusinessException {
        if (metaPPA.getLdos().size() != 4) {
            throw new BusinessException("Lista de LDOs deve ser igual a 4!");
        } else {
            BigDecimal soma = BigDecimal.ZERO;

            for (Ldo ldo : metaPPA.getLdos()) {
                soma = soma.add(ldo.getValor());
            }

            if (soma.compareTo(metaPPA.getValorMeta()) != 0) {
                throw new BusinessException("Soma das LDOs deve ser igual ao valor do PPA!");
            }
        }

        if (metaPPA.getTerritorios().size() < 1) {
            throw new BusinessException("Ao menos um território deve ser informado!");
        } else {
            BigDecimal soma = BigDecimal.ZERO;

            for (TerritorioPPA territorio : metaPPA.getTerritorios()) {
                soma = soma.add(territorio.getValor());
            }

            if (soma.compareTo(metaPPA.getValorMeta()) != 0) {
                throw new BusinessException("Soma dos valores para os territorios informados deve ser igual ao valor do PPA!");
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
