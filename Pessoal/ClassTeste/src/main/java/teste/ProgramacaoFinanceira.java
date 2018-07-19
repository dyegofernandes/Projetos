/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class ProgramacaoFinanceira implements Serializable, Comparable<ProgramacaoFinanceira> {

    private Long id;

    private Meses mes;

    private Integer ano;

    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Meses getMes() {
        return mes;
    }

    public void setMes(Meses mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return mes.getDescricao().concat(" - ").concat(ano.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ProgramacaoFinanceira other = (ProgramacaoFinanceira) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ProgramacaoFinanceira o) {

        int retorno = this.ano.compareTo(o.ano);

        if(retorno==0){
            retorno = new Integer(this.mes.getNum()).compareTo(o.getMes().getNum());
        }


        return retorno;
    }

}
