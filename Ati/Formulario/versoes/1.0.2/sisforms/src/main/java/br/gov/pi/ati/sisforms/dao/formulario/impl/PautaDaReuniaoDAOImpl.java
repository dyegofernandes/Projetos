package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.PautaDaReuniaoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.PautaDaReuniao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PautaDaReuniaoDAOImpl extends BaseDAOImpl<PautaDaReuniao> implements PautaDaReuniaoDAO {

    @Override
    public Class getEntityClass() {
        return PautaDaReuniao.class;
    }

}
