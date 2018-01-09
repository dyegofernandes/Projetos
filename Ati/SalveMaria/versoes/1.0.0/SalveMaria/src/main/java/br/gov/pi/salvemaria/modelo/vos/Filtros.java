/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.enums.Demandante;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class Filtros {
    
    private Usuario usuario;

    private Unidade unidade;

    private String descricao;

    private Date dataDenunciaInicial;

    private Date dataDenunciaFinal;

    private Date horaDenunciaInicial;

    private Date horaDenunciaFinal;

    private FormasDeViolencia formaDeViolencia;

    private Situacao situacao;

    private Demandante demandante;

    private TipoDenuncia tipo;

    private Bairro bairro;

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDenunciaInicial() {
        return dataDenunciaInicial;
    }

    public void setDataDenunciaInicial(Date dataDenunciaInicial) {
        this.dataDenunciaInicial = dataDenunciaInicial;
    }

    public Date getDataDenunciaFinal() {
        return dataDenunciaFinal;
    }

    public void setDataDenunciaFinal(Date dataDenunciaFinal) {
        this.dataDenunciaFinal = dataDenunciaFinal;
    }

    public Date getHoraDenunciaInicial() {
        return horaDenunciaInicial;
    }

    public void setHoraDenunciaInicial(Date horaDenunciaInicial) {
        this.horaDenunciaInicial = horaDenunciaInicial;
    }

    public Date getHoraDenunciaFinal() {
        return horaDenunciaFinal;
    }

    public void setHoraDenunciaFinal(Date horaDenunciaFinal) {
        this.horaDenunciaFinal = horaDenunciaFinal;
    }

    public FormasDeViolencia getFormaDeViolencia() {
        return formaDeViolencia;
    }

    public void setFormaDeViolencia(FormasDeViolencia formaDeViolencia) {
        this.formaDeViolencia = formaDeViolencia;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Demandante getDemandante() {
        return demandante;
    }

    public void setDemandante(Demandante demandante) {
        this.demandante = demandante;
    }

    public TipoDenuncia getTipo() {
        return tipo;
    }

    public void setTipo(TipoDenuncia tipo) {
        this.tipo = tipo;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
