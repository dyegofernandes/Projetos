/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.acessoApp.vos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class NotificacaoVO implements Serializable {

    private String anonimo;
    
    private AnimalVO animalVO;

    private ResponsavelVO responsavel;

    private String nomeEstabelecimento;

    private EnderecoVO endereco;

    private String observacoes;

    private List<SinalClinicoVO> sinaisClinicos = new ArrayList<SinalClinicoVO>();
    
    private List<ArquivoVO> arquivos = new ArrayList<ArquivoVO>();

    public String getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(String anonimo) {
        this.anonimo = anonimo;
    }

    public ResponsavelVO getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ResponsavelVO responsavel) {
        this.responsavel = responsavel;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public EnderecoVO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVO endereco) {
        this.endereco = endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<SinalClinicoVO> getSinaisClinicos() {
        return sinaisClinicos;
    }

    public void setSinaisClinicos(List<SinalClinicoVO> sinaisClinicos) {
        this.sinaisClinicos = sinaisClinicos;
    }

    public AnimalVO getAnimalVO() {
        return animalVO;
    }

    public void setAnimalVO(AnimalVO animalVO) {
        this.animalVO = animalVO;
    }

    public List<ArquivoVO> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoVO> arquivos) {
        this.arquivos = arquivos;
    }

}
