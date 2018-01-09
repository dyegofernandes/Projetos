package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.UnidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import br.gov.pi.siste.modelo.cadastro.Orgao;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import br.gov.pi.siste.modelo.vos.FiltrosVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeBO extends AbstractBusinessObject<Unidade> {

    @EJB
    private UnidadeDAO unidadeDAO;

    @Override
    public UnidadeDAO getDAO() {
        return unidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("orgao", "nome").add("orgao", "codigo").add("cnpj");
    }

    @Override
    public void validate(Unidade unidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Unidade> listarUnidades(FiltrosVO filtros) {
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Unidade unidade = null;
        Restrictions restrictions = new Restrictions();

        if (!usuario.isSuperUsuario()) {
            Orgao orgao = getDAO().getInitialized(usuario.getOrgao());
            restrictions.add("orgao", orgao);
            if (usuario.getUnidade() != null) {
                unidade = getDAO().getInitialized(usuario.getUnidade());
                restrictions.add("unidade.id", unidade.getId());
            }
        } else {
            if (filtros.getOrgao() != null) {
                restrictions.add("orgao", filtros.getOrgao());
            }

            if (filtros.getUnidade() != null) {
                unidade = getDAO().getInitialized(filtros.getUnidade());
                restrictions.add("unidade.id", unidade.getId());
            }
        }

        List<Unidade> unidades = new ArrayList<Unidade>();

        if (filtros.getUnidadeNome() != null && !filtros.getUnidadeNome().equals("")) {
            restrictions.like("unidade.nome", filtros.getUnidadeNome());
        }

        if (filtros.getCodigoUnidade() != null && !filtros.getCodigoUnidade().equals("")) {
            restrictions.add("unidade.codigo", new Integer(filtros.getCodigoUnidade()));
        }

        if (filtros.getCnpjUnidade() != null && !filtros.getCnpjUnidade().equals("")) {
            restrictions.add("unidade.cnpj", filtros.getCnpjUnidade());
        }

        if (filtros.getLimite() != null) {
            restrictions.greaterThan("unidade.valorLimite", filtros.getLimite());
        }

        if (filtros.getCidade() != null) {
            restrictions.add("cidade", filtros.getCidade());
        }

        unidades = unidadeDAO.getQueryBuilder().select("unidade").from(Unidade.class, "unidade").innerJoinFetch("unidade.orgao", "orgao").innerJoinFetch("unidade.endereco", "endereco")
                .innerJoinFetch("endereco.cidade", "cidade").add(restrictions).orderBy("orgao, unidade.codigo").getResultList();

        return unidades;
    }

    public List<Unidade> unidadesPorMovimentos(List<Movimento> movimentos) {
        List<Unidade> unidades = new ArrayList<Unidade>();
        for (Movimento movimento : movimentos) {
//            Servidor servidor = getDAO().getInitialized(movimento.getServidor());
//            DadosFuncionais dados = getDAO().getInitialized(servidor.getDadosFuncionais());
//            Unidade unidade = getDAO().getInitialized(servidor.getDadosFuncionais().getUnidade());
            if (!unidades.contains(movimento.getServidor().getDadosFuncionais().getUnidade())) {
                unidades.add(movimento.getServidor().getDadosFuncionais().getUnidade());
            }
        }

        return unidades;
    }

    public List<Unidade> unidadesPorOrgao(Orgao orgao) {
        List<Unidade> unidades = new ArrayList<Unidade>();
        Restrictions restrictions = new Restrictions();

        if (orgao != null) {
            restrictions.add("orgao", orgao);
            unidades = unidadeDAO.list(restrictions, "codigo");
        }

        return unidades;
    }
}
