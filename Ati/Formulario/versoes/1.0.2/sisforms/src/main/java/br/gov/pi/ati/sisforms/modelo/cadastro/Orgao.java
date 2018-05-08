/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.cadastro;

import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import br.gov.pi.ati.sisforms.modelo.formulario.FormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.formulario.FormCriacaoEmail;
import br.gov.pi.ati.sisforms.modelo.formulario.Participante;
import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeVisita;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

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

    private String codigo;

    @Size(max = 50)
    private String cnpj;

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    @Size(max = 50)
    private String sigla;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgaoPai;

    @OrderBy(value = "nome")
    @OneToMany(mappedBy = "orgaoPai")
    private List<Orgao> orgaosFilhos = new ArrayList<Orgao>();

    /**
     * iniciar com valor padrao 0
     */
    private Integer ordenacao = 0;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<FormAcessoConteudo> formsAcessoConteudo;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<FormCriacaoEmail> formsCriacaoEmail;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<Participante> participantes;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<PendenciaIdentificada> pendencias;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<AtaDeReuniao> atas;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<RelatorioDeVisita> visitas;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<FormAcessoConteudo> getFormsAcessoConteudo() {
        return formsAcessoConteudo;
    }

    public void setFormsAcessoConteudo(List<FormAcessoConteudo> formsAcessoConteudo) {
        this.formsAcessoConteudo = formsAcessoConteudo;
    }

    public List<FormCriacaoEmail> getFormsCriacaoEmail() {
        return formsCriacaoEmail;
    }

    public void setFormsCriacaoEmail(List<FormCriacaoEmail> formsCriacaoEmail) {
        this.formsCriacaoEmail = formsCriacaoEmail;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<PendenciaIdentificada> getPendencias() {
        return pendencias;
    }

    public void setPendencias(List<PendenciaIdentificada> pendencias) {
        this.pendencias = pendencias;
    }

    public List<AtaDeReuniao> getAtas() {
        return atas;
    }

    public void setAtas(List<AtaDeReuniao> atas) {
        this.atas = atas;
    }

    public List<RelatorioDeVisita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<RelatorioDeVisita> visitas) {
        this.visitas = visitas;
    }

    public Orgao getOrgaoPai() {
        return orgaoPai;
    }

    public void setOrgaoPai(Orgao orgaoPai) {
        this.orgaoPai = orgaoPai;
    }

    public List<Orgao> getOrgaosFilhos() {
        return orgaosFilhos;
    }

    public void setOrgaosFilhos(List<Orgao> orgaosFilhos) {
        this.orgaosFilhos = orgaosFilhos;
    }

    public Integer getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(Integer ordenacao) {
        this.ordenacao = ordenacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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

    @Override
    public String toString() {
        return sigla.concat(" - ").concat("nome");
    }
}
