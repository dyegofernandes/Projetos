package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.ArquivoPublicoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoPublico;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoPublicoDAOImpl extends BaseDAOImpl<ArquivoPublico> implements ArquivoPublicoDAO {

    @Override
    public Class getEntityClass() {
        return ArquivoPublico.class;
    }

}
