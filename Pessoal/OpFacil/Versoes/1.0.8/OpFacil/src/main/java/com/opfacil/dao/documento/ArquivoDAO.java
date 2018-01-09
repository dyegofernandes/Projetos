package com.opfacil.dao.documento;

import com.opfacil.modelo.documentos.Arquivo;
import com.xpert.persistence.dao.BaseDAO;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ArquivoDAO extends BaseDAO<Arquivo> {

    public Arquivo getArquivo(String nome);
}
