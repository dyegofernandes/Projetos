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
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaArmaVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaPessoaEnvolvidaVO;
import br.gov.pi.ati.siopm.modelo.vos.OcorrenciaVeiculoVO;
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
public class OcorrenciaConsultaMB extends AbstractBaseBean<Ocorrencia> implements Serializable {

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosVO filtrosDeBusca;

    private List<OcorrenciaArmaVO> ocorrenciasArmas;

    private List<OcorrenciaPessoaEnvolvidaVO> ocorrenciasPessoas;

    private List<OcorrenciaVeiculoVO> ocorrenciasVeiculos;

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
        ocorrenciasArmas = new ArrayList<OcorrenciaArmaVO>();
        ocorrenciasPessoas = new ArrayList<OcorrenciaPessoaEnvolvidaVO>();
        ocorrenciasVeiculos = new ArrayList<OcorrenciaVeiculoVO>();
    }

    public List<OcorrenciaArmaVO> getOcorrenciasArmas() {
        return ocorrenciasArmas;
    }

    public void setOcorrenciasArmas(List<OcorrenciaArmaVO> ocorrenciasArmas) {
        this.ocorrenciasArmas = ocorrenciasArmas;
    }

    public List<OcorrenciaPessoaEnvolvidaVO> getOcorrenciasPessoas() {
        return ocorrenciasPessoas;
    }

    public void setOcorrenciasPessoas(List<OcorrenciaPessoaEnvolvidaVO> ocorrenciasPessoas) {
        this.ocorrenciasPessoas = ocorrenciasPessoas;
    }

    public List<OcorrenciaVeiculoVO> getOcorrenciasVeiculos() {
        return ocorrenciasVeiculos;
    }

    public void setOcorrenciasVeiculos(List<OcorrenciaVeiculoVO> ocorrenciasVeiculos) {
        this.ocorrenciasVeiculos = ocorrenciasVeiculos;
    }

    public void buscarArmas() {
        ocorrenciasArmas = getBO().armasPorOcorrencias(filtrosDeBusca);
    }

    public void buscarPessoas() {
        ocorrenciasPessoas = getBO().pessoasPorOcorrencias(filtrosDeBusca);
    }

    public void buscarVeiculos() {
        ocorrenciasVeiculos = getBO().veiculosPorOcorrencias(filtrosDeBusca);
    }
}
