/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.SituacaoObjeto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class ObjetoApreendido implements Serializable {

    @Id
    @SequenceGenerator(name = "ObjetoApreendido", sequenceName = "objetoApreendido_seq_id")
    @GeneratedValue(generator = "ObjetoApreendido")
    private Long id;

    @Size(max = 260)
    private String descricao;

    private Integer quantidade;

    private String marcaObjeto;

    private String modelo;

    private String destino;

    private String destinatario;

    private SituacaoObjeto situacao;

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
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarcaObjeto() {
        return marcaObjeto;
    }

    public void setMarcaObjeto(String marcaObjeto) {
        this.marcaObjeto = marcaObjeto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public SituacaoObjeto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoObjeto situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ObjetoApreendido other = (ObjetoApreendido) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
