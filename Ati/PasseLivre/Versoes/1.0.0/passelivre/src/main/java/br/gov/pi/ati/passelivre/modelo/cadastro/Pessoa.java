/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.passelivre.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "Pessoa", sequenceName = "pessoa_id_seq")
    @GeneratedValue(generator = "Pessoa")
    private Long id;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 20)
    @NotBlank
    private String rg;

    @Size(max = 20)
    @NotBlank
    private String rg_orgao_expedidor;

    @Size(max = 2)
    @NotBlank
    private String rg_uf;

    private Integer rg_data_expedicao;

    private String cpf;

    private String mae;

    private Integer data_obito;
}
