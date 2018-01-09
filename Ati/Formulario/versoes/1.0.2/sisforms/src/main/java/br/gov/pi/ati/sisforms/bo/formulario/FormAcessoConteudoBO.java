package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FormAcessoConteudoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormAcessoConteudoBO extends AbstractBusinessObject<FormAcessoConteudo> {

    @EJB
    private FormAcessoConteudoDAO formAcessoConteudoDAO;

    @Override
    public FormAcessoConteudoDAO getDAO() {
        return formAcessoConteudoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FormAcessoConteudo formAcessoConteudo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<FormAcessoConteudo> listar(FiltrosVO filtros) {
        List<FormAcessoConteudo> lista = null;

        Restrictions restrictions = new Restrictions();

        if (filtros.getUsuario() != null) {
            restrictions.add("usuario", filtros.getUsuario());
        }

        if (filtros.getOrgao() != null) {
            restrictions.add("orgao", filtros.getOrgao());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("f.dataCriacao", filtros.getDataInicial());
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("f.dataCriacao", filtros.getDataFinal());
        }

        if (filtros.getNome() != null) {
            if (!filtros.getNome().equals("")) {
                restrictions.like("f.nomeCompleto", filtros.getNome());
            }
        }

        if (filtros.getSituacao() != null) {
            restrictions.add("f.situacao", filtros.getSituacao());
        }

        lista = getDAO().getQueryBuilder().select("f").from(FormAcessoConteudo.class, "f").innerJoinFetch("f.usuario", "usuario")
                .innerJoinFetch("f.orgao", "orgao").add(restrictions).orderBy("usuario, orgao, f.dataCriacao").getResultList();

        return lista;
    }

}
