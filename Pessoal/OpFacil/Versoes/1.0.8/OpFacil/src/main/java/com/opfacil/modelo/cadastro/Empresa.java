/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.cadastro;

import com.opfacil.modelo.documentos.DownloadArquivos;
import com.opfacil.modelo.pagamento.Lote;
import com.opfacil.modelo.pagamento.Pagamento;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author Juniel
 */
@Entity
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 45)
    @NotBlank
    private String nomeFantasia;

    @Size(max = 80)
    @NotBlank
    private String razaosocial;

    @Size(max = 18)
    @NotBlank
    private String cnpj;

    @Size(max = 100)
    @NotBlank
    private String endereco;

    @Size(max = 10)
    @NotBlank
    private String nroLocal;

    @Size(max = 30)
    @NotBlank
    private String bairro;

    private String complemento;

    @Size(max = 20)
    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Uf uf;

    @NotNull
    private BigDecimal iss;

    @Size(max = 12)
    @NotBlank
    private String cep;

    @Size(max = 20)
    @NotBlank
    private String telefone;

    @Size(max = 20)
    private String celular;

    @Size(max = 20)
    private String fax;

    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    private BigDecimal valorTarifa;

    @Size(max = 50)
    @NotBlank
    private String natureza;

    @Size(max = 10)
    @NotBlank
    private String cdBanco;

    private boolean ativo = true;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios;

    @NotAudited
    @OrderBy("id")
    @OneToMany(mappedBy = "empresa")
    private List<Pagamento> pagamentos;

    @NotAudited
    @OrderBy("id")
    @OneToMany(mappedBy = "empresa")
    private List<Lote> lote;

    @NotAudited
    @OrderBy("id")
    @OneToMany(mappedBy = "empresa")
    private List<DownloadArquivos> arquivos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNroLocal() {
        return nroLocal;
    }

    public void setNroLocal(String nroLocal) {
        this.nroLocal = nroLocal;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(BigDecimal valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Lote> getLote() {
        return lote;
    }

    public void setLote(List<Lote> lote) {
        this.lote = lote;
    }

    public List<DownloadArquivos> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<DownloadArquivos> arquivos) {
        this.arquivos = arquivos;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(String cdBanco) {
        this.cdBanco = cdBanco;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
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
        final Empresa other = (Empresa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return format("##.###.###/####-##", cnpj).concat(" - ").concat(nomeFantasia);
    }

    private String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
