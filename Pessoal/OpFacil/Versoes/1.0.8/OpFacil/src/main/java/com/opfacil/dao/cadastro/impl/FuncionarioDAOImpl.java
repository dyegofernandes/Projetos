package com.opfacil.dao.cadastro.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.cadastro.FuncionarioDAO;
import com.opfacil.modelo.cadastro.Funcionario;
import com.xpert.audit.Audit;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.utils.EntityUtils;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class FuncionarioDAOImpl extends BaseDAOImpl<Funcionario> implements FuncionarioDAO {

    @Override
    public Class getEntityClass() {
        return Funcionario.class;
    }
    
    private Audit getNewAudit() {
        return new Audit(getEntityManager());
    }

}
