package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.RelatorioDeVisitaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeVisita;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class RelatorioDeVisitaBO extends AbstractBusinessObject<RelatorioDeVisita> {

    @EJB
    private RelatorioDeVisitaDAO relatorioDeVisitaDAO;

    @Override
    public RelatorioDeVisitaDAO getDAO() {
        return relatorioDeVisitaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(RelatorioDeVisita relatorioDeVisita) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<RelatorioDeVisita> listar(FiltrosVO filtros) {

        List<RelatorioDeVisita> lista = null;

        Restrictions restrictions = new Restrictions();

        if (filtros.getUsuario() != null) {
            restrictions.add("usuario", filtros.getUsuario());
        }

        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                restrictions.like("a.solicitadoPor", filtros.getNome());
            }
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("a.dataEmissao", filtros.getDataInicial());
        }

        if (filtros.getAno() != null) {
            restrictions.add("a.ano", filtros.getAno());
        }

        if (filtros.getNumero() != null) {
            restrictions.add("a.numero", filtros.getNumero());
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("a.dataEmissao", filtros.getDataFinal());
        }

        lista = getDAO().getQueryBuilder().select("a").from(RelatorioDeVisita.class, "a").innerJoinFetch("a.usuario", "usuario")
                .innerJoinFetch("a.orgao", "orgao").add(restrictions).orderBy("usuario, orgao, a.dataEmissao").getResultList();

        return lista;
    }

}
