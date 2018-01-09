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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class NaturezaDeDespesa implements Serializable {

    @Id
    @SequenceGenerator(name = "NaturezaDeDespesa", sequenceName = "naturezaDeDespesa_seq_id")
    @GeneratedValue(generator = "NaturezaDeDespesa")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturezaDeDespesa naturezaDeDespesaPai;

    @NotBlank
    @Size(max = 260)
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "naturezaDeDespesaPai")
    private List<NaturezaDeDespesa> naturezes;

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

    public NaturezaDeDespesa getNaturezaDeDespesaPai() {
        return naturezaDeDespesaPai;
    }

    public void setNaturezaDeDespesaPai(NaturezaDeDespesa naturezaDeDespesaPai) {
        this.naturezaDeDespesaPai = naturezaDeDespesaPai;
    }

    public List<NaturezaDeDespesa> getNaturezes() {
        return naturezes;
    }

    public void setNaturezes(List<NaturezaDeDespesa> naturezes) {
        this.naturezes = naturezes;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final NaturezaDeDespesa other = (NaturezaDeDespesa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
