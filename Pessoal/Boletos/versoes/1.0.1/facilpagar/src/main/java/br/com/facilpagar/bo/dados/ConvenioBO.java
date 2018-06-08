package br.com.facilpagar.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.facilpagar.dao.dados.ConvenioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.facilpagar.modelo.dados.Convenio;
import br.com.facilpagar.modelo.dados.Franquia;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioBO extends AbstractBusinessObject<Convenio> {

    @EJB
    private ConvenioDAO convenioDAO;

    @Override
    public ConvenioDAO getDAO() {
        return convenioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf_cnpj").add("razao_social").add("nome_fantasia");
    }

    @Override
    public void validate(Convenio convenio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Convenio> conveniosPeloNomeOrCnpjOuCpf(String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("cpf_cnpj", (nome.replace(".", "").replace("/", "").replace("-", "")));
            } else {
                restrictions.like("nome_fantasia", nome);
            }

        }

        return getDAO().list(restrictions, "nome_fantasia");
    }

    public List<Convenio> conveniosPeloNomeOrCnpjOuCpfEFranquia(Franquia franquia, String nome) {
        Restrictions restrictions = new Restrictions();

        restrictions.add("ativo", true);

        if (franquia != null) {
            restrictions.add("franquia", franquia);
        }else{
            return null;
        }

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("cpf_cnpj", (nome.replace(".", "").replace("/", "").replace("-", "")));
            } else {
                restrictions.like("nome_fantasia", nome);
            }

        }

        return getDAO().list(restrictions, "nome_fantasia");
    }

    public List<Convenio> convenioPelaFranquia(Franquia franquia) {
        return getDAO().list("franquia", franquia, "nome_fantasia");
    }

    public List<Convenio> convenios(FiltrosBusca filtros) {

        Restrictions restrictions = new Restrictions();

        if (filtros.getFranquia() != null) {
            restrictions.add("franquia", filtros.getFranquia());
        }

        if (filtros.getTipoPessoa() != null) {
            restrictions.add("convenio.tipo_pessoa", filtros.getTipoPessoa());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome_fantasia())) {
            restrictions.like("convenio.nome_fantasia", filtros.getNome_fantasia());
        }

        if (!Utils.isNullOrEmpty(filtros.getCpf_cnpj())) {
            restrictions.add("convenio.cpf_cnpj", filtros.getCpf_cnpj());
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }

        if (filtros.getEstado() != null) {
            restrictions.add("uf", filtros.getEstado());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("convenio.ativo", filtros.getAtivo().isStatus());
        }

        return getDAO().getQueryBuilder().from(Convenio.class, "convenio").leftJoinFetch("convenio.franquia", "franquia").leftJoinFetch("convenio.cidade", "cidade")
                .leftJoinFetch("cidade.uf", "uf").add(restrictions).orderBy("uf, cidade, franquia, convenio.nome_fantasia").getResultList();
    }

}
