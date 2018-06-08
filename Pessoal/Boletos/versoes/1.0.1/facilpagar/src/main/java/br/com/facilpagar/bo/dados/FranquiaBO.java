package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.FranquiaDAO;
import br.com.facilpagar.modelo.dados.Convenio;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Franquia;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.Utils;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class FranquiaBO extends AbstractBusinessObject<Franquia> {

    @EJB
    private FranquiaDAO franquiaDAO;

    @Override
    public FranquiaDAO getDAO() {
        return franquiaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Franquia franquia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Franquia> franquias(FiltrosBusca filtros) {

        Restrictions restrictions = new Restrictions();

        if (filtros.getTipoPessoa() != null) {
            restrictions.add("franquias.tipo_pessoa", filtros.getTipoPessoa());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome_fantasia())) {
            restrictions.like("franquias.nome_fantasia", filtros.getNome_fantasia());
        }

        if (!Utils.isNullOrEmpty(filtros.getCpf_cnpj())) {
            restrictions.add("franquias.cpf_cnpj", filtros.getCpf_cnpj());
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }

        if (filtros.getEstado() != null) {
            restrictions.add("uf", filtros.getEstado());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("franquias.ativo", filtros.getAtivo().isStatus());
        }

        return getDAO().getQueryBuilder().from(Franquia.class, "franquias").leftJoinFetch("franquias.cidade", "cidade")
                .leftJoinFetch("cidade.uf", "uf").add(restrictions).orderBy("uf, cidade, franquias.nome_fantasia").getResultList();
    }
}
