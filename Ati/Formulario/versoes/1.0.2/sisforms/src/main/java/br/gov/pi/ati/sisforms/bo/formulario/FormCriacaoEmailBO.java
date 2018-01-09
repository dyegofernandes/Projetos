package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FormCriacaoEmailDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FormCriacaoEmail;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormCriacaoEmailBO extends AbstractBusinessObject<FormCriacaoEmail> {

    @EJB
    private FormCriacaoEmailDAO formCriacaoEmailDAO;
    
    @Override
    public FormCriacaoEmailDAO getDAO() {
        return formCriacaoEmailDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FormCriacaoEmail formCriacaoEmail) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public List<FormCriacaoEmail> listar(FiltrosVO filtros) {

        List<FormCriacaoEmail> lista = null;

        Restrictions restrictions = new Restrictions();

        if (filtros.getUsuario() != null) {
            restrictions.add("usuario", filtros.getUsuario());
        }

        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("a.dataCriacao", filtros.getDataInicial());
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("a.dataCriacao", filtros.getDataFinal());
        }
        
        if(filtros.getSituacao()!=null){
            restrictions.add("a.situacao", filtros.getSituacao());
        }

        lista = getDAO().getQueryBuilder().select("a").from(FormCriacaoEmail.class, "a").innerJoinFetch("a.usuario", "usuario")
                .innerJoinFetch("a.orgao", "orgao").add(restrictions).orderBy("usuario, orgao, a.dataCriacao").getResultList();

        return lista;
    }

}
