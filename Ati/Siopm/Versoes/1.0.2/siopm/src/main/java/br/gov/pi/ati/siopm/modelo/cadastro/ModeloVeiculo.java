/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.TipoVeiculo;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ModeloVeiculo implements Serializable {

    @Id
    @SequenceGenerator(name = "ModeloVeiculo", sequenceName = "modeloVeiculo_id_seq")
    @GeneratedValue(generator = "ModeloVeiculo")
    private Long id;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MarcaVeiculo marca;

    @NotAudited
    @OneToMany(mappedBy = "modelo")
    private List<QualificacaoDeVeiculo> qualiticacoes;

    @NotAudited
    @OneToMany(mappedBy = "marcaModelo")
    private List<Viatura> viaturas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MarcaVeiculo getMarca() {
        return marca;
    }

    public void setMarca(MarcaVeiculo marca) {
        this.marca = marca;
    }

    public List<QualificacaoDeVeiculo> getQualiticacoes() {
        return qualiticacoes;
    }

    public void setQualiticacoes(List<QualificacaoDeVeiculo> qualiticacoes) {
        this.qualiticacoes = qualiticacoes;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public List<Viatura> getViaturas() {
        return viaturas;
    }

    public void setViaturas(List<Viatura> viaturas) {
        this.viaturas = viaturas;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ModeloVeiculo other = (ModeloVeiculo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
