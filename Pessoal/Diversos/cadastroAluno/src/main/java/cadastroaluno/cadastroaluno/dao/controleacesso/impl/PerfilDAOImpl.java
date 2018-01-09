package cadastroaluno.cadastroaluno.dao.controleacesso.impl;

import cadastroaluno.cadastroaluno.application.BaseDAOImpl;
import cadastroaluno.cadastroaluno.dao.controleacesso.PerfilDAO;
import cadastroaluno.cadastroaluno.modelo.controleacesso.Perfil;
import cadastroaluno.cadastroaluno.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ayslan
 */
@Stateless
public class PerfilDAOImpl extends BaseDAOImpl<Perfil> implements PerfilDAO {

    @Override
    public Class getEntityClass() {
        return Perfil.class;
    }

    @Override
    public List<Perfil> getPerfis(Usuario usuario) {

        String queryString = "SELECT perfis FROM " + Usuario.class.getName() + " u WHERE u =?1 ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter(1, usuario);

        return query.getResultList();

    }
}
