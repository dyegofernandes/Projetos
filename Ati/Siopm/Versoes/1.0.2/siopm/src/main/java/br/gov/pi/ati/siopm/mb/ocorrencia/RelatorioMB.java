/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.mb.ocorrencia;

import br.gov.pi.ati.siopm.bo.ocorrencia.OcorrenciaBO;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaVO;
import br.gov.pi.ati.siopm.util.SessaoUtils;
import com.xpert.core.crud.AbstractBaseBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RelatorioMB extends AbstractBaseBean<Ocorrencia> implements Serializable {

    private Usuario usuarioAtual = SessaoUtils.getUser();
    
    private FiltrosVO filtrosDeBusca;

    private List<OcorrenciaVO> ocorrencias;

    

    public List<OcorrenciaVO> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<OcorrenciaVO> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public FiltrosVO getFiltrosDeBusca() {
        return filtrosDeBusca;
    }

    public void setFiltrosDeBusca(FiltrosVO filtrosDeBusca) {
        this.filtrosDeBusca = filtrosDeBusca;
    }

    @EJB
    private OcorrenciaBO ocorrenciaBO;

    @Override
    public OcorrenciaBO getBO() {
        return ocorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtrosDeBusca = new FiltrosVO();
        filtrosDeBusca.setUsuario(usuarioAtual);
    }

    public void relatorioPorOpm() {
        ocorrencias = new ArrayList<OcorrenciaVO>();
        ocorrencias = getBO().ocorrenciasVO(filtrosDeBusca);
    }

}
