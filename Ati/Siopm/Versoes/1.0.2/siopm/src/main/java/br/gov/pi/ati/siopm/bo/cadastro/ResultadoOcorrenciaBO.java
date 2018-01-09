package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ResultadoOcorrenciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ResultadoOcorrenciaBO extends AbstractBusinessObject<ResultadoOcorrencia> {

    @EJB
    private ResultadoOcorrenciaDAO resultadoOcorrenciaDAO;

    @Override
    public ResultadoOcorrenciaDAO getDAO() {
        return resultadoOcorrenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("codigo").add("nome", "orgaoRecebedor");
    }

    @Override
    public void validate(ResultadoOcorrencia resultadoOcorrencia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<ResultadoOcorrencia> resultadoOcorrenciaAtivos() {
        Restrictions restrictions = new Restrictions();
        restrictions.add("resultado.ativo", true);
        return getDAO().getQueryBuilder().select("resultado").from(ResultadoOcorrencia.class, "resultado").leftJoinFetch("resultado.orgaoRecebedor", "orgao")
                .add(restrictions).orderBy("orgao.nome, resultado.nome").getResultList();
    }

    public List<ResultadoOcorrencia> resultadoOcorrenciaPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();
        restrictions.add("resultado.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("resultado.nome", nome);
        }
        return getDAO().getQueryBuilder().select("resultado").from(ResultadoOcorrencia.class, "resultado").leftJoinFetch("resultado.orgaoRecebedor", "orgao")
                .add(restrictions).orderBy("orgao.nome, resultado.nome").getResultList();
    }

}
