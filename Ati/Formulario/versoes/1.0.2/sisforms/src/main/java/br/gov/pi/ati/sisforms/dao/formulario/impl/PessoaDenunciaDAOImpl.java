package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.PessoaDenunciaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.PessoaDenuncia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PessoaDenunciaDAOImpl extends BaseDAOImpl<PessoaDenuncia> implements PessoaDenunciaDAO {

    @Override
    public Class getEntityClass() {
        return PessoaDenuncia.class;
    }

}
