/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.formulario.Deliberacao;
import br.gov.pi.ati.sisforms.modelo.formulario.Observacao;
import br.gov.pi.ati.sisforms.modelo.formulario.PautaDaReuniao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class AtaDeReuniaoListasVO {

    private List<ParticipanteVO> participantes = new ArrayList<ParticipanteVO>();

    private List<PautaDaReuniao> pautas = new ArrayList<PautaDaReuniao>();

    private List<Deliberacao> deliberacoes = new ArrayList<Deliberacao>();

    private List<Observacao> observacoes = new ArrayList<Observacao>();

    private List<PendenciaVO> pendencias = new ArrayList<PendenciaVO>();

    public List<ParticipanteVO> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipanteVO> participantes) {
        this.participantes = participantes;
    }

    public List<PautaDaReuniao> getPautas() {
        return pautas;
    }

    public void setPautas(List<PautaDaReuniao> pautas) {
        this.pautas = pautas;
    }

    public List<Deliberacao> getDeliberacoes() {
        return deliberacoes;
    }

    public void setDeliberacoes(List<Deliberacao> deliberacoes) {
        this.deliberacoes = deliberacoes;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    public List<PendenciaVO> getPendencias() {
        return pendencias;
    }

    public void setPendencias(List<PendenciaVO> pendencias) {
        this.pendencias = pendencias;
    }

    public AtaDeReuniaoListasVO() {
    }

}
