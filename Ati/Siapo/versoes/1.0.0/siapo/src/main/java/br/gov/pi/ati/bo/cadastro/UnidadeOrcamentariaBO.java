package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.UnidadeOrcamentariaDAO;
import br.gov.pi.ati.modelo.cadastro.Orgao;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.util.SessaoUtils;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeOrcamentariaBO extends AbstractBusinessObject<UnidadeOrcamentaria> {

    @EJB
    private UnidadeOrcamentariaDAO unidadeOrcamentariaDAO;

    @Override
    public UnidadeOrcamentariaDAO getDAO() {
        return unidadeOrcamentariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo,orgao").add("nome,orgao").add("mnemonico,orgao");
    }

    @Override
    public void validate(UnidadeOrcamentaria unidadeOrcamentaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<UnidadeOrcamentaria> unidadePeloNomeEunidadeDeAcesso(String nome) {
        Usuario usuarioAtual = SessaoUtils.getUser();

        List<UnidadeOrcamentaria> unidadeComAcesso = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());

        Restrictions restrictions = new Restrictions();

        restrictions.add("uo.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("uo.nome", nome);
        }

        if (unidadeComAcesso != null) {
            if (unidadeComAcesso.size() > 0) {
                restrictions.in("uo", unidadeComAcesso);
            }
        }

        return getDAO().getQueryBuilder().select("uo").from(UnidadeOrcamentaria.class, "uo").leftJoinFetch("uo.programa", "progppa")
                .leftJoinFetch("progppa.programa", "programa").add(restrictions).orderBy("uo.nome").getResultList();

    }

    public List<UnidadeOrcamentaria> unidadePeloNome(String nome) {

        Restrictions restrictions = new Restrictions();

        restrictions.add("uo.ativo", true);

        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("uo.nome", nome);
        }

        return getDAO().getQueryBuilder().select("uo").from(UnidadeOrcamentaria.class, "uo").add(restrictions).orderBy("uo.nome").getResultList();

    }

    public List<UnidadeOrcamentaria> unidadesAtivas() {

        Restrictions restrictions = new Restrictions();

        restrictions.add("uo.ativo", true);

        return getDAO().getQueryBuilder().select("uo").from(UnidadeOrcamentaria.class, "uo").add(restrictions).orderBy("uo.codigo").getResultList();

    }

    public List<UnidadeOrcamentaria> unidadesPeloOrgao(Orgao orgao, String nome, String codigo) {
        Restrictions restrictions = new Restrictions();

        if (orgao != null) {
            restrictions.add("orgao", orgao);
        }
        
        if(!Utils.isNullOrEmpty(codigo)){
            restrictions.like("uo.codigo", codigo);
        }
        
        if(!Utils.isNullOrEmpty(nome)){
            restrictions.like("uo.nome", nome);
        }

        return getDAO().getQueryBuilder().select("uo").from(UnidadeOrcamentaria.class, "uo").leftJoinFetch("uo.orgao", "orgao").add(restrictions).orderBy("uo.codigo").getResultList();

    }
}
