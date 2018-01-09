/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.util.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class DenunciaVO {

    private Long id;

    private String descricao;

    private String observacao;

    private String dataDenuncia;

    private String horaDenuncia;

    private String endereco;

    private String numero;

    private String complemento;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    private String formaDeViolencia;

    private String vitima;

    private String idadeVitima;

    private String agressor;

    private String idadeAgressor;

    private String demandante;

    private String tipo;

    private String situacao;

    private String latitude;

    private String longitude;

    private List<ArquivoVO> arquivos = new ArrayList<ArquivoVO>();

    private String imei;

    private String cpfUsuario;

    private String unidade;

    public DenunciaVO() {

    }

    public DenunciaVO(Denuncia denuncia) {
        unidade = denuncia.getUnidade() != null ? denuncia.getUnidade().getNome() : null;
        dataDenuncia = Utils.convertDateToString(denuncia.getDataDenuncia(), "dd/MM/yyyy");
        horaDenuncia = Utils.convertDateToString(denuncia.getHoraDenuncia(), "HH:mm");
        id = denuncia.getId();
        descricao = denuncia.getDescricao();
        observacao = denuncia.getObservacao();
        endereco = denuncia.getEndereco().getEndereco();
        numero = denuncia.getEndereco().getNumero();
        complemento = denuncia.getEndereco().getComplemento();
        cep = denuncia.getEndereco().getCep();
        bairro = denuncia.getEndereco().getBairro().getNome();
        cidade = denuncia.getEndereco().getBairro().getCidade().getNome();
        formaDeViolencia = denuncia.getFormaDeViolencia().getDescricao();
        vitima = denuncia.getVitima();
        idadeVitima = denuncia.getIdadeVitima() != null ? denuncia.getIdadeVitima().toString() : "";
        agressor = denuncia.getAgressor();
        idadeAgressor = denuncia.getIdadeAgressor() != null ? denuncia.getIdadeAgressor().toString() : "";
        demandante = denuncia.getDemandante() != null ? denuncia.getDemandante().getDescricao() : "";
        tipo = denuncia.getTipo() != null ? denuncia.getTipo().getDescricao() : "";
        situacao = denuncia.getSituacao() != null ? denuncia.getSituacao().getDescricao() : "";
    }

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public String getIdadeVitima() {
        return idadeVitima;
    }

    public void setIdadeVitima(String idadeVitima) {
        this.idadeVitima = idadeVitima;
    }

    public String getAgressor() {
        return agressor;
    }

    public void setAgressor(String agressor) {
        this.agressor = agressor;
    }

    public String getIdadeAgressor() {
        return idadeAgressor;
    }

    public void setIdadeAgressor(String idadeAgressor) {
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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

}
