/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juniel
 */
//@XmlRootElement
public class DenunciaVO {
    
//    @XmlElement public
    private Long id;

//    @XmlElement  public
    private String descricao;

//    @XmlElement 
    private String observacao;

//    @XmlElement 
    private String dataDenuncia;

//    @XmlElement 
    private String horaDenuncia;

//    @XmlElement 
    private String endereco;

//    @XmlElement 
    private String numero;

//    @XmlElement 
    private String complemento;

//    @XmlElement 
    private String cep;

//    @XmlElement 
    private String bairro;

//    @XmlElement 
    private String cidade;

//    @XmlElement 
    private String estado;

//    @XmlElement 
    private String formaDeViolencia;
    
//    @XmlElement 
    private String vitima;
    
//    @XmlElement 
    private Integer idadeVitima;
    
//    @XmlElement 
    private String agressor;
    
//    @XmlElement 
    private Integer idadeAgressor;
    
//    @XmlElement 
    private String demandante;
    
//    @XmlElement 
    private String tipo;
    
//    @XmlElement 
    private String latitude;
    
//    @XmlElement 
    private String longitude;
    
//    @XmlElement public 
    private List<ArquivoVO> arquivos = new ArrayList<ArquivoVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(String dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public String getHoraDenuncia() {
        return horaDenuncia;
    }

    public void setHoraDenuncia(String horaDenuncia) {
        this.horaDenuncia = horaDenuncia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormaDeViolencia() {
        return formaDeViolencia;
    }

    public void setFormaDeViolencia(String formaDeViolencia) {
        this.formaDeViolencia = formaDeViolencia;
    }

    public String getVitima() {
        return vitima;
    }

    public void setVitima(String vitima) {
        this.vitima = vitima;
    }

    public Integer getIdadeVitima() {
        return idadeVitima;
    }

    public void setIdadeVitima(Integer idadeVitima) {
        this.idadeVitima = idadeVitima;
    }

    public String getAgressor() {
        return agressor;
    }

    public void setAgressor(String agressor) {
        this.agressor = agressor;
    }

    public Integer getIdadeAgressor() {
        return idadeAgressor;
    }

    public void setIdadeAgressor(Integer idadeAgressor) {
        this.idadeAgressor = idadeAgressor;
    }

    public String getDemandante() {
        return demandante;
    }

    public void setDemandante(String demandante) {
        this.demandante = demandante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<ArquivoVO> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoVO> arquivos) {
        this.arquivos = arquivos;
    }
    
    
}
