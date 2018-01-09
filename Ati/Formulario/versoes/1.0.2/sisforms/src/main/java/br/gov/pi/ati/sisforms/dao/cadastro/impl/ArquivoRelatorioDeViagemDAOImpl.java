package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.ArquivoRelatorioDeViagemDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeViagem;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoRelatorioDeViagemDAOImpl extends BaseDAOImpl<ArquivoRelatorioDeViagem> implements ArquivoRelatorioDeViagemDAO {

    @Override
    public Class getEntityClass() {
        return ArquivoRelatorioDeViagem.class;
    }

}
