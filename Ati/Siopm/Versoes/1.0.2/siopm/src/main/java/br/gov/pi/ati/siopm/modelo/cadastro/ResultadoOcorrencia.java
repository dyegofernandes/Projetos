/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ResultadoOcorrencia implements Serializable {

    @Id
    @SequenceGenerator(name = "ResultadoOcorrencia", sequenceName = "resultadoOcorrencia_id_seq")
    @GeneratedValue(generator = "ResultadoOcorrencia")
    private Long id;

    @Size(max = 255)
//    @NotBlank
    private String codigo;

    @Size(max = 255)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private OrgaoRecebedor orgaoRecebedor;

    private boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull
    private GrupoResultadoOcorrencia grupo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoResultadoOcorrencia getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoResultadoOcorrencia grupo) {
        this.grupo = grupo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public OrgaoRecebedor getOrgaoRecebedor() {
        return orgaoRecebedor;
    }

    public void setOrgaoRecebedor(OrgaoRecebedor orgaoRecebedor) {
        this.orgaoRecebedor = orgaoRecebedor;
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
        final ResultadoOcorrencia other = (ResultadoOcorrencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

}
