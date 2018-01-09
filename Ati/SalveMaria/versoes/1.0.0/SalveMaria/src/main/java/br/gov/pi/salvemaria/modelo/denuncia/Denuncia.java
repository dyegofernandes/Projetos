/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.denuncia;

import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.enums.Demandante;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Denuncia implements Serializable {

    @Id
    @SequenceGenerator(name = "Denuncia", sequenceName = "seq_denuncia")
    @GeneratedValue(generator = "Denuncia")
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Unidade unidade;

    @NotBlank
    @Size(max = 80)
    private String descricao;

    @NotBlank
    @Size(max = 400)
    private String observacao;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDenuncia;

    @Temporal(TemporalType.TIME)
    private Date horaDenuncia;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @NotNull
    private FormasDeViolencia formaDeViolencia;

    @NotNull
    private Situacao situacao = Situacao.NOVA;
    
    @Size(max = 400)
    private String descricaoAtendimento;
    
    @Size(max = 100)
    private String vitima;
    
    private Integer idadeVitima;
    
    @Size(max = 100)
    private String agressor;
    
    private Integer idadeAgressor;
    
    @NotNull
    private Demandante demandante = Demandante.ANONIMO;
    
    @NotNull
    private TipoDenuncia tipo = TipoDenuncia.DENUNCIA;

    @NotAudited
    @OneToMany(mappedBy = "denuncia")
    private List<Arquivo> arquivos;

    @Override
    public String toString() {
        return descricao; 
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
        if(descricao!=null){
            descricao = descricao.trim().toUpperCase();
        }
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        if(observacao!=null){
            observacao = observacao.trim().toUpperCase();
        }
        this.observacao = observacao;
    }

    public Date getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Date dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public Date getHoraDenuncia() {
        return horaDenuncia;
    }

    public void setHoraDenuncia(Date horaDenuncia) {
        this.horaDenuncia = horaDenuncia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public FormasDeViolencia getFormaDeViolencia() {
        return formaDeViolencia;
    }

    public void setFormaDeViolencia(FormasDeViolencia formaDeViolencia) {
        this.formaDeViolencia = formaDeViolencia;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getVitima() {
        return vitima;
    }

    public void setVitima(String vitima) {
        if(vitima!=null){
            vitima = vitima.trim().toUpperCase();
        }
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
        if(agressor!=null){
            agressor = agressor.trim().toUpperCase();
        }
        this.agressor = agressor;
    }

    public Integer getIdadeAgressor() {
        return idadeAgressor;
    }

    public void setIdadeAgressor(Integer idadeAgressor) {
        this.idadeAgressor = idadeAgressor;
    }

    public Demandante getDemandante() {
        return demandante;
    }

    public void setDemandante(Demandante demandante) {
        this.demandante = demandante;
    }

    public TipoDenuncia getTipo() {
        return tipo;
    }

    public void setTipo(TipoDenuncia tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Denuncia other = (Denuncia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
