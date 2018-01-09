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
public class EventoVO {

    private Long id;

    private LocalEventoVO local = new LocalEventoVO();

    private String titulo;

    private String descricao;

    private String dataInicio;

    private String horaInicio;

    private String dataFim;

    private String horaFim;

    List<AgendaEventoVO> agenda = new ArrayList<AgendaEventoVO>();
    List<CategoriaEventoVO> categorias = new ArrayList<CategoriaEventoVO>();
    List<ValorEventoVO> valores = new ArrayList<ValorEventoVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalEventoVO getLocal() {
        return local;
    }

    public void setLocal(LocalEventoVO local) {
        this.local = local;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public List<AgendaEventoVO> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<AgendaEventoVO> agenda) {
        this.agenda = agenda;
    }

    public List<CategoriaEventoVO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEventoVO> categorias) {
        this.categorias = categorias;
    }

    public List<ValorEventoVO> getValores() {
        return valores;
    }

    public void setValores(List<ValorEventoVO> valores) {
        this.valores = valores;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
