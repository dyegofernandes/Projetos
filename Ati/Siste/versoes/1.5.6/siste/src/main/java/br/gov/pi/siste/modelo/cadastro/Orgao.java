/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import br.gov.pi.siste.modelo.controleacesso.Usuario;

/**
 *
 * @author Juniel
 */
@Entity
public class Orgao implements Serializable {

    @Id
    @SequenceGenerator(name = "Orgao", sequenceName = "seq_orgao")
    @GeneratedValue(generator = "Orgao")
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String cnpj;

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    @Size(max = 50)
    private String sigla;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @Size(max = 260)
    @NotBlank
    private String nomeContato;

    @Size(max = 260)
    @NotBlank
    private String telefoneContato;

    @Size(max = 260)
    private String telefoneContato2;

    @Size(max = 260)
    @Email
    @NotBlank
    private String emailContato;

    @Size(max = 260)
    private String emailContato2;

    @Size(max = 3)
    @NotBlank
    private String codigoRecolhimento;

    @Size(max = 7)
    @NotBlank
    private String codigoCNAE;

    @NotNull
    private BigDecimal aliquotaRAT;

    @Size(max = 3)
    @NotBlank
    private String codigoFPAS;

    @Size(max = 4)
    @NotBlank
    private String outraEntidade;

    @Size(max = 4)
    @NotBlank
    private String pagamentoGPS;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "orgao")
    private List<Unidade> unidades;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<Usuario> usuarios;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "orgao")
    private List<Cargo> cargos;

    @Override
    public String toString() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla != null) {
            sigla = sigla.trim().toUpperCase();
        }
        this.sigla = sigla;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getEmailContato2() {
        return emailContato2;
    }

    public void setEmailContato2(String emailContato2) {
        this.emailContato2 = emailContato2;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public String getTelefoneContato2() {
        return telefoneContato2;
    }

    public void setTelefoneContato2(String telefoneContato2) {
        this.telefoneContato2 = telefoneContato2;
    }

    public String getCodigoRecolhimento() {
        return codigoRecolhimento;
    }

    public void setCodigoRecolhimento(String codigoRecolhimento) {
        this.codigoRecolhimento = codigoRecolhimento;
    }

    public String getCodigoCNAE() {
        return codigoCNAE;
    }

    public void setCodigoCNAE(String codigoCNAE) {
        this.codigoCNAE = codigoCNAE;
    }

    public BigDecimal getAliquotaRAT() {
        return aliquotaRAT;
    }

    public void setAliquotaRAT(BigDecimal aliquotaRAT) {
        this.aliquotaRAT = aliquotaRAT;
    }

    public String getCodigoFPAS() {
        return codigoFPAS;
    }

    public void setCodigoFPAS(String codigoFPAS) {
        this.codigoFPAS = codigoFPAS;
    }

    public String getOutraEntidade() {
        return outraEntidade;
    }

    public void setOutraEntidade(String outraEntidade) {
        this.outraEntidade = outraEntidade;
    }

    public String getPagamentoGPS() {
        return pagamentoGPS;
    }

    public void setPagamentoGPS(String pagamentoGPS) {
        this.pagamentoGPS = pagamentoGPS;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Orgao other = (Orgao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
