package br.com.jsoft.centralfinanceira.dao.central;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import javax.ejb.Local;

/**
 *
 * @author KillerBeeTwo
 */
@Local
public interface EmpresaDAO extends BaseDAO<Empresa> {
    
}
