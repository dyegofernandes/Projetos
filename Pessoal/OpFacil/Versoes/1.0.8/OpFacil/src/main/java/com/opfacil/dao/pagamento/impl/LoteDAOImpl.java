package com.opfacil.dao.pagamento.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.pagamento.LoteDAO;
import com.opfacil.modelo.pagamento.Lote;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class LoteDAOImpl extends BaseDAOImpl<Lote> implements LoteDAO {

    @Override
    public Class getEntityClass() {
        return Lote.class;
    }

}
