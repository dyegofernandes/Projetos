package br.com.dota2.dao.exemplo;

import com.xpert.persistence.dao.BaseDAO;
import br.com.dota2.modelo.exemplo.PessoaExemplo;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface PessoaExemploDAO extends BaseDAO<PessoaExemplo> {
    
}
