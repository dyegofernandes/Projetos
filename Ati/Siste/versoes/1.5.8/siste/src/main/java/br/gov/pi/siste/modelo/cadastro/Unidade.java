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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import br.gov.pi.siste.modelo.controleacesso.UsuarioUnidade;

/**
 *
 * @author Juniel
 */
@Entity
public class Unidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Unidade", sequenceName = "seq_unidade")
    @GeneratedValue(generator = "Unidade")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;

    @NotNull
    private Integer codigo;

    @Size(max = 60)
    @NotBlank
    private String cnpj;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @Size(max = 20)
    @NotBlank
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
    @NotBlank
    @Email
    private String emailContato;

    @Size(max = 260)
    private String emailContato2;

    @NotNull
    private BigDecimal valorLimite;

    private Integer fechamentoInicial = new Integer(1);

    private Integer fechamentoFinal = new Integer(5);

    @Size(max = 3)
    private String codigoRecolhimento;

    @Size(max = 7)
    private String codigoCNAE;

    private BigDecimal aliquotaRAT;

    @Size(max = 3)
    private String codigoFPAS;

    @Size(max = 4)
    private String outraEntidade;

    @Size(max = 4)
    private String pagamentoGPS;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "unidade")
    private List<DadosFuncionais> dadosFuncionais;

    @NotAudited
    @OneToMany(mappedBy = "unidade")
    private List<UsuarioUnidade> usuarioUnidade;

    @NotAudited
    @OneToMany(mappedBy = "unidade")
    private List<Usuario> usuarios;

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
        if (nomeContato != null) {
            nomeContato = nomeContato.trim().toUpperCase();
        }
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

    public List<DadosFuncionais> getDadosFuncionais() {
        return dadosFuncionais;
    }

    public void setDadosFuncionais(List<DadosFuncionais> dadosFuncionais) {
        this.dadosFuncionais = dadosFuncionais;
    }

    public List<UsuarioUnidade> getUsuarioUnidade() {
        return usuarioUnidade;
    }

    public void setUsuarioUnidade(List<UsuarioUnidade> usuarioUnidade) {
        this.usuarioUnidade = usuarioUnidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    public Integer getFechamentoInicial() {
        return fechamentoInicial;
    }

    public void setFechamentoInicial(Integer fechamentoInicial) {
        this.fechamentoInicial = fechamentoInicial;
    }

    public Integer getFechamentoFinal() {
        return fechamentoFinal;
    }

    public void setFechamentoFinal(Integer fechamentoFinal) {
        this.fechamentoFinal = fechamentoFinal;
    }

    public String getTelefoneContato2() {
        return telefoneContato2;
    }

    public void setTelefoneContato2(String telefoneContato2) {
        this.telefoneContato2 = telefoneContato2;
    }

    public String getEmailContato2() {
        return emailContato2;
    }

    public void setEmailContato2(String emailContato2) {
        this.emailContato2 = emailContato2;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla != null) {
            sigla = sigla.trim().toUpperCase();
        }

        this.sigla = sigla;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Unidade other = (Unidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
