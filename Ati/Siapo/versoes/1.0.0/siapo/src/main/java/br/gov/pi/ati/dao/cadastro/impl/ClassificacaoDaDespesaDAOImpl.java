package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.ClassificacaoDaDespesaDAO;
import br.gov.pi.ati.modelo.cadastro.ClassificacaoDaDespesa;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ClassificacaoDaDespesaDAOImpl extends BaseDAOImpl<ClassificacaoDaDespesa> implements ClassificacaoDaDespesaDAO {

    @Override
    public Class getEntityClass() {
        return ClassificacaoDaDespesa.class;
    }

}
