/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.formulario;

import br.gov.pi.ati.sisdh.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Usuario;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class AtaDeReuniao implements Serializable {

    @Id
    @SequenceGenerator(name = "AtaDeReuniao", sequenceName = "seq_ataDeReuniao")
    @GeneratedValue(generator = "AtaDeReuniao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Orgao orgao;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataDaReuniao = new Date();

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date horaInicio = new Date();

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date horaTermino;

    @Size(max = 255)
    @NotBlank
    private String localReuniao;

    @Size(max = 255)
    private String redator;

    @Size(max = 255)
    @NotBlank
    private String assunto;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String resumoReuniao;

    @Temporal(TemporalType.DATE)
    private Date dataDaProximaReuniao;

    @Temporal(TemporalType.TIME)
    private Date horaDaProximaReuniao;

    @Size(max = 255)
    private String localProximaReuniao;

    @NotAudited
    @OneToMany(mappedBy = "ataDeReuniao")
    private List<Participante> participantes;

    @NotAudited
    @OneToMany(mappedBy = "ataDeReuniao")
    private List<PautaDaReuniao> pautasDaReuniao;

    @NotAudited
    @OneToMany(mappedBy = "ataDeReuniao")
    private List<Deliberacao> deliberacoes;

    @NotAudited
    @OneToMany(mappedBy = "ataDeReuniao")
    private List<Observacao> observacoes;

    @NotAudited
    @OneToMany(mappedBy = "ataDeReuniao")
    private List<PendenciaIdentificada> pendenciasIdentificadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Date getDataDaReuniao() {
        return dataDaReuniao;
    }

    public void setDataDaReuniao(Date dataDaReuniao) {
        this.dataDaReuniao = dataDaReuniao;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getLocalReuniao() {
        return localReuniao;
    }

    public void setLocalReuniao(String localReuniao) {
        this.localReuniao = localReuniao;
    }

    public String getRedator() {
        return redator;
    }

    public void setRedator(String redator) {
        this.redator = redator;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getDataDaProximaReuniao() {
        return dataDaProximaReuniao;
    }

    public void setDataDaProximaReuniao(Date dataDaProximaReuniao) {
        this.dataDaProximaReuniao = dataDaProximaReuniao;
    }

    public Date getHoraDaProximaReuniao() {
        return horaDaProximaReuniao;
    }

    public void setHoraDaProximaReuniao(Date horaDaProximaReuniao) {
        this.horaDaProximaReuniao = horaDaProximaReuniao;
    }

    public String getLocalProximaReuniao() {
        return localProximaReuniao;
    }

    public void setLocalProximaReuniao(String localProximaReuniao) {
        this.localProximaReuniao = localProximaReuniao;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<PautaDaReuniao> getPautasDaReuniao() {
        return pautasDaReuniao;
    }

    public void setPautasDaReuniao(List<PautaDaReuniao> pautasDaReuniao) {
        this.pautasDaReuniao = pautasDaReuniao;
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

    public List<PendenciaIdentificada> getPendenciasIdentificadas() {
        return pendenciasIdentificadas;
    }

    public void setPendenciasIdentificadas(List<PendenciaIdentificada> pendenciasIdentificadas) {
        this.pendenciasIdentificadas = pendenciasIdentificadas;
    }

    public String getResumoReuniao() {
        return resumoReuniao;
    }

    public void setResumoReuniao(String resumoReuniao) {
        this.resumoReuniao = resumoReuniao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AtaDeReuniao other = (AtaDeReuniao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

