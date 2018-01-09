/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import br.gov.pi.siste.modelo.cadastro.enums.Categoria;
import br.gov.pi.siste.modelo.cadastro.enums.Previdencia;

/**
 *
 * @author Juniel
 */
@Entity
public class DadosFuncionais implements Serializable {

    @Id
    @SequenceGenerator(name = "DadosFuncionais", sequenceName = "seq_dadosFuncionais")
    @GeneratedValue(generator = "DadosFuncionais")
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInclusao = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Unidade unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cargo cargo;

    @NotNull
    private Categoria categoria = Categoria.TRABALHADORES_EVENTUAIS;

    @NotNull
    private Integer qtdDepIr = 0;

    @NotNull
    private Previdencia previdencia = Previdencia.INSS;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private CargaHoraria cargaHoraria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getQtdDepIr() {
        return qtdDepIr;
    }

    public void setQtdDepIr(Integer qtdDepIr) {
        this.qtdDepIr = qtdDepIr;
    }

    public Previdencia getPrevidencia() {
        return previdencia;
    }

    public void setPrevidencia(Previdencia previdencia) {
        this.previdencia = previdencia;
    }

    public CargaHoraria getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CargaHoraria cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DadosFuncionais other = (DadosFuncionais) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
