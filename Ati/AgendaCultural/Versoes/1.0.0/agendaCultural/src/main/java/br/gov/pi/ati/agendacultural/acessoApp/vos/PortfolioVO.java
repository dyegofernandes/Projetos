/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp.vos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class PortfolioVO {

    private Long id;

    private TipoLocalVO tipo = new TipoLocalVO();

    private String localPortfolio;

    private EnderecoVO endereco = new EnderecoVO();

    private List<DiasVisitacaoVO> horarios = new ArrayList<DiasVisitacaoVO>();

    private List<HistoricosVO> historicos = new ArrayList<HistoricosVO>();

    private List<LinksVideosVO> urlVideos = new ArrayList<LinksVideosVO>();

    private List<FotosVO> fotos = new ArrayList<FotosVO>();

    private List<FoneVO> fones = new ArrayList<FoneVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoLocalVO getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocalVO tipo) {
        this.tipo = tipo;
    }

    public String getLocalPortfolio() {
        return localPortfolio;
    }

    public void setLocalPortfolio(String localPortfolio) {
        this.localPortfolio = localPortfolio;
    }

    public EnderecoVO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVO endereco) {
        this.endereco = endereco;
    }

    public List<DiasVisitacaoVO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<DiasVisitacaoVO> horarios) {
        this.horarios = horarios;
    }

    public List<HistoricosVO> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricosVO> historicos) {
        this.historicos = historicos;
    }

    public List<LinksVideosVO> getUrlVideos() {
        return urlVideos;
    }

    public void setUrlVideos(List<LinksVideosVO> urlVideos) {
        this.urlVideos = urlVideos;
    }

    public List<FotosVO> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotosVO> fotos) {
        this.fotos = fotos;
    }

    public List<FoneVO> getFones() {
        return fones;
    }

    public void setFones(List<FoneVO> fones) {
        this.fones = fones;
    }

    

}
