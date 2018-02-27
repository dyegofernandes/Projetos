/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.servicos;

import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class CriacaoEmail implements Serializable {

    @Id
    @SequenceGenerator(name = "CriacaoEmail", allocationSize = 1, sequenceName = "seq_criacaoEmail")
    @GeneratedValue(generator = "CriacaoEmail")
    private Long id;
    
    private String nome;
    
    
    
    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.NOVA;
}
