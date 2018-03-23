package br.gov.pi.ati.sccd.dao.cadastro.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.cadastro.AutoridadeCertificadoraDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.AutoridadeCertificadora;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AutoridadeCertificadoraDAOImpl extends BaseDAOImpl<AutoridadeCertificadora> implements AutoridadeCertificadoraDAO {

    @Override
    public Class getEntityClass() {
        return AutoridadeCertificadora.class;
    }

}
