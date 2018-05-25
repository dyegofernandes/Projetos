package br.gov.pi.ati.sisrh.dao.cadastro;


import br.gov.pi.ati.sisrh.application.BaseDAOImpl;
import br.gov.pi.ati.sisrh.modelo.cadastro.EncaminhamentoLGBT;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EncaminhamentoLGBTDAOImpl extends BaseDAOImpl<EncaminhamentoLGBT> implements EncaminhamentoLGBTDAO {

    @Override
    public Class getEntityClass() {
        return EncaminhamentoLGBT.class;
    }

}
