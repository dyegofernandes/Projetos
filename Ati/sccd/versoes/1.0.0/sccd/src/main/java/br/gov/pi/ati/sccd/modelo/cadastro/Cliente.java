/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.cadastro;

import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @SequenceGenerator(name = "Cliente", sequenceName = "cliente_id_seq")
    @GeneratedValue(generator = "Cliente")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;

    @Size(max = 50)
    @NotBlank
    private String cpfCnpj;

    @Size(max = 250)
    @NotBlank
    private String nome;

    private boolean isento = false;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<ContratoCliente> contratos;

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isIsento() {
        return isento;
    }

    public void setIsento(boolean isento) {
        this.isento = isento;
    }

    public List<ContratoCliente> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoCliente> contratos) {
        this.contratos = contratos;
    }

}
