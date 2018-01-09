/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeViagem;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class RelatorioDeViagem implements Serializable {

    @Id
    @SequenceGenerator(name = "RelatorioDeViagem", sequenceName = "seq_relatorioDeViagem")
    @GeneratedValue(generator = "RelatorioDeViagem")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @Size(max = 255)
    @NotBlank
    private String nome;

    @Size(max = 255)
    @NotBlank
    private String lotacao;

    @Size(max = 255)
    @NotBlank
    private String cargoOuFuncao;

    @Size(max = 255)
    @NotBlank
    private String cpf;

    @Size(max = 255)
    private String matricula;

    @Size(max = 255)
    @NotBlank
    private String trajeto;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataChegada;

    private Integer duracaoAfastamento;

    @Size(max = 255)
    private String modalidadeDoTransporte;

    @Column(columnDefinition = "Text")
    private String relatoViagem;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao = new Date();

    @NotAudited
    @OneToMany(mappedBy = "relatorioDeViagem")
    private List<AtividadeRelatorioViagem> atividadesRelatoriosViagens;

    @NotAudited
    @OneToMany(mappedBy = "relatorioDeViagem")
    private List<ArquivoRelatorioDeViagem> rrquivosRelatorioDeViagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRelatoViagem() {
        return relatoViagem;
    }

    public void setRelatoViagem(String relatoViagem) {
        this.relatoViagem = relatoViagem;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getCargoOuFuncao() {
        return cargoOuFuncao;
    }

    public void setCargoOuFuncao(String cargoOuFuncao) {
        this.cargoOuFuncao = cargoOuFuncao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(String trajeto) {
        this.trajeto = trajeto;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Integer getDuracaoAfastamento() {
        return duracaoAfastamento;
    }

    public void setDuracaoAfastamento(Integer duracaoAfastamento) {
        this.duracaoAfastamento = duracaoAfastamento;
    }

    public String getModalidadeDoTransporte() {
        return modalidadeDoTransporte;
    }

    public void setModalidadeDoTransporte(String modalidadeDoTransporte) {
        this.modalidadeDoTransporte = modalidadeDoTransporte;
    }

    public List<AtividadeRelatorioViagem> getAtividadesRelatoriosViagens() {
        return atividadesRelatoriosViagens;
    }

    public void setAtividadesRelatoriosViagens(List<AtividadeRelatorioViagem> atividadesRelatoriosViagens) {
        this.atividadesRelatoriosViagens = atividadesRelatoriosViagens;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public List<ArquivoRelatorioDeViagem> getRrquivosRelatorioDeViagem() {
        return rrquivosRelatorioDeViagem;
    }

    public void setRrquivosRelatorioDeViagem(List<ArquivoRelatorioDeViagem> rrquivosRelatorioDeViagem) {
        this.rrquivosRelatorioDeViagem = rrquivosRelatorioDeViagem;
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
        final RelatorioDeViagem other = (RelatorioDeViagem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
