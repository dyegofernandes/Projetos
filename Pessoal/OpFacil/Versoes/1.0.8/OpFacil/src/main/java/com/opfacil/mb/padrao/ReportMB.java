package com.opfacil.mb.padrao;

import com.opfacil.util.ReportUtils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@RequestScoped
public class ReportMB {
    
    public String getTitulo(){
        return ReportUtils.TITULO;
    }
    public String getSubTitulo(){
        return ReportUtils.SUBTITULO;
    }
    public String getNomeEmpresa(){
        return ReportUtils.NOME_EMPRESA;
    }
    public String getCnpjEmpresa(){
        return ReportUtils.CNPJ_EMPRESA;
    }
    
}
