package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.FonteDeRecursoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class FonteDeRecursoBO extends AbstractBusinessObject<FonteDeRecurso> {

    @EJB
    private FonteDeRecursoDAO fonteDeRecursoDAO;

    @Override
    public FonteDeRecursoDAO getDAO() {
        return fonteDeRecursoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome").add("mnemonico");
    }

    @Override
    public void validate(FonteDeRecurso fonteDeRecurso) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<FonteDeRecurso> listarPeloNome(String nome) {
        Restrictions restrictions = new Restrictions();

        if (!Utils.isNullOrEmpty(nome)) {
            if (Utils.ehInteiro(nome)) {
                restrictions.like("fonte.codigo", nome);
            }else{
                restrictions.like("fonte.nome", nome);
            }
            
        }

        restrictions.add("fonte.ativo", true);

        return getDAO().getQueryBuilder().from(FonteDeRecurso.class, "fonte").add(restrictions).orderBy("fonte.nome").getResultList();
    }
}
