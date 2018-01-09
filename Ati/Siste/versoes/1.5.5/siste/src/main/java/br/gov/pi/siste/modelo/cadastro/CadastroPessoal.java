/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import br.gov.pi.siste.modelo.cadastro.enums.EstadoCivil;
import br.gov.pi.siste.modelo.cadastro.enums.Estrangeiro;
import br.gov.pi.siste.modelo.cadastro.enums.Sexo;

/**
 *
 * @author Juniel
 */
@Entity
public class CadastroPessoal implements Serializable {

    @Id
    @SequenceGenerator(name = "CadastroPessoal", sequenceName = "seq_cadastroPessoal")
    @GeneratedValue(generator = "CadastroPessoal")
    private Long id;
    
    @NotNull
    private Estrangeiro estrangeiro = Estrangeiro.NAO;

    @Size(max = 60)
    @NotBlank
    private String cpf;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Rg rg = new Rg();

    @Size(max = 260)
    private String pai;

    @Size(max = 260)
    @NotBlank
    private String mae;

    @NotNull
    private Sexo sexo;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataNascimento;

    @Size(max = 60)
    @NotBlank
    private String nacionalidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade naturalidade;
    
    @Size(max = 100)
    private String naturalidadeEstrangeira;

    @NotNull
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = CascadeType.ALL)
    private TituloEleitoral titulo = new TituloEleitoral();

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private CarteiraTrabalho carteiraDeTrabalho = new CarteiraTrabalho();

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @Size(max = 60)
    @NotBlank
    private String telefone1;

    @Size(max = 60)
    private String telefone2;

    @Size(max = 60)
    private String fax;

    @Size(max = 60)
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private GrauDeInstrucao grauDeInstrucao;

    @ManyToOne(fetch = FetchType.LAZY)
    private FormacaoProfissional formacaoProfissional;

    @Override
    public String toString() {
        return cpf.concat(" - ").concat(nome);
    }
    public CadastroPessoal(){
        
    }
    
    public CadastroPessoal(Servidor servidor){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        if (pai != null) {
            pai = pai.trim().toUpperCase();
        }
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        if (mae != null) {
            mae = mae.trim().toUpperCase();
        }
        this.mae = mae;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        if (nacionalidade != null) {
            nacionalidade = nacionalidade.trim().toUpperCase();
        }
        this.nacionalidade = nacionalidade;
    }

    public Cidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Cidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public TituloEleitoral getTitulo() {
        return titulo;
    }

    public void setTitulo(TituloEleitoral titulo) {
        this.titulo = titulo;
    }

    public CarteiraTrabalho getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraDeTrabalho(CarteiraTrabalho carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
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

    public GrauDeInstrucao getGrauDeInstrucao() {
        return grauDeInstrucao;
    }

    public void setGrauDeInstrucao(GrauDeInstrucao grauDeInstrucao) {
        this.grauDeInstrucao = grauDeInstrucao;
    }

    public FormacaoProfissional getFormacaoProfissional() {
        return formacaoProfissional;
    }

    public void setFormacaoProfissional(FormacaoProfissional formacaoProfissional) {
        this.formacaoProfissional = formacaoProfissional;
    }

    public Estrangeiro getEstrangeiro() {
        return estrangeiro;
    }

    public void setEstrangeiro(Estrangeiro estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    public String getNaturalidadeEstrangeira() {
        return naturalidadeEstrangeira;
    }

    public void setNaturalidadeEstrangeira(String naturalidadeEstrangeira) {
        this.naturalidadeEstrangeira = naturalidadeEstrangeira;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final CadastroPessoal other = (CadastroPessoal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
