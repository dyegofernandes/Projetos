package com.opfacil.dao.cadastro;

import com.opfacil.VOs.EmpresaInforAdicionaisVO;
import com.xpert.persistence.dao.BaseDAO;
import com.opfacil.modelo.cadastro.Empresa;
import javax.ejb.Local;

/**
 *
 * @author KillerBeeTwo
 */
@Local
public interface EmpresaDAO extends BaseDAO<Empresa> {
    
    public EmpresaInforAdicionaisVO listarInformacoesAdicEmpresa(Integer cdBanco);
    
}
