/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
public class RequisicaoDeMaterial implements Serializable {

    @Id
    @SequenceGenerator(name = "RequisicaoDeMaterial", sequenceName = "seq_requisicaoDeMaterial")
    @GeneratedValue(generator = "RequisicaoDeMaterial")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @Size(max = 250)
    @NotBlank
    private String gerencia;
    
    @Size(max = 250)
    @NotBlank
    private String coordenadoria;
    
    @Size(max = 250)
    private String requisitadoPor;
    
    @Size(max = 250)
    private String autorizadoPor;
    
    @Size(max = 250)
    private String visto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date atendido;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaEmissao = new Date();
    
     @NotNull
    private Situacao situacao = Situacao.NOVA;
    
    @NotAudited
    @OneToMany(mappedBy = "requisicaoDeMaterial")
    private List<ItemDaRequisicaoDeMaterial> ItemDaRequisicaoDeMateriais;

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

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(String coordenadoria) {
        this.coordenadoria = coordenadoria;
    }

    public Date getDataDaEmissao() {
        return dataDaEmissao;
    }

    public void setDataDaEmissao(Date dataDaEmissao) {
        this.dataDaEmissao = dataDaEmissao;
    }

    public List<ItemDaRequisicaoDeMaterial> getItemDaRequisicaoDeMateriais() {
        return ItemDaRequisicaoDeMateriais;
    }

    public void setItemDaRequisicaoDeMateriais(List<ItemDaRequisicaoDeMaterial> ItemDaRequisicaoDeMateriais) {
        this.ItemDaRequisicaoDeMateriais = ItemDaRequisicaoDeMateriais;
    }

    public String getRequisitadoPor() {
        return requisitadoPor;
    }

    public void setRequisitadoPor(String requisitadoPor) {
        this.requisitadoPor = requisitadoPor;
    }

    public String getAutorizadoPor() {
        return autorizadoPor;
    }

    public void setAutorizadoPor(String autorizadoPor) {
        this.autorizadoPor = autorizadoPor;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public Date getAtendido() {
        return atendido;
    }

    public void setAtendido(Date atendido) {
        this.atendido = atendido;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final RequisicaoDeMaterial other = (RequisicaoDeMaterial) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    

}
