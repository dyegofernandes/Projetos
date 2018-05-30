/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class SubFuncao implements Serializable {

    @Id
    @SequenceGenerator(name = "SubFuncao", sequenceName = "subFuncao_seq_id")
    @GeneratedValue(generator = "SubFuncao")
    private Long id;

    @NotBlank
    @Size(max = 260)
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "subfuncao")
    @NotAudited
    private List<AcaoOrcamentaria> acoes;

    private boolean ativo = true;

    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public Funcao getFuncao() {
//        return funcao;
//    }
//
//    public void setFuncao(Funcao funcao) {
//        this.funcao = funcao;
//    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<AcaoOrcamentaria> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<AcaoOrcamentaria> acoes) {
        this.acoes = acoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SubFuncao other = (SubFuncao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
