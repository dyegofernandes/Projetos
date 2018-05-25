/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisrh.modelo.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class FichaDeVisitaInstitucionalLGBT implements Serializable {

    @Id
    @SequenceGenerator(name = "FichaDeVisitaInstitucionalLGBT", sequenceName = "seq_fichaDeVisitaInstitucionalLGBT")
    @GeneratedValue(generator = "FichaDeVisitaInstitucionalLGBT")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataEmissao = new Date();

    @Size(max = 120)
    @NotBlank
    private String instituicao;

    private String naturezaInstituicao;

    private String telefone;

    private String endereco;

    @ManyToMany(targetEntity = ProfissionalDeReferenciaFichaVisita.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ProfissionalDeReferenciaFichaVisita> profissionais = new ArrayList<ProfissionalDeReferenciaFichaVisita>();

    @Column(columnDefinition = "Text")
    private String servicosOferecidos;

    @Column(columnDefinition = "Text")
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getNaturezaInstituicao() {
        return naturezaInstituicao;
    }

    public void setNaturezaInstituicao(String naturezaInstituicao) {
        this.naturezaInstituicao = naturezaInstituicao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ProfissionalDeReferenciaFichaVisita> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<ProfissionalDeReferenciaFichaVisita> profissionais) {
        this.profissionais = profissionais;
    }

    public String getServicosOferecidos() {
        return servicosOferecidos;
    }

    public void setServicosOferecidos(String servicosOferecidos) {
        this.servicosOferecidos = servicosOferecidos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FichaDeVisitaInstitucionalLGBT other = (FichaDeVisitaInstitucionalLGBT) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
