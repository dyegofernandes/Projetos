/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.GrupoLojaCreditoDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoLojaCredito;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoLojaCreditoDAOImpl extends BaseDAOImpl<GrupoLojaCredito> implements GrupoLojaCreditoDAO {

    @Override
    public Class getEntityClass() {
        return GrupoLojaCredito.class;
    }

}

