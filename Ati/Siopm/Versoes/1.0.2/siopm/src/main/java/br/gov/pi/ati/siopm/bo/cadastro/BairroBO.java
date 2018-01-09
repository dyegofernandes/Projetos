package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.BairroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import br.gov.pi.ati.siopm.modelo.cadastro.Cidade;
import br.gov.pi.ati.siopm.modelo.cadastro.Circunscricao;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroBO extends AbstractBusinessObject<Bairro> {

    @EJB
    private BairroDAO bairroDAO;

    @Override
    public BairroDAO getDAO() {
        return bairroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome", "cidade");
    }

    @Override
    public void validate(Bairro bairro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Bairro> listarBairros(FiltrosVO filtro) {
        Restrictions restrictions = new Restrictions();

        if (filtro.getNome() != null) {
            if (!filtro.getNome().equals("")) {
                restrictions.like("bairro.nome", filtro.getNome());
            }
        }

        if (filtro.getCidade() != null) {
            restrictions.add("cidade", filtro.getCidade());
        }

        List<Bairro> bairros = getDAO().getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .leftJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("cidade, bairro.nome").getResultList();

        return bairros;

    }

    public List<Bairro> listarBairrosPelaCidade(Cidade cidade) {
        Restrictions restrictions = new Restrictions();

        if (cidade != null) {
            restrictions.add("cidade", cidade);
        }

        List<Bairro> bairros = getDAO().getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                .leftJoinFetch("bairro.cidade", "cidade").add(restrictions).orderBy("cidade, bairro.nome").getResultList();

        return bairros;

    }

    public Bairro getBairroPelaCidadeENome(Cidade cidade, String nome) {
        Restrictions restrictions = new Restrictions();
        Bairro bairro = null;

        if (cidade != null && Utils.isNullOrEmpty(nome)) {
            restrictions.add("bairro.nome", nome);
            restrictions.add("cidade", cidade);
            bairro = (Bairro) getDAO().getQueryBuilder().select("bairro").from(Bairro.class, "bairro")
                    .leftJoinFetch("bairro.cidade", "cidade").add(restrictions).getSingleResult();
        }

        return bairro;

    }

    public List<Circunscricao> listarBairrosPorCidades(List<Circunscricao> cidades) {

        List<Circunscricao> circunscricoes = new ArrayList<Circunscricao>();

        Restrictions restrictions = new Restrictions();

        List<Long> ids = new ArrayList<Long>();

        for (Circunscricao cidade : cidades) {
            ids.add(cidade.getId());
        }

        if (ids.size() > 0) {
            restrictions.in("cidade.id", ids);
        } else {
            return circunscricoes;
        }

        List<Bairro> bairros = getDAO().list(restrictions, "cidade, nome");

        for (Bairro bairro : bairros) {
            circunscricoes.add((Circunscricao) bairro);
        }

        return circunscricoes;
    }

    private List<Long> converteListaEmString(List<Cidade> cidades) {
        List<Long> ids = new ArrayList<Long>();
        //Itero toda a lista
        for (Cidade cidade : cidades) {
            ids.add(cidade.getId());
        }
        //Retorno toda a string menos a ultima virgula
        return ids;
    }

}
