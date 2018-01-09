package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.ArquivoRelatorioDeVisitaDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeVisita;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoRelatorioDeVisitaDAOImpl extends BaseDAOImpl<ArquivoRelatorioDeVisita> implements ArquivoRelatorioDeVisitaDAO {

    @Override
    public Class getEntityClass() {
        return ArquivoRelatorioDeVisita.class;
    }

}
