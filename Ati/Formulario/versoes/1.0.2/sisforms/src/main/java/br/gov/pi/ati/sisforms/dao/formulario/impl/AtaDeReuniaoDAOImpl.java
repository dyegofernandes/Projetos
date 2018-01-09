package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.AtaDeReuniaoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AtaDeReuniaoDAOImpl extends BaseDAOImpl<AtaDeReuniao> implements AtaDeReuniaoDAO {

    @Override
    public Class getEntityClass() {
        return AtaDeReuniao.class;
    }

}
