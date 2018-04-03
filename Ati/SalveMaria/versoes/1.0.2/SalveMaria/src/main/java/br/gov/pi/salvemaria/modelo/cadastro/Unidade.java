/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.cadastro;

import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
import br.gov.pi.salvemaria.modelo.enums.FaixaEtaria;
import br.gov.pi.salvemaria.modelo.enums.TipoUnidade;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

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

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    @NotBlank
    private String sigla;

    @NotNull
    private TipoUnidade tipo;

    private FaixaEtaria faixaEtariaVitima = FaixaEtaria.TODAS;

    private FaixaEtaria faixaEtariaAgressor = FaixaEtaria.TODAS;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Circunscricao circunscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private CircunscricaoBairro circunscricaoBairro;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @NotAudited
    @OneToMany(mappedBy = "unidade")
    private List<Denuncia> denuncias;

    @NotAudited
    @OneToMany(mappedBy = "unidade")
    private List<Usuario> usuarios;

    @NotAudited
    @OneToMany(mappedBy = "unidade")
    private List<Viatura> viaturas;

    @NotNull
    private Boolean visualizarDenunciaNormal = true;

    @NotNull
    private Boolean visualizarDenunciaPanico = true;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        this.nome = nome;
    }

    public TipoUnidade getTipo() {
        return tipo;
    }

    public void setTipo(TipoUnidade tipo) {
        this.tipo = tipo;
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

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Circunscricao getCircunscricao() {
        return circunscricao;
    }

    public void setCircunscricao(Circunscricao circunscricao) {
        this.circunscricao = circunscricao;
    }

    public CircunscricaoBairro getCircunscricaoBairro() {
        return circunscricaoBairro;
    }

    public void setCircunscricaoBairro(CircunscricaoBairro circunscricaoBairro) {
        this.circunscricaoBairro = circunscricaoBairro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Viatura> getViaturas() {
        return viaturas;
    }

    public void setViaturas(List<Viatura> viaturas) {
        this.viaturas = viaturas;
    }

    public FaixaEtaria getFaixaEtariaVitima() {
        return faixaEtariaVitima;
    }

    public void setFaixaEtariaVitima(FaixaEtaria faixaEtariaVitima) {
        this.faixaEtariaVitima = faixaEtariaVitima;
    }

    public FaixaEtaria getFaixaEtariaAgressor() {
        return faixaEtariaAgressor;
    }

    public void setFaixaEtariaAgressor(FaixaEtaria faixaEtariaAgressor) {
        this.faixaEtariaAgressor = faixaEtariaAgressor;
    }

    public Boolean getVisualizarDenunciaNormal() {
        return visualizarDenunciaNormal;
    }

    public void setVisualizarDenunciaNormal(Boolean visualizarDenunciaNormal) {
        this.visualizarDenunciaNormal = visualizarDenunciaNormal;
    }

    public Boolean getVisualizarDenunciaPanico() {
        return visualizarDenunciaPanico;
    }

    public void setVisualizarDenunciaPanico(Boolean visualizarDenunciaPanico) {
        this.visualizarDenunciaPanico = visualizarDenunciaPanico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
