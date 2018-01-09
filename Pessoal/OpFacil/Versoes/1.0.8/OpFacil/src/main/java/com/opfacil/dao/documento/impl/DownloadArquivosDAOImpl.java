package com.opfacil.dao.documento.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.documento.DownloadArquivosDAO;
import com.opfacil.modelo.documentos.DownloadArquivos;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class DownloadArquivosDAOImpl extends BaseDAOImpl<DownloadArquivos> implements DownloadArquivosDAO {

    @Override
    public Class getEntityClass() {
        return DownloadArquivos.class;
    }   

}
