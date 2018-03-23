/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.servicos;

import br.gov.pi.ati.sisforms.modelo.enums.TipoLocal;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel, Nilson, Samuel, Yago
 */
@Entity
public class LocalReserva implements Serializable {
    
        @Id
    @SequenceGenerator(name = "Local", allocationSize = 1, sequenceName = "local_id_seq")
    @GeneratedValue(generator = "Local")
    private Long id;
    
    @Size(max = 200)
    @NotBlank
    private String nome;
    
    @NotAudited
    @OneToMany(mappedBy = "local")
    private List<ReservaLocal> reservas;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoLocal tipo;
    
    @NotNull
    private Integer quantidadeLugares;
    
    
    private Boolean ativo;

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

    public List<ReservaLocal> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaLocal> reservas) {
        this.reservas = reservas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public TipoLocal getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(Integer quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LocalReserva other = (LocalReserva) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
