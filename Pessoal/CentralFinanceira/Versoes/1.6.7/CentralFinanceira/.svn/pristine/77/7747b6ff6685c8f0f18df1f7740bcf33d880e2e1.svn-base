package br.com.jsoft.centralfinanceira.dao.central;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoLoja;
import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Loja;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface LojaDAO extends BaseDAO<Loja> {
    public List<Loja> getLojaPorNome(String nome);
    public List<Loja> getLojaPorNomeSemGrupo(String nome);
}
