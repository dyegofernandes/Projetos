/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.UnidadeDeMedida;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Juniel
 */
@Entity
public class DrogaOcorrenciaItem implements Serializable {

    @Id
    @SequenceGenerator(name = "DrogaOcorrenciaItem", sequenceName = "drogaOcorrenciaItem_id_seq")
    @GeneratedValue(generator = "DrogaOcorrenciaItem")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DrogaOcorrencia droga;

    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidade;

    private BigDecimal quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DrogaOcorrencia getDroga() {
        return droga;
    }

    public void setDroga(DrogaOcorrencia droga) {
        this.droga = droga;
    }

    public UnidadeDeMedida getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeDeMedida unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DrogaOcorrenciaItem other = (DrogaOcorrenciaItem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
