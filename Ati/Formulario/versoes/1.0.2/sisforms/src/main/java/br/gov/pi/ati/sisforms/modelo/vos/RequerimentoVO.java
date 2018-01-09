/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.enums.AssuntoRequerimento;
import br.gov.pi.ati.sisforms.modelo.formulario.Requerimento;

/**
 *
 * @author Juniel
 */
public class RequerimentoVO {

    private String destinatario;

    private String requerente;

    private String matricula;

    private String cpf;

    private String telefone;

    private String cargo;

    private String area;

    private String assuntoFerias;

    private String assuntoComp;

    private String assuntoSolic;

    private String assuntoJust;

    private String assuntoOutros;

    private String solicitacao;

    public RequerimentoVO(Requerimento requerimento) {
        this.destinatario = requerimento.getDestinatario();
        this.requerente = requerimento.getRequerente();
        this.matricula = requerimento.getMatricula();
        this.cpf = requerimento.getCpf();
        this.telefone = requerimento.getTelefone();
        this.cargo = requerimento.getCargo();
        this.area = requerimento.getArea();
        this.assuntoFerias = requerimento.getAssuntoRequerimento() == AssuntoRequerimento.FERIAS ? "X" : "";
        this.assuntoComp = requerimento.getAssuntoRequerimento() == AssuntoRequerimento.COMPENSACAO ? "X" : "";
        this.assuntoJust  = requerimento.getAssuntoRequerimento() == AssuntoRequerimento.JUSTIFICATIVA_FALTA ? "X" : "";
        this.assuntoSolic = requerimento.getAssuntoRequerimento() == AssuntoRequerimento.SOLICITACAO_VALE ? "X" : "";
        this.assuntoOutros = requerimento.getAssuntoRequerimento() == AssuntoRequerimento.OUTROS ? "X" : "";
        this.solicitacao = requerimento.getSolicitacao();

    }
    
    public RequerimentoVO(){
        
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getRequerente() {
        return requerente;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public String getArea() {
        return area;
    }

    public String getAssuntoFerias() {
        return assuntoFerias;
    }

    public String getAssuntoComp() {
        return assuntoComp;
    }

    public String getAssuntoSolic() {
        return assuntoSolic;
    }

    public String getAssuntoJust() {
        return assuntoJust;
    }

    public String getAssuntoOutros() {
        return assuntoOutros;
    }

    public String getSolicitacao() {
        return solicitacao;
    }
    

}
