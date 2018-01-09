/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.ArquivoRelatorioDeVisita;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.util.Utils;
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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class RelatorioDeVisita implements Serializable {

    @Id
    @SequenceGenerator(name = "RelatorioDeVisita", sequenceName = "seq_relatorioDeVisita")
    @GeneratedValue(generator = "RelatorioDeVisita")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @NotNull
    private Integer numero = 1;

    @NotNull
    private Integer ano = new Integer(Utils.convertDateToString(new Date(), 11));

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Orgao orgao;

    @Size(max = 255)
    @NotBlank
    private String solicitadoPor;

    @Size(max = 255)
    @NotBlank
    private String contato;

    @Size(max = 255)
    private String telefone;

    @Size(max = 255)
    @Email
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dataInicioVisita;

    @Temporal(TemporalType.TIME)
    private Date horaInicioVisita;

    @Temporal(TemporalType.DATE)
    private Date dataConclusaoVisita;

    @Temporal(TemporalType.TIME)
    private Date horaConclusaoVisita;

    @Column(columnDefinition = "Text")
    private String resumo;

    @Column(columnDefinition = "Text")
    private String solicitacao;

    @Column(columnDefinition = "Text")
    private String constatacaoTecnica;

    @Column(columnDefinition = "Text")
    private String observacaoCliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao = new Date();
    
    @NotAudited
    @OneToMany(mappedBy = "relatorioDeVisita")
    private List<ArquivoRelatorioDeVisita> arquivos;

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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public String getSolicitadoPor() {
        return solicitadoPor;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setSolicitadoPor(String solicitadoPor) {
        this.solicitadoPor = solicitadoPor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public Date getDataInicioVisita() {
        return dataInicioVisita;
    }

    public void setDataInicioVisita(Date dataInicioVisita) {
        this.dataInicioVisita = dataInicioVisita;
    }

    public Date getHoraInicioVisita() {
        return horaInicioVisita;
    }

    public void setHoraInicioVisita(Date horaInicioVisita) {
        this.horaInicioVisita = horaInicioVisita;
    }

    public Date getDataConclusaoVisita() {
        return dataConclusaoVisita;
    }

    public void setDataConclusaoVisita(Date dataConclusaoVisita) {
        this.dataConclusaoVisita = dataConclusaoVisita;
    }

    public Date getHoraConclusaoVisita() {
        return horaConclusaoVisita;
    }

    public void setHoraConclusaoVisita(Date horaConclusaoVisita) {
        this.horaConclusaoVisita = horaConclusaoVisita;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    public String getConstatacaoTecnica() {
        return constatacaoTecnica;
    }

    public void setConstatacaoTecnica(String constatacaoTecnica) {
        this.constatacaoTecnica = constatacaoTecnica;
    }

    public String getObservacaoCliente() {
        return observacaoCliente;
    }

    public void setObservacaoCliente(String observacaoCliente) {
        this.observacaoCliente = observacaoCliente;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<ArquivoRelatorioDeVisita> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoRelatorioDeVisita> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final RelatorioDeVisita other = (RelatorioDeVisita) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
