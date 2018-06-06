/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import br.gov.pi.ati.sisdh.modelo.cadastro.enums.SimOuNaoOutros;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Solicitante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class FichaDeVisitaDomiciliar implements Serializable {

    @Id
    @SequenceGenerator(name = "FichaDeVisitaDomiciliar", sequenceName = "seq_fichaDeVisitaDomiciliar")
    @GeneratedValue(generator = "FichaDeVisitaDomiciliar")
    private Long id;

    @Size(max = 255)
    @NotBlank
    private String usuario;

    @Size(max = 50)
    @NotBlank
    private String nc;

    @Size(max = 255)
    @NotBlank
    private String endereco;

    @Size(max = 255)
    @NotBlank
    private String bairro;

    @Size(max = 255)
    @NotBlank
    private String cidade;

    @Size(max = 255)
    @NotBlank
    private String telefone;

    @NotNull
    private Solicitante solicitante;

    private String solicitanteOutroA;

    @NotNull
    private SimOuNaoOutros residencia;

    private String residenciaOutroA;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataVisita;

    @Size(max = 255)
    private String agendamento;

    @Size(max = 255)
    private String equipe;

    @ManyToMany(targetEntity = ProcedimentoFichaDeVisitaLgbt.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ProcedimentoFichaDeVisitaLgbt> procedimentos = new ArrayList<ProcedimentoFichaDeVisitaLgbt>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public String getSolicitanteOutroA() {
        return solicitanteOutroA;
    }

    public void setSolicitanteOutroA(String solicitanteOutroA) {
        this.solicitanteOutroA = solicitanteOutroA;
    }

    public SimOuNaoOutros getResidencia() {
        return residencia;
    }

    public void setResidencia(SimOuNaoOutros residencia) {
        this.residencia = residencia;
    }

    public String getResidenciaOutroA() {
        return residenciaOutroA;
    }

    public void setResidenciaOutroA(String residenciaOutroA) {
        this.residenciaOutroA = residenciaOutroA;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(String agendamento) {
        this.agendamento = agendamento;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public List<ProcedimentoFichaDeVisitaLgbt> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<ProcedimentoFichaDeVisitaLgbt> procedimentos) {
        this.procedimentos = procedimentos;
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
        final FichaDeVisitaDomiciliar other = (FichaDeVisitaDomiciliar) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
