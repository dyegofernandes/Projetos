package cadastroaluno.cadastroaluno.dao.exemplo.impl;

import cadastroaluno.cadastroaluno.application.BaseDAOImpl;
import cadastroaluno.cadastroaluno.dao.exemplo.PessoaExemploDAO;
import cadastroaluno.cadastroaluno.modelo.exemplo.PessoaExemplo;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class PessoaExemploDAOImpl extends BaseDAOImpl<PessoaExemplo> implements PessoaExemploDAO {

    @Override
    public Class getEntityClass() {
        return PessoaExemplo.class;
    }

}
