package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ItemFormAcessoConteudoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormAcessoConteudo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemFormAcessoConteudoDAOImpl extends BaseDAOImpl<ItemFormAcessoConteudo> implements ItemFormAcessoConteudoDAO {

    @Override
    public Class getEntityClass() {
        return ItemFormAcessoConteudo.class;
    }

}
