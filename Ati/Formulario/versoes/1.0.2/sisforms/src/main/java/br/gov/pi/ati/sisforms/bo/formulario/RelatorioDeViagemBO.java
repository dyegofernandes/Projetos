package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.RelatorioDeViagemDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author Juniel
 */
@Stateless
public class RelatorioDeViagemBO extends AbstractBusinessObject<RelatorioDeViagem> {

    @EJB
    private RelatorioDeViagemDAO relatorioDeViagemDAO;

    @Override
    public RelatorioDeViagemDAO getDAO() {
        return relatorioDeViagemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(RelatorioDeViagem relatorioDeViagem) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<RelatorioDeViagem> listar(FiltrosVO filtros) {

        List<RelatorioDeViagem> lista = null;

        Restrictions restrictions = new Restrictions();

        if (filtros.getUsuario() != null) {
            restrictions.add("usuario", filtros.getUsuario());
        }

        if (filtros.getDataInicial() != null) {
            restrictions.greaterEqualsThan("a.dataEmissao", filtros.getDataInicial());
        }
        
        if(filtros.getNome()!=null){
            if(!filtros.getNome().equals("")){
                restrictions.like("a.nome", filtros.getNome());
            }
        }
        
        if(filtros.getCpf()!=null){
            if(!filtros.getCpf().equals("")){
                restrictions.add("a.cpf", filtros.getCpf().replace(".", "").replace("-", ""));
            }
        }

        if (filtros.getDataFinal() != null) {
            restrictions.lessEqualsThan("a.dataEmissao", filtros.getDataFinal());
        }

        lista = getDAO().getQueryBuilder().select("a").from(RelatorioDeViagem.class, "a").innerJoinFetch("a.usuario", "usuario")
                .add(restrictions).orderBy("usuario, a.dataEmissao").getResultList();

        return lista;
    }
}
