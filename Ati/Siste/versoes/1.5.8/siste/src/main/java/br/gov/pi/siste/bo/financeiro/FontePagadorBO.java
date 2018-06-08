package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.FontePagadorDAO;

import br.gov.pi.siste.modelo.cadastro.Orgao;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.financeiro.FontePagador;
import br.gov.pi.siste.modelo.vos.FiltrosVO;
import br.gov.pi.siste.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class FontePagadorBO extends AbstractBusinessObject<FontePagador> {

    @EJB
    private FontePagadorDAO fontePagadorDAO;
    
    @Override
    public FontePagadorDAO getDAO() {
        return fontePagadorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("orgao","codigo").add("orgao","nome");
    }

    @Override
    public void validate(FontePagador fontePagador) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<FontePagador> listarFontesPagadoras(FiltrosVO filtros) {

        
        Restrictions restrictions = new Restrictions();

        
        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }

        if (!Utils.isNullOrEmpty(filtros.getNome())) {
            restrictions.like("fontePagador.nome", filtros.getNome());
        }
        
        if (filtros.getCode() != null){
            restrictions.add("fontePagador.codigo", filtros.getCode());
        }

        List<FontePagador> fontes = fontePagadorDAO.getQueryBuilder().from(FontePagador.class, "fontePagador")
                .leftJoinFetch("fontePagador.orgao", "orgao")
                .add(restrictions)
                .orderBy("orgao.nome")
                .getResultList();

        return fontes;
    }
    
    
    public List<Orgao> orgaoPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();
        if (!Utils.isNullOrEmpty(nome)) {
            restrictions.like("orgao.sigla", nome);
        }

        return getDAO().getQueryBuilder().from(Orgao.class, "orgao").add(restrictions).orderBy("orgao.nome").getResultList();
    }
}
