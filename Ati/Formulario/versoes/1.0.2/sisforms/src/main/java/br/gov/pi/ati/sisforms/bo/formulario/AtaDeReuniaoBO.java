package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.AtaDeReuniaoDAO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class AtaDeReuniaoBO extends AbstractBusinessObject<AtaDeReuniao> {

    @EJB
    private AtaDeReuniaoDAO ataDeReuniaoDAO;

    @Override
    public AtaDeReuniaoDAO getDAO() {
        return ataDeReuniaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AtaDeReuniao ataDeReuniao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<AtaDeReuniao> listar(FiltrosVO filtros) {

        List<AtaDeReuniao> lista = null;

        Restrictions restrictions = new Restrictions();

        if (filtros.getUsuario() != null) {
            restrictions.add("usuario", filtros.getUsuario());
        }

        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("a.dataDaReuniao", filtros.getDataInicial());
        }

        if (filtros.getAssunto() != null) {
            if (!filtros.getAssunto().equals("")) {
                restrictions.like("a.assunto", filtros.getAssunto());
            }
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("a.dataDaReuniao", filtros.getDataFinal());
        }

        lista = getDAO().getQueryBuilder().select("a").from(AtaDeReuniao.class, "a").innerJoinFetch("a.usuario", "usuario")
                .innerJoinFetch("a.orgao", "orgao").add(restrictions).orderBy("usuario, orgao, a.dataDaReuniao").getResultList();

        return lista;
    }

}
