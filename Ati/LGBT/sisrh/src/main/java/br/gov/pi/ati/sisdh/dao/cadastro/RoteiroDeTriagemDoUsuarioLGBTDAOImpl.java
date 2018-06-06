package br.gov.pi.ati.sisdh.dao.cadastro;


import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.modelo.cadastro.RoteiroDeTriagemDoUsuarioLGBT;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RoteiroDeTriagemDoUsuarioLGBTDAOImpl extends BaseDAOImpl<RoteiroDeTriagemDoUsuarioLGBT> implements RoteiroDeTriagemDoUsuarioLGBTDAO {

    @Override
    public Class getEntityClass() {
        return RoteiroDeTriagemDoUsuarioLGBT.class;
    }

}
