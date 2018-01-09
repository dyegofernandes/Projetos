/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.cadastro;

import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.venda.Credito;
import com.ebol.modelo.venda.Debito;
import com.ebol.modelo.venda.Item;
import com.ebol.modelo.venda.Venda;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(schema = "cadastro")
public class Convenio implements Serializable {

    @Id
    @SequenceGenerator(schema = "cadastro", allocationSize = 1, name = "Convenio", sequenceName = "convenio_id_seq")
    @GeneratedValue(generator = "Convenio")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Banco banco;

    @Size(max = 14)
    @NotBlank
    private String cpfCnpj;

    @Size(max = 100)
    @NotBlank
    private String razaoSocial;

    @Size(max = 100)
    @NotBlank
    private String fantasia;

    @Size(max = 30)
    @NotBlank
    private String nomePos;

    @Size(max = 15)
    @NotBlank
    private String incest = "Isento";

    @Size(max = 100)
    private String endereco;

    @Size(max = 100)
    private String bairro;

    @Size(max = 30)
    private String cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade cidade;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 100)
    private String fones;

    @Size(max = 20)
    private String ipCadastro;
    
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Padrao_Cobranca padrao = new Padrao_Cobranca();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date cadastro = new Date();

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Socio> socios;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Contato> contatos;
   
    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<PessoaOp> pessoas;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Cliente> clientes;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Venda> vendas;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Item> itens;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Boleto> boleto;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Credito> credito;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Debito> Debitos;

    @NotAudited
    @OneToMany(mappedBy = "convenio")
    private List<Usuario> usuarios;

    @Override
    public String toString() {
        return (cpfCnpj.length() > 11 ? format("##.###.###/####-##", cpfCnpj) : format("###.###.###-##", cpfCnpj))
                .concat(" - ").concat(razaoSocial);
    }

    public String formtCpfOrCnpj(String x) {
        return (cpfCnpj.length() > 11 ? format("##.###.###/####-##", cpfCnpj) : format("###.###.###-##", cpfCnpj));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Convenio other = (Convenio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
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

    public Padrao_Cobranca getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao_Cobranca padrao) {
        this.padrao = padrao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getNomePos() {
        return nomePos;
    }

    public void setNomePos(String nomePos) {
        this.nomePos = nomePos;
    }

    public String getIncest() {
        return incest;
    }

    public void setIncest(String incest) {
        this.incest = incest;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFones() {
        return fones;
    }

    public void setFones(String fones) {
        this.fones = fones;
    }

    public String getIpCadastro() {
        return ipCadastro;
    }

    public void setIpCadastro(String ipCadastro) {
        this.ipCadastro = ipCadastro;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<PessoaOp> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaOp> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Boleto> getBoleto() {
        return boleto;
    }

    public void setBoleto(List<Boleto> boleto) {
        this.boleto = boleto;
    }

    public List<Credito> getCredito() {
        return credito;
    }

    public void setCredito(List<Credito> credito) {
        this.credito = credito;
    }

    public List<Debito> getDebitos() {
        return Debitos;
    }

    public void setDebitos(List<Debito> Debitos) {
        this.Debitos = Debitos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
