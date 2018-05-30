/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.cadastro.enums.IndicadorResultado;
import br.gov.pi.ati.modelo.cadastro.enums.TipoDeNaturezaReceita;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class NaturezaDeReceita implements Serializable {

    @Id
    @SequenceGenerator(name = "NaturezaDeReceita", sequenceName = "naturezaDeReceita_id_seq")
    @GeneratedValue(generator = "NaturezaDeReceita")
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Size(max = 250)
    @NotBlank
    private String nome;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoDeNaturezaReceita tipo;
    
    @Enumerated(EnumType.STRING)
    private IndicadorResultado indicadorDeResultado;

    private boolean ativo = true;
    
    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
    }

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

    public TipoDeNaturezaReceita getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeNaturezaReceita tipo) {
        this.tipo = tipo;
    }

    public IndicadorResultado getIndicadorDeResultado() {
        return indicadorDeResultado;
    }

    public void setIndicadorDeResultado(IndicadorResultado indicadorDeResultado) {
        this.indicadorDeResultado = indicadorDeResultado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
        final NaturezaDeReceita other = (NaturezaDeReceita) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
