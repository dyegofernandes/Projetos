/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.BairroGoogle;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
//@Entity
public class Bairro extends Circunscricao implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade cidade;

    @NotNull
    private BairroGoogle bairroGoogle = BairroGoogle.NAO;

    @OneToMany(targetEntity = Setor.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Setor> setores = new ArrayList<Setor>();
//
//    @NotAudited
//    @OneToMany(mappedBy = "bairro")
//    private List<Endereco> enderecos;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public BairroGoogle getBairroGoogle() {
        return bairroGoogle;
    }

    public void setBairroGoogle(BairroGoogle bairroGoogle) {
        this.bairroGoogle = bairroGoogle;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (getId() != null ? getId().hashCode() : 0);
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
        final Circunscricao other = (Circunscricao) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
}
