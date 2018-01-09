/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
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
//@Entity
public class ResultadoOcorrenciaAux implements Serializable {

    @Id
    @SequenceGenerator(name = "ResultadoOcorrencia", sequenceName = "resultadoOcorrencia_id_seq")
    @GeneratedValue(generator = "ResultadoOcorrencia")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ResultadoOcorrencia resultado;

    @Column(columnDefinition = "Text")
    private String observacao;

}
