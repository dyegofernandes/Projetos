package com.opfacil.dao.documento.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.documento.ArquivoDAO;
import com.opfacil.modelo.documentos.Arquivo;
import com.opfacil.modelo.documentos.DownloadArquivos;
import com.xpert.persistence.query.Restrictions;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ArquivoDAOImpl extends BaseDAOImpl<Arquivo> implements ArquivoDAO {

    @Override
    public Class getEntityClass() {
        return Arquivo.class;
    }
    
    @Override
    public Arquivo getArquivo(String nome){
        
        Restrictions restrictions = new Restrictions();
        restrictions.equals("nome", nome);
                
        return unique(restrictions);
    }

}
