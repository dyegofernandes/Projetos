/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class MetaAcaoEstrategica implements Serializable {

    @Id
    @SequenceGenerator(name = "MetaAcaoEstrategica", sequenceName = "metaAcaoEstrategica_id_seq")
    @GeneratedValue(generator = "MetaAcaoEstrategica")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private AcaoEstrategica acaoEstrategica;

    @NotNull
    private Integer ano;

    @NotNull
    private BigDecimal valor;
}
