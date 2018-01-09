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
public class LocalEventoVO {

    private Long id;

    private String nome;

    private TipoLocalVO tipo = new TipoLocalVO();

    private EnderecoVO endereco = new EnderecoVO();

    private List<FoneVO> fones = new ArrayList<FoneVO>();
    
    private List<DiasVisitacaoVO> horarioFuncionamento = new ArrayList<DiasVisitacaoVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoLocalVO getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocalVO tipo) {
        this.tipo = tipo;
    }

    public EnderecoVO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVO endereco) {
        this.endereco = endereco;
    }

    public List<FoneVO> getFones() {
        return fones;
    }

    public void setFones(List<FoneVO> fones) {
        this.fones = fones;
    }

    public List<DiasVisitacaoVO> getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(List<DiasVisitacaoVO> horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

}
