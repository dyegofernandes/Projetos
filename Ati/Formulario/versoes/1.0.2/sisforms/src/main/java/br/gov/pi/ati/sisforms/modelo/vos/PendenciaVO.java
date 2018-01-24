/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;
import br.gov.pi.ati.sisforms.util.Utils;
import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class PendenciaVO implements Serializable{

    private String orgao;
    
    private String pendencia;

    private String responsavel;

    private String dataPrevista;

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }


    public String getPendencia() {
        return pendencia;
    }

    public void setPendencia(String pendencia) {
        this.pendencia = pendencia;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public PendenciaVO(PendenciaIdentificada pendencia) {
        this.orgao = pendencia.getOrgao().getNome();
        this.pendencia = pendencia.getPendencia();
        this.responsavel = pendencia.getResponsavel();
        this.dataPrevista = Utils.convertDateToString(pendencia.getDataPrevista(), "dd/MM/yyyy");
    }

    public PendenciaVO() {

    }

}
