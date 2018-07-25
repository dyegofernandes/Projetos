package br.gov.pi.ati.mb;

import br.gov.pi.ati.bo.orcamento.ExecucaoOrcamentariaBO;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;
import br.gov.pi.ati.util.SessaoUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.map.MapModel;

/**
 * Como esse managed bean tem o escopo de "Application" e a opcao "eager = true"
 * o metodo "@PostConstruct" sera chamado ao iniciar a aplicacao
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DashBoardMB implements Serializable {
    
    @EJB
    private ExecucaoOrcamentariaBO execucaoBO;
    
    private Usuario usuarioAtual;
    
    private DashboardModel model;
        
    private List<ExecucaoOrcamentaria> execucoes;
    
    @PostConstruct
    public void init() {
        usuarioAtual = SessaoUtils.getUser();
        
        Filtros filtros = new Filtros();
        
        List<UnidadeOrcamentaria> unidades = execucaoBO.getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());
        
        filtros.setUnidadesOrcamentaria(unidades);
        
//        execucoes = execucaoBO.listar(filtros);
        
        DashboardColumn column1 = new DefaultDashboardColumn();
        
        DashboardColumn column2 = new DefaultDashboardColumn();
//        DashboardColumn column3 = new DefaultDashboardColumn();

        column1.addWidget("atalhos");
        
        column2.addWidget("execucao");

//        column3.addWidget("denuncias");
        model = new DefaultDashboardModel();
        
        model.addColumn(column1);
        model.addColumn(column2);
//        model.addColumn(column3);
    }
    
    public List<ExecucaoOrcamentaria> getExecucoes() {
        return execucoes;
    }
    
    public void setExecucoes(List<ExecucaoOrcamentaria> execucoes) {
        this.execucoes = execucoes;
    }

    public DashboardModel getModel() {
        return model;
    }

    public void setModel(DashboardModel model) {
        this.model = model;
    }
    
}
