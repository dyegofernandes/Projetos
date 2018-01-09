/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import br.gov.pi.siste.modelo.cadastro.enums.EstadoCivil;
import br.gov.pi.siste.modelo.cadastro.enums.Sexo;
import br.gov.pi.siste.modelo.financeiro.Movimento;

/**
 *
 * @author Juniel
 */
@Entity //Trabalhador
public class Servidor implements Serializable {

    @Id
    @SequenceGenerator(name = "Servidor", sequenceName = "seq_servidor")
    @GeneratedValue(generator = "Servidor")
    private Long id;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @Size(max = 60)
    @NotBlank
    private String cpf;
    
    @Size(max = 120)
    private String passaporte;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private Rg rg = new Rg();
    
    @Size(max = 60)
    private String numInscPrefeitura;

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
    private String nacionalidade = "Brasil";

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade naturalidade;

    @NotNull
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private TituloEleitoral titulo = new TituloEleitoral();

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private CarteiraTrabalho carteiraDeTrabalho = new CarteiraTrabalho();

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    @Size(max = 60)
    private String numeroDoConselho;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private DadosFuncionais dadosFuncionais = new DadosFuncionais();

    private boolean ativo = true;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "servidor")
    private List<Movimento> movimentos;

    @Override
    public String toString() {
        return nome.concat(" ").concat(format("###.###.###-##", cpf));
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

    public String getNumInscPrefeitura() {
        return numInscPrefeitura;
    }

    public void setNumInscPrefeitura(String numInscPrefeitura) {
        this.numInscPrefeitura = numInscPrefeitura;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
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

    public String getNumeroDoConselho() {
        return numeroDoConselho;
    }

    public void setNumeroDoConselho(String numeroDoConselho) {
        this.numeroDoConselho = numeroDoConselho;
    }

    public DadosFuncionais getDadosFuncionais() {
        return dadosFuncionais;
    }

    public void setDadosFuncionais(DadosFuncionais dadosFuncionais) {
        this.dadosFuncionais = dadosFuncionais;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
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
        final Servidor other = (Servidor) obj;
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
}
