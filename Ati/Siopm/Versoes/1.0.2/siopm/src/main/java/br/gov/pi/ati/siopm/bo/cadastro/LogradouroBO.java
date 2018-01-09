package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.LogradouroDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Logradouro;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.persistence.query.Restrictions;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.persistence.Query;
import br.gov.pi.ati.siopm.util.Utils;

/**
 *
 * @author Juniel
 */
@Stateless
public class LogradouroBO extends AbstractBusinessObject<Logradouro> {

    @EJB
    private LogradouroDAO logradouroDAO;

    @Override
    public LogradouroDAO getDAO() {
        return logradouroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
//        return new UniqueFields().add("logradouro", "cidade");
    }

    @Override
    public void validate(Logradouro logradouro) throws BusinessException {
        if (logradouro.getBairros().size() < 1) {
            throw new BusinessException("Logradouro dever pertencer a um ou mais bairros!!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Logradouro> listarLogradouroPeloBairro(FiltrosVO filtros) {
        List<Logradouro> logradouros;

        Restrictions restrictions = new Restrictions();

        if (filtros.getBairro() != null) {
            restrictions.add("bairro", filtros.getBairro());
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                restrictions.like("nome", filtros.getNome());
            }
        }

        logradouros = getDAO().getQueryBuilder().select("logradouro").from(Logradouro.class, "logradouro")
                .leftJoinFetch("bairro.cidade", "cidade").add(restrictions)
                .orderBy("cidade, bairro, logradouro.logradouro").getResultList();

        return logradouros;
    }

    public Logradouro getLogradouroPeloNomeEBairro(Bairro bairro, String nome) {
        Logradouro logradouro = null;

        if (bairro != null && Utils.isNullOrEmpty(nome)) {
            String queryString = "select * from logradouro_bairro lb left join logradouro l on (lb.logradouro_id=l.id)"
                    + "where bairros_id=BAIRRO_ID and upper(l.logradouro) = upper('NOME_LOGRADOURO') ";

            queryString = queryString.replace("BAIRRO_ID", bairro.getId().toString());

            queryString = queryString.replace("NOME_LOGRADOURO", nome);

            Query query;

            query = getEntityManager().createNativeQuery(queryString);

            List<Object[]> resultado = query.getResultList();

            for (Object[] tupla : resultado) {
                logradouro = logradouroDAO.unique("id", ((BigInteger) tupla[0]).longValue());
            }
        }

        return logradouro;
    }

    public List<Logradouro> listarLogradouroPeloBairro(Bairro bairro) {
        List<Logradouro> logradouros = null;

        if (bairro != null) {
            logradouros = new ArrayList<Logradouro>();

            String queryString = "select * from logradouro_bairro lb where lb.bairros_id=BAIRRO_ID";

            queryString = queryString.replace("BAIRRO_ID", bairro.getId().toString());

            Query query;

            query = getEntityManager().createNativeQuery(queryString);

            List<Object[]> resultado = query.getResultList();

            for (Object[] tupla : resultado) {
                Logradouro logradouro = new Logradouro();
                logradouro = logradouroDAO.unique("id", ((BigInteger) tupla[0]).longValue());
                logradouros.add(logradouro);
            }
        }

        return logradouros;
    }

}
