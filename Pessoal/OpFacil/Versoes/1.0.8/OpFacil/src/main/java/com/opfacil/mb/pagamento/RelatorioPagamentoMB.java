package com.opfacil.mb.pagamento;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.VOs.PagamentoVO;
import com.opfacil.bo.cadastro.EmpresaBO;
import com.opfacil.bo.documentos.DownloadArquivosBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.pagamento.PagamentoBO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.documentos.Arquivo;
import com.opfacil.modelo.pagamento.Pagamento;
import com.opfacil.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.proxy.HibernateProxy;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class RelatorioPagamentoMB extends AbstractBaseBean<Pagamento> implements Serializable {

    @EJB
    private PagamentoBO pagamentoBO;
    
    @EJB
    private EmpresaBO empresaBO;
    
    @EJB
    private DownloadArquivosBO downloadBO;
    
    private List<Empresa> empresas;

    FiltroDeBusca filtros;

    List<PagamentoVO> pagamentos = new ArrayList<PagamentoVO>();
    
    List<PagamentoVO> pagamentosFiltrados = new ArrayList<PagamentoVO>();
    
    private FiltroDeBusca campoDeBusca;

    @Override
    public PagamentoBO getBO() {
        return pagamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtros = new FiltroDeBusca();
        filtros.setUsuario(SessaoUtils.getUser());
        pagamentos = pagamentoBO.getPagamentosRealizados(filtros);
        empresas = empresaBO.getListEmpresasAutorizadas(SessaoUtils.getUser());
    }

    public List<PagamentoVO> getPagamentos() {
        return pagamentos;
    }

    public List<PagamentoVO> getPagamentosFiltrados() {
        return pagamentosFiltrados;
    }

    public void setPagamentosFiltrados(List<PagamentoVO> pagamentosFiltrados) {
        this.pagamentosFiltrados = pagamentosFiltrados;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public FiltroDeBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroDeBusca filtros) {
        this.filtros = filtros;
    }

    public FiltroDeBusca getCampoDeBusca() {
        return campoDeBusca;
    }

    public void setCampoDeBusca(FiltroDeBusca campoDeBusca) {
        this.campoDeBusca = campoDeBusca;
    }

    public void buscar() {
        filtros.setUsuario(SessaoUtils.getUser());
        pagamentos = pagamentoBO.getPagamentosRealizados(filtros);
    }

    public StreamedContent downloadArquivo(Integer cdOp) throws IOException {
        Arquivo arquivo = downloadBO.consultarArquivo(cdOp);
        
        if (arquivo != null) {
            if (arquivo instanceof HibernateProxy) {
                HibernateProxy proxy = (HibernateProxy) arquivo;
                arquivo = (Arquivo) proxy.getHibernateLazyInitializer().getImplementation();
            }
            
            String nomeArquivo = arquivo.getNome();
            String extensaoArquivo = arquivo.getExtensao();
            
            File file = File.createTempFile(nomeArquivo, extensaoArquivo);
            
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(arquivo.getConteudo());
            outputStream.flush();
            outputStream.close();
            
            return new DefaultStreamedContent(new FileInputStream(file), extensaoArquivo, nomeArquivo);
        } else {
            FacesMessageUtils.error("Não existe culpom para esta Op!!");
            return null;
        }
    }
}
