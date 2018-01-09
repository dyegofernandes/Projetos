/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.pagamento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class PagtosRealizados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String codigoBanco;

    @Size(max = 255)
    private String codigoOp;

    @Size(max = 255)
    private String favorecido;

    @Size(max = 255)
    private String dtNascimento;

    @Size(max = 255)
    private String rg;

    @Size(max = 255)
    private String inscricao;

    @Size(max = 255)
    private String valorOp;

    @Size(max = 255)
    private String situacaoOp;

    @Size(max = 255)
    private String motivo;

    @Size(max = 255)
    private String funcaoFavorecido;

}
