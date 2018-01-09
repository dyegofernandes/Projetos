package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.DadosFuncionaisDAO;
import br.gov.pi.siste.modelo.cadastro.DadosFuncionais;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DadosFuncionaisDAOImpl extends BaseDAOImpl<DadosFuncionais> implements DadosFuncionaisDAO {

    @Override
    public Class getEntityClass() {
        return DadosFuncionais.class;
    }

}
