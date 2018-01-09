/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.SituacaoVeiculo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class QualificacaoDeVeiculo implements Serializable {

    @Id
    @SequenceGenerator(name = "QualificacaoDeVeiculo", sequenceName = "qualificacaoDeVeiculo_id_seq")
    @GeneratedValue(generator = "QualificacaoDeVeiculo")
    private Long id;

    @Size(max = 10)
    private String placa;

    @Size(max = 20)
    private String chassi;

    @ManyToOne(fetch = FetchType.LAZY)
    private ModeloVeiculo modelo;

    private String cor;

    private Integer fabricacaoAno;

    private Integer modeloAno;

    private String municipio;

    @Size(max = 260)
    private String proprietario;

    @Size(max = 20)
    private String telefoneProprietario;

    private SituacaoVeiculo situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public ModeloVeiculo getModelo() {
        return modelo;
    }

    public void setModelo(ModeloVeiculo modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getFabricacaoAno() {
        return fabricacaoAno;
    }

    public void setFabricacaoAno(Integer fabricacaoAno) {
        this.fabricacaoAno = fabricacaoAno;
    }

    public Integer getModeloAno() {
        return modeloAno;
    }

    public void setModeloAno(Integer modeloAno) {
        this.modeloAno = modeloAno;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getTelefoneProprietario() {
        return telefoneProprietario;
    }

    public void setTelefoneProprietario(String telefoneProprietario) {
        this.telefoneProprietario = telefoneProprietario;
    }

    public SituacaoVeiculo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoVeiculo situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QualificacaoDeVeiculo other = (QualificacaoDeVeiculo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return placa; //To change body of generated methods, choose Tools | Templates.
    }

}
