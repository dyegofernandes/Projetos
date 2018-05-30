/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro.vos;

import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class Filtros implements Serializable {

    private List<UnidadeOrcamentaria> unidadesOrcamentaria = new ArrayList<UnidadeOrcamentaria>();

    private UnidadeOrcamentaria unidadeOrcamentaria;

    private AcaoEstrategica acaoEstrategica;

    private ProgramaDeGoverno programaDeGoverno;

    private Produto produto;

    private Date dataInicial;

    private Date dataFinal;

    private String nome;

    private String codigo;

    public List<UnidadeOrcamentaria> getUnidadesOrcamentaria() {
        return unidadesOrcamentaria;
    }

    public void setUnidadesOrcamentaria(List<UnidadeOrcamentaria> unidadesOrcamentaria) {
        this.unidadesOrcamentaria = unidadesOrcamentaria;
    }

    public AcaoEstrategica getAcaoEstrategica() {
        return acaoEstrategica;
    }

    public void setAcaoEstrategica(AcaoEstrategica acaoEstrategica) {
        this.acaoEstrategica = acaoEstrategica;
    }

    public ProgramaDeGoverno getProgramaDeGoverno() {
        return programaDeGoverno;
    }

    public void setProgramaDeGoverno(ProgramaDeGoverno programaDeGoverno) {
        this.programaDeGoverno = programaDeGoverno;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UnidadeOrcamentaria getUnidadeOrcamentaria() {
        return unidadeOrcamentaria;
    }

    public void setUnidadeOrcamentaria(UnidadeOrcamentaria unidadeOrcamentaria) {
        this.unidadeOrcamentaria = unidadeOrcamentaria;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
