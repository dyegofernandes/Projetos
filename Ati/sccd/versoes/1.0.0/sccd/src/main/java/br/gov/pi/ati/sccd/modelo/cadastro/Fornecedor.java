/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.cadastro;

import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
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
public class Fornecedor implements Serializable {

    @Id
    @SequenceGenerator(name = "Fornecedor", sequenceName = "fornecedor_id_seq")
    @GeneratedValue(generator = "Fornecedor")
    private Long id;

    @Size(max = 250)
    @NotBlank
    private String autoridadeCertificadora;

    @Size(max = 250)
    @NotBlank
    private String emailAutoridadeCertificadora;

    @Size(max = 250)
    @NotBlank
    private String autoridadeRegistro;

    @Size(max = 250)
    @NotBlank
    private String emailAutoridadeRegistro;

    @Size(max = 50)
    @NotBlank
    private String telefoneAutoridadeRegistro;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<ContratoFornecedor> contratos;

    @Override
    public String toString() {
        return autoridadeCertificadora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutoridadeCertificadora() {
        return autoridadeCertificadora;
    }

    public void setAutoridadeCertificadora(String autoridadeCertificadora) {
        this.autoridadeCertificadora = autoridadeCertificadora;
    }

    public String getEmailAutoridadeCertificadora() {
        return emailAutoridadeCertificadora;
    }

    public void setEmailAutoridadeCertificadora(String emailAutoridadeCertificadora) {
        this.emailAutoridadeCertificadora = emailAutoridadeCertificadora;
    }

    public String getAutoridadeRegistro() {
        return autoridadeRegistro;
    }

    public void setAutoridadeRegistro(String autoridadeRegistro) {
        this.autoridadeRegistro = autoridadeRegistro;
    }

    public String getEmailAutoridadeRegistro() {
        return emailAutoridadeRegistro;
    }

    public void setEmailAutoridadeRegistro(String emailAutoridadeRegistro) {
        this.emailAutoridadeRegistro = emailAutoridadeRegistro;
    }

    public String getTelefoneAutoridadeRegistro() {
        return telefoneAutoridadeRegistro;
    }

    public void setTelefoneAutoridadeRegistro(String telefoneAutoridadeRegistro) {
        this.telefoneAutoridadeRegistro = telefoneAutoridadeRegistro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ContratoFornecedor> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoFornecedor> contratos) {
        this.contratos = contratos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
