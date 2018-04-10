/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.modelo.dados;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "dados")
public class Banco implements Serializable {
    
    @Id
    @SequenceGenerator(schema = "dados", allocationSize = 1, name = "Banco", sequenceName = "dados.seq_banco_id")
    @GeneratedValue(generator = "Banco")
    private Long id;
    
    @Size(max = 3)
    @NotBlank
    private String codigo;
    
    @Size(max = 1)
    private String dv;
    
    @Size(max = 50)
    @NotBlank
    private String nome;
    
    @Size(max = 14)
    private String sigla;
    
    @NotAudited
    @OneToMany(mappedBy = "banco")
    private List<Convenio> convenios;
    
    @NotAudited
    @OneToMany(mappedBy = "emissor")
    private List<Convenio> conveniosEmissor;
    
    @NotAudited
    @OneToMany(mappedBy = "banco")
    private List<Deposito> depostidos;
    
    @NotAudited
    @OneToMany(mappedBy = "banco")
    private List<Boleto> boletos;
    
    public List<Convenio> getConvenios() {
        return convenios;
    }
    
    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
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
    
    public String getDv() {
        return dv;
    }
    
    public void setDv(String dv) {
        this.dv = dv;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public List<Convenio> getConveniosEmissor() {
        return conveniosEmissor;
    }
    
    public void setConveniosEmissor(List<Convenio> conveniosEmissor) {
        this.conveniosEmissor = conveniosEmissor;
    }
    
    public List<Deposito> getDepostidos() {
        return depostidos;
    }
    
    public void setDepostidos(List<Deposito> depostidos) {
        this.depostidos = depostidos;
    }
    
    public List<Boleto> getBoletos() {
        return boletos;
    }
    
    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
    
    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Banco other = (Banco) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
