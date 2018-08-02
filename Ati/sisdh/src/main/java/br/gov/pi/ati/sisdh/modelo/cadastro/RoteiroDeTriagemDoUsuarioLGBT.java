/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;


import br.gov.pi.ati.sisdh.modelo.cadastro.enums.ComQuemMora;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.EstadoCivil;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Etnia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.IdentidadeGenero;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.OrientacaoSexual;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Religiao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.RendaFamiliar;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.ResideEm;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Sexo;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TipoMoradia;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.TodosDocumento;
import br.gov.pi.ati.sisdh.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel Alves da Silva
 */
@Entity
public class RoteiroDeTriagemDoUsuarioLGBT implements Serializable {

    @Id
    @SequenceGenerator(name = "RoteiroDeTriagemDoUsuarioLGBT", sequenceName = "seq_roteiroDeTriagemDoUsuarioLGBT")
    @GeneratedValue(generator = "RoteiroDeTriagemDoUsuarioLGBT")
    private Long id;

    @NotNull
    private Integer codigo = 1;

    @NotNull
    private Integer ano = Utils.getAnoAtual();

    @Temporal(TemporalType.DATE)
    private Date dataEmissao = new Date();

    @Size(max = 120)
    @NotBlank
    private String nome;

    @Size(max = 120)
    @NotBlank
    private String nomeSocial;

    @Size(max = 50)
//    @NotBlank Solicitado pela SASC no dia 29-11-17
    private String rg;

    @Size(max = 20)
//   @NotBlank Solicitado pela SASC no dia 29-11-17

    private String cpf;

    @Size(max = 250)
    private String filiacao;

    private Sexo sexo;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataNascimento;

    private String naturalidade;

    private EstadoCivil estadoCivil;

    private String escolaridade;

    private String profissao;

    private String endereco;

    private String bairro;

    private String cidade;

    private String cep;

    private String telefone;

    private String telefone2;

    private String email;

    @NotNull
    private TodosDocumento todosDocumentos = TodosDocumento.NAO;

    private OrientacaoSexual orientacaoSexual;

    private IdentidadeGenero identidadeGenero;

    private ComQuemMora comQuemMora;

    private String grupoFamiliar;

    private ResideEm resideEm;

    private TipoMoradia tipoMoradia;

    private RendaFamiliar rendaFamiliar;

    private Etnia etnia;

    private Religiao religiao;

    @Column(columnDefinition = "Text")
    private String observacao;

    @Column(columnDefinition = "Text")
    private String encaminhado;

    @Column(columnDefinition = "Text")
    private String atementoAnterior;

    @Column(columnDefinition = "Text")
    private String motivoConsulta;

    @Column(columnDefinition = "Text")
    private String expectativasAtendimento;

    @Column(columnDefinition = "Text")
    private String evolucao;

    private Integer registroSocialNum;

    private Integer registroSocialAno;

    @ManyToMany(targetEntity = AcolhimentoTriagemLgbt.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<AcolhimentoTriagemLgbt> acolhimentos = new ArrayList<AcolhimentoTriagemLgbt>();

    @ManyToMany(targetEntity = ArquivoLGBT.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ArquivoLGBT> arquivos = new ArrayList<ArquivoLGBT>();

    @Temporal(TemporalType.DATE)
    private Date dataEncaminhamento;

    @Column(columnDefinition = "Text")
    private String observacaoEncaminhamento;

    @ManyToMany(targetEntity = AgendamentoTriagem.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<AgendamentoTriagem> agendamentos = new ArrayList<AgendamentoTriagem>();

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

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
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

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TodosDocumento getTodosDocumentos() {
        return todosDocumentos;
    }

    public void setTodosDocumentos(TodosDocumento todosDocumentos) {
        this.todosDocumentos = todosDocumentos;
    }

    public OrientacaoSexual getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(OrientacaoSexual orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public IdentidadeGenero getIdentidadeGenero() {
        return identidadeGenero;
    }

    public void setIdentidadeGenero(IdentidadeGenero identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public ComQuemMora getComQuemMora() {
        return comQuemMora;
    }

    public void setComQuemMora(ComQuemMora comQuemMora) {
        this.comQuemMora = comQuemMora;
    }

    public String getGrupoFamiliar() {
        return grupoFamiliar;
    }

    public void setGrupoFamiliar(String grupoFamiliar) {
        this.grupoFamiliar = grupoFamiliar;
    }

    public ResideEm getResideEm() {
        return resideEm;
    }

    public void setResideEm(ResideEm resideEm) {
        this.resideEm = resideEm;
    }

    public TipoMoradia getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(TipoMoradia tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }

    public RendaFamiliar getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(RendaFamiliar rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public Etnia getEtnia() {
        return etnia;
    }

    public void setEtnia(Etnia etnia) {
        this.etnia = etnia;
    }

    public Religiao getReligiao() {
        return religiao;
    }

    public void setReligiao(Religiao religiao) {
        this.religiao = religiao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEncaminhado() {
        return encaminhado;
    }

    public void setEncaminhado(String encaminhado) {
        this.encaminhado = encaminhado;
    }

    public String getAtementoAnterior() {
        return atementoAnterior;
    }

    public void setAtementoAnterior(String atementoAnterior) {
        this.atementoAnterior = atementoAnterior;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getExpectativasAtendimento() {
        return expectativasAtendimento;
    }

    public void setExpectativasAtendimento(String expectativasAtendimento) {
        this.expectativasAtendimento = expectativasAtendimento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public Integer getRegistroSocialNum() {
        return registroSocialNum;
    }

    public void setRegistroSocialNum(Integer registroSocialNum) {
        this.registroSocialNum = registroSocialNum;
    }

    public Integer getRegistroSocialAno() {
        return registroSocialAno;
    }

    public void setRegistroSocialAno(Integer registroSocialAno) {
        this.registroSocialAno = registroSocialAno;
    }

    public List<AcolhimentoTriagemLgbt> getAcolhimentos() {
        return acolhimentos;
    }

    public void setAcolhimentos(List<AcolhimentoTriagemLgbt> acolhimentos) {
        this.acolhimentos = acolhimentos;
    }

    public Date getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    public void setDataEncaminhamento(Date dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    public String getObservacaoEncaminhamento() {
        return observacaoEncaminhamento;
    }

    public void setObservacaoEncaminhamento(String observacaoEncaminhamento) {
        this.observacaoEncaminhamento = observacaoEncaminhamento;
    }

    public List<AgendamentoTriagem> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoTriagem> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<ArquivoLGBT> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoLGBT> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final RoteiroDeTriagemDoUsuarioLGBT other = (RoteiroDeTriagemDoUsuarioLGBT) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
