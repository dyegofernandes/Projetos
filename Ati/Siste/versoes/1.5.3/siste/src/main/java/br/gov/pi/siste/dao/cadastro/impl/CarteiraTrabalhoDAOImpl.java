package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.CarteiraTrabalhoDAO;
import br.gov.pi.siste.modelo.cadastro.CarteiraTrabalho;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CarteiraTrabalhoDAOImpl extends BaseDAOImpl<CarteiraTrabalho> implements CarteiraTrabalhoDAO {

    @Override
    public Class getEntityClass() {
        return CarteiraTrabalho.class;
    }

}
