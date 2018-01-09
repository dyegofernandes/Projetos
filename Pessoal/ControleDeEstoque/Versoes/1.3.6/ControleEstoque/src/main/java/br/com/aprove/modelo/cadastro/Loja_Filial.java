/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro;

import br.com.aprove.modelo.cadastro.enums.TipoEndereco;
import br.com.aprove.modelo.cadastro.enums.TipoLoja;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.modelo.faturamento.Estoque;
import br.com.aprove.modelo.faturamento.NotaFiscal;
import br.com.aprove.modelo.faturamento.Pedido;
import br.com.aprove.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class Loja_Filial implements Serializable {

    @Id
    @SequenceGenerator(name = "Loja_Filial", allocationSize = 1, sequenceName = "seq_loja_Filial")
    @GeneratedValue(generator = "Loja_Filial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial matriz;

    @NotNull
    private TipoLoja tipo = TipoLoja.LOJA;

    @Size(max = 200)
    @NotBlank
    private String razaoSocial;

    @Size(max = 200)
    private String nomeFantasia;

    @Size(max = 20)
    @NotBlank
    private String cnpj;

    @Size(max = 20)
    private String inscricaoEstatual;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituacaoTributaria situacaoTributaria; //empresa

    // Tab Enderecos
    @NotBlank
    @Size(max = 200)
    private String endereco;

    @Size(max = 50)
    private String numero;

    @Size(max = 50)
    private String bairro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidadeEndereco;

    @Size(max = 14)
    private String cep;

    @Size(max = 100)
    private String complemento;

    private TipoEndereco tipoEndereco;

    // tab Telefones/Enderecos digitais
    @Size(max = 20)
    private String telefone;

    @Size(max = 20)
    private String fax;

    @Size(max = 20)
    private String celula1;

    @Size(max = 20)
    private String celular2;

    @Size(max = 20)
    private String whatsapp;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 100)
    private String facebook;

    private boolean ativo = true;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "loja")
    private List<Pedido> pedido;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "empresa")
    private List<Estoque> estoques;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "empresa")
    private List<Produto> produtos;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "empresa")
    private List<Fornecedor> forncedores;

    @NotAudited
    @OrderBy("conta")
    @OneToMany(mappedBy = "loja")
    private List<ContaBancaria> conta;

    @NotAudited
    @OrderBy("loja")
    @OneToMany(mappedBy = "loja")
    private List<NotaFiscal> nota;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "matriz")
    private List<Loja_Filial> lojas;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "matriz")
    private List<Usuario> usuariosMatriz;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "filial")
    private List<Usuario> usuariosFilial;

    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "empresa")
    private List<Cliente> clientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoLoja getTipo() {
        return tipo;
    }

    public void setTipo(TipoLoja tipo) {
        this.tipo = tipo;
    }

    public Loja_Filial getMatriz() {
        return matriz;
    }

    public void setMatriz(Loja_Filial matriz) {
        this.matriz = matriz;
    }

    public List<Loja_Filial> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja_Filial> lojas) {
        this.lojas = lojas;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<ContaBancaria> getConta() {
        return conta;
    }

    public void setConta(List<ContaBancaria> conta) {
        this.conta = conta;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstatual() {
        return inscricaoEstatual;
    }

    public void setInscricaoEstatual(String inscricaoEstatual) {
        this.inscricaoEstatual = inscricaoEstatual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(Cidade cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCelula1() {
        return celula1;
    }

    public void setCelula1(String celula1) {
        this.celula1 = celula1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    public List<NotaFiscal> getNota() {
        return nota;
    }

    public void setNota(List<NotaFiscal> nota) {
        this.nota = nota;
    }

    public List<Usuario> getUsuariosMatriz() {
        return usuariosMatriz;
    }

    public void setUsuariosMatriz(List<Usuario> usuariosMatriz) {
        this.usuariosMatriz = usuariosMatriz;
    }

    public List<Usuario> getUsuariosFilial() {
        return usuariosFilial;
    }

    public void setUsuariosFilial(List<Usuario> usuariosFilial) {
        this.usuariosFilial = usuariosFilial;
    }

    public List<Fornecedor> getForncedores() {
        return forncedores;
    }

    public void setForncedores(List<Fornecedor> forncedores) {
        this.forncedores = forncedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public SituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(SituacaoTributaria situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public Loja_Filial() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Loja_Filial other = (Loja_Filial) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Utils util = new Utils();
        return util.format("##.###.###/####-##", cnpj).concat(" - ").concat(razaoSocial);
    }

}
