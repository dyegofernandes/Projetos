/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.cadastro;

import br.gov.pi.ati.sisforms.modelo.enums.StatusPontoAcesso;
import br.gov.pi.ati.sisforms.modelo.enums.TipoDeAcesso;
import br.gov.pi.ati.sisforms.modelo.monitoramento.InterrupcaoPontoAcesso;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class PontoAcesso implements Serializable {

    @Id
    @SequenceGenerator(name = "PontoAcesso", sequenceName = "seq_pontoAcesso")
    @GeneratedValue(generator = "PontoAcesso")
    private Long id;

    @NotBlank
    @Size(max = 250)
    private String local;

    @Size(max = 250)
    private String serialNumer;

    @NotBlank
    @Size(max = 250)
    private String modelo;
    
    @Temporal(TemporalType.DATE)
    private Date dataInstalacao;
    
    @Size(max = 250)
    private String municipio;
    
    @Size(max = 250)
    private String tombo;
    
    private String latidude;
    
    private String longitude;
    
    @Size(max = 250)
    private String endereco;
    
    private TipoDeAcesso tipoAcesso;
    
    private StatusPontoAcesso status;
    
     @NotAudited
    @OneToMany(mappedBy = "indentificacao")
    private List<InterrupcaoPontoAcesso> interrupcoes;

    @Override
    public String toString() {
        return local; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSerialNumer() {
        return serialNumer;
    }

    public void setSerialNumer(String serialNumer) {
        this.serialNumer = serialNumer;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTombo() {
        return tombo;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public String getLatidude() {
        return latidude;
    }

    public void setLatidude(String latidude) {
        this.latidude = latidude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public StatusPontoAcesso getStatus() {
        return status;
    }

    public void setStatus(StatusPontoAcesso status) {
        this.status = status;
    }

    public List<InterrupcaoPontoAcesso> getInterrupcoes() {
        return interrupcoes;
    }

    public void setInterrupcoes(List<InterrupcaoPontoAcesso> interrupcoes) {
        this.interrupcoes = interrupcoes;
    }

    public TipoDeAcesso getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(TipoDeAcesso tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PontoAcesso other = (PontoAcesso) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
